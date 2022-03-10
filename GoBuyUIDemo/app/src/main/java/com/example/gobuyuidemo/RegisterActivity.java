package com.example.gobuyuidemo;

import android.content.DialogInterface;
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

import com.example.gobuyuidemo.base_activity.BaseActivity;

public class RegisterActivity extends BaseActivity {

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

    private Boolean firstChoose = true;
    private String countryChooseResults = "";
    private String inputData = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setupIBOutlet(); // 設定 @IBOutlet
        setButtonOnClickListener(); // 設定 @IBAction
        setupCountrySpinnerArrayAdapterDataInput(); // 設定 Spinner 內的資料跟選擇事件
    }

    private void setupIBOutlet() {
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
                    countryChooseResults = adapterView.getSelectedItem().toString();
                }
            }

            @Override // 沒有選擇項目做的事
            public void onNothingSelected(AdapterView<?> adapterView) {
                countryChooseResults = "";
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
            showAlertWithYes("提示", "已經將資料清空了", "關閉", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    // 按下關閉要做的事
                    countryChooseResults = "";
                    phoneTextField.setText("");
                    emailTextField.setText("");
                    passwordTextField.setText("");
                    birthdayTextField.setText("");
                    inputData = "";
                }
            });
        }
    };

    private View.OnClickListener submitData = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            inputData = "國籍：" + countryChooseResults + "\n" +
                    "會員手機：" + phoneTextField.getText() + "\n" +
                    "會員 Email：" + emailTextField.getText() + "\n" +
                    "會員密碼：" + passwordTextField.getText() + "\n" +
                    "出生日期：" + birthdayTextField.getText() + "\n";
            showAlertWithYesNo("提醒", "是否確定送出？\n\n" + inputData, "確定", "取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    System.out.println(inputData);
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class); // 跳頁到登入頁面
                    startActivity(intent);
                }
            }, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    inputData = "";
                }
            });
        }
    };
}