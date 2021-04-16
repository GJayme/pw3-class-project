<%@ page import="java.time.LocalDate" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="lib/css/style.css">
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
    A data de hoje é <%=LocalDate.now()%>
<br/>
<form action="hello-servlet" method="post">
    Nome: <input name="nome" type="text" size="40"/>
    <br/>
    <button type="submit">Enviar</button>
</form>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>