<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="./header.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/melkList.css" />

<section class="well-sm" id="search">
	<section id="result-cont" class="col-md-10 col-xs-11 col-xs-offset-1">

		<h1>دانستنیهای ملک</h1>
		
		
		

		<c:forEach items="${listKnow}" var="Know">
			<article class="result">
				<div class="result-wrapper">
					<div class="result-inner">

						<fmt:parseNumber type="number" value="${Know.idKnow}"
							var="myIdKnow" />
						<div class="result-props">
							<div>
								<a href="<c:url value="/melk/${myIdKnow}/${Know.URL}"/>"><h2>${Know.subjectKnow}</h2></a>
								${Know.knowBodyNOhtml} <a
									href="<c:url value="/melk/${myIdKnow}/${Know.URL}"/>">بیشتر...</a>
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
<div class="clearfix"></div>
<%@ include file="./footer.jsp"%>