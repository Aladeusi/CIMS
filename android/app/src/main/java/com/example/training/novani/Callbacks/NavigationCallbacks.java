package com.example.training.novani.Callbacks;

import com.example.training.novani.data.Child;

import java.util.ArrayList;

public interface NavigationCallbacks {
    void showRegisterFragment();
    void showAdministerFragment();
    void showDetailsFragment(ArrayList<Child> child);
}
