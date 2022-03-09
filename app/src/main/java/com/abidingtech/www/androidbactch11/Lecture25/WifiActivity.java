package com.abidingtech.www.androidbactch11.Lecture25;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.net.wifi.ScanResult;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.abidingtech.www.androidbactch11.R;
import com.thanosfisherman.wifiutils.WifiUtils;

import java.util.List;

public class WifiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);

        WifiUtils.withContext(getApplicationContext()).enableWifi(this::getEnabled);

        WifiUtils.withContext(getApplicationContext()).scanWifi(this::getWifiResults).start();

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED){
            requestPermission();
        }

    }

    int PERMISSION_CODE=123;
    private void requestPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.ACCESS_FINE_LOCATION)){

        }
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},PERMISSION_CODE);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode==PERMISSION_CODE){
            if (grantResults.length >0 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
                Toast.makeText(this, "Thanks for Giving us Permission", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
        }
    }

    private void getWifiResults(List<ScanResult> results) {
        if (results.isEmpty())
        {
            Log.e("TAG", "SCAN RESULTS IT'S EMPTY");
            return;
        }
        Log.e("TAG", "GOT SCAN RESULTS " + results);
    }

    private void getEnabled(boolean b) {

        if (b)
            Toast.makeText(this, "Wifi is Enabled", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Wifi is Not Enabled", Toast.LENGTH_SHORT).show();

    }
}