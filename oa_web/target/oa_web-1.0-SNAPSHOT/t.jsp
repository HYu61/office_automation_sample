<%--
  Created by IntelliJ IDEA.
  User: hyu
  Date: 2020-10-08
  Time: 10:08 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${dept.name}
<h1>${dept.address}</h1>

<c:forEach var="d" items="${list}">
    <h2>${d.name}</h2>
    <p>${d.address}</p>
</c:forEach>

</body>
</html>
