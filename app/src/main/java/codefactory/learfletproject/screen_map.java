package codefactory.learfletproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class screen_map extends AppCompatActivity {

    TextView txt_num2 = null;
    TextView txt_num3 = null;
    TextView txt_num4 = null;
    TextView txt_num5 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_map);

        txt_num2 = (TextView) findViewById(R.id.txt_num2);
        txt_num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(screen_map.this, screen_map.class);
                startActivity(it);
            }
        });

        txt_num3 = (TextView) findViewById(R.id.txt_num3);
        txt_num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(screen_map.this, screen_food.class);
                startActivity(it);
            }
        });

        txt_num4 = (TextView) findViewById(R.id.txt_num4);
        txt_num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(screen_map.this, screen_coupon.class);
                startActivity(it);
            }
        });

        txt_num5 = (TextView) findViewById(R.id.txt_num5);
        txt_num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(screen_map.this, screen_info.class);
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
