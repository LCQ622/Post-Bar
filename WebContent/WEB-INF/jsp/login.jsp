<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8">
<title>登录</title>
<script src="static_file/js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="static_file/layui/css/layui.css">
<link rel="stylesheet" href="static_file/css/login.css">
<script src="static_file/layui/layui.js"></script>
<script>
	layui.use([ 'element', "layer" ], function() {
		var element = layui.element;
		var layer = layui.layer;
	});

	$(function() {
		$("#btn1").click(function() {
			if (checkActionData()) {

				$.ajax({
					url : "login_submit",
					type : "post",
					data : {
						username : $("#username").val(),
						pwd : $("#pwd").val()
					},
					success : function(data) {
						var obj = JSON.parse(data)
						if (obj.login === "1") {
							layer.msg("登录成功！")
							location.href = "index";
						}
						if (obj.login === "2") {
							layer.confirm("该用户名不存在，是否注册新用户?", {
								btn : [ '注册新用户', '取消' ]
							//按钮
							}, function() {
								location.href = "register";
							}, function() {

							});
						}
						if (obj.login === "3") {
							layer.msg("请检查用户名或密码是否正确!", function() {
							});
						}

					}
				});
			}
		});
	});

	function checkActionData() {

		var username = $("#username").val();
		var pwd = $("#pwd").val();
		if (username != "") {
			if (pwd == "") {
				layer.tips('密码不能为空！', 'input[name=pwd]');
			} else {
				return true;
			}

		} else {
			layer.tips('用户名不能为空！', 'input[name=username]');
		}
	}
</script>

</head>
<body class="layui-bg-gray">
	<%
		if (session.getAttribute("username") != null && null != session.getAttribute("pwd")) {
			out.print("<script> alert('您已经登录了，如需重新登录，请在主页登出');</script>");
			out.print("<script> window.location.href='index'; </script>");
		}
	%>
	<div id="top">
		<a href="index"><i class="layui-icon layui-icon-find-fill" id="logo"></i></a> 
		<span id="mbx" class="layui-breadcrumb"> <a href="index">首页</a> <a href="login"><cite>登录</cite></a>
		</span>
	</div>
	<div id="content" class="layui-main">
		<div id="form" class="layui-main">
			<div>


				<p id="txt">登录</p>
				<div class="layui-progress " id="jdt">
					<div class="layui-progress-bar layui-bg-green" lay-percent="35%"></div>
				</div>
				<!--  去除form 便签 使用 ajax提交-->
				<input type="text" name="username" id="username" class="layui-input"
					placeholder="请输入用户名"><br> <input type="password"
					name="pwd" id="pwd" class="layui-input" placeholder="请输入密码"><br>
				<button id="btn1" class="layui-btn ">立即登录</button>
				<a href="register"><button id="btn2" class="layui-btn layui-btn-primary ">前往注册</button></a><br />
				<br />
				<br />
				
				<a href="#" id="forgetPwd">忘记密码</a>
			</div>
			
			
		</div>
	</div>

	<div id="footer">
		<hr>
		<div>2018 © mcandroid.cn</div>
	</div>
</body>
</html>