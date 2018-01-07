package codefactory.learfletproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


/**
 * Created by jhyoo on 2018-01-04.
 */
public class Fragment4 extends Fragment {

    Button btn_list = null;
    private ArrayList<String> mGroupList = null;
    private ArrayList<ArrayList<String>> mChildList = null;
    private ArrayList<String> mChildListContent = null;
    SharedPreferences spf = null;
    String id = "";

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        spf = this.getActivity().getSharedPreferences("id", Context.MODE_PRIVATE);
        id = spf.getString("id","");


        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment4, container, false);

        btn_list = (Button)rootView.findViewById(R.id.btn_list);

        ExpandableListView listView = rootView.findViewById(R.id.exlistView);
        mGroupList = new ArrayList<String>();
        mChildList = new ArrayList<ArrayList<String>>();
        mChildListContent = new ArrayList<String>();

        mGroupList.add("받은쿠폰함");
        mGroupList.add("받을 수 있는 주변 쿠폰");
        mGroupList.add("쿠폰사용순위");
        mGroupList.add("관심사가 같은 유저들이 선호하는 쿠폰");

        mChildListContent.add("1");
        mChildListContent.add("2");
        mChildListContent.add("3");
        mChildListContent.add("4");

        mChildList.add(mChildListContent);
        mChildList.add(mChildListContent);
        mChildList.add(mChildListContent);
        mChildList.add(mChildListContent);


        mExpandableAdapter eea = new mExpandableAdapter(getActivity(), mGroupList, mChildList);
        listView.setAdapter(eea);

        btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getActivity(), chart.class);
                startActivity(it);

            }
        });


        return rootView;


    }

}


