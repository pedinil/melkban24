<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page language="java" contentType="text/html; charset=utf-8" 
   pageEncoding="utf-8"%>

<%@ page session="false"%>

<!DOCTYPE html>
<html lang="fa" dir="rtl">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1">
    <link rel="canonical" href="http://melkban24.ir" />
    <title>${pageTitle}</title>
    <meta name="author" content="ملک بان 24"/>
    <meta name="description" content="${pageDescription}"/>
    <meta name="keywords" content="${pageKeywords}"/>
    <meta name="robots" content="index, follow"/>
    
    <meta name="twitter:card" content="summary">
	<meta name="twitter:site" content="@melkban24">
	<meta name="twitter:title" content="${pageTitle}">
	<meta name="twitter:description" content="${pageDescription}">
	
	<meta property="og:url" content="http://melkban24.ir">
	<meta property="og:title" content="${pageTitle}">
    <meta property="og:description" content="${pageDescription}">
	
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/img/favicon.ico" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/ex_styles.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.12.1.min.js"></script>

<script type="application/ld+json">
  {
    "@context": "http://schema.org",
    "@type": "Blog",
    "url": "http://melkban24.ir/blog/"
  }
</script>
<script type="application/ld+json">
  {
    "@context": "http://schema.org",
    "@type": "Organization",
    "name": "melkban24",
    "url": "http://melkban24.ir",
    "sameAs": [
      "https://www.facebook.com/melkban24.ir",
      "https://plus.google.com/115229317655810421884",
      "https://twitter.com/melkban24",
	  "https://telegram.me/melkban24",
	  "https://www.instagram.com/melkban24.ir",
	  "https://www.linkedin.com/in/melkban24"
    ],
        "contactPoint" : [{
          "@type" : "ContactPoint",
          "url" : "http://melkban24.ir/connectus",
		  "telephone": "+98-021-22144162",
          "contactType" : "Customer service | پشتیبانی"
        }]

  }
</script>

</head>
<body>
<div id="fullpage">
    <header id="header">
		<h1 class="desc col-xs-offset-1 col-md-offset-0">
		
		 	<label>خريد خانه</label>
			<label class="highlight">,اجاره آپارتمان,</label>
			<label>خريد ويلا</label>
		
		</h1>
		<div class="icons hidden-xs">
			<a href="<c:url value="/addfile" />" class="hvr-bounce-in" title="سپردن ملک">
				<i class="icon i-identify-o"></i>
			</a>
			<a href="#" class="hvr-bounce-in logo" title="ملک بان">
				<img src="${pageContext.request.contextPath}/resources/img/logo_s.png" alt="ملک بان 24"/>
			</a>
			<a href="#" class="hvr-bounce-in" title="ورود مشاوران">
				<i class="icon i-malek"></i>
			</a>
	
		</div>
		
		
		
    </header>
    <div class="clearfix"></div>
    <a id="nav-menu" href="#" class="btn btn-default float-r"><i class="fa fa-bars"></i></a>
    <nav id="main_nav">
        <ul>
            <li>
                <a href="<c:url value="/" />">خانه</a>
            </li>
            
             <li>
                <a href="<c:url value="/addfile" />">سپردن ملک</a>
            </li>
            
            <li>
                <a href="<c:url value="/melk" />">دانستني ها</a>
            </li>
            <li>
                <a href="<c:url value="/news" />">آرشيو اخبار</a>
            </li>
            <li>
                <a data-toggle="collapse" data-target="#aboutus">درباره ما</a>
                <ul id="aboutus" class="collapse">
                
                	<li>
                        <a href="<c:url value="/about" />">
                            درباره ما
                        </a>
                    </li>
                    
                    
                    <li>
                        <a href="<c:url value="/aboutdpd" />">
                            درباره دي پي دي
                        </a>
                    </li>
                    
                     <li>
                        <a href="<c:url value="/vision" />">
                            چشم انداز ما
                        </a>
                    </li>
                    
                      <li>
                        <a href="<c:url value="/mission" />">
                            ماموریت ما
                        </a>
                    </li>
                
                
                
                </ul>
            </li>
            <li>
                <a  data-toggle="collapse" data-target="#collapse1">ارتباط با ما</a>
                <ul id="collapse1" class="collapse">
                    <li>
                        <a href="<c:url value="/connectus" />">
                            ارتباط با ما
                        </a>
                    </li>
                    <li>
                        <a href="<c:url value="/melkcooperation" />">
                            همکاري با ما
                        </a>
                    </li>
                </ul>
            </li>
            <li>
                <a data-toggle="collapse" data-target="#collapse2">گالري تصاوير</a>
                <ul id="collapse2" class="collapse">
                    <li>
                        <a href="<c:url value="/gallery/طراحی-آشپزخانه" />">
                            طراحی آشپزخانه
                        </a>
                    </li>
                    <li>
                        <a href="<c:url value="/gallery/طراحی-اتاق-نشیمن" />">
                            طراحی اتاق نشیمن
                        </a>
                    </li>
                    <li>
                        <a href="<c:url value="/gallery/طراحی-اتاق-خواب" />">
                           طراحی اتاق خواب
                        </a>
                    </li>
                    <li>
                        <a href="<c:url value="/gallery/طراحی-داخلی" />">
                           طراحی داخلی
                        </a>
                    </li>
                    <li>
                        <a href="<c:url value="/gallery/سرویس-بهداشتی" />">
                           سرویس بهداشتی
                        </a>
                    </li>
                    <li>
                        <a href="<c:url value="/gallery/حیاط-و-مشاعات" />">
                           حیاط و مشاعات
                        </a>
                    </li>
                    <li>
                        <a href="<c:url value="/gallery/نمای-ساختمان" />">
                           نمای ساختمان
                        </a>
                    </li>
                    <li>
                        <a href="<c:url value="/gallery/طراحی-لابی" />">
                           طراحی لابی
                        </a>
                    </li>
                </ul>
                
            </li>
            
            <li>
                <a data-toggle="collapse" data-target="#collapse3">راهنماي سايت</a>
                <ul id="collapse3" class="collapse">
                    <li>
                        <a href="<c:url value="/melklows" />">
                            قوانین و مقررات
                        </a>
                    </li>
                    
                    <li>
                        <a href="<c:url value="/melkhelp" />">
                            راهنماي سپردن ملک
                        </a>
                    </li>
                    
                    
                    <li>
                        <a href="<c:url value="/melksearchhelp" />">
                            راهنمای جستجوی ملک
                        </a>
                    </li>
                    
                      <li>
                        <a href="<c:url value="/melksite" />">
                            بخشهای مختلف سایت
                        </a>
                    </li>
                    
                 </ul>
                    
            </li>
            <li>
                <a href="<c:url value="/blog" />">بلاگ</a>
            </li>
        </ul>
    </nav>
	<section id="body">