package codefactory.learfletproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * Created by jhyoo on 2018-01-04.
 */

public class Fragment2 extends Fragment {

    LinearLayout linearTop = null;
    ImageView imageView_map = null;
    SharedPreferences spf = null;
    String id = "";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment2, container, false);
        View v = inflater.inflate(R.layout.fragment2, container, false);
        imageView_map = v.findViewById(R.id.imgView_map);


        linearTop = (LinearLayout)v.findViewById(R.id.linear_top);
        //linearTop = (LinearLayout)getView().findViewById(R.id.linear_top);
        linearTop.setVisibility(View.GONE);

        spf = this.getActivity().getSharedPreferences("id", Context.MODE_PRIVATE);

        id = spf.getString("id","");


        //지도 눌렀을때 상단 레이아웃 나오게 설정해 놓음.
        //지도 상 표시 눌렀을 때 레이아웃 나오게 설정 바꿔야 함.
        imageView_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //나타날 때 & 사라질 때 스르륵 애니메이션
                Animation animation = new AlphaAnimation(0, 1);
                animation.setDuration(1000);

                linearTop.setVisibility(View.VISIBLE);
                linearTop.setAnimation(animation);


            }
        });


        return v;




    }
}
