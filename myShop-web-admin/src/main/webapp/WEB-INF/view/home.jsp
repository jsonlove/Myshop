<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <jsp:include page="../ftl/header.jsp"></jsp:include>
    <title>我的 | 商城</title>

</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="../ftl/nav_header.jsp"></jsp:include>
    <jsp:include page="../ftl/leftcolomn.jsp"></jsp:include>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                控制面板
                <small>欢迎你</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-user"></i>用户管理 </a></li>
                <li class="active">Dashboard</li>
            </ol>
        </section>
        <!-- /.content -->
    </div>
    <jsp:include page="../ftl/copyright.jsp"></jsp:include>

</div>
    <jsp:include page="../ftl/footer.jsp"></jsp:include>
</body>
</html>
