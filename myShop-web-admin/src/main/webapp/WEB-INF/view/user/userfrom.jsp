<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <jsp:include page="../../ftl/header.jsp"></jsp:include>
    <title>我的商城 | 用户管理</title>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="../../ftl/nav_header.jsp"></jsp:include>
    <jsp:include page="../../ftl/leftcolomn.jsp"></jsp:include>
    <div class="content-wrapper">
        <section class="content-header">
            <h1>
                用户管理
                <small>欢迎你</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-user"></i>用户管理 </a></li>
                <li class="active">${user.username}</li>
            </ol>

            <div class="box box-info">
                <div class="box-header with-border">
                    <h3 class="box-title">
                        ${tbuser.id==null?"新增":"编辑"}用户
                    </h3>
                </div>
                <!-- /.box-header -->
                <!-- form start -->
                <form class="form-horizontal" action="<%=request.getContextPath()%>/user/saveUser" method="post">
                    <div class="box-body">
                        <div class="alert ${result.status==500?"alert-danger":"alert-success"} alert-dismissible" >
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                            <h5><i class="icon fa fa-ban"></i> ${result.message}</h5>
                        </div>
                        <input type="hidden" class="form-control" name="id" id="inputId" placeholder="Email" value="${tbuser.id}">
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">Email</label>

                            <div class="col-sm-10">
                                <input type="email" class="form-control" name="email" id="inputEmail3" placeholder="Email" value=${tbuser.email}>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" name="password" class="col-sm-2 control-label">密码</label>

                            <div class="col-sm-10">
                                <input type="password" name="password" class="form-control" id="inputPassword3" placeholder="请输入密码"  value=${tbuser.password}>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">姓名</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="username"  placeholder="请输入姓名" value=${tbuser.username}>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">手机号</label>

                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="phone"  placeholder="请输入手机号"  value="${tbuser.phone}">
                            </div>
                        </div>
                    </div>
                    <!-- /.box-body -->
                    <div class="box-footer">
                        <button type="button" class="btn btn-default" onclick="history.go(-1)">返回</button>
                        <button type="submit" class="btn btn-info pull-right">提交</button>
                    </div>
                    <!-- /.box-footer -->
                </form>
            </div>


        </section>
        <!-- /.content -->

    </div>
    <jsp:include page="../../ftl/copyright.jsp"></jsp:include>

</div>
<jsp:include page="../../ftl/footer.jsp"></jsp:include>
</body>
</html>
