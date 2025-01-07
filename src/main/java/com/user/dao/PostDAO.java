package com.user.dao;

import com.user.model.Post;
import java.util.List;

public interface PostDAO {
    void addPost(Post post);          // Add a new post
    Post getPostById(int postId);     // Get a post by ID
    List<Post> getAllPosts();         // Get all posts
    void updatePost(Post post);       // Update a post
    void deletePost(int postId);      // Delete a post by ID
}
