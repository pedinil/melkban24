<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="./header.jsp"%>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/news.css" />

<div id="main-wrapper" class="col-xs-12">
	<article id="news-detail" class="se-bg">
		<header id="news-header">
			<h1>
				<i class="fa"></i> ${headerTitle}
			</h1>
		</header>
		<div id="news-body">${dynamic.body}</div>
		<div class="clearfix"></div>
	</article>

	<div class="clearfix"></div>
</div>




<%@ include file="./footer.jsp"%>