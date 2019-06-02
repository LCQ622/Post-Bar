<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
<script src="static_file/js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="static_file/layui/css/layui.css">
<link rel="stylesheet" href="static_file/css/index.css">
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
		<i class="layui-icon layui-icon-find-fill" id="logo"></i><span
			class="font-class"> 我的贴吧</span>
			<jsp:include   page="user_session_display.jsp" flush="true"/>
	</div>
	<div id="content">
		<!--
	生成
	 (a>div.item>(p.item_title{好玩$吧}+hr+p.item_msg{我是内容简介}+p.item_date{2018年11月26日})) -->




		<c:forEach items="${list }" var="temp">
			<a 
				href="ThematicColumn?column_id=<c:out value="${temp.getColumnId() }"></c:out>">
				<div class="item">
					<p class="item_title">
						<c:out value="${temp.getColumnName() }"></c:out>
					</p>
					<hr />
					<p class="item_msg">
						<c:out value="${temp. getDescription() }"></c:out>
					</p>
					<p class="item_date">
						<fmt:formatDate pattern="yyyy年MM月dd日"
							value="${temp.getColumnCreatedate()}" />
					</p>
				</div>
			</a>
		</c:forEach>
	</div>


	<div id="footer">
		<hr>
		<div>2018 © mcandroid.cn</div>
	</div>
</body>
</html>