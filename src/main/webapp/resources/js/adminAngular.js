angular.module('MyApp',['ngMaterial', 'ngMessages', 'material.svgAssetsCache'])
  .controller('AppCtrl', function($scope,$http,$log) {
    


	  $scope.myFunct = function (e, myValue) {
	      var charCode = (e.which) ? e.which : e.keyCode;        
	     
	      if (charCode==13)
	    	  {

			  var ttest=[];
			  var url = "../case/json/"+myValue;
		
			  $http.get(url).then(function(response) {
			          ttest = response.data;
			    $scope.messages =ttest
			       
			      });
	  
	    	  }

	  }

  });


/**
Copyright 2016 Google Inc. All Rights Reserved. 
Use of this source code is governed by an MIT-style license that can be foundin the LICENSE file at http://material.angularjs.org/HEAD/license.
**/