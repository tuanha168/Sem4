<%@ page import="com.example.model.Product" %>
<%@ page import="com.example.db.ProductService" %>

<%
    Product product =  new Product();
    product.setId(Integer.parseInt(request.getParameter("id")));
    product.setBrand(request.getParameter("brand"));
    product.setMadein(request.getParameter("madein"));
    product.setName(request.getParameter("name"));
    product.setPrice(Float.parseFloat( request.getParameter("price")));

    ProductService db = new ProductService();
    db.updateProduct(product);

    request.setAttribute("link","index.jsp");
    request.setAttribute("msg","Insert new product");

    response.sendRedirect("index.jsp");
%>
