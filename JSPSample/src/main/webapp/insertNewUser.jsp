<%@ page import="com.example.model.User" %>
<%@ page import="com.example.db.UsersService" %>

<%
    User user = new User();
    user.setFirstName(request.getParameter("first_name"));
    user.setLastName(request.getParameter("last_name"));
    user.setSex(request.getParameter("sex"));
    user.setEmail(request.getParameter("email"));
    user.setAddress(request.getParameter("address"));

    UsersService db = new UsersService();
    db.saveUser(user);

    request.setAttribute("link","index.jsp");
    request.setAttribute("msg","Insert new user");

    response.sendRedirect("index.jsp");
%>
