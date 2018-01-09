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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class mainscreen extends AppCompatActivity {

    /*Fragment1 fragment1;*/
    Fragment2 fragment2;
    Fragment3 fragment3;
    Fragment4 fragment4;
    Fragment5 fragment5;

    /*TextView txt_num1 = null;*/
    TextView txt_num2 = null;
    TextView txt_num3 = null;
    TextView txt_num4 = null;
    TextView txt_num5 = null;
    boolean isPageOpen = false;
    FrameLayout container = null;

    ImageView imgbtn_back = null;

    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);

        final Animation translateLeft;
        Animation translateRight;
        container = findViewById(R.id.container);
       /* fragment1 = new Fragment1();*/
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();
        fragment5 = new Fragment5();

        Intent intent = new Intent();
        String analData = intent.getStringExtra("analData");


        imgbtn_back = (ImageView)findViewById(R.id.imgbtn_back);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer);

        translateLeft = AnimationUtils.loadAnimation(this, R.anim.translate_left);
        translateRight = AnimationUtils.loadAnimation(this, R.anim.translate_left);

        //홈화면에서 지도 나오게
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment2).commit();
        drawerLayout.closeDrawers();

        /*txt_num1 = (TextView)findViewById(R.id.txt_num1);
        txt_num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isPageOpen){
                    container.startAnimation(translateLeft);
                }else{
                    txt_num1.setVisibility(View.VISIBLE);
                    container.startAnimation(translateLeft);
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment1).commit();
                drawerLayout.closeDrawers();//버튼누르면 슬라이드메뉴창 닫기
            }
        });*/

        txt_num2 = (TextView) findViewById(R.id.txt_num2);
        txt_num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment2).commit();
                drawerLayout.closeDrawers();
            }
        });

        txt_num3 = (TextView) findViewById(R.id.txt_num3);
        txt_num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment3).commit();
                drawerLayout.closeDrawers();
            }
        });

        txt_num4 = (TextView) findViewById(R.id.txt_num4);
        txt_num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment4).commit();
                drawerLayout.closeDrawers();
            }
        });

        txt_num5 = (TextView) findViewById(R.id.txt_num5);
        txt_num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment5).commit();
                drawerLayout.closeDrawers();
            }
        });

        imgbtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(mainscreen.this, mainscreen.class);
                startActivity(it);
            }
        });
    }
}

