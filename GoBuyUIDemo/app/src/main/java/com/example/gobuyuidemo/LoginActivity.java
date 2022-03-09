package com.example.gobuyuidemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
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
            Login_AccountEditText.setText("");
            Login_PasswordEditText.setText("");
            HttpsCheckBox.setChecked(false);
            LongStayCheckBox.setChecked(false);
        }
    };

    private View.OnClickListener submitData = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            System.out.println("會員帳號：" + Login_AccountEditText.getText());
            System.out.println("會員密碼：" + Login_PasswordEditText.getText());
            System.out.println("HTTPS 勾選狀態：" + HttpsCheckBox.isChecked());
            System.out.println("常駐 勾選狀態：" + HttpsCheckBox.isChecked());
        }
    };
}