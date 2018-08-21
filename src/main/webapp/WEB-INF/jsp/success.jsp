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
<%--<script src="../../js/jquery-1.8.2.min.js"></script>--%>
<script src="../../js/jquery.form.js"></script>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" href="./css/bootstrap.css"/>
<link rel="stylesheet" href="./css/bootstrap-table.css"/>

<script src="./js/bootstrap.js"></script>
<script src="./js/bootstrap-table.js"></script>
<script src="./js/bootstrap-table-export.js"></script>
<script src="./js/jquery.base64.js"></script>
<script src="./js/tableExport.js"></script>
<html>
<head>
    <%--<meta http-equiv="Content-Type" content="multipart/form-data;charset=utf-8"/>--%>
    <link rel="stylesheet" href="./css/bootstrap.css"/>
    <link rel="stylesheet" href="./css/bootstrap-table.css"/>

    <script src="./js/bootstrap.js"></script>
    <script src="./js/bootstrap-table.js"></script>
    <script src="./js/bootstrap-table-export.js"></script>
    <script src="./js/jquery.base64.js"></script>
    <script src="./js/tableExport.js"></script>

</head>

<body>
<h3>hello,${id}</h3>
<div id="content">
    <div style="text-align: right">
        可选导出文件格式: ['csv', 'txt', 'xml','excel','sql','json']
    </div>
    <div id="content-body">
        <div id="reportTableDiv" class="span10">
            <table id="reportTable">
            </table>
        </div>
    </div>
</div>

<div>
    <form id="form1" enctype="multipart/form-data">
        <input type="file" name="file">
        <input type="submit" value="上传" id="submit">
    </form>
    <iframe name="frame1" frameborder="0" height="200" width="200" ></iframe>
</div>


