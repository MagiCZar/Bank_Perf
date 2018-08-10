<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.bank.bean.AssetCus" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%--
  Created by IntelliJ IDEA.
  User: CZ
  Date: 2018/8/1
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@page isELIgnored="false"%>

<html>
<head>
    <title>success</title>
</head>
<body>
<h1>hello ${id} !</h1>
<form action="register" method="post">
<input type="text" name="id" placeholder="输入科室编号"/>
    <br/>
<button type="submit">添加新用户</button>
</form>
<div>
<form action="/success/excel" method="post" enctype="multipart/form-data">
    <input type="file" name="file" accept=".xlsx,.xls" />
    <br/>
    <button type="submit" >导入文件</button>
</form>
</div>
<%
    List list = (ArrayList) request.getAttribute("list");
    if ( list!= null){
        String[][] lists = new String[list.size()][5];
        for (int i = 0;i < list.size(); i++) {
            AssetCus assetCus = (AssetCus)list.get(i);
            lists[i][0] = String.valueOf(assetCus.getCusId());
            lists[i][1] = assetCus.getCusName();
            lists[i][2] = assetCus.getPhone();
            lists[i][3] = String.valueOf(assetCus.getNumber());
            lists[i][4] = String.valueOf(assetCus.getState());
        }
        request.setAttribute("lists",lists);
    }
%>
<table class="table-view">
    <c:forEach var="i" begin="0" end="${fn:length(lists)}">
        <c:forEach var="j" begin="0" end="${fn:length(lists[i])}">
            ${requestScope.lists[i][j]}
        </c:forEach>
        <br/>
    </c:forEach>

</table>
<%--<div id="sheetview" class="two fields">--%>
    <%--<div class="field">--%>
        <%--<label>工作表</label>--%>
        <%--<select id="sheet" class="ui dropdown"></select>--%>
    <%--</div>--%>
<%--</div>--%>
</body>
</html>
