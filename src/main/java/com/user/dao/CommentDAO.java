package com.user.dao;

import com.user.model.Comment;
import java.util.List;

public interface CommentDAO {
    // Method to add a comment
    boolean addComment(Comment comment);

    // Method to retrieve all comments for a specific post
    List<Comment> getCommentsByPostId(int postId);

    // Method to delete a comment by its ID
    boolean deleteComment(int commentId);
}
