package codefactory.learfletproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    ImageButton imgbtn_back = null;
    SharedPreferences spf = null;
    String id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spf = getSharedPreferences("id", MODE_PRIVATE);
        id = spf.getString("id","");


        imgbtn_back = (ImageButton)findViewById(R.id.imgbtn_back);
        Spinner spinner = (Spinner)findViewById(R.id.spn_menu);
        Spinner spinner1 = (Spinner)findViewById(R.id.spn_menu2);
        Spinner spinner2 = (Spinner)findViewById(R.id.spn_menu3);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.number,android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this, R.array.number2,android.R.layout.simple_spinner_item);
        spinner1.setAdapter(adapter2);

        ArrayAdapter adapter3 = ArrayAdapter.createFromResource(this, R.array.number3,android.R.layout.simple_spinner_item);
        spinner2.setAdapter(adapter3);




                imgbtn_back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent it = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(it);
                        finish();
                    }
                });

    }
}
