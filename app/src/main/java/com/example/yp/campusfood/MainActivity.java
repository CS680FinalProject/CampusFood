package com.example.yp.campusfood;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TabHost;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.view.View;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import java.util.ArrayList;
import java.util.Calendar;


public class MainActivity extends Activity implements OnClickListener {

    private RadioGroup group;





    // initiate new variable for google map and tab

    private static final float zoom = 14.0f;
    TabHost tabHost;

    // button for option menu
    final int yourMenu = Menu.FIRST + 1;
    final int setting = Menu.FIRST + 2;
    final int help = Menu.FIRST + 3;
    final int secret = Menu.FIRST + 4;
    final int close = Menu.FIRST + 5;

    private TextView text1, text2, text3, text4, text5;
    private ImageButton image1, image2, image3, image4, image5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayUseLogoEnabled(false);

        tabHost = (TabHost) findViewById(R.id.tabhost);
        tabHost.setup();

        text1 = (TextView) findViewById(R.id.textView1);
        text2 = (TextView) findViewById(R.id.textView2);
        text3 = (TextView) findViewById(R.id.textView3);
        text4 = (TextView) findViewById(R.id.textView4);
        text5 = (TextView) findViewById(R.id.textView5);

        image1 = (ImageButton) findViewById(R.id.image1);
        image2 = (ImageButton) findViewById(R.id.image2);
        image3 = (ImageButton) findViewById(R.id.image3);
        image4 = (ImageButton) findViewById(R.id.image4);
        image5 = (ImageButton) findViewById(R.id.image5);
        image1.setOnClickListener(this);
        image2.setOnClickListener(this);
        image3.setOnClickListener(this);
        image4.setOnClickListener(this);
        image5.setOnClickListener(this);

        TabHost.TabSpec spec;
        // Initialize a TabSpec for tab1 and add it to the TabHost
        spec=tabHost.newTabSpec("tag1");	//create new tab specification
        spec.setContent(R.id.tab1);    //add tab view content
        spec.setIndicator("Cafe");    //put text on tab
        tabHost.addTab(spec);             //put tab in TabHost container

        //set listeners for tab1


        //-------------------------------------------------------------------------------------

        // Initialize a TabSpec for tab2 and add it to the TabHost
        spec=tabHost.newTabSpec("tag2");		//create new tab specification
        spec.setContent(R.id.tab2);			//add view tab content
        spec.setIndicator("Favorites");
        tabHost.addTab(spec);					//put tab in TabHost container





        //-------------------------------------------------------------------------------------

        // Initialize a TabSpec for tab3 and add it to the TabHost
        spec=tabHost.newTabSpec("tag3");		//create new tab specification
        spec.setContent(R.id.tab3);			//add tab view content
        spec.setIndicator("Radio");			//put text on tab
        tabHost.addTab(spec); 					//put tab in TabHost container


    }


    // option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuItem item1 = menu.add(0, yourMenu, Menu.NONE, "Your Menu");
        MenuItem item2 = menu.add(0, setting, Menu.NONE, "Setting");
        MenuItem item3 = menu.add(0, help, Menu.NONE, "Help");
        MenuItem item4 = menu.add(0, secret, Menu.NONE, "Secret Function");
        MenuItem item5 = menu.add(0, close, Menu.NONE, "Close App");
        item1.setShortcut('1', 'a');
        item2.setShortcut('2', 'd');
        item3.setShortcut('3', 'u');
        item4.setShortcut('4', 's');
        item5.setShortcut('5', 'c');
        return true;
    }

    public void onClick(View v) throws SecurityException {
        Intent intent = new Intent(MainActivity.this, CafeView.class);

        // test
        Intent broadcast = new Intent("TRIGGER_RECEIVER");

        // find image buttons by id and run respective code
        switch (v.getId()) {

            case R.id.image1:
                intent.putExtra("CafeName", "LowerCafe");
                broadcast.putExtra("Cafe", "Lower Cafe");
                sendBroadcast(broadcast);
                startActivity(intent);
                break;

            case R.id.image2:
                intent.putExtra("CafeName", "921");
                broadcast.putExtra("Cafe", "Deloitte");
                sendBroadcast(broadcast);
                startActivity(intent);
                break;

            case R.id.image3:
                intent.putExtra("CafeName", "Deloitte");
                startActivity(intent);
                break;

            case R.id.image4:
                intent.putExtra("CafeName", "Currito");
                startActivity(intent);
                break;

            case R.id.image5:
                intent.putExtra("CafeName", "Dunkin");
                startActivity(intent);
                break;
        }
    }
}
