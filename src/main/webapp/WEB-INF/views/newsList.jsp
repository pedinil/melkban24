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
		
		<c:if test="${currentIndex==0}">
			<div class="row">
						
						<div class="col-xs-11">
							<input type="text" id="pac-input" autocomplete="off"
								lang="fa" class="form-control input-sm binput"
								name="district_title" value="" style="height: 35px" />

						</div>
						
						<div class="col-xs-1">
							<i class="fa fa-search fa-2x" id="searchClick"></i>
						</div>
						
					</div>
		</c:if>
		

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

	<div id="pager" class="col-lg-8 col-lg-offset-2 col-xs-12">

		<c:if test="${currentIndex==0}">
			<c:url var="prevUrl" value="news/page-1" />
			<c:url var="nextUrl" value="news/page-2" />
		</c:if>

		<c:if test="${currentIndex>0}">
			<c:url var="prevUrl" value="./page-${currentIndex - 1}" />
			
			<c:if test="${currentIndex==1}">
				<c:url var="prevUrl" value="./page-${currentIndex}" />
			</c:if>
			
			<c:url var="nextUrl" value="./page-${currentIndex + 1}" />
		</c:if>


		<a href="${prevUrl}" class="back control"> <i
			class="fa fa-chevron-right"></i>
		</a>

		<ul>

			<c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
				<c:if test="${currentIndex==0}">
					<c:url var="pageUrl" value="news/page-${i}" />
				</c:if>

				<c:if test="${currentIndex>0}">
					<c:url var="pageUrl" value="./page-${i}" />
				</c:if>

				<c:choose>
					<c:when test="${i == currentIndex}">
						<li><a href="${pageUrl}"> <i class="fa fa-circle active"></i>
								<span class="num"> ${i} </span>
						</a></li>
					</c:when>

					<c:otherwise>
						<li><a href="${pageUrl}"> <i class="fa fa-circle"></i> <span
								class="num"> ${i} </span>
						</a></li>
					</c:otherwise>

				</c:choose>

			</c:forEach>


		</ul>
	
		<a href="${nextUrl}" class="next control"> <i
			class="fa fa-chevron-left"></i>
		</a>

		
	</div>
</section>

<div class="clearfix"></div>

<script>

$(document).ready(function(){
	  
	  $('#pac-input').keypress(function (e) {
			if (e.keyCode == 13) {
	        
				jsAction();
				
			}
		});
	  
	  $('#searchClick').click(function(){
		  jsAction();
		});
	  
	  function jsAction() {
		  var str =  $('#pac-input').val().trim();
			var res = str.replace(/ /g, '-');
	     
			location.href ="./newssearch/"+res;
		  };
	  
	});

	
</script>

<%@ include file="./footer.jsp"%>