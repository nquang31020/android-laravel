package com.example.buyticket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        LinearLayout linearLayout = findViewById(R.id.dsGhe);

        for(int i = 0; i < 10; i++)
        {
            Button btn = new Button(this);
            btn.setText("A" + i);
            linearLayout.addView(btn, 150,150);
        }
    }
}