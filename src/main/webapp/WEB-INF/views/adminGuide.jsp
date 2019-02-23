<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="./header.jsp"%>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/jquery-te-1.4.0.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/admin.css" />

<c:url var="ActionUrl" value="/addGuide"></c:url>
<form:form id="form-admin" name="form-admin" action="${ActionUrl}"
	commandName="guideSave" method="post">

	<div id="main-wrapper" class="col-xs-12">

		<article id="news-detail" class="se-bg">
			<br />

			<div class="row">
				<div class="col-xs-3 lbl">شهر</div>
				<div class="col-xs-6">
					<div class="select-wrapper">

						<form:select path="city.idCity" id="CityCombo" class="binput w100">
							<form:options items="${listCity}" itemValue="idCity"
								itemLabel="nameCity" />
						</form:select>

					</div>
				</div>
			</div>
			<br />
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



			<br />

			<div id="news-body row">
				متن راهنما
				<form:textarea path="description" name="textarea" class="jqte-test" />
			</div>


			<div class="clearfix"></div>
			<input type="submit" value="ذخیره" class="col-xs-12">

			<div class="clearfix"></div>
			<div class="clearfix"></div>

		</article>

		<div class="clearfix"></div>
	</div>


</form:form>


<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-te-1.4.0.min.js"
	charset="utf-8"></script>

<script>
	$('.jqte-test').jqte();

	// settings of status
	var jqteStatus = true;
	$(".status").click(function() {
		jqteStatus = jqteStatus ? false : true;
		$('.jqte-test').jqte({
			"status" : jqteStatus
		})
	});
</script>



<%@ include file="./footer.jsp"%>