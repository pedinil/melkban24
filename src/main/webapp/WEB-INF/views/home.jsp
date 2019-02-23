<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="./headerHome.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/home.css" />
<section id="main-slider" class="segment">
	<div class="p pr col-sm-6 col-xs-12"
		style="background-image: url('${pageContext.request.contextPath}/resources/img/parts/p-map.jpg')"></div>
	<div class="p pl hidden-xs col-sm-6 col-xs-12"
		style="background-image: url('${pageContext.request.contextPath}/resources/img/parts/p1-1.jpg')"></div>
	<div class="p pr col-sm-6 col-xs-12 form">
		<form id="form-search" class="search" action="." method="POST">
			<header>
				<h2>
					<i class="fa fa-map-marker"></i> جست و جوی ملک
				</h2>
			</header>
			<div class="row">
				<label class="col-md-3 col-md-offset-2 col-xs-5 l">استان</label>

				<div class="select-wrapper col-md-4 col-xs-5">
					<select id="province" name="province" class="form-control">
						<c:forEach items="${listState}" var="state">
							<option value="${state.idState}">${state.nameState}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="row">
				<label class="col-md-3 col-md-offset-2 col-xs-5 l">شهر</label>

				<div class="select-wrapper col-md-4 col-xs-5">
					<select id="city" name="city" class="form-control">
						<option selected='selected' value='0'>در ميان همه بگرد</option>
					</select>
				</div>
			</div>
			<div class="row">
				<label class="col-md-3 col-md-offset-2 col-xs-5 l">منطقه</label>

				<div class="select-wrapper col-md-4 col-xs-5">
					<select id="area" name="area" class="form-control">
						<option selected='selected' value='0'>در ميان همه بگرد</option>
					</select>
				</div>
			</div>
			<div class="row">
				<label class="col-md-3 col-md-offset-2 col-xs-5 l">محدوده</label>

				<div class="select-wrapper col-md-4 col-xs-5">
					<select id="zone" name="zone" class="form-control">
						<option selected='selected' value='0'>در ميان همه بگرد</option>
					</select>
				</div>
			</div>
			<div class="row">
				<label class="col-md-3 col-md-offset-2 col-xs-5 l">نوع ملک</label>

				<div class="select-wrapper col-md-4 col-xs-5">
					<select id="otype" name="otype" class="form-control">
						<option selected='selected' value='0'>در ميان همه بگرد</option>
						<c:forEach items="${listkindCase}" var="kindCase">
							<option value="${kindCase.idKindCase}">${kindCase.nameKindCase}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="row">
				<label class="col-md-3 col-md-offset-2 col-xs-5 l">نوع
					معامله</label>

				<div class="select-wrapper col-md-4 col-xs-5">
					<select id="mtype" name="mtype" class="form-control">
						<c:forEach items="${listkindRequest}" var="kindRequest">
							<option value="${kindRequest.idKindRequest}">${kindRequest.nameKindRequest}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="row center">
				<div
					class="col-md-4 col-md-offset-5 col-xs-5 col-xs-offset-5 center">
					<button type="submit" class="icon submit hvr-bounce-in"
						title="جست و جوی ملک"></button>
				</div>
			</div>
		</form>
		<form id="form-search-code" class="search" action="." method="POST">
			<header>
				<h2>
					<i class="fa fa-map-marker"></i> جست و جوی با کد ملک
				</h2>
			</header>
			<div class="row">
				<label class="col-md-3 col-md-offset-2 col-xs-5 l">کد ملک</label>

				<div class="input-wrapper col-md-4 col-xs-5">
					<input type="text" id="code" name="code" class="form-control" />
				</div>
			</div>
			<div class="row center">

				<div
					class="col-md-4 col-md-offset-5 col-xs-5 col-xs-offset-5 center">
					<button type="submit" class="icon submit hvr-bounce-in"
						title="جست و جوی با کد ملک"></button>
				</div>

			</div>
		</form>
	</div>
	<div style="clear: both"></div>
</section>


