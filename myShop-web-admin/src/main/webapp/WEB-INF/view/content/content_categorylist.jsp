<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <jsp:include page="../../ftl/header.jsp"></jsp:include>
    <%--treetable--%>
    <link  rel="stylesheet" href="<%=request.getContextPath()%>/static/plugins/treeTable/themes/vsStyle/treeTable.min.css">
    <title>我的商城 | 内容管理</title>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="../../ftl/nav_header.jsp"></jsp:include>
    <jsp:include page="../../ftl/leftcolomn.jsp"></jsp:include>
    <div class="content-wrapper">
        <section class="content-header">
            <h1>
                内容管理
                <small>欢迎你</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-user"></i>内容管理 </a></li>
                <li class="active">${user.username}</li>
            </ol>

            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">内容分类</h3>

                            <div class="box-tools">
                                <div class="input-group input-group-sm" style="width: 150px;">
                                    <input type="text" name="table_search" class="form-control pull-right" placeholder="Search">

                                    <div class="input-group-btn">
                                        <button type="submit" onclick="search()" class="btn btn-default"><i class="fa fa-search"></i></button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <a type="button" href="<%=request.getContextPath()%>/user/userfrom" class="btn   margin btn-sm"><i class="fa fa-plus-square"></i>新增</a>
                        <a type="button" class="btn  btn-sm my-remove"><i class="fa fa-trash"></i>删除</a>
                        <a type="button" class="btn  margin btn-sm"><i class="fa fa-cloud-upload"></i>导入</a>
                        <a type="button" class="btn   btn-sm"><i class="fa fa-cloud-download"></i>导出</a>
                        <!-- /.box-header -->
                        <div class="box-body table-responsive mailbox-messages">
                            <table id="treetable" class="table table-hover table-striped">
                                <thead>
                                <tr>

                                    <th>ID</th>
                                    <th>名称</th>
                                    <th>是否排序</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="category" items="${contentcate}">
                                    <tr id="${category.id}" pid="${category.parentid}">
                                        <td>${category.id}</td>
                                        <td>${category.name}</td>
                                        <td>${category.sortorder}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
            </div>
        </section>
        <!-- /.content -->

    </div>
    <jsp:include page="../../ftl/copyright.jsp"></jsp:include>

</div>
<jsp:include page="../../ftl/footer.jsp"></jsp:include>
<%--treetable--%>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/plugins/treeTable/jquery.treeTable.min.js"></script>
</body>
</html>
<script>
    $(function () {
        $("#treetable").treeTable({
            expandLevel: 2,
            column: 1
        });
    })
</script>
