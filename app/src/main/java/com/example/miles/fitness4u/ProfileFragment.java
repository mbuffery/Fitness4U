package com.example.miles.fitness4u;

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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by miles on 4/16/2018.
 */

public class ProfileFragment extends Fragment {


    private EditText NameReg, AgeReg, SexReg
            , WeightReg, HeightReg, EmailReg, PasswordReg;

    private Button RegButton;
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




        //Sets references to each item in the activity
        final TextView heightView =  getView().findViewById(R.id.profHeight);
        final TextView ageView =  getView().findViewById(R.id.profAge);
        final TextView weightView =  getView().findViewById(R.id.profWeight);

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

                //Displays the selected data to the Textviews in tbe activity
                ageView.setText(ageText);
                weightView.setText(weightText);
                heightView.setText(heightText);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                ageView.setText("Error Found");
                weightView.setText("Error Found");
                heightView.setText("Error Found");

            }
        });






    }
}
//Adds listener to the button*/

//When button is pressed, it saves all the data onto the database, e.g. Sex

// if (v.equals(RegButton))
//  {
                    /*String user_id = auth.getCurrentUser().getUid();
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
                    curren_userdb.setValue(newPost);*/


//}
/* //Sets each edit text to a variable
        NameReg = (EditText) getView().findViewById(R.id.nameReg);
        AgeReg = (EditText) getView().findViewById(R.id.ageReg);
        SexReg = (EditText) getView().findViewById(R.id.sexReg);
        WeightReg = (EditText) getView().findViewById(R.id.weightReg);
        HeightReg = (EditText) getView().findViewById(R.id.heightReg);
        EmailReg = (EditText) getView().findViewById(R.id.emailReg);
        PasswordReg = (EditText) getView().findViewById(R.id.passwordReg);*/

//Button to register the user details
//RegButton = (Button) getView().findViewById(R.id.regButton);