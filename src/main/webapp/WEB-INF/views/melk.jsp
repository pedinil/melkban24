<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="./header.jsp"%>

<fmt:parseNumber var="varIdknowUrl" type="number"
						value="${know.idKnow}" />
				
	
						
<link rel="canonical" href="http://melkban24.ir/melk/${varIdknowUrl}/${know.URL}" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/melk.css?version9" />

<div id="main-wrapper" class="col-xs-12">
	<article id="news-detail" class="se-bg">
		<header id="news-header">
			<h1>
				<i class="fa fa-bookmark icon"></i> ${know.subjectKnow}
			</h1>
		</header>
		
		<div id="news-body">${know.bodyKnow}</div>

		<footer>
			<time datetime="2016-09-14 00:00">
				تعداد بازدید : <span class="persian jalali"> <fmt:parseNumber
						type="number" value="${know.countView}" /></span>
			</time>
		</footer>

		<div class="clearfix"></div>
		

	
	</article>
	
	

	<div class="clearfix"></div>

	
	
	<div id="share" class="col-xs-10 col-xs-offset-1 l">
	
		<a class="share_telegram" title="اشتراک گذاری در تلگرام"
			href="https://telegram.me/share/url?url=http://melkban24.ir/melk/${varIdknowUrl}/${know.URL}" target="_blank">
		 <i class="fa fa-send"></i>
		</a> 
		<a class="share_googleplus" title="اشتراک گذاری در اینستاگرام"
			href="https://plus.google.com/share?url=http://melkban24.ir/melk/${varIdknowUrl}/${know.URL}" target="_blank"> 
			<i class="fa fa-google-plus"></i>
		</a> 
		<a class="share_facebook" title="اشتراک گذاری در فیسبوک"
			href="https://www.facebook.com/sharer.php?u=http://melkban24.ir/melk/${varIdknowUrl}/${know.URL}" target="_blank"> 
			<i class="fa fa-facebook"></i>
		</a>
		<a class="share_twitter" title="اشتراک گذاری در تویتر"
			href="http://www.twitter.com/share?url=http://melkban24.ir/melk/${varIdknowUrl}/${know.URL}" target="_blank"> 
			<i class="fa fa-twitter"></i>
		</a>
		
	</div>

	<div id="do-you-know" class="col-xs-12">
		<div class="center well-sm">مطالب مرتبط با این مقاله</div>
		<div class="col-md-6 col-md-offset-3 col-xs-12">
			<div class="red-border well-sm">

				<c:forEach items="${listKnowRandom}" var="KnowRand">




					<fmt:parseNumber var="varIdknow" type="number"
						value="${KnowRand.idKnow}" />
					<a href="<c:url value="/melk/${varIdknow}/${KnowRand.URL}"/>">
						${KnowRand.subjectKnow} </a>
					<br />
					<br />

				</c:forEach>

			</div>

		</div>

	
	
	</div>


	<div class="clearfix"></div>




	<section id="related" class="col-xs-12">
		<h3 class="col-xs-12">
			<i class="fa fa-map-marker red"></i> ملک بان 24
		</h3>
		<div class="col-md-8 col-md-offset-2 col-xs-12">


			<c:forEach items="${listSaleCase}" var="caseSale">

				<div
					class="m-cont col-md-4 col-sm-5 col-sm-offset-1 col-xs-8 col-md-offset-0 col-xs-offset-2 hvr-grow">

					<fmt:parseNumber var="idcaseCn" type="number"
						value="${caseSale.idCase}" />

					<div class="cont">
						<a href="<c:url value="/melkoffer/${idcaseCn}"/>" class="img"
							style="background-image:url('${caseSale.thPic1}');"> </a>
						<footer>
							<ul>
								<li><a href="<c:url value="/melkoffer/${idcaseCn}"/>">
										<i class="icon i-place"></i> ${caseSale.state.nameState} -
										${caseSale.city.nameCity}
								</a></li>
								<li><a href="<c:url value="/melkoffer/${idcaseCn}"/>">
										<i class="icon i-pip"></i> <fmt:parseNumber type="number"
											value="${caseSale.metraj}" />
								</a></li>
								<li><a href="<c:url value="/melkoffer/${idcaseCn}"/>">
										<i class="icon i-hand"></i> <fmt:parseNumber type="number"
											value="${caseSale.countBed}" />
								</a></li>
								<li><a href="<c:url value="/melkoffer/${idcaseCn}"/>">
										<i class="icon i-money"></i> <fmt:formatNumber type="number"
											maxIntegerDigits="20" value="${caseSale.price1}" />
								</a></li>
							</ul>
						</footer>
					</div>
				</div>

			</c:forEach>



			<div class="clearfix"></div>
		</div>
	</section>


</div>

<%@ include file="./footer.jsp"%>