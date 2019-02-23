
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<%@ page language="java" contentType="text/html; charset=utf-8" 
   pageEncoding="utf-8"%>
   <%@ include file="./header.jsp" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/panel.css"/>

<div class="tabbable">

  <!-- Nav tabs -->
  <ul class="nav nav-tabs col-md-offset-1 col-md-10" role="tablist">
    <li role="presentation" class="active">
		<a href="#profile" aria-controls="location" role="tab" data-toggle="tab">
			<i class="fa fa-map-marker"></i>
			<span>ويرايش مشخصات</span>
		</a>
	</li>
    <li role="presentation">
		<a href="#moshaver" aria-controls="me_props" role="tab" data-toggle="tab">
			<i class="fa fa-map-marker"></i>
			<span>تعريف مشاوران</span>
		</a>
	</li>
    <li role="presentation">
		<a href="#finance" aria-controls="images" role="tab" data-toggle="tab">
			<i class="fa fa-map-marker"></i>
			<span>آرشيو مالی</span>
		</a>
	</li>
    <li role="presentation">
		<a href="#work" role="tab" data-toggle="tab">
			<i class="fa fa-map-marker"></i>
			<span>آرشيو کاری</span>
		</a>
	</li>
	<li role="presentation">
		<a href="#charge" role="tab" data-toggle="tab">
			<i class="fa fa-map-marker"></i>
			<span>شارژ حساب</span>
		</a>
	</li>
	<li role="presentation">
		<a href="#">
			<i class="fa fa-map-marker"></i>
			<span>خروج</span>
		</a>
	</li>
  </ul>

  <div class="clearfix"></div>
  
  <div id="hint" class="center">
	املاک گرامی
	<span class="name">
	خوانساری
	</span>
	
	<span class="city">
	(تهران)
	</span>
	
	به بخش مشاوران سابت خوش آمدید، تعداد روز مانده از حساب شما
	
	<span> 0 </span>
  </div>
  
	<div class="tab-content">
	  
		<div role="tabpanel" class="tab-pane fade in active" id="profile">
		
		</div>
		
		<div role="tabpanel" class="tab-pane fade" id="moshaver">
			<div class="main-tab-wrapper col-xs-12">
				<div class="col-xs-12">
				در صورتی که تمایل به عدم ورود یکی از مشاوران خود دارید، رمز عبور وی را تغییر دهید
				</div>
				<div class="clearfix"></div>
				<form method="post" action="./Panel.php" name="form-moshaver">
					<div class="form-field">
						<div class="lbl col-md-12 col-xs-4">
							کلمه کاربری
						</div>
						<div class="col-md-6 col-xs-8 field">
							<input class="form-control" required type="text" name="username" lang="en"/>
						</div>
						
						<div class="clearfix"></div>
					</div>
					
					<div class="form-field">
						<div class="lbl col-md-12 col-xs-4">
							نام
						</div>
						<div class="col-md-6 col-xs-8 field">
							<input class="form-control" required type="text" name="name" lang="en"/>
						</div>
						
						<div class="clearfix"></div>
					</div>
					
					<div class="form-field">
						<div class="lbl col-md-12 col-xs-4">
							تلفن
						</div>
						<div class="col-md-6 col-xs-8 field">
							<input class="form-control" required type="text" name="tel" lang="en"/>
						</div>
						
						<div class="clearfix"></div>
					</div>
					
					<div class="form-field">
						<div class="lbl col-md-12 col-xs-4">
							موبایل
						</div>
						<div class="col-md-6 col-xs-8 field">
							<input class="form-control" required type="text" name="mobile" maxlength="11" lang="en"/>
						</div>
						
						<div class="clearfix"></div>
					</div>
					
					<div class="form-field">
						<div class="lbl col-md-12 col-xs-4">
							رمز عبور
						</div>
						<div class="col-md-6 col-xs-8 field">
							<input class="form-control" type="password" name="password" lang="en"/>
						</div>
						<div class="col-md-6 col-xs-8">
						ترکیبی از حروف انگلیسی و اعداد
						</div>
						
						<div class="clearfix"></div>
					</div>
					
					<div class="form-field">
						<div class="lbl col-md-12 col-xs-4">
							تکرار رمز عبور
						</div>
						<div class="col-md-6 col-xs-8 field">
							<input class="form-control" type="password" name="password-match" lang="en"/>
						</div>
						
						<div class="clearfix"></div>
					</div>
					
					<br/>
					
					<div class="col-md-6 col-xs-12">
						<div id="success-moshaver">
							<i class="fa fa-check"></i>
							عملیات انجام گردید
						</div>
					</div>
					
					<div id="moshaver-actions" class="col-md-6">
						
						<div class="action grbwb grlbl">
							<input type="submit" class="grbwb grlbl" name="edit" value="ویرایش"/>
						</div>
						
						<div class="action grbwb grlbl">
							<input type="submit" class="grbwb grlbl" name="login" value="ورود"/>
						</div>
						
						<div class="action grbwb grlbl">
							<input type="submit" name="newCode" value="تولید کد جدید"/>
						</div>
					</div>
				</form>
				
				<div id="search-moshaver" class="col-xs-12">
					<form method="post" action="./Panel.php">
						<div>
							<span>
							نام مشاور:
							</span>
							
							&nbsp;
							
							<input class="binput" type="text" name="name"/>
							
							<button type="submit">
								<i class="fa fa-search fa-flip-horizontal"></i>
							</button>
							
							<button type="reset">
								<i class="fa fa-reply fa-flip-horizontal"></i>
							</button>
						</div>
						<div class="clearfix"></div>
					</form>
				</div>
				
				<div id="moshaver-grid" class="grid col-md-offset-2 col-md-8">
					<table class="table table-striped">
						<colgroup>
							<col style="width:23%"/>
							<col style="width:22%"/>
							<col style="width:23%"/>
							<col style="width:22%"/>
							<col style="width:10%"/>
						</colgroup>
						<tbody>
							<tr>
								<td class="username persian">284923472</td>
								<td class="name">حامد</td>
								<td class="tel persian">021234765482</td>
								<td class="mobile persian">09124537624</td>
								<td>
									<a href="#" class="btn btn-default fill-moshaver">
										کلیک کنید
									</a>
								</td>
							</tr>
							<tr>
								<td class="username persian">284923472</td>
								<td class="name">حامد</td>
								<td class="tel persian">021234765482</td>
								<td class="mobile persian">09124537624</td>
								<td>
									<a href="#" class="btn btn-default fill-moshaver">
										کلیک کنید
									</a>
								</td>
							</tr>
							<tr>
								<td class="username persian">284923472</td>
								<td class="name">حامد</td>
								<td class="tel persian">021234765482</td>
								<td class="mobile persian">09124537624</td>
								<td>
									<a href="#" class="btn btn-default fill-moshaver">
										کلیک کنید
									</a>
								</td>
							</tr>
							<tr>
								<td class="username persian">284923472</td>
								<td class="name">حامد</td>
								<td class="tel persian">021234765482</td>
								<td class="mobile persian">09124537624</td>
								<td>
									<a href="#" class="btn btn-default fill-moshaver">
										کلیک کنید
									</a>
								</td>
							</tr>
							<tr>
								<td class="username persian">284923472</td>
								<td class="name">حامد</td>
								<td class="tel persian">021234765482</td>
								<td class="mobile persian">09124537624</td>
								<td>
									<a href="#" class="btn btn-default fill-moshaver">
										کلیک کنید
									</a>
								</td>
							</tr>
							<tr>
								<td class="username persian">284923472</td>
								<td class="name">حامد</td>
								<td class="tel persian">021234765482</td>
								<td class="mobile persian">09124537624</td>
								<td>
									<a href="#" class="btn btn-default fill-moshaver">
										کلیک کنید
									</a>
								</td>
							</tr>
							<tr>
								<td class="username persian">284923472</td>
								<td class="name">حامد</td>
								<td class="tel persian">021234765482</td>
								<td class="mobile persian">09124537624</td>
								<td>
									<a href="#" class="btn btn-default fill-moshaver">
										کلیک کنید
									</a>
								</td>
							</tr>
							<tr>
								<td class="username persian">284923472</td>
								<td class="name">حامد</td>
								<td class="tel persian">021234765482</td>
								<td class="mobile persian">09124537624</td>
								<td>
									<a href="#" class="btn btn-default fill-moshaver">
										کلیک کنید
									</a>
								</td>
							</tr>
							<tr>
								<td class="username persian">284923472</td>
								<td class="name">حامد</td>
								<td class="tel persian">021234765482</td>
								<td class="mobile persian">09124537624</td>
								<td>
									<a href="#" class="btn btn-default fill-moshaver">
										کلیک کنید
									</a>
								</td>
							</tr>
							<tr>
								<td class="username persian">284923472</td>
								<td class="name">حامد</td>
								<td class="tel persian">021234765482</td>
								<td class="mobile persian">09124537624</td>
								<td>
									<a href="#" class="btn btn-default fill-moshaver">
										کلیک کنید
									</a>
								</td>
							</tr>
							<tr>
								<td class="username persian">284923472</td>
								<td class="name">حامد</td>
								<td class="tel persian">021234765482</td>
								<td class="mobile persian">09124537624</td>
								<td>
									<a href="#" class="btn btn-default fill-moshaver">
										کلیک کنید
									</a>
								</td>
							</tr>
							<tr>
								<td class="username persian">284923472</td>
								<td class="name">حامد</td>
								<td class="tel persian">021234765482</td>
								<td class="mobile persian">09124537624</td>
								<td>
									<a href="#" class="btn btn-default fill-moshaver">
										کلیک کنید
									</a>
								</td>
							</tr>
							<tr>
								<td class="username persian">284923472</td>
								<td class="name">حامد</td>
								<td class="tel persian">021234765482</td>
								<td class="mobile persian">09124537624</td>
								<td>
									<a href="#" class="btn btn-default fill-moshaver">
										کلیک کنید
									</a>
								</td>
							</tr>
							<tr>
								<td class="username persian">284923472</td>
								<td class="name">حامد</td>
								<td class="tel persian">021234765482</td>
								<td class="mobile persian">09124537624</td>
								<td>
									<a href="#" class="btn btn-default fill-moshaver">
										کلیک کنید
									</a>
								</td>
							</tr>
							<tr>
								<td class="username persian">284923472</td>
								<td class="name">حامد</td>
								<td class="tel persian">021234765482</td>
								<td class="mobile persian">09124537624</td>
								<td>
									<a href="#" class="btn btn-default fill-moshaver">
										کلیک کنید
									</a>
								</td>
							</tr>
							<tr>
								<td class="username persian">284923472</td>
								<td class="name">حامد</td>
								<td class="tel persian">021234765482</td>
								<td class="mobile persian">09124537624</td>
								<td>
									<a href="#" class="btn btn-default fill-moshaver">
										کلیک کنید
									</a>
								</td>
							</tr>
							<tr>
								<td class="username persian">284923472</td>
								<td class="name">حامد</td>
								<td class="tel persian">021234765482</td>
								<td class="mobile persian">09124537624</td>
								<td>
									<a href="#" class="btn btn-default fill-moshaver">
										کلیک کنید
									</a>
								</td>
							</tr>
							<tr>
								<td class="username persian">284923472</td>
								<td class="name">حامد</td>
								<td class="tel persian">021234765482</td>
								<td class="mobile persian">09124537624</td>
								<td>
									<a href="#" class="btn btn-default fill-moshaver">
										کلیک کنید
									</a>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				
				<div class="clearfix"></div>
			</div>
		</div>

		<div role="tabpanel" class="tab-pane fade" id="finance">
			
		</div>
		
		<div role="tabpanel" class="tab-pane" id="work">
			<div class="main-tab-wrapper col-xs-12">
				<div class="table grid">
					<div class="province row">
						<div class="col-md-2 col-xs-2">
							<div>
								نام استان
							</div>
						</div>
						<div class="col-md-2 col-xs-2">
							تهران
						</div>
						<div class="col-md-2 col-xs-2">
							تهران
						</div>
						<div class="col-md-2 col-xs-2">
							تهران
						</div>
						<div class="col-md-2 col-xs-2">
							تهران
						</div>
						<div class="col-md-2 col-xs-2">
							تهران
						</div>
					</div>
					
					<div class="area row">
						<div class="col-md-2 col-xs-2">
							<div>
								نام منطقه
							</div>
						</div>
						<div class="col-md-2 col-xs-2">
							تهران
						</div>
						<div class="col-md-2 col-xs-2">
							تهران
						</div>
						<div class="col-md-2 col-xs-2">
							تهران
						</div>
						<div class="col-md-2 col-xs-2">
							تهران
						</div>
						<div class="col-md-2 col-xs-2">
							تهران
						</div>
					</div>
					
					<div class="range row">
						<div class="col-md-2 col-xs-2">
							<div>
								نام محدوده
							</div>
						</div>
						<div class="col-md-2 col-xs-2">
							تهران
						</div>
						<div class="col-md-2 col-xs-2">
							تهران
						</div>
						<div class="col-md-2 col-xs-2">
							تهران
						</div>
						<div class="col-md-2 col-xs-2">
							تهران
						</div>
						<div class="col-md-2 col-xs-2">
							تهران
						</div>
					</div>
					
					<div class="file row">
						<div class="col-md-2 col-xs-2">
							<div>
								نوع فایل
							</div>
						</div>
						<div class="col-md-2 col-xs-2">
							تهران
						</div>
						<div class="col-md-2 col-xs-2">
							تهران
						</div>
						<div class="col-md-2 col-xs-2">
							تهران
						</div>
						<div class="col-md-2 col-xs-2">
							تهران
						</div>
						<div class="col-md-2 col-xs-2">
							تهران
						</div>
					</div>
					
					<div class="metr row">
						<div class="col-md-2 col-xs-2">
							<div>
								متراژ
							</div>
						</div>
						<div class="col-md-2 col-xs-2">
							تهران
						</div>
						<div class="col-md-2 col-xs-2">
							تهران
						</div>
						<div class="col-md-2 col-xs-2">
							تهران
						</div>
						<div class="col-md-2 col-xs-2">
							تهران
						</div>
						<div class="col-md-2 col-xs-2">
							تهران
						</div>
					</div>
					
					<div class="price-row row">
						<div class="col-md-2 col-xs-2">
							<div>
								قیمت
							</div>
						</div>
						<div class="col-md-2 col-xs-2 persian">
							100000
						</div>
						<div class="col-md-2 col-xs-2 persian">
							100000
						</div>
						<div class="col-md-2 col-xs-2 persian">
							100000
						</div>
						<div class="col-md-2 col-xs-2 persian">
							100000
						</div>
						<div class="col-md-2 col-xs-2 persian">
							100000
						</div>
					</div>
					
					<div class="rent row">
						<div class="col-md-2 col-xs-2">
							<div>
								اجاره
							</div>
						</div>
						<div class="col-md-2 col-xs-2 persian">
							100000
						</div>
						<div class="col-md-2 col-xs-2 persian">
							100000
						</div>
						<div class="col-md-2 col-xs-2 persian">
							100000
						</div>
						<div class="col-md-2 col-xs-2 persian">
							100000
						</div>
						<div class="col-md-2 col-xs-2 persian">
							100000
						</div>
					</div>
					
					<div class="floors-count row">
						<div class="col-md-2 col-xs-2">
							<div>
								تعداد طبقات
							</div>
						</div>
						<div class="col-md-2 col-xs-2 persian">
							100000
						</div>
						<div class="col-md-2 col-xs-2 persian">
							100000
						</div>
						<div class="col-md-2 col-xs-2 persian">
							100000
						</div>
						<div class="col-md-2 col-xs-2 persian">
							100000
						</div>
						<div class="col-md-2 col-xs-2 persian">
							100000
						</div>
					</div>
					
					<div class="floor row">
						<div class="col-md-2 col-xs-2">
							<div>
								طبقه
							</div>
						</div>
						<div class="col-md-2 col-xs-2 persian">
							1
						</div>
						<div class="col-md-2 col-xs-2 persian">
							1
						</div>
						<div class="col-md-2 col-xs-2 persian">
							1
						</div>
						<div class="col-md-2 col-xs-2 persian">
							1
						</div>
						<div class="col-md-2 col-xs-2 persian">
							1
						</div>
					</div>
					
					<div class="unit-count row">
						<div class="col-md-2 col-xs-2">
							<div>
								تعداد واحدها
							</div>
						</div>
						<div class="col-md-2 col-xs-2 persian">
							1
						</div>
						<div class="col-md-2 col-xs-2 persian">
							1
						</div>
						<div class="col-md-2 col-xs-2 persian">
							1
						</div>
						<div class="col-md-2 col-xs-2 persian">
							1
						</div>
						<div class="col-md-2 col-xs-2 persian">
							1
						</div>
					</div>
					
					<div class="unit row">
						<div class="col-md-2 col-xs-2">
							<div>
								واحد
							</div>
						</div>
						<div class="col-md-2 col-xs-2 persian">
							1
						</div>
						<div class="col-md-2 col-xs-2 persian">
							1
						</div>
						<div class="col-md-2 col-xs-2 persian">
							1
						</div>
						<div class="col-md-2 col-xs-2 persian">
							1
						</div>
						<div class="col-md-2 col-xs-2 persian">
							1
						</div>
					</div>
					
					<div class="geography row">
						<div class="col-md-2 col-xs-2">
							<div>
								وضعیت جغرافیایی
							</div>
						</div>
						<div class="col-md-2 col-xs-2 persian">
							1
						</div>
						<div class="col-md-2 col-xs-2 persian">
							1
						</div>
						<div class="col-md-2 col-xs-2 persian">
							1
						</div>
						<div class="col-md-2 col-xs-2 persian">
							1
						</div>
						<div class="col-md-2 col-xs-2 persian">
							1
						</div>
					</div>
					
					<div class="room row">
						<div class="col-md-2 col-xs-2">
							<div>
								تعداد خواب
							</div>
						</div>
						<div class="col-md-2 col-xs-2 persian">
							1
						</div>
						<div class="col-md-2 col-xs-2 persian">
							1
						</div>
						<div class="col-md-2 col-xs-2 persian">
							1
						</div>
						<div class="col-md-2 col-xs-2 persian">
							1
						</div>
						<div class="col-md-2 col-xs-2 persian">
							1
						</div>
					</div>
					
					<div class="parking row">
						<div class="col-md-2 col-xs-2">
							<div>
								پارکینگ
							</div>
						</div>
						<div class="col-md-2 col-xs-2 persian">
							<i class="fa fa-check"></i>
						</div>
						<div class="col-md-2 col-xs-2 persian">
							<i class="fa fa-check"></i>
						</div>
						<div class="col-md-2 col-xs-2 persian">
							<i class="fa fa-check"></i>
						</div>
						<div class="col-md-2 col-xs-2 persian">
							<i class="fa fa-check"></i>
						</div>
						<div class="col-md-2 col-xs-2 persian">
							<i class="fa fa-check"></i>
						</div>
					</div>
					
					<div class="warehouse row">
						<div class="col-md-2 col-xs-2">
							<div>
								انباری
							</div>
						</div>
						<div class="col-md-2 col-xs-2 persian">
							<i class="fa fa-check"></i>
						</div>
						<div class="col-md-2 col-xs-2 persian">
							<i class="fa fa-check"></i>
						</div>
						<div class="col-md-2 col-xs-2 persian">
							<i class="fa fa-check"></i>
						</div>
						<div class="col-md-2 col-xs-2 persian">
							<i class="fa fa-check"></i>
						</div>
						<div class="col-md-2 col-xs-2 persian">
							<i class="fa fa-check"></i>
						</div>
					</div>
					
					<div class="elevator row">
						<div class="col-md-2 col-xs-2">
							<div>
								آسانسور
							</div>
						</div>
						<div class="col-md-2 col-xs-2 persian">
							<i class="fa fa-check"></i>
						</div>
						<div class="col-md-2 col-xs-2 persian">
							<i class="fa fa-check"></i>
						</div>
						<div class="col-md-2 col-xs-2 persian">
							<i class="fa fa-check"></i>
						</div>
						<div class="col-md-2 col-xs-2 persian">
							<i class="fa fa-check"></i>
						</div>
						<div class="col-md-2 col-xs-2 persian">
							<i class="fa fa-check"></i>
						</div>
					</div>
					
					<div class="number row">
						<div class="col-md-2 col-xs-2">
							<div>
								نمره فایل
							</div>
						</div>
						<div class="col-md-2 col-xs-2 persian">
							1
						</div>
						<div class="col-md-2 col-xs-2 persian">
							2
						</div>
						<div class="col-md-2 col-xs-2 persian">
							1
						</div>
						<div class="col-md-2 col-xs-2 persian">
							4
						</div>
						<div class="col-md-2 col-xs-2 persian">
							2
						</div>
					</div>
					
					<div class="voter row">
						<div class="col-md-2 col-xs-2">
							<div>
								تعداد رای دهنده
							</div>
						</div>
						<div class="col-md-2 col-xs-2 persian">
							1
						</div>
						<div class="col-md-2 col-xs-2 persian">
							2
						</div>
						<div class="col-md-2 col-xs-2 persian">
							1
						</div>
						<div class="col-md-2 col-xs-2 persian">
							4
						</div>
						<div class="col-md-2 col-xs-2 persian">
							2
						</div>
					</div>
					
					<div class="voter row">
						<div class="col-md-2 col-xs-2">
							<div>
								مشاور
							</div>
						</div>
						<div class="col-md-2 col-xs-2">
							شمس
						</div>
						<div class="col-md-2 col-xs-2">
							شمس
						</div>
						<div class="col-md-2 col-xs-2">
							شمس
						</div>
						<div class="col-md-2 col-xs-2">
							شمس
						</div>
						<div class="col-md-2 col-xs-2">
							شمس
						</div>
					</div>
				
				</div>
				
				<div id="pager" class="col-lg-8 col-lg-offset-2 col-xs-12">
					<a href="#" class="back control">
						<i class="fa fa-chevron-right"></i>
					</a>
					
					<ul>
						<li>
							<a href="#">
								<i class="fa fa-circle active"></i>
								<span class="num">&nbsp;<span>
							</a>
						</li>
						<li>
							<a href="#">
								<i class="fa fa-circle"></i>
								<span class="num">&nbsp;<span>
							</a>
						</li>
						<li>
							<a href="#">
								<i class="fa fa-circle"></i>
								<span class="num">&nbsp;<span>
							</a>
						</li>
					</ul>
					
					<a href="#" class="next control">
						<i class="fa fa-chevron-left"></i>
					</a>
				</div>
				
			</div>
		</div>
		
		
		<div role="tabpanel" class="tab-pane fade" id="charge">
		
		</div>
		
		
	</div>
	
	
	<div class="clearfix"></div>