<section id="facts" class="segment sb">
	<div class="p pr col-sm-6 col-xs-12"
		style="background-image: url('${pageContext.request.contextPath}/resources/img/parts/p4.jpg')"></div>
	<div class="p pl form col-sm-6 col-xs-12">
		<section id="news">
			<header>
				<h2>
					<i class="fa fa-map-marker"></i> اخبار مسکن
				</h2>

			</header>
			<ul>

				<c:set var="count" value="0" scope="page" />
				<c:forEach items="${listNews}" var="news">
					<fmt:parseNumber var="varIdNews" type="number"
						value="${news.idNews}" />
					<c:if test="${count % 2==0}">
						<li class="l"><a href="./news/${varIdNews}/${news.URL}"
							class="hvr-float-shadow"> <img class="img"
								src="${news.thImagenews}" alt=" ${news.subjectNews}" />
								<div class="label">${news.subjectNews}</div>
						</a></li>
					</c:if>
					<c:if test="${count % 2 !=0}">
						<li class="r"><a href="./news/${varIdNews}/${news.URL}"
							class="hvr-float-shadow"> <img class="img"
								src="${news.thImagenews}" alt=" ${news.subjectNews}" />
								<div class="label">${news.subjectNews}</div>
						</a></li>
					</c:if>
					<c:set var="count" value="${count + 1}" scope="page" />
				</c:forEach>
			</ul>
		</section>

		<section id="know">
			<header>
				<h2>
					<i class="fa fa-map-marker"></i> دانستنی های ملک و مسکن
				</h2>
			</header>
			<ul>
				<c:set var="count" value="0" scope="page" />
				<c:forEach items="${listKnow}" var="know">
					<fmt:parseNumber var="varIdknow" type="number"
						value="${know.idKnow}" />
					<c:if test="${count % 2==0}">
						<li class="l"><a href="./melk/${varIdknow}/${know.URL}">
								${know.subjectKnow} </a></li>
					</c:if>
					<c:if test="${count % 2 !=0}">
						<li class="r"><a href="./melk/${varIdknow}/${know.URL}">
								${know.subjectKnow} </a></li>
					</c:if>
					<c:set var="count" value="${count + 1}" scope="page" />
				</c:forEach>
			</ul>
		</section>

	</div>
</section>



<section id="special-offer" class="segment sb section">
	<header>
		<h2>
			<i class="fa fa-map-marker"></i> فروش ویژه
		</h2>
	</header>
	<div class="clearfix"></div>


	<div class="col-md-10 col-md-offset-1 col-xs-12">

		<c:forEach items="${listSaleCase}" var="caseSale">

			<div
				class="m-cont col-md-4 col-sm-5 col-sm-offset-1 col-xs-8 col-md-offset-0 col-xs-offset-2 hvr-grow">
				<div class="cont">

					<fmt:parseNumber var="idcaseCn" type="number"
						value="${caseSale.idCase}" />

					<a class="img" href="./melkoffer/${idcaseCn}"> <img
						class="w100" src="${caseSale.thPic1}"
						alt="خرید خانه"
						title="خرید خانه" />
					</a>
					<footer>
						<ul>
							<li><a href="./melkoffer/${idcaseCn}"> <i
									class="icon i-place"></i> ${caseSale.state.nameState} -
									${caseSale.city.nameCity}
							</a></li>
							<li><a href="./melkoffer/${idcaseCn}"> <i
									class="icon i-pip"></i> <fmt:parseNumber type="number"
										value="${caseSale.metraj}" />
							</a></li>
							<li><a href="./melkoffer/${idcaseCn}"> <i
									class="icon i-hand"></i> مشاهده جزئیات
							</a></li>
							<li><a href="./melkoffer/${idcaseCn}"> <i
									class="icon i-money"></i> <fmt:formatNumber type="number"
										maxIntegerDigits="20" value="${caseSale.price1}" />
							</a></li>
						</ul>
					</footer>
				</div>
			</div>

		</c:forEach>




	</div>

</section>



