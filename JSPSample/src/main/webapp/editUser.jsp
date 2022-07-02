<%@ page import="com.example.model.User" %>
<%@ page import="com.example.db.UsersService" %>

<%
    User user =  new User();
    user.setId(Integer.parseInt(request.getParameter("id")));
    user.setFirstName(request.getParameter("first_name"));
    user.setLastName(request.getParameter("last_name"));
    user.setEmail(request.getParameter("email"));
    user.setSex(request.getParameter("sex"));
    user.setAddress(request.getParameter("address"));

    UsersService db = new UsersService();
    db.updateUser(user);

    request.setAttribute("link","index.jsp");
    request.setAttribute("msg","Insert new user");

    response.sendRedirect("index.jsp");
%>
