<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*" %>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <title>管理员登陆</title>
    
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
  		<form action="/login" name="loginform">
  			<div class="row" style="padding-top:20px">
  				<div class="span3" style="padding-left:360px;">
  					<div class="alert alert-error fade hide" style="width:220px;">
  						<a class="close" data-dismiss="alert" href="#">×</a>
  						<img src="./img/cross_circle.png"/>
  						<strong id="errormsg"><s:property value="errormsg"/></strong>
  					</div>
  				</div>
  			</div>
  			<div class="row" style="padding-top:10px;">
	  			<div class="span6" style="padding-left:400px">
	  				<div class="input-prepend">
	  					 <button id="lableForName" class="btn btn-danger" type="button" style="height:28.5px;"><i class="icon-user icon-white"></i></button><input id="userName" name="userName" type="text" class="input-medium" placeholder="用户名"/>
	  				</div>
	  			</div>
	  		</div>
	  		<div class="row" style="padding-top:30px;">
	  			<div class="span6" style="padding-left:400px">
	  				<div class="input-prepend">
	  					 <button id="lableForPswd" class="btn btn-danger" type="button" style="height:28.5px;"><i class="icon-lock icon-white"></i></button><input id="pswd" name="pswd" type="password" class="input-medium" placeholder="密码"/>
	  				</div>
	  			</div>
	  		</div>
	  		<div class="row" style="padding-top:40px;">
	  			<div class="span5" style="padding-left:445px">
	  				<button id="confirm" class="btn btn-success" type="button"><i class="icon-share icon-white"></i>Login</button>
	  				<button id="reset" class="btn" type="button"><i class="icon-refresh"></i>Reset</button>
	  			</div>
	  		</div>
	  		
  		</form>
  		
  	</div>
  	
  	<script type="text/javascript">
  		
  		 $(document).ready(function(){
  		 	
  		 	if($('#errormsg').text()!=""){
  		 		$('#errormsg').parent(".alert").removeClass('fade hide');
  		 	}
  		 	
  		 	$('#lableForName').click(function(){
  		 		$('#userName').focus();
  		 	});
  		 	
  		 	$('#lableForPswd').click(function(){
  		 		$('#pswd').focus();
  		 	});
  		 	
  		 	$('#confirm').click(function(){
  		 		var userName = $('#userName').val();
  		 		var pswd = $('#pswd').val();
  		 		
  		 		if(userName == ""){
  		 			alert("请输入用户名");
  		 			return;
  		 		}
  		 		
  		 		if(pswd == ""){
  		 			alert("请输入密码");
  		 			return;
  		 		}
  		 		
  		 		document.loginform.submit();
  		 	});
  		 	
  		 	$('#reset').click(function(){
  		 		
  		 		$('#userName').val('');
  		 		$('#pswd').val('');
  		 	});
  		 	
  		 	//监听键盘事件
  		 	$(document).keypress(function(e){
  		 		if(e.which == 13){
  		 			var userName = $('#userName').val();
	  		 		var pswd = $('#pswd').val();
	  		 		
	  		 		if(userName == ""){
	  		 			alert("请输入用户名");
	  		 			return;
	  		 		}
	  		 		
	  		 		if(pswd == ""){
	  		 			alert("请输入密码");
	  		 			return;
	  		 		}
	  		 		
	  		 		document.loginform.submit();
  		 		}
  		 	});
  		 	
  		 });
  	</script>
  </body>
</html>
