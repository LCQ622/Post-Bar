<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8">
<title>用户注册</title>
<script src="static_file/js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="static_file/layui/css/layui.css">
<link rel="stylesheet" href="static_file/css/register.css">
<script src="static_file/layui/layui.js"></script>

<script>
	layui.use([ 'element', "layer" ], function() {
		var element = layui.element;
		var layer = layui.layer;
	});

	$(function() {
		$("#btn1").click(function() {

			if (checkActionData()) {
				// 校验完成后执行的操作

				$.ajax({
					url : "register_submit",
					type : "post",
					data : {
						username : $("input[name=username]").val(),
						pwd : $("input[name=pwd]").val(),
						alias : $("input[name=alias]").val(),
						email : $("input[name=email]").val()
					},
					success : function(data) {
						/* 1. 存在 
						2. 不存在
						 */
						var obj = JSON.parse(data)
						if (obj.result === "1") {
							layer.msg("该用户名已存在！", function() {
							});
						} else if (obj.result === "2") {
							layer.confirm('注册成功！', {
								btn : [  '前往登录','返回首页' ]
							//按钮
							}, function() {
								location.href = "login"

							}, function() {
								location.href = "index"
							});
						} else if (obj.result === "3") {
							layer.msg(obj.msg, function() {
							});
						}

					}
				});
			}

		});

	});

	//校验输入。校验完成即返回true

	function checkActionData() {
		var username = $("input[name=username]").val();
		var alias = $("input[name=alias]").val();
		var pwd = $("input[name=pwd]").val();
		var checkpwd = $("input[name=checkpwd]").val();
		var email = $("input[name=email]").val();
		if (username != "") {
			if (alias != "") {
				if (pwd == "" && checkpwd == "") {
					layer.tips('密码不能为空！', 'input[name=pwd]');
				} else {
					if (pwd != checkpwd) {
						layer.tips('两次输入的密码不一致！', 'input[name=checkpwd]');
					} else {
						if (email != "") {
							return true;
						} else {
							layer.tips('email不能为空！', 'input[name=email]');
						}
					}
				}
			} else {
				layer.tips('昵称不能为空！', 'input[name=alias]');
			}
		} else {
			layer.tips('用户名不能为空！', 'input[name=username]');
		}

	}
</script>
</head>
<body class="layui-bg-gray">
	<div id="top"> <a href="index"><i class="layui-icon layui-icon-find-fill" id="logo"></i></a>
	<span id="mbx" class="layui-breadcrumb"> <a href="index">首页</a>
			<a href="register"><cite>注册</cite></a>
		</span>
	</div>
	
	<div id="content" class="layui-main">
		
		<div id="form" class="layui-main">
			<div>
				<p id="txt">注册</p>
				<div class="layui-progress " id="jdt">
					<div class="layui-progress-bar layui-bg-green" lay-percent="35%"></div>
				</div>
				<!--  去除form 便签 使用 ajax提交-->
				<input type="text" name="username" class="layui-input"
					placeholder="请输入用户名"><br> <input type="text"
					name="alias" class="layui-input" placeholder="请输入昵称"><br>
				<input type="password" name="pwd" class="layui-input"
					placeholder="请输入密码"><br> <input type="password"
					name="checkpwd" class="layui-input" placeholder="请再次入密码"><br>
				<input type="email" name="email" class="layui-input"
					placeholder="请输入邮箱地址"><br>
				<button id="btn1" class="layui-btn layui-btn layui-btn-fluid">立即注册</button>
			</div>
		</div>
	</div>

	<div id="footer">
		<hr>
		<div>2018 © mcandroid.cn</div>
	</div>
</body>
</html>