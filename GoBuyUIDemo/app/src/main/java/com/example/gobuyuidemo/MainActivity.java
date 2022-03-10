package com.example.gobuyuidemo;

import com.example.gobuyuidemo.base_activity.BaseActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends BaseActivity {

    private ImageView iconImageView;
    private TextView Main_SloganTextView;
    private ImageButton Main_LatestNewsImageButton;
    private ImageButton Main_ScanImageButton;
    private ImageButton Main_ActivitySearchImageButton;
    private ImageButton Main_BonusPointsSearchImageButton;
    private ImageButton Main_SearchStoreImageButton;
    private ImageButton Main_FunctionSettingsImageButton;
    private ImageButton Main_JoinSpecialStoreImageButton;
    private ImageButton Main_JoinDiscountStoreImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupIBOutlet(); // 設定 @IBOutlet
        setupButtonOnClickListener(); // 設定 @IBAction
    }

    private void setupIBOutlet() {
        iconImageView = findViewById(R.id.iconImageView);
        Main_SloganTextView = findViewById(R.id.Main_SloganTextView);
        Main_LatestNewsImageButton = findViewById(R.id.Main_LatestNewsImageButton);
        Main_ScanImageButton = findViewById(R.id.Main_ScanImageButton);
        Main_ActivitySearchImageButton = findViewById(R.id.Main_ActivitySearchImageButton);
        Main_BonusPointsSearchImageButton = findViewById(R.id.Main_BonusPointsSearchImageButton);
        Main_SearchStoreImageButton = findViewById(R.id.Main_SearchStoreImageButton);
        Main_FunctionSettingsImageButton = findViewById(R.id.Main_FunctionSettingsImageButton);
        Main_JoinSpecialStoreImageButton = findViewById(R.id.Main_JoinSpecialStoreImageButton);
        Main_JoinDiscountStoreImageButton = findViewById(R.id.Main_JoinDiscountStoreImageButton);
    }

    private void setupButtonOnClickListener() {
        Main_LatestNewsImageButton.setOnClickListener(latestNews);
        Main_ScanImageButton.setOnClickListener(scan);
        Main_ActivitySearchImageButton.setOnClickListener(activitySearch);
        Main_BonusPointsSearchImageButton.setOnClickListener(bonusPointsSearch);
        Main_SearchStoreImageButton.setOnClickListener(searchStore);
        Main_FunctionSettingsImageButton.setOnClickListener(functionSettings);
        Main_JoinSpecialStoreImageButton.setOnClickListener(joinSpecialStore);
        Main_JoinDiscountStoreImageButton.setOnClickListener(joinDiscountStore);
    }

    private View.OnClickListener latestNews = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            System.out.println("點擊了最新消息按鈕");
        }
    };
    private View.OnClickListener scan = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            System.out.println("點擊了掃一掃按鈕");
        }
    };
    private View.OnClickListener activitySearch = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            System.out.println("點擊了活動查詢按鈕");
        }
    };
    private View.OnClickListener bonusPointsSearch = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            System.out.println("點擊了紅利點數查詢按鈕");
        }
    };
    private View.OnClickListener searchStore = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            System.out.println("點擊了搜尋店家按鈕");
        }
    };
    private View.OnClickListener functionSettings = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            System.out.println("點擊了功能設置按鈕");
        }
    };
    private View.OnClickListener joinSpecialStore = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            System.out.println("點擊了申請加入特約店按鈕");
        }
    };
    private View.OnClickListener joinDiscountStore = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            System.out.println("點擊了申請加入優惠店按鈕");
        }
    };
}