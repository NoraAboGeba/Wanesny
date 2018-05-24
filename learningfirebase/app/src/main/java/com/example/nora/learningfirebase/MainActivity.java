package com.example.nora.learningfirebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.EventListener;

public class MainActivity extends AppCompatActivity implements EventListener{

    private TextView welcomeText;
    private Button registerButton,loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        welcomeText =findViewById(R.id.welcomeText);

        registerButton=findViewById(R.id.registerButton);
        loginButton=findViewById(R.id.loginButton);




        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent =new Intent(view.getContext(),Registrition.class);
                startActivityForResult(intent,0);

               }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(view.getContext(),UserLogin.class);
                startActivityForResult(intent,0);

            }
        });

    }




}// class closing
