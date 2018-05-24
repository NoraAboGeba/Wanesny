package com.example.nora.learningfirebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.EventListener;

public class Registrition extends AppCompatActivity implements EventListener {

    private EditText usernameText,emailText,phoneText,passwordText,conpasswordText,ssnText;
    private Button button;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrition);
        usernameText =findViewById(R.id.usernameText);
        emailText=findViewById(R.id.emailText);
        phoneText=findViewById(R.id.phoneText);
        passwordText=findViewById(R.id.passwordText);
        conpasswordText=findViewById(R.id.conpasswordText);
        ssnText=findViewById(R.id.ssnText);
        button=findViewById(R.id.button);

        databaseReference= FirebaseDatabase.getInstance().getReference().child("Users");


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                saveData();
                Intent intent =new Intent(view.getContext(),UserLogin.class);
                startActivityForResult(intent,0);

            }
        });


    }


    ////////////////////////registration
    void saveData(){
        String name= usernameText.getText().toString().trim();
        String email= emailText.getText().toString().trim();
        String mobile=phoneText.getText().toString().trim();
        String passwd=passwordText.getText().toString().trim();
        String conpasswd=conpasswordText.getText().toString().trim();
        String identity=ssnText.getText().toString().trim();



        //validation for registerition form
        if(isEmailValid(email)&&passwd.contentEquals(conpasswd)&&isPasswordValid(passwd)&&isSsnValid(identity)){

            // Toast.makeText(getApplicationContext(), "correct",Toast.LENGTH_LONG).show();
            //saving data in firebase
            Data data = new Data(name,email, mobile,passwd,conpasswd,identity);
            Log.i("hell","data");

            databaseReference.push().setValue(data);
            Toast.makeText(this, "Register successfully ", Toast.LENGTH_SHORT).show();
        }

        if(TextUtils.isEmpty(email)){
            emailText.setError("this field is empty");

        }
        else if(!isEmailValid(email)) {

            emailText.setError("invalid syntax");
        }

        if(!TextUtils.isEmpty(mobile) && !isPhoneValid(mobile)){
            phoneText.setError("mobile should be 11 number");
        }
        if (!TextUtils.isEmpty(passwd) && !isPasswordValid(passwd)) {
            passwordText.setError("this password is too short");

        }
        if(!TextUtils.isEmpty(identity) && !isSsnValid(identity)){

            ssnText.setError("identy shoud be 14 number");
        }
        if(!passwd.equals(conpasswd)){

            conpasswordText.setError("password not the same");
        }
        else {

            Toast.makeText(getApplicationContext(), "please,enter correct inputs", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String passwd) {
        //TODO: Replace this with your own logic
        return passwd.length() > 5;
    }

    private  boolean isSsnValid(String identity){

        return  identity.length()==14;
    }
    private  boolean isPhoneValid(String mobile){

        return  mobile.length()==11;
    }




}// class closing
