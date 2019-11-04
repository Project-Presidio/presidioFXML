/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presidiofxml;

import java.util.ArrayList;

/**
 *
 * @author jxw5883
 */
public class UserList {
    private final ArrayList<User> userList = new ArrayList();

    /**
     * @return the userList
     */
    public ArrayList<User> getUserList() {
        return userList;
    }
    
    /*
     * Generate a set of test users
     */
    public void generateUserList(){
        getUserList().add(new User("user1","password1"));
        getUserList().add(new User("user2","password2"));
        getUserList().add(new User("user3","password3"));
    }
}
