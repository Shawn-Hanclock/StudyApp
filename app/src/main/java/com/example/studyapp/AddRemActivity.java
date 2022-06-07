package com.example.studyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddRemActivity extends AppCompatActivity
{

    //static final for passing arraylist through intent
    public static final String WORD_LIST = "com.example.studyapp.WORD_LIST";
    public static final String DEFINE_LIST = "com.example.studyapp.DEFINE_LIST";

    //array lists that store the words and degins
    ArrayList<String> wordList = new ArrayList<String>();
    ArrayList<String> defineList = new ArrayList<String>();

    //elements for user input to add
    EditText wordInput;
    EditText defineInput;
    Button addButton;

    //elements for user input to remove
    EditText removeInput;
    Button removeButton;

    //text views displaying words and defins
    TextView words;
    TextView defines;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_rem);

        //check if the intent comes from study screen
        Intent intent = getIntent();
        String source = getIntent().getStringExtra("Source");
        if(source.equals("Study"))
        {
            Toast.makeText(AddRemActivity.this, "Re-enter Your Word List For Extra Practice", Toast.LENGTH_LONG).show();
        }

        //assignment of inputs to their matching text edits
        wordInput = (EditText) findViewById(R.id.wordInputAdd);
        defineInput = (EditText) findViewById(R.id.defineInputAdd);
        removeInput = (EditText) findViewById(R.id.removeWord);

        //assignment of text views
        words = (TextView) findViewById(R.id.wordListView);
        defines = (TextView) findViewById(R.id.definListView);

        //methods for the buttons
        wordListToHome();
        wordListToStudy();
        removeWord();

        //add button onclick
        addButton = (Button) findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                wordList.add(wordInput.getText().toString());
                defineList.add(defineInput.getText().toString());

                words.setText(words.getText().toString() + "\n " + wordInput.getText().toString() + " ");
                defines.setText(defines.getText().toString() + "\n " + defineInput.getText().toString() + " ");
            }
        });//end of conclick
    }//end of on create

    private void removeWord()
    {
        removeButton = (Button) findViewById(R.id.removeButton);
        removeButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int i = wordList.indexOf(removeInput.getText().toString());
                if (i > -1)
                {
                    words.setText(words.getText().toString().replaceFirst("\n " + removeInput.getText().toString() + " ", ""));
                    defines.setText(defines.getText().toString().replaceFirst("\n " + defineList.get(i) + " ", ""));
                    wordList.remove(i);
                    defineList.remove(i);
                }
                else
                {
                    Toast.makeText(AddRemActivity.this, "Not in the Word List", Toast.LENGTH_LONG).show();
                }
            }
        });//end on click
    }//end of remove word

    private void wordListToHome()
    {
        Button toHome = (Button) findViewById(R.id.wordListMainButton);
        toHome.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(AddRemActivity.this, MainActivity.class));
            }
        });//end on click
    }//end word list to home

    private void wordListToStudy()
    {
        Button toStudy = (Button) findViewById(R.id.wordListStudyButton);
        toStudy.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(AddRemActivity.this, StudyActivity.class);
                intent.putStringArrayListExtra(WORD_LIST, wordList);
                intent.putStringArrayListExtra(DEFINE_LIST, defineList);
                startActivity(intent);
            }
        });//end on click
    }//end word list to sutdy
}//end add rem activity class