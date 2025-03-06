<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Change PIN</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
        }

        /* Navigation Bar */
        .navbar {
            background-color: #007bff;
            padding: 10px 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            color: white;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }

        .navbar h1 {
            margin: 0;
            font-size: 24px;
        }

        .navbar a {
            color: white;
            text-decoration: none;
            margin: 0 15px;
            font-size: 16px;
            font-weight: bold;
            transition: color 0.3s ease;
        }

        .navbar a:hover {
            color: #ffdd57;
        }

        .navbar .links {
            display: flex;
            align-items: center;
        }

        /* Form Container */
        .form-container {
            background: #ffffff;
            padding: 20px 30px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            width: 100%;
            max-width: 400px;
            margin: 50px auto;
        }

        .form-container h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333333;
        }

        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            display: block;
            margin-bottom: 5px;
            color: #555555;
            font-size: 14px;
        }

        .form-group input {
            width: 100%;
            padding: 10px;
            border: 1px solid #cccccc;
            border-radius: 4px;
            font-size: 14px;
        }

        .form-group input:focus {
            border-color: #007bff;
            outline: none;
            box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
        }

        .btn {
            display: block;
            width: 100%;
            padding: 10px;
            background: #007bff;
            color: #ffffff;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
            text-align: center;
        }

        .btn:hover {
            background: #0056b3;
        }

        .error, .success {
            text-align: center;
            font-size: 14px;
            margin-top: 10px;
        }

        .error {
            color: red;
        }

        .success {
            color: green;
        }
    </style>
</head>
<body>
    <!-- Navigation Bar -->
    <div class="navbar">
        <h1>Bank Management System</h1>
        <div class="links">
            <a href="index.jsp">Home</a>
            <a href="CheckUserDetailsServlet">Check User Details</a>
            <a href="userDashboard.jsp">Change PIN</a>
            <a href="index.jsp">Logout</a>
        </div>
    </div>

    <!-- Change PIN Form -->
    <div class="form-container">
        <h2>Change PIN</h2>
        <form action="PinChangeServlet" method="post">
            <div class="form-group">
                <label for="oldPin">Old PIN:</label>
                <input type="password" id="oldPin" name="oldPin" placeholder="Enter old PIN" required>
            </div>
            <div class="form-group">
                <label for="newPin">New PIN:</label>
                <input type="password" id="newPin" name="newPin" placeholder="Enter new PIN" required>
            </div>
            <div class="form-group">
                <label for="confirmPin">Confirm New PIN:</label>
                <input type="password" id="confirmPin" name="confirmPin" placeholder="Confirm new PIN" required>
            </div>
            <button type="submit" class="btn">Change PIN</button>
        </form>
       
    </div>
</body>
</html>
