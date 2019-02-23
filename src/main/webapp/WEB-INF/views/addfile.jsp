<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="./header.jsp"%>



<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/cropper.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/AddFile.css" />
<div class="tabbable">

	<!-- Nav tabs -->
	<ul class="nav nav-tabs" role="tablist">
		<li role="presentation" class="active col-xs-3"><a
			href="#location" aria-controls="location" role="tab"
			data-toggle="tab"> <i class="icon i-pos visible-xs-inline-block"></i>
				<i class="fa fa-map-marker hidden-xs"></i> <span class="hidden-xs">موقعیت
					ملک</span>
		</a></li>
		<li role="presentation" class="col-xs-3"><a href="#me_props"
			aria-controls="me_props" role="tab" data-toggle="tab"> <i
				class="icon i-identify visible-xs-inline-block"></i> <i
				class="fa fa-map-marker hidden-xs"></i> <span class="hidden-xs">مشخصات
					ملک</span>
		</a></li>
		<li role="presentation" class="col-xs-3"><a href="#images"
			aria-controls="images" role="tab" data-toggle="tab"> <i
				class="icon i-m-img visible-xs-inline-block"></i> <i
				class="fa fa-map-marker hidden-xs"></i> <span class="hidden-xs">تصاویر
					ملک</span>
		</a></li>
		<li role="presentation" class="col-xs-3"><a href="#ma_props"
			aria-controls="ma_props" role="tab" data-toggle="tab"> <i
				class="icon i-identify-o visible-xs-inline-block"></i> <i
				class="fa fa-map-marker hidden-xs"></i> <span class="hidden-xs">مشخصات
					مالک</span>
		</a></li>
	</ul>

	<div id="hint" class="center">
		قبل از سپردن فایل ملک موردنظر لطفا قسمت <a href="<c:url value="/melklows" />"> قوانین و
			مقررات سایت </a> را با دقت مطالعه کنید.
	</div>

	<c:url var="addAction" value="/addfile"></c:url>

	<form:form id="form-add" name="form-add" action="${addAction}"
		commandName="caseSave" method="post" enctype="multipart/form-data">
		<form:input type="hidden" path="Lat"  id="latitude" />
		<form:input type="hidden" path="Lon"  id="longitude" />
		<!-- Tab panes -->
		<div class="tab-content">
			<div role="tabpanel" class="tab-pane active" id="location">
				<div class="col-md-5 col-xs-12 col-md-offset-1">
					<div class="row">
						<div class="col-xs-3 lbl">استان</div>
						<div class="col-xs-6">
							<div class="select-wrapper">

								<form:select id="province"  path="state.idState"
									class="binput w100">
									<form:options items="${listState}" itemValue="idState"
										itemLabel="nameState" />
								</form:select>

							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-3 lbl">شهر</div>
						<div class="col-xs-6">
							<div class="select-wrapper">
								<form:select id="city"  path="city.idCity"
									class="binput w100">
									<option>تهران</option>
								</form:select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-3 lbl">منطقه</div>
						<div class="col-xs-6">
							<div class="select-wrapper">
								<form:select id="area"  path="area.idArea"
									class="binput w100">
									<option>یک</option>
								</form:select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-3 lbl">محدوده</div>
						<div class="col-xs-6">
							<div class="select-wrapper">
								<form:select id="zone"  path="range.idRange"
									class="binput w100">
									<option>-</option>
								</form:select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-3 lbl">محله</div>
						<div class="col-xs-6">
							<div>
								<form:input type="text" path="confine" class="binput w100" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-3 lbl">نوع ملک</div>
						<div class="col-xs-6">
							<div class="select-wrapper">

								<form:select path="kindCase.idKindCase" class="binput w100">
									<form:options items="${listkindCase}" itemValue="idKindCase"
										itemLabel="nameKindCase" />
								</form:select>

							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-3 lbl">نوع معامله</div>
						<div class="col-xs-6">
							<div class="select-wrapper">

								<form:select path="kindRequest.idKindRequest"
									id="kindRequestCombo" class="binput w100">
									<form:options items="${listkindRequest}"
										itemValue="idKindRequest" itemLabel="nameKindRequest" />
								</form:select>

							</div>
						</div>
					</div>

				</div>
				<div class="col-md-5 col-xs-12">
					<div class="row">
						<div class="col-xs-1">
							<i class="fa fa-search fa-2x"></i>
						</div>
						<div class="col-xs-11">
							<input type="text" id="pac-input" autocomplete="off"
								placeholder="برای تسریع عملیات، منطقه موردنظر خود را وارد کنید.   مثال: نارمک"
								lang="fa" class="form-control input-sm binput"
								name="district_title" value="" style="height: 35px" />

						</div>
					</div>
					
					 <div>
						 <a id="find-loc" href="#" title="پیدا کردن محل کنونی"> 
						 <i class="fa fa-crosshairs fa-4"></i>
						</a>
						 <div id="gMap" style="width: 100%; height: 300px"></div> 
					</div>
					
				</div>
			</div>
			<div role="tabpanel" class="tab-pane" id="me_props">
				<div
					class="col-lg-8 col-md-10 col-lg-offset-2 col-md-offset-1 col-xs-12"
					style="margin-bottom: 100px">
					<div class="col-md-5 col-xs-12">
						<div class="row">
							<div class="col-xs-5 lbl">متراژ</div>
							<div class="col-xs-7">
								<form:input path="metraj" required="required" type="number"
									class="binput form-control" min="0" max="10000" />
							</div>
						</div>
						<div class="row">
							<div class="col-xs-5 lbl">مبلغ کل(تومان)</div>
							<div class="col-xs-7">
								<form:input path="price1" required="required"
									class="binput form-control price required" />
							</div>
						</div>
						<div class="row" id="price2Div" style="display: none">
							<div class="col-xs-5 lbl">مبلغ اجاره(تومان)</div>
							<div class="col-xs-7">
								<form:input path="price2"  type="text"
									class="binput form-control price" />
							</div>
						</div>


						<div class="row">
							<div class="col-xs-5 lbl">سن بنا</div>
							<div class="col-xs-7">
								<form:input path="age" type="number" class="binput form-control" />
							</div>
						</div>

						<div class="row">
							<div class="col-xs-5 lbl">تعداد خواب</div>
							<div class="col-xs-7">
								<form:input path="countBed" type="number"
									class="binput form-control" min="0" max="10" />
							</div>
						</div>

						<div class="row">
							<div class="col-xs-5 lbl">تعداد طبقات</div>
							<div class="col-xs-7">
								<form:input path="countFloor" type="number"
									class="binput form-control" min="0" max="100" />
							</div>
						</div>

						<div class="row">
							<div class="col-xs-5 lbl">طبقه</div>
							<div class="col-xs-7">
								<form:input path="floor" type="text"
									class="binput form-control"  />
							</div>
						</div>

						<div class="row">
							<div class="col-xs-5 lbl">تعداد واحدها</div>
							<div class="col-xs-7">
								<form:input path="countUnit" type="number"
									class="binput form-control" min="0" max="100" />
							</div>
						</div>

						<div class="row">
							<div class="col-xs-5 lbl">واحد</div>
							<div class="col-xs-7">
								<form:input path="Unit" type="number"
									class="binput form-control" min="0" max="100" />
							</div>
						</div>

						<div class="row">
							<div class="col-xs-5 lbl">مساحت زمین</div>
							<div class="col-xs-7">
								<form:input path="masahat" type="number"
									class="binput form-control" min="0" max="10000" />
							</div>
						</div>




					</div>
					<div class="col-md-6 col-xs-12 col-md-offset-1">


						<div class="row">
							<div class="col-xs-5 lbl">نما</div>
							<div class="col-xs-7">
								<div class="select-wrapper">

									<form:select path="nama.fID" class="binput w100">
										<form:options items="${listNama}" itemValue="fID"
											itemLabel="namaName" />
									</form:select>

								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-xs-5 lbl">جهت ملک</div>
							<div class="col-xs-7">
								<div class="select-wrapper">

									<form:select path="caseSide.fID" class="binput w100">
										<form:options items="${listcaseSide}" itemValue="fID"
											itemLabel="name" />
									</form:select>

								</div>

							</div>
						</div>



						<div class="row">
							<div class="col-xs-5 lbl">نوع کف</div>
							<div class="col-xs-7">
								<div class="select-wrapper">

									<form:select path="roof.fID" class="binput w100">
										<form:options items="${listRoof}" itemValue="fID"
											itemLabel="nameRoof" />
									</form:select>

								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-5 lbl">نوع آشپزخانه</div>
							<div class="col-xs-7">
								<div class="select-wrapper">
									<form:select path="kitchen.fID" class="binput w100">
										<form:options items="${listKitchen}" itemValue="fID"
											itemLabel="kitchenName" />
									</form:select>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-5 lbl">نوع کابینت</div>
							<div class="col-xs-7">
								<div class="select-wrapper">

									<form:select path="cabinet.fID" class="binput w100">
										<form:options items="${listCabinet}" itemValue="fID"
											itemLabel="cabinetName" />
									</form:select>

								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-5 lbl">نوع پنجره</div>
							<div class="col-xs-7">
								<div class="select-wrapper">

									<form:select path="windows.fID" class="binput w100">
										<form:options items="${listWindows}" itemValue="fID"
											itemLabel="windowsName" />
									</form:select>

								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-5 lbl">سرویس بهداشتی</div>
							<div class="col-xs-7">
								<div class="select-wrapper">

									<form:select path="service.fID" class="binput w100">
										<form:options items="${listService}" itemValue="fID"
											itemLabel="serviceName" />
									</form:select>

								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-5 lbl">گرمایش</div>
							<div class="col-xs-7">
								<div class="select-wrapper">

									<form:select path="systemG.fID" class="binput w100">
										<form:options items="${listSystemG}" itemValue="fID"
											itemLabel="systemGName" />
									</form:select>

								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-5 lbl">سرمایش</div>
							<div class="col-xs-7">
								<div class="select-wrapper">

									<form:select path="systemS.fID" class="binput w100">
										<form:options items="${listSystemS}" itemValue="fID"
											itemLabel="systemSName" />
									</form:select>

								</div>
							</div>
						</div>


					</div>
				</div>
				<div class="clearfix"></div>

				<div class="col-md-10 col-md-offset-1 col-xs-12 row">
					<div class="col-xs-12">
						<div>
							<i class="fa fa-map-marker red"></i>&nbsp; توضیحات:
						</div>
						<form:textarea path="Comment" class="binput form-control"
							style="height:100px" />

					</div>
				</div>

				<div class="clearfix"></div>

				<div class="col-md-10 col-md-offset-1 col-xs-12 row center">
					<div class="prop-cont" title="پارکینگ">
						<form:checkbox path="parking"  />
						<div class="check_st"></div>
						<i class="prop prop-parking"></i>
					</div>
					<div class="prop-cont" title="پله اظطراری">
						<form:checkbox path="pele"  />
						<div class="check_st"></div>
						<i class="prop prop-1_png_3_"></i>
					</div>
					<div class="prop-cont" title="آنتن مرکزی">
						<form:checkbox path="anten"  />
						<div class="check_st"></div>
						<i class="prop prop-wifi"></i>
					</div>
					<div class="prop-cont" title="درب ریموت">
						<form:checkbox path="door"  />
						<div class="check_st"></div>
						<i class="prop prop-door"></i>
					</div>
					<div class="prop-cont" title="پاسیو">
						<form:checkbox path="pasio"  />
						<div class="check_st"></div>
						<i class="prop prop-flower"></i>
					</div>
					<div class="prop-cont" title="آیفون تصویری">
						<form:checkbox path="iphone" />
						<div class="check_st"></div>
						<i class="prop prop-iphone"></i>
					</div>
					<div class="prop-cont" title="آسانسور">
						<form:checkbox path="elevator" />
						<div class="check_st"></div>
						<i class="prop prop-elevator"></i>
					</div>
					<div class="prop-cont" title="دوربین">
						<form:checkbox path="camera"  />
						<div class="check_st"></div>
						<i class="prop prop-camera"></i>
					</div>
					<div class="prop-cont" title="شومینه">
						<form:checkbox path="shomineh"  />
						<div class="check_st"></div>
						<i class="prop prop-fireplace"></i>
					</div>
					<div class="prop-cont" title="مبله">
						<form:checkbox path="furned"  />
						<div class="check_st"></div>
						<i class="prop prop-furnished"></i>
					</div>
					<div class="prop-cont" title="تلفن">
						<form:checkbox path="tel"  />
						<div class="check_st"></div>
						<i class="prop prop-tel"></i>
					</div>
					<div class="prop-cont" title="انباری">
						<form:checkbox path="storage"  />
						<div class="check_st"></div>
						<i class="prop prop-track"></i>
					</div>
					<div class="prop-cont" title="سرایدار">
						<form:checkbox path="negahban"  />
						<div class="check_st"></div>
						<i class="prop prop-janitor"></i>
					</div>
					<div class="prop-cont" title="استخر">
						<form:checkbox path="pool" value="1" />
						<div class="check_st"></div>
						<i class="prop prop-swim"></i>
					</div>
					<div class="prop-cont" title="شوتینگ زباله">
						<form:checkbox path="shooting"  />
						<div class="check_st"></div>
						<i class="prop prop-doc"></i>
					</div>
					<div class="prop-cont" title="لابی">
						<form:checkbox path="loby"  />
						<div class="check_st"></div>
						<i class="prop prop-pack"></i>
					</div>
					<div class="prop-cont" title="گاز رومیزی">
						<form:checkbox path="gas"  />
						<div class="check_st"></div>
						<i class="prop prop-gas"></i>
					</div>
					<div class="prop-cont" title="اطقا حریق">
						<form:checkbox path="fire"  />
						<div class="check_st"></div>
						<i class="prop prop-lamp"></i>
					</div>
					<div class="prop-cont" title="جکوزی">
						<form:checkbox path="sona"  />
						<div class="check_st"></div>
						<i class="prop prop-jacuzzi"></i>
					</div>
					<div class="prop-cont" title="تخلیه">
						<form:checkbox path="takhlie"  />
						<div class="check_st"></div>
						<i class="prop prop-home"></i>
					</div>

				</div>
				<div class="clearfix"></div>

			</div>

			<div role="tabpanel" class="tab-pane" id="images">
				<div class="col-lg-10 col-lg-offset-1 col-xs-12">
					<div class="col-md-6 col-xs-12 center"
						style="padding-top: 60px; font-size: 1.3em">
						تصاویر ملک خود را در این مکان بارگذاری کنید <br> <span
							class="smaller"> (حجم هریک از تصاویر وارد شده نهایتا باید
							دو مگابایت باشد) </span>
					</div>
					<div class="col-md-6 col-xs-12 row">
						<div class="up_img">
							<input type="file" name="file"> <img
								src="${pageContext.request.contextPath}/resources/img/icons.png"
								alt="تصویر فایل" /> <i class="fa fa-camera fa-3x"></i> <a
								href="#" class="btn btn-danger remove"><i
								class="fa fa-times"></i></a>
						</div>
						<div class="up_img">
							<input type="file" name="file"> <img
								src="${pageContext.request.contextPath}/resources/img/icons.png"
								alt="تصویر فایل" /> <i class="fa fa-camera fa-3x"></i> <a
								href="#" class="btn btn-danger remove"><i
								class="fa fa-times"></i></a>
						</div>
						<div class="up_img">
							<input type="file" name="file"> <img
								src="${pageContext.request.contextPath}/resources/img/icons.png"
								alt="تصویر فایل" /> <i class="fa fa-camera fa-3x"></i> <a
								href="#" class="btn btn-danger remove"><i
								class="fa fa-times"></i></a>
						</div>
						<div class="up_img">
							<input type="file" name="file"> <img
								src="${pageContext.request.contextPath}/resources/img/icons.png"
								alt="تصویر فایل" /> <i class="fa fa-camera fa-3x"></i> <a
								href="#" class="btn btn-danger remove"><i
								class="fa fa-times"></i></a>
						</div>
						<div class="up_img">
							<input type="file" name="file"> <img
								src="${pageContext.request.contextPath}/resources/img/icons.png"
								alt="تصویر فایل" /> <i class="fa fa-camera fa-3x"></i> <a
								href="#" class="btn btn-danger remove"><i
								class="fa fa-times"></i></a>
						</div>
						<div class="up_img">
							<input type="file" name="file"> <img
								src="${pageContext.request.contextPath}/resources/img/icons.png"
								alt="تصویر فایل" /> <i class="fa fa-camera fa-3x"></i> <a
								href="#" class="btn btn-danger remove"><i
								class="fa fa-times"></i></a>
						</div>
						<div class="up_img">
							<input type="file" name="file"> <img
								src="${pageContext.request.contextPath}/resources/img/icons.png"
								alt="تصویر فایل" /> <i class="fa fa-camera fa-3x"></i> <a
								href="#" class="btn btn-danger remove"><i
								class="fa fa-times"></i></a>
						</div>
						<div class="up_img">
							<input type="file" name="file"> <img
								src="${pageContext.request.contextPath}/resources/img/icons.png"
								alt="تصویر فایل" /> <i class="fa fa-camera fa-3x"></i> <a
								href="#" class="btn btn-danger remove"><i
								class="fa fa-times"></i></a>
						</div>
						<div class="up_img">
							<input type="file" name="file"> <img
								src="${pageContext.request.contextPath}/resources/img/icons.png"
								alt="تصویر فایل" /> <i class="fa fa-camera fa-3x"></i> <a
								href="#" class="btn btn-danger remove"><i
								class="fa fa-times"></i></a>
						</div>
					</div>
				</div>
			</div>

			<div role="tabpanel" class="tab-pane" id="ma_props">
				<div class="col-md-10 col-md-offset-1 col-xs-12">

					<div class="col-md-9 col-xs-12 ">
						<div class="col-xs-12 row">
							<h3>ثبت مشخصات مالک</h3>
						</div>
						<div class="row">
							<div class="col-xs-5 lbl">نام مالک</div>
							<div class="col-xs-7">
								<form:input path="Users.family"  type="text"
									class="binput form-control namereq" />
							</div>
						</div>
						<div class="row">
							<div class="col-xs-5 lbl">شماره ثابت</div>
							<div class="col-xs-7">
								<form:input path="Users.tel" type="text"
									class="binput form-control number required" maxlength="10" />
							</div>
						</div>
						<div class="row">
							<div class="col-xs-5 lbl">شماره موبایل</div>
							<div class="col-xs-7">
								<form:input path="Users.mobile" required="required" type="text"
									class="binput form-control mobilereq number required"
									maxlength="11" />
							</div>
						</div>
					</div>

					<div class="col-xs-12" style="margin-top: 20px">
						<div class="col-xs-12 center">آدرس ایمیل خود را جهت عضویت در
							سایت و دریافت لینک ویرایش وارد نمایید:</div>
						<div class="col-md-8 col-md-offset-2 col-xs-12">
							<form:input path="Users.emailAdd" type="email"
								class="form-control binput" lang="en" />
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="col-xs-12">
			<div id="tab-controller" class="center">
				<a href="#" class="prev" data-toggle="tab"><i
					class="fa fa-chevron-right"></i></a> <a href="#" class="next"
					data-toggle="tab"><i class="fa fa-chevron-left"></i></a>
				<button type="submit" name="submit" class="btn btn-default"
					style="display: none">
					<i class="fa fa-check"></i>
				</button>
			</div>
		</div>
	</form:form>

	<div style="clear: both"></div>
