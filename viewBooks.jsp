<%@ page import="java.util.List, model.Book" %>
<%
    List<Book> listBook = (List<Book>) request.getAttribute("listBook");
%>
<html>
<head><title>Books List</title></head>
<body>
    <h2>Books List</h2>
    <table border="1">
        <tr><th>ID</th><th>Title</th><th>Author</th><th>Price</th><th>Actions</th></tr>
        <%
            for (Book b : listBook) {
        %>
            <tr>
                <td><%= b.getId() %></td>
                <td><%= b.getTitle() %></td>
                <td><%= b.getAuthor() %></td>
                <td><%= b.getPrice() %></td>
                <td>
                    <form action="BookServlet" method="post" style="display:inline;">
                        <input type="hidden" name="action" value="delete"/>
                        <input type="hidden" name="id" value="<%= b.getId() %>"/>
                        <input type="submit" value="Delete"/>
                    </form>
                </td>
            </tr>
        <%
            }
        %>
    </table>
    <br><a href="addBook.jsp">Add New Book</a>
</body>
</html>
