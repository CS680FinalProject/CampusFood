package com.example.yp.campusfood;


import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.Calendar;

public class Receiver extends BroadcastReceiver {
    private NotificationManager manager;
    private Notification notifyDetails;
    private int SIMPLE_NOTIFICATION_ID;
    private String tickerText = "New Alert!";

    private final double[][] lowerC = new double[][]{
            {25,-1},{11,19},{11,19},{11,19},{11,19},{11,15},{25,-1}
    };

    private final double[][] deloitte = new double[][]{
            {12, 21},{7.5, 21.5},{7.5, 21.5},{7.5, 21.5},{7.5, 21.5},{7.5, 16}, {11, 17}
    };

    private final double[][] cafe921 = new double[][]{
            {9,21},{7,21},{7,21},{7,21},{7,21},{7,20},{9,20}
    };

    private final double[][] currito = new double[][]{
            {12, 23},{12, 23},{12, 23},{12, 23},{12, 23}
    };

    public boolean isOpen(double[][] cafe){
        Calendar cal = Calendar.getInstance();
        double hour = cal.get(Calendar.HOUR_OF_DAY) + (double)(cal.get(Calendar.MINUTE))/60;
        int day = cal.get(Calendar.DAY_OF_WEEK);

        if (cafe[day][0] <= hour && cafe[day][1] >= hour){
            return true;
        }

        else return false;
    }

    public void onReceive(Context context, Intent intent){;
        boolean open = false;

        String cafe = intent.getStringExtra("Cafe");

        switch(cafe){
            case "Lower Cafe":
                open = isOpen(lowerC);
                break;

            case "Deloitte":
                open = isOpen(deloitte);
                break;
        }

        String str = "";
        if (open) {
            str = cafe + " is open now.";
        }

        else str = cafe + " is closed.";

        manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        notifyDetails = new Notification.Builder(context)

                .setContentTitle("Bentley Dining Info")
                .setContentText(str)
                .setSmallIcon(R.drawable.droid)
                .setTicker(tickerText)
                .build();

        manager.notify(SIMPLE_NOTIFICATION_ID, notifyDetails);

    }
}
