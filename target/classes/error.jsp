<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8d7da;
            color: #721c24;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .error-container {
            text-align: center;
            border: 1px solid #f5c6cb;
            border-radius: 8px;
            padding: 20px;
            background-color: #f5c6cb;
            max-width: 600px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
        .error-code {
            font-size: 3em;
            font-weight: bold;
        }
        .error-message {
            margin-top: 10px;
            font-size: 1.2em;
        }
        .back-link {
            margin-top: 20px;
            display: inline-block;
            text-decoration: none;
            color: #721c24;
            font-weight: bold;
        }
        .back-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="error-container">
    <div class="error-code">Error <%= exception == null ? "Unknown" : exception.getMessage() %></div>
    <div class="error-message">
        <p>An unexpected error occurred.</p>
        <p>Status Code: <%= request.getAttribute("javax.servlet.error.status_code") %></p>
        <p>Requested URI: <%= request.getAttribute("javax.servlet.error.request_uri") %></p>
    </div>
    <a href="/" class="back-link">Go Back to Home</a>
</div>
</body>
</html>
