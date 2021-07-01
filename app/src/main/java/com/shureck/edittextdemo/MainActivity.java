package com.shureck.edittextdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SaveInPref saveInPref;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveInPref = new SaveInPref(getApplicationContext());

        EditText editName = findViewById(R.id.editTextTextPersonName);
        EditText editDate = findViewById(R.id.editTextTextPersonName2);
        textView = findViewById(R.id.textView);
        Button button = findViewById(R.id.button);

        refreshTextView(textView);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveInPref.saveText("name",editName.getText().toString());
                saveInPref.saveText("date",editDate.getText().toString());
                refreshTextView(textView);
            }
        });
    }


    public void refreshTextView(TextView textView){
        textView.setText("name: "+saveInPref.readText("name")+"\n"+"date: "+saveInPref.readText("date"));
    }
}