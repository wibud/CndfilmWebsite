$(document).ready(function(){
	
//	var oldIntroduce = introduceTextarea.instanceById('introduce').getContent();
	var oldAddr = $('#addr').val();
	var oldTel = $('#tel').val();
	var oldEmail = $('#email').val();
	var oldQq = $('#qq').val();
	var oldMsn = $('#msn').val();
	
	//修改密码
	$('#modifyPswdSave').click(function(){
	
		var oldPswd = $('#oldPswd').val();
		var newPswd = $('#newPswd').val();
		var repeatNewPswd = $('#repeatNewPswd').val();
		
		if(oldPswd==""|| newPswd==""|| repeatNewPswd==""){
			alert("输入内容不能为空");
			return;
		}
		if(newPswd!=repeatNewPswd){
			alert("两次输入的新密码不一致");
			return;
		}
		
		$.post('modifyPswd.action',{'pswd':oldPswd,'newPswd':newPswd},
			function(data){
				var errormsg = data.errormsg;
				if(errormsg!=""){
					alert(errormsg);
				}
	        },
	     'json');
	});

	//修改分类
	$('#addFilmTypeButton').click(function(){

		var filmTypeName = $('#filmTypeName').val();
		var flag = true;
		$('#filmTypes option').each(function(){

			if(filmTypeName==$(this).text()){
				flag = false;
				alert("该分类已存在");
				$('#filmTypeName').focus();
				return;
			}
		});

		if(flag==true){
			$('#filmTypes').append("<option>"+filmTypeName+"</option>");
		}
	});

	$('#removeFilmTypeButton').click(function(){

		$('#filmTypes').find("option:selected").remove();
	});

	$('#modifyFilmTypeSave').click(function(){

		var filmTypes = "";
		$('#filmTypes option').each(function(){
			
			filmTypes = filmTypes+$(this).text()+",";
		});
		
		if(filmTypes!=""){
			filmTypes = filmTypes.substring(0,filmTypes.length-1);
		}
		
		$.ajax({
			  type: 'post',
			  async: false,
			  url: "modifyFilmType",
			  dataType: 'json',
			  data: {'filmType':filmTypes},
			  success: function(){
					
					alert("修改成功！");
					window.location.reload();
				},
			  error: function(){
					alert("服务器正忙");
				}
		});
	});
	
	//修改简介
	$('#modifyIntroduceSave').click(function(){

		if($('#introduceAlert').length>0){
			
			$('#introduceAlert').alert('close');
		}
		var introduceInfo = introduceTextarea.instanceById('introduce').getContent();
		if(introduceInfo==""){
			$('#introduceBody div[class="accordion-inner"]').prepend('<div id="introduceAlert" class="alert alert-error"> <button class="close" data-dismiss="alert">×</button><strong>警告！</strong>请输入简介</div>');
			return;
		}
		
		$('#introduceInput').val(introduceInfo);
		
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
		
	  	$('#modifyIntroduceForm').ajaxSubmit(options);
		
//		$.ajax({
//			  type: 'post',
//			  async: false,
//			  url: "modifyBaseInfo",
//			  dataType: 'json',
//			  data: {'introduce':introduceInfo},
//			  success: function(){
////				  	oldIntroduce = introduceInfo;
//					alert("修改成功！");
//				},
//			  error: function(){
//					alert("服务器正忙");
//				}
//		});
	});

//	$('#resetIntroduce').click(function(){
//		$('#introduce').val(oldIntroduce);
//	});
	
	//影片查询
	$('#searchFilmSave').click(function(){
		
		$('#searchFilmForm').submit();
	});

	//修改基本信息
	$('#modifyBaseInfoSave').click(function(){

		if($('#infoAlert').length>0){
			$('#infoAlert').alert('close');
		}	
		var addrInfo = $('#addr').val();
		var telInfo = $('#tel').val();
		var emailInfo = $('#email').val();
		var qqInfo = $('#qq').val();
		var msnInfo = $('#msn').val();
		if(addrInfo==""|| telInfo==""|| emailInfo=="" || qqInfo=="" || msnInfo==""){
			$('#infoBody div[class="accordion-inner"]').prepend('<div id="infoAlert" class="alert alert-error"> <button class="close" data-dismiss="alert">×</button><strong>警告！</strong>请输入基本本信</div>');
			return;
		}

		$.ajax({
			  type: 'post',
			  async: false,
			  url: "modifyBaseInfo",
			  dataType: 'json',
			  data: {'address':addrInfo,'tel':telInfo,'email':emailInfo,'qq':qqInfo,'msn':msnInfo},
			  success: function(){
				  	oldAddr = addrInfo;
				  	oldTel = telInfo;
				  	oldEmail = emailInfo;
				  	oldQq = qqInfo;
				  	oldMsn = msnInfo;
					alert("修改成功！");
				},
			  error: function(){
					alert("服务器正忙");
				}
		});
  	});

	$('#resetBaseInfo').click(function(){	//---重置
		$('#addr').val(oldAddr);
		$('#tel').val(oldTel);
		$('#email').val(oldEmail);
		$('#qq').val(oldQq);
		$('#msn').val(oldMsn);
  	});
	
  	//添加影片
  	$('#resetAddFilm').click(function(){	//---重置
		$('#filmName').val('');
		$('#filmTime').val('');
		$('#director').val('');
		$('#employee').val('');
		$('#link').val('');
		$('#filmLength').val('');
		$('#standard').val('');
		$('#producer').val('');
		$('#recommend').attr('checked',false);
		$('#filmSubject').val('');
		$('.MultiFile-list').each(function(){
			$(this).find('a[class="MultiFile-remove"]').each(function(i,val){
				val.click();
			});
		});
  	});

	$('#addFilmSave').click(function(){		//---添加
		
		if($('#addfilmAlert').length>0){
			$('#addfilmAlert').alert('close');
		}

		var filmName = $('#filmName').val();
		var filmTime = $('#filmTime').val();
		//使用nicEdit后，直接val()取不到textarea的值
		$('#awardsInput').val(awardsTextarea.instanceById('awards').getContent());
		$('#broadcastSituationInput').val(broadcastSituationTextarea.instanceById('broadcastSituation').getContent());
		$('#mediaInput').val(mediaTextarea.instanceById('media').getContent());
		$('#filmIntroInput').val(filmIntroTextarea.instanceById('filmIntro').getContent());
		$('#commentInput').val(commentTextarea.instanceById('comment').getContent());
		$('#commentaryInput').val(commentaryTextarea.instanceById('commentary').getContent());
//		var filmType = $('#filmTypeOfAddFilm').val();
//		var director = $('#director').val();
//		var employee = $('#employee').val();
//		var link = $('#link').val();
//		var filmIntro = $('#filmIntro').val();
//		var filmSubject = $('#filmSubject').val();
		if($('#recommend:checked').length>0){
			if(filmSubject==""){
				$('#addFilmBody div[class="accordion-inner"]').prepend('<div id="addfilmAlert" class="alert alert-error"> <button class="close" data-dismiss="alert">×</button><strong>警告！</strong>请填写推荐主题</div>');
				return;
			}
		}
		
		if(filmName == ""){
			$('#addFilmBody div[class="accordion-inner"]').prepend('<div id="addfilmAlert" class="alert alert-error"> <button class="close" data-dismiss="alert">×</button><strong>警告！</strong>影片名称不能为空</div>');
			return;
		}

		var check = /^\d{4}$/;
		if(filmTime.match(check)==null){
			$('#addFilmBody div[class="accordion-inner"]').prepend('<div id="addfilmAlert" class="alert alert-error"> <button class="close" data-dismiss="alert">×</button><strong>警告！</strong>年份填写不正确</div>');
			return;
		}

		$.ajax({
			  type: 'post',
			  async: false,
			  url: "checkFilmName",
			  dataType: 'json',
			  data: {'filmName':filmName},
			  success: function(data){
				  	var result = data.checkResult;
				  	if(result=="false"){
						if(!confirm("影片名称重复，是否继续添加?")){
							
							$('#filmName').focus();
							return;
						}
				  	}
				  	
				  	var options = {
				  		success: function(back){
					  			var error = back.resultMsg;
					  			if(error!=""){
					  				alert(error);
					  			}else{
					  				alert("修改成功！");
					  			}
								
								window.location.reload();
							},
						error: function(){
								alert("服务器正忙");
							},
						clearForm: true	
				  	};
//				  	$('#addFilmForm').ajaxForm(options);
				  	$('#addFilmForm').ajaxSubmit(options);
				  	
//				  	$.ajax({
//						  type: 'post',
//						  async: false,
//						  url: "addFilm",
//						  dataType: 'json',
//						  data: {'actor':actor,'director':director,'filmIntro':filmIntro,'filmName':filmName,'filmTime':filmTime,'filmType':filmType,'link':link,'recommend':recommend,'filmSubject':filmSubject},
//						  success: function(){
//							  	
//								alert("修改成功！");
//								window.location.reload();
//							},
//						  error: function(){
//								alert("服务器正忙");
//							}
//					});
					
				},
			  error: function(){
					alert("服务器正忙");
				}
		});
	});
	
//	if($('#recommend:checked').length>0){
//		$('#filmSubjectBody').removeClass('hide');
//		$('#recommendPictureBody').removeClass('hide');
//	}
//	
//	$('#recommend').click(function(){
//		
//		if($('#recommend:checked').length>0){
//			$('#filmSubjectBody').removeClass('hide');
//			$('#recommendPictureBody').removeClass('hide');
//		}else{
//			$('#filmSubjectBody').addClass('hide');
//			$('#recommendPictureBody').addClass('hide');
//		}
//	});
	

	//影片列表
	$('#filmListBody tr').each(function(){		//---控制推荐主题长度
		var filmIntro = $(this).find("td:eq(9) div p a").attr('title');
		if(filmIntro.length>10){

			filmIntro = filmIntro.substring(0,11)+"....";
		}
		$(this).find("td:eq(9) div p a").text(filmIntro);
	});
	
	$('.delete').bind('click',function(){		//---删除
		var filmId = $(this).parent('td').parent('tr').attr('id');
		if(confirm("确定删除？")){
			$.ajax({
				  type: 'post',
				  async: false,
				  url: "delFilm",
				  dataType: 'json',
				  data: {'filmId':filmId},
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
	
	$('#selectAll').click(function(){		//---控制全选
		
		if($('#selectAll:checked').length>0){
			$('#filmListBody tr').each(function(){
				
				$(this).find('td:eq(0) input').attr('checked',true);
			});
		}else{
			$('#filmListBody tr').each(function(){
				
				$(this).find('td:eq(0) input').attr('checked',false);
			});
		}
	});
	
	$('#applyAction').click(function(){		//---列表全局操作（目前只有批量删除）
		
		var filmIds = "";
		var op = $('#tableAction').val();
		if(op=='0'){
			alert('请选择操作！');
			return;
		}
		if(op=='1'){
			$('#filmListBody tr').each(function(){
				
				if($(this).find('td:eq(0) input').attr('checked')){
					filmIds += $(this).attr('id')+",";
				}
			});
		}
		
		if(filmIds==""){
			alert('请勾选应用操作的影片！');
		}else{
			
			filmIds = filmIds.substring(0, filmIds.length-1);
			if(confirm("确定删除？")){
				$.ajax({
					  type: 'post',
					  async: false,
					  url: "mutipleDelFilms",
					  dataType: 'json',
					  data: {'filmId':filmIds},
					  success: function(){
						  	
							alert("删除成功！");
							$('#filmListBody tr').each(function(){
								
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
	
	$('.detail').bind('click',function(){		//---查看详情（在新窗口查看）
		
		var filmId = $(this).parent('td').parent('tr').attr('id');
		window.open('adminFilmDetail?filmId='+filmId+'&linkFrom=detail','_blank');
	});
	
	$('.edit').bind('click',function(){			//---编辑节目
		
		var filmId = $(this).parent('td').parent('tr').attr('id');
		window.location.href='adminFilmDetail?filmId='+filmId+'&linkFrom=edit';
	});
	
});

function managerNews(){
	
	window.open('listNewTrends');
}

function managerUsers(){
	
	window.open('listUsers');
}
