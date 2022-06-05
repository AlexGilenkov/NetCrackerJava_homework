package com.netcracker.service;

import com.netcracker.model.User;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDataService {

    private final String filePath = "src/main/resources/data/userlist.txt";


    public List<User> readAll (){
        List<User> list = new ArrayList<>();
        try(BufferedReader input = new BufferedReader(new FileReader(this.filePath)) ) {
            String in = input.readLine();
            while(in != null){
                list.add(new User().parseUser(in));
                in = input.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void saveInFile (User user) {
        if(user.equals(findByNameAndFamily(user.getFirstName(), user.getLastName())))
            return;
        try(FileWriter fileWriter = new FileWriter(filePath, true)) {
            //fileWriter.write(user.toWritingInFile());
            fileWriter.append(System.lineSeparator());
            fileWriter.append(user.toWritingInFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User findByNameAndFamily(String name, String family){
        List<User> all = readAll();
        User user = null;
        for(User u: all){
            if(name.equals(u.getFirstName()) && family.equals(u.getLastName())){
                user = u;
            }
        }
        return user;
    }

    public User downloadFromFile(String src){
        User user = new User();
        try(BufferedReader input = new BufferedReader(new FileReader(src)) ) {
            String in = input.readLine();
            user.parseUser(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        saveInFile(user);
        return user;
    }

}
