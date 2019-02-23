<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="./header.jsp"%>



<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/MelkSearch.css" />

<section class="well-sm" id="search">

	<h1 class="col-xs-offset-1 col-xs-10">${h1text}</h1>

	<c:url var="addAction" value="/melksearch/${urlPath}/page-1"></c:url>
	<form:form id="form-search" method="post" action="${addAction}"
		commandName="caseAdSearch">
		<div class="col-xs-offset-1 col-xs-10">
			<header>
				<h3 class="center grlbl grbwb well-sm">
					<i class="fa fa-map-marker red"></i> جست و جوی پیشرفته
				</h3>
			</header>
			<div class="form">
				<div class="col-md-4 col-xs-12 nopr">
					<div class="well-sm form-inner">
						<div class="col-xs-12">متراژ:</div>

						<div>
							<div class="col-xs-1">از</div>
							<div class="col-xs-5">
								<form:input path="fromMetraj"  type="text"
									class="form-control binput" />
							</div>
							<div class="float-r">تا</div>
							<div class="col-xs-5">
								<form:input path="tillMetraj"  type="text"
									class="form-control binput" />
							</div>

						</div>

						<div class="clearfix"></div>

						<div class="col-xs-12">قیمت کل(تومان):</div>

						<div>
							<div class="col-xs-1">از</div>
							<div class="col-xs-5">
								<form:input path="fromPrice1"  type="text"
									class="form-control binput price" />
							</div>
							<div class="float-r">تا</div>
							<div class="col-xs-5">
								<form:input path="tillPrice1"  type="text"
									class="form-control binput price" />
							</div>

						</div>

						<div class="clearfix"></div>

						<c:if test="${requestType==3}">

							<div class="col-xs-12">قیمت اجاره(تومان):</div>

							<div>
								<div class="col-xs-1">از</div>
								<div class="col-xs-5">
									<form:input path="fromPrice2"  type="text"
										class="form-control binput price" />
								</div>
								<div class="float-r">تا</div>
								<div class="col-xs-5">
									<form:input path="tillPrice2"  type="text"
										class="form-control binput price" />
								</div>

							</div>
						</c:if>


						<div class="clearfix"></div>

						<div class="col-xs-12">سن بنا:</div>

						<div>
							<div class="col-xs-1">از</div>
							<div class="col-xs-5">
								<form:input path="fromAge" type="number" min="0" max="100"
									class="form-control binput" />
							</div>
							<div class="float-r">تا</div>
							<div class="col-xs-5">
								<form:input path="tillAge" type="number" min="0" max="100"
									class="form-control binput" />
							</div>

						</div>
						<div class="clearfix"></div>

						<div class="col-xs-12">تعداد خواب:</div>

						<div>
							<div class="col-xs-1">از</div>
							<div class="col-xs-5">
								<form:input path="fromCountbed" type="number" min="0" max="10"
									class="form-control binput" />
							</div>
							<div class="float-r">تا</div>
							<div class="col-xs-5">
								<form:input path="tillCountbed" type="number" min="0" max="10"
									class="form-control binput" />
							</div>

						</div>

						<div class="clearfix"></div>

					</div>
					<div class="clearfix"></div>
				</div>

				<div class="col-md-4 col-xs-12">
					<div class="well-sm form-inner">
						<div class="col-md-5 col-xs-5 col-sm-2 l">نوع کف</div>
						<div class="col-md-6 col-xs-6 col-sm-2">
							<div class="select-wrapper">
								<form:select path="roof.fID" class="binput w100">
									<form:options items="${listRoof}" itemValue="fID"
										itemLabel="nameRoof" />
								</form:select>
							</div>
						</div>
						<div class="clearfix hidden-sm"></div>

						<div class="col-md-5 col-xs-5 col-sm-2 l">نوع کابینت</div>
						<div class="col-md-6 col-xs-6 col-sm-2">
							<div class="select-wrapper">
								<form:select path="cabinet.fID" class="binput w100">
									<form:options items="${listCabinet}" itemValue="fID"
										itemLabel="cabinetName" />
								</form:select>
							</div>
						</div>
						<div class="clearfix hidden-sm"></div>

						<div class="col-md-5 col-sm-1 col-xs-5 l">نما</div>
						<div class="col-md-6 col-sm-2 col-xs-6">
							<div class="select-wrapper">
								<form:select path="nama.fID" class="binput w100">
									<form:options items="${listNama}" itemValue="fID"
										itemLabel="namaName" />
								</form:select>
							</div>
						</div>
						<div class="clearfix"></div>

						<div>
							<div
								class="form-icon col-md-8 col-md-offset-2 col-sm-5 col-xs-10 col-xs-offset-1">
								<form:checkbox path="WithPicture" />
								<div class="binput l form-control">فایل های عکس دار</div>
								<div class="icon right">
									<i class="fa fa-camera fa-2x"></i>
								</div>
							</div>

							<div class="clearfix hidden-sm"></div>

							<div
								class="form-icon col-md-8 col-md-offset-2 col-sm-5 col-sm-offset-0 col-xs-10 col-xs-offset-1">
								<form:checkbox path="Recently"  />
								<div class="binput r form-control">فایل های 30 روز اخیر</div>
								<div class="icon left">
									<i class="fa fa-home fa-2x"></i>
								</div>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>

				<div class="col-md-4 col-xs-12 nopl">
					<div id="features" class="well-sm form-inner">
						<div class="center">
							<div class="prop-cont hvr-grow" title="پارکینگ">
								<form:checkbox path="parking" />
								<div class="icon-cont">
									<i class="prop w prop-parking"></i>
								</div>
							</div>
							<div class="prop-cont hvr-grow" title="استخر">
								<form:checkbox path="pool" />
								<div class="icon-cont">
									<i class="prop w prop-swim"></i>
								</div>
							</div>
							<div class="prop-cont hvr-grow" title="درب ریموت دار">
								<form:checkbox path="door"  />
								<div class="icon-cont">
									<i class="prop w prop-door"></i>
								</div>
							</div>
							<div class="prop-cont hvr-grow" title="انباری">
								<form:checkbox path="storage" />
								<div class="icon-cont">
									<i class="prop w prop-track"></i>
								</div>

							</div>
							<div class="prop-cont hvr-grow" title="آیفون تصویری">
								<form:checkbox path="iphone" />
								<div class="icon-cont">
									<i class="prop w prop-iphone"></i>
								</div>
							</div>
							<div class="prop-cont hvr-grow" title="آسانسور">
								<form:checkbox path="elevator" />
								<div class="icon-cont">
									<i class="prop w prop-elevator"></i>
								</div>
							</div>
							<div class="prop-cont hvr-grow" title="سرایدار">
								<form:checkbox path="negahban" />
								<div class="icon-cont">
									<i class="prop w prop-janitor"></i>
								</div>
							</div>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
				<footer class="well-sm grbwb grlbl center">
					<button type="submit">
						<i class="fa fa-search fa-2x"></i>
					</button>
				</footer>
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="clearfix"></div>


	</form:form>
