package com.example.nora.learningfirebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserLogin extends AppCompatActivity {

    private static final String TAG ="" ;

    private EditText email;
    private EditText password;
    private Button signInButton;

    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    private String userId;
    String uemail;
    String upassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        signInButton=findViewById(R.id.signInButton);

        mFirebaseInstance=FirebaseDatabase.getInstance();
        mFirebaseDatabase=mFirebaseInstance.getReference().child("Users");

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                 uemail =email.getText().toString().trim();
                 upassword =password.getText().toString().trim();


                mFirebaseDatabase.addValueEventListener(new ValueEventListener() {
                 String databaseEmail;
                 String databasePassword;
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {


                        for (DataSnapshot messageSnapshot: dataSnapshot.getChildren()) {
                            databaseEmail = (String) messageSnapshot.child("email").getValue();
                            databasePassword = (String) messageSnapshot.child("password").getValue();
                        }

                            if (databaseEmail.equals(uemail) && databasePassword.equals(upassword)) {

                                Toast.makeText(getApplicationContext(), "login successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(view.getContext(), MainActivity.class);
                                startActivityForResult(intent, 0);
                            } else {

                                Toast.makeText(getApplicationContext(), "User not found", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(view.getContext(), UserLogin.class);
                                startActivityForResult(intent, 0);
                            }


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        setEmail(databaseError.toString());
                        setPassword(databaseError.toString());


                    }
                });

                    }
        });
    }// on create

    private void setEmail(String s) {
        email.setText(s);
    }

    private void setPassword(String s) {
        password.setText(s);
    }
    }//class closing

