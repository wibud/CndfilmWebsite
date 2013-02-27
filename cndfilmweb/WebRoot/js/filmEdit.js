//textarea编辑器
var filmIntroTextarea;
var awardsTextarea;
var broadcastSituationTextarea;
var commentTextarea;
var mediaTextarea;
var commentaryTextarea;
bkLib.onDomLoaded(function() {
	var o = {
		    buttonList : ['fontSize','fontFamily','fontFormat','bold','italic','underline','strikeThrough','subscript','superscript','html','left','center','right','justify','ol','ul','indent','outdent','removeformat','hr','link','unlink','forecolor','bgcolor','image'],
		    iconsPath : '../img/nicEditorIcons.gif',
		    maxHeight :220
		};
	
	filmIntroTextarea = new nicEditor(o).panelInstance('filmIntro');
	awardsTextarea = new nicEditor(o).panelInstance('awards');
	broadcastSituationTextarea = new nicEditor(o).panelInstance('broadcastSituation');
	commentTextarea = new nicEditor(o).panelInstance('comment');
	mediaTextarea = new nicEditor(o).panelInstance('media');
	commentaryTextarea = new nicEditor(o).panelInstance('commentary');
});

$(document).ready(function(){
	
	//视频播放
	$('.media').media();
	
//	$('#resetEditFilm').click(function(){	//---重置
//		$('#filmName').val('');
//		$('#filmTime').val('');
//		$('#director').val('');
//		$('#employee').val('');
//		$('#link').val('');
//		$('#filmLength').val('');
//		$('#standard').val('');
//		$('#producer').val('');
//		$('#recommend').attr('checked',false);
//		$('#filmSubject').val('');
//		$('.MultiFile-list').each(function(){
//			$(this).find('a[class="MultiFile-remove"]').each(function(i,val){
//				val.click();
//			});
//		});
//  	});
	
	$('#editFilmSave').click(function(){		//---修改
		
		if($('#editfilmAlert').length>0){
			$('#editfilmAlert').alert('close');
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
		var filmSubject = $('#filmSubject').val();
		if($('#recommend:checked').length>0){
			if(filmSubject==""){
				$('#editFilmBody div[class="accordion-inner"]').prepend('<div id="editfilmAlert" class="alert alert-error"> <button class="close" data-dismiss="alert">×</button><strong>警告！</strong>请填写推荐主题</div>');
				return;
			}
		}
		
		if(filmName == ""){
			$('#editFilmBody div[class="accordion-inner"]').prepend('<div id="editfilmAlert" class="alert alert-error"> <button class="close" data-dismiss="alert">×</button><strong>警告！</strong>影片名称不能为空</div>');
			return;
		}

		var check = /^\d{4}$/;
		if(filmTime.match(check)==null){
			$('#editFilmBody div[class="accordion-inner"]').prepend('<div id="editfilmAlert" class="alert alert-error"> <button class="close" data-dismiss="alert">×</button><strong>警告！</strong>年份填写不正确</div>');
			return;
		}
		
		var recommendDelName = "";
		var photoDelName = "";
		var posterName = "";
		var videoName = "";
		$('#recommendTable tr').each(function(){
			
			if($(this).find("td:eq(0) input").attr('checked')){
				recommendDelName += $(this).find("td:eq(1)").text()+",";
			}
		});
		$('#photoTable tr').each(function(){
			
			if($(this).find("td:eq(0) input").attr('checked')){
				photoDelName += $(this).find("td:eq(1)").text()+",";
			}
		});
		$('#posterTable tr').each(function(){
			
			if($(this).find("td:eq(0) input").attr('checked')){
				posterName += $(this).find("td:eq(1)").text()+",";
			}
		});
		$('#videoTable tr').each(function(){
			
			if($(this).find("td:eq(0) input").attr('checked')){
				videoName += $(this).find("td:eq(1)").text()+",";
			}
		});
		
		$('#recommendDel').val(recommendDelName);
		$('#photoDel').val(photoDelName);
		$('#posterDel').val(posterName);
		$('#videoDel').val(videoName);

//		$.ajax({
//			  type: 'post',
//			  async: false,
//			  url: "checkFilmName",
//			  dataType: 'json',
//			  data: {'filmName':filmName},
//			  success: function(data){
//				  	var result = data.checkResult;
//				  	if(result=="false"){
//						if(!confirm("影片名称重复，是否继续修改?")){
//							
//							$('#filmName').focus();
//							return;
//						}
//				  	}
				  	
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
						clearForm: false	
				  	};
//				  	$('#addFilmForm').ajaxForm(options);
				  	$('#editFilmForm').ajaxSubmit(options);
				  	
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
					
//				},
//			  error: function(){
//					alert("服务器正忙");
//				}
//		});
	});
});