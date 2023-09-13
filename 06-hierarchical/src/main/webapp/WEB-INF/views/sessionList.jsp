<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SessionList</title>
</head>

<body>
<table class="table table-success">
    <tr>
        <th>유저</th>
        <th>sessionId</th>
        <th>마지막 요청 시간</th>
    </tr>
    <c:forEach var="item" items="${sessionList}">
    <tr>
        <td>${item.username}</td>
        <td>${item.sessionId}</td>
        <td>${item.lastRequest}</td>
    </tr>
    </c:forEach>
</table>>
</body>

</html>