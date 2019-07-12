<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <jsp:include page="../../ftl/header.jsp"></jsp:include>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/plugins/dropzone/basic.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/plugins/dropzone/dropzone.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/plugins/jquery-ztree/css/zTreeStyle/zTreeStyle.min.css">
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
                            <div class="box-header with-border">
                                <h3 class="box-title">
                                    ${content.id==null?"新增":"编辑"}内容
                                    ${contentfrom}
                                </h3>
                            </div>
                            <!-- form start -->
                            <form class="form-horizontal" action="<%=request.getContextPath()%>/content/saveContent" method="post">
                                <div class="box-body">
                                    <div class="alert ${result.status==500?"alert-danger":"alert-success"} alert-dismissible" >
                                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                        <h5><i class="icon fa fa-ban"></i> ${result.message}</h5>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputcategory" class="col-sm-2 control-label">分类</label>

                                        <div class="col-sm-10">
                                            <ul id="myTree" class="ztree"></ul>
                                            <input type="text" name="categoryid" hidden="hidden" value="${contentfrom.content.categoryid}">
                                            <input type="text" class="form-control" name="category_name" id="inputcategory" disabled="disabled" placeholder="分类" value="${contentfrom.category.name}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputtitle" name="title" class="col-sm-2 control-label">内容标题</label>

                                        <div class="col-sm-10">
                                            <input type="text" name="title" class="form-control" id="inputtitle" placeholder="内容标题"  value="${contentfrom.content.title}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="sub_title" class="col-sm-2 control-label">子标题</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="subtitle"  placeholder="子标题" value="${contentfrom.content.subtitle}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputEmail3" class="col-sm-2 control-label">标题描述</label>

                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="titledesc"  placeholder="标题描述"  value="${contentfrom.content.titledesc}">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputEmail3" class="col-sm-2 control-label">链接</label>

                                        <div class="col-sm-10">
                                            <c:if test="${contentfrom.content.url==null}"> <input type="text" class="form-control" name="url"  placeholder="链接"  value="${contentfrom.content.url}"></c:if>
                                            <c:if test="${contentfrom.content.url!=null}"><a href="${contentfrom.content.url}">查看</a></c:if>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputEmail3" class="col-sm-2 control-label">图片</label>
                                        <input type="hidden" id="pic" class="form-control" name="pic"  placeholder="图片链接"  value="${contentfrom.content.pic}">
                                        <div class="col-sm-10">
                                            <%--<input type="text" class="form-control" name="pic"  placeholder="图片"  value="${contentfrom.content.pic}">--%>
                                            <div id="dropz" class="dropzone"></div>
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

                        </div>
                        <!-- /.box-body -->
                    </div>
            </div>
        </section>
        <!-- /.content -->

    </div>
    <jsp:include page="../../ftl/copyright.jsp"></jsp:include>

</div>
<jsp:include page="../../ftl/footer.jsp"></jsp:include>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/plugins/jquery-ztree/js/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/plugins/dropzone/dropzone.js"></script>
</body>
</html>
<script>
    //ztree 树形前端插件
    var setting={
        //禁止多选
        view:{selectedMulti: false},
        async:{
            // 开启异步加载功能
            enable: true,
            // 远程访问地址
            url: "<%=request.getContextPath()%>/content/categorytreedata",
            // 选择父节点时会自动将节点中的参数传回服务器再重新取结果
            autoParam: ["id"]
        },
        callback:{
            onMouseDown: onMouseDown,
        }
    };
    $.fn.zTree.init($("#myTree"),setting);
    function onMouseDown(event, treeId, treeNode) {
        $("#inputcategory").val(treeNode.name);
        alert("id="+treeNode.id);
        $("input[name='categoryid']").val(treeNode.id);
    }
    Dropzone.autoDiscover = false;
    $("#dropz").dropzone({
        url:"<%=request.getContextPath()%>/upload",
        dictDefaultMessage: '拖动文件至此或者点击上传', // 设置默认的提示语句
        paramName: "dropfile",
        dictRemoveLinks: "删除",
        init: function () {
            this.on("success", function (file, data) {
                // 上传成功触发的事件
                $("#pic").val(data.filename);
                alert("上传成功");
            });
        }
    })


</script>
