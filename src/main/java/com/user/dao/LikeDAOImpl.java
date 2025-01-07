package com.user.dao;

import com.user.model.Like;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LikeDAOImpl implements LikeDAO {

    @Override
    public boolean addLike(Like like) {
        String query = "INSERT INTO likes (post_id, user_id, created_at) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, like.getPostId());
            statement.setInt(2, like.getUserId());
            statement.setTimestamp(3, like.getCreatedAt());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean removeLike(int likeId) {
        String query = "DELETE FROM likes WHERE like_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, likeId);

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Like getLikeById(int likeId) {
        String query = "SELECT * FROM likes WHERE like_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, likeId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Like(
                            resultSet.getInt("like_id"),
                            resultSet.getInt("post_id"),
                            resultSet.getInt("user_id"),
                            resultSet.getTimestamp("created_at")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Like> getLikesByPostId(int postId) {
        String query = "SELECT * FROM likes WHERE post_id = ?";
        List<Like> likes = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, postId);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    likes.add(new Like(
                            resultSet.getInt("like_id"),
                            resultSet.getInt("post_id"),
                            resultSet.getInt("user_id"),
                            resultSet.getTimestamp("created_at")
                    ));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return likes;
    }

    @Override
    public int countLikesByPostId(int postId) {
        String query = "SELECT COUNT(*) FROM likes WHERE post_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, postId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
