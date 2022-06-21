<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <title>Title</title>
    <link href="/css/styles1.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Please Log In!
    </div>
    <form method="post" action="${pageContext.request.contextPath}/logIn">
        <label for="userName">User name
            <input class="input-field" type="text" id="userName" name="userName">
        </label>
        <label for="password">Password
            <input class="password-field" type="text" id="password" name="password">
        </label>
        <input type="submit" value="Log in">
    </form>
</body>
</html>