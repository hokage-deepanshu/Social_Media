package com.user.dao;

import com.user.model.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDAOImpl implements PostDAO {



    @Override
    public void addPost(Post post) {
        String query = "INSERT INTO posts (user_id, content, created_at) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, post.getUserId());
            statement.setString(2, post.getContent());
            statement.setTimestamp(3, post.getCreatedAt());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Post added successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Post getPostById(int postId) {
        String query = "SELECT * FROM posts WHERE post_id = ?";
        Post post = null;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, postId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                post = new Post(
                        resultSet.getInt("post_id"),
                        resultSet.getInt("user_id"),
                        resultSet.getString("content"),
                        resultSet.getTimestamp("created_at")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return post;
    }

    @Override
    public List<Post> getAllPosts() {
        String query = "SELECT * FROM posts";
        List<Post> posts = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Post post = new Post(
                        resultSet.getInt("post_id"),
                        resultSet.getInt("user_id"),
                        resultSet.getString("content"),
                        resultSet.getTimestamp("created_at")
                );
                posts.add(post);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }

    @Override
    public void updatePost(Post post) {
        String query = "UPDATE posts SET content = ?, created_at = ? WHERE post_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, post.getContent());
            statement.setTimestamp(2, post.getCreatedAt());
            statement.setInt(3, post.getPostId());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Post updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePost(int postId) {
        String query = "DELETE FROM posts WHERE post_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, postId);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Post deleted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
