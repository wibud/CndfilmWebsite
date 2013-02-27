<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*" %>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <title>错误页面</title>
    
    <!-- css -->
    <link href="./css/bootstrap.css" rel="stylesheet">
    <link href="./css/bootstrap-responsive.css" rel="stylesheet">
    <link href="./css/docs.css" rel="stylesheet">
    
    <!-- js -->
    <script type="text/javascript" src="./js/jquery.js"></script>
    <script type="text/javascript" src="./js/bootstrap.js"></script>
    
  </head>
  <body style="background:url(./img/bg-login.gif);">
  	<div class="container" style="width:980px;height:600px;background:url(./img/login-background.png) no-repeat center top">
  		<div class="row" style="padding-top:100px;">
  			<div class="span8" style="padding-left:270px;">
  				<img src="./img/rare-logo.png"/>
  			</div>
  		</div>
  		<div style="text-align:center;padding-top:40px;">
  			<h2 style="color:#fff"><img src="./img/warning.png" />您指定的网页无法访问！</h2>
  		</div>
  		<div class="row" style="padding-top:40px;">
  			<div class="span5" style="padding-left:550px">
  				<button id="reset" class="btn" type="button"><i class="icon-share"></i>后退</button>
  			</div>
  		</div>
  	</div>
  	
  	<script type="text/javascript">
  	 $(document).ready(function(){
		$('#reset').click(function(){
			history.back();
		});
  	 });
  	</script>
  </body>
</html>