</div>

<script>
$(document).ready(function(){
	
	//--------------------------------------------
	$('.fill-moshaver').on('click',function(e){
		e.preventDefault();
		var tr = $(this).closest('tr');
		document.forms['form-moshaver'].elements['username'].value = tr.find('.username').text();
		document.forms['form-moshaver'].elements['name'].value = tr.find('.name').text();
		document.forms['form-moshaver'].elements['tel'].value = tr.find('.tel').text();
		document.forms['form-moshaver'].elements['mobile'].value = tr.find('.mobile').text();
	})
	//--------------------------------------------
		function setChangeInvalid(e) {
		e.target.checkValidity();
	}
	var invalidEl;
	function setInvalid(e,i){
		e.target.setCustomValidity("");
		
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
	var forms = document.forms;
	
	function hack_browser_msg() {
		for(var i=0; i<forms.length; i++){
			invalidEl = $(forms[i]).find('input:invalid, textarea:invalid');
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
	}
	
	hack_browser_msg();
	
	$('form input:invalid, form textarea:invalid').on('change', setChangeInvalid);

	//----------------submit form moshaver
	document.forms['form-moshaver'].addEventListener('submit',function(e){
		var password = this.elements['password'].value;
		var passwordMatch = this.elements['password-match'].value;
		if(password.length){
			if(password != passwordMatch){
				e.preventDefault();
				$(password).focus();
				alert('رمز عبور و تکرار آن می بایست یکسان باشند!');
				return false;
			}
		}
	})

})
</script>
<%@ include file="./footer.jsp" %>
