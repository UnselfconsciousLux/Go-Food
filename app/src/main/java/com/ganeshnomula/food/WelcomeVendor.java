package com.ganeshnomula.food;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class WelcomeVendor extends AppCompatActivity implements View.OnClickListener {

     CardView editInfo, updateLocation, menuItems, readReviews;
     CollapsingToolbarLayout collapsebar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_vendor);

        //tagging with xml

        editInfo = findViewById(R.id.editinfocard);
        updateLocation = findViewById(R.id.updatelocationcard);
        menuItems = findViewById(R.id.menuitemscard);
        readReviews = findViewById(R.id.readreviewscard);
        collapsebar = findViewById(R.id.collapsingtoolbar);
        collapsebar.setTitle("Stillwater Waffles");

        //setting onClick Listener
        editInfo.setOnClickListener(this);
        updateLocation.setOnClickListener(this);
        menuItems.setOnClickListener(this);
        readReviews.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent i;

        switch (v.getId()){

            case R.id.editinfocard: i = new Intent(WelcomeVendor.this, EditInfo.class);
                startActivity(i);
                break;
            case R.id.updatelocationcard: i = new Intent(WelcomeVendor.this, UpdateLocation.class);
                startActivity(i);
                break;
            case R.id.menuitemscard: i = new Intent(WelcomeVendor.this, MenuItems.class);
                startActivity(i);
                break;
            case R.id.readreviewscard: i = new Intent(WelcomeVendor.this, ReadReviews.class);
                startActivity(i);
                break;
            default:break;
        }

    }
}
