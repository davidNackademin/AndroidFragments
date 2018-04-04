package com.example.david.wed4aprilandroidfragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getFragmentManager();

    }

    public void addMyFragment(View view) {
        MyFragment myFragment = new MyFragment();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container, myFragment, "myFragment");
        transaction.commit();



    }

    public void addMySecondFragment(View view) {
        MySecondFragment mySecondFragment = new MySecondFragment();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container, mySecondFragment, "mySecondFragment");
        transaction.commit();

    }

    public void removeMyFragment(View view) {
        MyFragment myFragment =  (MyFragment) manager.findFragmentByTag("myFragment");

        if (myFragment != null) {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.remove(myFragment);
            transaction.commit();
        } else {
            Toast.makeText(this, "MyFragment not found", Toast.LENGTH_SHORT).show();
        }

    }

    public void removeMySecondFragment(View view) {
        MySecondFragment mySecondFragment =  (MySecondFragment) manager.findFragmentByTag("mySecondFragment");

        if (mySecondFragment != null) {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.remove(mySecondFragment);
            transaction.commit();
        } else {
            Toast.makeText(this, "MySecondFragment not found", Toast.LENGTH_SHORT).show();
        }

    }

    public void replaceByMyFragment(View view) {
        MyFragment fragment = new MyFragment();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment, "myFragment");

        transaction.commit();

    }

    public void replaceByMySecondFragment(View view) {
        MySecondFragment fragment = new MySecondFragment();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment, "mySecondFragment");

        transaction.commit();
    }


    public void changeTextInfragment(View view) {
        MyFragment myFragment =  (MyFragment) manager.findFragmentByTag("myFragment");

        if (myFragment != null) {
            myFragment.setTextInTextView("David");
        }
    }



}
