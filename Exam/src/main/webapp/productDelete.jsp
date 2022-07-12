<%@ page import="com.example.model.Products" %>
<%@ page import="com.example.db.ProductService" %>
<%@ page
        import="com.example.model.Products" %>

<%
    Products products =  new Products();
    products.setId(Integer.parseInt(request.getParameter("id")));

    ProductService db = new ProductService();
    db.deleteProduct(products);

    request.setAttribute("link","index.jsp");
    request.setAttribute("msg","Insert new products");

    response.sendRedirect("index.jsp");
%>