</div>

<div id="edit_img" class="modal fade" tabindex="-1" role="dialog"
	style="height: 80%">
	<div class="modal-dialog center" style="height: 100%">
		<div class="modal-content" style="height: 100%">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body" style="height: calc(100% - 144px)"></div>
			<div class="modal-footer r">
				<button id="btn-crop" type="button" class="btn btn-success">
					<i class="fa fa-check white"></i>
				</button>
				<button type="button" class="btn btn-danger" data-dismiss="modal">
					<i class="fa fa-times white"></i>
				</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<script src="${pageContext.request.contextPath}/resources/js/cropper.js"></script>


	
<script>
 $(document).ready(function(){
	var geocoder, gmap, marker;
	var markersArray = [];
	var prprt_longitude = 0,
		prprt_latitude = 0,
		position = null;
	var find_loc = $('#find-loc');

	function getLocation(show,error) {
		if (navigator.geolocation) {
			navigator.geolocation.getCurrentPosition(show,error);
		} else {
			alert("مرورگر شما این قابلیت را پشتیبانی نمی کند!");
		}
	}
	function initialize() {

		geocoder = new google.maps.Geocoder();
		var mapProp = {
			center: new google.maps.LatLng(35.67291625588, 51.451721191406),
			zoom: 10,
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
		};
		if (prprt_latitude > 0) {
			mapProp.center = position;
			mapProp.zoom = 16;
		}
		gmap = new google.maps.Map(document.getElementById("gMap"), mapProp);



		if (prprt_latitude > 0) {
			var marker = new google.maps.Marker({
				position: position,
				map: gmap,
				title: 'موقعیت ملک'
			});
			markersArray.push(marker);
		}


		function get_place_name(latlng) {
			geocoder.geocode({'latLng': latlng}, function (results, status) {
				if (status == google.maps.GeocoderStatus.OK) {
					var reg = /، /g;
					if (results[0]) {
						if(reg.test(results[0].formatted_address)) {
							var str = results[0].formatted_address.replace(/، /g, '،').split('،');
						}else{
							var str = results[0].formatted_address.replace(/, /g, ',').split(',');
						}
						var uniqueNames = [];
						$.each(str, function (i, el) {
							if ($.inArray(el, uniqueNames) === -1) uniqueNames.push(el);
						});
						uniqueNames.splice(uniqueNames.indexOf(reg.test(results[0].formatted_address) ? 'ایران' : 'Iran'), 1);
						str = uniqueNames.join('، ');
						try {
							
							address.val(str);
							pac_input.val(str);

						} catch (ex) {
							;
						}
					}
					
				} 
			})
		}

		google.maps.event.addListener(gmap, "click", function (event) {
			if (gmap.getZoom() >= 16) {
				deleteOverlays();
				var marker = new google.maps.Marker({
					position: event.latLng,
					map: gmap,
					title: 'موقعیت ملک'
				});
				markersArray.push(marker);
				$('#latitude').val(event.latLng.lat());
				$('#longitude').val(event.latLng.lng());
				get_place_name(event.latLng);

			} else {
				var pt = new google.maps.LatLng(event.latLng.lat(), event.latLng.lng());
				gmap.setCenter(pt);
				gmap.setZoom(gmap.getZoom() + 3);
			}
		});

		var input = (document.getElementById('pac-input'));
		//gmap.controls[google.maps.ControlPosition.TOP_LEFT].push($(input).parent()[0]);
		var searchBox = new google.maps.places.SearchBox((input));

		google.maps.event.addListener(searchBox, 'places_changed', function () {
			var places = searchBox.getPlaces();
			if (places.length == 0) {
				return;
			}
			var bounds = new google.maps.LatLngBounds();
			for (var i = 0, place; place = places[i]; i++) {
				bounds.extend(place.geometry.location);
			}
			gmap.fitBounds(bounds);
			gmap.setZoom(15);
		});
		find_loc.show();



	}
	$('#pac-input').keypress(function (e) {
		if (e.keyCode == 13) {
			e.preventDefault();
		}
	});
	function deleteOverlays() {
		if (markersArray) {
			for (var i in markersArray) {
				markersArray[i].setMap(null);
			}
			markersArray.length = 0;
		}
	}


	google.maps.event.addDomListener(window, 'load', initialize);


	find_loc.on('click', function () {
		function show_map(position){
			position = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
			gmap.setCenter(position);
			gmap.setZoom(14);
			var marker = new google.maps.Marker({
				position: position,
				map: gmap,
				title: 'موقعیت شما'
			});
			markersArray.push(marker);
		}
		getLocation(show_map);
	});
	//-------------------------------------------------
	function get_file_ext(filename){
		return (/[.]/.exec(filename)) ? /[^.]+$/.exec(filename) : undefined;
	}
	function is_img(ext){
		var img_ext = Array('jpg','jpeg','gif','png','bmp','swf','JPG','JPEG','GIF','PNG','BMP','SWF');
		if(ext) {
			for (var i in img_ext) {
				if (img_ext[i] == ext)
					return true;
			}
		}
		return false;
	}
	var cropper;
	var ifile = null;
	var img;
	$(edit_img).on('shown.bs.modal',function(){
		var image = img;
		if(cropper)
			cropper.destroy();
		cropper = new Cropper(image);
	});
	$('.up_img input[type="file"]').on('change', function (e) {
		if (this.files && this.files[0]) {
			var $this = this;
			ifile = this;
			if(is_img(get_file_ext(this.files[0].name))) {
				var maxfilesize = 2048 * 1024;
				if (maxfilesize == 0 || this.files[0].size <= maxfilesize) {
					var FR = new FileReader();
					if (edit_img.querySelector('img')) {
						img = edit_img.querySelector('img');
					} else {
						img = document.createElement('img');
						edit_img.querySelector('.modal-body').appendChild(img);
					}
					
					FR.onload = function (e) {
						img.src = e.target.result;
						$(edit_img).modal('show');
						//$this.parentNode.className += ' img';
						//img.style.marginBottom = img.style.marginTop = Math.abs($this.parentNode.clientHeight - img.height) / 2;
						
					};
					FR.readAsDataURL(this.files[0]);
				} else {
					alert(('فایل باید کوچک تر از 2048 کیلوبایت باشد.'));
				}
			}else{
				alert(('فایل باید با فرمت jpg,png,gif,bmp باشد.'));
			}
		}
	});
	//-----------------------------
	$("#me_props").find('.prop-cont').tooltip({
		container:'body'
		,trigger:'hover'
	});
	//----------------------------

	var fd = new FormData(document.forms['form-add']);

	function dataURItoBlob(dataURI) {
		// convert base64/URLEncoded data component to raw binary data held in a string
		var byteString;
		if (dataURI.split(',')[0].indexOf('base64') >= 0)
			byteString = atob(dataURI.split(',')[1]);
		else
			byteString = unescape(dataURI.split(',')[1]);

		// separate out the mime component
		var mimeString = dataURI.split(',')[0].split(':')[1].split(';')[0];

		// write the bytes of the string to a typed array
		var ia = new Uint8Array(byteString.length);
		for (var i = 0; i < byteString.length; i++) {
			ia[i] = byteString.charCodeAt(i);
		}

		return new Blob([ia], {type:mimeString});

	}
	
	document.getElementById('btn-crop').addEventListener('click',function(e){
		var base_64 = cropper.getCroppedCanvas().toDataURL('image/jpeg');
		var img_ = $(ifile).siblings('img')
		img_.attr('src',base_64).parent().addClass('img');
		var blob =dataURItoBlob(base_64);
		fd.delete("file-"+$(ifile).parent().index());
		fd.append("file-"+$(ifile).parent().index(), blob);
		ifile = null;
		$(edit_img).modal('hide');
	});
	
	
	
	
	function setChangeInvalid(e) {
		e.target.checkValidity();
	}
	var invalidEl;
	function setInvalid(e,i){
		e.target.setCustomValidity("");
		console.log(e.target)
		
		invalid = false;
		field = e.target;
		for(var j in field.validity){
			if(j!='customError' && j!='valid' && field.validity[j]){
				invalid = true;
				if(j=='valueMissing' && e.target.value!=''){
					invalid = false;
				}
			}
		}
		if (!e.target.validity.valid && invalid) {
			var msg = "مقدار این فیلد معتبر نمی باشد";
			if (!$(e.target).is('textarea')) {
				if (e.target.attributes['type'].value == 'email')
					msg = ".آدرس ایمیل وارد شده معتبر نمی باشد";
				if (e.target.attributes['type'].value == 'url')
					msg = ".آدرس وبگاه معتبر نمی باشد";
			}
			var tab = $(e.target).closest('.tab-pane');
			if (tab.length) {
				var $this = $(e.target);
				if(tab.hasClass('active')){
					$this.focus();
				}else{
					var h = '#' + tab.attr('id');
					tab.closest('.tabbable').children('ul').find('li > a[href="' + h + '"]').trigger('click').on('shown.bs.tab', function () {
						$this.focus();
					});
				}
			}
			e.target.setCustomValidity(msg);
			
			invalidEl.off('invalid');
			return false;
		}
		
		
		return !invalid;
	}
	function hack_browser_msg() {
		invalidEl = $(document.forms['form-add']).find('input:invalid, textarea:invalid');
		invalidEl.on('invalid', function(e){
			var invalid = false;
			/*field = e.target;
			for(var j in field.validity){
				if(j!='customError' && field.validity[j]){
					invalid = true;
				}
			}
			if(!invalid)*/
			setInvalid(e);
		});
	}
	
	$('form input:invalid, form textarea:invalid').on('change', setChangeInvalid);

	
	 document.forms['form-add'].elements['submit'].addEventListener('click',function(){
		hack_browser_msg(); 
		
	})
		
		 
	function FormValidate(){
		var fields = document.forms['form-add'].querySelectorAll('.namereq');
		if(fields[0].value=='' && fields[1].value==''){
			return false;
		}
		var fields = document.forms['form-add'].querySelectorAll('.mobilereq');
		if(fields[0].value=='' && fields[1].value==''){
			return false;
		}
		return true;
	}
		
	 document.forms['form-add'].addEventListener('submit',function(e){
			if(FormValidate()){
				/*e.preventDefault();
				 $.ajax({
					url: '${addAction}',
					data: fd,
					processData: false,
					contentType: false,
					type: 'POST',
					success: function(data){
						alert(data);
					}
				});  */
				$('#form-add').submit();
				
				
			}else{
				alert("لطفا اطلاعات مشاور و یا مالک را تکمیل بفرمایید!");
				e.preventDefault();
				return false;
			}
		})
	
	//-------------------------------------
	var tab_controllers = $('#tab-controller').children();
	var tab_container = document.querySelector('#body').querySelector('.nav-tabs');
	
	tab_controllers.filter('a').on('click',function(e){
		e.preventDefault();
		var active = tab_container.querySelector('li.active');
		var target;
		if($(this).hasClass('next')){
			target = $(active).next().find('a');
		}else if($(this).hasClass('prev')){
			target = $(active).prev().find('a');
		}
		if(target && target.length){
			target.tab('show');
		}
	});
	
	
	$(tab_container).find('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
		e.target // newly activated tab
		e.relatedTarget // previous active tab
		var cu_index = $(this.parentNode).index();
		var length = $(tab_container).children().length;
		if(cu_index == length - 1){
			tab_controllers.filter('button[type="submit"]').show();
			tab_controllers.filter('.next').hide();
		}else{
			tab_controllers.filter('button[type="submit"]').hide();
			tab_controllers.filter('.next').show();
		}
	})
	//------------------------------------------------------------
	$('.up_img > .remove').on('click',function(e){
		e.preventDefault();
		$(this).siblings('img').removeAttr('src').parent().removeClass('img');
		fd.delete("file-"+$(this).parent().index());
	});
	//-------------------------------------------------
	
})
</script>

