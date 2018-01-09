package codefactory.learfletproject;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class screen_coupon extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_coupon);


        ////////////////////보유중인 쿠폰 리스트 시작
        ListView listview;
        ListViewAdapter adapter;

        // Adapter 생성
        adapter = new ListViewAdapter();

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);

        // 첫 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.bonobono1),
                "김밥 한줄 300원!", "2018년 1월 8일 21시 30분까지");
        // 두 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.bonobono2),
                "콜라 무료!!!!!!!!", "2018년 1월 8일 21시 34분까지");
        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.bonobono3),
                "가게 가져라!!!!", "2099년 12월 4일 11시 30분까지");


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                // get item
                ListViewItem item = (ListViewItem) parent.getItemAtPosition(position);

                String titleStr = item.getTitle();
                String descStr = item.getDesc();
                Drawable iconDrawable = item.getIcon();

                // TODO : use item data.
            }
        });
        ///////////////////보유중인 쿠폰 리스트 끝


        ///////////////////추천 쿠폰 리스트뷰 시작
        ListView listview2;
        ListViewAdapter adapter2;

        // Adapter 생성
        adapter2 = new ListViewAdapter();

        // 리스트뷰 참조 및 Adapter달기
        listview2 = (ListView) findViewById(R.id.listview2);
        listview2.setAdapter(adapter2);

        //1. 파이썬 분석결과 가져오기(추천1,추천2,추천3)
        /*추천 쿠폰 : 스타벅스, 엔제리너스, 베스킨이라고 가정
        넘어온 값 : "starbucks, angelinus, baskin"
        */

        //2. 분석결과에 해당하는 쿠폰정보 가져오기(FireBase)

        String a = "starbucks";
        int[] arr = {R.drawable.adidas,R.drawable.angelinus,R.drawable.apple,R.drawable.artbox,R.drawable.baskin,R.drawable.burgerking,R.drawable.china1,R.drawable.china2,R.drawable.dessert1,R.drawable.dior,R.drawable.domino,R.drawable.hair1,R.drawable.hair2,R.drawable.hyundai,R.drawable.innisfree,R.drawable.japan1,R.drawable.japan2,R.drawable.kia,R.drawable.korean1,R.drawable.korean2,R.drawable.korean3,R.drawable.kyobo,R.drawable.nail1,R.drawable.nail2,R.drawable.officedepot,R.drawable.pizzahut,R.drawable.chanel,R.drawable.sony,R.drawable.starbucks,R.drawable.sulbing,R.drawable.swarovski,R.drawable.thebodyshop,R.drawable.western1,R.drawable.western2,R.drawable.ypbook,R.drawable.yvessaintlaurent,};
        String[] arrString = {"adidas", "angelinus", "apple", "artbox", "baskin", "burgerking", "china1", "china2", "dessert1", "dior", "domino", "hair1", "hair2", "hyundai", "innisfree", "japan1", "japan2", "kfc", "kia", "korean1", "korean2", "korean3", "kyobo", "nail1", "nail2", "officedepot", "pizzahut", "chanel", "sony", "starbucks", "sulbing", "swarovski", "thebodyshop", "western1", "western2", "ypbook", "yvessaintlaurent"};

        for (int i = 0; i < arr.length; i++) {
            if (arrString[i].equals(a)) {
                int img1 = arr[i];
            }
        }


        int img1 = R.drawable.starbucks;
        int img2 = R.drawable.angelinus;
        int img3 = R.drawable.baskin;
        //3.가져온 쿠폰정보 listView2에 추가
        // 첫 번째 아이템 추가.
        adapter2.addItem(ContextCompat.getDrawable(this, img1),
                "김밥 한줄 300원!", "2018년 1월 8일 21시 30분까지");
        // 두 번째 아이템 추가.
        adapter2.addItem(ContextCompat.getDrawable(this, img2),
                "콜라 무료!!!!!!!!", "2018년 1월 8일 21시 34분까지");
        // 세 번째 아이템 추가.
        adapter2.addItem(ContextCompat.getDrawable(this, img3),
                "가게 가져라!!!!", "2099년 12월 4일 11시 30분까지");


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                // get item
                ListViewItem item = (ListViewItem) parent.getItemAtPosition(position);

                String titleStr = item.getTitle();
                String descStr = item.getDesc();
                Drawable iconDrawable = item.getIcon();

                // TODO : use item data.
            }
        });
        ///////////////////추천 쿠폰 리스트뷰 끝
    }
}
