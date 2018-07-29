package com.example.training.novani;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.training.novani.Callbacks.NavigationCallbacks;
import com.example.training.novani.data.Child;
import com.example.training.novani.fragments.AdministerFragment;
import com.example.training.novani.fragments.DetailsFragment;
import com.example.training.novani.fragments.LandingFragment;
import com.example.training.novani.fragments.RegisterFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationCallbacks {


    private FragmentManager fragmentManager=getSupportFragmentManager();
    private FragmentTransaction fragmentTransaction;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showLandingFragment();
    }

    private void showLandingFragment(){
        fragment=fragmentManager.findFragmentById(R.id.mainContainer);
        if(fragment==null){
           fragment= LandingFragment.getInstance();
            fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.mainContainer,fragment).commit();
        }
    }

    @Override
    public void showRegisterFragment() {

        fragment= RegisterFragment.getInstance();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContainer,fragment).addToBackStack("Register").commit();

    }

    @Override
    public void showAdministerFragment() {
        fragment= AdministerFragment.getInstance();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContainer,fragment).addToBackStack("Administer").commit();
    }

    @Override
    public void showDetailsFragment(ArrayList<Child> child) {
        fragment= DetailsFragment.getInstance(child);
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContainer,fragment).addToBackStack("Details").commit();
    }
}
