package com.example.studyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainToWordList();
        mainToAbout();

    }//end of onCreate

    private void mainToWordList()
    {
        Button toWordList = (Button) findViewById(R.id.mainWordListButton);
        toWordList.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, AddRemActivity.class);
                intent.putExtra("Source", "Main");
                startActivity(intent);
            }
        });//end on click
    }//end of mainToWordList

    private void mainToAbout()
    {
        Button toAbout = (Button) findViewById(R.id.mainAboutButton);
        toAbout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
            }
        });//end on click
    }//end of mainToAbout
}// end of mainActivity class