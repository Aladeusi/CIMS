package com.example.training.novani.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.training.novani.Callbacks.NavigationCallbacks;
import com.example.training.novani.R;
import com.example.training.novani.data.Child;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class LandingFragment extends Fragment {
/*
     @BindView(R.id.)
    ImageView mainImageView;

    @BindView(R.id.addChild)
    ImageView addChildImageView;

    @BindView(R.id.administer)
    ImageView administerImageView;*/

    @BindView(R.id.checkBtn)
    Button checkBtn;

    @BindView(R.id.parentPhone)
    EditText parentPhone;

    private ArrayList<Child> mList=new ArrayList<>();




    NavigationCallbacks mCallbacks;


    public LandingFragment() {
        // Required empty public constructor
    }

    public static LandingFragment getInstance(){
        return new LandingFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.landing_fragment, container, false);
        ButterKnife.bind(this,view);
        return view;

    }


    @OnClick({R.id.checkBtn})
    public void clicks(View view) {
        switch(view.getId()){
            case(R.id.checkBtn):

                break;



        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{
            mCallbacks=(NavigationCallbacks) context;

        }catch (ClassCastException e){
            throw new ClassCastException(e.getMessage());
        }


    }







}
