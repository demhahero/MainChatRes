package com.example.engahmed.mainchat;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import com.exmaple.engahmed.models.InstantMessageModel;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * Created by EngAhmed on 04/05/2015.
 */
public class InstantMessaging{
    DataTaker dt = new DataTaker();
    String[] msg = null;
    Object listner ;
    Method method;



    public boolean sendInstantMessage(InstantMessageModel imm) {
        return dt.sendInstantMessage(imm);
    }

    public void messageListner(){

        dt.setOnInstantMessgaeEventListener(new OnInstantMessgaeEventListener() {
            public void onInstantMessageEvent(InstantMessageModel imm) {
                onMessageComeEvent(imm);
            }
        });

        InstantMessageModel imm = new InstantMessageModel();
        imm.setID(1);
        imm.setSenderID("Ali");
        imm.setBody("I am fine.");
        //Simulate new message event
        dt.doInstantMessageEvent(imm);
    }

    public void registerMessagesListner(Object o){
        listner = o;

    }

    public void onMessageComeEvent(InstantMessageModel imm)
    {

        try {
            method = listner.getClass().getMethod("onInstantMessageComeEvent" ,InstantMessageModel.class );
            try {
                method.invoke(listner, imm);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public boolean sendInstantMessageACK(InstantMessageModel imm) {
        return dt.sendInstantMessageACK(imm);
    }
}
