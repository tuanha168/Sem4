<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
    <title>Confirmation</title>
</head>

<body>
<!--  store information into the bean and redisplay it for user's confirmation-->
<jsp:useBean id="newUser" class="com.example.model.User"
             type="com.example.model.User"  scope="session"/>

<jsp:setProperty name="newUser" property="firstName" param="first_name" />
<jsp:setProperty name="newUser" property="lastName" param="last_name" />
<jsp:setProperty name="newUser" property="address" param="address" />
<jsp:setProperty name="newUser" property="sex" param="sex" />
<jsp:setProperty name="newUser" property="email" param="email" />

<center>
    <table>
        <tr>
            <th colspan="2">Your information.</th>
        </tr>
        <tr>
            <td>First name : </td>
            <td><jsp:getProperty name="newUser" property="firstName" /></td>
        </tr>

        <tr>
            <td>Last name : </td>
            <td><jsp:getProperty name="newUser" property="lastName" /></td>
        </tr>

        <tr>
            <td>Email : </td>
            <td><jsp:getProperty name="newUser" property="email" /></td>
        </tr>

        <tr>
            <td>Sex : </td>
            <td><jsp:getProperty name="newUser" property="sex" /></td>
        </tr>

        <tr>
            <td>Address : </td>
            <td><jsp:getProperty name="newUser" property="address" /></td>
        </tr>
        <tr>
            <td><a href="javascript:history.back(-1)">Back</a></td>
            <td align="right"><a href="insertNewUser.jsp">Accept</a></td>
        </tr>
    </table>
</center>
</body>
</html>
