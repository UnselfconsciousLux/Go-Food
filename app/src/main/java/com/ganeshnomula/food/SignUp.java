package com.ganeshnomula.food;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.ganeshnomula.food.Model.User;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SignUp extends AppCompatActivity {

    TextView t;
    MaterialEditText edtPhonenum, edtFullname, edtPassword, edtEmail;
    Button btnSignUp;
    public String userType;
    public ProgressBar progressBar;
    //FirebaseDatabase db;
    //DatabaseReference users;

    // Declaring connection variables
    public Connection con;
    String un, pass, db, ip;
    public String z = "";
    public Boolean isSuccess = false;
    public String name1 = "";
    public User user;

    //When the radio button checked
    public void onRadioButtonClicked(View view) {

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.vendor:
                if (checked)
                    // Vendor marking in database
                    userType = "vendor";
                Toast.makeText(this, "Yo! Vendor", Toast.LENGTH_SHORT).show();
                break;
            case R.id.customer:
                if (checked)
                    userType = "customer";
                // Customer marking in database
                Toast.makeText(this, "Yo! Customer", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        t = findViewById(R.id.signUpTitle);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Thin.ttf");
        t.setTypeface(typeface);

        edtPhonenum = findViewById(R.id.edtPhonenum);
        edtFullname = findViewById(R.id.edtFullname);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnSignUp = findViewById(R.id.btnSignUp);

        // Declaring Server ip, username, database name and password
        ip = "1130grp16.database.windows.net";
        db = "1130grp16";
        un = "grp16";
        pass = "rM98s7nB";

        user = new User(edtFullname.getText().toString(),edtPassword.getText().toString(),edtEmail.getText().toString(), userType);


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // this is the Asynctask, which is used to process in background to reduce load on app process
                Insert insert = new Insert();
                insert.execute("");

            }
        });
    }

    public class Insert extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            if(isSuccess){
                Toast.makeText(SignUp.this, s ,Toast.LENGTH_SHORT).show();
                finish();
            }

        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                con = connectionclass();        // Connect to database
                if (con == null) {
                    z = "Check Your Internet Access!";
                } else {
                    // Change below query according to your own database.
                    String query = "INSERT INTO ganeshnomula VALUES('"+user.getUsertype()+"','"+user.getFullname()+"');";
                    Statement stmt = con.createStatement();
                    stmt.executeUpdate(query);
                    isSuccess = true;
                    z = "SignUp Successful";
                }
            } catch (Exception ex) {
                z = ex.getMessage();
                Log.d("sql error", z);
            }

            return z;


        }
    }

    @SuppressLint({"NewApi", "AuthLeak"})
    public Connection connectionclass() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection = null;
        String ConnectionURL;
        try
        {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            //your database connection string goes below
            //ConnectionURL = "jdbc:jtds:sqlserver://spring2017.database.windows.net;DatabaseName=thmsis;user=thavakho@spring2017;password=THMSIS1365o;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
            ConnectionURL = "jdbc:jtds:sqlserver://1130grp16.database.windows.net:1433;DatabaseName=1130grp16;user=grp16;password=rM98s7nB;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
            connection = DriverManager.getConnection(ConnectionURL);
        }
        catch (SQLException se)
        {
            Log.e("error here 1 : ", se.getMessage());
        }
        catch (ClassNotFoundException e)
        {
            Log.e("error here 2 : ", e.getMessage());
        }
        catch (Exception e)
        {
            Log.e("error here 3 : ", e.getMessage());
        }
        return connection;
    }
}




//        //Init Firebase database
//
//        db = FirebaseDatabase.getInstance();
//        users = db.getReference("User");
//
//        //Changes should be done in the database now
//        btnSignUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                final ProgressDialog mDialog = new ProgressDialog(SignUp.this);
//                mDialog.setMessage("Please Wait!");
//                mDialog.show();
//
//                //This is about changing values into the table, if the table_user exists in the database then the following thing executes
//                users.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        //check if already user phone num exist
//
//                        if(dataSnapshot.child(edtPhonenum.getText().toString()).exists()){
//
//                           /** wrapping toast in between this method to avoid app crashing in debug mode.
//                            * isFinishing() which is called by Android when Activity enters finishing stage:
//                            * be it explicit finish() call or activity clean up made by Android.*/
//                            if(!(SignUp.this.isFinishing())) {
//                                mDialog.dismiss();
//                                Toast.makeText(SignUp.this, "Phone Number already exists", Toast.LENGTH_SHORT).show();
//                            }
//
//                        } else {
//                            mDialog.dismiss();
//                            //assigning new user to their respective phone number
//
//                            // How to pass radio button value to the database?
//                            User user = new User(edtFullname.getText().toString(),edtPassword.getText().toString()
//                            ,edtEmail.getText().toString(), userType);
//                            users.child(edtPhonenum.getText().toString()).setValue(user);
//                            if(!(SignUp.this.isFinishing())){
//                                Toast.makeText(getApplicationContext(), "Sign Up Successful", Toast.LENGTH_SHORT).show();
//                                finish();
//                            }
//
//
//                        }
//
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
//
//
//
//    }
//}
