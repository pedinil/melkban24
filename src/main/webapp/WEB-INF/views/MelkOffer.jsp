
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="./header.jsp"%>


<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/MelkOffer.css" />
<section class="col-xs-12">
	<div class="well-sm">
		<section class="col-md-8 col-xs-12">
			<div class="galleria">
				<c:if test="${Case.pic1!=''}">
					<a href="${Case.pic1}"><img src="${Case.pic1}"
						alt="${Case.state.nameState} - ${Case.city.nameCity}" /></a>
				</c:if>

				<c:if test="${Case.pic2!=''}">
					<a href="${Case.pic2}"><img src="${Case.pic2}"
						alt="${Case.state.nameState} - ${Case.city.nameCity}" /></a>
				</c:if>

				<c:if test="${Case.pic3!=''}">
					<a href="${Case.pic3}"><img src="${Case.pic3}"
						alt="${Case.state.nameState} - ${Case.city.nameCity}" /></a>
				</c:if>

				<c:if test="${Case.pic4!=''}">
					<a href="${Case.pic4}"><img src="${Case.pic4}"
						alt="${Case.state.nameState} - ${Case.city.nameCity}" /></a>
				</c:if>

				<c:if test="${Case.pic5!=''}">
					<a href="${Case.pic5}"><img src="${Case.pic5}"
						alt="${Case.state.nameState} - ${Case.city.nameCity}" /></a>
				</c:if>

				<c:if test="${Case.pic6!=''}">
					<a href="${Case.pic6}"><img src="${Case.pic6}"
						alt="${Case.state.nameState} - ${Case.city.nameCity}" /></a>
				</c:if>

				<c:if test="${Case.pic7!=''}">
					<a href="${Case.pic7}"><img src="${Case.pic7}"
						alt="${Case.state.nameState} - ${Case.city.nameCity}" /></a>
				</c:if>

				<c:if test="${Case.pic8!=''}">
					<a href="${Case.pic8}"><img src="${Case.pic8}"
						alt="${Case.state.nameState} - ${Case.city.nameCity}" /></a>
				</c:if>

				<c:if test="${Case.pic9!=''}">
					<a href="${Case.pic9}"><img src="${Case.pic9}"
						alt="${Case.state.nameState} - ${Case.city.nameCity}" /></a>
				</c:if>



			</div>
		</section>

		<section class="col-md-4 col-xs-12">
			<section>
				<h3 class="l">
					<i class="fa fa-map-marker red"></i> موقعیت ملک
				</h3>
			</section>
			<section>
				<div id="gMap" style="width: 100%; height: 200px"></div>
			</section>
			<section id="features">
				<h3 class="l border-bottom">
					<i class="fa fa-map-marker red"></i> امکانات ملک
				</h3>
				<div class="center">

					<c:if test="${Case.parking==true}">
						<div class="prop-cont col-lg-2 col-md-3 col-sm-2 col-xs-3"
							title="پارکینگ">
							<div class="icon-cont">
								<i class="prop prop-parking"></i>
							</div>
						</div>
					</c:if>

					<c:if test="${Case.anten==true}">
						<div class="prop-cont col-lg-2 col-md-3 col-sm-2 col-xs-3"
							title="آنتن مرکزی">
							<div class="icon-cont">
								<i class="prop prop-wifi"></i>
							</div>
						</div>
					</c:if>



					<c:if test="${Case.camera==true}">
						<div class="prop-cont col-lg-2 col-md-3 col-sm-2 col-xs-3"
							title="دوربین">
							<div class="icon-cont">
								<i class="prop prop-camera"></i>
							</div>
						</div>
					</c:if>

					<c:if test="${Case.door==true}">
						<div class="prop-cont col-lg-2 col-md-3 col-sm-2 col-xs-3"
							title="درب ریموت دار">
							<div class="icon-cont">
								<i class="prop prop-door"></i>
							</div>
						</div>
					</c:if>

					<c:if test="${Case.shooting==true}">
						<div class="prop-cont col-lg-2 col-md-3 col-sm-2 col-xs-3"
							title="شوتینگ زباله">
							<div class="icon-cont">
								<i class="prop prop-doc"></i>
							</div>
						</div>
					</c:if>

					<c:if test="${Case.gas==true}">
						<div class="prop-cont col-lg-2 col-md-3 col-sm-2 col-xs-3"
							title="گاز رومیزی">
							<div class="icon-cont">
								<i class="prop prop-gas"></i>
							</div>
						</div>
					</c:if>


					<c:if test="${Case.fire==true}">
						<div class="prop-cont col-lg-2 col-md-3 col-sm-2 col-xs-3"
							title="اطقا حریق">
							<div class="icon-cont">
								<i class="prop prop-lamp"></i>
							</div>
						</div>
					</c:if>


					<c:if test="${Case.pasio==true}">
						<div class="prop-cont col-lg-2 col-md-3 col-sm-2 col-xs-3"
							title="پاسیو">
							<div class="icon-cont">
								<i class="prop prop-flower"></i>
							</div>
						</div>
					</c:if>


					<c:if test="${Case.iphone==true}">
						<div class="prop-cont col-lg-2 col-md-3 col-sm-2 col-xs-3"
							title="آیفون تصویری">
							<div class="icon-cont">
								<i class="prop prop-iphone"></i>
							</div>
						</div>
					</c:if>


					<c:if test="${Case.elevator==true}">
						<div class="prop-cont col-lg-2 col-md-3 col-sm-2 col-xs-3"
							title="آسانسور">
							<div class="icon-cont">
								<i class="prop prop-elevator"></i>
							</div>
						</div>
					</c:if>

					<c:if test="${Case.tel==true}">
						<div class="prop-cont col-lg-2 col-md-3 col-sm-2 col-xs-3"
							title="تلفن">
							<div class="icon-cont">
								<i class="prop prop-tel"></i>
							</div>
						</div>
					</c:if>


					<c:if test="${Case.furned==true}">
						<div class="prop-cont col-lg-2 col-md-3 col-sm-2 col-xs-3"
							title="مبله">
							<div class="icon-cont">
								<i class="prop prop-furnished"></i>
							</div>
						</div>
					</c:if>

					<c:if test="${Case.storage==true}">
						<div class="prop-cont col-lg-2 col-md-3 col-sm-2 col-xs-3"
							title="انباری">
							<div class="icon-cont">
								<i class="prop prop-track"></i>
							</div>
						</div>
					</c:if>


					<c:if test="${Case.negahban==true}">
						<div class="prop-cont col-lg-2 col-md-3 col-sm-2 col-xs-3"
							title="سرایدار">
							<div class="icon-cont">
								<i class="prop prop-janitor"></i>
							</div>
						</div>
					</c:if>



					<c:if test="${Case.pool==true}">
						<div class="prop-cont col-lg-2 col-md-3 col-sm-2 col-xs-3"
							title="استخر">
							<div class="icon-cont">
								<i class="prop prop-swim"></i>
							</div>
						</div>
					</c:if>


					<c:if test="${Case.sona==true}">
						<div class="prop-cont col-lg-2 col-md-3 col-sm-2 col-xs-3"
							title="جکوزی">
							<div class="icon-cont">
								<i class="prop prop-jacuzzi"></i>
							</div>
						</div>
					</c:if>


					<c:if test="${Case.shomineh==true}">
						<div class="prop-cont col-lg-2 col-md-3 col-sm-2 col-xs-3"
							title="شومینه">
							<div class="icon-cont">
								<i class="prop prop-fireplace"></i>
							</div>
						</div>
					</c:if>

					<c:if test="${Case.pele==true}">
						<div class="prop-cont col-lg-2 col-md-3 col-sm-2 col-xs-3"
							title="پله اظطراری">
							<div class="icon-cont">
								<i class="prop prop-1_png_3_"></i>
							</div>
						</div>
					</c:if>



					<c:if test="${Case.loby==true}">
						<div class="prop-cont col-lg-2 col-md-3 col-sm-2 col-xs-3"
							title="لابی">
							<div class="icon-cont">
								<i class="prop prop-pack"></i>
							</div>
						</div>
					</c:if>

				</div>
			</section>
		</section>
		<div class="col-xs-12 clearfix">
			<div class="col-xs-12 border-bottom"></div>
		</div>
	</div>

