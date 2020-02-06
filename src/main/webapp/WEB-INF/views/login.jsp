<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<div>
    <form action="/security-spring-security/login" method="post">
        <label>用户名:<input type="text" name="username"  /></label>
        <br>
        <label>密码:<input type="password" name="password" /></label>
        <br>
        <input type="submit" value="登录" />

    </form>
</div>
</body>
</html>