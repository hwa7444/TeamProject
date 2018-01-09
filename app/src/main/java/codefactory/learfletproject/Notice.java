package codefactory.learfletproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Notice extends AppCompatActivity {


    TextView txt_notice2 = null;
    TextView txt_notice3 = null;
    TextView txt_notice4 = null;
    TextView txt_notice5 = null;
    TextView txt_notice6 = null;
    TextView txt_notice7 = null;
    TextView txt_notice8 = null;
    TextView txt_notice9 = null;
    LinearLayout txt_back = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);


        /*txt_back = (LinearLayout)findViewById(R.id.txt_back);
        txt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Notice.this, Fragment5.class);
                startActivity(it);
            }
        });*/

        txt_notice2 = (TextView)findViewById(R.id.txt_notice2);
        txt_notice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Notice.this, Notice2Activity.class);
                startActivity(it);
            }
        });

        txt_notice3 = (TextView)findViewById(R.id.txt_notice3);
        txt_notice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Notice.this, Notice3Activity.class);
                startActivity(it);
            }
        });

        txt_notice4 = (TextView)findViewById(R.id.txt_notice4);
        txt_notice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Notice.this, Notice4Activity.class);
                startActivity(it);
            }
        });

        txt_notice5 = (TextView)findViewById(R.id.txt_notice5);
        txt_notice5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Notice.this, Notice5Activity.class);
                startActivity(it);
            }
        });

        txt_notice6 = (TextView)findViewById(R.id.txt_notice6);
        txt_notice6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Notice.this, Notice6Activity.class);
                startActivity(it);
            }
        });

        txt_notice7 = (TextView)findViewById(R.id.txt_notice7);
        txt_notice7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Notice.this, Notice7Activity.class);
                startActivity(it);
            }
        });

        txt_notice8 = (TextView)findViewById(R.id.txt_notice8);
        txt_notice8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Notice.this, Notice8Activity.class);
                startActivity(it);
            }
        });

        txt_notice9 = (TextView)findViewById(R.id.txt_notice9);
        txt_notice9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Notice.this, Notice9Activity.class);
                startActivity(it);
            }
        });



    }
}
