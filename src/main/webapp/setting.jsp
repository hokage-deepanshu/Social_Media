<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/cropperjs/1.5.12/cropper.min.css" />
    <link rel="stylesheet" href="/css/setting.css">
</head>

<body>
<div class="nav">
    <div class="logo">
        <a href="/dashboard?username=${username}"> <img src="assets/logo.png" alt="" width="50px"></a> <span>Socio</span>
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
        <h2>Settings</h2>

        <!-- Social Media Settings Section -->
        <div class="social-media-settings">

            <!-- Privacy Settings -->
            <div class="setting">
                <label for="profile-visibility">Profile Visibility:</label>
                <select id="profile-visibility">
                    <option value="public">Public</option>
                    <option value="private">Private</option>
                    <option value="friends">Friends</option>
                </select>
            </div>

            <div class="setting">
                <a href="#" id="pass">
                    <img src="assets/setting.png" alt="" width="50px">Change your password
                </a>
            </div>
            <div class="setting">
                <label for="linked-accounts">Link Other Accounts:</label>
                <div class="links">
                    <a href="https://www.facebook.com/">
                        <button id="link-facebook">Link Facebook</button></a>
                    <a href="https://twitter.com/?lang=en">
                        <button id="link-twitter">Link Twitter</button></a>
                    <a href="https://www.instagram.com/">
                        <button id="link-instagram">Link Instagram</button> </a>
                </div>
            </div>

        </div>

    </div>
</div>

<!-- <script src="script/post.js"></script> -->
</body>

</html>
