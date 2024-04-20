<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>


<h2 align="center"> DELETE</h2>

<br/>

    <form action="DeleteDetails" method="post" align="center">
        <table>
                <tr>
                    <td>ID:</td>
                    <td><input type="text" name="id" maxlength="6" size="25" /></td>
                </tr>
        </table>

        <br> <input type="submit" value="Eliminar" />

    </form>

    <input type="button" value="Inicio" onclick="window.location.href='Home.jsp'"/>


</body>

</html>