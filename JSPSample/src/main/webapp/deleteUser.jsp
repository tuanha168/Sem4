<%@ page import="com.example.model.User" %>
<%@ page import="com.example.db.UsersService" %>

<%
    User user =  new User();
    user.setId(Integer.parseInt(request.getParameter("id")));

    UsersService db = new UsersService();
    db.deleteUser(user);

    request.setAttribute("link","index.jsp");
    request.setAttribute("msg","Insert new User");

    response.sendRedirect("index.jsp");
%>
