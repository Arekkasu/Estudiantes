<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Actualizar</title>
</head>
<body>

<h2>Ingrese la información</h2>

<form action="UpdateDetails" method="post">
    <table>
        <tr>
            <td>ID:</td>
            <td><input type="text" name="id"
                       value="<%=request.getParameter("id")%>" readonly="readonly">
            </td>
        </tr>
        <tr>
            <td>Nombre:</td>
            <td><input type="text" name="nombre" maxlength="30" size="35" /></td>
        </tr>
        <tr>
            <td>Apellido:</td>
            <td><input type="text" name="apellido" maxlength="40" size="35" /></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="text" name="email" maxlength="20" size="35" /></td>
        </tr>
        <tr />
    </table>
    <br /> <input type="submit" value="Actualizar" />
</form>
<br />
<input type="button" value="Inicio"
       onclick="window.location.href='Home.jsp'" />
=======
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

>>>>>>> upgrading

</body>
</html>