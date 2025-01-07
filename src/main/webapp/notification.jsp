<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/cropperjs/1.5.12/cropper.min.css" />
    <link rel="stylesheet" href="css/addpost.css">
</head>

<body>
<div class="nav">
    <div class="logo">
        <a href="/dashboard?username=${username}">
            <img src="assets/logo.png" alt="Logo" width="50px">
        </a>
        <span>Socio</span>
    </div>
    <div class="search">
        <input type="text" placeholder="Search...">
        <button id="Searchbutton">Search</button>
    </div>
    <div class="buttons">
        <a href="#"><img src="assets/email.png" alt="Messages" width="40px"></a>
        <a href="/profile?username=${username}"><img src="assets/profile.png" alt="Profile" width="35px"></a>
    </div>
</div>

<div class="main">
    <!-- Sidebar section -->
    <div class="corner">
        <div class="features">
            <span>Short-cuts</span>
            <a href="/dashboard?username=${username}">
                <img src="assets/home.png" alt="Home" width="28px">Home
            </a>
            <a href="/notification?username=${username}">
                <img src="assets/not.png" alt="Notifications" width="25px"> Notification
            </a>
            <a href="/addpost?username=${username}">
                <img src="assets/add2.png" alt="Add Post" width="30px"> Add Post
            </a>
            <a href="/setting?username=${username}">
                <img src="assets/setting.png" alt="Settings" width="28px">Settings
            </a>
            <a href="#"><img src="assets/logout.png" alt="Logout" width="24px">Logout</a>
        </div>
        <div class="news">
            <h3>Latest News</h3>
            <p>Stay tuned for updates...</p>
        </div>
    </div>

    <!-- Main content section -->
    <div class="addpostbox">
        <h2>Notification</h2>
    </div>

    <!-- User Profile Card Section -->
    <div class="left">
        <div class="usercard">
            <span id="name"> Your Popularity </span>
            <div class="info">
                <div class="photo">
                    <img class="profile-photo" src="assets/default_profile.jpg" alt="Profile Photo" width="100" height="100">
                </div>
                <div class="details">
                    <p>Username: <span>${username}</span></p>
                    <p>Followers: <span>${followersCount}</span></p>
                    <p>Following: <span>${followingCount}</span></p>
                </div>
            </div>
            <input type="file" id="uploadPhoto" accept="image/*">
            <button id="removePhoto">Remove Photo</button>
        </div>

        <div class="news">
            <h3>Recent Activities</h3>
            <p>Stay tuned for updates...</p>
        </div>
    </div>
</div>

<script src="script/post.js"></script>
</body>

</html>
