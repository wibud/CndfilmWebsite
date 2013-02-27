<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Edit</title>

		<!-- css -->
		<link href="./css/bootstrap.css" rel="stylesheet">
		<link href="./css/bootstrap-responsive.css" rel="stylesheet">
		<link href="./css/docs.css" rel="stylesheet">
		<link href="./css/administrator.css" rel="stylesheet">
		<link href="./css/nav.css" rel="stylesheet">

		<!-- js -->
		<script type="text/javascript" src="./js/jquery.js"></script>
		<script type="text/javascript" src="./js/bootstrap.js"></script>
		<script type="text/javascript" src="./js/application.js"></script>
		<script type="text/javascript" src="./js/jquery.form.js"></script>
		<script type="text/javascript" src="./js/nicEdit.js"></script>
		<script type="text/javascript" src="./js/jquery.MultiFile.js"></script>
		<script type="text/javascript" src="./js/jquery.media.js"></script>
		<script type="text/javascript" src="./js/lightbox.js"></script>
		<script type="text/javascript" src="./js/filmEdit.js"></script>

		<style type="text/css">
		.editImg{
			width:200px;
			height:120px;
		}
		</style>
		<script type="text/javascript">
	
		</script>
	</head>

	<body style="background-color: #f5f5f5;">
		<!-- admin manager navbar -->
		<div class="fixed" style="background: url('./img/bg-sidebar.png') top left repeat-y; height: 100%; width: 225px;">
			<div style="with: 225px; background: #525252 url(./img/bg_leftside.png) repeat-x top; padding-top: 15px;">
				<div class="row-fluid" style="">
					<div style="width: 54px; float: left">
						<img src="./img/avatar.png" width="44" height="44"
							style="padding-left: 10px" />
					</div>
					<div style="width: 100px; float: left; padding-left: 10px">
						<h2 style="color: #fff;">
							admin
						</h2>
					</div>

				</div>
				<div style="background: url(./img/bg_left_spacer.png) repeat-x bottom; height: 20px; padding-top: 10px">
				</div>
			</div>

			<div id="adminNavbar" class="sidebar-nav">
				<ul class="nav nav-list">
					<li class="nav-header">
						admin管理页面
					</li>
					<li class="active">
						<a><i class="icon-list"></i>编辑节目</a>
					</li>
					<li>
						<a href="adminManager.action"><i class="icon-chevron-left icon-white"></i>返回</a>
					</li>
					<li class="divider"></li>
					<li>
						<a href="login.jsp"><i class="icon-share icon-white"></i>退出</a>
					</li>
				</ul>
			</div>
		</div>
		<!--/ admin manager navbar -->
		<div class="container-fluid">
			<div class="row-fluid" style="">
	  			<div class="span3" style="width:250px;"></div>
	  			<div class="span9" style="height:100%;">
	  				<div class="row-fluid">
	  					<div class="span4">
	  						<img src="./img/logo-name.png" />
	  					</div>
	  				</div>
	  				
	  				<!-- 编辑节目 -->
		            <div class="accordion pt30" id="editFilm">
		  				<div class="accordion-group">
			              <div class="accordion-heading">
			                <a class="accordion-toggle" data-toggle="collapse" data-parent="#editFilm" style="cursor:default;">
			                  	<i class="icon-pencil"></i>编辑节目
			                </a>
			              </div>
			              <div id="editFilmBody" class="accordion-body collapse in">
			                <div class="accordion-inner">
			                	<s:form cssClass="form-horizontal" id="editFilmForm" method="post" action="editFilm" enctype="multipart/form-data">
			                		<fieldset>
			                			<input type="hidden" value="<s:property value="filmId" />" name="filmId"/>
			                			<div class="control-group">
											<label class="control-label" for="filmName">节目片名：</label>
											<div class="controls">
											  <input type="text" class="input-large" id="filmName" name="filmName" value="<s:property value="filmDetail.filmName" />"/>
											  <a  href="#" rel="popover" title="注意！" data-content="节目名称不能为空">
											  	<img src="./img/icon/information.png"/>
											  </a>
										 	</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="filmTypeOfAddFilm">节目类别：</label>
											<div class="controls">
												<select id="filmTypeOfAddFilm" name="filmType" "<s:property value='filmDetail.filmTypeValue' />">
													<s:iterator value="filmTypeList" id="filmTypeBean">
														<s:if test="#filmTypeBean.value==filmDetail.filmTypeValue">
															<option selected value="<s:property value="#filmTypeBean.value" />"><s:property value="#filmTypeBean.name" /></option>
														</s:if>
														<s:else>
															<option value="<s:property value="#filmTypeBean.value" />"><s:property value="#filmTypeBean.name" /></option>
														</s:else>
											    		
											    	</s:iterator>
												</select>
										 	</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="filmTime">出品日期：</label>
											<div class="controls">
												<input type="text" class="input-small" id="filmTime" name="filmTime" value="<s:property value="filmDetail.filmTime" />"/>
										 	</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="filmLength">节目时长：</label>
											<div class="controls">
												<input type="text" class="input-small" id="filmLength" name="filmLength" value="<s:property value="filmDetail.filmLength" />"/>
										 	</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="standard">节目格式：</label>
											<div class="controls">
												<input type="text" class="input-large" id="standard" name="standard" value="<s:property value="filmDetail.standard" />"/>
										 	</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="director">导演（编导）：</label>
											<div class="controls">
											  <input type="text" class="input-large" id="director" name="director" value="<s:property value="filmDetail.director" />"/>
										 	</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="employee">职员：</label>
											<div class="controls">
											  <input type="text" class="input-xxlarge" id="employee" name="employee" value="<s:property value="filmDetail.employee" />"/>
										 	</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="awards">获奖情况：</label>
											<div class="controls">
											  <textarea class="input-xxlarge" id="awards" rows="7"><s:property value="filmDetail.awards" /></textarea>
											  <input type="hidden" id="awardsInput" name="awards"/>
										 	</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="broadcastSituation">播出情况：</label>
											<div class="controls">
											  <textarea class="input-xxlarge" id="broadcastSituation" rows="7"><s:property value="filmDetail.broadcastSituation" /></textarea>
											  <input type="hidden" id="broadcastSituationInput" name="broadcastSituation"/>
										 	</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="media">媒体宣传：</label>
											<div class="controls">
											  <textarea class="input-xxlarge" id="media" rows="5"><s:property value="filmDetail.media" /></textarea>
											  <input type="hidden" id="mediaInput" name="media"/>
										 	</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="link">链接：</label>
											<div class="controls">
											  <input type="text" class="input-xlarge" id="link" name="link" value="<s:property value="filmDetail.link" />"/>
										 	</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="producer">制作单位：</label>
											<div class="controls">
											  <input type="text" class="input-xxlarge" id="producer" name="producer" value="<s:property value="filmDetail.producer" />"/>
										 	</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="filmIntro">内容介绍：</label>
											<div class="controls">
											  <textarea class="span8" id="filmIntro" rows="10"><s:property value="filmDetail.filmIntro" /></textarea>
											  <input type="hidden" id="filmIntroInput" name="filmIntro"/>
										 	</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="comment">评论文章：</label>
											<div class="controls">
											  <textarea class="span8" id="comment" rows="10" ><s:property value="filmDetail.comment" /></textarea>
											  <input type="hidden" id="commentInput" name="comment"/>
										 	</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="commentary">台本/解说词：</label>
											<div class="controls">
											  <textarea class="span10" id="commentary" rows="10" ><s:property value="filmDetail.commentary" /></textarea>
											  <input type="hidden" id="commentaryInput" name="commentary"/>
										 	</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="recommend">设置为推荐节目：</label>
											<div class="controls">
												<label class="checkbox input-large">
													<s:if test="filmDetail.recommend==1">
														<input type="checkbox" id="recommend" name="recommend" checked="checked"/>
													</s:if>
													<s:else>
														<input type="checkbox" id="recommend" name="recommend"/>
													</s:else>
													是否推荐
												</label>
										 	</div>
										</div>
										
										<div id="filmSubjectBody" class="control-group">
											<label class="control-label" for="filmSubject">推荐主题：</label>
											<div class="controls">
												<input type="text" class="input-xxlarge" id=filmSubject name="filmSubject" value="<s:property value="filmDetail.filmSubject" />"/>
										 	</div>
										</div>
										<div class="" style="padding-left:25px;width:450px;">
											<div class="alert alert-block">
												<a class="close" data-dismiss="alert" href="#">×</a>
												<h4 class="alert-heading">注意!</h4>
												请上传gif、jpg、png格式的图片和flv格式的视频文件。<br>
												推荐节目展示图片上传尺寸为610*250px的图片
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="recommendPicture">推荐节目展示图片：</label>
											<div class="controls">
												<input type="file" class="multi" maxlength="1" accept="gif|jpg|png" id="recommendPicture" name="recommendPicture"/>
										 	</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="photo">上传节目剧照：</label>
											<div class="controls">
												<input type="file" class="multi" accept="gif|jpg|png" id="photo" name="photo"/>
										 	</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="poster">上传节目海报：</label>
											<div class="controls">
												<input type="file" class="multi" accept="gif|jpg|png" id="poster" name="poster"/>
										 	</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="video">上传节目花絮：</label>
											<div class="controls">
												<input type="file" class="multi" accept="flv" id="video" name="video"/>
										 	</div>
										</div>
										<div class="" style="padding-left:25px;width:450px;">
											<div class="alert alert-block">
												<a class="close" data-dismiss="alert" href="#">×</a>
												<h4 class="alert-heading">注意!</h4>
												请上传与上传的视频同名的jpg视频截图
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="video">上传花絮截图：</label>
											<div class="controls">
												<input type="file" class="multi" accept="jpg" id="videoScreen" name="videoScreen"/>
										 	</div>
										</div>
										<input type="hidden" id="recommendDel" name="recommendDel" />
										<input type="hidden" id="photoDel" name="photoDel" />
										<input type="hidden" id="posterDel" name="posterDel" />
										<input type="hidden" id="videoDel" name="videoDel" />
			                		</fieldset>
		                		</s:form>
		                		<div>
		                			<fieldset class="form-horizontal">
		                				<div class="" style="padding-left:25px;width:450px;">
											<div class="alert alert-block">
												<a class="close" data-dismiss="alert" href="#">×</a>
												<h4 class="alert-heading">注意!</h4>
												请勾选需要删除的资源文件
											</div>
										</div>
		                				<div class="control-group">
											<label class="control-label" for="">推荐节目图片：</label>
											<div class="controls">
												<table class="table table-striped" style="width:70%;">
													<tbody id="recommendTable">
														<s:iterator value="filmDetail.recommendPath" id="recommendPhotoPath">
															<tr>
																<td style="text-align:center;width:10%"><input type="checkbox"/></td>
																<td style="text-align:center;width:40%"><s:property value='#recommendPhotoPath' /></td>
																<td style="text-align:center;width:50%"><img class="editImg" src="./uploadFiles/<s:property value="filmDetail.folder_name" />/picture/recommend/<s:property value='#recommendPhotoPath' />"/></td>
															</tr>
														</s:iterator>
													</tbody>
												</table>
										 	</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="">节目剧照：</label>
											<div class="controls">
												<table id="photoTable" class="table table-striped" style="width:70%;">
													<tbody id="photoTable">
														<s:iterator value="filmDetail.photoPath" id="photoFileName">
															<tr>
																<td style="text-align:center;width:10%"><input type="checkbox"/></td>
																<td style="text-align:center;width:40%"><s:property value='#photoFileName' /></td>
																<td style="text-align:center;width:50%"><img class="editImg"  src="./uploadFiles/<s:property value="filmDetail.folder_name" />/picture/photo/<s:property value='#photoFileName' />"/></td>
															</tr>
														</s:iterator>
													</tbody>
												</table>
										 	</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="">节目海报：</label>
											<div class="controls">
												<table class="table table-striped" style="width:70%;">
													<tbody id="posterTable">
														<s:iterator value="filmDetail.posterPath" id="posterFileName">
															<tr>
																<td style="text-align:center;width:10%"><input type="checkbox"/></td>
																<td style="text-align:center;width:40%"><s:property value='#posterFileName' /></td>
																<td style="text-align:center;width:50%"><img class="editImg" src="./uploadFiles/<s:property value="filmDetail.folder_name" />/picture/poster/<s:property value='#posterFileName' />"/></td>
															</tr>
														</s:iterator>
													</tbody>
												</table>
										 	</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="">节目花絮：</label>
											<div class="controls">
												<table class="table table-striped" style="width:70%;">
													<tbody id="videoTable">
														<s:iterator value="filmDetail.videoPath" id="videoPath">
															<tr>
																<td style="text-align:center;width:10%"><input type="checkbox"/></td>
																<td style="text-align:center;width:40%"><s:property value='#videoPath.videoName' /></td>
																<td style="text-align:center;width:50%"><img class="editImg" src="./uploadFiles/<s:property value="filmDetail.folder_name" />/video/screen/<s:property value='#videoPath.videoScreenName' />"/></td>
															</tr>
														</s:iterator>
													</tbody>
												</table>
										 	</div>
										</div>
		                			</fieldset>
		                		</div>
		                		<div class="form-actions">
								  <button id="editFilmSave" class="btn btn-danger">确定修改</button>
								  <!--
								  <button class="btn" id="resetEditFilm">重置</button>
								  -->
								</div>
			                </div>
			              </div>
			            </div>
		            </div>
		            <!-- /编辑节目 -->
	  			</div>
	  		</div>
  		</div>
	</body>

</html>
