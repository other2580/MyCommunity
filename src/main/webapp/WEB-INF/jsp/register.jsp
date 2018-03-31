<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
fieldset.edit-panel div{
	margin-top: 10px;
}
</style>
<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/content/bootstrap-3.0.3/dist/css/bootstrap.css" rel="stylesheet" media="screen">
<!-- Custom CSS -->
<link href="${pageContext.request.contextPath}/content/css/main.css" rel="stylesheet">

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${pageContext.request.contextPath}/content/script/jquery-1.10.2.js"></script>
<script src="${pageContext.request.contextPath}/content/js/jquery.validate-1.17.0.js"></script>
<script type="text/javascript">
	$(function() {
		//异步校验用户名是否存在
		$("#check").validate({
			rules:{
				username:{required:true},
				password:{required:true},
				password2:{required:true},
				nickname:{required:true},
				email:{required:true}
			},
			messages:{
				username:{required:"请输入用户名"},
				password:{required:"请设定用户密码"},
				password2:{required:"请输入确认密码"},
				nickname:{required:"请输入昵称"},
				email:{required:"请输入Email"}
			}
		});
	});
</script>

</head>
<body>
	<div class="container">
		<header>
		<div id="logo">
			 <img src="${pageContext.request.contextPath}/content/css/images/logo.png" alt="" />
		</div>
		<nav class="navbar navbar-default">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#navbar-collapse-menu">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">首页</a>
			</div>
			<div class="collapse navbar-collapse" id="navbar-collapse-menu">
				<form class="navbar-form navbar-left" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="主题">
					</div>
					<button type="submit" class="btn btn-default">搜索</button>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">登录</a></li>
				</ul>
			</div>
		</nav> 
		</header>
	</div>
	
	<div class="container">
		<div id="hotAlbums">
			<form action="registerUser" method="post" id="check">
				<fieldset class="edit-panel">
					<div>
						<label class="fieldname">用户名：</label> <input type="text" name="user.username" />
					</div>
					<div>
						<label class="fieldname">密&nbsp;&nbsp;码：</label> <input type="password" name="user.password" />
					</div>
					<div>
						<label class="fieldname">确认密码：</label> <input type="password" name="password2" />
					</div>
					<div>
						<label class="fieldname">昵称：</label> <input type="text" name="user.nickname" />
					</div>
					<div>
						<label class="fieldname">Email：</label> <input type="text" name="user.email" />
					</div>
					<div>
						<label class="fieldname">&nbsp;</label>
						<button type="submit">注册</button>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
	<div class="container">
		<footer id="footer" class="panel-footer">
		<p>手机论坛 xda.cn</p>
		<p>Designed by Sam Chen</p>
		</footer>
	</div>
</body>
</html>