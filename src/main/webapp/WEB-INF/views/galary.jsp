<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="./header.jsp"%>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/news.css" />

<!-- Custom CSS -->
<link
	href="${pageContext.request.contextPath}/resources/css/thumbnail-gallery.css"
	rel="stylesheet">
<!-- Page Content -->
<div class="container">

	<div class="row">

		<div class="col-lg-12">
			<h1 class="page-header">${titleHeader}</h1>
		</div>
		<c:forEach items="${galaryList}" var="galary">

			<div class="col-lg-3 col-md-4 col-xs-6 thumb">
				<a class="thumbnail" href="${galary.imageGallery}"> <img
					class="img-responsive" src="${galary.imageGallery}"
					alt="${galary.nameGallery}" />
				</a>
			</div>

		</c:forEach>
	</div>
</div>




<%@ include file="./footer.jsp"%>