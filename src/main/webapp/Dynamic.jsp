<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.mobile.app.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Jabilamma Mobile Booking Store</title>
    <style>
        body {
            margin: 0;
            font-family: 'Poppins', sans-serif;
            background: linear-gradient(180deg, #f4f6f9, #dfe4ea);
            color: #333;
        }

        .navbar {
            background: linear-gradient(90deg, #002244, #0055aa);
            padding: 15px 25px;
            color: white;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.3);
            position: sticky;
            top: 0;
            z-index: 1000;
            transition: all 0.3s ease-in-out;
        }

        .container {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .logo {
            font-size: 26px;
            font-weight: bold;
            text-decoration: none;
            color: #ffcc00;
            text-shadow: 2px 2px 10px rgba(255, 204, 0, 0.7);
            transition: transform 0.3s ease-in-out;
        }

        .logo:hover {
            transform: scale(1.1);
        }

        .nav-links {
            list-style: none;
            display: flex;
            margin: 0;
            padding: 0;
        }

        .nav-links li {
            margin: 0 15px;
        }

        .nav-links a {
            text-decoration: none;
            color: white;
            font-size: 16px;
            font-weight: bold;
            padding: 8px 12px;
            border-radius: 5px;
            transition: all 0.3s ease;
        }

        .nav-links a:hover {
            background: #ffcc00;
            color: #222;
            box-shadow: 0 4px 10px rgba(255, 204, 0, 0.6);
        }

        .product-list {
            padding: 40px;
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 25px;
        }

        .product-card {
            background: white;
            border-radius: 15px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);
            overflow: hidden;
            transition: transform 0.3s ease, box-shadow 0.3s ease;
            width: 520px;
            display: flex;
            align-items: center;
            padding: 18px;
        }

        .product-card:hover {
            transform: scale(1.05);
            box-shadow: 0 12px 25px rgba(0, 0, 0, 0.3);
        }

        .product-card img {
            width: 170px;
            height: 170px;
            object-fit: contain;
            background: #f1f1f1;
            padding: 12px;
            border-radius: 10px;
        }

        .product-info {
            padding-left: 25px;
            flex: 1;
        }

        .product-title {
            font-size: 22px;
            font-weight: bold;
            color: #222;
        }

        .product-price {
            font-size: 20px;
            color: #004aad;
            font-weight: bold;
            margin: 6px 0;
        }

        .product-offer {
            font-size: 15px;
            color: #388e3c;
            font-weight: bold;
        }

        .product-specs {
            font-size: 15px;
            color: #555;
            margin: 6px 0;
        }

        .product-specs ul {
            padding-left: 20px;
        }

        .product-specs ul li {
            font-size: 14px;
            color: #666;
            margin: 3px 0;
        }

        .buy-now {
            display: inline-block;
            background: linear-gradient(90deg, #ff5722, #ff9800);
            color: white;
            padding: 12px 16px;
            text-decoration: none;
            border-radius: 10px;
            font-size: 15px;
            font-weight: bold;
            transition: background 0.3s ease, transform 0.2s ease;
            border: none;
            cursor: pointer;
            width: 130px;
            text-align: center;
        }

        .buy-now:hover {
            background: linear-gradient(90deg, #e64a19, #ff6d00);
            transform: scale(1.1);
        }

        .logout-message {
            background: #f44336;
            color: white;
            padding: 14px;
            text-align: center;
            display: none;
            font-size: 17px;
            font-weight: bold;
            border-radius: 8px;
            margin-top: 12px;
            transition: opacity 1s ease-out;
        }

    </style>
</head>
<body>

<nav class="navbar">
    <div class="container">
        <a href="#" class="logo">Jabilamma Mobile Booking Store</a>
        <ul class="nav-links">
            <li><a href="Dynamic.jsp">Home</a></li>
            <li><a href="MyOrders.jsp">My Orders</a></li>
            <li><a href="Contact.html">Contact</a></li>
            <li><a href="about.html">About</a></li>
            <li><a href="registration.html">Register / Login</a></li>
            <li><a href="logout" id="logoutBtn">Logout</a></li>
        </ul>
    </div>
</nav>

<div id="logoutMessage" class="logout-message">Logged out successfully.</div>

<div class="product-list">
<%
for (int i = 1; i < 13; i++) {
    String[] phone = PhoneServlet.phonedata(i);
    String[] arr = phone[2].split("}");
%>
    <div class="product-card">
        <img src="<%= phone[3] %>" alt="mobile image">
        <div class="product-info">
            <div class="product-title"><%= phone[0] %></div>
            <div class="product-price">₹<%= phone[1] %></div>
            <div class="product-offer"><%= arr[0] %></div>
            <div class="product-specs">
                <strong>Highlights:</strong>
                <ul>
                    <li><%= arr[1] %></li>
                    <li><%= arr[2] %></li>
                    <li><%= arr[3] %></li>
                </ul>
            </div>
            <form action="Buy.jsp" method="post">
                <input type="hidden" name="phoneid" value="<%= i %>">
                <button type="submit" class="buy-now">Buy Now</button>
            </form>
        </div>
    </div>
<% } %>
</div>

<script>
    document.getElementById('logoutBtn').addEventListener('click', function() {
        document.getElementById('logoutMessage').style.display = 'block';
        setTimeout(() => document.getElementById('logoutMessage').style.opacity = '0', 2000);
    });
</script>

</body>
</html>


