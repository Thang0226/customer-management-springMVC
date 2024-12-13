<%--
  Created by IntelliJ IDEA.
  User: thang
  Date: 13/12/24
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Information</title>
</head>
<body>
<h2>Customer Information</h2>
<form method="post" action="customer?action=update">
    <fieldset>
        <legend>Customer Information</legend>
        <table>
            <tr>
                <td>ID:</td>
                <td>${customer.id}</td>
                <input type="hidden" name="customer_id" value="${customer.id}">
            </tr>
            <tr>
                <td><label for="name">Name:</label></td>
                <td><input type="text" id="name" name="name" value="${customer.name}"></td>
            </tr>
            <tr>
                <td><label for="email">Email:</label></td>
                <td><input type="email" id="email" name="email" value="${customer.email}"></td>
            </tr>
            <tr>
                <td><label for="address">Address:</label></td>
                <td><input type="text" id="address" name="address" value="${customer.address}"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Update"></td>
                <td></td>
            </tr>
        </table>
    </fieldset>
</form>
<a href="customers">Back to customer list</a>
</body>
</html>