<script language="JavaScript">
$(function(){
		
		//Province
		$("#province").change(function(e){
			var selected=$(this).val();


			
			var url="city/json/"+selected;
			
			$("#city").empty();
			
			$.getJSON(url,{ajax:'true'},function(data){
				var options;
				options+='<option selected="selected" value="0">انتخاب کنید</option>';
				for(var i=0;i<data.length;i++){
					options+="<option value='"+data[i].idCity+"'>"+data[i].nameCity+"</option>";
				}
				$("#city").html(options);
			});
			
			//$("#city").change();
			resetOpt($("#area"));
			resetOpt($("#zone"));
			 
		});

		//City
		$("#city").change(function(e){
			var selected=$(this).val();


			
			var url="area/json/"+selected;

			 $("#area").empty(); 
			
			$.getJSON(url,{ajax:'true'},function(data){
				var options;
				options+='<option selected="selected" value="0">انتخاب کنید</option>';
				for(var i=0;i<data.length;i++){
					options+="<option value='"+data[i].idArea+"'>"+data[i].nameArea+"</option>";
				}
				$("#area").html(options);
			});
			
			//$("#area").change();
			resetOpt($("#zone"));
		});
		
		//Zone
		$("#area").change(function(e){
			var selected=$(this).val();

		
			
			var url="range/json/"+selected;
			
			 $("#zone").empty(); 

			$.getJSON(url,{ajax:'true'},function(data){
				var options;
				options+='<option selected="selected" value="0">انتخاب کنید</option>';
				for(var i=0;i<data.length;i++){
					options+="<option value='"+data[i].idRange+"'>"+data[i].nameRange+"</option>";
				}
				$("#zone").html(options);
			});
		});
	});
	
	$(document).ready(function(){
		$("#province").change();
	});
	
	
	
	$(document).ready(function(){
	    $('#kindRequestCombo').on('change', function() {
	      if ( this.value == 3)
	      {

	        $("#price2Div").show();
	      }
	      else
	      {

	        $("#price2Div").hide();
	      }
	    });
	});
	
	
	function resetOpt(ref)
	{
		ref.empty(); 
		var options;
		options+='<option selected="selected" value="0">انتخاب کنید</option>';
		ref.html(options);
		
	}
	
	
		
	
	
</script>

	
<%@ include file="./footerMap.jsp"%>

