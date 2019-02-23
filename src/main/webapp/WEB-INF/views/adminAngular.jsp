<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Basic Usage</title>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700,400italic">
  
  <link rel='stylesheet prefetch' href='https://cdn.gitcdn.link/cdn/angular/bower-material/v1.1.3/angular-material.css'>
<link rel='stylesheet prefetch' href='https://material.angularjs.org/1.1.3/docs.css'>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
     

  
</head>

<body>
  <div ng-controller="AppCtrl" ng-cloak="" class="dividerdemoBasicUsage , carddemoBasicUsage" ng-app="MyApp">
    <md-content class="md-padding" layout-xs="column" layout="row">


      <div flex-xs="" flex-gt-xs="100" layout="column">
    <md-toolbar >
    <h2 >
      <span ><strong><center>صفحه جستجوی ملک</center></strong></span>
    </h2>


    


  </md-toolbar>
        <div class="container">

     
            <div class="dropdown">
            <div align="center">
            <input style="width: 20%; float: right;" 
       ng-model="que.SelectedOptionsUID" 
       type="text" 
       ng-keypress="myFunct($event, que.SelectedOptionsUID)"/>
       
          </div>

         
          </div>
        </div>
    
  
    
      <md-list>
      <md-list-item class="md-3-line" ng-repeat="item in messages">
  <div flex-xs="" flex-gt-xs="50" layout="column" >
      
    

    <md-card md-theme="{{ showDarkTheme ? 'dark-purple' : 'default' }}" md-theme-watch="">
        <md-card-title>
          <md-card-title-text>
            <span class="md-headline">{{item.dateIn}}</span>
 
          </md-card-title-text>
         
          <md-card-title-media>
           
            
               <md-card-avatar>
			      <img class="md-user-avatar" src="{{item.pic1}}">
			    </md-card-avatar>
             
          </md-card-title-media>
        </md-card-title>
        <md-card-actions  >
          <!-- <md-button ng-href="melk/melkoffer/{{item.idCase}}">{{item.idCase}}</md-button> -->
           <md-button ng-href="http://melkban24.ir/melkoffer/{{item.idCase}}">{{item.idCase}}</md-button>
           
	          <div layout="row">
	        <md-label> موبایل: </md-label>  <md-label> {{item.users.mobile}}</md-label> 
	         </div>
	         
	         <div layout="row">
	         <md-label> فامیلی: </md-label> <md-label> {{item.users.family}}</md-label>  
	          </div>
         
          
        </md-card-actions>
      </md-card>
</div>

        <md-divider ng-if="!$last"></md-divider>
      </md-list-item>
    </md-list>

  </md-content>



 
</div>

<!--
Copyright 2016 Google Inc. All Rights Reserved. 
Use of this source code is governed by an MIT-style license that can be foundin the LICENSE file at http://material.angularjs.org/HEAD/license.
-->
  <script src='https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.js'></script>
<script src='https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-animate.min.js'></script>
<script src='https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-route.min.js'></script>
<script src='https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-aria.min.js'></script>
<script src='https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-messages.min.js'></script>
<script src='https://s3-us-west-2.amazonaws.com/s.cdpn.io/t-114/svg-assets-cache.js'></script>
<script src='https://cdn.gitcdn.link/cdn/angular/bower-material/v1.1.3/angular-material.js'></script>

    <script src="${pageContext.request.contextPath}/resources/js/adminAngular.js"></script>

</body>
</html>
