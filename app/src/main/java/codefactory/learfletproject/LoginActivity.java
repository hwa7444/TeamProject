package codefactory.learfletproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    EditText edt_id = null;
    EditText edt_pw = null;
    Button btn_join = null;
    ImageButton imgbtn_login = null;
    SharedPreferences spf = null;
    private Spinner spinner1 = null;
    private Spinner spinner2 = null;
    private Spinner spinner3 = null;

    private ArrayAdapter<String> adapter;
    SpinnerAdapter spinnerAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        edt_id = (EditText) findViewById(R.id.edt_id);
        edt_pw = (EditText) findViewById(R.id.edt_pw);
        btn_join = (Button) findViewById(R.id.btn_join);
        imgbtn_login = (ImageButton) findViewById(R.id.imgbtn_login);


        btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(it);
                finish();
            }
        });

        imgbtn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //id 확인 후 로그인
                String userId = edt_id.getText().toString();
                String userPw = edt_pw.getText().toString();
                String fireBasePw = "1234"; // fir  eBase에서 비번 가져오기
                if (userPw.equals(fireBasePw)) {
                    spf = getSharedPreferences("id", MODE_PRIVATE);
                    spf.edit().putString("id", userId + "").commit();
                    Toast.makeText(getApplicationContext(), "로그인 성공. ", Toast.LENGTH_LONG).show();
                    Intent it = new Intent(LoginActivity.this, mainscreen.class);
                    startActivity(it);
                    finish();

                } else {
                    Toast.makeText(getApplicationContext(), "아이디, 비밀번호가 일치하지 않습니다. ", Toast.LENGTH_LONG).show();

                }


            }
        });


    }
}