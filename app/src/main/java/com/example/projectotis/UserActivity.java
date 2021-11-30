package com.example.projectotis;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;


public class UserActivity extends AppCompatActivity {
    Button btnLogOut;
    Button btnLawyerHire;
    ImageButton btnPicture;
    FirebaseAuth firebaseAuth;
    public int GET_FROM_GALLERY = 1;
    public int REQUEST_CODE = 1;
    public Uri selectedPic;
    private FirebaseAuth.AuthStateListener authStateListener;
    private static final int PICK_IMAGE = 100;
    Uri imageUri;
    ImageView userImage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        userImage = (ImageView) findViewById(R.id.displayUserImg);

        btnLogOut = (Button) findViewById(R.id.btnLogOut);
        btnLawyerHire = (Button) findViewById(R.id.btnProfile);
        btnPicture = (ImageButton) findViewById(R.id.btnAddUserImage);

        userImage.setVisibility(View.GONE);

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseAuth.getInstance().signOut();
                Intent I = new Intent(UserActivity.this, ActivityLogin.class);
                startActivity(I);

            }

        });

        btnLawyerHire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent I = new Intent(UserActivity.this, MainActivity.class);
                startActivity(I);

            }

        });

        btnPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openGallery();

                //startActivityForResult(new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI), GET_FROM_GALLERY);

                /*
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, GALLERY_REQUEST);
                --------
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"),REQUEST_CODE);


                 */



            }

        });


    }

    private void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        userImage.setVisibility(View.VISIBLE);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            //ImageView imgUser = (ImageView) findViewById(R.id.userPicture);
            imageUri = data.getData();
            userImage.setImageURI(imageUri);

            /*
            // Load an image using Picasso library
            Picasso.with(getApplicationContext())
                    .load("YOUR IMAGE URL")
                    .into(roundedimag);

            // Load an image using Glide library
            Glide.with(getApplicationContext())
                    .load("YOUR IMAGE URL")
                    .into(roundedimag);

             */

            TextView changedText = (TextView) findViewById(R.id.txtAddPicPls);
            changedText.setText("Change Picture");
        }
            }

    /**
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        ImageView imgUser = (ImageView) findViewById(R.id.userPicture);



        //Detects request codes
        if(requestCode==GET_FROM_GALLERY && resultCode == Activity.RESULT_OK) {
            Uri selectedImage = data.getData();
            selectedPic = selectedImage;

            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);
                imgUser.setImageBitmap(bitmap);


            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    **/
}
