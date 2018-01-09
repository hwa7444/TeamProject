package codefactory.learfletproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class screen_food extends AppCompatActivity {


    LinearLayout img1 = null;
    LinearLayout img2 = null;
    LinearLayout img3 = null;
    LinearLayout img4 = null;
    LinearLayout img5 = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_food);



       img1 = (LinearLayout)findViewById(R.id.img);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.mentalvehicle.co.kr/"));
                startActivity(intent);
            }
        });

        img2 = (LinearLayout)findViewById(R.id.img2);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.kungjeun.co.kr/"));
                startActivity(intent);
            }
        });

        img3 = (LinearLayout)findViewById(R.id.img3);
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://cafebarie.com/"));
                startActivity(intent);
            }
        });

        img4 = (LinearLayout)findViewById(R.id.img4);
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://blog.naver.com/147048/221159547514"));
                startActivity(intent);
            }
        });


        img5 = (LinearLayout)findViewById(R.id.img5);
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/ynh1531/221166460890"));
                startActivity(intent);
            }
        });




       /*imgbtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(mainscreen.this, mainscreen.class);
                startActivity(it);
            }
        });*/
    }
}

