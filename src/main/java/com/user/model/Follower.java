package com.user.model;

public class Follower {
    private int followerId;
    private int userId;
    private int followerUserId;

    public Follower(int followerId, int userId, int followerUserId) {
        this.followerId = followerId;
        this.userId = userId;
        this.followerUserId = followerUserId;
    }

    // Getters and Setters
    public int getFollowerId() {
        return followerId;
    }
    public void setFollowerId(int followerId) {
        this.followerId = followerId;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getFollowerUserId() {
        return followerUserId;
    }
    public void setFollowerUserId(int followerUserId) {
        this.followerUserId = followerUserId;
    }
}
