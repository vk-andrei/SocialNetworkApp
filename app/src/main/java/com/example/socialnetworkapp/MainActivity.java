package com.example.socialnetworkapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.socialnetworkapp.ui.FragmentSocialNetwork;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initToolBar();
        addFragment(FragmentSocialNetwork.newInstance());
        
        
    }

    private void initToolBar() {
        // TODO toolbar
    }

    private void addFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        fm
                .beginTransaction()
                .replace(R.id.main_container, fragment)
                .addToBackStack(null)
                .commit();
    }


}