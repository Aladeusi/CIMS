package com.example.training.novani.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
public class DetailsFragment extends Fragment {

    @BindView(R.id.listRv)
    RecyclerView listRv;

    @BindView(R.id.addChild)
    Button addChild;

    private static ArrayList<Child> mList;

    private static NavigationCallbacks mCallbacks;




    public DetailsFragment() {
        // Required empty public constructor
    }

    public static DetailsFragment getInstance(ArrayList<Child> listArray){
        mList=listArray;
        return new DetailsFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.new_lay, container, false);
        ButterKnife.bind(this,view);
        return view;
    }


    @OnClick({R.id.addChild})
    public void clicks(View view) {
        switch(view.getId()){
            case(R.id.addChild):
                //mCallbacks.showRegisterFragment();
                Toast.makeText(getActivity(),"Posted",Toast.LENGTH_LONG).show();
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
