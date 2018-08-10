<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page language="java" pageEncoding="UTF-8" %>
<%@page contentType="text/html; ISO-8859-1" %>
<%@page isELIgnored="false"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>绩效管理系统用户登录</title>
    <link href="css/login.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
    <script type="text/javascript" src="js/jQuery1.7.js"></script>
    <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="js/jquery1.42.min.js"></script>
    <script type="text/javascript" src="js/jquery.SuperSlide.js"></script>
    <script type="text/javascript" src="js/Validform_v5.3.2_min.js"></script>

    <script type="text/javascript">
        $(function(){
            /*员工登录信息验证*/
            $("#stu_username_hide").focus(function(){
                var username = $(this).val();
                if(username=='输入工号'){
                    $(this).val('');
                }
            });
            $("#stu_username_hide").focusout(function(){
                var username = $(this).val();
                if(username==''){
                    $(this).val('输入工号');
                }
            });
            $("#stu_password_hide").focus(function(){
                var username = $(this).val();
                if(username=='输入密码'){
                    $(this).val('');
                }
            });
            $("#stu_password_hide").focusout(function(){
                var username = $(this).val();
                if(username==''){
                    $(this).val('输入密码');
                }
            });

            $(".stu_login_error").Validform({
                tiptype:function(msg,o,cssctl){
                    var objtip=$(".stu_error_box");
                    cssctl(objtip,o.type);
                    objtip.text(msg);
                },
//                ajaxPost:true
            });
        });

    </script>

</head>

<body>
<div id="tab">

    <div class="tab_box">
        <!-- 员工登录开始 -->
        <div>
            <div class="tab_title">
                <label>银&nbsp;行&nbsp;绩&nbsp;效&nbsp;管&nbsp;理&nbsp;系&nbsp;统</label>
            </div>
            <div class="stu_error_box"></div>
            <form action="login" method="post" class="stu_login_error">
                <div id="username">
                    <h5>${error}</h5>
                    <label>工&nbsp;&nbsp;&nbsp;号：</label>
                    <input type="text" id="stu_username_hide" name="id" value="输入工号" nullmsg="工号不能为空！" datatype="/^[1-3]\d{4}$/" errormsg="工号非法！" sucmsg="工号验证通过！"/>
                    <!--ajaxurl="demo/valid.jsp"-->
                </div>
                <div id="password">
                    <label>密&nbsp;&nbsp;&nbsp;码：</label>
                    <input type="password" id="stu_password_hide" name="password" value="输入密码" nullmsg="密码不能为空！" datatype="*4-16" errormsg="密码范围在6~16位之间！" sucmsg="密码验证通过！"/>
                </div>
                <div id="remember">
                    <input type="checkbox" name="remember">
                    <label>记住密码</label>
                </div>
                <div id="login">
                    <button type="submit">登录</button>
                </div>
            </form>
        </div>
        <!-- 员工登录结束-->
    </div>
</div>

</body>
</html>