</section>

<section id="props" class="col-xs-12">
	<h3 class="col-xs-12">
		<i class="fa fa-map-marker red"></i> مشخصات ملک
	</h3>

	<div id="me_prop_v_cont" class="col-md-8 col-xs-12">
		<div class="col-xs-12 nopl">
			<div class="col-xs-12 nopl">
				<div class="col-xs-12 nopl">
					<div class="lbl_dark code_key">کد ملک:</div>
				</div>

				<div class="col-xs-12 nopl">
					<div class="lbl_dark code_value">

						<fmt:parseNumber type="number" value="${Case.idCase}" />
					</div>
				</div>

				<div class="col-md-6 col-xs-12 nopl">
					<div class="inner-cont">
						<div>
							<div class="col-xs-6 l">استان شهر:</div>
							<div class="col-xs-6 r red">${Case.state.nameState}-
								${Case.city.nameCity}</div>
							<div class="clearfix"></div>
						</div>

						<div>
							<div class="col-xs-6 l">نوع تقاضا:</div>
							<div class="col-xs-6 r red">${Case.kindCase.nameKindCase}</div>
							<div class="clearfix"></div>
						</div>
						<div>
							<div class="col-xs-6 l">نوع درخواست:</div>
							<div class="col-xs-6 r red">
								${Case.kindRequest.nameKindRequest}</div>
							<div class="clearfix"></div>
						</div>
						<div>
							<div class="col-xs-6 l">منطقه:</div>
							<div class="col-xs-6 r red">${Case.area.nameArea}</div>
							<div class="clearfix"></div>
						</div>
						<div>
							<div class="col-xs-6 l">محدوده:</div>
							<div class="col-xs-6 r red">${Case.range.nameRange}</div>
							<div class="clearfix"></div>
						</div>
						<div>
							<div class="col-xs-6 l">مساحت زمین:</div>
							<div class="col-xs-6 r red">
								<fmt:parseNumber type="number" value="${Case.masahat}" />
							</div>
							<div class="clearfix"></div>
						</div>
						<div>
							<div class="col-xs-6 l">محله:</div>
							<div class="col-xs-6 r red">${Case.confine}</div>
							<div class="clearfix"></div>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
				<div class="col-md-6 col-xs-12 nopl">
					<div class="inner-cont">
						<div>
							<div class="col-xs-6 l">متراژ:</div>
							<div class="col-xs-6 r red">
								<fmt:parseNumber type="number" value="${Case.metraj}" />
							</div>
							<div class="clearfix"></div>
						</div>
						<div>
							<div class="col-xs-6 l">تعداد خواب:</div>
							<div class="col-xs-6 r red">
								<fmt:parseNumber type="number" value="${Case.countBed}" />
							</div>
							<div class="clearfix"></div>
						</div>
						<div>
							<c:choose>
								<c:when test="${Case.kindRequest.idKindRequest==3}">
									<div class="col-xs-6 l">مبلغ رهن:</div>
								</c:when>
								<c:otherwise>
									<div class="col-xs-6 l">مبلغ کل:</div>
								</c:otherwise>
							</c:choose>
							<div class="col-xs-6 r red">

								<fmt:formatNumber type="number" maxIntegerDigits="20"
									value="${Case.price1}" />
								ت
							</div>
							<div class="clearfix"></div>
						</div>
						<div>
							<div class="col-xs-6 l">تعداد طبقات:</div>
							<div class="col-xs-6 r red">
								<fmt:parseNumber type="number" value="${Case.countFloor}" />
							</div>
							<div class="clearfix"></div>
						</div>

						<c:if test="${Case.kindRequest.idKindRequest==3}">
							<div>
								<div class="col-xs-6 l">مبلغ اجاره:</div>
								<div class="col-xs-6 r red">
									<fmt:formatNumber type="number" maxIntegerDigits="20"
										value="${Case.price2}" />
									ت
								</div>
								<div class="clearfix"></div>
							</div>
						</c:if>

						<div>
							<div class="col-xs-6 l">طبقه ملک:</div>
							<div class="col-xs-6 r red">${Case.floor}</div>
							<div class="clearfix"></div>
						</div>
						<div>
							<div class="col-xs-6 l">تعداد واحدها:</div>
							<div class="col-xs-6 r red">
								<fmt:parseNumber type="number" value="${Case.countUnit}" />
							</div>
							<div class="clearfix"></div>
						</div>
						<div>
							<div class="col-xs-6 l">شماره واحد:</div>
							<div class="col-xs-6 r red">${Case.unit}</div>
							<div class="clearfix"></div>
						</div>
						<div>
							<div class="col-xs-6 l">سن بنا:</div>
							<div class="col-xs-6 r red">${Case.age}</div>
							<div class="clearfix"></div>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="col-md-4 col-xs-12">

		<div id="visit_count"
			class="col-md-12 col-xs-11 col-md-offset-0 col-xs-offset-1">
			<div class="lbl_light visit_key">
				تعداد بازدیدها:
				<fmt:parseNumber type="number" value="${Case.visitorCount}" />
			</div>
			<div class="lbl_dark">
				تاریخ درج: <span> ${Case.dateIn} </span>
			</div>
			<div class="inner-cont">
				<div>
					<div class="col-xs-6 l">نمای بنا:</div>
					<div class="col-xs-6 r red">${Case.nama.namaName}</div>
					<div class="clearfix"></div>
				</div>
				<div>
					<div class="col-xs-6 l">وضعیت ملک:</div>
					<div class="col-xs-6 r red">${Case.caseSide.name}</div>
					<div class="clearfix"></div>
				</div>
				<div>
					<div class="col-xs-6 l">وضعیت کف:</div>
					<div class="col-xs-6 r red">${Case.roof.nameRoof}</div>
					<div class="clearfix"></div>
				</div>
				<div>
					<div class="col-xs-6 l">آشپزخانه:</div>
					<div class="col-xs-6 r red">${Case.kitchen.kitchenName}</div>
					<div class="clearfix"></div>
				</div>
				<div>
					<div class="col-xs-6 l">کابینت:</div>
					<div class="col-xs-6 r red">${Case.cabinet.cabinetName}</div>
					<div class="clearfix"></div>
				</div>
				<div>
					<div class="col-xs-6 l">پنجره:</div>
					<div class="col-xs-6 r red">${Case.windows.windowsName}</div>
					<div class="clearfix"></div>
				</div>
				<div>
					<div class="col-xs-6 l">سرویس:</div>
					<div class="col-xs-6 r red">${Case.service.serviceName}</div>
					<div class="clearfix"></div>
				</div>
				<div>
					<div class="col-xs-6 l">سرمایش:</div>
					<div class="col-xs-6 r red">${Case.systemS.systemSName}</div>
					<div class="clearfix"></div>
				</div>
				<div>
					<div class="col-xs-6 l">گرمایش:</div>
					<div class="col-xs-6 r red">${Case.systemG.systemGName}</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>

	</div>
