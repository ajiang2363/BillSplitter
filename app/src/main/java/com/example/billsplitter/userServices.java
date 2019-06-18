package com.example.billsplitter;

import java.util.ArrayList;
import java.util.HashMap;

public class userServices {

    private ArrayList<userInfo> userArray;
    private HashMap<String, String> userInfoHM;

    public userServices(){
        this.userArray = new ArrayList<userInfo>();
    }

    public void addUser(String username, String password){
        userInfo newUser = new userInfo(username, password);
        userInfoHM.put(username, password);
        userArray.add(newUser);
    }

    public boolean usernameExists(String attemptUsername){
        return userInfoHM.containsKey(attemptUsername);
    }

}
