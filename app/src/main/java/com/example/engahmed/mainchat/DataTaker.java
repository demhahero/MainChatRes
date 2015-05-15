package com.example.engahmed.mainchat;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.exmaple.engahmed.models.InstantMessageModel;
import com.exmaple.engahmed.models.UserModel;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by EngAhmed on 03/05/2015.
 */
public class DataTaker  extends Service {


    @Override
    public void onCreate() {

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("LocalService", "Received start id " + startId + ": " + intent);
        // We want this service to continue running until it is explicitly
        // stopped, so return sticky.
        return START_STICKY;
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private OnInstantMessgaeEventListener mOnInstantMessgaeEventListener;
    String username = "Ahmed";
    String password = "pass";
    String ID = "1";
    UserModel [] friends = new UserModel[3];
    UserModel currentUser = new UserModel();

    public DataTaker(){
        friends[0] = new UserModel();
        friends[0].setUsername("Ali");
        friends[1] = new UserModel();
        friends[1].setUsername("Yahya");
    }

    public void setOnInstantMessgaeEventListener(OnInstantMessgaeEventListener listener) {
        mOnInstantMessgaeEventListener = listener;
    }

    public UserModel getCurrentUser() {
        return currentUser;
    }

    public boolean doLogin(UserModel um){
        if(um.getUsername().equals(this.username) && um.getPassword().equals(this.password)) {
            currentUser = um;
            currentUser.setID(1);
            return true;
        }
        return false;
    }

    public boolean doLogout() {
        // Destory the session with the server here

        currentUser = null;
        return true;
    }

    public UserModel[] getFriendsOf(UserModel um) {
        return this.friends;
    }

    public boolean addNewUser(UserModel um) {
        this.username = um.getUsername();
        this.password = um.getPassword();
        return true;
    }

    public boolean sendInstantMessage(InstantMessageModel imm) {
        return true;
    }

    public void doInstantMessageEvent(InstantMessageModel imm) {

        if (mOnInstantMessgaeEventListener != null)
            mOnInstantMessgaeEventListener.onInstantMessageEvent(imm); // event object :)
    }

    public boolean sendInstantMessageACK(InstantMessageModel imm) {
        return true;
    }
}
