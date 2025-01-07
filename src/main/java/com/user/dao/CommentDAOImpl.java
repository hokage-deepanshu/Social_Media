package com.user.dao;

import com.user.model.Comment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CommentDAOImpl implements CommentDAO {

    @Override
    public boolean addComment(Comment comment) {
        String query = "INSERT INTO comments (post_id, user_id, content, created_at) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, comment.getPostId());
            statement.setInt(2, comment.getUserId());
            statement.setString(3, comment.getContent());
            statement.setTimestamp(4, comment.getCreatedAt());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Comment> getCommentsByPostId(int postId) {
        String query = "SELECT * FROM comments WHERE post_id = ?";
        List<Comment> comments = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, postId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int commentId = resultSet.getInt("comment_id");
                int userId = resultSet.getInt("user_id");
                String content = resultSet.getString("content");
                Timestamp createdAt = resultSet.getTimestamp("created_at");

                Comment comment = new Comment(commentId, postId, userId, content, createdAt);
                comments.add(comment);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return comments;
    }

    @Override
    public boolean deleteComment(int commentId) {
        String query = "DELETE FROM comments WHERE comment_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, commentId);
            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
