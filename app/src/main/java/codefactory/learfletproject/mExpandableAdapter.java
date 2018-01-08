package codefactory.learfletproject;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by jhyoo on 2018-01-05.
 */

public class mExpandableAdapter extends BaseExpandableListAdapter {
        private ArrayList<String> groupList = null;
        private ArrayList<ArrayList<String>> childList = null;
        private LayoutInflater inflater = null;
        private Context c;



    public mExpandableAdapter(Context c, ArrayList<String> groupList,ArrayList<ArrayList<String>> childList){
        this.inflater = LayoutInflater.from(c);
        this.groupList = groupList;
        this.childList = childList;
        this.c = c;

    }


    @Override
    public int getGroupCount() {
        return groupList.size();
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

        /*btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.btn_child4:
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(c);
                        alertDialogBuilder.setTitle("쿠폰사용");

                        alertDialogBuilder
                                .setMessage("쿠폰을 사용하시겠습니까?")
                                .setCancelable(false)
                                .setPositiveButton("예",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int i) {
                                                Intent it = new Intent(c, coupon.class);
                                                c.startActivity(it);
                                            }
                                        })
                                .setNegativeButton("아니오",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int i) {
                                                dialog.cancel();
                                            }
                                        });
                }
            }
        });*/

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(c, giftcouponActivity.class);
                c.startActivity(it);
            }
        });

        /*tv1.setText(childList.get(groupID).get(childID));*/


        if (groupID == 0){
            tv3.setVisibility(View.GONE);
            btn4.setVisibility(View.GONE);
        }else if(groupID == 1){
            tv3.setVisibility(View.GONE);
            btn4.setVisibility(View.GONE);
        }/*else{
            view = inflater.inflate(R.layout.fragment1, viewGroup, false);
        }*/


        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
