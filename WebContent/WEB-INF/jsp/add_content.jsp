<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<c:if test="${sessionScope.username !=null}">
	<title>${thematicColumn.getColumnName()  }-编辑帖子</title>
</c:if>

<script src="static_file/js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="static_file/layui/css/layui.css">
<script src="static_file/layui/layui.js"></script>
<link rel="stylesheet" href="static_file/css/add_content.css">

<script>
	layui.use([ 'element', 'layer' ], function() {
		var element = layui.element;
		var layer = layui.layer;
	});

	$(function() {
		$("#btn1").click(
				function() {
					if (checkActionData()) {
						$.ajax({
							url : "add_content_submit",
							type : "post",
							data : {
								contentTitle : $("#contentTitle").val(),
								thematicContent : $("#thematicContent").val(),
								userId : $("#userId").val(),
								columnId : $("#columnId").val()
							},
							success : function(data) {
								var obj = JSON.parse(data)
								if (obj.add === "1") {
									layer.msg("添加成功");
									location.href = "ThematicColumn?column_id="
											+ $("#columnId").val();
								} else if (obj.add === "2") {
									layer.msg("添加失败！", function() {
									});
								}

							}
						});

					}

				});
	});

	function checkActionData() {
		var contentTitle = $("#contentTitle").val();
		var thematicContent = $("#thematicContent").val();
		if (contentTitle != "") {
			if (thematicContent == "") {
				layer.tips('内容不能为空！', '#thematicContent');
			} else {
				return true;
			}

		} else {
			layer.tips('标题不能为空！', '#contentTitle');
		}
	}
</script>
</head>
<body class="layui-bg-gray">
	<div id="top">
		<a href="index"><i class="layui-icon layui-icon-find-fill"
			id="logo"></i></a> <span id="mbx" class="layui-breadcrumb"> <a
			href="index">首页</a><a
			href="ThematicColumn?column_id=${thematicColumn.getColumnId() }">${thematicColumn.getColumnName()  }</a>
			<a href="add_content?column_id=${thematicColumn.getColumnId() }"><cite>编辑帖子</cite></a>
		</span>
		<c:if test="${sessionScope.username !=null }">
			<a href="logout" class="alink">登出</a>
			<a href="#" class="alink" id="login">您好，${sessionScope.alias }</a>
		</c:if>
	</div>
	<c:if test="${sessionScope.username ==null}">
		<script>
			var r = confirm("您还没有登录，不能发帖！")
			if (r == true) {
				location.href = "login";
			} else {
				location.href = "ThematicColumn?column_id=${thematicColumn. getColumnId() }";
			}
		</script>
	</c:if>
	<!-- 登录成功后 -->
	<c:if test="${sessionScope.username !=null }">
		<div id="content" class="layui-main">
			<div id="form" class="layui-main">
				<div>
					<p id="txt">发帖子到：${thematicColumn.getColumnName()  }</p>
					<div class="layui-progress " id="jdt">
						<div class="layui-progress-bar layui-bg-green" lay-percent="95%"></div>
					</div>
					<input type="hidden" id="columnId" name="columnId"
						value="${thematicColumn.getColumnId() }" /> <input type="hidden"
						id="userId" name="userId" value="${user.getUserId() }" /> <input
						type="text" id="contentTitle" name="contentTitle"
						class="layui-input" placeholder="请输入帖子标题"><br>
					<textarea id="thematicContent" name="thematicContent"
						placeholder="请输入帖子内容"></textarea>
					<button id="btn1" class="layui-btn layui-btn layui-btn-fluid">提交</button>
				</div>
			</div>
		</div>
	</c:if>
	<div id="footer">
		<hr>
		<div>2018 © mcandroid.cn</div>
	</div>

</body>
</html>