$(document).ready(function(){
	
	var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/; //验证邮箱的正则表达式
	$('#editSave').click(function(){
		
		var userName = $('#userName').val();
		var real_name = $('#real_name').val();
		var workplace = $('#workplace').val();
		var dept = $('#dept').val();
		var cert_number = $('#cert_number').val();
		var email = $('#email').val();
		var tel = $('#tel').val();
		
		if(userName==""||real_name==""||workplace==""||dept==""||cert_number==""||email==""||tel==""){
			
			alert("内容不能为空");
			return;
		}
		
		if(!reg.test(email)){
			alert("邮箱格式不正确");
			return;
		}
		
		//提交表单
		var options = {
	  		success: function(back){
			
		  			alert("修改成功！");
					window.location.reload();
				},
			error: function(){
					alert("服务器正忙");
				},
			clearForm: false	
	  	};
		
	  	$('#editUserForm').ajaxSubmit(options);
	});
});