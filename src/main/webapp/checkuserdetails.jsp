<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Details</title>
    <style>
        /* General Styles */
        body {
            font-family: 'Roboto', Arial, sans-serif;
            background: linear-gradient(120deg, #f0f4f8, #d9e4f5);
            margin: 0;
            padding: 0;
            color: #333;
        }

        /* Navigation Bar */
        nav {
            background: #fff;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            padding: 10px 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .nav-left {
            font-size: 20px;
            font-weight: bold;
            color: #333;
        }
        .nav-left a {
            text-decoration: none;
            color: inherit;
        }
        .nav-left a:hover {
            color: #007bff;
        }
        .nav-right ul {
            list-style: none;
            margin: 0;
            padding: 0;
            display: flex;
        }
        .nav-right ul li {
            margin: 0 10px;
        }
        .nav-right ul li a {
            color: #333;
            text-decoration: none;
            font-weight: bold;
            padding: 8px 15px;
            border-radius: 4px;
        }
        .nav-right ul li a:hover {
            background: #007bff;
            color: #fff;
            transition: background 0.3s ease;
        }

        /* Container */
        .container {
            max-width: 800px;
            margin: 30px auto;
            background: #fff;
            border-radius: 12px;
            box-shadow: 0 6px 20px rgba(0, 0, 0, 0.15);
            overflow: hidden;
        }

        /* Title */
        .container h2 {
            background: #007bff;
            color: #fff;
            text-align: center;
            margin: 0;
            padding: 15px 0;
            font-size: 24px;
            font-weight: bold;
            text-transform: uppercase;
        }

        /* Table Styles */
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
        }
        table th,
        table td {
            padding: 15px;
            text-align: left;
        }
        table th {
            background: #f8f9fa;
            color: #333;
            text-transform: uppercase;
            font-size: 14px;
            border-bottom: 2px solid #ddd;
        }
        table tr:nth-child(odd) {
            background: #f4f4f9;
        }
        table tr:hover {
            background: #e9ecef;
            cursor: pointer;
        }
        table td {
            color: #555;
            font-size: 14px;
            border-bottom: 1px solid #ddd;
        }

        /* Footer */
        .footer {
            text-align: center;
            padding: 15px 0;
            font-size: 14px;
            color: #666;
            background: #f8f9fa;
            margin-top: 20px;
        }
        .footer a {
            color: #007bff;
            text-decoration: none;
        }
        .footer a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <nav>
        <div class="nav-left">
            <a href="userDashboard.jsp">Magadha Bank</a>
        </div>
        <div class="nav-right">
            <ul>
                <li><a href="userDashboard.jsp">Dashboard</a></li>
                <li><a href="pinchange.jsp">Change PIN</a></li>
                <li><a href="index.jsp">Logout</a></li>
            </ul>
        </div>
    </nav>

    <div class="container">
        <h2>User Details</h2>
        <table>
            <tr>
                <th>Field</th>
                <th>Details</th>
            </tr>
            <tr>
                <td>User ID</td>
                <td>${userId}</td>
            </tr>
            <tr>
                <td>Name</td>
                <td>${userName}</td>
            </tr>
            <tr>
                <td>Email</td>
                <td>${email}</td>
            </tr>
            <tr>
                <td>Aadhar</td>
                <td>${aadhar}</td>
            </tr>
            <tr>
                <td>Mobile Number</td>
                <td>${mobile}</td>
            </tr>
            <tr>
                <td>PAN</td>
                <td>${pan}</td>
            </tr>
            <tr>
                <td>Address</td>
                <td>${address}</td>
            </tr>
            <tr>
                <td>Gender</td>
                <td>${gender}</td>
            </tr>
            <tr>
                <td>User PIN</td>
                <td>${userPin}</td>
            </tr>
            <tr>
                <td>Account Number</td>
                <td>${accountNumber}</td>
            </tr>
            <tr>
                <td>Status</td>
                <td>${status}</td>
            </tr>
            <tr>
                <td>Amount</td>
                <td>${amount}</td>
            </tr>
        </table>
    </div>

    <div class="footer">
        <p>&copy; 2024 Magadha Bank. All rights reserved. | <a href="help.jsp">Help</a></p>
    </div>
</body>
</html>
