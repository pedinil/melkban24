<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%@ page language="java" contentType="text/html; charset=utf-8" 
   pageEncoding="utf-8"%>
   <%@ include file="./header.jsp" %>
   
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-te-1.4.0.css">  
   <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/cropper.css" >


  
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin.css"/>


<c:url var="addUrl" value="/addNews"></c:url>
<c:url var="delUrl" value="/delNews"></c:url>
 <form:form id="form-admin" name="form-admin"  action="${addUrl}" commandName="newsSave" method="post" enctype="multipart/form-data" >

<div id="main-wrapper" class="col-xs-12">
		
	<article id="news-detail" class="se-bg">
		
		<form:hidden path="idNews"/>
		<form:hidden path="imageNews"/>
		
		 <div role="tabpanel" class="tab-pane row" id="images">
			 <div class="up_img">
						<input type="file" name="file">
						<img src="${pageContext.request.contextPath}/resources/img/icons.png" alt="تصویر فایل"/>
						<i class="fa fa-camera fa-3x"></i>
						<a href="#" class="btn btn-danger remove"><i class="fa fa-times"></i></a>
			</div>
			
			
		</div>
	
				<div class="row">
						<div class="col-xs-2 lbl">
						 تاریخ
						</div>
						<div class="col-xs-7">
							<form:input path="dateNews" type="text" class="binput form-control"  />
						</div>
				</div>
		
	
			<br/>

		<div class="row">
						<div class="col-xs-2 lbl">
						 موضوع
						</div>
						<div class="col-xs-7">
							<form:input path="subjectNews" type="text" class="binput form-control"  />
						</div>
		</div>
	       
	 
		
<br/>
	
		<div id="news-body row">
			متن نمایش
			  <form:textarea path="bodyNews" name="textarea" class="jqte-test"/>
		</div>
	
		
		<div class="clearfix"></div>
		<button type="submit" formaction="${addUrl}">ذخیره</button>
		<c:if test="${newsSave.subjectNews !=null}">
			<button type="submit" formaction="${delUrl}">حذف</button>
		</c:if>
		<div class="clearfix"></div>
		<div class="clearfix"></div>
		
	</article>
	
	<div class="clearfix"></div>
	
		
	
	
</div>
		

</form:form>


<div id="edit_img" class="modal fade" tabindex="-1" role="dialog" style="height:80%">
  <div class="modal-dialog center" style="height:100%">
    <div class="modal-content" style="height:100%">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
      </div>
      <div class="modal-body" style="height:calc(100% - 144px)">
        
      </div>
      <div class="modal-footer r">
        <button id="btn-crop" type="button" class="btn btn-success">
			<i class="fa fa-check white"></i>
		</button>
        <button type="button" class="btn btn-danger" data-dismiss="modal">
			<i class="fa fa-times white"></i>
		</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script src="${pageContext.request.contextPath}/resources/js/cropper.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-te-1.4.0.min.js" charset="utf-8"></script>

<script>

$(document).ready(function(){
		
	
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
				var maxfilesize = 40 * 1024;
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
					alert(('فایل باید کوچک تر از 40 کیلوبایت باشد.'));
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
	
	var fd = new FormData(document.forms['form-admin']);

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
	
	
	$('.up_img > .remove').on('click',function(e){
		e.preventDefault();
		$(this).siblings('img').removeAttr('src').parent().removeClass('img');
		fd.delete("file-"+$(this).parent().index());
	});
	
	
	
	});



	$('.jqte-test').jqte();
	
	// settings of status
	var jqteStatus = true;
	$(".status").click(function()
	{
		jqteStatus = jqteStatus ? false : true;
		$('.jqte-test').jqte({"status" : jqteStatus})
	});
	
	
	
	

	
</script>



<%@ include file="./footer.jsp" %>