package codefactory.learfletproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class mainscreen extends AppCompatActivity {
    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;
    Fragment4 fragment4;
    Fragment5 fragment5;

    ImageButton imgbtn_num1 = null;
    ImageButton imgbtn_num2 = null;
    ImageButton imgbtn_num3 = null;
    ImageButton imgbtn_num4 = null;
    ImageButton imgbtn_num5 = null;

    SharedPreferences spf = null;

    String id = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);

        //아이디 받아온것
        spf = getSharedPreferences("id", MODE_PRIVATE);
        id = spf.getString("id","");

        Log.v("확인", id);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();
        fragment5 = new Fragment5();


        imgbtn_num1 = (ImageButton)findViewById(R.id.imgbtn_num1);
        imgbtn_num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment1).commit();
            }
        });

        imgbtn_num2 = (ImageButton)findViewById(R.id.imgbtn_num2);
        imgbtn_num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment2).commit();
            }
        });

        imgbtn_num3 = (ImageButton)findViewById(R.id.imgbtn_num3);
        imgbtn_num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment3).commit();
            }
        });

        imgbtn_num4 = (ImageButton)findViewById(R.id.imgbtn_num4);
        imgbtn_num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment4).commit();
            }
        });

        imgbtn_num5 = (ImageButton)findViewById(R.id.imgbtn_num5);
        imgbtn_num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment5).commit();
            }
        });
    }
}

