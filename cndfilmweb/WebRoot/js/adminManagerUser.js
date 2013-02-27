$(document).ready(function(){
	
	$('#searchButton').click(function(){
		$('#searchUserForm').submit();
	});
	
	$('#selectAll').click(function(){		//---控制全选
		
		if($('#selectAll:checked').length>0){
			$('#userListBody tr').each(function(){
				
				$(this).find('td:eq(0) input').attr('checked',true);
			});
		}else{
			$('#userListBody tr').each(function(){
				
				$(this).find('td:eq(0) input').attr('checked',false);
			});
		}
	});
	
	$('#applyAction').click(function(){		//---列表全局操作（赋予权限）
		
		var userIds = "";
		var op = $('#tableAction').val();
		if(op=='0'){
			alert('请选择操作！');
			return;
		}
		$('#userListBody tr').each(function(){
			
			if($(this).find('td:eq(0) input').attr('checked')){
				userIds += $(this).attr('id')+",";
			}
		});
		
		if(userIds==""){
			alert('请勾选应用操作的用户！');
		}else{
			
			userIds = userIds.substring(0, userIds.length-1);
			if(confirm("确定执行操作？")){
				$.ajax({
					  type: 'post',
					  async: false,
					  url: "mutipleRuleUsers",
					  dataType: 'json',
					  data: {'id':userIds,'op':op},
					  success: function(){
						  	
							alert("操作成功！");
							$('#userListBody tr').each(function(){
								
								$(this).find('td:eq(0) input').attr('checked',false);
							});
							window.location.reload();
						},
					  error: function(){
							alert("服务器正忙");
						}
				});
			}
		}
	});
	
	$('.delete').bind('click',function(){		//---删除
		var userId = $(this).parent('td').parent('tr').attr('id');
		if(confirm("确定删除？")){
			$.ajax({
				  type: 'post',
				  async: false,
				  url: "delUser",
				  dataType: 'json',
				  data: {'id':userId},
				  success: function(){
					  	
						alert("删除成功！");
						window.location.reload();
					},
				  error: function(){
						alert("服务器正忙");
					}
			});
		}
	});
	
	$('.detail').bind('click',function(){		//---查看（在新窗口查看）
		
		var userId = $(this).parent('td').parent('tr').attr('id');
		window.open('adminUserDetail?id='+userId+'&linkFrom=detail','_blank');
	});
	
	$('.edit').bind('click',function(){			//---编辑
		
		var userId = $(this).parent('td').parent('tr').attr('id');
		window.location.href='adminUserDetail?id='+userId+'&linkFrom=edit';
	});
	
});