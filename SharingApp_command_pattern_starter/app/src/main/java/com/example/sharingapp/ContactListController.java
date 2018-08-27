package com.example.sharingapp;
import android.content.Context;
import java.util.ArrayList;

/**
 * Created by Adarsh on 26/08/18.
 *
 * ItemListController is responsible for all communication between views and ItemList object
 */
public class ContactListController {

    private ContactList contact_list;

    public ContactListController(ContactList contact_list) {
        this.contact_list = contact_list;
    }

    public void setContacts(ArrayList<Contact> contact_list) {
        this.contact_list.setContacts(contact_list);
    }

    public ArrayList<Contact> getContacts() {
        return contact_list.getContacts();
    }

    public boolean addContact(Contact contact, Context context) {
        AddContactCommand add_contact_command = new AddContactCommand(contact_list, contact, context);
        add_contact_command.execute();
        return add_contact_command.isExecuted();
    }

    public boolean deleteContact(Contact contact, Context context) {
        DeleteContactCommand delete_contact_command = new DeleteContactCommand(contact_list, contact, context);
        delete_contact_command.execute();
        return delete_contact_command.isExecuted();
    }

    public boolean editItem(Contact contact, Contact updated_contact, Context context) {
        EditContactCommand edit_contact_command = new EditContactCommand(contact_list, contact, updated_contact, context);
        edit_contact_command.execute();
        return edit_contact_command.isExecuted();
    }

    public Contact getContact(int index) {
        return contact_list.getContact(index);
    }

    public int getIndex(Contact contact) {
        return contact_list.getIndex(contact);
    }

    public int getSize() {
        return contact_list.getSize();
    }

    public void loadContacts(Context context) {
        contact_list.loadContacts(context);
    }


//    public ArrayList<Item> filterItemsByStatus(String status){
//        return item_list.filterItemsByStatus(status);
//    }

    public Contact getContactByUsername(String username){

        return contact_list.getContactByUsername(username);
    }

    public boolean hasContact(Contact contact){

        return contact_list.hasContact(contact);
    }

    public ArrayList<String> getAllUsernames(){

        return contact_list.getAllUsernames();
    }

    public void saveContacts(Context context){

         contact_list.saveContacts(context);
    }

    public void addContact(Contact contact){

        contact_list.addContact(contact);
    }

    public void deleteContact(Contact contact){

        contact_list.deleteContact(contact);
    }

    public void addObserver(Observer observer) {
        contact_list.addObserver(observer);
    }

    public void removeObserver(Observer observer) {
        contact_list.removeObserver(observer);
    }
}