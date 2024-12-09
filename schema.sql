
-- Create the database and use it
CREATE DATABASE IF NOT EXISTS SocialMedia;
USE SocialMedia;

-- Create Users Table
CREATE TABLE IF NOT EXISTS Users (
                                     user_id INT AUTO_INCREMENT PRIMARY KEY,
                                     username VARCHAR(50) UNIQUE NOT NULL,
                                     email VARCHAR(100) UNIQUE NOT NULL,
                                     password VARCHAR(255) NOT NULL,
                                     mobile_number BIGINT UNIQUE NOT NULL, -- Adding mobile_number with the appropriate type
                                     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create Posts Table
CREATE TABLE IF NOT EXISTS Posts (
                                     post_id INT AUTO_INCREMENT PRIMARY KEY,
                                     user_id INT NOT NULL,
                                     content TEXT NOT NULL,
                                     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                     FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE
);

-- Create Comments Table
CREATE TABLE IF NOT EXISTS Comments (
                                        comment_id INT AUTO_INCREMENT PRIMARY KEY,
                                        post_id INT NOT NULL,
                                        user_id INT NOT NULL,
                                        content TEXT NOT NULL,
                                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                        FOREIGN KEY (post_id) REFERENCES Posts(post_id) ON DELETE CASCADE,
                                        FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE
);

-- Create Likes Table
CREATE TABLE IF NOT EXISTS Likes (
                                     like_id INT AUTO_INCREMENT PRIMARY KEY,
                                     post_id INT NOT NULL,
                                     user_id INT NOT NULL,
                                     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                     FOREIGN KEY (post_id) REFERENCES Posts(post_id) ON DELETE CASCADE,
                                     FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE
);

-- Create Followers Table
CREATE TABLE IF NOT EXISTS Followers (
                                         follower_id INT AUTO_INCREMENT PRIMARY KEY,
                                         user_id INT NOT NULL,
                                         follower_user_id INT NOT NULL,
                                         FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE,
                                         FOREIGN KEY (follower_user_id) REFERENCES Users(user_id) ON DELETE CASCADE
);
