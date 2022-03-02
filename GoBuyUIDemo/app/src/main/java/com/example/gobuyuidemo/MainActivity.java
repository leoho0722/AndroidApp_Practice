package com.example.gobuyuidemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupIBOutlet();
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
}