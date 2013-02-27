$(document).ready(function(){
	
	var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/; //验证邮箱的正则表达式
	
	$('#registerButton').click(function(){
		
		var userName = $('#userName').val();
		var pswd = $('#pswd').val();
		var assurePswd = $('#assurePswd').val();
		var realName = $('#realName').val();
		var workPlace = $('#workPlace').val();
		var dept = $('#dept').val();
		var certNumber = $('#certNumber').val();
		var email = $('#email').val();
		var tel = $('#tel').val();
		
		if(userName==""){
			$('#userNameError').removeClass('hidden');
			return;
		}
		if(pswd==""){
			$('#pswdError').removeClass('hidden');
			return;
		}
		if(assurePswd==""){
			$('#assurePswdError').removeClass('hidden');
			return;
		}
		if(realName==""){
			$('#realNameError').removeClass('hidden');
			return;
		}
		if(workPlace==""){
			$('#workPlaceError').removeClass('hidden');
			return;
		}
		if(dept==""){
			$('#deptError').removeClass('hidden');
			return;
		}
		if(certNumber==""){
			$('#certNumberError').removeClass('hidden');
			return;
		}
		if(email==""){
			$('#emailError').removeClass('hidden');
			return;
		}
		if(tel==""){
			$('#telError').removeClass('hidden');
			return;
		}
		
		if(!reg.test(email)){
			$('#emailError').removeClass('hidden');
			return;
		}
		
		if(pswd!=assurePswd){
			alert("确认密码不正确");
			return;
		}
		
		$.ajax({
			  type: 'post',
			  async: false,
			  url: "checkUserName",
			  dataType: 'json',
			  data: {'userName':userName},
			  success: function(back){
					var error = back.errormsg;
					if(error!=""){
						alert(error);
					}else{
						var options = {
					  		success: function(back){
							
						  			alert("注册成功！");
								},
							error: function(){
									alert("服务器正忙");
								},
							clearForm: true	
					  	};
						
					  	$('#registerForm').ajaxSubmit(options);
					}
					
				},
			  error: function(){
					alert("服务器正忙");
				}
		});
		
	});
	
	$('#userName').blur(function(){
		
		var userName = $('#userName').val();
		if(userName!=""){
			if(!$('#userNameError').hasClass('hidden')){
				$('#userNameError').addClass('hidden');
			}
		}
	});
	
	$('#pswd').blur(function(){
		
		var pswd = $('#pswd').val();
		if(pswd!=""){
			if(!$('#pswdError').hasClass('hidden')){
				$('#pswdError').addClass('hidden');
			}
		}
	});

	$('#assurePswd').blur(function(){
		
		var assurePswd = $('#assurePswd').val();
		if(assurePswd!=""){
			if(!$('#assurePswdError').hasClass('hidden')){
				$('#assurePswdError').addClass('hidden');
			}
		}
	});
	
	$('#realName').blur(function(){
		
		var realName = $('#realName').val();
		if(realName!=""){
			if(!$('#realNameError').hasClass('hidden')){
				$('#realNameError').addClass('hidden');
			}
		}
	});
	
	$('#workPlace').blur(function(){
		
		var workPlace = $('#workPlace').val();
		if(workPlace!=""){
			if(!$('#workPlaceError').hasClass('hidden')){
				$('#workPlaceError').addClass('hidden');
			}
		}
	});
	
	$('#dept').blur(function(){
		
		var dept = $('#dept').val();
		if(dept!=""){
			if(!$('#deptError').hasClass('hidden')){
				$('#deptError').addClass('hidden');
			}
		}
	});
	
	$('#certNumber').blur(function(){
		
		var certNumber = $('#certNumber').val();
		if(certNumber!=""){
			if(!$('#certNumberError').hasClass('hidden')){
				$('#certNumberError').addClass('hidden');
			}
		}
	});
	
	$('#email').blur(function(){
		
		var email = $('#email').val();
		if(email!=""){
			if(!$('#emailError').hasClass('hidden')){
				if(reg.test(email)){
					$('#emailError').addClass('hidden');
				}
			}
		}
		
	});
	
	$('#tel').blur(function(){
		
		var tel = $('#tel').val();
		if(tel!=""){
			if(!$('#telError').hasClass('hidden')){
				$('#telError').addClass('hidden');
			}
		}
	});
});