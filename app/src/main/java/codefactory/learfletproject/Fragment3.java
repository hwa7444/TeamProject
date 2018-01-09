package codefactory.learfletproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by jhyoo on 2018-01-04.
 */

public class Fragment3 extends Fragment {

    LinearLayout img1 = null;
    LinearLayout img2 = null;
    LinearLayout img3 = null;
    LinearLayout img4 = null;
    LinearLayout img5 = null;

    SharedPreferences spf = null;
    String id = "";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment3, container, false);
        spf = this.getActivity().getSharedPreferences("id", Context.MODE_PRIVATE);
        id = spf.getString("id","");

        img1 = (LinearLayout)rootView.findViewById(R.id.img);
        img2 = (LinearLayout)rootView.findViewById(R.id.img2);
        img3 = (LinearLayout)rootView.findViewById(R.id.img3);
        img4 = (LinearLayout)rootView.findViewById(R.id.img4);
        img5 = (LinearLayout)rootView.findViewById(R.id.img5);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.mentalvehicle.co.kr/"));
                startActivity(intent);
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.kungjeun.co.kr/"));
                startActivity(intent);
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://cafebarie.com/"));
                startActivity(intent);
            }
        });

        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://blog.naver.com/147048/221159547514"));
                startActivity(intent);
            }
        });

        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/ynh1531/221166460890"));
                startActivity(intent);
            }
        });

        return rootView;

    }
}
