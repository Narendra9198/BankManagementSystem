<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.text.DecimalFormat" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Check Balance</title>
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
            text-align: center;
        }
        .balance-container {
            margin: 20px auto;
            padding: 20px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            max-width: 600px;
            text-align: center;
        }
        .error-message {
            color: red;
            font-weight: bold;
        }
        .balance-info {
            font-size: 24px;
            color: #004080;
            margin-top: 20px;
        }
        footer {
            background-color: #004080;
            color: white;
            padding: 15px;
            text-align: center;
            position: fixed;
            width: 100%;
            bottom: 0;
        }
    </style>
</head>
<body>

<header>
    <h1>Account Balance</h1>
</header>

<main>
    <div class="balance-container">
        <h2>Your Current Balance</h2>
        
        <%
            Double balance = (Double) request.getAttribute("balance");
            String errorMessage = (String) request.getAttribute("errorMessage");
            
            if (errorMessage != null) {
        %>
            <p class="error-message"><%= errorMessage %></p>
        <%
            } else {
                // Check if balance is null
                if (balance == null) {
        %>
            <p class="error-message">Balance not available. Please try again later.</p>
        <%
                } else {
                    // Format and display the balance
                    DecimalFormat df = new DecimalFormat("###,###.##");
        %>
            <p class="balance-info">Your balance: Rs:<%= df.format(balance) %></p>
        <%
                }
            }
        %>
    </div>
</main>

<footer>
    &copy; 2024 Magadha Bank. All rights reserved.
</footer>

</body>
</html>