<section id="step-desc" class="segment sb section ">
	<div class="p pr hidden-xs col-sm-6 col-xs-12"
		style="background-image: url('${pageContext.request.contextPath}/resources/img/parts/p2.jpg')"></div>
	<div class="p pl col-sm-6 col-xs-12 form">
		<div id="side-left">
			<header>
				<h2>
					<i class="fa fa-map-marker"></i> سپردن ملک
				</h2>
			</header>
			<article>قبل از سپردن فایل ملک موردنظر خود لطفاً قسمت
				راهنمای سایت بخش قوانین و مقررات سایت را مطالعه نمایید</article>

			<ul id="side-menu">

				<li class="l"> <label><a href="<c:url value="/addfile" />">
							<span class="si_ci"> <i class="icon i-pos hvr-bounce-in"></i>
						</span> موقعیت ملک
						</a>
					</label>
				</li>

				<li class="r"><label>
							<a href="<c:url value="/addfile" />"> <span class="si_ci"> <i
								class="icon i-identify hvr-bounce-in"></i>
						</span>
						مشخصات ملک</a>
					</label> </li>

				<li class="l"> <label><a href="<c:url value="/addfile" />">
							<span class="si_ci"> <i
								class="icon i-identify-o hvr-bounce-in"></i>
						</span> مشخصات مالک</a>
					</label>
				</li>

				<li class="r"> <label><a href="<c:url value="/addfile" />">
							<span class="si_ci"> <i class="icon i-m-img hvr-bounce-in"></i>
						</span> تصویر ملک</a>
					</label>
				</li>

			</ul>
		</div>
	</div>
</section>


<section id="social-mobile" class="segment sb">
	<div id="social-banner"></div>
	<img
		src="${pageContext.request.contextPath}/resources/img/parts/p5-social.jpg"
		class="col-md-6 hidden-xs hidden-sm nopr nopl" alt="شبکه های اجتماعی" />
	<img
		src="${pageContext.request.contextPath}/resources/img/parts/p5-hand.png"
		class="col-md-6 hidden-xs hidden-sm nopr nopl hand"
		alt="شبکه های اجتماعی" /> <img
		src="${pageContext.request.contextPath}/resources/img/parts/p5-app.jpg"
		class="col-md-6 col-xs-12 nopr nopl" alt="اپلیکیشن" />


	<div class="app-cont">
		<a class="icon-cont playstore"
			href="https://play.google.com/store/apps/details?id=air.com.mteamapps.Melkban24"
			title="Google Play"> <i class="icon"></i>
		</a> <a class="icon-cont iphone" href="https://appsto.re/us/iBEHdb.i"
			title="Apple Store"> <i class="icon"></i>
		</a> <a class="icon-cont android"
			href="https://play.google.com/store/apps/details?id=air.com.mteamapps.Melkban24"
			title="android Store"> <i class="icon"></i>
		</a> <a class="icon-cont a hvr-grow" href="https://appsto.re/us/iBEHdb.i"
			title="Apple Store"> <i class="icon"></i>
		</a>
	</div>

	<div class="social-cont hidden-xs hidden-sm">
		<a class="icon-cont instagram hvr-grow"
			href="http://www.instagram.com/melkban24.ir" title="Instagram"> <img
			src="${pageContext.request.contextPath}/resources/img/social/instagram.png"
			alt="Instagram" />
		</a> <a class="icon-cont facebook hvr-grow"
			href="https://www.facebook.com/melkban24.ir" title="Facebook"> <img
			src="${pageContext.request.contextPath}/resources/img/social/facebook.png"
			alt="Facebook" />
		</a> <a class="icon-cont telegram hvr-grow"
			href="https://telegram.me/melkban24" title="Telegram"> <img
			src="${pageContext.request.contextPath}/resources/img/social/telegram.png"
			alt="telegram" />
		</a> <a class="icon-cont wifi hvr-grow" href="#" title=""> <img
			src="${pageContext.request.contextPath}/resources/img/social/wifi.png"
			alt="wifi" />
		</a> <a class="icon-cont google-plus hvr-grow r2"
			href="https://plus.google.com/people/find" title="Google Plus"> <img
			src="${pageContext.request.contextPath}/resources/img/social/google-plus.png"
			alt="google-plus" />
		</a> <a class="icon-cont linkedin hvr-grow r2"
			href="https://www.linkedin.com/in/melkban24?trk=hp-identity-headline"
			title="Linkedin"> <img
			src="${pageContext.request.contextPath}/resources/img/social/linkedin.png"
			alt="linkedin" />
		</a> <a class="icon-cont aparat hvr-grow r2"
			href="http://aparat.com/melkban24" title="Aparat"> <img
			src="${pageContext.request.contextPath}/resources/img/social/aparat.png"
			alt="aparat" />
		</a> <a class="icon-cont twitter hvr-grow r2" href="https://twitter.com/"
			title="Twitter"> <img
			src="${pageContext.request.contextPath}/resources/img/social/twitter.png"
			alt="twitter" />
		</a>
	</div>
