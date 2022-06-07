package com.example.studyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class StudyActivity extends AppCompatActivity {


    Button swap;
    Button next;

    TextView flashCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);
        studyToHome();
        swapCard();
        nextCard();

        flashCard = (TextView) findViewById(R.id.studyWordDefTextView);

        Intent intent = getIntent();
        ArrayList<String> wordStudy = intent.getStringArrayListExtra(AddRemActivity.WORD_LIST);
        ArrayList<String> defineStudy = intent.getStringArrayListExtra(AddRemActivity.DEFINE_LIST);

        //flashCard.setText(wordStudy.get(0));


        Toast.makeText(StudyActivity.this, "" + wordStudy.isEmpty(), Toast.LENGTH_LONG).show();
        if(!(wordStudy.isEmpty()))
        {
            flashCard.setText(wordStudy.get(0));
        }

        Button toWordList = (Button) findViewById(R.id.studyWordListButton);
        toWordList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudyActivity.this, AddRemActivity.class));
            }
        });
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

    private void swapCard()
    {
        swap = (Button) findViewById(R.id.swapButton);
        swap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void nextCard()
    {
        next = (Button) findViewById(R.id.nextButton);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}