<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.model.BankUserRegisterDetails" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        .navbar {
            background-color: #333;
            overflow: hidden;
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 0 20px;
        }
        .navbar a {
            color: white;
            text-decoration: none;
            padding: 14px 20px;
            display: block;
        }
        .navbar a:hover {
            background-color: #575757;
        }
        .navbar .logout {
            background-color: red;
            border-radius: 5px;
        }
        h1 {
            text-align: center;
            margin-top: 20px;
        }
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }
        th, td {
            padding: 10px;
            text-align: center;
            border: 1px solid #ddd;
        }
        th {
            background-color: #f4f4f4;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        .action-buttons button {
            padding: 5px 10px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
        .accept {
            background-color: #4CAF50;
            color: white;
        }
        .reject {
            background-color: #f44336;
            color: white;
        }
    </style>
</head>
<body>
    <div class="navbar">
        <a href="adminDashboard.jsp">Dashboard</a>
        <a href="profile.jsp">Profile</a>
        <a href="logoutServlet" class="logout">Logout</a>
    </div>

    <h1>Admin Dashboard</h1>

    <table>
        <thead>
            <tr>
                <th>Request ID</th>
                <th>User Name</th>
                <th>Email</th>
                <th>Mobile</th>
                <th>Address</th>
                <th>Gender</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <% 
                List<BankUserRegisterDetails> requests = 
                    (List<BankUserRegisterDetails>) request.getAttribute("bankUserRegisterDetails");
                if (requests != null && !requests.isEmpty()) {
                    for (BankUserRegisterDetails details : requests) {
            %>
            <tr>
                <td><%= details.getUserId() %></td>
                <td><%= details.getUserName() %></td>
                <td><%= details.getEmail() %></td>
                <td><%= details.getMobile() %></td>
                <td><%= details.getAddress() %></td>
                <td><%= details.getGender() %></td>
                <td class="action-buttons">
                    <form action="ProcessRequestServlet" method="post" style="display: inline;">
                        <input type="hidden" name="userId" value="<%= details.getUserId() %>">
                        <button class="accept" name="action" value="accept">Accept</button>
                    </form>
                    <form action="ProcessRequestServlet" method="post" style="display: inline;">
                        <input type="hidden" name="userId" value="<%= details.getUserId() %>">
                        <button class="reject" name="action" value="reject">Reject</button>
                    </form>
                </td>
            </tr>
            <% 
                    }
                } else {
            %>
            <tr>
                <td colspan="7">No pending requests</td>
            </tr>
            <% 
                }
            %>
        </tbody>
    </table>
</body>
</html>