</section>





<section class="segment section sr">
	<section id="why" class="sb col-md-12 col-xs-12">
		<div class="col-md-8 col-md-offset-2 col-xs-10 col-xs-offset-1">
			<header class="center">
				<h2>چرا ملک بان ۲۴ ؟</h2>
			</header>
			<div class="detail">گروه ساختمانی DPD بر این باور است که تا چند
				سال آینده سرعت زندگی در شهرهای بزرگ مــــردم را وادار به صرفه جویی
				در زمـان و انرژی خود برای انجام معاملات ملکی (خرید خانه، اجاره
				آپارتمان، خرید آپارتمان، خرید و فروش مسکن، اجاره مسکن، خرید ویلا،
				خرید و فروش ملک کلنگی و ...) خواهد کـرد و در این راستا سعی کرده است
				تا با همکاری دوجــــــــانبه با مشاورین املاک بـرتر در شهرهای بــزرگ
				کشور این امــــــکان را برای متقاضیان ملک فراهم آورد تا هرچه سریعتر
				و بهتر تقاضای خود را پاســـــخ گـــــویند، ملک بان24 با ایجاد فضایی
				که در آن امکان ارائه کامل مشخصات ملک های موجود به همراه فایل تصویری
				آنها، سعی کرده که هم عرضه کنندگان ملک را سامان داده و هم تقاضای
				(خرید خانه، اجاره آپارتمان، خرید آپارتمان، خرید و فروش مسکن، اجاره
				مسکن ،خرید ویلا، خرید و فروش ملک کلنگی و ...) را به بهـــــترین نحو
				سازماندهی کند.</div>
		</div>
	</section>
</section>


