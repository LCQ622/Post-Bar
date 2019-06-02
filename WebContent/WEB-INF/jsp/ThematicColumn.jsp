<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${obj.getColumnName() }</title>
<script src="static_file/js/jquery-3.3.1.min.js"></script>
<script src="static_file/layer/layer.js"></script>
<link rel="stylesheet" href="static_file/layui/css/layui.css">
<link rel="stylesheet" href="static_file/css/ThematicColumn.css">
<script src="static_file/layui/layui.js"></script>
<script>
	layui.use([ 'element', "layer" ], function() {
		var element = layui.element;
		var layer = layui.layer;
	});
</script>
</head>
<body class="layui-bg-gray">
	<div id="top">

		<a href="index"><i class="layui-icon layui-icon-find-fill"
			id="logo"></i></a><span class="font-class">${obj.getColumnName() }</span>

		<c:if test="${sessionScope.username !=null }">
			<a href="logout" class="alink">登出</a>
			<a href="#" class="alink" id="login">您好，${sessionScope.alias }</a>
		</c:if>
		<c:if test="${sessionScope.username ==null}">
			<a href="register" target="_blank" class="alink" id="reg">注册</a>
			<a href="login" class="alink" id="login">登录</a>
		</c:if>
	</div>

	<div id="content">

		<div>
			<div id="content_title">
				<span id="mbx" class="layui-breadcrumb"> <a href="index">首页</a>
					<a href="ThematicColumn?column_id=${obj.getColumnId() }"><cite>${obj.getColumnName() }</cite></a>
				</span> <a href="add_content?column_id=${obj.getColumnId() }"><button
						id="btn1" class="layui-btn  layui-btn-sm  ">
						<i class="layui-icon">&#xe608;</i>我要发帖
					</button></a>
			</div>
			<c:if test="${empty list}">

				<!-- 需要修改发帖按钮 -->
				<script>
					layer.confirm(
									$("title").text() + '还没有贴子，抢先发贴？',
									{
										btn : [ '发帖', '返回上层' ]
									//按钮
									},
									function() {
										location.href = "add_content?column_id=${obj.getColumnId() }";

									}, function() {
										location.href = "index";
									});
				</script>
			</c:if>
	


		<c:if test="${!empty list}">
			<c:forEach items="${list }" var="temp">
				<a href="thematic_content?contentId=<c:out value="${temp.contentId }"></c:out>">
					<div class="item">
						<p class="item_title">
							<c:out value="${temp.Title }"></c:out>
						</p>
						<span class="item_username"><c:out value="${temp.Alias }"></c:out></span>
						<hr />
						<p class="item_msg">
							<c:out value="${temp.msg }"></c:out>
						</p>
						<p class="item_date">
							<fmt:formatDate pattern="yyyy年MM月dd日 HH:mm:ss"
								value="${temp.date}" />
						</p>
					</div>
				</a>
			</c:forEach>
		</c:if>
	</div>
	</div>

	<div id="footer">
		<hr>
		<div>2018 © mcandroid.cn</div>
	</div>
</body>
</html>