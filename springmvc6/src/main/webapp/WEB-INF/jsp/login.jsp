<%--
  Created by IntelliJ IDEA.
  User: starlee
  Date: 2018/9/13
  Time: 8:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-2.1.0.js"></script>
</head>
<script>
    function login() {
        var username = $("#username").val();
        var password = $("#password").val();
        var admin = {"username": username, "password": password};
        $.ajax({
            type: "post",
            url: "login",
            data: JSON.stringify(admin),
            contentType: "application/json",
            dataType: "json",
            success: function (msg) {
                alert("登陆的用户信息：" + msg.id + ":" + msg.username + ":" + msg.password);
            },
            error: function (msg) {
            }
        });
    }
</script>
<body>
<div>
    <input type="text" name="username" id="username"><br>
    <input type="text" name="password" id="password"><br>
    <input type="button" value="Login" onclick="login();">
</div>

</body>
</html>
