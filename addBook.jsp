<html>
<head><title>Add Book</title></head>
<body>
    <h2>Add New Book</h2>
    <form action="BookServlet" method="post">
        <input type="hidden" name="action" value="insert"/>
        Title: <input type="text" name="title"/><br>
        Author: <input type="text" name="author"/><br>
        Price: <input type="text" name="price"/><br>
        <input type="submit" value="Add Book"/>
    </form>
</body>
</html>
