<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cities</title>
</head>
<body>
Cities:
<table>
    <thead>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>country</th>
        <th>district</th>
        <th>population</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${cities}" var="city">
        <tr>
            <td>${city.id}</td>
            <td>${city.name}</td>
            <td>${city.country}</td>
            <td>${city.district}</td>
            <td>${city.population}</td>
            <td><a href="<c:url value="/${city.id}" />" >details</a></td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>
