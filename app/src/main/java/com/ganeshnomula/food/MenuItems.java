package com.ganeshnomula.food;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MenuItems extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_items);
        Toast.makeText(this,"You're in Menu Items", Toast.LENGTH_SHORT).show();
    }
}
