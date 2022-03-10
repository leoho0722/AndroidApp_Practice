package com.example.gobuyuidemo.base_activity;

import android.app.AlertDialog;
import android.content.DialogInterface;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    /// 單一確認按鈕的 AlertDialog
    /// - Parameters:
    /// - title: String，AlertDialog 的標題
    /// - message: String，AlertDialog 的訊息
    /// - confirmTitle: String，，AlertDialog 確認按鈕的文字
    /// - confirmListener: DialogInterface.OnClickListener，按下確認按鈕後要做的事
    public void showAlertWithYes(String title, String message, String confirmTitle, DialogInterface.OnClickListener confirmListener) {
        AlertDialog.Builder alertWithYesBuilder = new AlertDialog.Builder(this);
        alertWithYesBuilder.setTitle(title).setMessage(message);
        alertWithYesBuilder.setPositiveButton(confirmTitle, confirmListener); // 按下確認按鈕後要做的事
        alertWithYesBuilder.setCancelable(true); // 可以透過返回鍵來關閉 Alert
        alertWithYesBuilder.show();
    }

    /// 有確認、取消按鈕的 AlertDialog
    /// - Parameters:
    /// - title: String，AlertDialog 的標題
    /// - message: String，AlertDialog 的訊息
    /// - confirmTitle: String，，AlertDialog 確認按鈕的文字
    /// - cancelTitle: String，，AlertDialog 取消按鈕的文字
    /// - confirmListener: DialogInterface.OnClickListener，按下確認按鈕後要做的事
    /// - cancelListener: DialogInterface.OnClickListener，按下取消按鈕後要做的事
    public void showAlertWithYesNo(String title, String message, String confirmTitle, String cancelTitle, DialogInterface.OnClickListener confirmListener, DialogInterface.OnClickListener cancelListener) {
        AlertDialog.Builder alertWithYesNoBuilder = new AlertDialog.Builder(this);
        alertWithYesNoBuilder.setTitle(title).setMessage(message);
        alertWithYesNoBuilder.setPositiveButton(confirmTitle, confirmListener); // 按下確認按鈕後要做的事
        alertWithYesNoBuilder.setNegativeButton(cancelTitle, cancelListener);  // 按下取消按鈕後要做的事
        alertWithYesNoBuilder.setCancelable(true); // 可以透過返回鍵來關閉 Alert
        alertWithYesNoBuilder.show();
    }


}
