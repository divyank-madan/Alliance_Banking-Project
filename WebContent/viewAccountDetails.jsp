<%@ page import="account_info.Account_Service , customer_master.Customer_Master_Pojo" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #4CAF50;
  color: white;
}
.example{
margin-top:50px;
float:right;
margin-right:300px;
}
</style>
<style>
.vertical-menu {
  width: 200px;
}

.vertical-menu a {
  background-color: #eee;
  color: black;
  display: block;
  padding: 12px;
  text-decoration: none;
}

.vertical-menu a:hover {
  background-color: #ccc;
}

.vertical-menu a.active {
  background-color: #4CAF50;
  color: white;
}

</style>

<style>
body {
  font-family: Arial;
}

* {
  box-sizing: border-box;
}

form.example input[type=text] {
  padding: 10px;
  font-size: 17px;
  border: 1px solid grey;
  float: left;
  width: 80%;
  background: #f1f1f1;
}

form.example button {
  float: left;
  width: 20%;
  padding: 10px;
  background: #2196F3;
  color: white;
  font-size: 17px;
  border: 1px solid grey;
  border-left: none;
  cursor: pointer;
}

form.example button:hover {
  background: #0b7dda;
}

form.example::after {
  content: "";
  clear: both;
  display: table;
}
.topnav-right {
  float: right;
}
</style>

</head>
<body background="1.jpg" style="background-repeat:no-repeat;background-size:cover">
<div class="topnav">
  <a href="dashboard.html">Dashboard</a>
  <a href="#news">News</a>
  <a href="#contact">Contact</a>
  <a href="#about">About</a>
  <form class="example" action="/action_page.php" style="margin:auto;max-width:300px;margin-left:100px">
  <input type="text" placeholder="Search.." name="search2">
  <button type="submit"><i class="fa fa-search"></i></button>
  </form>
  <a href="#logout">Logout</a>		
</div>
<div style="padding-left:16px">  
</div>
</body>
<body>
<div class="vertical-menu">
  <a href="addAccount.html">Add Account</a>
  <a href="deleteAccount.html">Delete Account</a>
  <a href="updateAccount.html">Update Account</a>
  <a class="active" href="#">View Account</a>
</div>

<center>
<div id="container" style="height:150px;width:400px;background-color:lightgrey;margin-top:-150px ">

<fieldset>
<%
String accountid=request.getParameter("viewid");
Account_Service as2 = new Account_Service();
Customer_Master_Pojo ob = as2.viewAccount(accountid);
String details=ob.toString();
out.print(details);
%>
</fieldset>

</div>
</center>
</body>

</html>
</DOCTYPE>