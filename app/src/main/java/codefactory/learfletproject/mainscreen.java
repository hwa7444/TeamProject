package codefactory.learfletproject;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class mainscreen extends AppCompatActivity {

    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;
    Fragment4 fragment4;
    Fragment5 fragment5;

    Button imgbtn_num1 = null;
    Button imgbtn_num2 = null;
    Button imgbtn_num3 = null;
    Button imgbtn_num4 = null;
    Button imgbtn_num5 = null;
    ImageButton imgButton_back = null;


    boolean isPageOpen = false;
    FrameLayout container = null;

    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);

        final Animation translateLeft;
        Animation translateRight;
        container = findViewById(R.id.container);
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();
        fragment5 = new Fragment5();



        drawerLayout = (DrawerLayout)findViewById(R.id.drawer);

        translateLeft = AnimationUtils.loadAnimation(this, R.anim.translate_left);
        translateRight = AnimationUtils.loadAnimation(this, R.anim.translate_left);


        imgbtn_num1 = (Button)findViewById(R.id.imgbtn_num1);
        imgbtn_num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isPageOpen){
                    container.startAnimation(translateLeft);
                }else{
                    imgbtn_num1.setVisibility(View.VISIBLE);
                    container.startAnimation(translateLeft);
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment1).commit();
                drawerLayout.closeDrawers();//버튼누르면 슬라이드메뉴창 닫기
            }
        });

        imgbtn_num2 = (Button) findViewById(R.id.imgbtn_num2);
        imgbtn_num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment2).commit();
                drawerLayout.closeDrawers();
            }
        });

        imgbtn_num3 = (Button) findViewById(R.id.imgbtn_num3);
        imgbtn_num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment3).commit();
                drawerLayout.closeDrawers();
            }
        });

        imgbtn_num4 = (Button) findViewById(R.id.imgbtn_num4);
        imgbtn_num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment4).commit();
                drawerLayout.closeDrawers();
            }
        });

        imgbtn_num5 = (Button) findViewById(R.id.imgbtn_num5);
        imgbtn_num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment5).commit();
                drawerLayout.closeDrawers();
            }
        });

        imgButton_back = (ImageButton) findViewById(R.id.imgButton_back);
        imgButton_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(mainscreen.this, mainscreen.class);
                startActivity(it);
                finish();

            }
        });
    }
}

