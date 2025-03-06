<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Credit</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f9;
        }
        header {
            background-color: #004080;
            color: white;
            padding: 10px 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        header h1 {
            margin: 0;
        }
        nav ul {
            list-style: none;
            margin: 0;
            padding: 0;
            display: flex;
        }
        nav ul li {
            margin: 0 10px;
        }
        nav ul li a {
            color: white;
            text-decoration: none;
            padding: 5px 10px;
            border-radius: 5px;
            transition: background 0.3s;
        }
        nav ul li a:hover {
            background-color: #0056b3;
        }
        .form-container {
            max-width: 500px;
            margin: 50px auto;
            background: white;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            padding: 20px;
        }
        .form-container h2 {
            color: #004080;
            margin-bottom: 20px;
            text-align: center;
        }
        .form-container form {
            display: flex;
            flex-direction: column;
        }
        .form-container label {
            margin-bottom: 5px;
            font-weight: bold;
            color: #333;
        }
        .form-container input[type="number"] {
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }
        .form-container input[type="submit"] {
            background-color: #004080;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: background 0.3s;
        }
        .form-container input[type="submit"]:hover {
            background-color: #0056b3;
        }
        footer {
            text-align: center;
            background-color: #004080;
            color: white;
            padding: 10px;
            margin-top: 178px;
        }
    </style>
</head>
<body>
    <header>
        <h1>Bank Transaction</h1>
        <nav>
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="userDashboard.jsp">Dashboard</a></li>
            </ul>
        </nav>
    </header>

    <main>
        <div class="form-container">
            <h2>Credit Amount</h2>
            <form action="ProcessCreditServlet" method="post">
                <label for="creditAmount">Credit Amount</label>
                <input type="number" id="creditAmount" name="transactionAmount" placeholder="Enter amount to credit" required>

                <!-- Hidden User ID fetched from the HTTP session -->
                <input type="hidden" id="userIdCredit" name="userId" value="<%= session.getAttribute("userId") %>">

                <input type="submit" value="Submit Credit">
            </form>
        </div>
    </main>

    <footer>
        &copy; 2024 Bank Management System. All rights reserved.
    </footer>
</body>
</html>
