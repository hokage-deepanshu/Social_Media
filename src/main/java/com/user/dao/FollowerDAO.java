package com.user.dao;

import com.user.model.Follower;
import java.util.List;

public interface FollowerDAO {
    // Add a follower
    void addFollower(Follower follower);

    // Get followers of a user
    List<Follower> getFollowersByUserId(int userId);

    // Remove a follower
    void removeFollower(int followerId);
}
