<%--
  Created by IntelliJ IDEA.
  User: gabrieljayme
  Date: 22/04/21
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, gabrieljayme.project.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Endereços Cadastrados</title>
    <link rel="stylesheet" type="text/css" href="lib/css/style.css">
</head>
<body>
    <h1>Contatos Cadastrados</h1>
    <table>
        <%
//            EnderecosDAO dao = new EnderecosDAO();
            ArrayList<Enderecos> lista = (ArrayList<Enderecos>) request.getSession().getAttribute("lista");

            for (Enderecos enderecos : lista) {
        %>
        <tr>
            <td>
                <%=enderecos.getId()%>
            </td>
            <td>
                <%=enderecos.getNome()%>
            </td>
            <td>
                <%=enderecos.getEmail()%>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
