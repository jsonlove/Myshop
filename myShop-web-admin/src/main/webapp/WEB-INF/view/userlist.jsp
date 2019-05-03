<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <jsp:include page="../ftl/header.jsp"></jsp:include>
    <title>我的商城 | 用户管理</title>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="../ftl/nav_header.jsp"></jsp:include>
    <jsp:include page="../ftl/leftcolomn.jsp"></jsp:include>
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

            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">用户列表</h3>

                            <div class="box-tools">
                                <div class="input-group input-group-sm" style="width: 150px;">
                                    <input type="text" name="table_search" class="form-control pull-right" placeholder="Search">

                                    <div class="input-group-btn">
                                        <button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
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
                            <table id="example2" class="table table-hover table-striped">
                                <thead>
                                    <tr>
                                        <th> <button type="button" class="btn btn-default btn-sm checkbox-toggle"><i class="fa fa-square-o"></i>
                                        </button></th>
                                        <th>ID</th>
                                        <th>姓名</th>
                                        <th>邮箱</th>
                                        <th>手机号</th>
                                        <th>注册时间</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <%--<c:forEach items="${users}" var="user">--%>
                                    <%--<tr>--%>
                                        <%--<td  class="table-responsive mailbox-messages"><input type="checkbox"></td>--%>
                                        <%--<td ><i>${user.id}</i></td>--%>
                                        <%--<td>${user.username}</td>--%>
                                        <%--<td>${user.email}</td>--%>
                                        <%--<td>${user.phone}</td>--%>
                                        <%--<td><fmt:formatDate value="${user.created}" pattern="yyyy/MM/dd HH:mm:ss"></fmt:formatDate></td>--%>
                                        <%--<td>--%>
                                                <%--<a type="button" href="#" class="btn btn-default btn-sm"><i class="fa fa-search"></i>查看</a>--%>
                                                <%--<a type="button" href="<%=request.getContextPath()%>/user/userfrom?id=${user.id}" class="btn btn-info btn-sm "><i class="fa fa-edit"></i>编辑</a>--%>
                                                <%--<a type="button" href="#" class="btn btn-danger btn-sm"><i class="fa fa-trash"></i>删除</a>--%>
                                        <%--</td>--%>
                                    <%--</tr>--%>
                                <%--</c:forEach>--%>

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
    <jsp:include page="../ftl/copyright.jsp"></jsp:include>

</div>
<jsp:include page="../ftl/footer.jsp"></jsp:include>
</body>
</html>
<script>
    $(function () {
        var _columns=[   {'data':function ( row, type, val, meta ) {
                return " <td  class=\"table-responsive mailbox-messages\"><input type=\"checkbox\"></td>"
            }
        },
            {'data':'id'},
            {'data':'username'},
            {'data':'email'},
            {'data':'phone'},
            {'data':'created'},
            {'data':function ( row, type, val, meta ) {
                    return "<td>\n" +
                        "                <a type=\"button\" href=\"#\" class=\"btn btn-default btn-sm\"><i class=\"fa fa-search\"></i>查看</a>\n" +
                        "            <a type=\"button\" href=\"<%=request.getContextPath()%>/user/userfrom?id=${user.id}\" class=\"btn btn-info btn-sm \"><i class=\"fa fa-edit\"></i>编辑</a>\n" +
                        "        <a type=\"button\" href=\"#\" class=\"btn btn-danger btn-sm\"><i class=\"fa fa-trash\"></i>删除</a>\n" +
                        "        </td>"
                }}
        ];
        App.initdatatable("<%=request.getContextPath()%>/user/gotopage",_columns);

    });

    $('.my-remove').click(function () {
        var checks=new Array();
        $('.mailbox-messages input[type="checkbox"]').each(function (i) {
            if($(this).is(":checked")){
                checks.push($(this).parent().parent().next().text());
            }
        });
        // if(checks.length===0){
        //     alert("请至少选择一条");
        //     return;
        // }
        console.log(checks);
        $.post("<%=request.getContextPath()%>/user/removeUser",{'ids':checks},function (data) {
            alert(data.message);
            location.reload();
        })
    });
</script>
