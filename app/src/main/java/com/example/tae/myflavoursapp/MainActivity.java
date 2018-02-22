package com.example.tae.myflavoursapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.tae.myflavoursapp.free.simpsons.SimpsonsCharacterFragment;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private static FragmentManager fragmentManager;
    Bundle savedInstanceState;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                   // mTextMessage.setText(R.string.title_home);
                    simpsonsFragment();
                    return true;
                case R.id.navigation_dashboard:
                  //  mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                   // mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        simpsonsFragment();

        }

        public void simpsonsFragment()
        {
            if (savedInstanceState == null) {
                fragmentManager.beginTransaction()
                        .add(R.id.fragmentContainer, new SimpsonsCharacterFragment())
                        .disallowAddToBackStack()
                        .commit();
            }
        }

}
