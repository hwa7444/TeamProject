package codefactory.learfletproject;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class coupon extends AppCompatActivity {
    SharedPreferences spf = null;
    String id = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon);


        spf = getSharedPreferences("id", MODE_PRIVATE);
        id = spf.getString("id","");
    }
}