</section>

<section id="desc" class="col-xs-12">
	<h3 class="col-xs-12">توضیحات:</h3>
	<div class="col-xs-12">
		<div class="col-xs-12">
			<div class="lbl_light">${Case.comment}</div>

		</div>
	</div>
</section>

<div class="col-xs-12">
	<div class="col-xs-12">
		<div class="border-bottom well-sm"></div>
	</div>
</div>

<section id="contact" class="col-xs-12">
	<h3 class="col-xs-12">
		<i class="fa fa-map-marker red"></i> اطلاعات تماس
	</h3>
	<div class="col-xs-11 col-xs-offset-1">
		<div class="col-md-3 col-sm-6 col-xs-12">
			<div class="lbl_light center">نام آژانس</div>
			<div class="lbl_dark center">&nbsp;كاربر آزاد</div>
		</div>
		<div class="col-md-3 col-sm-6 col-xs-12">
			<div class="lbl_light center">نام سپارنده فایل</div>
			<div class="lbl_dark center">&nbsp;${Case.users.family}</div>
		</div>
		<div class="col-md-3 col-sm-6 col-xs-12">
			<div class="lbl_light center">شماره تماس</div>
			<div class="lbl_dark center">&nbsp;${Case.users.tel}</div>
		</div>
		<div class="col-md-3 col-sm-6 col-xs-12">
			<div class="lbl_light center">موبایل</div>
			<div class="lbl_dark center">&nbsp;${Case.users.mobile}</div>
		</div>
	</div>

