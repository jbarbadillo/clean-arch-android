package com.javirock.cleanarchevents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.javirock.cleanarchevents.ui.views.RegistrationActivity;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Intent activity = new Intent(this, RegistrationActivity.class);
        startActivity(activity);
    }
}
