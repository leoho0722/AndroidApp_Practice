package com.example.gobuyuidemo;

import com.example.gobuyuidemo.base_activity.BaseActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends BaseActivity {
    private TextView Login_AccountTextView;
    private EditText Login_AccountEditText;
    private TextView Login_PasswordTextView;
    private EditText Login_PasswordEditText;
    private TextView HttpsTextView;
    private CheckBox HttpsCheckBox;
    private TextView LongStayTextView;
    private CheckBox LongStayCheckBox;
    private Button clearButton;
    private Button submitButton;
    private TextView verifyTextView;

    private String inputData = "";
    private String httpsState = "";
    private String longStayState = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setUpIBOutlet(); // 設定 @IBOutlet
        setupButtonOnClickListener(); // 設定 @IBAction
    }

    public void setUpIBOutlet() {
        Login_AccountTextView = findViewById(R.id.AccountTextView);
        Login_AccountEditText = findViewById(R.id.AccountEditText);
        Login_PasswordTextView = findViewById(R.id.PasswordTextView);
        Login_PasswordEditText = findViewById(R.id.PasswordEditText);
        HttpsTextView = findViewById(R.id.HTTPSTextView);
        HttpsCheckBox = findViewById(R.id.HTTPSCheckBox);
        LongStayTextView = findViewById(R.id.LongStayTextView);
        LongStayCheckBox = findViewById(R.id.LongStayCheckBox);
        clearButton = findViewById(R.id.Login_ClearButton);
        submitButton = findViewById(R.id.Login_SubmitButton);
        verifyTextView = findViewById(R.id.Login_VerifyTextView);
    }

    // OnClickListener 類似 @IBAction
    public void setupButtonOnClickListener() {
        clearButton.setOnClickListener(clearData);
        submitButton.setOnClickListener(submitData);
    }

    private View.OnClickListener clearData = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            showAlertWithYes("提示", "已經將資料清空了", "關閉", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Login_AccountEditText.setText("");
                    Login_PasswordEditText.setText("");
                    HttpsCheckBox.setChecked(false);
                    LongStayCheckBox.setChecked(false);
                    inputData = "";
                    httpsState = "";
                    longStayState = "";
                }
            });
        }
    };

    private View.OnClickListener submitData = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            httpsState = HttpsCheckBox.isChecked() ? "已勾選" : "未勾選";
            longStayState = LongStayCheckBox.isChecked() ? "已勾選" : "未勾選";
            inputData = "會員帳號：" + Login_AccountEditText.getText() + "\n" +
                    "會員密碼：" + Login_PasswordEditText.getText() + "\n" +
                    "HTTPS 勾選狀態：" + httpsState + "\n" +
                    "常駐 勾選狀態：" + longStayState + "\n";
            showAlertWithYesNo("提醒", "是否確定送出？\n\n" + inputData, "確定", "取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    System.out.println(inputData);
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
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