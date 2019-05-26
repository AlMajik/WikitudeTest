package com.example.wikitudetest;

import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wikitude.architect.ArchitectStartupConfiguration;
import com.wikitude.architect.WearableArchitectView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private WearableArchitectView architectView;

    

    private static final int WIKITUDE_PERMISSIONS_REQUEST_CAMERA = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        architectView = new WearableArchitectView(this);

        ArchitectStartupConfiguration configuration = new ArchitectStartupConfiguration();
        configuration.setLicenseKey("2Sas5Dk7oosZA0x2Q+SHd7vZE6eaGv0HYjsSSVordcWlp1Mu7SkRcmkXB4GcvCGUBKUAQXfIYDJqV5qkE6jii41hmHe8lrCv5AIsafZ11s+df2q0jWJJddjvYIoTCvNM4FBNUerzzSQvSXuralP51WEKnzC7iCUbYH3GGcIOMXtTYWx0ZWRfX/N+zWyXVv4tKS2GYVjfGbxSzb3PLwmzk6FG5907/pnS1DO0RuWV600coG3EHyLlwVTwxeMXoGlyLjg/c6XSlk9n5R/of1fmRarf/mCQJmnP5yS3/6ZeDWhJIw7DtKwjsjRCRzySIggcilBF1rx8DkCGr+Xg1XaQ8Fq2RJy3CjhqTtzLgSSaQZgksmvsp/HbVMsVob4Ml9I6E12pIQtvZy49VESn+sewK0ffq6M21CqMuaJYB7SEmwYBm0Zbo07KyBz1a8MW0rw/CZ7QznZyaHJo4SyPdPy3n4YMUER6oz6t4kMRJaXyc5gEw30SyAByi33zy5blyy4Fkui5fwFLic/eGKA0QHKKIQoSyN/E+I3cHuVfNLj/xWmWfzX4y9CQrtdP0xZ3M7yUHKGSwaECinWubOeBUaeqFyfis7FfY7+LzoF8ZBeYvkPuXdqNrankHQug0zZyPJc33kwbbClhRz37tcTZ2N2Nq9lGcQ/pSPApLNxM5i5O42PeThV5nesyhGIC8eLXPTq2knNT0hsPQ++gMa3F98HFqNnMs0/7uCd+Hinhqz25p56e8Tlr2OsIRSb5KpBz5MLY");

        architectView.onCreate(configuration);
        setContentView(architectView);

        if ( ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED ) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.CAMERA},
                    WIKITUDE_PERMISSIONS_REQUEST_CAMERA);
        }

    }

    @Override
    protected void onPostCreate(final Bundle savedInstanceState){
        super.onPostCreate(savedInstanceState);
        architectView.onPostCreate();
        try {
            architectView.load( (String) "index.html");
        }catch(IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onResume(){
        super.onResume();
        architectView.onResume();
    }

    @Override
    protected void onPause(){
        super.onPause();
        architectView.onPause();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        architectView.onDestroy();
    }
}
