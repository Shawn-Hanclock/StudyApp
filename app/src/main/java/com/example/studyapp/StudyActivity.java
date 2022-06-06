package com.example.studyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);
        studyToWordList();
        studyToHome();
    }

    private void studyToHome()
    {
        Button toHome = (Button) findViewById(R.id.studyMainButton);
        toHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudyActivity.this, MainActivity.class));
            }
        });
    }

    private void studyToWordList()
    {
        Button toWordList = (Button) findViewById(R.id.studyWordListButton);
        toWordList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudyActivity.this, AddRemActivity.class));
            }
        });
    }
}