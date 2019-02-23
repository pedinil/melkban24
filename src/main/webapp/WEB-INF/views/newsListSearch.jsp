<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="./header.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/newsList.css" />

<section class="well-sm" id="search">
	<section id="result-cont" class="col-md-10 col-xs-11 col-xs-offset-1">

		<h1>اخبار مسکن</h1>

		<c:forEach items="${listNewsLast}" var="news">
			<article class="result">

				<div class="search grbwb">اخبار</div>
				<div class="result-wrapper">
					<div class="result-inner">

						<fmt:parseNumber type="number" value="${news.idNews}"
							var="myNewsid" />

						<a href="<c:url value="/news/${myNewsid}/${news.URL}"/>"
							class="img col-sm-12 col-md-5 nopr nopl"> <img
							src="${news.imageNews}" alt="${news.subjectNews}" /> <span
							class="triangle"> جزییات اخبار <span class="pgram"></span>
						</span>
						</a>
						<div class="result-props col-md-7 col-sm-12 col-md-offset-5">
							<div>
								<a href="<c:url value="/news/${myNewsid}/${news.URL}"/>"><h2>${news.subjectNews}</h2></a>
								${news.newBodyNOhtml}
							</div>


							<div class="clearfix"></div>
						</div>

						<div class="clearfix"></div>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>

			</article>

		</c:forEach>
	</section>

	
	
	
</section>

<div class="clearfix"></div>
<%@ include file="./footer.jsp"%>