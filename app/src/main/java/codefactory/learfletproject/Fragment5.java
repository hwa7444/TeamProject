package codefactory.learfletproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by jhyoo on 2018-01-04.
 */

public class Fragment5 extends Fragment {

    private ArrayList<String> mGroupList2 = null;
    private ArrayList<ArrayList<String>> mChildList2 = null;
    private ArrayList<String> mChildListContent2 = null;

    TextView txt_notice = null;
    TextView txt_logout = null;

    SharedPreferences spf = null;
    String id = "";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment5, container, false);

        txt_notice = (TextView)rootView.findViewById(R.id.txt_notice);
        txt_logout = (TextView)rootView.findViewById(R.id.txt_logout);

        spf = this.getActivity().getSharedPreferences("id", Context.MODE_PRIVATE);
        id = spf.getString("id","");
        
       txt_logout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent it = new Intent(getActivity(), LoginActivity.class);
               startActivity(it);
           }
       });

       txt_notice.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent it = new Intent(getActivity(), Notice.class);
               startActivity(it);
           }
       });
        /*ExpandableListView listView = rootView.findViewById(R.id.exlistview2);
        mGroupList2 = new ArrayList<String>();
        mChildList2 = new ArrayList<ArrayList<String>>();
        mChildListContent2 = new ArrayList<String>();

        mGroupList2.add("내가 사용한 쿠폰");
        mGroupList2.add("내가 선호하는 쿠폰");
        mGroupList2.add("관심사가 같은 유저들이 선호하는 쿠폰");

        mChildListContent2.add("1");
        mChildListContent2.add("2");
        mChildListContent2.add("3");

        mChildList2.add(mChildListContent2);
        mChildList2.add(mChildListContent2);
        mChildList2.add(mChildListContent2);


        mExpandableAdapter eea = new mExpandableAdapter(getActivity(), mGroupList2, mChildList2);
        listView.setAdapter(eea);*/


        return rootView;


    }

}
