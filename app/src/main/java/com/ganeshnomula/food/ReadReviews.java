package com.ganeshnomula.food;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class ReadReviews extends AppCompatActivity {

    ListView listView;
    TextView userName, comments;
    RatingBar ratingBar;

    String[] userNames = {"John", "Graham", "Paul","Ganesh", "Kiran", "Masty", "Cherova", "Yuoi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_reviews);
        Toast.makeText(this,"You're in Read Reviews", Toast.LENGTH_SHORT).show();

        listView = findViewById(R.id.listview);

        CustomAdapter customAdapter =  new CustomAdapter();
        listView.setAdapter(customAdapter);
    }

    class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return userNames.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            if (view == null){

                view = getLayoutInflater().inflate(R.layout.customlayout, null );
                return view;
            }
            userName = findViewById(R.id.username);
            ratingBar = findViewById(R.id.ratingBar);
            comments = findViewById(R.id.comments);
            userName.setText(userNames[i]);

            return view;

        }
    }

}
