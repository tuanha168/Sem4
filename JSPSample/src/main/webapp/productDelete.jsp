<%@ page import="com.example.model.Product" %>
<%@ page import="com.example.db.ProductService" %>

<%
    Product product =  new Product();
    product.setId(Integer.parseInt(request.getParameter("id")));

    ProductService db = new ProductService();
    db.deleteProduct(product);

    request.setAttribute("link","index.jsp");
    request.setAttribute("msg","Insert new product");

    response.sendRedirect("index.jsp");
%>
