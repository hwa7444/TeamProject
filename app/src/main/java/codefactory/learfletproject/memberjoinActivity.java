package codefactory.learfletproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.net.URLEncoder;

public class memberjoinActivity extends AppCompatActivity {
    TextView joinButton = null;
    ImageButton imgbtn_back = null;
    EditText EtId = null;
    EditText EtPw = null;
    EditText EtAge = null;
    RadioGroup radioGroup = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memberjoin);

        EtId = (EditText) findViewById(R.id.edt_id);
        EtPw = (EditText) findViewById(R.id.edt_pw);
        EtAge = (EditText) findViewById(R.id.edt_age);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);

        joinButton = (TextView) findViewById(R.id.btn_join);
        imgbtn_back = (ImageButton) findViewById(R.id.imgbtn_back);
        Spinner spinner = (Spinner) findViewById(R.id.spn_interest1);
        Spinner spinner1 = (Spinner) findViewById(R.id.spn_interest2);
        Spinner spinner2 = (Spinner) findViewById(R.id.spn_interest3);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.number, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this, R.array.number2, android.R.layout.simple_spinner_item);
        spinner1.setAdapter(adapter2);

        ArrayAdapter adapter3 = ArrayAdapter.createFromResource(this, R.array.number3, android.R.layout.simple_spinner_item);
        spinner2.setAdapter(adapter3);


        joinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //db에 저장 해야됨!
                String id = EtId.getText().toString();
                String pw = EtPw.getText().toString();
                String age = EtAge.getText().toString();
                String interest1 = spinner.getSelectedItem().toString();
                String interest2 = spinner1.getSelectedItem().toString();
                String interest3 = spinner2.getSelectedItem().toString();
                int genderId = radioGroup.getCheckedRadioButtonId();

                RadioButton rb = (RadioButton) findViewById(genderId);
                String gender = rb.getText().toString();

                Log.v("값", id + "" + pw + age + interest1 + interest2 + interest3 + gender);
                /*DB에 회원정보 저장 코드
                *
                *
                *
                *
                *
                * */

                //서버로 값 넘기기
                String sendmsg = "join";
                try {
                        id = URLEncoder.encode(id,"utf-8");
                        interest1 = URLEncoder.encode(interest1,"utf-8");
                        interest2 = URLEncoder.encode(interest2,"utf-8");
                        interest3 = URLEncoder.encode(interest3,"utf-8");
                        gender = URLEncoder.encode(gender,"utf-8");

                    //Task task = new Task();
                    //task.execute("?log=join&id="+id+"&age="+age+"&gender="+gender+"&interest1="+interest1+"&interest2="+interest2+"&interest3="+interest3);
                    new Task(sendmsg).execute("join",id,age,gender,interest1,interest2,interest3);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Intent it = new Intent(memberjoinActivity.this, LoginActivity.class);
                startActivity(it);
                finish();
            }
        });


        imgbtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(memberjoinActivity.this, LoginActivity.class);
                startActivity(it);
                finish();


            }
        });

    }
}
