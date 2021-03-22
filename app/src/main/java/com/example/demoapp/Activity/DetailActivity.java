package com.example.demoapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demoapp.R;

public class DetailActivity extends AppCompatActivity
{
    TextView detail_name,detail_branch;
    ImageView detail_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        setTitle("Details");
        setContentView(R.layout.activity_detail);

        detail_name= findViewById(R.id.detail_name);
        detail_branch= findViewById(R.id.detail_branch);
        detail_image= findViewById(R.id.detail_image);

        if(this.getIntent() !=null)
        {
            detail_name.setText(getIntent().getStringExtra("name"));
            detail_branch.setText(getIntent().getStringExtra("branch"));
            detail_image.setImageResource(getIntent().getIntExtra("image", 0));
        }
    }
}