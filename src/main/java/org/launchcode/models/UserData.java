package org.launchcode.models;

import java.util.ArrayList;

public class UserData {

    //store users in an arraylist as user objects
    static ArrayList<User> users = new ArrayList();

    //get all users
    public static ArrayList<User> getAll() {
        return users;
    }

    //add user
    public static void add(User newUser) {
        users.add(newUser);
    }

    //remove user
    public static void remove(int userId) {
        User userToRemove = getById(userId);
        users.remove(userToRemove);
    }

    //getById
    public static User getById(int userId) {
        User theUser = null;
        for (User possibleUser : users) {
            if (possibleUser.getUserId() == userId) {
                theUser = possibleUser;
            }
        }
        return theUser;
    }
}
