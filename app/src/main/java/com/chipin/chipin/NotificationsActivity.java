package com.chipin.chipin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class NotificationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        ImageView imageView = findViewById(R.id.not_2).findViewById(R.id.image);
        TextView textView = findViewById(R.id.not_2).findViewById(R.id.message);
        textView.setText("We are one step closer to building the water tunnel in Damas! All the required cement has been purchased today. Tap here to check the progress of the project.");
        imageView.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.bell_icon));

        ImageView imageView2 = findViewById(R.id.not_3).findViewById(R.id.image);
        TextView textView2 = findViewById(R.id.not_3).findViewById(R.id.message);
        textView2.setText("Thanks to you, Saadeya now has all the poultry she needs to start her own business. Thank you for taking part in empowering this inspirational young woman.");
        imageView2.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.true_g_icon));
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
