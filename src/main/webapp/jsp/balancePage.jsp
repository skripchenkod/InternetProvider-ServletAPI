<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="/css/styles1.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Wallet!
    </div>
    <div class="input-field">
        <form action="${pageContext.request.contextPath}/balance" method="get">
            top up the balance, enter sum
            <label for="sum">
                <input class="input-field" type="text" id="sum" name="sum">
            </label>
            <input type="submit" value="Top Up!">
            </select>
        </form>
    </div>
</div>

<div class="form-style-2" >
    <div class="input-field">
        <form action="${pageContext.request.contextPath}/guest" method="post">
            <input type="submit" value="Back to personal account">
        </form>
    </div>
</div>
</body>
</html>
