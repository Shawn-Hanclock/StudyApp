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

public class AddRemActivity extends AppCompatActivity {
    public static final String WORD_LIST = "com.example.studyapp.WORD_LIST";
    public static final String DEFINE_LIST = "com.example.studyapp.DEFINE_LIST";
//    Map<String, String> wordList = new HashMap<String, String>();
    Intent intent = getIntent();
    ArrayList<String> wordList = new ArrayList<String>();
    ArrayList<String> defineList = new ArrayList<String>();

    EditText wordInput;
    EditText defineInput;
    Button addButton;
    EditText removeInput;
    Button removeButton;

    TextView words;
    TextView defines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_rem);

        wordInput = (EditText) findViewById(R.id.wordInputAdd);
        defineInput = (EditText) findViewById(R.id.defineInputAdd);
        removeInput = (EditText) findViewById(R.id.removeWord);

        words = (TextView) findViewById(R.id.wordListView);
        defines = (TextView) findViewById(R.id.definListView);

        wordListToHome();
        wordListToStudy();
        removeWord();

        addButton = (Button) findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wordList.add(wordInput.getText().toString());
                defineList.add(defineInput.getText().toString());

                words.setText(words.getText().toString() + "\n " + wordInput.getText().toString() + " ");
                defines.setText(defines.getText().toString() + "\n " + defineInput.getText().toString() + " ");
            }
        });

    }

    private void removeWord()
    {
        removeButton = (Button) findViewById(R.id.removeButton);
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = wordList.indexOf(removeInput.getText().toString());
                if (i > -1) {
                    words.setText(words.getText().toString().replaceAll(" " + removeInput.getText().toString() + " ", ""));
                    defines.setText(defines.getText().toString().replaceAll(" " + defineList.get(i) + " ", ""));
                wordList.remove(i);
                defineList.remove(i);
                }
                else
                {
                    Toast.makeText(AddRemActivity.this, "Not in the Word List", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void wordListToHome()
    {
        Button toHome = (Button) findViewById(R.id.wordListMainButton);
        toHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddRemActivity.this, MainActivity.class));
            }
        });
    }

    private void wordListToStudy()
    {
        Button toStudy = (Button) findViewById(R.id.wordListStudyButton);
        toStudy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddRemActivity.this, StudyActivity.class);
                intent.putStringArrayListExtra(WORD_LIST, wordList);
                intent.putStringArrayListExtra(DEFINE_LIST, defineList);
                startActivity(intent);
            }
        });
    }
}