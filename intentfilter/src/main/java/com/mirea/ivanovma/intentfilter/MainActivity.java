package com.mirea.ivanovma.intentfilter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn1;
    private Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);

        View.OnClickListener onBtnUri = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String address = "https://www.mirea.ru/";
                Intent openLinkIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(address));
                startActivity(openLinkIntent);
            }
        };


        View.OnClickListener onBtnSendInfo = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "MIREA");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Иванов Максим Александрович");
                startActivity(Intent.createChooser(shareIntent, "ИМА"));
            }
        };

        btn1.setOnClickListener(onBtnUri);
        btn2.setOnClickListener(onBtnSendInfo);
    }
}