<%@ page import="ru.itis.web.dto.UserDto" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <table>
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
        </tr>
        <%--<%--%>
            <%--List<UserDto> users = (List<UserDto>) request.getAttribute("users");--%>
            <%--for (UserDto user : users) {--%>
        <%--%>--%>
        <%--<tr>--%>
            <%--<td><%=user.getId()%>--%>
            <%--</td>--%>
            <%--<td><%=user.getFirstName()%>--%>
            <%--</td>--%>
            <%--<td><%=user.getLastName()%>--%>
            <%--</td>--%>
        <%--</tr>--%>
        <%--<%}%>--%>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
