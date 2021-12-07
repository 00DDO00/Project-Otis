package com.example.projectotis;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FragmentOneInnerTest extends Fragment {

    ImageView img;

    Spinner spinner;
    String[] services = {"Legal Counseling", "Mortgage Counseling", "Legal Terminology", "Individual and Group Counseling", "Legal Submissions", "Legal Codes",};

    // creating a variable for
    // our Firebase Database.
    FirebaseDatabase firebaseDatabase;

    // creating a variable for our
    // Database Reference for Firebase.
    private DatabaseReference databaseReference;
    private DatabaseReference databaseReferenceSub;
    private DatabaseReference databaseReferenceName;
    private DatabaseReference databaseReferenceNameSub;
    public DatabaseReference databaseReference2;
    public DatabaseReference databaseReferenceName2;
    public DatabaseReference databaseReference3;
    public DatabaseReference databaseReferenceName3;

    private TextView lawyerInfoDatabase;
    private TextView lawyerNameDatabase;

    public TextView lawyerInfoDatabase2;
    public TextView lawyerNameDatabase2;

    public TextView lawyerInfoDatabase3;
    public TextView lawyerNameDatabase3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_one, container, false);
        //View rootView = inflater.inflate(R.layout.fragment_one, container, false);

        // Database get and setText code
        // below line is used to get the instance
        // of our Firebase database.
        firebaseDatabase = FirebaseDatabase.getInstance();


        // below line is used to get the database reference.

        databaseReference = firebaseDatabase.getReference("TutorData").child("Data1");
        databaseReferenceName = firebaseDatabase.getReference("TutorName").child("Name1");

        //databaseReference = firebaseDatabase.getReference("Data");
        //databaseReferenceName = firebaseDatabase.getReference("Name1");




        /*
        databaseReference = firebaseDatabase.getReference("Data");
        databaseReferenceName = firebaseDatabase.getReference("Name1");

         */



        //databaseReference2 = firebaseDatabase.getReference("Data2");
        //databaseReferenceName2 = firebaseDatabase.getReference("Name2");
/*
         databaseReference3 = firebaseDatabase.getReference("Data3");
         databaseReferenceName3 = firebaseDatabase.getReference("Name3");

          */


        // initializing our object class variable.
        lawyerInfoDatabase = root.findViewById(R.id.lawyerInfo1);
        lawyerNameDatabase = root.findViewById(R.id.lawyer1Name);

         /*
         lawyerInfoDatabase2 = root.findViewById(R.id.lawyerInfo2);
         lawyerNameDatabase2 = root.findViewById(R.id.lawyer2Name);

         lawyerInfoDatabase3 = root.findViewById(R.id.lawyerInfo3);
         lawyerNameDatabase3 = root.findViewById(R.id.lawyer3Name);

          */

        // calling method
        // for getting data.
        getdata();


        img = (ImageView) root.findViewById(R.id.lawyerPhoto1);


        Drawable myDrawable = ResourcesCompat.getDrawable(getResources(), R.drawable.rory, null);

        img.setImageDrawable(myDrawable);

        spinner = (Spinner) root.findViewById(R.id.optionsList1);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, services);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //apply the adapter to the spinner
        spinner.setAdapter(adapter);



        //return inflater.inflate(R.layout.fragment_one, container, false);

        return root;





    }



    //Get Firebase data function
    private void getdata() {

        // calling add value event listener method
        // for getting the values from database.
        //Gets the Data attribute with its value belonging to this lawyer(1st one)
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // this method is call to get the realtime
                // updates in the data.
                // this method is called when the data is
                // changed in our Firebase console.
                // below line is for getting the data from
                // snapshot of our database.
                String value = snapshot.getValue(String.class);

                // after getting the value we are setting
                // our value to our text view in below line.
                lawyerInfoDatabase.setText(value);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // calling on cancelled method when we receive
                // any error or we are not able to get the data.
                //Toast.makeText(MainActivity.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }


        });

        //Gets the Name attribute with its value belonging to this lawyer(1st one)
        databaseReferenceName.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // this method is called to get the realtime
                // updates in the data.
                // this method is called when the data is
                // changed in our Firebase console.
                // below line is for getting the data from
                // snapshot of our database.
                String value = snapshot.getValue(String.class);

                // after getting the value we are setting
                // our value to our text view in below line.
                lawyerNameDatabase.setText(value);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // calling on cancelled method when we receive
                // any error or we are not able to get the data.
                //Toast.makeText(MainActivity.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }


        });
/*

        databaseReference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // this method is call to get the realtime
                // updates in the data.
                // this method is called when the data is
                // changed in our Firebase console.
                // below line is for getting the data from
                // snapshot of our database.
                String value = snapshot.getValue(String.class);

                // after getting the value we are setting
                // our value to our text view in below line.
                lawyerInfoDatabase2.setText(value);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // calling on cancelled method when we receive
                // any error or we are not able to get the data.
                //Toast.makeText(FragmentOne.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }


        });


        //Gets the Name attribute with its value belonging to this lawyer(2nd one)
        databaseReferenceName2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // this method is called to get the realtime
                // updates in the data.
                // this method is called when the data is
                // changed in our Firebase console.
                // below line is for getting the data from
                // snapshot of our database.
                String value = snapshot.getValue(String.class);

                // after getting the value we are setting
                // our value to our text view in below line.
                lawyerNameDatabase2.setText(value);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // calling on cancelled method when we receive
                // any error or we are not able to get the data.
                //Toast.makeText(MainActivity.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }


        });



        databaseReference3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // this method is call to get the realtime
                // updates in the data.
                // this method is called when the data is
                // changed in our Firebase console.
                // below line is for getting the data from
                // snapshot of our database.
                String value = snapshot.getValue(String.class);

                // after getting the value we are setting
                // our value to our text view in below line.
                lawyerInfoDatabase3.setText(value);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // calling on cancelled method when we receive
                // any error or we are not able to get the data.
                //Toast.makeText(MainActivity.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }


        });


        //Gets the Name attribute with its value belonging to this lawyer(3rd one)
        databaseReferenceName3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // this method is called to get the realtime
                // updates in the data.
                // this method is called when the data is
                // changed in our Firebase console.
                // below line is for getting the data from
                // snapshot of our database.
                String value = snapshot.getValue(String.class);

                // after getting the value we are setting
                // our value to our text view in below line.
                lawyerNameDatabase3.setText(value);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // calling on cancelled method when we receive
                // any error or we are not able to get the data.
                //Toast.makeText(MainActivity.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }


        });

         */


    }


}
