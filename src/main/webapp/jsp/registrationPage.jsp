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
        Please registration new user!
    </div>
    <form action="/registration" method="post">
        <label for="userName">User name
            <input class="input-field" type="text" id="userName" name="userName">
        </label>
        <label for="password">Password
            <input class="input-field" type="text" id="password" name="password">
        </label>
        <input type="submit" value="registration">
    </form>
</body>
</html>