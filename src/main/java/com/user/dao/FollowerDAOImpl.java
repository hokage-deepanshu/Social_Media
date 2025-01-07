package com.user.dao;

import com.user.model.Follower;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FollowerDAOImpl implements FollowerDAO {

    @Override
    public void addFollower(Follower follower) {
        String query = "INSERT INTO followers (user_id, follower_user_id) VALUES (?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, follower.getUserId());
            statement.setInt(2, follower.getFollowerUserId());
            statement.executeUpdate();
            System.out.println("Follower added successfully!");

        } catch (SQLException e) {
            System.err.println("Error while adding follower.");
            e.printStackTrace();
        }
    }

    @Override
    public List<Follower> getFollowersByUserId(int userId) {
        String query = "SELECT * FROM followers WHERE user_id = ?";
        List<Follower> followers = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int followerId = resultSet.getInt("follower_id");
                int followerUserId = resultSet.getInt("follower_user_id");

                Follower follower = new Follower(followerId, userId, followerUserId);
                followers.add(follower);
            }

        } catch (SQLException e) {
            System.err.println("Error while fetching followers.");
            e.printStackTrace();
        }

        return followers;
    }

    @Override
    public void removeFollower(int followerId) {
        String query = "DELETE FROM followers WHERE follower_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, followerId);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Follower removed successfully!");
            } else {
                System.out.println("No follower found with the given ID.");
            }

        } catch (SQLException e) {
            System.err.println("Error while removing follower.");
            e.printStackTrace();
        }
    }
}
