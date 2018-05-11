package com.example.miles.fitness4u;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miles.fitness4u.AccountActivity.UserLoginActivity;
import com.example.miles.fitness4u.AccountActivity.UserSignupActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Button btnChangePassword, btnRemoveUser,
            changePassword, remove, signOut, backBtn, RegButton;
    private TextView email;
    private EditText NameReg, AgeReg, SexReg, WeightReg, HeightReg, EmailReg, PasswordReg;
    private EditText oldEmail, password, newPassword;
    private ProgressBar progressBar;
    private FirebaseAuth auth;
    private DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get firebase auth instance
        auth = FirebaseAuth.getInstance();
        email = findViewById(R.id.useremail);

        //Button to register the user details
        RegButton = findViewById(R.id.regButton);


        NameReg = findViewById(R.id.nameReg);
        AgeReg = findViewById(R.id.ageReg);
        SexReg = findViewById(R.id.sexReg);
        WeightReg = findViewById(R.id.weightReg);
        HeightReg = findViewById(R.id.heightReg);

        //Gets the current firebase user
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        setDataToView(user);

        //Creates instance to allow Read/Write for the data
        database = FirebaseDatabase.getInstance().getReference();

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference userRef = database.getReference("Users");

        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    // user auth state is changed - user is null
                    // launch login activity
                    startActivity(new Intent(MainActivity.this, UserLoginActivity.class));
                    finish();
                }
            }
        };

        if (user == null) {
            //If no signed in, launch the Sign In activity
            startActivity(new Intent(this, UserLoginActivity.class));
            finish();
            return;
        }

        //On create, Set each variable to the right ID.
        btnChangePassword = findViewById(R.id.change_password_button);
        //btnRemoveUser = findViewById(R.id.remove_user_button);
        changePassword = findViewById(R.id.changePass);
        //remove = findViewById(R.id.remove);
        signOut = findViewById(R.id.sign_out);
        backBtn = findViewById(R.id.back_btn);
        //oldEmail = findViewById(R.id.old_email);
        password = findViewById(R.id.password);
        newPassword = findViewById(R.id.newPassword);

        //On create, sets the visibility to gone so they cant be seen.
        //oldEmail.setVisibility(View.GONE);
        password.setVisibility(View.GONE);
        newPassword.setVisibility(View.GONE);
        changePassword.setVisibility(View.GONE);
        //remove.setVisibility(View.GONE);
        progressBar = findViewById(R.id.progressBar);
        if (progressBar != null) {
            progressBar.setVisibility(View.GONE);
        }

        //If the user wants to change their password, on click will set the different variable to either visible or hidden
        btnChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //oldEmail.setVisibility(View.GONE);

                password.setVisibility(View.GONE);
                newPassword.setVisibility(View.VISIBLE);

                changePassword.setVisibility(View.VISIBLE);

                remove.setVisibility(View.GONE);
            }
        });



        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                //Sets the new password if the user has met all the requirements, e.g. 6 or more characters
                if (user != null && !newPassword.getText().toString().trim().equals("")) {
                    if (newPassword.getText().toString().trim().length() < 6) {
                        newPassword.setError("Password too short, enter minimum 6 characters");
                        progressBar.setVisibility(View.GONE);
                    } else {
                        user.updatePassword(newPassword.getText().toString().trim())
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(MainActivity.this, "Password is updated, sign in with new password!", Toast.LENGTH_SHORT).show();
                                            signOut();
                                            progressBar.setVisibility(View.GONE);
                                        } else {
                                            Toast.makeText(MainActivity.this, "Failed to update password!", Toast.LENGTH_SHORT).show();
                                            progressBar.setVisibility(View.GONE);
                                        }
                                    }
                                });
                    }
                } else if (newPassword.getText().toString().trim().equals("")) {
                    newPassword.setError("Enter password");
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
        //Simple back button
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, NavDrawerActivity.class));
            }
        });

        /*RegButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.equals(RegButton)) {

                    String user_id = auth.getCurrentUser().getUid();
                    DatabaseReference curren_userdb = FirebaseDatabase.getInstance().getReference().child("Users").child(user_id);

                    //Sets each variable to a specific string
                    String name = NameReg.getText().toString();
                    String age = AgeReg.getText().toString();
                    String sex = SexReg.getText().toString();
                    String weight = WeightReg.getText().toString();
                    String height = HeightReg.getText().toString();
                    String email = EmailReg.getText().toString();
                    String password = PasswordReg.getText().toString();

                    //Creates new map to store each data post.
                    Map newPost = new HashMap();
                    newPost.put("Name", name);
                    newPost.put("Age", age);
                    newPost.put("Sex", sex);
                    newPost.put("Weight", weight);
                    newPost.put("Height", height);
                    newPost.put("Email", email);
                    newPost.put("Password", password);

                    //sets the value of the current user to newpost
                    curren_userdb.setValue(newPost);
                }
            }


        });*/


        //This will remove the user on click
        /*btnRemoveUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                if (user != null) {
                    user.delete()
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(MainActivity.this, "Your profile is deleted:( Create a account now!", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(MainActivity.this, UserSignupActivity.class));
                                        finish();
                                        progressBar.setVisibility(View.GONE);
                                    } else {
                                        Toast.makeText(MainActivity.this, "Failed to delete your account!", Toast.LENGTH_SHORT).show();
                                        progressBar.setVisibility(View.GONE);
                                    }
                                }
                            });
                }
            }
        });
        */
        //On click, Sign the user out
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });

    }

    @SuppressLint("SetTextI18n")
    private void setDataToView(FirebaseUser user) {

        email.setText("User Email: " + user.getEmail());

    }

    // this listener will be called when there is change in firebase user session
    FirebaseAuth.AuthStateListener authListener = new FirebaseAuth.AuthStateListener() {
        @SuppressLint("SetTextI18n")
        @Override
        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
            FirebaseUser user = firebaseAuth.getCurrentUser();
            if (user == null) {
                // user auth state is changed - user is null
                // launch login activity
                startActivity(new Intent(MainActivity.this, UserLoginActivity.class));
                finish();
            } else {
                setDataToView(user);

            }
        }

    };

    //sign out method
    public void signOut() {
        auth.signOut();


// this listener will be called when there is change in firebase user session
        FirebaseAuth.AuthStateListener authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    // user auth state is changed - user is null
                    // launch login activity
                    startActivity(new Intent(MainActivity.this, UserLoginActivity.class));
                    finish();
                }
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onStart() {
        super.onStart();
        auth.addAuthStateListener(authListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (authListener != null) {
            auth.removeAuthStateListener(authListener);
        }
    }
}