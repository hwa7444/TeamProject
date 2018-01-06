package codefactory.learfletproject;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jhyoo on 2018-01-05.
 */

public class mExpandableAdapter extends BaseExpandableListAdapter {
        private ArrayList<String> groupList = null;
        private ArrayList<ArrayList<String>> childList = null;
        private LayoutInflater inflater = null;


    public mExpandableAdapter(Context c, ArrayList<String> groupList,ArrayList<ArrayList<String>> childList){
        this.inflater = LayoutInflater.from(c);
        this.groupList = groupList;
        this.childList = childList;


    }


    @Override
    public int getGroupCount() { return groupList.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return childList.get(i).size();
    }

    @Override
    public Object getGroup(int i) {
        return groupList.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return childList.get(i).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        if(view == null){
            view = inflater.inflate(R.layout.parentlistitem, viewGroup, false);
        }
        TextView tv = view.findViewById(R.id.tv_parent);
        tv.setText(groupList.get(i));
        return view;
    }

    @Override
    public View getChildView(final int groupID, int childID, boolean b, View view, ViewGroup viewGroup) {

        //여기만 손대면돼욤!
        if(view == null){
            view = inflater.inflate(R.layout.sublistitem, viewGroup, false);
        }
        ImageView img1 = view.findViewById(R.id.img_child1);
        TextView tv2 = view.findViewById(R.id.tv_child2);
        TextView tv3 = view.findViewById(R.id.tv_child3);
        Button btn4 = view.findViewById(R.id.btn_child4);

        img1.setVisibility(View.VISIBLE);
        tv2.setVisibility(View.VISIBLE);
        tv3.setVisibility(View.VISIBLE);
        btn4.setVisibility(View.VISIBLE);

        /*tv1.setText(childList.get(groupID).get(childID));*/

        if (groupID == 2){
            tv3.setVisibility(View.GONE);
            btn4.setVisibility(View.GONE);
        }else if(groupID == 1){
            tv3.setVisibility(View.GONE);
            btn4.setVisibility(View.GONE);
        }



        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
