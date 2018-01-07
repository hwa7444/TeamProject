package codefactory.learfletproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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

public class Fragment1 extends Fragment {

    private PieChart mPieChart; //piechart
    private Button btn_pie1, btn_bar1, btn_line1;
    SharedPreferences spf = null;
    String id = "";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment1, container, false);

        spf = this.getActivity().getSharedPreferences("id", Context.MODE_PRIVATE);
        id = spf.getString("id","");


        mPieChart = (PieChart) rootView.findViewById(R.id.piechart);
        btn_pie1 = (Button) rootView.findViewById(R.id.btn_pie1);
        btn_bar1 = (Button) rootView.findViewById(R.id.btn_bar1);
        btn_line1 = (Button) rootView.findViewById(R.id.btn_line1);




//
//            btn_bar1.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent it = new Intent(pie_pie.this, bar_bar.class);
//                    finish();
//                    startActivity(it);
//                }
//            });

//            btn_line1.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent it = new Intent(pie_pie.this, line_line.class);
//                    finish();
//                    startActivity(it);
//                }
//            });

        //piechart

        mPieChart.setUsePercentValues(true);
        mPieChart.getDescription().setEnabled(false);
        mPieChart.setExtraOffsets(5,10,5,5);

        mPieChart.setDragDecelerationFrictionCoef(0.95f);

        mPieChart.setDrawHoleEnabled(false);
        mPieChart.setHoleColor(Color.WHITE);
        mPieChart.setTransparentCircleRadius(61f);

        ArrayList<PieEntry> yValues = new ArrayList<PieEntry>();

        yValues.add(new PieEntry(34f,"Japan"));  //라벨
        yValues.add(new PieEntry(23f,"USA"));
        yValues.add(new PieEntry(14f,"UK"));
        yValues.add(new PieEntry(35f,"India"));
        yValues.add(new PieEntry(40f,"Russia"));
        yValues.add(new PieEntry(40f,"Korea"));

        Description description = new Description();
        description.setText("세계 국가"); //라벨
        description.setTextSize(15);
        mPieChart.setDescription(description);

        mPieChart.animateY(1000, Easing.EasingOption.EaseInOutCubic); //애니메이션

        PieDataSet dataSet = new PieDataSet(yValues,"Countries");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.JOYFUL_COLORS); //색바꾸는 속성

        PieData pie_data = new PieData((dataSet));
        pie_data.setValueTextSize(10f);
        pie_data.setValueTextColor(Color.YELLOW); //퍼센트 색깔

        mPieChart.setData(pie_data);


        return rootView;

    }
}

