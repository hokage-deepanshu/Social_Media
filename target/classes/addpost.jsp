<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/cropperjs/1.5.12/cropper.min.css" />
    <link rel="stylesheet" href="<c:url value='/css/addpost.css' />">
</head>

<body>
<div class="nav">
    <div class="logo">
        <a href="<c:url value='/dashboard?username=${username}' />">
            <img src="<c:url value='/resources/assets/logo.png' />" alt="" width="50px">
        </a>
        <span>Socio</span>
    </div>
    <div class="search">
        <input type="text" placeholder="Search...">
        <button id="Searchbutton">Search</button>
    </div>
    <div class="buttons">
        <a href="#">
            <img src="<c:url value='/resources/assets/email.png' />" alt="Messages" width="40px">
        </a>
        <a href="<c:url value='/profile?username=${username}' />">
            <img src="<c:url value='/resources/assets/profile.png' />" alt="Profile" width="35px">
        </a>
    </div>
</div>

<div class="main">
    <!-- Sidebar section -->
    <div class="corner">
        <div class="features">
            <span>Short-cuts</span>
            <a href="<c:url value='/dashboard?username=${username}' />">
                <img src="<c:url value='/resources/assets/home.png' />" alt="Home" width="28px">Home
            </a>
            <a href="<c:url value='/notification?username=${username}' />">
                <img src="<c:url value='/resources/assets/not.png' />" alt="Notifications" width="25px"> Notification
            </a>
            <a href="<c:url value='/addpost?username=${username}' />">
                <img src="<c:url value='/resources/assets/add2.png' />" alt="Add Post" width="30px"> Add Post
            </a>
            <a href="<c:url value='/setting?username=${username}' />">
                <img src="<c:url value='/resources/assets/setting.png' />" alt="Settings" width="28px">Settings
            </a>
            <a href="<c:url value='/logout' />">
                <img src="<c:url value='/resources/assets/logout.png' />" alt="Logout" width="24px">Logout
            </a>
        </div>
        <div class="news">
            <h3>Latest News</h3>
            <p>Stay tuned for updates...</p>
        </div>
    </div>

    <!-- Main content section -->
    <div class="addpostbox">
        <h2>Add Post</h2>
        <!-- File Input for Image Upload -->
        <form action="<c:url value='/addpost' />" method="POST" id="editForm">
            <label for="imageInput">
                <img src="<c:url value='/resources/assets/add.png' />" id="imagePreview" alt="Image Preview" width="300px" />
            </label>

            <input type="file" id="imageInput" accept="image/*" style="display: none;" />
            <div id="cropper-container" style="display: none;">
                <img id="croppedImage" src="" alt="To Be Cropped">
                <div class="controls">
                    <button onclick="setAspectRatio(1)">1:1</button>
                    <button onclick="setAspectRatio(4 / 3)">4:3</button>
                    <button onclick="setAspectRatio(16 / 9)">16:9</button>
                    <button onclick="rotateImage(90)">Rotate</button>
                    <button id="applyEdit">Apply Crop</button>
                </div>
            </div>

            <!-- Caption Input -->
            <div class="caption-container">
                <label for="caption">Add a caption:</label><br>
                <textarea id="caption" name="caption" placeholder="Add your caption..." rows="2" style="width: 95%;"></textarea><br><br>
            </div>

            <!-- List of Emojis -->
            <div class="emoji-container" id="emojiContainer">
                <span class="emoji" onclick="addEmoji('😀')">😀</span>
                <span class="emoji" onclick="addEmoji('😊')">😊</span>
                <span class="emoji" onclick="addEmoji('❤️')">❤️</span>
                <span class="emoji" onclick="addEmoji('😎')">😎</span>
                <span class="emoji" onclick="addEmoji('😂')">😂</span>
            </div>

            <!-- Submit and Close Buttons -->
            <button type="submit" id="applyEdit" class="btn">Add post</button>
        </form>
    </div>

    <!-- User Profile Card Section -->
    <div class="left">
        <div class="usercard">
            <span id="name"> Your Popularity </span>
            <div class="info">
                <div class="photo">
                    <img class="profile-photo" src="<c:url value='/resources/assets/default_profile.jpg' />" alt="Profile Photo" width="100" height="100">
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

<script src="https://cdnjs.cloudflare.com/ajax/libs/cropperjs/1.5.12/cropper.min.js"></script>
<script src="<c:url value='/resources/script/post.js' />"></script>
<script src="<c:url value='/resources/script/addpost.js' />"></script>
</body>

</html>
