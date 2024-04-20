<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!---AQUI SE OBTIENEN LOS VALORES DEL RESULTADO DE SelectDetails--->
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>

<h2 align="center">Informacion</h2>

<h2>Detalles</h2>

<form action="UpdateDetails" method="post">
    <input type="hidden"  name="stid" value="<%=request.getParameter("id")%>">
    <input type="hidden"  name="stnombre" value="<%=request.getParameter("nombre")%>">
    <input type="hidden"  name="stapellido" value="<%=request.getParameter("apellido")%>">
    <input type="hidden"  name="stemail" value="<%=request.getParameter("email")%>">

    <table>
        <tr>
            <td>ID</td>
            <td><%=request.getParameter("id")%></td>
        </tr>
        <tr>
            <td>Nombre: </td>
            <td><%=request.getParameter("nombre")%></td>
        </tr>
        <tr>
            <td>apellido</td>
            <td><%=request.getParameter("apellido")%></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><%=request.getParameter("email")%></td>
        </tr>
    </table>


</form>

<input type="button" value="Actualizar Datos" onclick="update()">
<br/>

<input type="button" value="Inicio" onclick="window.location.href='index.jsp'">

<br/>


</body>
<script>
    function update(){
        let sid = document.forms[0].elements["stid"].value;
        let stn = document.forms[0].elements["stnombre"].value
        let sta = document.forms[0].elements["stapellido"].value
        let ste = document.forms[0].elements["stemail"].value
        window.location.href = "Update.jsp?id=" + sid + "&nombre=" + stn + "&apellido=" + sta + "&email=" + ste;
    }
</script>
</html>