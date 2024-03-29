package com.example.miles.fitness4u.AccountActivity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.miles.fitness4u.MainActivity;
import com.example.miles.fitness4u.NavDrawerActivity;
import com.example.miles.fitness4u.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserSignupActivity extends AppCompatActivity {

    private EditText inputEmail, inputPassword, inputName, inputWeight, inputHeight, inputAge, inputPref, inputGoal;
    private Button btnSignIn, btnSignUp, btnResetPassword;
    private ProgressBar progressBar;
    private FirebaseAuth auth;
    private DatabaseReference mDatabase;
    private static final String weightKG = "KG";
    private static final String heightM = "M";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_signup);
        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        btnSignIn = findViewById(R.id.sign_in_button);
        btnSignUp = findViewById(R.id.sign_up_button);
        inputEmail = findViewById(R.id.email);
        inputPassword = findViewById(R.id.password);
        progressBar = findViewById(R.id.progressBar);
        btnResetPassword = findViewById(R.id.btn_reset_password);

        inputName = findViewById(R.id.name);
        inputWeight = findViewById(R.id.weight);
        inputHeight = findViewById(R.id.height);
        inputAge = findViewById(R.id.age);
        inputGoal = findViewById(R.id.goal);
        inputPref = findViewById(R.id.preFitness);

        btnResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserSignupActivity.this, UserResetPasswordActivity.class));
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();
                final String name = inputName.getText().toString().trim();
                final String weight = inputWeight.getText().toString().trim();
                final String height = inputHeight.getText().toString().trim();
                final String age = inputAge.getText().toString().trim();
                final String goal = inputGoal.getText().toString().trim();
                final String prefitness = inputPref.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(getApplicationContext(), "Enter Name Please!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(weight)) {
                    Toast.makeText(getApplicationContext(), "Enter Weight Please!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(height)) {
                    Toast.makeText(getApplicationContext(), "Enter Height Please!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(age)) {
                    Toast.makeText(getApplicationContext(), "Enter Age Please!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(goal)) {
                    Toast.makeText(getApplicationContext(), "Enter Goal please", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(prefitness)) {
                    Toast.makeText(getApplicationContext(), "Enter Preferred fitness", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                //create user
                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(UserSignupActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(UserSignupActivity.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    Toast.makeText(UserSignupActivity.this, "Authentication failed." + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    startActivity(new Intent(UserSignupActivity.this, NavDrawerActivity.class));

                                    //Uses the information that the user inputs and saves it onto the firebase database

                                    mDatabase.child("Users").child(task.getResult().getUser().getUid()).child("name").setValue(name);
                                    mDatabase.child("Users").child(task.getResult().getUser().getUid()).child("weight").setValue(weight);
                                    mDatabase.child("Users").child(task.getResult().getUser().getUid()).child("height").setValue(height);
                                    mDatabase.child("Users").child(task.getResult().getUser().getUid()).child("age").setValue(age);
                                    mDatabase.child("Users").child(task.getResult().getUser().getUid()).child("preferred").setValue(prefitness);
                                    mDatabase.child("Users").child(task.getResult().getUser().getUid()).child("goal").setValue(goal);
                                    finish();
                                }
                            }
                        });

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }
}
