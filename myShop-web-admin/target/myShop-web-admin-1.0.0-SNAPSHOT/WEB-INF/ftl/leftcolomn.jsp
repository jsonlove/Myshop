<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="<%=request.getContextPath()%>/static/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>${user.username}</p>
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">控制台</li>
            <li class="active treeview">
                <a href="#">
                    <i class="fa  fa-user"></i> <span>用户管理</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="<%=request.getContextPath() %>/user/list"><i class="fa fa-circle-o"></i>用户列表</a></li>
                    <li><a href="<%=request.getContextPath() %>/user/userfrom"><i class="fa fa-circle-o"></i>添加用户</a></li>
                </ul>
            </li>
            <li class="active treeview">
                <a href="#">
                    <i class="fa  fa-book"></i> <span>内容管理</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="<%=request.getContextPath() %>/content/content_categorylist"><i class="fa fa-circle-o"></i>分类管理</a></li>
                    <li><a href="<%=request.getContextPath() %>/content/contentlist"><i class="fa fa-circle-o"></i>内容列表</a></li>
                </ul>
            </li>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>
