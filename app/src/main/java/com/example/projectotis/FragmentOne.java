package com.example.projectotis;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
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
import androidx.viewpager.widget.ViewPager;

import com.example.projectotis.databinding.ActivityMainBinding;
import com.example.projectotis.databinding.FragmentOneBinding;
import com.example.projectotis.main.SectionsPagerAdapter;
import com.example.projectotis.main.SectionsPagerAdapterInnerFrags;
import com.example.projectotis.main.SectionsPagerAdapterInnerFrags1;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FragmentOne extends Fragment {

    //private ActivityMainBinding binding;
    private FragmentOneBinding binding;


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

    private final Handler handler = new Handler();
    private Runnable runPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_one, container, false);

        /*
        binding = FragmentOneBinding.inflate(getLayoutInflater());
        //binding = inflater.inflate(R.layout.fragment_one, container, false);
        //View view = binding.getRoot();

        SectionsPagerAdapterInnerFrags1 sectionsPagerAdapterInnerFrags1 = new SectionsPagerAdapterInnerFrags1(this, getFragmentManager());
        ViewPager viewPagerInnerFrags = binding.viewPagerInnerFragOne;
        viewPagerInnerFrags.setAdapter(sectionsPagerAdapterInnerFrags1);


         */


        return root;
        //return view;




    }

/*
    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        runPager = new Runnable() {

            @Override
            public void run()
            {
                getFragmentManager().beginTransaction().add(R.id.view_pager_inner_FragOne, FragmentOne.newInstance()).commit();
                getFragmentManager().beginTransaction().add(R.id.view_pager_inner_FragTwo, FragmentOne.newInstance()).commit();
                //getFragmentManager().beginTransaction().add(R.id.view_pager_inner_FragThree, FragmentOne.newInstance()).commit();

            }
        };
        handler.post(runPager);
    }

    public static FragmentOne newInstance() {
        return new FragmentOne();
    }


    @Override
    public void onPause()
    {
        super.onPause();
        handler.removeCallbacks(runPager);
    }


 */


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
