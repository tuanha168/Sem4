<%--
  Created by IntelliJ IDEA.
  User: Hoang
  Date: 5/27/2022
  Time: 7:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h3><a href="/Class3Hibernate_war/new">New Customer</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${listEmployee}" var="emp">
            <tr>
                <td>${emp.id}</td>
                <td>${emp.name}</td>
                <td>${emp.age}</td>
                <td>
                    <a href="/edit?id=${emp.id}">Edit</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="/delete?id=${emp.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
