package codefactory.learfletproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class LoginActivity extends AppCompatActivity {
    EditText edt_id = null;
    EditText edt_pw = null;
    ImageButton imgbtn_join = null;
    ImageButton imgbtn_login = null;
    SharedPreferences spf = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edt_id = (EditText)findViewById(R.id.edt_id);
        edt_pw = (EditText)findViewById(R.id.edt_pw);
        imgbtn_join = (ImageButton)findViewById(R.id.imgbtn_join);
        imgbtn_login = (ImageButton)findViewById(R.id.imgbtn_login);



        imgbtn_join.setOnClickListener(new View.OnClickListener() {
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
                //id - firebase에서 받아와야 함.
                String id = "beng";
                spf = getSharedPreferences("id", MODE_PRIVATE);
                spf.edit().putString("id", id + "").commit();


                Intent it = new Intent(LoginActivity.this, mainscreen.class);


                startActivity(it);




                finish();
            }
        });


    }
}