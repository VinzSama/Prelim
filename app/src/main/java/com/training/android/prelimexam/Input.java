package com.training.android.prelimexam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Input extends AppCompatActivity {

    private EditText mEtTitle,mEtDesc,mEtTime,mEtDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        mEtTitle = (EditText) findViewById(R.id.etTitle);
        mEtDesc = (EditText) findViewById(R.id.etDesc);
        mEtTime = (EditText) findViewById(R.id.etTime);
        mEtDate = (EditText) findViewById(R.id.etDate);

        Task task = new Task(mEtTitle.getText().toString(),mEtDesc.getText().toString(), mEtTime.toString(), mEtDate.toString());

    }
}