<script type="text/javascript">
    $(function(){
        var obj = [];
            upload();
            function upload() {
                var sub = $('#submit');
                sub.click(function (e) {
                    // if ($("input[type='file']").val()!=="") {
                        var data = new FormData($('#form1')[0]);
                        e.preventDefault();
                        $.ajax({
                            type: 'post',
                            url: '/success/excel',//请求地址
                            cache: false,
                            data: data,
                            processData: false, //特别注意这个属性不能省
                            contentType: false, //特别注意这个属性不能省
                            dataType: 'json',
                            success: function (data) {
                                // $.ajax({
                                //     url:"/success/excel",
                                //     type:"get",
                                //     dataType:"json",
                                //     cache:false,
                                //     success:function (data) {
                                //         if (data) {
                                //             obj = eval(data);
                                //         }
                                //     }
                                // })
                                $('#form1')[0].reset();
                                obj = eval(data);
                                console.log(obj);
                                $('#reportTable').bootstrapTable('destroy');
                                $('#reportTable').bootstrapTable(
                                    {
                                        data:obj,
                                        height:$(window).height()-100,
                                        toolbar:'#toolbar',
                                        striped:true,
                                        pagination : true,
                                        pageNumber : 1,
                                        pageSize : 10,
                                        pageList : [ 5, 10, 20 ],
                                        search : true,
                                        searchAlign : 'left',
                                        //showRefresh: true,
                                        showExport : true, //是否显示导出
                                        exportDataType : "selected", //basic', 'all', 'selected'.
                                        sidePagination : "client",
                                        editable : true,
                                        showColumns : true,
                                        clickToSelect : true,
                                        showToggle : true, //是否显示详细视图和列表视图的切换按钮
                                        cardView : false, //是否显示详细视图
                                        detailView : false,
                                        minimunCountColumns : 2,
                                        // rowStyle : function(row, index) {
                                        //     //这里有5个取值代表5中颜色['active', 'success', 'info', 'warning', 'danger'];
                                        //     var strclass = "";
                                        //     if (row.ORDER_STATUS == "待排产") {
                                        //         strclass = 'success';//还有一个active
                                        //     } else if (row.ORDER_STATUS == "已删除") {
                                        //         strclass = 'danger';
                                        //     } else {
                                        //         return {};
                                        //     }
                                        //     return {
                                        //         classes : strclass
                                        //     }
                                        // },
                                        // onEditableSave : function(field, row,
                                        //                           oldValue, $el) {
                                        //     $.ajax({
                                        //         type : "post",
                                        //         url : "/Editable/Edit",
                                        //         data : {
                                        //             strJson : JSON.stringify(row)
                                        //         },
                                        //         success : function(data, status) {
                                        //             if (status == "success") {
                                        //                 alert("编辑成功");
                                        //             }
                                        //         },
                                        //         error : function() {
                                        //             alert("Error");
                                        //         },
                                        //         complete : function() {
                                        //
                                        //         }
                                        //     });
                                        // },
                                        columns: [{
                                            field: 'cusID',//Json  KEY
                                            title: '流水号',
                                            align: 'center',
                                            valign: 'middle',
                                            sortable: true
                                        }, {
                                            field: 'cusName',
                                            title: '客户名字',
                                            align: 'center',
                                            valign: 'middle',
                                            sortable: true
                                        }, {
                                            field: 'phone',
                                            title: '客户电话',
                                            align: 'center',
                                            valign: 'middle',
                                            sortable: true
                                        },  {
                                            field: 'type',
                                            title: '业务类型',
                                            align: 'center',
                                            valign: 'middle',
                                            sortable: true
                                        },{
                                            field: 'money',
                                            title: '金额',
                                            align: 'center',
                                            valign: 'middle',
                                            sortable: true
                                        }, {
                                            field: 'state',
                                            title: '状态',
                                            align: 'center',
                                            valign: 'middle',
                                            sortable: true
                                        },],
                                    }
                                )
                            }
                        })

                    // }
                })

            }
            $(window).resize(function () {
                $('#reportTable').bootstrapTable('resetView');
            });
        });

    // $(function () {
        <%--$('#reportTable').bootstrapTable({--%>
            <%--url: '/success/excel',--%>
            <%--method: 'post',--%>
            <%--dataType:"json",--%>
            <%--cache: false,--%>
            <%--height: 800,//改变table的高度，!!!并不是实际大小--%>
            <%--striped: true,--%>
            <%--pagination: true,--%>
            <%--pageSize: 20,//每页默认数据量--%>
            <%--pageNumber: 1,//默认第一页--%>
            <%--pageList: [10, 20, 50, 100, 200, 500],--%>
            <%--search: true,//搜索框--%>

            <%--showColumns: true,--%>
            <%--showRefresh: true,--%>
            <%--showExport: true,--%>
            <%--exportTypes: ['csv', 'txt', 'xml', 'excel', 'sql', 'json'],--%>
            <%--search: true,--%>
            <%--clickToSelect: true,--%>
            <%--columns: [{--%>
                <%--field: 'cusID',//Json  KEY--%>
                <%--title: "流水号",--%>
                <%--align: "center",--%>
                <%--valign: "middle",--%>
                <%--sortable: "true"--%>
            <%--}, {--%>
                <%--field: "cusName",--%>
                <%--title: "客" +--%>
                    <%--"户名字",--%>
                <%--align: "center",--%>
                <%--valign: "middle",--%>
                <%--sortable: "true"--%>
            <%--}, {--%>
                <%--field: "phone",--%>
                <%--title: "客户电话",--%>
                <%--align: "center",--%>
                <%--valign: "middle",--%>
                <%--sortable: "true"--%>
            <%--},  {--%>
                <%--field: "type",--%>
                <%--title: "业务类型",--%>
                <%--align: "center",--%>
                <%--valign: "middle",--%>
                <%--sortable: "true"--%>
            <%--},{--%>
                <%--field: "money",--%>
                <%--title: "金额",--%>
                <%--align: "center",--%>
                <%--valign: "middle",--%>
                <%--sortable: "true"--%>
            <%--}, {--%>
                <%--field: "state",--%>
                <%--title: "状态",--%>
                <%--align: "center",--%>
                <%--valign: "middle",--%>
                <%--sortable: "true"--%>
            <%--},],--%>
            <%--onPageChange: function (size, number) {--%>
                <%--//$("#pageSizeInput").val(size);--%>
                <%--//$("#pageNumberInput").val(number);--%>

                <%--//var form = $('#tableForm');--%>
                <%--//form.action= '${base}/showReport';--%>
                <%--//form.submit();--%>
            <%--},--%>
            <%--//onSort: function (name, order) {--%>
            <%--// },--%>
            <%--//formatShowingRows: function (pageFrom, pageTo, totalRows) {--%>
            <%--//	return '';--%>
            <%--// },--%>
            <%--//formatRecordsPerPage: function () {--%>
            <%--//	return '';--%>
            <%--//  },--%>
            <%--formatNoMatches: function () {--%>
                    <%--return '�޷��������ļ�¼';--%>
            <%--}--%>
        <%--});--%>

        <%--$(window).resize(function () {--%>
            <%--$('#reportTable').bootstrapTable('resetView');--%>
        <%--});--%>
    <%--});--%>

</script>

<!--<div style="margin-left:20px;"><h4>
	When resize the window, the table header does not adjust automatically, how to solve it?<br/>
	When you set the height of bootstrap table, the fixed header feature is automatically enabled, <br/>
	that is what cause the problem, you need to listen the resize event of window and use the <br/>
	resetView method to solve this problem, code example:<br/>
	<br/>
	$(function () {<br/>
	&nbsp;&nbsp; $('#tableId').bootstrapTable(); // init via javascript<br/>
	<br/>
	&nbsp;&nbsp; $(window).resize(function () {<br/>
	&nbsp;&nbsp;&nbsp;&nbsp; $('#tableId').bootstrapTable('resetView');<br/>
	&nbsp;&nbsp; });<br/>
	});<br/>
</h4></div>
-->
</body>
</html>
