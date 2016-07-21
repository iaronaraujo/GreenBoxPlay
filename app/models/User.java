package models;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.UUID;

/**
 * Created by Iaron-PC on 17/07/2016.
 */
public class User {

    private UUID uuid;
    private UserDirectory userdirectory;
    private String email, username, password;

    public User(){

    }

    public User(String email, String username, String password){
        this.uuid = UUID.randomUUID();
        this.userdirectory = new UserDirectory(username);
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // Maybe the fileContent will be a String later
    public void createFile(String filename, StringBuffer fileContent) throws Exception{
        userdirectory.addFile(filename, ".txt" ,fileContent); // An enum should be created for file extension
    }


    public void createDirectory(String directoryName) throws Exception{
        userdirectory.addDirectory(directoryName);
    }

    public String getUsername(){
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserDirectory getUserDirectory(){
        return userdirectory;
    }

}
