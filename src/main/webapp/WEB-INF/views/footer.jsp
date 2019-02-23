<%@ page language="java" contentType="text/html; charset=utf-8" 
   pageEncoding="utf-8"%>

    
<footer>
	<div id="footer_top">
		<div class="row">
			<div class="col-md-4 col-xs-12">
				<div class="header">
					همراه باشید
				</div>
				<ul id="social">
					<li>
						<a class="icon hvr-pop i-social-sm i-telegram" href="https://telegram.me/melkban24" title="کانال تلگرام"></a>
					</li>
					<!-- <li>
						<a class="icon hvr-pop i-social-sm i-hi5" href="https://plus.google.com/people/find"></a>
					</li> -->
					<li>
						<a class="icon hvr-pop i-social-sm i-google-plus" href="https://plus.google.com/115229317655810421884" title="گوگل پلاس"></a>
					</li>
					<li>
						<a class="icon hvr-pop i-social-sm i-linkedin" href="https://www.linkedin.com/in/melkban24" title="لینکداین"></a>
					</li>
					<li>
						<a class="icon hvr-pop i-social-sm i-twitter" href="https://twitter.com/melkban24
						" title="توییتر"></a>
					</li>
					<li>
						<a class="icon hvr-pop i-social-sm i-facebook" href="https://www.facebook.com/melkban24.ir" title="فیسبوک"></a>
					</li>
					<li>
						<a class="icon hvr-pop i-social-sm i-aparat" href="http://aparat.com/melkban24" title="آپارات"></a>
					</li>
					<li>
						<a class="icon hvr-pop i-social-sm i-instagram" href="http://www.instagram.com/melkban24.ir" title="اینستاگرام"></a>
					</li>
				</ul>
				<div class="clearfix"></div>
				<ul id="apps">
					<li>
						<a class="icon i-apps hvr-pop i-android" href="https://play.google.com/store/apps/details?id=air.com.mteamapps.Melkban24" title="Andorid"></a>
					</li>
					<li>
						<a class="icon i-apps hvr-pop i-iphone" href="https://appsto.re/us/iBEHdb.i" title="IOS"></a>
					</li>
					<li>
						<a class="icon i-apps hvr-pop i-a" href="#" title=""></a>
					</li>
					<li>
						<a class="icon i-apps hvr-pop i-playstore" href="https://play.google.com/store/apps/details?id=air.com.mteamapps.Melkban24" title="Google Play"></a>
					</li>
					<li>
						<a class="icon i-apps hvr-pop i-bazar" href="https://cafebazaar.ir/app/air.com.mteamapps.Melkban24/" title="Cafe Bazaar"></a>
					</li>
					<!-- <li>
						<a class="icon i-apps hvr-pop i-i" href="#" title=""></a>
					</li> -->
				</ul>
				<div class="clearfix"></div>

				<form id="newsletter" action="#" method="get">
					<div>
						برای عضویت در خبرنامه ملک بان ۲۴ ایمیل خود را در این قسمت وارد نمایید.
					</div>
					<div id="submit_cont">
						<input class="inp_submit" type="submit"/>
						<i class="icon submit"></i>
						<input type="email" name="email" class="email form-control l" lang="en"/>
					</div>
				</form>

			</div>
			<div class="col-md-4 col-xs-12">
				<div class="header">
					تماس با ما
				</div>
				<div>
					<div class="icon float-r i-tel"></div>
					<div>02122144162</div>
				</div>
				<div>
					<div class="icon float-r i-fax"></div>
					<div>02122353176</div>
				</div>
				<div class="header">
					ایمیل
				</div>
				<div class="email">
					Info <i class="fa fa-at"></i> melkban24.ir
				</div>
			</div>
			<div class="col-md-4 col-xs-12">
				<div class="header">
					مکان
				</div>
				<div id="googleMap" style="width:100%; height:200px;"></div>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-9">
				<div class="header">
					آدرس
				</div>

				<div>
					<i class="fa fa-map-marker"></i>&nbsp;
					                                تهران-سعادت آباد-علامه شمالی-نبش خیابان 18 غربی-ساختمان سهیل-طبقه 1-واحد 5
				</div>
				<br/>
			</div>
		</div>

	</div>
	<div id="bank">
		<a class="hvr-float-shadow" href="http://www.behpardakht.com" title="به پرداخت">
			<img src="${pageContext.request.contextPath}/resources/img/logo/behpardakht.png" alt="به پرداخت"/>
		</a>
		<a class="hvr-float-shadow" href="http://www.mahak-charity.org" title="موسسه خیریه محک">
			<img src="${pageContext.request.contextPath}/resources/img/logo/mahak.png" alt="موسسه  خیریه  محک"/>
		</a>
		<a class="hvr-float-shadow" href="http://www.parsian-bank.com" title="بانک پارسیان">
			<img src="${pageContext.request.contextPath}/resources/img/logo/parsian.png" alt="بانک پارسیان"/>
		</a>
	</div>
