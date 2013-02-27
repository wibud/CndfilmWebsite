$(document).ready(function() {
	
	$('#loginButton').click(function(){
		
		var userName = $('#loginUserName').val();
		var pswd = $('#loginPswd').val();
		
		if(userName==""){
			alert("用户名不能为空！");
			return;
		}
		if(pswd==""){
			alert("密码不能为空！");
			return;
		}
		
		$.ajax({
			  type: 'post',
			  async: false,
			  url: "userLogin",
			  dataType: 'json',
			  data: {'userName':userName,'pswd':pswd},
			  success: function(back){
					var errormsg = back.errormsg;
					
					if(errormsg==""){
						
						window.location.reload();
					}else{
						alert(errormsg);
					}
					
				},
			  error: function(){
					alert("服务器正忙");
				}
		});
	});
	
	$('#modifyPswdButton').click(function(){
		
		var newPswd = $('#loginNewPswd').val();
		var assurePswd = $('#loginAssurePswd').val();
		
		if(newPswd=="" || assurePswd==""){
			alert("输入内容不能为空");
			return;
		}
		if(newPswd!=assurePswd){
			alert("确认密码不正确");
			return;
		}
		
		$.ajax({
			  type: 'post',
			  async: false,
			  url: "userModifyPswd",
			  dataType: 'json',
			  data: {'newPswd':newPswd},
			  success: function(){
					
					alert("修改成功");
				},
			  error: function(){
					alert("服务器正忙");
				}
		});
	});
});