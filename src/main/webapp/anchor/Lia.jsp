<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: demon
  Date: 2018/8/19
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>负债业务考核指标显示</title>
    <script language="JavaScript" src="../js/资产业务指标设定.js" ></script>
    <script>
        window.onload=function () {
            var xmlHttp=new XMLHttpRequest();
            xmlHttp.open("POST","<c:url value='/ZServlet1'/>",true);
            xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
            xmlHttp.send();
            xmlHttp.onreadystatechange=function () {
                if(xmlHttp.readyState==4&&xmlHttp.status==200){
                    var objJson=xmlHttp.responseText;
                    objJson=eval('('+xmlHttp.responseText+')');
                    var arr=new Array();
                    var arr1=new Array();
                    var j=0;
                    for (var i in objJson[0]){
                        arr[j]=i;
                        arr1[j]=objJson[0][i];
                        j++;
                    }
                    for (var i = 0; i <arr.length ; i++) {
                        if (i<2)
                      document.getElementById(arr[i]).innerHTML=arr1[i]+"%";
                        else if(i<=3&&i>=2)
                        {
                            document.getElementById(arr[i]).innerHTML=arr1[i]+"万元";
                        }

                    }


                }
            }
        }
    </script>
    <style>
        #k11{
            width: 200px;
        }
    </style>

</head>
<body>
<div>
    <table border="1" style="width:80%;margin:0 auto;height :40px;text-align: center">
        <caption>
            <span style="color: #FF0000">负债业务</span>考核指标
        </caption>
        <%--HeadLine  7columns--%>
        <tr>
            <th>考核项目</th>
            <th>考核指标</th>
            <th>权重</th>
            <th>KPI目标值</th>
            <th colspan="2">计分方式</th>
            <th>成果</th>
            <th>备注</th>
        </tr>
        <%--指标1 --%>

        <tr>
            <td rowspan="3">定量考核</td>
            <td  width="300px" rowspan="3">吸收对公存款日均数</td>
            <td rowspan="3" id="w1"></td>
            <td rowspan="3"id="k1">100（5000万元)</td>
            <td>&nbsp;&nbsp;0——&nbsp;&nbsp;60分:</td>
            <td id="k11">0——3000万元，不合格</td>
            <td rowspan="3"id="r1"></td>
            <td rowspan="3"id="bei1">（50万元/分</td>
        </tr>
        <tr>

            <td>60——&nbsp;&nbsp;90分:</td>
            <td id="k12">3000——4500万元，合格</td>
        </tr>
        <tr>
            <td>90——100分:</td>
            <td id="k13">4500——5000万元，优秀</td>
        </tr>

        <%--定性考核--%>
        <%--指标1 --%>
        <tr>
            <td rowspan="9">定性考核</td>
            <td rowspan="3">考勤</td>
            <td rowspan="3"id="w2">    <%--权重1--%>
            </td>
            <td rowspan="3">    <%--kpi1--%>
                100(100%)
            </td>
            <td>&nbsp;&nbsp;0——&nbsp;&nbsp;60分:</td>
            <td id="k21">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;0%——&nbsp;&nbsp;60%，不合格</td><%--等级1--%>
            <td rowspan="3"id="r2"></td>
            <td rowspan="3" id="bei2">签到天数/考核天数X100%</td><%--备注2--%>
        </tr>
        <tr>
            <td>60——&nbsp;&nbsp;90分:</td>
            <td id="k22">60%——&nbsp;&nbsp;90%，合格</td>
            <%--等级2--%>
        </tr>
        <tr>
            <td>90——100分:</td>
            <td id="k23">90%——100%，优秀</td>
            <%--等级3--%>
        </tr>
    </table>
</div>
</body>
</html>
