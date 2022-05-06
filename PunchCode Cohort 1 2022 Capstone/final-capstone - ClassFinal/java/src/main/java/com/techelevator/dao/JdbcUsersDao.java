package com.techelevator.dao;

import com.techelevator.exceptions.UserNotFoundException;
import com.techelevator.model.Users;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


@Component

public class JdbcUsersDao implements UsersDao {

    private final JdbcTemplate template;

    public JdbcUsersDao(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

///Create Method

    @Override
    public void createUser(String email, String password_hash, String allow) {

        String sql = "INSERT INTO users (email, password_hash, allow)" +
                "VALUES (?, ?, ?)";
        template.update(sql, email, password_hash, allow);
    }

//Read Method

//    For All

    @Override
    public List<Users> getAllUsers() {

        ArrayList<Users> users = new ArrayList<>();

        String sql = "SELECT * FROM users";

        SqlRowSet results = template.queryForRowSet(sql);
        while (results.next()) {
            users.add(mapRowToUsers(results));
        }
        return users;
    }


// For One

    @Override
    public Users getUser(int usersId) throws UserNotFoundException {

        String sql = "SELECT * FROM users WHERE users_id = ?";
        SqlRowSet result = template.queryForRowSet(sql, usersId);
        if (result.next()) {
            return mapRowToUsers(result);
        } else {
            throw new UserNotFoundException();
        }
    }

// Update Method

    @Override
    public void updateUser(String email, String password_hash, String allow, int usersId) {

        String sql = "UPDATE users SET email = ?, password_hash = ?, allow = ? WHERE users_id = ?";

        template.update(sql, email, password_hash, allow, usersId);
    }


////Delete Method

    @Override
    public void deleteUser(int usersId) {

        String sql = "DELETE FROM users WHERE users_id = ?";

        template.update(sql, usersId);

    }

    private Users mapRowToUsers(SqlRowSet result) {
        Users retrievedUser = null;
        int users_id = result.getInt("users_id");
        String email = result.getString("email");
        String password_hash = result.getString("password_hash");
        String allow = result.getString("allow");
        retrievedUser = new Users(users_id, email, password_hash, allow);
        return retrievedUser;
    }

}