</section>

<fmt:parseNumber type="number" value="${urlPath}" var="myCaseid" />
<c:url var="URL" value="melkban24.ir/melkoffer/${myCaseid}" />

<div id="share" class="col-xs-10 col-xs-offset-1 l">
	<a class="share_telegram" title="اشتراک گذاری در تلگرام"
		href="https://telegram.me/share/url?url=${URL}" target="_blank"> <i
		class="fa fa-send"></i>
	</a> 
	<a class="share_googleplus" title="اشتراک گذاری در اینستاگرام"
		href="https://plus.google.com/share?url=${URL}" target="_blank"> 
		<i class="fa fa-google-plus"></i>
	</a> 
	<a class="share_facebook" title="اشتراک گذاری در فیسبوک"
		href="https://www.facebook.com/sharer.php?u=${URL}" target="_blank"> <i class="fa fa-facebook"></i>
	</a>
	<a class="share_twitter" title="اشتراک گذاری در تویتر"
		href="https://www.facebook.com/sharer.php?u=${URL}" target="_blank"> <i class="fa fa-twitter fa-lg"></i>
	</a>
	
</div>

<div class="col-xs-12">
	<div class="col-xs-12">
		<div class="border-bottom well-sm"></div>
	</div>
</div>

<section id="related" class="col-xs-12">
	<h3 class="col-xs-12">
		<i class="fa fa-map-marker red"></i> ملک های مشابه
	</h3>
	<div class="col-md-8 col-md-offset-2 col-xs-12">


		<c:forEach items="${listCaseSimilar}" var="CaseSimilar">

			<div
				class="m-cont col-md-4 col-sm-5 col-sm-offset-1 col-xs-8 col-md-offset-0 col-xs-offset-2 hvr-grow">

				<fmt:parseNumber var="idcaseCn" type="number"
					value="${CaseSimilar.idCase}" />

				<div class="cont">
					<a href="<c:url value="/melkoffer/${idcaseCn}"/>" class="img"
						style="background-image:url('${CaseSimilar.thPic1}');"> </a>
					<footer>
						<ul>
							<li><a href="<c:url value="/melkoffer/${idcaseCn}"/>"> <i
									class="icon i-place"></i> ${CaseSimilar.state.nameState} -
									${CaseSimilar.city.nameCity}
							</a></li>
							<li><a href="<c:url value="/melkoffer/${idcaseCn}"/>"> <i
									class="icon i-pip"></i> <fmt:parseNumber type="number"
										value="${CaseSimilar.metraj}" />
							</a></li>
							<li><a href="<c:url value="/melkoffer/${idcaseCn}"/>"> <i
									class="icon i-hand"></i> <fmt:parseNumber type="number"
										value="${CaseSimilar.countBed}" />
							</a></li>
							<li><a href="<c:url value="/melkoffer/${idcaseCn}"/>"> <i
									class="icon i-money"></i> <fmt:formatNumber type="number"
										maxIntegerDigits="20" value="${CaseSimilar.price1}" />
							</a></li>
						</ul>
					</footer>
				</div>
			</div>

		</c:forEach>



		<div class="clearfix"></div>
	</div>
