package com.example.studyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class StudyActivity extends AppCompatActivity
{
    //buttons for switching cards
    Button swap;
    Button next;

    //text view for words
    TextView flashCard;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);
        studyToHome();
        studyToWordList();

        flashCard = (TextView) findViewById(R.id.studyWordDefTextView);

        Intent intent = getIntent();
        ArrayList<String> wordStudy = new ArrayList<String>();
        for(String s: intent.getStringArrayListExtra(AddRemActivity.WORD_LIST))
        {
            wordStudy.add(s);
        }//end of loop for words

        ArrayList<String> defineStudy = new ArrayList<String>();
        for(int i = 0; i < (intent.getStringArrayListExtra(AddRemActivity.DEFINE_LIST)).size(); i++)
        {
            defineStudy.add(intent.getStringArrayListExtra(AddRemActivity.DEFINE_LIST).get(i));
        }//end of loop for define

        //flashCard.setText(wordStudy.get(0));
        final Integer[] pos = {0};
        final Integer[] currtCard = {0};


        //Toast.makeText(StudyActivity.this, "" + wordStudy.isEmpty(), Toast.LENGTH_LONG).show();
        if(!(wordStudy.isEmpty()))
        {
            flashCard.setText(wordStudy.get(pos[0]));
        }

        swap = (Button) findViewById(R.id.swapButton);
        swap.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                setCard(currtCard[0], wordStudy, defineStudy, pos[0]);
                currtCard[0]++;

            }
        });//end of on click

        next = (Button) findViewById(R.id.nextButton);
        next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(pos[0] + 1 < wordStudy.size())
                {
                    pos[0]++;
                }
                else
                {
                    pos[0] = 0;
                }
                setCard(currtCard[0], wordStudy, defineStudy, pos[0]);
            }
        });//end of on click
    }//end on create

    private void studyToHome()
    {
        Button toHome = (Button) findViewById(R.id.studyMainButton);
        toHome.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(StudyActivity.this, MainActivity.class));
            }
        });//end on click
    }//end study to home

    private void studyToWordList()
    {
        Button toWordList = (Button) findViewById(R.id.studyWordListButton);
        toWordList.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(StudyActivity.this, AddRemActivity.class);
                intent.putExtra("Source", "Study");
                startActivity(intent);
            }
        });//end on click
    }//end study to wordList

    private void setCard(int i, ArrayList<String> def, ArrayList<String> wrd, int pos)
    {
        if(i % 2 != 0)
        {
            flashCard.setText(def.get(pos));
        }//end if
        else
        {
            flashCard.setText(wrd.get(pos));
        }//edn else
    }//end set card
}//end study activity class