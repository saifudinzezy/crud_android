package com.firebaseapp.crud.helper;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;

public class SendData {
    public static String KEY = "data";

    public static void sendDataToAcitivity(Context context, Class activity, Parcelable list){
        Intent intent = new Intent(context, activity);
        intent.putExtra(KEY, list);
        context.startActivity(intent);
    }
}
