package com.ganeshnomula.food;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

//import com.ganeshnomula.food.Model.User;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Type;

public class SignIn extends AppCompatActivity {

    TextView t; //signintitle
    Button btnSignIn;
    EditText edtPhonenum, edtPassword;
//    FirebaseDatabase db;
//    DatabaseReference users;



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        t = findViewById(R.id.signInTitle);
        btnSignIn = findViewById(R.id.btnSignIn);
        edtPhonenum = findViewById(R.id.edtPhonenum);
        edtPassword = findViewById(R.id.edtPassword);

        //changing the type face of the heading in the sign in page
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Thin.ttf");
        t.setTypeface(typeface);

        //Init Firebase database

//        db = FirebaseDatabase.getInstance();
//        users = db.getReference("User");
//
//
//        //Setting up onclick listener when sign in button is pressed.
//
//        btnSignIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                //ProgressBar mProgress = new ProgressBar(getApplicationContext());
//                final ProgressDialog mDialog = new ProgressDialog(SignIn.this);
//                mDialog.setMessage("Please Wait!");
//                mDialog.show();
//                //This is about changing values into the table, if the table_user exists in the database then the following thing executes
//                users.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//
//                        /* Check whether the user is present in the database or not */
//
//                        if (dataSnapshot.child(edtPhonenum.getText().toString()).exists()){
//
//                            /* Get User Information */
//                            mDialog.dismiss();
//                            User user = dataSnapshot.child(edtPhonenum.getText().toString()).getValue(User.class);
//
//                            if(user.getPassword().equals(edtPassword.getText().toString())  ){
//
//                                if(user.getUsertype().equals("customer")){
//                                    Intent userLandingPage = new Intent(SignIn.this, WelcomeUser.class);
//                                    startActivity(userLandingPage);
//                                    Toast.makeText(SignIn.this,"Here's user layout", Toast.LENGTH_SHORT).show();
//                                } else {
//                                    Intent vendorLandingPage = new Intent(SignIn.this, WelcomeVendor.class);
//                                    startActivity(vendorLandingPage);
//                                    Toast.makeText(SignIn.this,"Here's vendor Layout", Toast.LENGTH_SHORT).show();
//                                }
//
//                            } else {
//
//                                Toast.makeText(SignIn.this,"Wrong Phone number / Password", Toast.LENGTH_SHORT).show();
//                            }
//
//                        } else {
//                            mDialog.dismiss();
//                            Toast.makeText(SignIn.this, "User Doesn't exist in the database", Toast.LENGTH_SHORT).show();
//
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError databaseError) {
//
//                    }
//                });
//
//
//            }
//        });
    }

}
