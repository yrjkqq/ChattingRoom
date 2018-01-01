<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
    <base href="<%=basePath%>">
    <title>登陆页面</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, talker-scalable=no" name="viewport">
    <script src="assets/js/jquery-1.12.3.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/AdminLTE.min.css">
    <link rel="stylesheet" href="assets/css/_all-skins.min.css">
    <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/Ionicons/css/ionicons.min.css">
</head>

<body class="hold-transition login-page" style="height:auto">
<div class="login-box">
    <div class="login-logo">
        <strong>Chatting Room</strong>
    </div>
    <div class="login-box-body">
        <p class="login-box-msg">Hello World!</p>
        <form action="wechat/testify" method="post">
            <div class="form-group has-feedback">
                <input class="form-control" name="name" placeholder="用户名" type="text" value="${name}"/>
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                <span style="color:red">${tipToName}</span>
            </div>
            <div class="form-group has-feedback">
                <input class="form-control" name="password" placeholder="密码" type="password"/>
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                <span style="color:red">${tipToPassword}</span>
            </div>
            <div class="row">
                <div class="col-md-8">
                    <a href="register">注册新用户</a>
                </div>
                <div class="col-md-4">
                    <input type="submit" class="btn btn-sm btn-primary btn-block btn-flat" value="登陆"/>
                </div>
            </div>
        </form>
    </div>


</div>
</body>
</html>
