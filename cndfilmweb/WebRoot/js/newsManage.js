//textarea编辑器
var newsTextarea;
bkLib.onDomLoaded(function() {
	var o = {
		    buttonList : ['fontSize','fontFamily','fontFormat','bold','italic','underline','strikeThrough','subscript','superscript','html','left','center','right','justify','ol','ul','indent','outdent','removeformat','hr','link','unlink','forecolor','bgcolor','image','upload'],
		    iconsPath : '../img/nicEditorIcons.gif',
		    maxHeight :440
		};
	
	newsTextarea = new nicEditor(o).panelInstance('newsContent');
});

$(document).ready(function(){
	$('#newSave').click(function(){
		
		var title = $('#title').val();
		var time = $('#time').val();
		var content = newsTextarea.instanceById('newsContent').getContent();
		
		if(title=="" || time=="" || content==""){
			alert("内容不能为空");
			return;
		}
		
		$('#newsContentInput').val(content);
		
		//提交表单
		var options = {
		  		success: function(back){
				
			  			alert("添加成功！");
						window.location.reload();
					},
				error: function(){
						alert("服务器正忙");
					},
				clearForm: true	
		  	};
			
		  	$('#addNewsForm').ajaxSubmit(options);
//		  	document.addNewsForm.submit();
	});
	
	//时间选择器
	$('#time').glDatePicker({
		
		endDate: new Date(),
//		showAlways: true,
		position: "inherit",
		onChange: function(target, newDate)
	    {
	        target.val
	        (
	            newDate.getFullYear() + "-" +
	            (newDate.getMonth() + 1) + "-" +
	            newDate.getDate()
	        );
	    }
	});
	
	$('.delete').bind('click',function(){		//---删除
		var seq = $(this).parent('td').parent('tr').attr('id');
		if(confirm("确定删除？")){
			$.ajax({
				  type: 'post',
				  async: false,
				  url: "delNewTrends",
				  dataType: 'json',
				  data: {'seq':seq},
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
	
	$('.detail').bind('click',function(){		//---查看详情（在新窗口查看）
		
		var seq = $(this).parent('td').parent('tr').attr('id');
		window.open('detailNewTrends?seq='+seq+'&linkFrom=detail','_blank');
	});
	
	$('.edit').bind('click',function(){			//---编辑节目
		
		var seq = $(this).parent('td').parent('tr').attr('id');
		window.location.href='detailNewTrends?seq='+seq+'&linkFrom=edit';
	});
	
	//保存修改
	$('#editSave').click(function(){
		
		var title = $('#title').val();
		var time = $('#time').val();
		var content = newsTextarea.instanceById('newsContent').getContent();
		
		if(title=="" || time=="" || content==""){
			alert("内容不能为空");
			return;
		}
		
		$('#newsContentInput').val(content);
		
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
			
		  	$('#editNewTrendsForm').ajaxSubmit(options);
	});
});