<section id="other" class="segment sb section">
	<div id="enamad" class="col-md-1 col-xs-12">
		<img src="${pageContext.request.contextPath}/resources/img/enamad.png"
			alt="نماد اعتماد الکترونیکی" />
	</div>

	<section id="other-cont" class="col-md-11 col-xs-12">
		<section id="other_p" class="col-md-4 col-xs-12">
			<header>
				<h3>املاک سایر استانها</h3>
			</header>
			<ul>
				<li><a title="خانه مشهد" href="<c:url  value="./melksearch/خرید-خانه-خراسان+رضوی-مشهد"/>">خرید
						خانه مشهد</a></li>
				<li><a title="رهن و اجاره خانه خراسان رضوی مشهد" href="<c:url value="./melksearch/رهن+و+اجاره-خانه-خراسان+رضوی-مشهد"/>">رهن
						و اجاره آپارتمان مشهد</a></li>
				<li><a title="خرید خانه البرز کرج" href="<c:url value="./melksearch/خرید-خانه-البرز-کرج"/>">خرید
						خانه کرج</a></li>
				<li><a title="رهن و اجاره خانه تهران" href="<c:url value="./melksearch/رهن+و+اجاره-خانه-تهران"/>">رهن
						و اجاره آپارتمان کرج</a></li>
				<li><a title="خرید خانه فارس شیراز" href="<c:url value="./melksearch/خرید-خانه-فارس-شیراز"/>">خرید
						خانه شیراز</a></li>
				<li><a
					href="<c:url value="./melksearch/رهن+و+اجاره-خانه-فارس-شیراز"/>">رهن
						و اجاره آپارتمان شیراز</a></li>
				<li><a
					href="<c:url value="./melksearch/خرید-خانه-مازندران-فریدون+کنار"/>">خرید
						ویلا مازندران- فریدون کنار</a></li>
				<li><a
					href="<c:url value="./melksearch/خرید-خانه-مازندران-محمود+آباد"/>">خرید
						ویلا مازندران - محمودآباد</a></li>
				<li><a href="<c:url value="./melksearch/خرید-خانه-اصفهان-"/>">
						خرید خانه اصفهان</a></li>
				<li><a
					href="<c:url value="./melksearch/رهن+و+اجاره-خانه-اصفهان"/>">رهن
						و اجاره آپارتمان اصفهان</a></li>
				<li><a
					href="<c:url value="./melksearch/خرید-خانه-مازندران-محمود+آباد"/>">خرید
						خانه رشت</a></li>
				<li><a
					href="<c:url value="./melksearch/خرید-خانه-مازندران-محمود+آباد"/>">رهن
						و اجاره آپارتمان رشت</a></li>
				<li><a
					href="<c:url value="./melksearch/خرید-خانه-آذربایجان+شرقی-تبریز"/>">خرید
						خانه تبریز</a></li>
				<li><a
					href="<c:url value="./melksearch/رهن+و+اجاره-خانه-آذربایجان+شرقی-تبریز"/>">رهن
						و اجاره آپارتمان تبریز</a></li>
				<li><a href="<c:url value="./melksearch/خرید-خانه-کرمانشاه"/>">خرید
						خانه کرمانشاه</a></li>
				<li><a
					href="<c:url value="./melksearch/رهن+و+اجاره-خانه-کرمانشاه"/>">رهن
						و اجاره آپارتمان کرمانشاه</a></li>
				<li><a href="<c:url value="./melksearch/خرید-خانه-یزد"/>">خرید
						خانه یزد</a></li>
				<li><a
					href="<c:url value="./melksearch/رهن+و+اجاره-خانه-یزد"/>">رهن و
						اجاره آپارتمان یزد</a></li>
			</ul>
		</section>

		<section id="tehran_sale" class="col-md-4 col-xs-12">
			<header>
				<h3>خرید خانه در تهران</h3>
			</header>
			<ul>
				<li><a
					href="<c:url value="./melksearch/خرید-خانه-تهران-تهران-منطقه+دو-سعادت+آباد"/>">
						خرید خانه سعادت آباد</a></li>
				<li><a
					href="<c:url value="./melksearch/خرید-خانه-تهران-تهران-منطقه+دو-شهرک+غرب"/>">
						خرید خانه شهرک غرب</a></li>
				<li><a
					href="<c:url value="./melksearch/خرید-خانه-تهران-تهران-منطقه+پنج-پونک"/>">
						خرید خانه پونک سردار جنگل</a></li>
				<li><a
					href="<c:url value="./melksearch/خرید-خانه-تهران-تهران-منطقه+پنج-شهران"/>">
						خرید خانه آریاشهر- شهران</a></li>
				<li><a
					href="<c:url value="./melksearch/خرید-خانه-تهران-تهران-منطقه+دو-گیشا"/>">
						خرید خانه گیشا</a></li>
				<li><a
					href="<c:url value="./melksearch/خرید-خانه-تهران-تهران-منطقه+یك-نیاوران" />">
						خرید خانه نیاوران</a></li>
				<li><a
					href="<c:url value="./melksearch/خرید-خانه-تهران-تهران-منطقه+یك-ولنجک" />">
						خرید خانه ولنجک</a></li>
				<li><a
					href="<c:url value="./melksearch/خرید-خانه-تهران-تهران-منطقه+شش-شریعتی" />">
						خرید خانه شریعتی</a></li>
				<li><a
					href="<c:url value="./melksearch/خرید-خانه-تهران-تهران-منطقه+سه-ظفر" />">
						خرید خانه ظفر</a></li>
				<li><a
					href="<c:url value="./melksearch/خرید-خانه-تهران-تهران-منطقه+سه-میرداماد" />">
						خرید خانه میرداماد</a></li>
				<li><a
					href="<c:url value="./melksearch/خرید-خانه-تهران-تهران-منطقه+چهار-تهرانپارس" />">
						خرید خانه تهرانپارس</a></li>
				<li><a
					href="<c:url value="./melksearch/خرید-خانه-تهران-تهران-منطقه+سه-ونک" />">
						خرید خانه ونک ملاصدرا</a></li>
				<li><a
					href="<c:url value="./melksearch/خرید-سند+اداري-تهران-تهران-منطقه+هفت-عباس+آباد" />">
						خرید ملک اداری عباس آباد</a></li>
				<li><a
					href="<c:url value="./melksearch/خرید-خانه-تهران-تهران-منطقه+سه-سیدخندان" />">
						خرید خانه سیدخندان</a></li>
			</ul>
		</section>

		<section id="tehran_rent" class="col-md-4 col-xs-12">
			<header>
				<h3>رهن واجاره آپارتمان در تهران</h3>
			</header>
			<ul>
				<li><a
					href="<c:url value="./melksearch/رهن+و+اجاره%20-خانه-تهران-تهران-منطقه+دو-سعادت+آباد" />">
						رهن و اجاره آپارتمان سعادت آباد</a></li>
				<li><a
					href="<c:url value="./melksearch/رهن+و+اجار-خانه-تهران-تهران-منطقه+دو-شهرک+غرب" />">
						رهن و اجاره آپارتمان شهرک غرب</a></li>
				<li><a
					href="<c:url value="./melksearch/رهن+و+اجاره-خانه-تهران-تهران-منطقه+پنج-پونک" />">
						رهن و اجاره آپارتمان پونک سردار جنگل</a></li>
				<li><a
					href="<c:url value="./melksearch/رهن+و+اجاره-خانه-تهران-تهران-منطقه+پنج-شهران" />">
						رهن و اجاره آپارتمان آریاشهر- شهران</a></li>
				<li><a
					href="<c:url value="./melksearch/رهن+و+اجاره-خانه-تهران-تهران-منطقه+دو-گیش" />">
						رهن و اجاره آپارتمان گیشا</a></li>
				<li><a
					href="<c:url value="./melksearch/رهن+و+اجاره-تهران-تهران-منطقه+یك-نیاوران" />">
						رهن و اجاره آپارتمان نیاوران</a></li>
				<li><a
					href="<c:url value="./melksearch/رهن+و+اجاره-تهران-تهران-منطقه+یك-ولنجک" />">
						رهن و اجاره آپارتمان ولنجک</a></li>
				<li><a
					href="<c:url value="./melksearch/رهن+و+اجاره-خانه-تهران-تهران-منطقه+یك-فرمانیه" />">
						رهن و اجاره آپارتمان فرمانیه</a></li>
				<li><a
					href="<c:url value="./melksearch/رهن+و+اجاره-خانه-تهران-تهران-منطقه+یك-قیطریه" />">
						رهن و اجاره آپارتمان قیطریه</a></li>
				<li><a
					href="<c:url value="./melksearch/رهن+و+اجاره-خانه-تهران-تهران-منطقه+شش-شریعتی" />">
						رهن و اجاره آپارتمان شریعتی</a></li>
				<li><a
					href="<c:url value="./melksearch/رهن+و+اجاره-خانه-تهران-تهران-منطقه+سه-ظفر" />">
						رهن و اجاره آپارتمان ظفر</a></li>
				<li><a
					href="<c:url value="./melksearch/رهن+و+اجاره-خانه-تهران-تهران-منطقه+سه-میرداماد" />">
						رهن و اجاره آپارتمان میرداماد</a></li>
				<li><a
					href="<c:url value="./melksearch/رهن+و+اجاره-خانه-تهران-تهران-منطقه+چهار-تهرانپارس" />">رهن
						و اجاره آپارتمان تهرانپارس</a></li>
				<li><a
					href="<c:url value="./melksearch/رهن+و+اجاره-خانه-تهران-تهران-منطقه+سه-ونک" />">رهن
						و اجاره آپارتمان ونک ملاصدرا</a></li>
				<li><a
					href="<c:url value="./melksearch/رهن+و+اجاره-خانه-تهران-تهران-منطقه+هفت-عباس+آباد" />">اجاره
						ملک اداری عباس آباد</a></li>
				<li><a
					href="<c:url value="./melksearch/رهن+و+اجاره-خانه-تهران-تهران-منطقه+سه-سیدخندان" />">رهن
						و اجاره آپارتمان سیدخندان</a></li>
			</ul>
		</section>
		<div class="clearfix"></div>

	</section>
	<div class="clearfix"></div>
