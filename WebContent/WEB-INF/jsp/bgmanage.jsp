<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>后台管理</title>
<script src="static_file/js/jquery-3.3.1.min.js"></script>
<script src="static_file/layui/layui.js"></script>
<link rel="stylesheet" href="static_file/layui/css/layui.css">
<script>
	layui.use([ 'element', "layer" ], function() {
		var element = layui.element;
		var layer = layui.layer;
	});
</script>
</head>
<body>





	<table class="layui-table" id="demo" lay-size="sm">
		<tr>
			<th><strong>ID</strong></th>
			<th><strong>用户名</strong></th>
			<th><strong>密码</strong></th>
			<th><strong>邮箱</strong></th>
			<th><strong>昵称</strong></th>
			<th><strong>用户类型</strong></th>
			<th><strong>注册时间</strong></th>
			<th><strong>操作</strong></th>
		</tr>
		<c:forEach var="temp" items="${list }">
			<tr>
				<td>${temp.getUserId()}</td>
				<td>${temp. getUserName() }</td>
				<td>${temp.getUserPwd() }</td>
				<td>${temp.getEmail() }</td>
				<td>${temp.getUserAlias() }</td>
				<td><c:if test="${temp.getUserType() ==1}">
						普通用户
					</c:if> <c:if test="${temp.getUserType() ==2}">
						管理员
					</c:if></td>
				<td><fmt:formatDate pattern="yyyy年MM月dd日 HH:mm:ss"
						value="${temp.getCreatedate()}" /></td>
				<td>
					<button class="layui-btn layui-btn-sm">修改</button>
					<button class="layui-btn  layui-btn-sm layui-btn-danger">删除</button>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>