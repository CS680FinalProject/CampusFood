package com.example.yp.campusfood;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;


public class CafeView extends Activity implements OnClickListener{

    private ImageView image;
    private TextView hours, menu;
    private Button btn1, btn2;
    private String strUrl;
    private String cafeName;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cafe_layout);

        image = (ImageView) findViewById(R.id.imageView);
        hours = (TextView) findViewById(R.id.TextHours);
        menu = (TextView) findViewById(R.id.TextMenu);
        btn1 = (Button) findViewById(R.id.Button1);
        btn1.setOnClickListener(this);
        btn2 = (Button) findViewById(R.id.Button2);
        btn2.setOnClickListener(this);

        // get string message of cafe selected
        Bundle b = getIntent().getExtras();
        cafeName =b.getString("CafeName");

        Spanned strHours = null, strMenu = null;

        switch (cafeName) {

            case "LowerCafe":
                strHours = Html.fromHtml(getString(R.string.hours_lowerCafe));
                strMenu = Html.fromHtml(getString(R.string.menu_lowerCafe));
                strUrl = "https://bentley.sodexomyway.com/dining-choices/lacava.html";
                break;


            case "921":
                strHours = Html.fromHtml(getString(R.string.hours_921));
                strMenu = Html.fromHtml(getString(R.string.menu_921));
                strUrl = "http://bentley.sodexomyway.com/dining-choices/index.html";
                break;

            case "Deloitte":
                strHours = Html.fromHtml(getString(R.string.hours_Deloitte));
                strMenu = Html.fromHtml(getString(R.string.menu_Deloitte));
                strUrl = "http://www.einsteinbros.com/";
                break;

            case "Currito":
                strHours = Html.fromHtml(getString(R.string.hours_currito));
                strMenu = Html.fromHtml(getString(R.string.menu_currito));
                strUrl = "http://www.currito.com/";
                break;

            case "Dunkin":
                strHours = Html.fromHtml(getString(R.string.hours_dunkin));
                strMenu = Html.fromHtml(getString(R.string.menu_dunkin));
                strUrl = "http://www.dunkindonuts.com/en";
                break;

        }
        hours.setText(strHours);
        menu.setText(strMenu);

    }
    public void onClick(View v) throws SecurityException {

        switch (v.getId()) {

            case R.id.Button1:
                Intent intent0 = new Intent(CafeView.this, Map.class);
                intent0.putExtra("Cafe", cafeName);
                startActivity(intent0);
                break;

            case R.id.Button2:
                Intent intent = new Intent(CafeView.this, WebBrowse.class);
                intent.putExtra("URL", strUrl);
                startActivity(intent);
                break;


        }
    }
}
