<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>City</title>
</head>
<body>

<style>
    label, input, button {
        display: block;
        margin-top: 1em;
    }
</style>
<form:form modelAttribute="city" method="post">
    <label>id</label>
    <form:input path="id" readonly="true"/>
    <form:errors path="id"/>
    <label>name</label>
    <form:input path="name"/>
    <form:errors path="name"/>
    <label>year</label>
    <form:input path="country"/>
    <form:errors path="country"/>
    <label>awards</label>
    <form:input path="district"/>
    <form:errors path="district"/>
    <label>nominations</label>
    <form:input path="population"/>
    <form:errors path="population"/>
    <form:button>Save</form:button>
</form:form>
<a href="<c:url value="/"/>">Back</a>

</body>
</html>
