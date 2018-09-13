<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>springmvc lists</title>
</head>
<body>
<table border="1">
    <tr>
        <td width="50">Id</td>
        <td width="150">UserName</td>
        <td width="150">Password</td>
        <td width="150">Edit</td>
        <td width="150">Delete</td>
    </tr>
    <c:forEach items="${pageBean.list}" var="admin">
        <tr>
            <td><c:out value="${admin.id}"/></td>
            <td><c:out value="${admin.username}"/></td>
            <td><c:out value="${admin.password}"/></td>
            <td><a href="edit?id=${admin.id}">Edit</a></td>
            <td><a href="del?id=${admin.id}">Delete</a></td>
        </tr>
    </c:forEach>

    <tr>
        <td colspan="5">共&nbsp;${pageBean.getTotalPages()}&nbsp;页&nbsp;&nbsp;&nbsp;&nbsp;
            当前第&nbsp;${pageBean.getPageNo()}页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
                    href="list?pageNo=${pageBean.getTopPageNo()}">首页</a>
            <a
                    href="list?pageNo=${pageBean.getPreviousPageNo()}">上一页</a>
            <a
                    href="list?pageNo=${pageBean.getNextPageNo()}">下一页</a>
            <a
                    href="list?pageNo=${pageBean.getNextPageNo()}">尾页</a>

        </td>
    </tr>
</table>


</body>
</html>