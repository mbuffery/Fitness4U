package com.example.miles.fitness4u;

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


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Creates instance to allow Read/Write for the data
        database = FirebaseDatabase.getInstance().getReference();

        //Gets firebase Authenticator
        auth = FirebaseAuth.getInstance();

        //Gets the current User
        user = FirebaseAuth.getInstance().getCurrentUser();
/*
        //Sets references to each item in the activity
        final TextView heightView = getView().findViewById(R.id.profHeight);
        final TextView ageView = getView().findViewById(R.id.profAge);
        final TextView weightView = getView().findViewById(R.id.profWeight);
        final TextView nameView = getView().findViewById(R.id.userName);

        //Gets the instance of the firebase database and gets the users data
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference userRef = database.getReference("Users");

        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //Gets and sets the user ID to a string
                String user_id = user.getUid();

                //Gets the specific data from the Database
                String ageText = (String) dataSnapshot.child(user_id).child("Age").getValue();
                String weightText = (String) dataSnapshot.child(user_id).child("Weight").getValue();
                String heightText = (String) dataSnapshot.child(user_id).child("Height").getValue();
                String nameText = (String) dataSnapshot.child(user_id).child("Name").getValue();

                //Displays the selected data to the Textviews in the activity
                ageView.setText(ageText);
                weightView.setText(weightText);
                heightView.setText(heightText);
                nameView.setText(nameText);

                startActivity(new Intent(getActivity(), NavDrawerActivity.class));
                getActivity().finish();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                ageView.setText("Error Found");
                weightView.setText("Error Found");
                heightView.setText("Error Found");
                nameView.setText("Error Found");

            }
        });*/


    }
}


