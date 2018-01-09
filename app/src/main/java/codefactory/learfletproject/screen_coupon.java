package codefactory.learfletproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;

public class screen_coupon extends AppCompatActivity {

    TextView txt_num2 = null;
    TextView txt_num3 = null;
    TextView txt_num4 = null;
    TextView txt_num5 = null;

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
    MyCouponVO reCvo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_map);

        txt_num2 = (TextView) findViewById(R.id.txt_num2);
        txt_num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(screen_coupon.this, screen_map.class);
                startActivity(it);
            }
        });

        txt_num3 = (TextView) findViewById(R.id.txt_num3);
        txt_num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(screen_coupon.this, screen_food.class);
                startActivity(it);
            }
        });

        txt_num4 = (TextView) findViewById(R.id.txt_num4);
        txt_num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(screen_coupon.this, screen_coupon.class);
                startActivity(it);
            }
        });

        txt_num5 = (TextView) findViewById(R.id.txt_num5);
        txt_num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(screen_coupon.this, screen_info.class);
                startActivity(it);
            }
        });

       /* imgbtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(mainscreen.this, mainscreen.class);
                startActivity(it);
            }
        });*/


        spf = this.getSharedPreferences("id", Context.MODE_PRIVATE);
        id = spf.getString("id", "");


        btn_list = (Button) findViewById(R.id.btn_list);

        ExpandableListView listView = (ExpandableListView) findViewById(R.id.exlistView);
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
        mGroupList.add("추천 쿠폰");
        //보유중인 쿠폰 리스트뷰 코드 끝


        //추천쿠폰 리스트뷰 코드
        //1. 파이썬에서 추천 쿠폰 리스트를 받아온다(1위~6위)
        //2. 해당 쿠폰 명으로 fireBase에서 쿠폰 정보를 받아온다(업체명, 쿠폰내용)
        //3. 받아온 쿠폰 정보를 아래 for문 객체에 넣어준다.

        //추천 쿠폰 임시 데이터
        int recoImage = R.drawable.china2;
        String recoStoreName = "starbucks";
        String recoCouponInfo = "10% 할인";


        String coupon1 = "";
        Task task = new Task();

        coupon1 = task.receiveMsg; // 값을 받아옴
        Log.v("값", coupon1 + "");
        Log.v("ㅅㅂ", "메세지");
        int y = 3;

        for (int i = 0; i < y; i++) {
            //추천 결과 데이터 넣어야함
            reCvo = inputRecoData(recoImage, recoStoreName, recoCouponInfo);
            mChildListContent2.add(reCvo);
            mChildList.add(mChildListContent2);

        }
        //추천쿠폰 리스트뷰 코드 끝

        mExpandableAdapter eea = new mExpandableAdapter(this, mGroupList, mChildList);


        listView.setAdapter(eea);
        eea.notifyDataSetChanged();


    }

    public MyCouponVO inputData(int image, String couponName, String couponValidity) {
        myCvo = new MyCouponVO(image, couponName, couponValidity, "");
        return myCvo;
    }

    public MyCouponVO inputRecoData(int image, String couponName, String couponInfo) {
        reCvo = new MyCouponVO(image, couponName, "", couponInfo);
        return reCvo;
    }
}

