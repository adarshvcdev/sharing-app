package com.example.sharingapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Add a new contact
 */
public class AddContactActivity extends AppCompatActivity {

    private ContactList contact_list = new ContactList();
    private Context context;

    private EditText username;
    private EditText email;

    private ContactListController contactListController = new ContactListController(contact_list);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);

        context = getApplicationContext();
        contactListController.loadContacts(context);
    }

    public boolean validateInput(String emailStr, String usernameStr) {

        if (emailStr.equals("")) {
            email.setError("Empty field!");
            return false;
        }
        if (!emailStr.contains("@")){
            email.setError("Must be an email address!");
            return false;
        }

        if (usernameStr.equals("")) {
            username.setError("Empty field!");
            return false;
        }

        if (!contact_list.isUsernameAvailable(usernameStr)){
            username.setError("Username already taken!");
            return false;
        }

        return true;
    }

    public void saveContact(View view) {

        String username_str = username.getText().toString();
        String email_str = email.getText().toString();

        if (!validateInput(email_str, username_str)) {
            return;
        }

        Contact contact = new Contact(username_str, email_str, null);

        contactListController.addContact(contact);
        contactListController.saveContacts(context);

        // End AddContactActivity
        finish();
    }
}