</footer>
</section>
</div>
<div id="backdrop"></div>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

<script
	src="https://maps.googleapis.com/maps/api/js?sensor=false&language=fa&libraries=places&key=AIzaSyDfPamguUxWHifU99A7xQfyH4KrdKhMeFA"  async defer></script>

<script>
	
	
var API_KEY;
var my_location = [35.779865, 51.380360, 'ملکبان'];
function initMap() {
	var mapProp = {
		center: new google.maps.LatLng(my_location[0], my_location[1]),
		zoom: 15,
		scrollwheel:  false,
		scaleControl: false,
		mapTypeId: google.maps.MapTypeId.ROADMAP
	};
	var map = new google.maps.Map(document.getElementById("googleMap"), mapProp);
	var marker;
	var infowindow = new google.maps.InfoWindow({
		content: '<b style="color: #2098d1">&nbsp;&nbsp;&nbsp;&nbsp;' + my_location[2] + '</b>'
	});

	marker = new google.maps.Marker({
		position: new google.maps.LatLng(my_location[0], my_location[1]),
		map: map
	});

	google.maps.event.addListener(marker, 'click', (function (marker) {
		return function () {
			setTimeout(function () {
				infowindow.open(map, marker);
			}, 200)
		}
	})(marker));
}
	
	$(document).ready(function () {
		//--------------------------------------
		var nav_menu = document.getElementById('nav-menu');
		$(nav_menu).on('click', function (e) {
			e.preventDefault();
			this.className += ' focus';
			document.getElementById('backdrop').style.display = 'block';
		})
		$('#backdrop').on('click', function (e) {
			this.style.display = 'none';
			$(nav_menu).removeClass('focus');
		});
		//---------------------
		$(window).load(function () {
			$(document).trigger('scroll');
			initMap();
		});
		//------------------------------------------
		function numberWithCommas(x) {
			return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
		}

		function numberWithoutCommas(x) {
			return x.replace(/,/g, '');
		}

		var price = document.querySelectorAll('.price');
		for (var i = 0; i < price.length; i++) {
			var input = document.createElement('input');
			
			input.setAttribute('type', 'text');
			input.value = numberWithCommas(price[i].getAttribute('value'));
			
			
			input.className = price[i].className + ' fake_price';
		

			 if (price[i].getAttribute('required')) {        
				 
				 input.setAttribute('required', 'required');
				}
				price[i].removeAttribute('required');
			
			
			
			$(input).removeClass('price');
			input.addEventListener('keyup', function (e) {
				var p = this.parentNode.querySelector('.price');
				p.value = numberWithoutCommas(this.value);
				this.value = numberWithCommas(p.value);
			});
			price[i].parentNode.appendChild(input);
			price[i].style.display = 'none';
		}
		//----------------------------------------
		var number = document.querySelectorAll('input.number');
		if (number) {
			for (var i = 0; i < number.length; i++) {
				number[i].addEventListener("keypress", function (evt) {
					if (evt.which < 48  || evt.which > 57 || evt.which==8) {
						evt.preventDefault();
					}
				});
			}
		}

	});

       /*   (function (i, s, o, g, r, a, m) {
             i['GoogleAnalyticsObject'] = r; i[r] = i[r] || function () {
                 (i[r].q = i[r].q || []).push(arguments)
             }, i[r].l = 1 * new Date(); a = s.createElement(o),
  m = s.getElementsByTagName(o)[0]; a.async = 1; a.src = g; m.parentNode.insertBefore(a, m)
         })(window, document, 'script', '//www.google-analytics.com/analytics.js', 'ga');

         ga('create', 'UA-62601658-1', 'auto');
         ga('send', 'pageview'); */

</script> 

</body>
</html>
