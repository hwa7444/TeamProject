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
    private ArrayList<ArrayList<MyCouponVO>> mChildList = null;
    private ArrayList<MyCouponVO> mChildListContent = null;
    private ArrayList<MyCouponVO> mChildListContent2 = null;
    private ArrayList<MyCouponVO> userCoupon = null;

    SharedPreferences spf = null;
    String id = "";

    MyCouponVO myCvo = null;
    String couponName = "";
    MyCouponVO reCvo =  null;





    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        spf = this.getActivity().getSharedPreferences("id", Context.MODE_PRIVATE);
        id = spf.getString("id", "");
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment4, container, false);

        btn_list = (Button) rootView.findViewById(R.id.btn_list);

        ExpandableListView listView = rootView.findViewById(R.id.exlistView);
        mGroupList = new ArrayList<String>();
        mChildList = new ArrayList<ArrayList<MyCouponVO>>();
        mChildListContent = new ArrayList<MyCouponVO>();
        mChildListContent2 = new ArrayList<MyCouponVO>();

        //보유중인 쿠폰 리스트뷰 코드 시작
        //임시 데이터
        String couponName = "a";
        String couponValidity = "b";
        int image = R.drawable.acc1;


        //FireBase에서 받아온 값 집어넣어야 함
        int x = 3;//사용자가 가지고 있는 쿠폰 개수 들어가야함
        for (int i = 0; i < x; i++) {

            //쿠폰정보....넣는 firebase 코드
            if (!couponName.equals("")) {
                myCvo = inputData(image, couponName, couponValidity);
                mChildListContent.add(myCvo);
            }
        }
        mChildList.add(mChildListContent);

        mGroupList.add("보유중인 쿠폰");
        mGroupList.add("추천 쿠폰 분석하기");
        //보유중인 쿠폰 리스트뷰 코드 끝


        //추천쿠폰 리스트뷰 코드
        //1. 파이썬에서 추천 쿠폰 리스트를 받아온다(1위~6위)
        //2. 해당 쿠폰 명으로 fireBase에서 쿠폰 정보를 받아온다(업체명, 쿠폰내용)
        //3. 받아온 쿠폰 정보를 아래 for문 객체에 넣어준다.

        //추천 쿠폰 임시 데이터
        int recoImage = R.drawable.china2;
        String recoStoreName = "starbucks";
        String recoCouponInfo = "10% 할인";
        int y = 3;

        for (int i = 0; i < y; i++) {
            //추천 결과 데이터 넣어야함
            reCvo = inputRecoData(recoImage, recoStoreName, recoCouponInfo);
            mChildListContent2.add(reCvo);
            mChildList.add(mChildListContent2);

        }
        //추천쿠폰 리스트뷰 코드 끝

        mExpandableAdapter eea = new mExpandableAdapter(getActivity(), mGroupList, mChildList);


        listView.setAdapter(eea);
        eea.notifyDataSetChanged();


        btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getActivity(), chart.class);
                startActivity(it);

            }
        });


        return rootView;


    }

    public MyCouponVO inputData(int image, String couponName, String couponValidity) {
        myCvo = new MyCouponVO(image, couponName, couponValidity, "");
        return myCvo;
    }

    public MyCouponVO inputRecoData(int image, String couponName, String couponInfo) {
        reCvo = new MyCouponVO(image, couponName,"",couponInfo);
        return reCvo;
    }

}


