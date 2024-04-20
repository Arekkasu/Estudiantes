<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>

<form action="UpdateDetails" method="post">
    <table>
        <tr>
        <td>ID:</td>
        <td><input type="text" name="id" value='<%=request.getParameter("id")%>' readonly="readonly"></td>
        </tr>
        <tr>
            <td>Nombre:</td>
            <td><input type="text" name="id" value='<%=request.getParameter("nombre")%>'></td>
        </tr>

        <tr>
            <td>Apellido:</td>
            <td><input type="text" name="id" value='<%=request.getParameter("apellido")%>'></td>
        </tr>

        <tr>
            <td>Email:</td>
            <td><input type="text" name="id" value='<%=request.getParameter("email")%>'></td>
        </tr>

    </table>

<br> <input type="submit" value="Actualizar">
</form>

<br>
<input type="button" value="Inicio" onclick="window.location.href = 'index.jsp'">


</body>
</html>