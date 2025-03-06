<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Login - Magadha Bank</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f9;
        }
        .navbar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: #004d99;
            padding: 10px 20px;
            color: white;
        }
        .navbar a {
            color: white;
            text-decoration: none;
            margin: 0 15px;
            font-weight: bold;
        }
        .navbar .logo {
            font-size: 1.5em;
        }
        .login-container {
            width: 100%;
            max-width: 400px;
            margin: 100px auto;
            padding: 20px;
            background: white;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
        }
        .login-container h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #004d99;
        }
        .login-container input {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 1em;
        }
        .login-container input:focus {
            border-color: #004d99;
            outline: none;
        }
        .login-container button {
            width: 100%;
            padding: 10px;
            background: #004d99;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 1em;
            transition: background-color 0.3s ease;
        }
        .login-container button:hover {
            background: #003366;
        }
        .login-container p {
            text-align: center;
            margin-top: 20px;
            color: #666;
            font-size: 0.9em;
        }
        .login-container p a {
            color: #004d99;
            text-decoration: none;
            font-weight: bold;
        }
        .login-container p a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <!-- Navigation Bar -->
    <div class="navbar">
        <div class="logo">
            <a href="#">Magadha Bank</a>
        </div>
        <div class="nav-links">
            <a href="index.jsp">Home</a>
            <a href="#">About Us</a>
            <a href="#">Contact</a>
        </div>
    </div>

    <!-- User Login Form -->
    <div class="login-container">
        <h2>User Login</h2>
        <form action="UserLoginServlet" method="post">
            <input type="email" name="email" placeholder="Enter your email" required>
            <input type="password" name="pin" placeholder="Enter your pin" required>
            <input type="submit" value="Login">
        </form>
        <p>New Register ?<a href="bankRegister.jsp">Click here</a></p>
    </div>
</body>
</html>
