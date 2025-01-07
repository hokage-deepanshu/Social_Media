package com.user.dao;

import com.user.model.User;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;

import static org.junit.Assert.*;

public class UserDAOTest {

    private Connection connection;
    private UserDAO userDAO;

    @Before
    public void setUp() throws SQLException {
        // Establish the connection to the database
        // Update with your actual database URL, username, and password
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SocialMedia", "root", "Tomar@12345");

        // Instantiate the concrete implementation of UserDAO
        userDAO = new UserDAOImpl(connection);
    }

    @Test
    public void testValidateUser() {
        // Test for valid user credentials (Ensure this user exists in your database)
        String username = "testuser";
        String password = "testpassword";

        boolean isValid = userDAO.validateUser(username, password);

        // Assert that the credentials are valid
        assertTrue("User should be valid with the correct credentials.", isValid);
    }

    @Test
    public void testInvalidUser() {
        // Test for invalid user credentials (Ensure this user doesn't exist in your database)
        String username = "invaliduser";
        String password = "invalidpassword";

        boolean isValid = userDAO.validateUser(username, password);

        // Assert that the credentials are not valid
        assertFalse("User should be invalid with the incorrect credentials.", isValid);
    }

    @Test
    public void testSaveUser() {
        // Create a new user to save to the database
        User user = new User(0, "newuser", "newpassword", "newuser@example.com", 9876543210L, new Timestamp(System.currentTimeMillis()));
        userDAO.saveUser(user);

        // Fetch the user back by their username to verify it's saved
        User savedUser = userDAO.getUserByUsername("newuser");

        // Assert that the user was saved correctly
        assertNotNull("User should be saved and fetched successfully.", savedUser);
        assertEquals("Usernames should match.", "newuser", savedUser.getUsername());
    }

    @Test
    public void testGetUserByUsername() {
        // Assuming there's an existing user in the DB
        String username = "existinguser";

        // Fetch the user by their username
        User fetchedUser = userDAO.getUserByUsername(username);

        // Assert that the user exists and matches the username
        assertNotNull("User should be fetched successfully.", fetchedUser);
        assertEquals("Fetched username should match.", username, fetchedUser.getUsername());
    }

    @Test
    public void testCreateUser() {
        // Create a new user object to insert into the database
        User user = new User(0, "userToCreate", "password", "usertocreate@example.com", 1234567890L, new Timestamp(System.currentTimeMillis()));

        // Create the user in the database
        userDAO.createUser(user);

        // Fetch the user back by username to confirm creation
        User createdUser = userDAO.getUserByUsername("userToCreate");

        // Assert the user was created successfully
        assertNotNull("User should be created and fetched successfully.", createdUser);
        assertEquals("Usernames should match.", "userToCreate", createdUser.getUsername());
    }

    @Test
    public void testCreateDuplicateUser() {
        // Create a user with a duplicate username (assuming "existinguser" already exists)
        User user = new User(0, "existinguser", "password", "duplicate@example.com", 1122334455L, new Timestamp(System.currentTimeMillis()));

        // Attempt to create a duplicate user
        userDAO.createUser(user);

        // Fetch the user back by username
        User duplicateUser = userDAO.getUserByUsername("existinguser");

        // Assert the username doesn't change and is still valid (duplicate should not override)
        assertNotNull("Duplicate user creation should not overwrite the original user.", duplicateUser);
        assertEquals("Usernames should match.", "existinguser", duplicateUser.getUsername());
    }

    @After
    public void tearDown() throws SQLException {
        // Close the database connection after tests
        if (connection != null) {
            connection.close();
        }
    }
}