</section>

<section id="result-cont" class="col-md-10 col-xs-11 col-xs-offset-1">


	<c:forEach items="${listCase}" var="Case">

		<article class="result">
			<!-- <a class="compare hvr-grow">
			<i class="float-l fa fa-circle"></i>
			مقایسه کن
		</a> -->
			<div class="search grbwb">نتیجه جستجو</div>
			<div class="result-wrapper">
				<div class="result-inner">

					<fmt:parseNumber type="number" value="${Case.idCase}"
						var="myCaseid" />


					<a href="<c:url value="/melkoffer/${myCaseid}"/>"
						class="img col-sm-12 col-md-5 nopr nopl">
						<c:if test="${!empty Case.pic1}">
							<img src="${Case.pic1}" alt="${h1text}" /> 
						</c:if>
						
						 <c:if test="${empty Case.thPic1}">
							<img src="${pageContext.request.contextPath}/resources/img/default.png"  alt="${h1text}" /> 
						</c:if>
						<span class="triangle"> مشاهده جزئیات <span class="pgram"></span>
					</span>
					</a>
					<div class="result-props col-md-7 col-sm-12 col-md-offset-5">
						<div class="col-sm-5 col-xs-12 nopl nopr">
							<div class="row">
								<div class="col-xs-5">نوع تقاضا:</div>
								<div class="col-xs-7 red">${Case.kindCase.nameKindCase}</div>
							</div>

							<div class="row">
								<div class="col-xs-5">منطقه:</div>
								<div class="col-xs-7 red">${Case.area.nameArea}</div>
							</div>

							<div class="row">
								<div class="col-xs-5">محله:</div>
								<div class="col-xs-7 red">${Case.confine}</div>
							</div>

							<div class="row">
								<div class="col-xs-5">متراژ:</div>
								<div class="col-xs-7 red">
									<fmt:parseNumber type="number" value="${Case.metraj}" />
								</div>
							</div>

							<div class="row">
							
								<c:choose>
									<c:when test="${requestType==3}">
										<div class="col-xs-5">قیمت (ودیعه):</div>
									</c:when>
									<c:otherwise>
										<div class="col-xs-5">قیمت کل:</div>
									</c:otherwise>
								</c:choose>
								
								<div class="col-xs-7 red">
									<fmt:formatNumber type="number" maxIntegerDigits="20"
										value="${Case.price1}" /> ت
								</div>
							</div>

							<div class="row">
								<div class="col-xs-5">خواب:</div>
								<div class="col-xs-7 red">
									<fmt:parseNumber type="number" value="${Case.countBed}" />
								</div>
							</div>

							<div class="row">
								<div class="col-xs-5">سن بنا:</div>
								<div class="col-xs-7 red">${Case.age}</div>
							</div>

							<div class="row">
								<div class="col-xs-5">طبقه:</div>
								<div class="col-xs-7 red">${Case.floor}</div>
							</div>
							<div class="clearfix"></div>
						</div>

						<div class="col-sm-5 col-xs-12 nopl nopr">
							<div class="row">
								<div class="col-xs-5">کد ملک:</div>
								<div class="col-xs-7 red">
									<fmt:parseNumber type="number" value="${Case.idCase}" />
								</div>
							</div>

							<div class="row">
								<div class="col-xs-5">پارکینگ:</div>
								<div class="col-xs-7 red">

									<c:if test="${Case.parking==false}">
										<i class="fa fa-square-o"></i>
									</c:if>

									<c:if test="${Case.parking==true}">
										<i class="fa fa-check-square-o"></i>
									</c:if>

								</div>
							</div>

							<div class="row">
								<div class="col-xs-5">انباری:</div>
								<div class="col-xs-7 red">

									<c:if test="${Case.storage==false}">
										<i class="fa fa-square-o"></i>
									</c:if>

									<c:if test="${Case.storage==true}">
										<i class="fa fa-check-square-o"></i>
									</c:if>


								</div>
							</div>

							<div class="row">
								<div class="col-xs-5">آسانسور:</div>
								<div class="col-xs-7 red">


									<c:if test="${Case.elevator==false}">
										<i class="fa fa-square-o"></i>
									</c:if>

									<c:if test="${Case.elevator==true}">
										<i class="fa fa-check-square-o"></i>
									</c:if>

								</div>
							</div>

							<div class="row">
								<div class="col-xs-5">گاز رومیزی:</div>
								<div class="col-xs-7 red">

									<c:if test="${Case.gas==false}">
										<i class="fa fa-square-o"></i>
									</c:if>

									<c:if test="${Case.gas==true}">
										<i class="fa fa-check-square-o"></i>
									</c:if>

								</div>
							</div>

							<div class="row">
								<div class="col-xs-5">مبله:</div>
								<div class="col-xs-7 red">

									<c:if test="${Case.furned==false}">
										<i class="fa fa-square-o"></i>
									</c:if>

									<c:if test="${Case.furned==true}">
										<i class="fa fa-check-square-o"></i>
									</c:if>

								</div>
							</div>

							<div class="clearfix"></div>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
		</article>

	</c:forEach>



