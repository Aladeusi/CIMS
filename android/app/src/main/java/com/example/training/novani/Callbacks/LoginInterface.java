package com.example.training.novani.Callbacks;

import com.example.training.novani.data.LoginResponse;

public interface LoginInterface {
    void onSignInSuccessful(LoginResponse response);
    void onSignInFailed( int  responseCode,String failedMessage);
}
