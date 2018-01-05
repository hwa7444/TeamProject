package codefactory.learfletproject;

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
    ArrayList<String> array = new ArrayList<String>();
    ArrayList<dataVO> arrayList = new ArrayList<dataVO>();
    ImageView img = null;
    Button btn_use = null;
    TextView tv_name = null;
    TextView tv_time = null;
    Button btn_send = null;
    ListView lv = null;

    private ArrayList<String> mGroupList = null;
    private ArrayList<ArrayList<String>> mChildList = null;
    private ArrayList<String> mChildListContent = null;


    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment4, container, false);

        ExpandableListView listView = rootView.findViewById(R.id.exlistView);
        mGroupList = new ArrayList<String>();
        mChildList = new ArrayList<ArrayList<String>>();
        mChildListContent = new ArrayList<String>();

        mGroupList.add("받은쿠폰함");
        mGroupList.add("받을 수 있는 주변 쿠폰");
        mGroupList.add("쿠폰사용순위");

        mChildListContent.add("1");
        mChildListContent.add("2");
        mChildListContent.add("3");

        mChildList.add(mChildListContent);
        mChildList.add(mChildListContent);
        mChildList.add(mChildListContent);


        mExpandableAdapter eea = new mExpandableAdapter(getActivity(), mGroupList, mChildList);
        listView.setAdapter(eea);


        return rootView;


    }

}


