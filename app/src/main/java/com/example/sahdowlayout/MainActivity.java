package com.example.sahdowlayout;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ShadowLayout shadowLayout = new ShadowLayout(this);
        setContentView(shadowLayout);

        addOrangeButton(shadowLayout);
        addBlueButton(shadowLayout);
        addRedButton(shadowLayout);
        addWhitebutton(shadowLayout);
        addGreyButton(shadowLayout);
        addFace(shadowLayout);

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void addOrangeButton(ShadowLayout shadowLayout) {
        float density = getResources().getDisplayMetrics().density;
        ViewGroup.MarginLayoutParams layoutParams = new ViewGroup.MarginLayoutParams((int) (72 * density), (int) (32 * density));
        TextView button1 = new TextView(this);
        button1.setGravity(Gravity.CENTER);

        layoutParams.setMargins(dp(10), dp(10), 0, 0);
        button1.setLayoutParams(layoutParams);
        button1.setText("Text");
        button1.setTextColor(Color.WHITE);
        button1.setTextSize(sp(6));
        button1.setBackgroundColor(Color.parseColor("#FF4200"));
        button1.setBackground(ContextCompat.getDrawable(this,R.drawable.round_corners_ornge));
        button1.setLayoutParams(layoutParams);
        Shadow shadow = new Shadow();
        shadow.setAlpha(90);
        shadow.setBlur(20);
        shadow.setColor("#ff003f");
//        shadow.setColor("#64424242");
//        shadow.setColor("#96424242");
        shadow.setX(-10);
        shadow.setY(20);
        button1.setTag(R.id.shadow,shadow);
        shadowLayout.addView(button1);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void addBlueButton(ShadowLayout shadowLayout) {
        ViewGroup.MarginLayoutParams layoutParams = new ViewGroup.MarginLayoutParams(dp(72), dp(32));
        TextView button1 = new TextView(this);
        button1.setGravity(Gravity.CENTER);
        layoutParams.setMargins(dp(10), dp(52), 0, 0);
        button1.setLayoutParams(layoutParams);
        button1.setText("Text");
        button1.setTextColor(Color.WHITE);
        button1.setTextSize(sp(6));
        button1.setBackgroundColor(Color.parseColor("#1951F5"));
        button1.setBackground(ContextCompat.getDrawable(this,R.drawable.round_corners_blue));
        button1.setLayoutParams(layoutParams);
        Shadow shadow = new Shadow();
        shadow.setAlpha(90);
        shadow.setBlur(20);
        shadow.setColor("#1951F5");
        shadow.setX(0);
        shadow.setY(10);
        button1.setTag(R.id.shadow,shadow);
        shadowLayout.addView(button1);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void addRedButton(ShadowLayout shadowLayout) {
        ViewGroup.MarginLayoutParams layoutParams = new ViewGroup.MarginLayoutParams(dp(72), dp(32));
        TextView button1 = new TextView(this);
        button1.setGravity(Gravity.CENTER);
        layoutParams.setMargins(dp(10), dp(94), 0, 0);
        button1.setLayoutParams(layoutParams);
        button1.setText("Text");
        button1.setTextColor(Color.WHITE);
        button1.setTextSize(sp(6));
        button1.setBackgroundColor(Color.parseColor("#FF003F"));
        button1.setBackground(ContextCompat.getDrawable(this,R.drawable.round_corners_red));
        button1.setLayoutParams(layoutParams);
        Shadow shadow = new Shadow();
        shadow.setAlpha(90);
        shadow.setBlur(20);
        shadow.setColor("#FF003F");
        shadow.setX(0);
        shadow.setY(10);
        button1.setTag(R.id.shadow,shadow);
        shadowLayout.addView(button1);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void addWhitebutton(ShadowLayout shadowLayout) {

        ViewGroup.MarginLayoutParams layoutParams = new ViewGroup.MarginLayoutParams(dp(72), dp(32));
        TextView button1 = new TextView(this);
        button1.setGravity(Gravity.CENTER);
        layoutParams.setMargins(dp(10), dp(136), 0, 0);
        button1.setLayoutParams(layoutParams);
        button1.setText("Text");
        button1.setTextColor(Color.RED);
        button1.setTextSize(sp(6));
        button1.setBackgroundColor(Color.parseColor("#FFFFFF"));
        button1.setBackground(ContextCompat.getDrawable(this,R.drawable.round_corners_white));
        button1.setLayoutParams(layoutParams);
        Shadow shadow = new Shadow();
        shadow.setAlpha(90);
        shadow.setBlur(20);
        shadow.setColor("#000000");
        shadow.setX(0);
        shadow.setY(10);
        button1.setTag(R.id.shadow,shadow);
        shadowLayout.addView(button1);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void addGreyButton(ShadowLayout shadowLayout) {

        ViewGroup.MarginLayoutParams layoutParams = new ViewGroup.MarginLayoutParams(dp(72), dp(32));
        TextView button1 = new TextView(this);
        button1.setGravity(Gravity.CENTER);
        layoutParams.setMargins(dp(10), dp(178), 0, 0);
        button1.setLayoutParams(layoutParams);
        button1.setText("Text");
        button1.setTextColor(Color.WHITE);
        button1.setTextSize(sp(6));
        button1.setBackgroundColor(Color.parseColor("#D0D2DA"));
        button1.setBackground(ContextCompat.getDrawable(this, R.drawable.round_corners_grey));
        button1.setLayoutParams(layoutParams);
        Shadow shadow = new Shadow();
        shadow.setAlpha(90);
        shadow.setBlur(10);
//        shadow.setColor("#1a3a3f4a");
        shadow.setColor("#000000");
        shadow.setX(0);
        shadow.setY(10);
        button1.setTag(R.id.shadow,shadow);
        shadowLayout.addView(button1);
    }

    private int dp(int px) {
        float density = getResources().getDisplayMetrics().density;
        return (int) (px * density);
    }

    private int sp(int px) {
        float density = getResources().getDisplayMetrics().scaledDensity;
        return (int) (px * density);
    }
    private void addFace(ShadowLayout shadowLayout){
        View view = new View(this);

        Shadow shadow = new Shadow();
        shadow.setAlpha(90);
        shadow.setBlur(20);
//        shadow.setColor("#33ff003f");
//        shadow.setColor("#64424242");
        shadow.setColor("#96424242");
        shadow.setX(50);
        shadow.setY(50);
        ViewGroup.MarginLayoutParams layoutParams = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(dp(10), dp(208), 0, 0);
        view.setLayoutParams(layoutParams);
        view.setBackgroundResource(R.drawable.ic_launcher_foreground);
        view.setTag(R.id.shadow,shadow);
        shadowLayout.addView(view);
    }
}
