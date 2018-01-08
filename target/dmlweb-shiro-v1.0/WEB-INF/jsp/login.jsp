<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <link rel="Bookmark" href="${pageContext.request.contextPath}/resources/image/favicon.ico">
    <link rel="Shortcut Icon" href="${pageContext.request.contextPath}/resources/image/favicon.ico"/>
    <title>yutonsCMS内容管理系统！</title>
    <link href="${pageContext.request.contextPath}/resources/bootstrap-3.3.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/bootstrap-3.3.0/css/font-awesome.css?v=4.4.0"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/bootstrap-3.3.0/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/bootstrap-3.3.0/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/bootstrap-3.3.0/css/login.css" rel="stylesheet">
</head>

<body class="signin">
<div class="signinpanel">
    <div class="row  clearfix">
        <div class="col-md-7 column">
            <div class="signin-info">
                <div class="logopanel m-b">
                    <h1>欢迎使用</h1>
                </div>
                <div class="m-b"></div>
                <h1><strong>yutonsCMS内容管理系统</strong></h1>
            </div>
        </div>
        <div class="col-md-5 column">
            <form method="post" action="${pageContext.request.contextPath}/login">
                <h4 class="no-margins">登录：<span style="color: red">${msg}</span></h4>
                <input type="text" name="username" class="form-control uname" placeholder="请输入员工号"/>
                <input type="password" name="password" class="form-control pword m-b" placeholder="请输入密码"/>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" name="rememberMe" style="margin-top: 2px">记住我
                    </label>
                </div>
                <input type="submit" class="btn btn-success btn-block" value="登录">
            </form>
        </div>
    </div>
    <div class="signup-footer">
        <div class="pull-left">
            Copyrights &copy; yutonsCMS All Rights Reserved.
        </div>
    </div>
</div>
<!--Apache Shiro会话超时，登录页面跳转到父窗体的解决方法-->
<script>
    window.onload = function () {
        if (window.parent.window != window) {
            window.top.location = "${pageContext.request.contextPath}/login";
        }
    }
</script>
</body>
</html>