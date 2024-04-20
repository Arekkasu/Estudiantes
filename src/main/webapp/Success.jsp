<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

    <form action="index.jsp">

        <h3 align="center">

            <%= request.getParameter("msg")%>
            Operacion Existosa

        </h3>

        <br>
        <input type="submit" value="Inicio">

    </form>


</body>
</html>