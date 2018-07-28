package com.example.android.day8androidchallenge;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
SharedPreferences username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //You can pass the value from one to other activity using intent or using shared preferences.
        username= PreferenceManager.getDefaultSharedPreferences(this);
        String name=username.getString("username","default value");
        TextView textView=findViewById(R.id.text_view);
        Button button=findViewById(R.id.button);
        textView.setText("Welcome \n \n" +name);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
