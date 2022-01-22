package com.example.openweatherapi_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner chooseCitySpinner; // 宣告一個用來「選取城市」的 Spinner，類似 UIPickerView
    TextView cityNameLabel;  // 宣告一個用來顯示選取到的城市的 TextView，類似 UILabel
    boolean isFirstPress = true; // 用來判斷是否為首次點選
    String cityChooseResult; // 用來儲存選取到的城市名稱

    @Override
    // onCreate 類似 viewDidLoad
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* findViewById，類似 @IBOutlet */
        chooseCitySpinner = (Spinner)findViewById(R.id.chooseCitySpinner); // 與畫面上的 Spinner 進行連接，類似 @IBOutlet
        cityNameLabel = (TextView)findViewById(R.id.cityNameLabel);

        ArrayAdapter cityNameAdapter = ArrayAdapter.createFromResource(this, R.array.cityName, android.R.layout.simple_dropdown_item_1line); // 將 cityName.xml 裡面的城市名稱宣告為 ArrayAdapter 型態

        chooseCitySpinner.setAdapter(cityNameAdapter); // 將在 cityName.xml 裡面的城市名稱用 ArrayAdapter 的方式指派給 Spinner
        chooseCitySpinner.setVisibility(View.GONE); // 隱藏 Spinner
    }

    public void displayChooseCityPickerView(View view) {
        chooseCitySpinner.setVisibility(View.VISIBLE); // 顯示 Spinner

        // Spinner 點選項目的監聽事件
        chooseCitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            // 有選擇項目要做的事
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                cityChooseResult = adapterView.getItemAtPosition(i).toString(); // 將選取到的城市名稱轉為字串
                if (isFirstPress) {
                    isFirstPress = false;
                } else {
                    Toast.makeText(MainActivity.this, cityChooseResult, Toast.LENGTH_LONG).show(); // 用 Toast 的方式顯示在畫面上
                    cityNameLabel.setText("你選擇的城市為：" + cityChooseResult); // 將選擇的城市名稱顯示在畫面上
                }
            }

            @Override
            // 沒有選擇項目要做的事
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}