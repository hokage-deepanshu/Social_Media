<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/register.css">
    <style>
        .match { color: green; }
        .mismatch { color: red; }
        .weak { color: orange; }
        .medium { color: #f0ad4e; }
        .strong { color: green; }
    </style>
</head>
<body>
<h2>Register</h2>
<div class="register-container">
    <div class="left">
        <img src="<%= request.getContextPath() %>/assets/1.png" alt="" width="500px">
    </div>
    <div class="right">
        <form id="registerForm" action="<%= request.getContextPath() %>/register" method="POST">
            <div class="name">
                <label for="firstname">First name</label>
                <input type="text" id="firstname" name="firstname" required>

                <label for="lastname">Last name</label>
                <input type="text" id="lastname" name="lastname" required>
            </div>

            <label for="username">Username </label>
            <input type="text" id="username" name="username" required>

            <label for="Mobile">Mobile Number</label>
            <input type="text" id="mobileno" name="mobileno" required>

            <label for="email">Email</label>
            <input type="email" id="email" name="email" required>

            <label for="city">City:</label>
            <input type="text" id="city" name="city">

            <label for="password">Password</label>
            <input type="password" id="password" name="password" required oninput="checkPasswordMatch()">

            <label for="confirmpassword">Confirm Password:</label>
            <input type="password" id="confirmpassword" name="confirmpassword" required oninput="checkPasswordMatch()">

            <span id="message"></span><br><br>
            <span id="strengthMessage"></span><br><br>

            <button type="submit">Register</button>
        </form>
    </div>
</div>

<script src="<%= request.getContextPath() %>/script/register.js"></script>
</body>
</html>
