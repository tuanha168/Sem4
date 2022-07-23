<%@ page import="com.service.EmployeeServiceImpl" %>
<%@ page import="com.model.Employee" %>
<%@ page import="java.util.List" %>
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
                                EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
                                List<Employee> employeeList = employeeService.getAllEmployees();
                                if(employeeList.size()>0) {
                                    for (int i = 0; i < employeeList.size(); i++) {
                                        Employee employee = employeeList.get(i); %>
                            <tr>
<%--                                <td class=tdTop><%= employee.getBrand() %></td>--%>
<%--                                <td class=tdTop><%= employee.getMadein() %></td>--%>
                                <td class=tdTop><%= employee.getName() %></td>
<%--                                <td class=tdTop>$<%= employee.getPrice() %></td>--%>
                                <td class=tdTop><a href="productAdd.jsp?id=<%=employee.getId() %>"> <img border="0" src="images/edit1.gif" width="17" height="17"></a>
                                    <a href="javascript:doDelete(<%=employee.getId() %>);">
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
            </table>
        </td>

    </tr>
</table>

</body>
</html>
