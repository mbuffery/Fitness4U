package com.example.miles.fitness4u;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends Fragment {

    private Button signOut, RegButton;
    private EditText NameReg, AgeReg, SexReg, WeightReg, HeightReg, EmailReg, PasswordReg;
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

        //Creates instance to allow Read/Write for the data
        database = FirebaseDatabase.getInstance().getReference();

        //get firebase auth instance
        auth = FirebaseAuth.getInstance();

        //Gets the current User
        user = FirebaseAuth.getInstance().getCurrentUser();

        //If there is no user, it will go back to the login page in order to sign in
        if (auth.getCurrentUser() == null) {
            startActivity(new Intent(getActivity(), UserLoginActivity.class));
        }

        //Get reference for each view from the activity layout
        NameReg = getView().findViewById(R.id.nameReg);
        AgeReg = getView().findViewById(R.id.ageReg);
        SexReg = getView().findViewById(R.id.sexReg);
        WeightReg = getView().findViewById(R.id.weightReg);
        HeightReg = getView().findViewById(R.id.heightReg);
        EmailReg = getView().findViewById(R.id.emailReg);
        PasswordReg = getView().findViewById(R.id.passwordReg);
        RegButton = getView().findViewById(R.id.regButton);
        signOut = getView().findViewById(R.id.sign_out);

        //Gets the instance of the firebase database and gets the users data
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference userRef = database.getReference("Users");

        RegButton.setOnClickListener(new View.OnClickListener() {
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

                    //Creates new map to store each data post.
                    Map<String, String> newPost = new HashMap<String, String>();
                    newPost.put("Name", name);
                    newPost.put("Age", age);
                    newPost.put("Sex", sex);
                    newPost.put("Weight", weight);
                    newPost.put("Height", height);


                    //sets the value of the current user to newpost
                    curren_userdb.setValue(newPost);
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
            }


        }

    };

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








    /*
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
                                            Toast.makeText(getActivity(), "Password is updated, sign in with new password!", Toast.LENGTH_SHORT).show();
                                            signOut();
                                            progressBar.setVisibility(View.GONE);
                                        } else {
                                            Toast.makeText(getActivity(), "Failed to update password!", Toast.LENGTH_SHORT).show();
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
                startActivity(new Intent(getActivity(), NavDrawerActivity.class));
            }
        });*/

/*
        //On click, Sign the user out
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });



    }
/*
    @SuppressLint("SetTextI18n")
    private void setDataToView(FirebaseUser user) {

        email.setText("User Email: " + user.getEmail());

    }*/

    /*
    */

/*
    //sign out method
    public void signOut() {
        auth.signOut();
        *

/*
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
        };*/


/*
    @Override
    public void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }*/
/*
    */

/*
}
*/





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