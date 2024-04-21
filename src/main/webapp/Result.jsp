<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Informacio</h2>

<h3>Detalles</h3>

<form action="UptadeDetails" method="post">

    <input type="hidden" name="stid" value="<%=request.getParameter("id")%>"/>

<table>

    <tr>
        <td>ID</td>
        <td><%=request.getParameter("id")%></td>
    </tr>

    <tr>
        <td>Nombre</td>
        <td><%=request.getParameter("nombre")%></td>
    </tr>

    <tr>
        <td>Apellido</td>
        <td><%=request.getParameter("apellido")%></td>
    </tr>

    <tr>
        <td>Email</td>
        <td><%=request.getParameter("email")%></td>
    </tr>



</table>

</form>

<input type="button" value="Actualiazar Datos" onclick="update()">
<input type="button" value="Inicio" onclick="window.location.href='index.jsp'">

</body>
<script>
    function update(){
        let stid = document.forms[0].elements['stid'].value;
        window.location.href="Update.jsp?id=" + stid;
    }
</script>
</html>