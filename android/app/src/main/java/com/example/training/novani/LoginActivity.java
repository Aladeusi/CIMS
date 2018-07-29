package com.example.training.novani;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.training.novani.Callbacks.LoginInterface;
import com.example.training.novani.data.Login;
import com.example.training.novani.data.LoginResponse;
import com.example.training.novani.utils.NetworkUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.view.View.GONE;

public class LoginActivity extends AppCompatActivity implements LoginInterface{

    @BindView(R.id.userNmEdt)
    TextInputEditText userNameEdt;

    @BindView(R.id.passwordEdt)
    TextInputEditText passwordEdt;

    @BindView(R.id.loginBtn)
    Button loginButton;

    @BindView(R.id.signInProgressBar)
    ProgressBar mProgressBar;

    @BindView(R.id.signInCoordinator)
    CoordinatorLayout signInCoordinator;

    private String userName,password;
    private Login body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
       ButterKnife.bind(this);
    }

    @OnClick({R.id.loginBtn})
    public void clickLoginForgotPassword(View view){
        switch(view.getId()){

            case R.id.loginBtn:
                if(isValidated()){

                    if(NetworkUtil.isConnected(LoginActivity.this)){
                        signIn();
                    }else{
                        //callSnackBar();
                        signIn();
                    }

                }
                break;

        }

    }

    private boolean isValidated(){
        boolean validated=true;
        if(userNameEdt.getText().toString().equals("")){
            validated=false;
            userNameEdt.setError("Username cannot be empty");
        }else if(passwordEdt.getText().toString().equals("")){
            validated=false;
            passwordEdt.setError("Password cannot be empty");
        }
        if(validated){
            userName=userNameEdt.getText().toString();
            password=passwordEdt.getText().toString();
            body=new Login(userName,password);

        }

        return validated;
    }

    private void signIn(){
       //make a network call
        startActivity(new Intent(LoginActivity.this,MainActivity.class));
    }


    @Override
    public void onSignInSuccessful(LoginResponse response) {

    }

    @Override
    public void onSignInFailed(int responseCode, String failedMessage) {

    }


    private void callSnackBar(){
        if(!NetworkUtil.isConnected(LoginActivity.this)){
            mProgressBar.setVisibility(GONE);
            Snackbar signInSnack= Snackbar.make(signInCoordinator,"NO INTERNET",Snackbar.LENGTH_LONG);
            signInSnack.setAction("Try again", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mProgressBar.setVisibility(View.VISIBLE);
                    callSnackBar();
                }
            });
            signInSnack.show();
        }else{
            signIn();
        }

    }
}
