<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link rel="stylesheet" href="/css/dashboard.css">
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
    <div class="right">
        <!-- Post box -->
        <div class="postbox">
            <div class="textpost">
                <div class="photo">
                    <img class="profile-photo" src="assets/default_profile.jpg" alt="Profile Photo" width="100" height="100">
                </div>
                <input type="text" id="postContent" placeholder="Write Something..." aria-label="Post Content">
                <label for="mediaUpload">
                    <img id="upload" src="assets/add1.png" alt="Upload Media" width="35px">
                </label>
                <div class="content">
                    <input type="file" id="mediaUpload" accept="image/*,video/*" style="display: none;">
                    <button id="postButton">Post</button>
                </div>
            </div>
        </div>

        <!-- Posts container -->
        <div class="posts" id="postsContainer">
            <!-- Loop through posts -->
            <c:forEach var="post" items="${posts}">
                <div class="post">
                    <div class="post-header">
                        <img src="${post.user.profilePhoto}" alt="User Profile" width="50px">
                        <p>Username: <span>${post.user.username}</span></p>
                    </div>
                    <div class="post-content">
                        <p>${post.content}</p>
                        <c:if test="${post.mediaurl != null}">
                            <img src="${post.mediaurl}" alt="Post Media" style="max-width: 100%; height: auto;">
                        </c:if>
                    </div>
                    <div class="post-footer">
                        <span>${post.likesCount}</span> Likes |
                        <span>${post.commentsCount}</span> Comments
                    </div>
                </div>
            </c:forEach>
        </div>
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
            <h3> Recent Activities</h3>
            <p>Stay tuned for updates...</p>
        </div>
    </div>
</div>

<script src="script/post.js"></script>
</body>

</html>
