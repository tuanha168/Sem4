<%@ page import="com.example.model.Products" %>
<%@ page import="com.example.db.ProductService" %>
<%@ page
        import="com.example.model.Products" %>

<%
    Products products =  new Products();
    products.setAmount(Integer.parseInt(request.getParameter("amount")));
    products.setDetails(request.getParameter("details"));
    products.setName(request.getParameter("name"));
    products.setPrice(Float.parseFloat( request.getParameter("price")));

    ProductService db = new ProductService();
    db.saveProduct(products);

    request.setAttribute("link","index.jsp");
    request.setAttribute("msg","Insert new products");

    response.sendRedirect("index.jsp");
%>
