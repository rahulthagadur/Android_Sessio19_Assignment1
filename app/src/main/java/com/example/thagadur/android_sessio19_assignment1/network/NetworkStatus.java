package com.example.thagadur.android_sessio19_assignment1.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;



/**
 * Created by Thagadur on 11/2/2017.
 */
public class NetworkStatus {

    private static NetworkStatus instance = new NetworkStatus();
    static Context context;
    ConnectivityManager connectivityManager;
    boolean connected = false;

    public static NetworkStatus getInstance(Context ctx) {
        context = ctx;
        return instance;
    }

    public boolean isOnline(Context con) {
        try {
            connectivityManager = (ConnectivityManager) con.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            connected = networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected();
            return connected;
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context,"Check Connectivity Exception: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            //Log.v("connectivity", e.toString());
        }
        return connected;
    }

    /**
     * Checking for all possible Internet providers
     **/
    public boolean isConnectedToInternet(){
        connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        if (activeNetwork != null) { // connected to the internet
            return true;
        }
        return false;
    }
}
