package com.example.studyapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class AboutActivity extends AppCompatActivity
{
    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        aboutToMain();
    }//end of oncreate

    private void aboutToMain()
    {
        Button toMain = (Button) findViewById(R.id.aboutMainButton);
        toMain.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(AboutActivity.this, MainActivity.class));
            }
        });//end on click
    }//end of about to main
}//end of about activity class