package com.example.gobuyuidemo.custom_alert;

import android.app.AlertDialog;
import android.content.DialogInterface;

import androidx.appcompat.app.AppCompatActivity;

public class CustomAlert extends AppCompatActivity {
    private showAlertListener alertListener = null;
    public interface showAlertListener {
        void onConfirm();
        void onCancel();
    }
    public void setShowAlertListener(showAlertListener listener) {
        alertListener = listener;
    }

    public void showAlertWithYes(String title, String message, String confirmTitle) {
        AlertDialog.Builder alertWithYesBuilder = new AlertDialog.Builder(this);
        alertWithYesBuilder.setTitle(title).setMessage(message);
        // 點擊確認按鈕要做的事
        alertWithYesBuilder.setPositiveButton(confirmTitle, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                System.out.println("按下了只有確認按鈕的 Alert");
            }
        });
        alertWithYesBuilder.setCancelable(true); // 可以透過返回鍵來關閉 Alert
        alertWithYesBuilder.show();
    }

    public void showAlertWithYesNo(String title, String message, String confirmTitle, String cancelTitle) {
        AlertDialog.Builder alertWithYesNoBuilder = new AlertDialog.Builder(this);
        alertWithYesNoBuilder.setTitle(title).setMessage(message);
        // 點擊確認按鈕要做的事
        alertWithYesNoBuilder.setPositiveButton(confirmTitle, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                System.out.println("按下確認按鈕");
            }
        });
        // 點擊取消按鈕要做的事
        alertWithYesNoBuilder.setNegativeButton(cancelTitle, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                System.out.println("按下取消按鈕");
            }
        });
        alertWithYesNoBuilder.setCancelable(true); // 可以透過返回鍵來關閉 Alert
        alertWithYesNoBuilder.show();
    }
}
