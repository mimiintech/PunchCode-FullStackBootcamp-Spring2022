
package com.techelevator.dao;

import com.techelevator.exceptions.UserNotFoundException;
import com.techelevator.model.Users;
import java.util.List;

public interface UsersDao {



//Create Method

    public void createUser(String email, String password_hash, String allow);


//Read Method

//    For All

    public List<Users> getAllUsers();

// For One

    public Users getUser(int usersId) throws UserNotFoundException;


////Update Method

    public void updateUser(String email, String password_hash, String allow, int usersId);

////Delete Method

    public void deleteUser(int usersId);

}