package com.example.openweatherapi_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.openweatherapi_android.model.API;
import com.example.openweatherapi_android.model.OpenWeatherStruct;

import java.net.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    /* UI 元件宣告 */
    TextView cityNameLabel;  // 宣告一個用來顯示選取到的城市的 TextView，類似 UILabel
    Button chooseCityButton; // 宣告一個用來觸發選取城市 Spinner 的 Button，類似 UIButton
    Button startSearchCityButton; // 宣告一個用來查詢城市的 Button，類似 UIButton
    Spinner chooseCitySpinner; // 宣告一個用來「選取城市」的 Spinner，類似 UIPickerView

    /* 變數宣告 */
    boolean isFirstPress = true; // 用來判斷是否為首次點選
    private String cityChooseResult; // 用來儲存選取到的城市名稱
    private String cityNameWithURL; // 用來給 URL 用的城市名稱

    Retrofit apiManager;

    @Override
    // onCreate 類似 viewDidLoad
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupIBOutlet(); // 設定 UI 元件的 @IBOutlet
        setupButtonOnClickListener(); // 設定 Button 元件的 @IBAction

        ArrayAdapter cityNameAdapter = ArrayAdapter.createFromResource(this, R.array.cityName, android.R.layout.simple_dropdown_item_1line); // 將 cityName.xml 裡面的城市名稱宣告為 ArrayAdapter 型態

        chooseCitySpinner.setAdapter(cityNameAdapter); // 將在 cityName.xml 裡面的城市名稱用 ArrayAdapter 的方式指派給 Spinner
        chooseCitySpinner.setVisibility(View.GONE); // 隱藏 Spinner
    }

    public void setupIBOutlet() {
        /* findViewById，類似 @IBOutlet */
        cityNameLabel = (TextView)findViewById(R.id.cityNameLabel); // 與畫面上的 TextView 進行連接，類似 @IBOutlet
        chooseCityButton = (Button)findViewById(R.id.chooseCityBtn); // 與畫面上的 Button 進行連接，類似 @IBOutlet
        startSearchCityButton = (Button)findViewById(R.id.startSearchCityBtn); // 與畫面上的 Button 進行連接，類似 @IBOutlet
        chooseCitySpinner = (Spinner)findViewById(R.id.chooseCitySpinner); // 與畫面上的 Spinner 進行連接，類似 @IBOutlet
    }

    public void setupButtonOnClickListener() {
        /* setOnClickListener，類似 @IBAction */
        chooseCityButton.setOnClickListener(displayChooseCityPickerView);
        startSearchCityButton.setOnClickListener(startSearchCityWeather);
    }

    public void switchCityNameToURLFormat(String city) {
        switch (city) {
            case "台北":
                cityNameWithURL = "Taipei";
            case "新北":
                cityNameWithURL = "New%20Taipei";
            case "桃園":
                cityNameWithURL = "Taoyuan";
            case "台中":
                cityNameWithURL = "Taichung";
            case "台南":
                cityNameWithURL = "Tainan";
            case "高雄":
                cityNameWithURL = "Kaohsiung";
            case "紐約":
                cityNameWithURL = "New%20York";
            case "首爾":
                cityNameWithURL = "Seoul";
            default: break;
        }
    }

    private View.OnClickListener displayChooseCityPickerView = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
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
                        switchCityNameToURLFormat(cityChooseResult);
                    }
                }

                @Override
                // 沒有選擇項目要做的事
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }
    };

    private View.OnClickListener startSearchCityWeather = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            final String address = "https://api.openweathermap.org/data/2.5/";
            final String apiKey = "62ef5eba4eeb4662491645f8f68cc219";
            apiManager = new Retrofit.Builder()
//                    .baseUrl(address + "q=" + cityNameWithURL + "&appid=" + apiKey)
                    .baseUrl(address)
                    .addConverterFactory(GsonConverterFactory.create()).build();
            API api = apiManager.create(API.class);
//            api.getItem(cityNameWithURL, apiKey);
            Call<OpenWeatherStruct> getWeather = api.getItem(cityNameWithURL, apiKey);
            getWeather.enqueue(new Callback<OpenWeatherStruct>() {
                @Override
                public void onResponse(Call<OpenWeatherStruct> call, Response<OpenWeatherStruct> response) {
                    Log.d("name", );
                }

                @Override
                public void onFailure(Call<OpenWeatherStruct> call, Throwable t) {

                }
            });

        }
    };
}