<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Movies</title>
</head>
<body>
Movies:
<table>
    <thead>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>year</th>
        <th>awards</th>
        <th>nominations</th>
        <th>options</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${movies}" var="city">
        <tr>
            <td>${city.id}</td>
            <td>${city.name}</td>
            <td>${city.year}</td>
            <td>${city.awards}</td>
            <td>${city.nominations}</td>
            <td><a href="<c:url value="/${city.id}" />" >details</a></td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>
