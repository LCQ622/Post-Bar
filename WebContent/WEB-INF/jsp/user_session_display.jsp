<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${sessionScope.username !=null }">
	<a href="logout" class="alink">登出</a>
	<a href="#" class="alink" id="login">您好，${sessionScope.alias }</a>
</c:if>
<c:if test="${sessionScope.username ==null}">
	<a href="register" target="_blank" class="alink" id="reg">注册</a>
	<a href="login" class="alink" id="login">登录</a>
</c:if>