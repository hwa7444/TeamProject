package codefactory.learfletproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class screen_info extends AppCompatActivity {

    TextView txt_notice = null;
    TextView txt_logout = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_info);

        txt_notice = (TextView)findViewById(R.id.txt_notice);

       txt_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(screen_info.this, Notice.class);
                startActivity(it);
            }
        });

        txt_logout = (TextView)findViewById(R.id.txt_logout);

        txt_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(screen_info.this, LoginActivity.class);
                startActivity(it);
            }
        });





       /* imgbtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(mainscreen.this, mainscreen.class);
                startActivity(it);
            }
        });*/


    }
}