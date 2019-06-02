<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${user1.getUserAlias() }的帖子</title>
<script src="static_file/js/jquery-3.3.1.min.js"></script>
<script src="static_file/layer/layer.js"></script>
<script src="static_file/layui/layui.js"></script>
<link rel="stylesheet" href="static_file/layui/css/layui.css">
<link rel="stylesheet" href="static_file/css/tools.css">
<link rel="stylesheet" href="static_file/css/thematic_content.css">
<script>
	layui.use([ 'element', 'layer', 'layedit' ], function() {
		var element = layui.element;
		var layer = layui.layer;
		var layedit = layui.layedit;
		var edit = layedit.build('edit',{ height: 180}); //建立编辑器
		
		$("#btn1").click(function(){
			if($("#username").val()!=""){
				if(layedit.getText(edit)!=""){
				$.ajax({
					url:"replies_submit",
					type:"post",
					data:{
						contentId:$("#contentId").val(),
						username:$("#username").val(),
						repliesContent:layedit.getText(edit)
					},
					success:function(data){
						var obj = JSON.parse(data)
						if(obj.replies==="1"){
							layer.msg("发表回复成功！");
							 location.reload();
							
						}else if(obj.replies==="2"){
							layer.msg("发表回复失败！请重新发表回复！",function(){});
						}
					}
					
				});
				}else{
					layer.msg("回复内容不能为空！",function(){});
				}
			}else{
				layer.msg("您还没有登录！",function(){});
			}
		});

	});
	

	
</script>

</head>
<body class="layui-bg-gray">
	<div id="top" class="top">
		<a href="index"><i class="layui-icon layui-icon-find-fill"
			id="logo"></i></a> <span id="mbx" class="layui-breadcrumb"> <a
			href="index">首页</a><a
			href="ThematicColumn?column_id=${thematicColumn.getColumnId() }">${thematicColumn.getColumnName()  }</a>
			<a href="#"><cite>${user1.getUserAlias() }&nbsp;的帖子</cite></a>
		</span>
		<jsp:include   page="user_session_display.jsp" flush="true"/>
	</div>

	<div class="content" id="content">

		<div class="con">
			<p class="con_title">${content.getContentTitle() }</p>
			<span class="con_username">楼主： ${user1.getUserAlias() }</span>
			<hr />
			<p class="con_msg">${content.getThematicContent() }</p>
			<p class="con_date">
				<fmt:formatDate pattern="yyyy年MM月dd日 HH:mm:ss"
					value="${content.getContentCreatedate()}" />
			</p>
		</div>

		<c:if test="${empty list}">
			<script>
				layer.msg($("title").text() + '还没有回帖呢，要不回一个？');
			</script>
		</c:if>
		<c:if test="${!empty list}">
			<c:forEach items="${list }" var="temp">
				<div class="item">
					<p class="item_msg">
						<c:out value="${temp.RepliesContent }"></c:out>
					</p>
					<hr />
					<p class="item_username">
						来自：
						<c:out value="${temp.name }"></c:out>
					</p>
					<p class="item_date">
						<fmt:formatDate pattern="yyyy年MM月dd日 HH:mm:ss"
							value="${temp.RepliesDate}" />
					</p>
				</div>
			</c:forEach>
		</c:if>

		<div id="edits">
			<input type="hidden" id="contentId" value="${content.getContentId()}" />
  			<input type="hidden" id="username" value="${sessionScope.username}" />
			<textarea name="edit" id="edit" ></textarea>
			<button class="layui-btn layui-btn layui-btn-fluid" id="btn1">发表您的回复</button>
		</div>

	</div>
	<div id="footer" class="footer">
		<hr>
		<div>2018 © mcandroid.cn</div>
	</div>
</body>
</html>