</section>
<script>
	var segment;
	$(document)
			.scroll(
					function() {
						for (var i = 0; i < segment.length; i++) {
							if ($(segment[i]).hasClass('loaded'))
								continue;
							if ($(document).scrollTop()
									+ (window.innerHeight / 2) > $(segment[i])
									.offset().top) {
								segment[i].className += ' loaded';
							}
						}
					})
			.ready(
					function() {
						segment = $('.segment');
						//---------------------------
						window.mobileAndTabletcheck = function() {
							var check = false;
							try {
								(function(a) {
									if (/(android|bb\d+|meego).+mobile|avantgo|bada\/|blackberry|blazer|compal|elaine|fennec|hiptop|iemobile|ip(hone|od)|iris|kindle|lge |maemo|midp|mmp|mobile.+firefox|netfront|opera m(ob|in)i|palm( os)?|phone|p(ixi|re)\/|plucker|pocket|psp|series(4|6)0|symbian|treo|up\.(browser|link)|vodafone|wap|windows ce|xda|xiino|android|ipad|playbook|silk/i
											.test(a)
											|| /1207|6310|6590|3gso|4thp|50[1-6]i|770s|802s|a wa|abac|ac(er|oo|s\-)|ai(ko|rn)|al(av|ca|co)|amoi|an(ex|ny|yw)|aptu|ar(ch|go)|as(te|us)|attw|au(di|\-m|r |s )|avan|be(ck|ll|nq)|bi(lb|rd)|bl(ac|az)|br(e|v)w|bumb|bw\-(n|u)|c55\/|capi|ccwa|cdm\-|cell|chtm|cldc|cmd\-|co(mp|nd)|craw|da(it|ll|ng)|dbte|dc\-s|devi|dica|dmob|do(c|p)o|ds(12|\-d)|el(49|ai)|em(l2|ul)|er(ic|k0)|esl8|ez([4-7]0|os|wa|ze)|fetc|fly(\-|_)|g1 u|g560|gene|gf\-5|g\-mo|go(\.w|od)|gr(ad|un)|haie|hcit|hd\-(m|p|t)|hei\-|hi(pt|ta)|hp( i|ip)|hs\-c|ht(c(\-| |_|a|g|p|s|t)|tp)|hu(aw|tc)|i\-(20|go|ma)|i230|iac( |\-|\/)|ibro|idea|ig01|ikom|im1k|inno|ipaq|iris|ja(t|v)a|jbro|jemu|jigs|kddi|keji|kgt( |\/)|klon|kpt |kwc\-|kyo(c|k)|le(no|xi)|lg( g|\/(k|l|u)|50|54|\-[a-w])|libw|lynx|m1\-w|m3ga|m50\/|ma(te|ui|xo)|mc(01|21|ca)|m\-cr|me(rc|ri)|mi(o8|oa|ts)|mmef|mo(01|02|bi|de|do|t(\-| |o|v)|zz)|mt(50|p1|v )|mwbp|mywa|n10[0-2]|n20[2-3]|n30(0|2)|n50(0|2|5)|n7(0(0|1)|10)|ne((c|m)\-|on|tf|wf|wg|wt)|nok(6|i)|nzph|o2im|op(ti|wv)|oran|owg1|p800|pan(a|d|t)|pdxg|pg(13|\-([1-8]|c))|phil|pire|pl(ay|uc)|pn\-2|po(ck|rt|se)|prox|psio|pt\-g|qa\-a|qc(07|12|21|32|60|\-[2-7]|i\-)|qtek|r380|r600|raks|rim9|ro(ve|zo)|s55\/|sa(ge|ma|mm|ms|ny|va)|sc(01|h\-|oo|p\-)|sdk\/|se(c(\-|0|1)|47|mc|nd|ri)|sgh\-|shar|sie(\-|m)|sk\-0|sl(45|id)|sm(al|ar|b3|it|t5)|so(ft|ny)|sp(01|h\-|v\-|v )|sy(01|mb)|t2(18|50)|t6(00|10|18)|ta(gt|lk)|tcl\-|tdg\-|tel(i|m)|tim\-|t\-mo|to(pl|sh)|ts(70|m\-|m3|m5)|tx\-9|up(\.b|g1|si)|utst|v400|v750|veri|vi(rg|te)|vk(40|5[0-3]|\-v)|vm40|voda|vulc|vx(52|53|60|61|70|80|81|83|85|98)|w3c(\-| )|webc|whit|wi(g |nc|nw)|wmlb|wonu|x700|yas\-|your|zeto|zte\-/i
													.test(a.substr(0, 4)))
										check = true
								})(navigator.userAgent || navigator.vendor
										|| window.opera);
							} catch (ex) {
							}
							return check;
						};
						function resize() {
							var s_h = window.innerHeight;
							if (window.innerWidth >= 768) {
								for (var i = 0; i < segment.length; i++) {
									segment[i].style.minHeight = s_h
											- header.offsetHeight
											- (window.mobileAndTabletcheck() ? 0
													: main_nav.offsetHeight)
											- 1 + 'px';
								}
							}
						}

						$(window).on("resize", resize);
						$(window).on("orientationchange", resize);
						resize();
					});

	//pedram : submit 	جست و جوی با کد ملک

	$("#form-search-code").submit(
			function(event) {

				var codeId = $("#code").val();
				$('#form-search-code').attr('action',
						"<c:url value="/melkoffer/"/>" + codeId);
				$("#form-search-code").submit();
				e.preventDefault();
			});

	//pedram : submit 	
	$("#form-search")
			.submit(
					function(event) {

						var mtype = ($("#mtype").val() == '0') ? '' : $(
								"#mtype").find('option:selected').text()
								.replace(" ", "+").replace(" ", "+");
						var otype = ($("#otype").val() == '0') ? '-خانه' : '-'
								+ $("#otype").find('option:selected').text()
										.replace(" ", "+");
						var province = ($("#province").val() == '0') ? '' : '-'
								+ $("#province").find('option:selected').text()
										.replace(" ", "+");
						var city = ($("#city").val() == '0' || $("#city").val() == '') ? ''
								: '-'
										+ $("#city").find('option:selected')
												.text().replace(" ", "+");
						var area = ($("#area").val() == '0' || $("#area").val() == '') ? ''
								: '-'
										+ $("#area").find('option:selected')
												.text().replace(" ", "+");
						var zone = ($("#zone").val() == '0' || $("#zone").val() == '') ? ''
								: '-'
										+ $("#zone").find('option:selected')
												.text().replace(" ", "+");

						queryRequest = mtype + otype + province + city + area
								+ zone;
						//mtype + "-" + otype + "-" + province + "-" + city + "-" + area + "-" + zone

						$('#form-search').attr('action',
								"<c:url value="/melksearch/"/>" + queryRequest);
						$('#form-search').submit();
						e.preventDefault();

					});
