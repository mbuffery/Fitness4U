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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by miles on 4/16/2018.
 */

public class ProfileFragment extends Fragment {


    private EditText NameReg, AgeReg, SexReg
            , WeightReg, HeightReg, EmailReg, PasswordReg;

    private Button RegButton;

    private FirebaseAuth auth;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Gets the firebase Authenticator
        auth = FirebaseAuth.getInstance();

        NameReg = (EditText) getView().findViewById(R.id.nameReg);
        AgeReg = (EditText) getView().findViewById(R.id.ageReg);
        SexReg = (EditText) getView().findViewById(R.id.sexReg);
        WeightReg = (EditText) getView().findViewById(R.id.weightReg);
        HeightReg = (EditText) getView().findViewById(R.id.heightReg);
        EmailReg = (EditText) getView().findViewById(R.id.emailReg);
        PasswordReg = (EditText) getView().findViewById(R.id.passwordReg);

        //Button to register the user details
        RegButton = (Button) getView().findViewById(R.id.regButton);

        //
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        //Adds listener to the button
        RegButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.equals(RegButton))
                {
                    String user_id = auth.getCurrentUser().getUid();
                    DatabaseReference current
                }

            }
        });



    }
}
