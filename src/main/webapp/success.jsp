<%--
  Created by IntelliJ IDEA.
  User: CZ
  Date: 2018/8/1
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>success</title>
</head>
<body>
<h1>hello ${user.id}</h1>
<form action="register" method="post">
<input type="text" name="id" placeholder="输入科室编号"/>
    <br/>
<button type="button" class="btn btn-default">添加新用户</button>
</form>
</body>
</html>
