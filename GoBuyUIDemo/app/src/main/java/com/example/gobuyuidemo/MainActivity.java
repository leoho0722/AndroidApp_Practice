package com.example.gobuyuidemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView iconImageView;
    private TextView countryTextView;
    private Spinner countrySpinner;
    private TextView memberAccountTextView;
    private EditText phoneTextField;
    private EditText emailTextField;
    private TextView passwordTextView;
    private EditText passwordTextField;
    private TextView birthdayTextView;
    private EditText birthdayTextField;
    private TextView verifyTextView;
    private Button clearButton;
    private Button submitButton;
    private ArrayAdapter countryArrayAdapter;

    Boolean firstChoose = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupIBOutlet(); // 設定 @IBOutlet
        setButtonOnClickListener(); // 設定 @IBAction
        setupCountrySpinnerArrayAdapterDataInput(); // 設定 Spinner 內的資料跟選擇事件
    }

    public void setupIBOutlet() {
        iconImageView = findViewById(R.id.iconImageView);
        countryTextView = findViewById(R.id.countryTextView);
        countrySpinner = findViewById(R.id.countrySpinner);
        memberAccountTextView = findViewById(R.id.memberAccountTextView);
        phoneTextField = findViewById(R.id.phoneTextField);
        emailTextField = findViewById(R.id.emailTextField);
        passwordTextView = findViewById(R.id.passwordTextView);
        passwordTextField = findViewById(R.id.passwordTextField);
        birthdayTextView = findViewById(R.id.birthdayTextView);
        birthdayTextField = findViewById(R.id.birthdayTextField);
        verifyTextView = findViewById(R.id.verifyTextView);
        clearButton = findViewById(R.id.clearButton);
        submitButton = findViewById(R.id.submitButton);
    }

    public void setupCountrySpinnerArrayAdapterDataInput() {
        countryArrayAdapter = ArrayAdapter.createFromResource(this, R.array.country, android.R.layout.simple_dropdown_item_1line);
        countrySpinner.setAdapter(countryArrayAdapter);
        setupSpinnerOnItemSelectedListener();
    }

    private void setupSpinnerOnItemSelectedListener() {
        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override // 有選擇項目做的事
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (firstChoose) {
                    firstChoose = false;
                } else {
                    Toast.makeText(view.getContext(), adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override // 沒有選擇項目做的事
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    // OnClickListener 類似 @IBAction
    public void setButtonOnClickListener() {
        clearButton.setOnClickListener(clearData);
        submitButton.setOnClickListener(submitData);
    }

    private View.OnClickListener clearData = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            phoneTextField.setText("");
            emailTextField.setText("");
            passwordTextField.setText("");
            birthdayTextField.setText("");
        }
    };

    private View.OnClickListener submitData = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class); // 跳頁到登入頁面
            startActivity(intent);
        }
    };
}