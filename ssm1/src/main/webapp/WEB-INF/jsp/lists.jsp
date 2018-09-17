<%--
  Created by IntelliJ IDEA.
  User: starlee
  Date: 2018/9/17
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>


    <c:forEach items="${pageBean.list}" var="admin">
        <tr>
            <td><c:out value="${admin.id}"/></td>
            <td><c:out value="${admin.username}"/></td>
            <td><c:out value="${admin.password}"/></td>
            <td><a href="delete?id= <c:out value="${admin.id}"/>">del</a></td>
        </tr>

    </c:forEach>
    <tr>
        <td colspan="5">共&nbsp;${pageBean.getTotalPages()}&nbsp;页
            &nbsp;&nbsp;&nbsp;&nbsp;
            当前第&nbsp;${pageBean.getPageNo()}页
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="lists?pageNo=${pageBean.getTopPageNo()}">首页</a>
            <a href="lists?pageNo=${pageBean.getPreviousPageNo()}">上一页</a>
            <a href="lists?pageNo=${pageBean.getNextPageNo()}">下一页</a>
            <a href="lists?pageNo=${pageBean.getNextPageNo()}">尾页</a>
        </td>
    </tr>
</table>
</body>
</html>
