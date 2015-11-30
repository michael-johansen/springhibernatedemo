<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Movies</title>
</head>
<body>

<style>
    label, input, button {
        display: block;
        margin-top: 1em;
    }
</style>
<form:form modelAttribute="movie" method="post">
    <label>id</label>
    <form:input path="id" readonly="true"/>
    <form:errors path="id"/>
    <label>name</label>
    <form:input path="name"/>
    <form:errors path="name"/>
    <label>year</label>
    <form:input path="year"/>
    <form:errors path="year"/>
    <label>awards</label>
    <form:input path="awards"/>
    <form:errors path="awards"/>
    <label>nominations</label>
    <form:input path="nominations"/>
    <form:errors path="nominations"/>
    <form:button>Save</form:button>
</form:form>

</body>
</html>