</script>
<script language="JavaScript">
	$(function() {

		//Province
		$(".form-control[name=province]")
				.change(
						function(e) {
							var selected = $(this).val();

							var url = "city/json/" + selected;

							$("#city").empty();

							$
									.getJSON(
											url,
											{
												ajax : 'true'
											},
											function(data) {
												var options;
												options += '<option selected="selected" value="0">در ميان همه بگرد</option>';
												for (var i = 0; i < data.length; i++) {
													options += "<option value='"+data[i].idCity+"'>"
															+ data[i].nameCity
															+ "</option>";
												}
												$(".form-control[name=city]")
														.html(options);
											});

							//$("#city").change();
							resetOpt($("#area"));
							resetOpt($("#zone"));

						});

		//City
		$(".form-control[name=city]")
				.change(
						function(e) {
							var selected = $(this).val();

							var url = "area/json/" + selected;

							$("#area").empty();

							$
									.getJSON(
											url,
											{
												ajax : 'true'
											},
											function(data) {
												var options;
												options += '<option selected="selected" value="0">در ميان همه بگرد</option>';
												for (var i = 0; i < data.length; i++) {
													options += "<option value='"+data[i].idArea+"'>"
															+ data[i].nameArea
															+ "</option>";
												}
												$(".form-control[name=area]")
														.html(options);
											});

							//$("#area").change();
							resetOpt($("#zone"));
						});

		//Zone
		$(".form-control[name=area]")
				.change(
						function(e) {
							var selected = $(this).val();

							var url = "range/json/" + selected;

							$("#zone").empty();

							$
									.getJSON(
											url,
											{
												ajax : 'true'
											},
											function(data) {
												var options;
												options += '<option selected="selected" value="0">در ميان همه بگرد</option>';
												for (var i = 0; i < data.length; i++) {
													options += "<option value='"+data[i].idRange+"'>"
															+ data[i].nameRange
															+ "</option>";
												}
												$(".form-control[name=zone]")
														.html(options);
											});
						});
	});

	$(document).ready(function() {
		$("#province").change();
	});

	function resetOpt(ref) {
		ref.empty();
		var options;
		options += '<option selected="selected" value="0">در ميان همه بگرد</option>';
		ref.html(options);

	}
</script>

<%@ include file="./footer.jsp"%>