</section>

<div class="col-xs-12">
	<div class="col-xs-12">
		<div class="well-sm border-bottom">&nbsp;</div>
	</div>
</div>

<div id="do-you-know" class="col-xs-12">
	<div class="center well-sm">آیا می دانستید که ...؟</div>
	<div class="col-md-6 col-md-offset-3 col-xs-12">

		<div class="red-border well-sm">
			<c:forEach items="${listKnowRandom}" var="KnowRand">

				<fmt:parseNumber var="varIdknow" type="number"
					value="${KnowRand.idKnow}" />


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





<div class="well-sm clearfix">&nbsp;</div>


<script
	src="${pageContext.request.contextPath}/resources/js/galleria-1.4.2.min.js"></script>
<script>
$(document).ready(function(){
	//----------------------------------------------
	Galleria.configure({
		imageCrop: false,
		transition: 'slide',
		thumbPosition: 'center',
		lightbox: true
	});
	Galleria.loadTheme('${pageContext.request.contextPath}/resources/js/galleria/themes/classic/galleria.classic.min.js');
	Galleria.run('.galleria')
	//----------------------------------------------
	var gmap;
	function initialize() {
		
		var location = [${Case.lat},${Case.lon}];
		
		var mapProp = {
			center: new google.maps.LatLng(location[0],location[1]),
			zoom: 15,
			scrollwheel:  false,
			panControl: true,
			panControlOptions: {
				position: google.maps.ControlPosition.TOP_LEFT
			},
			mapTypeControl: false,
			zoomControl: true,
			zoomControlOptions: {
				style: google.maps.ZoomControlStyle.SMALL,
				position: google.maps.ControlPosition.TOP_LEFT
			},
			scaleControl: false,
			streetViewControl: false,
			rotateControl: false,
			mapTypeId: google.maps.MapTypeId.ROADMAP
		}
		
		gmap = new google.maps.Map(document.getElementById("gMap"), mapProp);

		var marker = new google.maps.Marker({
            position: new google.maps.LatLng(location[0],location[1]),
            map: gmap
        });

	}
	google.maps.event.addDomListener(window, 'load', initialize);
	//--------------------------------------------
	$("#features").find('.prop-cont').tooltip({
		container:'body'
		,trigger:'hover'
	});
	//------------------------------------------------
});
</script>

<%@ include file="./footerMap.jsp"%>