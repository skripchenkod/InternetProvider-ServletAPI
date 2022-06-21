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
        Edit tariff!
    </div>
<div class="input-field">
    <form action="${pageContext.request.contextPath}/admin" method="get">
        Input id of tariff
        <label for="idTariff">
            <input class="input-field" type="text" id="idTariff" name="idTariff">
        </label>
    </select>
        <br><br>
        Enter what edit in tariff
        <div>

        </div>
        if you want to change name, please enter new name
        <label for="idTariff">
            <input class="input-field" type="text" id="name" name="name" >
        </label>
        if you want to change price, please enter new price
        <label for="idTariff">
            <input class="input-field" type="text" id="price" name="price">
        </label>
        <div class="form-style-2-heading">
            Edit status user!
        </div>
        <div>
            Do you want edit status of user?
            <div>Enter username of user!</div>
            <label for="userName">
                <input class="input-field" type="text" id="userName" name="userName">
            </label>
            Block
            <input type="checkbox" name="status" value="false"/>
            Unblock
            <input type="checkbox" name="status" value="true"/>
        </div>
        <div class="form-style-2-heading">
            Delete tariff!
        </div>
        <div>
            Do you want delete tariff?
            Yes
            <input type="checkbox" name="delete" value="false"/>

            <br><br>
            <input type="submit" value="Submit"/>
        </div>
    </form>
</div>
</div>

<div class="form-style-2" >
    <div class="input-field">
        <form action="${pageContext.request.contextPath}/admin" method="post">
            <div class="form-style-2-heading">
                Registration user!
            </div>
            <div>
                Do you want registration new user?

            </div>
            <input type="submit" value="Registration">
        </form>
    </div>
</div>

</body>
</html>
