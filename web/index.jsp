</html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML>
<html>

<head>
    <base href="<%=basePath%>">
    <title>注册页面</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, talker-scalable=no" name="viewport">
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/AdminLTE.min.css">
    <link rel="stylesheet" href="assets/css/_all-skins.min.css">
    <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/Ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="assets/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">

    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/adminlte.min.js"></script>
    <script src="assets/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>

</head>

<body class="hold-transition login-page">

<div class="register-box" style="position:absolute; left:500px">
    <div class="register-logo">
        <strong>Chatting Room</strong>
    </div>
    <div class="register-box-body">
        <p class="register-box-msg">注册一个新用户</p>
        <form action="register/testify" method="post">
            <div class="form-group has-feedback">
                <input class="form-control" name="name" placeholder="用户名" type="text"/>
                <span class="glyphicon glyphicon-talker form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input class="form-control" name="email" placeholder="邮箱" type="text"/>
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input class="form-control" name="password" placeholder="密码" type="password"/>
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input class="form-control" placeholder="重复密码" type="password"/>
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>

            <div class="form-group">
                <div class="input-group date" id="datepicker">
                    <div class="input-group-addon">
                        <i class="fa fa-calendar"></i>
                    </div>
                    <input type="text" class="form-control pull-right" name="birthday" placeholder="生日">
                </div>
                <!-- /.input group -->
            </div>

            <div class="row">
                <label class="col-md-2 text-right" style="padding:0">头像:</label>
                <div class="col-md-10">
                    <input type="file" name="icon"/>
                </div>
            </div>
            <div class="row">
                <label class="col-sm-2 text-right" style="padding:0">性别:</label>
                <div class="col-md-10">

                    <label class="radio-inline">
                        <input type="radio" name="sex" value="1"/>男
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="sex" value="0"/>女
                    </label>
                </div>
            </div>
            <div class="row">
                <div class="col-md-8">
                    <a href="wechat">已有账户</a>
                </div>
                <div class="col-md-4">
                    <input type="submit" class="btn btn-sm btn-primary btn-block btn-flat" value="注册"/>
                </div>
            </div>
        </form>
    </div>


</div>

</body>
</html>

<script>
    $('#datepicker').datepicker({
        format: 'yyyy/mm/dd',
        endDate: '0d'
    });

</script>
