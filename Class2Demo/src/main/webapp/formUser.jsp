<%--
  Created by IntelliJ IDEA.
  User: Hoang
  Date: 6/11/2022
  Time: 6:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${action} employee</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">

</head>
<body>
    <div class="container text-center">
        <div class="row">
            <div class="col-6" style="margin: auto">
                <h1>${action} employee</h1>
                <form action="UserServlet${action}" method="post">
                    <div class="form-group" style="display: none">
                        <input name="id" type="text" class="form-control" id="id" value="${customer.id}">
                    </div>
                    <div class="form-group">
                        <label for="fullname">Full name</label>
                        <input required name="name" type="text" class="form-control" id="fullname" placeholder="Enter name" value="${customer.name}">
                    </div>
                    <div class="form-group">
                        <label for="Email">Email</label>
                        <input required name="email" type="email" class="form-control" id="Email" value="${customer.email}">
                    </div>
<%--                    <div class="form-group">--%>
<%--                        <label for="birthday">Birthday</label>--%>
<%--                        <input required name="birthday" type="date" class="form-control" id="birthday">--%>
<%--                    </div>--%>
                    <div class="form-group">
                        <label for="Address">Address</label>
                        <input required name="address" type="text" class="form-control" id="Address" value="${customer.address}">
                    </div>
<%--                    <div class="form-group">--%>
<%--                        <label for="Position">Position</label>--%>
<%--                        <input required name="position" type="text" class="form-control" id="Position">--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <label for="Department">Department</label>--%>
<%--                        <input required name="department" type="text" class="form-control" id="Department">--%>
<%--                    </div>--%>
                    <div class="d-flex justify-content-between">
                        <button type="reset" class="btn btn-primary">RESET FORM</button>
                        <button type="submit" class="btn btn-primary">ADD CUSTOMER</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

</body>
</html>
