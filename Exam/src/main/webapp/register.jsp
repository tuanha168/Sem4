<%@ page
        import="com.example.db.UsersService" %>
<%@ page
        import="com.example.model.User" %>
<%@ page
        contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<%
    String action = "insertNewUser.jsp";
    User user = null;
    Boolean isEdit = false;
    if (request.getParameter("id") != null && !request.getParameter("id").isEmpty() && !request.getParameter("id").trim().isEmpty()) {
        UsersService db = new UsersService();
        user = db.getUser(Integer.parseInt(request.getParameter("id")));
        action = "editUser.jsp";
        isEdit = true;
    }

%>
<html>

<head>
    <LINK href="fcm.css"
          rel=STYLESHEET>
</head>

<body topmargin="0"
      leftmargin="0">
<script>
    function doAdd() {
        document.forms[0].submit();
    }

    function doCancel() {
        document.location.href = "userList.jsp";
    }
</script>

<table border="0"
       cellpadding="0"
       cellspacing="0"
       width="100%"
       height="100%">
    <tr>
        <td width="100%"
            colspan="2"
            height="55"
            background="images/TopBar.bmp">
            <table border="0"
                   cellpadding="0"
                   cellspacing="0"
                   style="border-collapse: collapse"
                   bordercolor="#111111"
                   width="100%"
                   id="AutoNumber2">

            </table>
        </td>
    </tr>
    <tr>
        <td>
            <table border="0"
                   cellpadding="0"
                   cellspacing="0"
                   width="140"
                   height="100%">
                <tr>
                    <td align="center"
                        valign="top"
                        height="100%"
                        class=tdLeftBanner>
                        <table border="0"
                               cellpadding="0"
                               cellspacing="0"
                               height="29"
                               width=140>
                            <tr>
                                <td width="140"
                                    height="29"
                                    background="images/DateBar.bmp"
                                    align="center"
                                    class=tdDate>
                                    &nbsp;
                                </td>
                            </tr>
                        </table>
                        <b><br>
                            User</b>
                        <hr noshade
                            color="#919191"
                            size="1"
                            width="120">
                    </td>
                </tr>
            </table>
        </td>
        <td valign="top"
            class=tdNormal
            height="100%"
            width="100%"
            bgcolor="#FFFEF9">
            <table border="0"
                   cellpadding="10"
                   cellspacing="0"
                   width="100%">
                <tr>
                    <td width="100%">
                        <H1 class=H1><%=isEdit ? "Edit" : "Add"%>
                            new
                            user</H1>
                        <input style="display:none;"
                               hidden
                               type="text"
                               name="id"
                               size="20"
                               value="<%=  user != null ? user.getId() : "" %>">
                    </td>
                    <form method="post"
                          action="<%= action %>">
                        <table border="0"
                               cellpadding="3"
                               cellspacing="0"
                               width="100%"
                               class=table1>
                            <tr>
                                <td width="22%"
                                    class=tdEven>
                                    First
                                    Name
                                </td>
                                <td width="78%"
                                    class=tdEven>
                                    <input type="text"
                                           name="first_name"
                                           size="20"
                                           value="<%=  user != null ? user.getFirstName() : "" %>">
                                </td>
                            </tr>
                            <tr>
                                <td width="22%"
                                    class=tdodd>
                                    Last
                                    Name
                                </td>
                                <td width="78%"
                                    class=tdOdd>
                                    <input type="text"
                                           name="last_name"
                                           size="20"
                                           value="<%= user != null ? user.getLastName() : "" %>">
                                </td>
                            </tr>
                            <tr>
                                <td width="22%"
                                    class=tdEven>
                                    Email
                                </td>
                                <td width="78%"
                                    class=tdEven>
                                    <input type="email"
                                           name="email"
                                           size="20"
                                           value="<%= user != null ? user.getEmail() : "" %>">
                                </td>
                            </tr>
                            <tr>
                                <td width="22%"
                                    class=tdOdd>
                                    Sex
                                </td>
                                <td width="78%"
                                    class=tdOdd>
                                    <select name="sex">
                                        <option value="F" <%= user != null && user.getSex() == "F" ? "selected" : "" %>>
                                            Female
                                        </option>
                                        <option value="M" <%= user != null && user.getSex() == "M" ? "selected" : "" %>>
                                            Male
                                        </option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td width="22%"
                                    class=tdOdd>
                                    Address
                                </td>
                                <td width="78%"
                                    class=tdOdd>
                                    <input type="text"
                                           name="address"
                                           size="20"
                                           value="<%= user != null ? user.getAddress() : "" %>">
                                </td>
                            </tr>
                            <tr>
                                <td width="22%"
                                    class=tdEven>
                                    &nbsp;
                                </td>
                                <td width="78%"
                                    class=tdEven>
                                    &nbsp;
                                </td>
                            </tr>
                            <tr>
                                <td width="22%"
                                    class=tdOdd>
                                    &nbsp;
                                </td>
                                <td width="78%"
                                    class=tdOdd>
                                    <input type="button"
                                           value="<%=isEdit ? "Edit" : "Add"%>"
                                           name="B1"
                                           onClick="javascript:doAdd()">
                                    <input type="button"
                                           value="Cancel"
                                           name="B1"
                                           onClick="javascript:doCancel()">
                                </td>
                            </tr>
                        </table>
                    </form>

                    </td>
                </tr>
            </table>

            <p>
        </td>
    </tr>
    <tr>
        <td colspan="2"
            height="24"
            background="images/BottomBar.bmp">
            &nbsp;
        </td>
    </tr>
</table>

</body>

</html>
