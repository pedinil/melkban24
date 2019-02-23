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

<c:url var="addUrl" value="/addMelk"></c:url>
<c:url var="delUrl" value="/delMelk"></c:url>
<form:form id="form-admin" name="form-admin" action="${addUrl}"
	commandName="melkSave" method="post">

	<div id="main-wrapper" class="col-xs-12">

		<article id="news-detail" class="se-bg">
			<br />

			<form:hidden path="idKnow"/>
	
			<div class="row">
				<div class="col-xs-2 lbl">موضوع</div>
				<div class="col-xs-7">
					<form:input path="subjectKnow" type="text"
						class="binput form-control" />
				</div>
			</div>



			<br />

			<div id="news-body row">
				متن نمایش
				<form:textarea path="bodyKnow" name="textarea" class="jqte-test" />
			</div>


			<div class="clearfix"></div>
			<button type="submit" formaction="${addUrl}">ذخیره</button>
			<c:if test="${melkSave.subjectKnow !=null}">
				<button type="submit" formaction="${delUrl}">حذف</button>
			</c:if>

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