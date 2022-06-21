<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="/css/styles1.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-2">
    <form action="/guest" method="get">

        <div class="form-style-2-heading">
            All services
        </div>

        Services: <select name="service">
        <c:forEach items="${service}" var="service">
            <option>
                <tr>
                    <td>${service}</td>
                </tr>
            </option>
        </c:forEach>
        <input type="submit" value="Search tariff"/>

    </select>

    </form>
</div>

<div class="form-style-2">
<form action="/guest" method="get">
    Tariffs : <select name="tariffs">
    <c:forEach items="${tariffs}" var="tariff">
        <option>
            <tr>
                <td>${tariff.name}</td>
                <td>${tariff.price}</td>
            </tr>
        </option>
    </c:forEach>
    <input type="submit" value="buy a service"/>

</select>
</form>
    <div class="form-style-2">
        <div class="form-style-2-heading">
            Your wallet
        </div>
        <tr>
            <th>Your Balance</th>
            <th>Status of balance</th>
        </tr>
        <c:forEach items="${balance}" var="balance">
            <option>
                <tr>
                    <td>${balance.sum}</td>
                    <td>${balance.status}</td>
                </tr>
            </option>
        </c:forEach>
    </div>
</div>
</body>
</html>
