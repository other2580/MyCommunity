<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Insert title here</title>
	<!-- 移动优先，保持当前绘制和触屏缩放 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/content/bootstrap-3.0.3/dist/css/bootstrap.css" rel="stylesheet" media="screen">
    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/content/css/main.css" rel="stylesheet">
    <style type="text/css">
    	table{margin-left: 30px;}
    	table tr td{height: 50px;}
    </style>
</head>
<body>
    <div class="container">
        <header>
            <div id="logo">
                <img src="${pageContext.request.contextPath}/content/css/images/logo.png" alt="" />
            </div>
            <nav class="navbar navbar-default" >
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse-menu">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                    <a class="navbar-brand" href="#">首页</a>
                </div>
                <div class="collapse navbar-collapse" id="navbar-collapse-menu">
                	<c:if test="${loginUser!=null}">
	                    <ul class="nav navbar-nav">
	                        <li class="active"><a href="#">个人主页</a></li>
	                        <li class="dropdown">
	                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">我的邮箱<b class="caret"></b></a>
	                            <ul class="dropdown-menu">
	                                <li><a href="admin/updateEmail">收件箱</a></li>
	                                <li><a href="admin/updateEmail">发件箱</a></li>
	                                <li class="divider"></li>
	                                <li><a href="admin/updateEmail">回收站</a></li>
	                            </ul>
	                        </li>
	                    </ul>
                    </c:if>
                    <form class="navbar-form navbar-left" role="search">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="主题">
                        </div>
                        <button type="submit" class="btn btn-default">搜索</button>
                    </form>
                    <ul class="nav navbar-nav navbar-right">
                    	<c:if test="${loginUser==null}">
	                        <li><a href="login">登录</a></li>
	                        <li><a href="register">注册</a></li>
                        </c:if>
                        <c:if test="${loginUser!=null}">
	                        <li><a>欢迎，${loginUser.nickname}</a></li>
                        </c:if>
                    </ul>
                </div>
            </nav>
        </header>
    </div>
    <div class="container">
       <form action="admin/updateU">
       	<table>
       		<tr>
       			<td>上传头像</td>
       			<td></td>
       		</tr>
       		<tr>
       			<td>用户名</td>
       			<td><input type="text" name="user.username" value="${loginUser.username}"  readonly="true"/></td>
       		</tr>
       		<tr>
       			<td>密码</td>
       			<td><input type="password" name="user.password" value="${loginUser.password}"/></td>
       		</tr>
       		<tr>
       			<td>确认密码</td>
       			<td><input type="password" name="password2" value=""/></td>
       		</tr>
       		<tr>
       			<td>昵称</td>
       			<td><input type="text" name="user.nickname" value="${loginUser.nickname}"/></td>
       		</tr>
       		<tr>
       			<td>个性签名</td>
       			<td><input type="text" name="user.signature" value="${loginUser.signature}"  readonly="true"/></td>
       		</tr>
       		<tr>
       			<td>积分</td>
       			<td><input type="text" name="user.grade" value="${loginUser.grade}"  readonly="true"/></td>
       		</tr>
       		<tr>
       			<td>Email</td>
       			<td><input type="text" name="user.email" value="${loginUser.email}"  readonly="true"/></td>
       		</tr>
       		<tr>
       			<td></td>
       			<td><button type="submit">修改</button>&nbsp;&nbsp;<button>返回到首页</button></td>
       		</tr>
       	</table>
       </form>
    </div>
    <div class="container">
        <footer id="footer" class="panel-footer">
            <p>手机论坛 xda.cn </p>
            <p>Designed by Sam Chen </p>
        </footer>
    </div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="${pageContext.request.contextPath}/content/script/jquery-1.10.2.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${pageContext.request.contextPath}/content/bootstrap-3.0.3/dist/js/bootstrap.js"></script>
</body>
</html>