<%--
  Created by IntelliJ IDEA.
  User: hyu
  Date: 2020-10-08
  Time: 9:58 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/dept/addDept" method="post">
    name: <input id="name" name="name">
    address: <input id="address" name="address">
    <input type="submit" value="tijiao">

</form>

<h1>${msg}</h1>
</body>
</html>
