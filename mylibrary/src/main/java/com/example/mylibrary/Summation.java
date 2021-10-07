package com.example.mylibrary;

import android.content.Context;

import com.clevertap.android.sdk.CleverTapAPI;

import java.util.HashMap;

public class Summation {
    public int a;
    public int b;

    public Summation(int x, int y) {
        a = x;
        b = y;
    }

    public int sum(Context context) {

        CleverTapAPI clevertapDefaultInstance = CleverTapAPI.getDefaultInstance(context);
        CleverTapAPI.setDebugLevel(3);

        HashMap<String, Object> prodViewedAction = new HashMap<String, Object>();
        prodViewedAction.put("first value", a);
        prodViewedAction.put("second value", b);
        prodViewedAction.put("Sum", a + b);
        prodViewedAction.put("Date", new java.util.Date());

        clevertapDefaultInstance.pushEvent("Summation", prodViewedAction);

        return a + b;
    }

    public int multi() {
        return a * b;
    }
}
