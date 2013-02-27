<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <title>首页</title>
    
    <!-- css -->
    <link href="./css/bootstrap.css" rel="stylesheet">
    <link href="./css/bootstrap-responsive.css" rel="stylesheet">
    <link href="./css/docs.css" rel="stylesheet">
    
    <!-- slider css -->
    <link href="./css/slider.css" rel="stylesheet">
    
    <!-- js -->
    <script src="./js/jquery.js"></script>
    <script src="./js/bootstrap.js"></script>
    
    <!--slider js  -->
    <script type="text/javascript" src="./js/jquery.nivo.slider.js"></script>
    <script type="text/javascript" src="./js/cufon-yui.js"></script>
	<script type="text/javascript" src="./js/scripts.js"></script>
	<script type="text/javascript" src="./js/custom.js"></script>
    
  </head>
  <body style="background-color:#f5f5f5;">
  	
  	<!--logo  -->
  	<div class="container" style="width:1150px">
  		
		<div class="row">
			<div class="span8" ><img src='./img/logo.png'/></div>
			
		</div>
  	</div>
  	<!-- /logo -->
  	<!-- navbar -->
  	<div class="container" style="width:980px;">
  		
  		<div class="row" style="padding-top:20px">
  			<!--  <div class="span1" style="visibility:hidden;">navbar</div>-->
  			<div class="span12">
  				<div class="subnav">
  					<div class="row">
  						<div class="span6">
						    <ul class="nav nav-pills">
						      <li class="active"><a href="#"><i class="icon-home icon-white"></i>Home</a></li>
						      <li><a href="#">Films</a></li>
						      <li><a href="#">Search</a></li>
						      <li><a href="#">Contact us</a></li>
						    </ul>
					    </div>
					    <div class="span6" style="padding-top:3px">
					    	<div class="input-append" style="text-align:right;padding-right:7px">
					    		<input type="text" class="span2" placeholder="Search here"><button class="btn btn-danger" type="button" style="height:28px;"><i class="icon-search icon-white"></i></button>
					    	</div>
					    </div>
				    </div>
			  	</div>
  			</div>
  		</div>
  	</div>
  	<!-- /navbar -->
  	
  	<!--Slider-->
  	<div style="padding-top:30px">
  		<div class="clear" id="slider-bg">
			<div class="full-width-wrapper" id="slider-frame">
				<div class="fixed-width-wrapper maxx-theme" id="slider-wrapper">
					<div id="slider" class="nivoSlider">
						<a href="#"><img src="./img/slide1.jpg" alt="" title="#htmlcaption"></a>
						<a href="#"><img src="./img/slide2.jpg" alt="" title=""></a>
						<a href="#"><img src="./img/slide3.jpg" alt="" title="#htmlcaption2"></a>
						<a href="#"><img src="./img/slide4.jpg" alt="" title=""></a>
						<a href="#"><img src="./img/slide5.jpg" alt="" title="#htmlcaption3"></a>
					</div>
					<div id="htmlcaption" class="nivo-html-caption">
						<h1>Lorem ipsum dolor sit amet</h1><strong>This</strong> is an example of a <em>HTML</em> caption with <a href="#">a link</a>. 
					</div>
					<div id="htmlcaption2" class="nivo-html-caption">
						<h1>Lorem ipsum dolor sit amet</h1><strong>This</strong> is an example of a <em>HTML</em> caption with <a href="#">a link</a>.
					</div>
					<div id="htmlcaption3" class="nivo-html-caption">
						<h1>Lorem ipsum dolor sit amet</h1><strong>This</strong> is an example of a <em>HTML</em> caption with <a href="#">a link</a>.                
					</div>
				</div>
			</div>
		</div>
  	</div>
	<!-- /Slider -->
	
	<!-- container -->
	<div class="container" style="width:980px;">
		<div class="body-divider"></div>
		<div>
		
		</div>
	</div>
  	<!-- /container -->
  </body>
</html>
