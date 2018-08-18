<%@ taglib prefix="mce" uri="http://struts.apache.org/tags-html" %>
<%@ page import="com.fasterxml.jackson.databind.util.JSONPObject" %>
/**
 * Created by CZ on 2018/8/1.
 */

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%--<script type="text/javascript" src="jquery-1.5.1.min.js"></script>--%>
<%--<script type="text/javascript">--%>
    <%--function requestJson(){--%>
        <%--var jsonData = {--%>
            <%--"id" : login.id,--%>
            <%--"password" : login.password--%>
        <%--};--%>
        <%--$.ajax({--%>
            <%--type:'post',--%>
            <%--url:'${pageContext.request.contextPath }/login.action',--%>
            <%--contentType:'application/json;charset=utf-8',//指定为json类型--%>
            <%--//数据格式是json串，商品信息--%>
            <%--data:JSON.stringify(jsonData),--%>
            <%--success:function(data){//返回json结果--%>
                <%--alert("login  " + data.id);--%>
            <%--}--%>
        <%--});--%>
    <%--}--%>
<%--</script>--%>
<head>
 <title>Title</title>
</head>
<body>
<form action="login" method="post">
 <input type="text" name="id" placeholder="输入工号" />
 <br/>
 <input type="password" name="password" placeholder="输入密码" />
 <br />
 <input type="submit" value="登录">
 <input type="reset" value="重置">
</form>
</body>
</html>