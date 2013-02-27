$(document).ready(function() {
	
	var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/; //验证邮箱的正则表达式
	
	$('#sendMessage').click(function(){
		
		var userName = $('#userName').val();
		var userEmail = $('#userEmail').val();
		var message = $('#message').val();
		
		if(userName==""){
			$('#nameError').removeClass('hidden');
			return;
		}
		
		if(userEmail==""){
			$('#emailError').removeClass('hidden');
			return;
		}
		
		if(message==""){
			$('#messageError').removeClass('hidden');
			return;
		}
		
		if(!reg.test(userEmail)){
			$('#emailError').removeClass('hidden');
			return;
		}
		
		$.ajax({
			  type: 'post',
			  async: false,
			  url: "sendMessage",
			  dataType: 'json',
			  data: {'userName':userName,'userEmail':userEmail,'message':message},
			  success: function(){
					
					alert("发送成功！");
				},
			  error: function(){
					alert("服务器正忙");
				}
		});
	});
	
	$('#userName').blur(function(){
		
		var userName = $('#userName').val();
		if(userName!=""){
			if(!$('#nameError').hasClass('hidden')){
				$('#nameError').addClass('hidden');
			}
		}
	});
	
	$('#userEmail').blur(function(){
		
		var userEmail = $('#userEmail').val();
		if(userEmail!=""){
			if(!$('#emailError').hasClass('hidden')){
				if(reg.test(userEmail)){
					$('#emailError').addClass('hidden');
				}
			}
		}
	});

	$('#message').blur(function(){
		
		var message = $('#message').val();
		if(message!=""){
			if(!$('#messageError').hasClass('hidden')){
				$('#messageError').addClass('hidden');
			}
		}
	});
});