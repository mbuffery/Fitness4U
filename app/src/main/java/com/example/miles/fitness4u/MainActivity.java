package com.example.miles.fitness4u;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miles.fitness4u.AccountActivity.UserLoginActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends Fragment {

    private Button signOut, RegButton, changePass;
    private EditText AgeReg ,GoalReg, WeightReg, HeightReg, repeatPass, newPass;
    private TextView email;
    private FirebaseAuth auth;
    private DatabaseReference database;
    private FirebaseUser user;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.activity_main, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        email = getView().findViewById((R.id.useremail));

        //Creates instance to allow Read/Write for the data
        database = FirebaseDatabase.getInstance().getReference();

        //get firebase auth instance
        auth = FirebaseAuth.getInstance();

        //Gets the current User
        user = FirebaseAuth.getInstance().getCurrentUser();
        setDataToView(user);

        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    // user auth state is changed - user is null
                    // launch login activity
                    startActivity(new Intent(getActivity(), UserLoginActivity.class));
                    getActivity().finish();
                }
            }
        };



        //If there is no user, it will go back to the login page in order to sign in
        if (auth.getCurrentUser() == null) {
            startActivity(new Intent(getActivity(), UserLoginActivity.class));
        }

        //Get reference for each view from the activity layout

        AgeReg = getView().findViewById(R.id.ageReg);
        WeightReg = getView().findViewById(R.id.weightReg);
        HeightReg = getView().findViewById(R.id.heightReg);
        GoalReg = getView().findViewById(R.id.goalReg);
        changePass = getView().findViewById(R.id.changePassword);
        RegButton = getView().findViewById(R.id.regButton);
        signOut = getView().findViewById(R.id.sign_out);
        repeatPass = getView().findViewById(R.id.repeatPassword);
        newPass = getView().findViewById(R.id.password1);



        //Gets the instance of the firebase database and gets the users data
        //final FirebaseDatabase database = FirebaseDatabase.getInstance();
        //DatabaseReference userRef = database.getReference("Users");

        changePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //If textview not empty
                if (!newPass.getText().toString().isEmpty() && !newPass.getText().toString().isEmpty()) {

                    //if new password and repeat password are the same
                   if (newPass.getText().toString().trim().equals(newPass.getText().toString().trim())) {

                        // if user is not null and equals 6 characters
                        if (user != null && !newPass.getText().toString().trim().equals("")) {
                            //if password is less than 6 characters
                            if (newPass.getText().toString().trim().length() < 6)
                            {
                                newPass.setError("Password too short, enter minimum 6 characters");
                            } else
                                {

                                user.updatePassword(newPass.getText().toString().trim()).addOnCompleteListener(new OnCompleteListener<Void>()
                                        {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task)
                                            {
                                                if (task.isSuccessful())
                                                {
                                                    Toast.makeText(getActivity(), "Password is updated, sign in with new password!", Toast.LENGTH_SHORT).show();
                                                    auth.signOut();
                                                } else
                                                    {
                                                    Toast.makeText(getActivity(), "Failed to update password!", Toast.LENGTH_SHORT).show();

                                                }
                                            }
                                        });
                            }
                        } else if (newPass.getText().toString().trim().equals(""))
                        {
                            newPass.setError("Enter password");

                        }
                    } else
                        {
                        Toast.makeText(getActivity(), "The passwords are not the same", Toast.LENGTH_SHORT).show();
                    }
                }else
                {
                    Toast.makeText(getActivity(), "Password field can't be empty", Toast.LENGTH_SHORT).show();
                }
            }
        });

        RegButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.equals(RegButton)) {

                    final String weight = WeightReg.getText().toString().trim();
                    final String height = HeightReg.getText().toString().trim();
                    final String age = AgeReg.getText().toString().trim();
                    final String goal = GoalReg.getText().toString().trim();

                    if (TextUtils.isEmpty(weight)) {
                        Toast.makeText(getActivity().getApplicationContext(), "Enter Weight Please!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (TextUtils.isEmpty(height)) {
                        Toast.makeText(getActivity().getApplicationContext(), "Enter Height Please!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (TextUtils.isEmpty(age)) {
                        Toast.makeText(getActivity().getApplicationContext(), "Enter Age Please!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (TextUtils.isEmpty(goal)) {
                        Toast.makeText(getActivity().getApplicationContext(), "Enter Goal please", Toast.LENGTH_SHORT).show();
                        return;
                    }


                    database.child("Users").child(user.getUid()).child("weight").setValue(weight);
                    database.child("Users").child(user.getUid()).child("height").setValue(height);
                    database.child("Users").child(user.getUid()).child("age").setValue(age);
                    database.child("Users").child(user.getUid()).child("goal").setValue(goal);



                    Toast.makeText(getActivity(), "Update Completed", Toast.LENGTH_SHORT).show();
                }
            }


        });

        //On click, Sign the user out
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signOut();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void setDataToView(FirebaseUser user) {

        email.setText("Email: " + user.getEmail());

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
                startActivity(new Intent(getActivity(), UserLoginActivity.class));
                getActivity().finish();
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
                    startActivity(new Intent(getActivity(), UserLoginActivity.class));
                    getActivity().finish();
                }
            }
        };
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

