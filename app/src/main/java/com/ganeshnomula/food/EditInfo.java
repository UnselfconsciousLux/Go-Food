package com.ganeshnomula.food;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class EditInfo extends AppCompatActivity {

    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_info);

        t = findViewById(R.id.vendorDashboardTitle);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Thin.ttf");
        t.setTypeface(typeface);

        Toast.makeText(this,"You're in edit info", Toast.LENGTH_SHORT).show();


    }
}
