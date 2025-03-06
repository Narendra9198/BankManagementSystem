<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background: linear-gradient(to bottom, #f4f4f9, #cce7ff);
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
            font-size: 1.5em;
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
        nav ul li form {
            display: inline;
        }
        nav ul li button {
            color: white;
            background: none;
            border: none;
            padding: 5px 15px;
            cursor: pointer;
            font-size: 1em;
            transition: background 0.3s, color 0.3s;
        }
        nav ul li button:hover {
            background-color: #0056b3;
            color: #fff;
            border-radius: 5px;
        }
        .service-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
            gap: 20px;
            padding: 40px;
            max-width: 1200px;
            margin: auto;
        }
        .service-card {
            background: white;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            text-align: center;
            padding: 20px;
            transition: transform 0.3s, box-shadow 0.3s;
        }
        .service-card:hover {
            transform: translateY(-5px);
            box-shadow: 0 6px 10px rgba(0, 0, 0, 0.15);
        }
        .service-card form {
            display: inline;
            border: none;
        }
        .service-card img {
            max-width: 100%;
            border-radius: 10px;
            margin-bottom: 15px;
        }
        .service-card h2 {
            color: #004080;
            margin: 10px 0;
        }
        .service-card p {
            color: #333;
            margin: 0;
        }
        .info-section {
            background: white;
            padding: 20px;
            margin: 40px auto;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            max-width: 1200px;
        }
        .info-section h2 {
            color: #004080;
            margin-bottom: 20px;
        }
        .info-section ul {
            padding-left: 20px;
        }
        .info-section ul li {
            margin: 10px 0;
        }
        footer {
            text-align: center;
            background-color: #004080;
            color: white;
            padding: 15px;
        }
    </style>
</head>
<body>
    <header>
        <h1>User Dashboard</h1>
        <nav>
            <ul>
                <li>
                    <form action="index.jsp" method="get">
                        <button type="submit">Home</button>
                    </form>
                </li>
                <li>
                    <form action="CheckUserDetailsServlet" method="post">
                        <button type="submit">Check User Details</button>
                    </form>
                </li>
                <li>
                    <form action="BalanceCheckServlet" method="post">
                        <button type="submit">Check Balance</button>
                    </form>
                </li>
                <li>
                    <form action="userDebit.jsp" method="get">
                        <button type="submit">Debit</button>
                    </form>
                </li>
                <li>
                    <form action="userCredit.jsp" method="get">
                        <button type="submit">Credit</button>
                    </form>
                </li>
                <li>
                    <form action="mobileNumberTransaction.jsp" >
                        <button type="submit">Mobile Transaction</button>
                    </form>
                </li>
                <li>
                    <form action="PrintBankStatement" method="post">
                        <button type="submit">Transaction History</button>
                    </form>
                </li>
                <li>
                    <form action="pinchange.jsp" method="get">
                        <button type="submit">PIN Change</button>
                    </form>
                </li>
            </ul>
        </nav>
    </header>

    <main>
        <div class="service-grid">
            <div class="service-card">
                <form action="BalanceCheckServlet" method="post">
                    <button type="submit" style="background: none; border: none; cursor: pointer;">
                        <img src="https://via.placeholder.com/150/004080/ffffff?text=Check+Balance" alt="Check Balance">
                        <h2>Check Balance</h2>
                        <p>Monitor your account balance securely and efficiently.</p>
                    </button>
                </form>
            </div>
            <div class="service-card">
                <form action="userDebit.jsp" method="get">
                    <button type="submit" style="background: none; border: none; cursor: pointer;">
                        <img src="https://via.placeholder.com/150/004080/ffffff?text=Debit" alt="Debit">
                        <h2>Debit</h2>
                        <p>Instant debit transactions with detailed records.</p>
                    </button>
                </form>
            </div>
            <div class="service-card">
                <form action="userCredit.jsp" method="get">
                    <button type="submit" style="background: none; border: none; cursor: pointer;">
                        <img src="https://via.placeholder.com/150/004080/ffffff?text=Credit" alt="Credit">
                        <h2>Credit</h2>
                        <p>Quick credit services to enhance your financial flexibility.</p>
                    </button>
                </form>
            </div>
            <div class="service-card">
                <form action="mobileNumberTransaction.jsp" method="get">
                    <button type="submit" style="background: none; border: none; cursor: pointer;">
                        <img src="https://via.placeholder.com/150/004080/ffffff?text=Mobile+Transaction" alt="Mobile Transaction">
                        <h2>Mobile Transaction</h2>
                        <p>Transfer funds using registered mobile numbers securely.</p>
                    </button>
                </form>
            </div>
            <div class="service-card">
                <form action="PrintBankStatement" method="post">
                    <button type="submit" style="background: none; border: none; cursor: pointer;">
                        <img src="https://via.placeholder.com/150/004080/ffffff?text=Transaction+History" alt="Transaction History">
                        <h2>Transaction History</h2>
                        <p>View and manage your past transactions easily.</p>
                    </button>
                </form>
            </div>
            <div class="service-card">
                <form action="pinchange.jsp" method="get">
                    <button type="submit" style="background: none; border: none; cursor: pointer;">
                        <img src="https://via.placeholder.com/150/004080/ffffff?text=PIN+Change" alt="PIN Change">
                        <h2>PIN Change</h2>
                        <p>Update your PIN to keep your account secure.</p>
                    </button>
                </form>
            </div>
        </div>

        <section class="info-section">
            <h2>Banking Rules and Guidelines</h2>
            <ul>
                <li>Maintain a minimum balance in your account to avoid penalties.</li>
                <li>Keep your login credentials and PIN confidential.</li>
                <li>Regularly update your contact information for secure communication.</li>
                <li>Check transaction history frequently to identify any unauthorized activity.</li>
                <li>Do not share your OTP (One Time Password) or banking information over phone or email.</li>
            </ul>
        </section>
    </main>

    <footer>
        &copy; 2024 Bank Management System. All rights reserved.
    </footer>
</body>
</html>
