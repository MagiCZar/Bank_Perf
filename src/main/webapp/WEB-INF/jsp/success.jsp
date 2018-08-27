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
<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>银行管理系统</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/frame.css">
    <link rel="stylesheet" href="css/addClass.css">
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!-- 	<script>
        function printInputValue(){
            var inputValue = document.getElementById("login-user-input").value;
            document.getElementById("login-user-output").innerHTML = inputValue;
        }
        </script> -->
</head>

<body>

<div class="head">
    <div class="common-head clearfix">
        <!-- <a class="logo" href="EmpMainpage.html">
            <img src="img/logo3.png" alt="">
        </a> -->

        <div class="right pull-right text-right" id="hovpad">
            <dl class="user-wrapper">
                <dt><span class="time">欢迎您</span><span id="login-user-output" class="time"></span><img src="img/headjt.png" alt=""><img class="active" src="img/headjt-active.png" alt=""></dt>
                <dd>
                    <div class="head clearfix">
                        <a href="">账户信息</a>
                        <!-- <span></span> -->
                    </div>

                    <div class="head clearfix">
                        <a href="login.html">安全退出</a>
                    </div>
                    <!-- <ul>
                        <li>登陆：100&nbsp;次</li>
                        <li>下单：1000&nbsp;次</li>
                        <li>审单：1000&nbsp;次</li>
                        <li>好评：1000&nbsp;次</li>
                        <li>积分：1000&nbsp;分</li>
                        <li>星级：
                            <img src="img/star.png" alt="">
                            <img src="img/star.png" alt="">
                            <img src="img/star-ban.png" alt="">
                            <img src="img/star-hui.png" alt="">
                            <img src="img/star-hui.png" alt="">
                        </li>
                    </ul> -->
                </dd>
            </dl>
            <dl class="msg-wrapper">
                <dt class="clearfix"><img src="img/msg.png" alt=""><img class="active" src="img/msg-active.png" alt=""><span> 消息 </span><!-- <span class="tag">320</span> --></dt>
                <dd>
                    <a href="">交易通知：<span>123</span></a>
                    <a href="">系统通知：<span>123</span></a>
                    <a href="">系统消息：<span>123</span></a>
                </dd>
            </dl>
        </div>
    </div>
</div><!-- common-head -->

<!-- common-head -->
<!--侧栏-->
<div class="side-bar">
    <div class="logobox">
        <a href="index.html" class="banklogo">
            <img src="img/banklogo3.png" alt="">
        </a>
        <a href="index.html" class="banklogo2">
            <img src="img/banklogo2.png" alt="">
        </a>
    </div>
    <div class="content">
        <dl>
            <dt style="border-top: none;"><img class="line" src="img/line.png" alt="">客户管理 <img class="b" src="img/jt-right-co.png" alt=""><img class="r" src="img/jt-bottom.png" alt=""></dt>
            <dd>
                <a href="#eventable.html">客户信息 </a>
                <!-- <a href="#view/communication.html">业务管理 </a> -->
            </dd>
        </dl>
        <dl>
            <dt ><img class="line" src="img/line.png" alt="">绩效查看 <img class="b" src="img/jt-right-co.png" alt=""><img class="r" src="img/jt-bottom.png" alt=""></dt>
            <dd>
                <a href="#show2.html">考勤记录 </a>
                <a href="#service2.html">数据对比 </a>
                <!-- <a href="#view/loginCode.html">周报生成 </a> -->

            </dd>
        </dl>

        <dl>
            <dt><img class="line" src="img/line.png" alt="">个人中心 <img class="b" src="img/jt-right-co.png" alt=""><img class="r" src="img/jt-bottom.png" alt=""></dt>
            <dd>
                <a href="#table.html">信息管理 </a>
                <!-- <a href="#">错误申诉 </a> -->
            </dd>
        </dl>
    </div>
</div>
<!--内容部分-->
<div id="main" >
    <div   style="-webkit-overflow-scrolling:touch;overflow:auto;height: 100%;">
        <iframe class="scroll"  src="table.html" id="ghrzFrame"  frameborder="no" border="0"></iframe>
        <!-- 此数的src 填success -->
    </div>
</div>
</body>
<script src="js/jquery-1.11.3.js"></script>


<script>
    //首次加载至url
    var u = window.location.href.split('#')[1]; //以“#”拆分当前url，取第二部分
    $('#main iframe').attr('src',u);   //attr 对src属性进行设置
    $('.side-bar dd a[href="#'+ $('#main iframe').attr('src') + '"]').addClass('active');


    //侧栏菜单
    $(function() {                               //$(document).ready(function(){    DOM加载完成后对DOM进行操作
        $('.side-bar dt').click(function() {
            var dd = $(this).siblings('dd');
            dd.slideToggle();                  //slideToggle在显示和隐藏之间滑动切换
            $(this).find('.b').toggle()       //toggle是在显示和隐藏之间闪现切换
            $(this).find('.r').toggle()
        });
        $('.side-bar dd a').click(function() {
            $('.side-bar dd a').removeClass('active');
            $(this).addClass('active');
            //页面显示控制
            var url = $(this).attr('href').substring(1);
            var f = $('#main iframe');
            f.attr('src', url);
        });
    });

    $('#hovpad dl').on('click', function(e) {
        var dd = $(this).find('dd');
        if (dd.css('display') === 'none') {
            dd.show();
            $(this).addClass('active');
        } else {
            dd.hide();
            $(this).removeClass('active');
        }
        e.stopPropagation();
    });
    $('#hovpad dl').hover(function(e) {
        var dd = $(this).find('dd');
        dd.show();
        $(this).addClass('active');
    }, function(e) {
        var dd = $(this).find('dd');
        dd.hide();
        $(this).removeClass('active');
    })
    $('body').on('click', function() {
        $('#hovpad dl').removeClass('active');
    })



    function oneValues(){
        var result;
        var url=window.location.search; //获取url中"?"符后的字串
        if(url.indexOf("?")!==-1){
            result = url.substr(url.indexOf("=")+1);
        }
        return result;
    }

    $(function(){
        $("#login-user-output").html(oneValues());
    })


</script>

</html>
