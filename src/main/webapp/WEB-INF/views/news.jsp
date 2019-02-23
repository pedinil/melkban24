<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="./header.jsp"%>


<fmt:parseNumber var="varIdNewsUrl" type="number"
						value="${news.idNews}" />
						
<link rel="canonical" href="http://melkban24.ir/news/${varIdNewsUrl}/${news.URL}" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/news.css?version2" />

<div id="main-wrapper" class="col-xs-12">
	<article id="news-detail" class="se-bg">
		<header id="news-header">
			<h1>
				<i class="fa fa-bookmark icon"></i> ${news.subjectNews}
			</h1>
		</header>

		<figure id="img-index"
			class="img-thumbnail col-lg-3 col-md-4 col-sm-6 col-xs-12">
			<img src="${news.imageNews}" width="300" alt="${news.subjectNews}"
				title="${news.subjectNews}" />
		</figure>

		<div id="news-body">${news.bodyNews}</div>

		<footer>
			<time datetime="2016-09-14 00:00">
				تاریخ درج : <span class="persian jalali">${news.dateNews}</span>
			</time>
		</footer>
		
		<div id="share" class="col-xs-10 col-xs-offset-1 l">
	
		<a class="share_telegram" title="اشتراک گذاری در تلگرام"
			href="https://telegram.me/share/url?url=http://melkban24.ir/news/${varIdNewsUrl}/${news.URL}" target="_blank">
		 <i class="fa fa-send"></i>
		</a> 
		<a class="share_googleplus" title="اشتراک گذاری در اینستاگرام"
			href="https://plus.google.com/share?url=http://melkban24.ir/news/${varIdNewsUrl}/${news.URL}" target="_blank"> 
			<i class="fa fa-google-plus"></i>
		</a> 
		<a class="share_facebook" title="اشتراک گذاری در فیسبوک"
			href="https://www.facebook.com/sharer.php?u=http://melkban24.ir/news/${varIdNewsUrl}/${news.URL}" target="_blank"> 
			<i class="fa fa-facebook"></i>
		</a>
		<a class="share_twitter" title="اشتراک گذاری در تویتر"
			href="http://www.twitter.com/share?url=http://melkban24.ir/news/${varIdNewsUrl}/${news.URL}" target="_blank"> 
			<i class="fa fa-twitter"></i>
		</a>
		
	</div>

	<div class="clearfix"></div>
		
		
	
	</article>



	<section id="latest-news">
		<header>
			<h2>
				<i class="fa fa-map-marker"></i> آخرین اخبار و رویدادهای بازار مسکن
			</h2>
		</header>

		<c:forEach items="${listNewsLast}" var="newLast">

			<fmt:parseNumber var="varIdNews" type="number"
				value="${newLast.idNews}" />

			<a href="<c:url value="/news/${varIdNews}/${newLast.URL}" />"
				class="col-md-4 col-xs-12 hvr-float-shadow">
				<div class="grbwb grlbl">
					<div class="title">${newLast.subjectNews}</div>
				</div>
				<div class="img"
					style="background-image:url('${newLast.imageNews}')">
					<span class="triangle"> جزئیات خبر <span class="pgram"></span>
					</span>
				</div>
			</a>

		</c:forEach>
		<div class="clearfix"></div>
	</section>
</div>


<script
	src="${pageContext.request.contextPath}/resources/js/jquery.scrollTo.min.js"></script>


<%@ include file="./footer.jsp"%>