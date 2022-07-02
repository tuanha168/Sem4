<%@ page import="com.example.db.ProductService" %>
<%@ page import="com.example.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page
        import="com.example.db.UsersService" %>
<%@ page
        import="com.example.model.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <LINK href="style.css" rel=STYLESHEET type="text/css">
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<script>
    function doDelete(id){
        var result = confirm('Do you really want to delete this product')
        if(result) {
            document.location.href="productDelete.jsp?id=" + id;
        }
        else {
            return;
        }
    }
    function doAdd(){
        document.location.href = "productAdd.jsp";
    }
    function doDeleteUser(id){
        var result = confirm('Do you really want to delete this user')
        if(result) {
            document.location.href="deleteUser.jsp?id=" + id;
        }
        else {
            return;
        }
    }
    function doAddUser(){
        document.location.href = "register.jsp";
    }


</script>
<table border="0" cellpadding="0" cellspacing="0" width="100%" height="100%">
    <tr>
        <td width="100%" colspan="2" height="55" background="images/TopBar.bmp"><table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111" width="100%" id="AutoNumber2">
        </table></td>
    </tr>
    <tr>
        <td><table border="0" cellpadding="0" cellspacing="0" width="140" height="100%">
            <tr>
                <td align="center" valign="top" height="100%" class=tdLeftBanner>
                    <table border="0" cellpadding="0" cellspacing="0" height="29" width=140>
                    <tr>
                        <td width="140" height="29" background="images/DateBar.bmp" align="center"
                            class=tdDate>&nbsp;</td>
                    </tr>
                </table>
                    <b><br>
                        <a href="register.jsp">User</a></b>
                    <hr noshade color="#919191" size="1" width="120"></td>
            </tr>
        </table></td>
        <td valign="top" class=tdNormal height="100%" width="100%" bgcolor="#FFFEF9">
            <table border="0" cellpadding="10" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111" width="100%" id="AutoNumber1">
            <tr>
                <td width="100%"><H1 class=H1>Product list</H1>
                    <table class=table1 border="0" cellpadding="3" cellspacing="0" width="100%" style="border-collapse: collapse" bordercolor="#111111">
                        <tr>
                            <td class=thCenter>Brand
                            <td class=thCenter>Made in
                            <td class=thCenter>Name
                            <td class=thCenter>Price
                            <td class=thCenter> Action </td>
                        </tr>

                        <%
                            //generate rows
                            ProductService productService = new ProductService();
                            List<Product> productList = productService.getAllProduct();
                            if(productList.size()>0) {
                                for (int i = 0; i < productList.size(); i++) {
                                    Product product = productList.get(i); %>
                        <tr>
                            <td class=tdTop><%= product.getBrand() %></td>
                            <td class=tdTop><%= product.getMadein() %></td>
                            <td class=tdTop><%= product.getName() %></td>
                            <td class=tdTop>$<%= product.getPrice() %></td>
                            <td class=tdTop><a href="productAdd.jsp?id=<%=product.getId() %>"> <img border="0" src="images/edit1.gif" width="17" height="17"></a>
                                <a href="javascript:doDelete(<%=product.getId() %>);">
                                    <img border="0" src="images/delete1.gif" width="17" height="17"></a> </td>
                        </tr>
                        <%
                                }
                            }
                        %>
                    </table>
                    <br>
                    <input type="button" value="Add new Product" name="adduser" onClick="javascript:doAdd()">
                </td>
            </tr>
            <tr>
                <td width="100%"><H1 class=H1>Users list</H1>
                    <table class=table1 border="0" cellpadding="3" cellspacing="0" width="100%" style="border-collapse: collapse" bordercolor="#111111">
                        <tr>
                            <td class=thCenter>First Name
                            <td class=thCenter>Last Name
                            <td class=thCenter>Email
                            <td class=thCenter>Sex
                            <td class=thCenter>Address
<%--                            <td class=thCenter>Products--%>
                            <td class=thCenter>Action</td>
                        </tr>

                        <%
                            //generate rows
                            UsersService usersService = new UsersService();
                            List<User> usersList = usersService.getAllUser();
                            if(usersList.size()>0) {
                                for (int i = 0; i < usersList.size(); i++) {
                                    User user = usersList.get(i); %>
                        <tr>
                            <td class=tdTop><%= user.getFirstName() %></td>
                            <td class=tdTop><%= user.getLastName() %></td>
                            <td class=tdTop><%= user.getEmail() %></td>
                            <td class=tdTop><%= user.getSex() == "F" ? "Female" : "Male" %></td>
                            <td class=tdTop><%= user.getAddress() %></td>
<%--                            <td class=tdTop><%= user.getProducts() %></td>--%>
                            <td class=tdTop><a href="register.jsp?id=<%=user.getId() %>"> <img border="0" src="images/edit1.gif" width="17" height="17"></a>
                                <a href="javascript:doDeleteUser(<%=user.getId() %>);">
                                    <img border="0" src="images/delete1.gif" width="17" height="17"></a> </td>
                        </tr>
                        <%
                                }
                            }
                        %>
                    </table>
                    <br>
                    <input type="button" value="Add new User" name="adduser" onClick="javascript:doAddUser()">
                </td>
            </tr>
            </table>
        </td>

    </tr>
</table>

</body>
</html>
