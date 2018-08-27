package com.example.sharingapp;
import android.graphics.Bitmap;

/**
 * Created by Adarsh on 26/08/18.
 **
 * ContactController is responsible for all communication between views and Contact object
 */
public class ContactController {

    private Contact contact;

    public ContactController(Contact contact){
        this.contact = contact;
    }

    public String getId(){
        return contact.getId();
    }

    public void setId() {
        contact.setId();
    }

    public void setEmail(String title) {
        contact.setEmail(title);
    }

    public String getEmail() {
        return contact.getEmail();
    }

    public void setUsername(String username) {
        contact.setUsername(username);
    }

    public String getUsername() {
        return contact.getUsername();
    }


    public Contact getContact() { return this.contact; }

    public void addObserver(Observer observer) {
        contact.addObserver(observer);
    }

    public void removeObserver(Observer observer) {
        contact.removeObserver(observer);
    }
}
