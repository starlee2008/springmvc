<%--
  Created by IntelliJ IDEA.
  User: starlee
  Date: 2018/9/11
  Time: 8:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
TotalCount:<spring:eval expression="format.totalCount"/><br/>
Discount:<spring:eval expression="format.discount"/><br/>
SumMoney:<spring:eval expression="format.sumMoney"/><br/>
Register Date:
<spring:eval expression="format.registerDate"/><br/>
Order Date
<spring:eval expression="format.orderDate"/><br/>
</body>
</html>
