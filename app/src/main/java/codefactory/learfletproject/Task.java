package codefactory.learfletproject;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by pc-07 on 2018-01-04.
 */

public class Task extends AsyncTask<String, Void, String> {
    public static String ip = "knjas.or.kr"; //자신의 IP번호
    public static String sendMsg="", receiveMsg;
    String serverip = "http://192.168.0.6:8083/Learflet/CouponCon"; // 연결할 jsp주소
    private EditText tx;


    Task(String sendmsg, EditText edt_id) {
        this.sendMsg = sendmsg;
        tx = edt_id;
    }
    Task(){};

    public Task(EditText edt_id) {
        tx = edt_id;
    }

    @Override
    protected String doInBackground(String... strings) {
        try {

            serverip+=strings[0];
            Log.v("hhd", "hello2");
            //String rst = new Task(sendmsg).execute(result,"vision_write").get();
            String str;
            URL url = new URL(serverip);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestMethod("POST");
            OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());

            Log.v("hhd", "hello3");
            if (sendMsg.equals("vision_write")) {
                sendMsg = "vision_write=" + strings[0] + "&type=" + strings[1];
            } else if (sendMsg.equals("vision_list")) {
                sendMsg = "&type=" + strings[0];
            }

            osw.write(sendMsg);
            osw.flush();
            Log.v("hhd", "hello4");
            if (conn.getResponseCode() == conn.HTTP_OK) {
                InputStreamReader tmp = new InputStreamReader(conn.getInputStream(), "UTF-8");
                BufferedReader reader = new BufferedReader(tmp);
                StringBuffer buffer = new StringBuffer();
                while ((str = reader.readLine()) != null) {
                    buffer.append(str);
                }
                receiveMsg = buffer.toString();


                Log.v("response",receiveMsg);
            } else {
                Log.i("통신 결과", conn.getResponseCode() + "에러");
            }
            Log.v("hhd", "hello5");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return receiveMsg;
    }

    @Override
    protected void onPostExecute(String s) {
        //tx.setText(s);//받아온 값 editText에 넣기
    }
}
