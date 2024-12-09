package com.dao;

import com.user.model.Follower;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FollowerDAO {
    private Connection connection;

    public FollowerDAO(Connection connection) {
        this.connection = connection;
    }

    // Add a follower
    public boolean addFollower(int userId, int followerUserId) {
        String query = "INSERT INTO Followers (user_id, follower_user_id) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, userId);
            pstmt.setInt(2, followerUserId);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Remove a follower
    public boolean removeFollower(int userId, int followerUserId) {
        String query = "DELETE FROM Followers WHERE user_id = ? AND follower_user_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, userId);
            pstmt.setInt(2, followerUserId);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get all followers of a user
    public List<Integer> getFollowers(int userId) {
        List<Integer> followers = new ArrayList<>();
        String query = "SELECT follower_user_id FROM Followers WHERE user_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                followers.add(rs.getInt("follower_user_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return followers;
    }

    // Get all users followed by a specific user
    public List<Integer> getFollowing(int userId) {
        List<Integer> following = new ArrayList<>();
        String query = "SELECT user_id FROM Followers WHERE follower_user_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                following.add(rs.getInt("user_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return following;
    }
}
