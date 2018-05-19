package com.example.miles.fitness4u;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.miles.fitness4u.AccountActivity.UserLoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by miles on 4/16/2018.
 */

public class ProfileFragment extends Fragment {

    private DatabaseReference database;
    private FirebaseAuth auth;
    private FirebaseUser user;
    private TextView heightView, ageView, weightView, nameView, prefView, goalView, email;
    private static final String heightM = "M";
    private static final String weight = "KG";

    //final FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_profile, container, false);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        auth = FirebaseAuth.getInstance();

        //Gets the instance of the firebase database and gets the users data
        database = FirebaseDatabase.getInstance().getReference();

        if (auth.getCurrentUser() == null)
        {
            startActivity(new Intent(getActivity(), UserLoginActivity.class));
        }

        final FirebaseDatabase fDatabase = FirebaseDatabase.getInstance();
        DatabaseReference userRef = fDatabase.getReference("Users");

        user = FirebaseAuth.getInstance().getCurrentUser();

        //Gets references to each item in the activity
        heightView = getView().findViewById(R.id.profHeight);
        ageView = getView().findViewById(R.id.profAge);
        weightView = getView().findViewById(R.id.profWeight);
        nameView = getView().findViewById(R.id.userName);
        prefView = getView().findViewById(R.id.PrefView);
        goalView = getView().findViewById(R.id.GoalView);
        email = getView().findViewById((R.id.useremail));

        user = FirebaseAuth.getInstance().getCurrentUser();
        setDataToView(user);

        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //Gets and sets the user ID to a string
                String user_id = user.getUid();

                //Gets the specific data from the Database
                String ageText = (String) dataSnapshot.child(user_id).child("age").getValue();
                String weightText = (String) dataSnapshot.child(user_id).child("weight").getValue();
                String heightText = (String) dataSnapshot.child(user_id).child("height").getValue();
                String nameText = (String) dataSnapshot.child(user_id).child("name").getValue();
                String goalText = (String) dataSnapshot.child(user_id).child("goal").getValue();
                String prefText = (String) dataSnapshot.child(user_id).child("preferred").getValue();

                //Displays the selected data to the Textviews in the activity
                ageView.setText(ageText);
                weightView.setText(weightText + weight);
                heightView.setText(heightText + heightM);
                nameView.setText(nameText);
                prefView.setText(prefText);
                goalView.setText(goalText);



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                ageView.setText("Error Found");
                weightView.setText("Error Found");
                heightView.setText("Error Found");
                nameView.setText("Error Found");
                goalView.setText("Error Found");
                prefView.setText("Error Found");

            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void setDataToView(FirebaseUser user) {

        email.setText("Email: " + user.getEmail());

    }

}



