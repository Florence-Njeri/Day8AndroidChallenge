package com.example.android.day8androidchallenge;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

SharedPreferences logInPreferences;
    SharedPreferences.Editor logInEditor;
EditText username,password;
Button logIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        logIn=findViewById(R.id.log_in);

        //Create a shared preference object and initialize/instantiate it
        logInPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        //The editor is used to save the shared preference's information on Commit() or apply()
         logInEditor=logInPreferences.edit();
         logInEditor.putString("username","Lydiah");//Set username in preference
         logInEditor.putString("password","Flozzy");//Set password in preference
         logInEditor.apply();//saves the information to the shared preference object

      logIn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
//Retrieve data from preference
              SharedPreferences prefs=logInPreferences;//These object contains the values of the shared preferences
              String name=prefs.getString("username","");//gets the username stored in shared preference
              String pass=prefs.getString("password","");//gets the password stored in the shared preferences
              String uName=username.getText().toString();
              String pWord= password.getText().toString();
              if(uName.trim().length()==0){
                  username.setError("Username required");
                  username.requestFocus();
                  if(pWord.trim().length()==0){
                      password.setError("Password required");
                      password.requestFocus();
                  }
              }

             else if(!uName.equals(name)){
                  username.setError("Username mismatch");
                  username.requestFocus();
                  if(!pWord.equals(pass)){
                      password.setError("Password mismatch");
                      password.requestFocus();
                  }
              }

if(uName.equals(name)&&pWord.equals(pass)){
    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
    startActivity(intent);
}
          }
      });
    }

}
