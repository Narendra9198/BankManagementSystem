<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.model.BankStatementDeatils" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bank Statement</title>
    <link rel="stylesheet" href="styles.css"> <!-- Link to external CSS -->
    <style>
        /* Basic styling for navbar and table */
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
        }

        .navbar {
            background-color: #007bff;
            padding: 1rem;
            display: flex;
            justify-content: space-between;
            align-items: center;
            color: white;
        }

        .navbar a {
            color: white;
            text-decoration: none;
            font-weight: bold;
            margin: 0 15px;
        }

        .navbar a:hover {
            text-decoration: underline;
        }

        .container {
            margin: 20px auto;
            width: 80%;
            padding: 20px;
            background-color: white;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }

        h1 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        table th, table td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }

        table th {
            background-color: #007bff;
            color: white;
        }

        table tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        table tr:hover {
            background-color: #ddd;
        }

        .btn {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 5px;
            font-size: 16px;
        }

        .btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <!-- Navigation Bar -->
    <div class="navbar">
        <span>Welcome, User</span>
        <div>
            <a href="userDashboard.jsp">User Dashboard</a>
            <a href="logout.jsp">Logout</a>
        </div>
    </div>

    <!-- Container for Bank Statement -->
    <div class="container">
        <h1>Bank Statement</h1>

        <!-- Check if there are transactions -->
        <%
            List<BankStatementDeatils> transactions = (List<BankStatementDeatils>) request.getAttribute("transactions");
            if (transactions == null || transactions.isEmpty()) {
        %>
            <p style="text-align: center; color: #555;">No transactions found.</p>
        <% } else { %>
        <table>
            <thead>
                <tr>
                    <th>Transaction ID</th>
                    <th>Date</th>
                    <th>Time</th>
                    <th>Amount</th>
                    <th>Balance</th>
                    <th>Type</th>
                </tr>
            </thead>
            <tbody>
                <% for (BankStatementDeatils transaction : transactions) { %>
                <tr>
                    <td><%= transaction.getTransaction_id() %></td>
                    <td><%= transaction.getDate_of_transaction() %></td>
                    <td><%= transaction.getTime_of_transaction() %></td>
                    <td><%= transaction.getTransaction_amount() %></td>
                    <td><%= transaction.getBalance_amount() %></td>
                    <td><%= transaction.getTransaction_type() %></td>
                </tr>
                <% } %>
            </tbody>
        </table>
        <% } %>
    </div>
</body>
</html>
