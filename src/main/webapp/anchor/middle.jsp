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
    <title>中间业务考核指标显示</title>
    <script language="JavaScript" src="../js/中间业务指标设定.js" ></script>
    <script>
        window.onload=function () {
            var xmlHttp=new XMLHttpRequest();
            xmlHttp.open("POST","<c:url value='/Servlet3'/>",true);
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
                        //alert(i);
                        arr[j]=i;
                        arr1[j]=objJson[0][i];
                        j++;
                    }
                    j=0;
                    for (var i = 0; i <arr.length ; i++) {
                        if(i<5||i==9)//i 为w[i]
                            document.getElementById(arr[i]).innerHTML=arr1[i]+"%";
                        else if (i>=5&&i<9){
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
            <span style="color: #FF0000">中间业务</span>考核指标
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
            <td rowspan="12">定量考核</td>
            <td  width="300px" rowspan="3">国内贸易融资及对公委托贷款业务</td>
            <td rowspan="3" id="w1"></td>
            <td rowspan="3"id="k1">100（500万元）</td>
            <td>&nbsp;&nbsp;0——&nbsp;&nbsp;60分:</td>
            <td id="k11">0——300万元，不合格</td>
            <td rowspan="3"id="r1"></td>
            <td rowspan="3"id="bei1">（5万元/分）</td>
        </tr>
        <tr>

            <td>60——&nbsp;&nbsp;90分:</td>
            <td id="k12">300——450万元，合格</td>
        </tr>
        <tr>
            <td>90——100分:</td>
            <td id="k13">450——500万元，优秀</td>
        </tr>

         <%--指标2--%>
        <tr>
            <td rowspan="3">投资银行业务</td>
            <td rowspan="3"id="w2"></td>
            <td rowspan="3"id="k2">100（500万元）</td>
            <td>&nbsp;&nbsp;0——&nbsp;&nbsp;60分:</td>
            <td id="k21">0——300万元，不合格</td>
            <td rowspan="3"id="r2"></td>
            <td rowspan="3"id="bei2">（5万元/分）</td>
        </tr>
        <tr>
            <td>60——&nbsp;&nbsp;90分:</td>
            <td id="k22">300——450万元，合格</td>

        </tr>
        <tr>
            <td>90——100分:</td>
            <td id="k23">450——500万元，优秀</td>
        </tr>
        <%--指标3--%>
        <tr>
            <td rowspan="3">国内担保承诺业务</td>
            <td rowspan="3"id="w3"></td>
            <td rowspan="3"id="k3">100（500万元）</td>
            <td>&nbsp;&nbsp;0——&nbsp;&nbsp;60分:</td>
            <td id="k31">0——300万元，不合格</td>
            <td rowspan="3"id="r3"></td>
            <td rowspan="3"id="bei3">（5万元/分）</td>
        </tr>
        <tr>
            <td>60——&nbsp;&nbsp;90分:</td>
            <td id="k32">300——450万元，合格</td>
        </tr>
        <tr>
            <td>90——100分:</td>
            <td id="k33">450——500万元，优秀</td>
        </tr>
        <%--指标4--%>
        <tr>
            <td rowspan="3">人民币对公结算与现金管理业务</td>
            <td rowspan="3"id="w4"></td>
            <td rowspan="3"id="k4">100（500万元）</td>
            <td>&nbsp;&nbsp;0——&nbsp;&nbsp;60分:</td>
            <td id="k41">0——300万元，不合格</td>
            <td rowspan="3"id="r4"></td>
            <td rowspan="3"id="bei4">（5万元/分）</td>
        </tr>
        <tr>
            <td>60——&nbsp;&nbsp;90分:</td>
            <td id="k42">300——450万元，合格</td>
        </tr>
        <tr>
            <td>90——100分:</td>
            <td id="k43">450——500万元，优秀</td>
        </tr>

        <%--定性考核--%>
        <%--指标1 --%>
        <tr>
            <td rowspan="9">定性考核</td>
            <td rowspan="3">考勤</td>
            <td rowspan="3"id="w5">    <%--权重1--%>
            </td>
            <td rowspan="3">    <%--kpi1--%>
                100(100%)
            </td>
            <td>&nbsp;&nbsp;0——&nbsp;&nbsp;60分:</td>
            <td id="k51">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;0%——&nbsp;&nbsp;60%，不合格</td><%--等级1--%>
            <td rowspan="3"id="r5"></td>
            <td rowspan="3" id="bei5">签到天数/考核天数X100%</td>
            <%--备注5--%>
        </tr>
        <tr>
            <td>60——&nbsp;&nbsp;90分:</td>
            <td id="k52">60%——&nbsp;&nbsp;90%，合格</td>
            <%--等级2--%>
        </tr>
        <tr>
            <td>90——100分:</td>
            <td id="k53">90%——100%，优秀</td>
            <%--等级3--%>
        </tr>
    </table>
</div>
</body>
</html>
