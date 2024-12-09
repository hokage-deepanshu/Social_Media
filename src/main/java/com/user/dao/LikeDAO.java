package com.user.dao;

import com.user.model.Like;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LikeDAO {
    private Connection connection;

    public LikeDAO(Connection connection) {
        this.connection = connection;
    }

    // Add a like
    public boolean addLike(Like like) {
        String query = "INSERT INTO Likes (post_id, user_id) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, like.getPostId());
            pstmt.setInt(2, like.getUserId());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Remove a like
    public boolean removeLike(int postId, int userId) {
        String query = "DELETE FROM Likes WHERE post_id = ? AND user_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, postId);
            pstmt.setInt(2, userId);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get the total number of likes for a post
    public int getLikeCountByPostId(int postId) {
        String query = "SELECT COUNT(*) AS like_count FROM Likes WHERE post_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, postId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("like_count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
