<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.sams.com/tags" prefix="sams" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<style type="text/css">
fieldset.edit-panel {
	width: 400px;
}

fieldset.edit-panel label.fieldname {
	display: inline-block;
	width: 120px;
	text-align: right;
}

fieldset.edit-panel div {
	margin-top: 10px;
}

<style type="text/css">
	#fanye{margin-top: 20px;text-align: center;}
	div.pager a{
		text-decoration: none;
		border: solid 1px gray;
		padding: 1px 3px;
	}
	div.pager span.current{
		padding: 1px 3px;
		background-color: gray;
		color: white;
	}
	div.pager span.pageInfo{
		margin-left: 10px;
	}
</style>
</style>
<!-- Bootstrap -->
<link
	href="${pageContext.request.contextPath}/content/bootstrap-3.0.3/dist/css/bootstrap.css"
	rel="stylesheet" media="screen">
<!-- Custom CSS -->
<link href="${pageContext.request.contextPath}/content/css/main.css"
	rel="stylesheet">

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script
	src="${pageContext.request.contextPath}/content/script/jquery-1.10.2.js"></script>
<script
	src="${pageContext.request.contextPath}/content/js/jquery.validate-1.17.0.js"></script>
	
<script type="text/javascript">
	$(function() {
		
	})
</script>
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
	                        <li class="active"><a href="admin/updateuser">个人主页</a></li>
	                        <li class="dropdown">
	                            <a href="" class="dropdown-toggle" data-toggle="dropdown">我的邮箱<b class="caret"></b></a>
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
	                        <li><a href="userout">注销</a></li>
	                        <li><a>欢迎，${loginUser.nickname}</a></li>
                        </c:if>
                    </ul>
                </div>
            </nav>
        </header>
    </div>
	
	<c:if test="${topic0 != null}">
		<div class="container" id="container1">
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">${titleForum} - 精华区</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<table class="table table-hover">
							<tr>
								<td style="width: 550px; text-indent: 1em;">主题</td>
								<td style="width: 200px;">作者</td>
								<td style="width: 200px;">回复</td>
								<td>最后回复时间</td>
							</tr>
							<c:forEach var="c" items="${topic1}">
								<tr>
									<td style="width: 550px; text-indent: 1em;"><a href="fectAll?referenceId=${c.id}">${c.title}</a></td>
									<td style="width: 200px;">${c.user.nickname}</td>
									<td style="width: 200px;">${c.commentTimes}/${c.clicks}</td>
									<td>${c.updateTime}</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">${titleForum} - 讨论区</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<table class="table table-hover">
							<tr>
								<td style="width: 550px; text-indent: 1em;">主题</td>
								<td style="width: 200px;">作者</td>
								<td style="width: 200px;">回复</td>
								<td>最后回复时间</td>
							</tr>
	
							<c:forEach var="c" items="${topic0}">
								<tr>
									<td style="width: 550px; text-indent: 1em;"><a href="fectAll?referenceId=${c.id}">${c.title}</a></td>
									<td style="width: 200px;">${c.user.nickname}</td>
									<td style="width: 200px;">${c.commentTimes}/${c.clicks}</td>
									<td>${c.updateTime}</td>
								</tr>
							</c:forEach>
	
						</table>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div id="fanye">
							<sams:pager urlFormat="findTopicByTitle?id=${id}&pageNum=%d"
							pageSize="1" numbers="5" totalRows="${total}" curPage="${param.pageNum}" />
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:if>
	
	
	<c:if test="${topic2 != null}">
		<div class="container" id="container2">
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">${titleForum}	搜索出标题包含 “ ${title} ” 共${rows}条</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<table class="table table-striped">
							<tr>
								<td style="width: 550px; text-indent: 1em;">主题</td>
								<td style="width: 200px;">作者</td>
								<td style="width: 200px;">回复</td>
								<td>最后回复时间</td>
							</tr>
							<c:forEach var="c" items="${topic2}">
								<tr>
									<td style="width: 550px; text-indent: 1em;"><a href="fectAll?referenceId=${c.id}">${c.title}</a></td>
									<td style="width: 200px;">${c.user.nickname}</td>
									<td style="width: 200px;">${c.commentTimes}/${c.clicks}</td>
									<td>${c.updateTime}</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div id="fanye">
							<sams:pager urlFormat="findTopicByTitle?id=${id}&pageNum=%d&title=${title}"
							pageSize="1" numbers="5" totalRows="${total}" curPage="${param.pageNum}" />
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:if>

	<div class="container">
		<footer id="footer" class="panel-footer">
		<p>手机论坛 xda.cn</p>
		<p>Designed by Sam Chen</p>
		</footer>
	</div>
	 <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="${pageContext.request.contextPath}/content/script/jquery-1.10.2.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${pageContext.request.contextPath}/content/bootstrap-3.0.3/dist/js/bootstrap.js"></script>
</body>
</html>