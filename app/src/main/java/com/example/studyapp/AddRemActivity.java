package com.example.studyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddRemActivity extends AppCompatActivity {
    EditText wordInput;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_rem);

        wordInput = (EditText) findViewById(R.id.wordInput);
        wordListToHome();
        wordListToStudy();

        addButton = (Button) findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //word = wordInput.getText().toString();
                Intent intent = new Intent(AddRemActivity.this, AddRemActivity.class);
                intent.putExtra(wordInput.getText().toString(), "apple");
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
                startActivity(new Intent(AddRemActivity.this, StudyActivity.class));
            }
        });
    }
}