package com.example.demoapp.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.example.demoapp.AdapterRecycler.Adapter;
import com.example.demoapp.Model.Model;
import com.example.demoapp.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    RecyclerView recyclerView;
    Adapter adapter;
    Toolbar toolbar;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);

        recyclerView= findViewById(R.id.recyclerView);
        adapter = new Adapter(dataqueue());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(adapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

    }

    public ArrayList<Model> dataqueue() {
        ArrayList<Model> holder = new ArrayList<>();

        Model ob1 = new Model();
        ob1.setName("Amit");
        ob1.setBranch("BE");
        ob1.setImage(R.drawable.ajay);
        holder.add(ob1);

        Model ob2 = new Model();
        ob2.setName("Deepak");
        ob2.setBranch("BCA");
        ob2.setImage(R.drawable.akshay);
        holder.add(ob2);

        Model ob3 = new Model();
        ob3.setName("Manan");
        ob3.setBranch("MCA");
        ob3.setImage(R.drawable.karan);
        holder.add(ob3);

        Model ob4 = new Model();
        ob4.setName("Rahul");
        ob4.setBranch("BBA");
        ob4.setImage(R.drawable.sawan);
        holder.add(ob4);

        Model ob5 = new Model();
        ob5.setName("Harry");
        ob5.setBranch("ME");
        ob5.setImage(R.drawable.arjun);
        holder.add(ob5);

        Model ob6 = new Model();
        ob6.setName("Lalit");
        ob6.setBranch("BCOM");
        ob6.setImage(R.drawable.shah);
        holder.add(ob6);

        Model ob7 = new Model();
        ob7.setName("Raman");
        ob7.setBranch("Mtech");
        ob7.setImage(R.drawable.shahid);
        holder.add(ob7);

        Model ob8 = new Model();
        ob8.setName("Mohit");
        ob8.setBranch("BBA");
        ob8.setImage(R.drawable.sawan);
        holder.add(ob8);

        Model ob9 = new Model();
        ob9.setName("Sunil");
        ob9.setBranch("Btech");
        ob9.setImage(R.drawable.ajay);
        holder.add(ob9);

        Model ob10 = new Model();
        ob10.setName("Yash");
        ob10.setBranch("Phd");
        ob10.setImage(R.drawable.akshay);
        holder.add(ob10);

        return holder;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }


    public void ClickMenu(View view)
    {
        opendrawer(drawerLayout);
    }

    public static void opendrawer(DrawerLayout drawerLayout)
    {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogout(View view)
    {
        logout(this);
    }

    public static void logout(final Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Logout");
        builder.setMessage("Are you sure you want to logout?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                activity.finishAffinity();
                System.exit(0);
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

}