package com.user.dao;

import com.user.model.Like;
import java.util.List;

public interface LikeDAO {
    // Method to add a like
    boolean addLike(Like like);

    // Method to remove a like by ID
    boolean removeLike(int likeId);

    // Method to get a like by ID
    Like getLikeById(int likeId);

    // Method to get all likes for a specific post
    List<Like> getLikesByPostId(int postId);

    // Method to count likes for a specific post
    int countLikesByPostId(int postId);
}

