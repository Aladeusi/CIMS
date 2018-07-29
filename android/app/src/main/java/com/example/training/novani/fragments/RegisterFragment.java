package com.example.training.novani.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.training.novani.R;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {

@BindView(R.id.name)
EditText name;
@BindView(R.id.motherName)
EditText motherName;
@BindView(R.id.motherPhone)
EditText motherPhone;
@BindView(R.id.emergencyNumber)
EditText emergencyNumber;
@BindView(R.id.numberInfamily)
    MaterialBetterSpinner positionFamily;
@BindView(R.id.sex)
MaterialBetterSpinner sexSpinner;
@BindView(R.id.dateTv)
TextView dateTv;
@BindView(R.id.ageRange)
MaterialBetterSpinner ageRangeSpinner;

@BindView(R.id.range1)
    LinearLayout range1Lay;

@BindView(R.id.range2)
LinearLayout range2Lay;






    public RegisterFragment() {
        // Required empty public constructor
    }

    public static RegisterFragment getInstance(){
        return new RegisterFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.register_layout, container, false);
        ButterKnife.bind(this,view);
        populateSpinner();
        return view;
    }

    private void populateSpinner(){


        String[] SEX_LIST={"Male","Female"};
        String[] POSITION_LIST={"1","2","3","4","5"};
        String[] AGE_RANGE={"At Birth"," 6 Weeks"};


        ArrayAdapter<String> positionAdapter=new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_dropdown_item_1line,POSITION_LIST);

        positionFamily.setAdapter(positionAdapter);


        positionFamily.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        ArrayAdapter<String> sexAdapter=new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_dropdown_item_1line,SEX_LIST);

        sexSpinner.setAdapter(sexAdapter);

        sexSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });


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
