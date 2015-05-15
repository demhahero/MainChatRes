package com.exmaple.engahmed.models;

/**
 * Created by EngAhmed on 14/05/2015.
 */
public class InstantMessageModel {
    int ID;
    String senderID;
    String body;
    public void setID(int id){
        ID = id;
    }
    public int getID()
    {
        return ID;
    }
    public void setSenderID(String si){
        senderID = si;
    }
    public String getSenderID()
    {
        return senderID;
    }
    public void setBody(String body){
        this.body = body;
    }
    public String getBody()
    {
        return body;
    }
}