</section>

<div id="pager" class="col-lg-8 col-lg-offset-2 col-xs-12">





	<c:if test="${currentIndex==0}">
		<c:url var="prevUrl" value="${urlPath}/page-1" />
		<c:url var="nextUrl" value="${urlPath}/page-${currentIndex + 1}" />
	</c:if>

	<c:if test="${currentIndex>0}">

		<c:url var="prevUrl" value="./page-${currentIndex - 1}" />

		<c:if test="${currentIndex==1}">
			<c:url var="prevUrl" value="./page-${currentIndex}" />
		</c:if>

		<c:url var="nextUrl" value="./page-${currentIndex + 1}" />

	</c:if>

	<c:if test="${methodRequest == 'GET'}">
		<a href="${prevUrl}" class="back control"> <i
			class="fa fa-chevron-right"></i>
		</a>
	</c:if>

	<c:if test="${methodRequest == 'POST'}">
		<a href="${prevUrl}"
			onclick="submitResponse('${prevUrl}'); return false"
			class="back control"> <i class="fa fa-chevron-right"></i>
		</a>
	</c:if>

	<ul>

		<c:forEach var="i" begin="${beginIndex}" end="${endIndex}">

			<c:if test="${currentIndex==0}">
				<c:url var="pageUrl" value="${urlPath}/page-${i}" />
			</c:if>

			<c:if test="${currentIndex>0}">
				<c:url var="pageUrl" value="./page-${i}" />
			</c:if>

			<c:choose>
				<c:when test="${i == currentIndex}">
					<li><c:if test="${methodRequest == 'GET'}">
							<a href="${pageUrl}"> <i class="fa fa-circle active"></i> <span
								class="num"> ${i} </span>
							</a>
						</c:if> <c:if test="${methodRequest == 'POST'}">
							<a href="${pageUrl}"
								onclick="submitResponse('${pageUrl}'); return false"> <i
								class="fa fa-circle active"></i> <span class="num"> ${i}
							</span>
							</a>
						</c:if></li>
				</c:when>

				<c:otherwise>
					<li><c:if test="${methodRequest == 'GET'}">
							<a href="${pageUrl}"> <i class="fa fa-circle"></i> <span
								class="num"> ${i} </span>
							</a>
						</c:if> <c:if test="${methodRequest == 'POST'}">
							<a href="${pageUrl}"
								onclick="submitResponse('${pageUrl}') ; return false"> <i
								class="fa fa-circle"></i> <span class="num"> ${i} </span>
							</a>
						</c:if></li>
				</c:otherwise>

			</c:choose>

		</c:forEach>


	</ul>

	<c:if test="${methodRequest == 'GET'}">
		<a href="${nextUrl}" class="next control"> <i
			class="fa fa-chevron-left"></i>
		</a>
	</c:if>

	<c:if test="${methodRequest == 'POST'}">
		<a href="${nextUrl}"
			onclick="submitResponse('${nextUrl}'); return false"
			class="next control"> <i class="fa fa-chevron-left"></i>
		</a>
	</c:if>

</div>




<div class="clearfix"></div>

<c:if test="${!empty guideBuy.description}">

	<section id="help" class="segment col-xs-12 sb">
		<div class="center well-sm">راهنمای
			${guideBuy.kindRequest.nameKindRequest} خانه در
			${guideBuy.city.nameCity}</div>
		<div name="help_buy"
			class="col-md-10 col-md-offset-1 col-xs-12 col-sm-11 col-sm-offset-1 textareaDiv">${guideBuy.description}</div>
	</section>

</c:if>

<div class="clearfix"></div>

<script language="JavaScript">
	$(document).ready(function() {
		$("#features").find('.prop-cont').tooltip({
			container : 'body',
			trigger : 'hover'
		});
	})

	function submitResponse(url) {

		//$.post( url, $( "#form-search" ).serialize() );
		//$('#form-search').attr('action', "_$tag___________________________________"+url);
		$('#form-search').attr('action', url);
		$('#form-search').submit();

	}
</script>


<%@ include file="./footer.jsp"%>