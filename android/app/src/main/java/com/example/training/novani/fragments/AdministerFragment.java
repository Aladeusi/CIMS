package com.example.training.novani.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.training.novani.Callbacks.NavigationCallbacks;
import com.example.training.novani.R;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdministerFragment extends Fragment {

    NavigationCallbacks mCallbacks;



    @BindView(R.id.ageRange)
    MaterialBetterSpinner ageRangeSpinner;


    @BindView(R.id.range1)
    LinearLayout range1Lay;

    @BindView(R.id.range2)
    LinearLayout range2Lay;

    @BindView(R.id.submitBtn)
    Button submitBtn;



    public AdministerFragment() {
        // Required empty public constructor
    }

    public static AdministerFragment getInstance(){
        return new AdministerFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.administer_layout, container, false);
    ButterKnife.bind(this,view);
    populateSpinner();
        return view;
    }

    @OnClick({R.id.submitBtn})
    public void clicks(View view) {
        switch(view.getId()){
            case(R.id.submitBtn):
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

    private void populateSpinner(){



        String[] AGE_RANGE={"At Birth"," 6 Weeks"};




        ArrayAdapter<String> ageAdapter=new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_dropdown_item_1line,AGE_RANGE);

        ageRangeSpinner.setAdapter(ageAdapter);

        ageRangeSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==1){
                    range1Lay.setVisibility(View.VISIBLE);
                }else if(position==2){
                    range2Lay.setVisibility(View.VISIBLE);
                }

            }
        });


    }

}
