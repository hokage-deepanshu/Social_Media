<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link href="https://fonts.googleapis.com/css2?family=Billabong&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/index.css">
</head>
<body>

<div class="main">
    <div class="left">
        <form action="<%= request.getContextPath() %>/login" method="POST">
            <h1>Mini Social Media</h1>
            <input type="text" name="username" placeholder="Username" required>
            <input type="password" name="password" placeholder="Password" required>
            <button type="submit">Login</button>
            <div class="register">
                <label> Don't have an account?</label>
                <a href="<%= request.getContextPath() %>/register.jsp">Register</a>
            </div>
        </form>
    </div>
    <div class="right">
        <img src="assets/social-media-5187243_1280.png" alt="Social Media" height="560" width="735"/>
    </div>
</div>

</body>
</html>
