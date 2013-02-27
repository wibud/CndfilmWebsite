<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Admain Manager</title>
    
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
    <script type="text/javascript" src="./js/textareaEdit.js"></script>
    <script type="text/javascript" src="./js/administrator.js"></script>
    <script type="text/javascript" src="./js/page.js"></script>
    
    <style type="text/css">
    	
    </style>
    <script type="text/javascript">
    $(document).ready(function(){
    	createPage('adminManager','','#filmtabls');
    });
    </script>
    
  </head>
  <body style="background-color:#f5f5f5;" data-spy="scroll" data-target="#adminNavbar">
  	<!-- admin manager navbar -->
	<div class="fixed" style="background: url('./img/bg-sidebar.png') top left repeat-y;height:100%;width:225px;">
		<div style="with:225px;background: #525252 url(./img/bg_leftside.png) repeat-x top;padding-top:15px;">
			<div class="row-fluid" style="">
				<div style="width:54px;float:left">
					<img src="./img/avatar.png" width="44" height="44" style="padding-left:10px"/>
				</div>
				<div style="width:100px;float:left;padding-left:10px">
					<h2 style="color: #fff;">admin</h2>
				</div>
				
			</div>
			<div style="background: url(./img/bg_left_spacer.png) repeat-x bottom;height:20px;padding-top:10px">
			</div> 	
		</div>
				
		<div id="adminNavbar" class="sidebar-nav">
            <ul class="nav nav-list">
              <li class="nav-header">admin管理页面</li>
              <li><a href="#home">首页</a></li>
              <li><a href="#basicInfo">基本信息</a></li>
              <li><a href="#filmtabls">节目管理</a></li>
              <li><a href="javascript:void(0);" onclick="managerNews();">新闻动态</a></li>
              <li><a href="javascript:void(0);" onclick="managerUsers();">用户管理</a></li>
              <li><a href="#help">帮助</a></li>
              <li class="divider"></li>
              <li><a href="login.jsp"><i class="icon-share icon-white"></i>退出</a></li>
            </ul>
       	</div>
	</div>
	<!--/ admin manager navbar -->
  	<div class="container-fluid">
  		<div class="row-fluid" style="">
  			<div class="span3" style="width:250px;"></div>
  			<div class="span9" style="height:100%;">
  				<div id="home" class="row-fluid">
  					<div class="span4">
  						<img src="./img/logo-name.png" />
  					</div>
  				</div>
  				<!--  
  				<div class="row-fluid">
  					<div>
  						<ul class="breadcrumb">
		  					<li class="active"><i class="icon-home"></i>Home<span class="divider">/</span></li>
		  				</ul>
  					</div>
  				</div>
  				-->
  				<div id="basicInfo" class="row-fluid pt30">
  					<div>
  						<ul class="thumbnails">
  							<!-- 修改密码 -->
  							<li class="span2" style="width:13%;">
  								<a id="modifyPswdButton" href="#modifyPswd" data-toggle="modal" class="thumbnail shortcutbutton" style="text-decoration:none;">
  									<img src="./img/pencil.png"/>
  									<div style="padding-top:20px;text-align:center;">
  										<span style="color:#555;font-weight:bold;">修改密码</span>
  									</div>
  								</a>
  							</li>
  							<div id="modifyPswd" class="modal hide fade">
					            <div class="modal-header">
					              <button type="button" class="close" data-dismiss="modal">&times;</button>
					              <h3>修改密码</h3>
					            </div>
					            <div class="modal-body">
				            		<fieldset class="form-horizontal">
					            		 <div class="control-group">
								            <label class="control-label" for="oldPswd">密码：</label>
								            <div class="controls">
								              <input type="password" class="input-large" id="oldPswd" name="pswd">
								            </div>
								          </div>
								          <div class="control-group">
								            <label class="control-label" for="newPswd">新密码：</label>
								            <div class="controls">
								              <input type="password" class="input-large" id="newPswd" name="newPswd">
								            </div>
								          </div>
								          <div class="control-group">
								            <label class="control-label" for="repeatNewPswd">确认新密码：</label>
								            <div class="controls">
								              <input type="password" class="input-large" id="repeatNewPswd">
								            </div>
								          </div>
					            	</fieldset>
					            </div>
					            <div class="modal-footer">
					              <button class="btn" data-dismiss="modal" >关闭</button>
					              <button class="btn btn-danger" id="modifyPswdSave">保存修改</button>
					            </div>
					        </div>
					        <!-- /修改密码 -->
					        <!-- 
					        <li class="span2" style="width:13%;">
  								<a href="#" class="thumbnail shortcutbutton" style="text-decoration:none;">
  									<img src="./img/paper_pencil.png"/>
  									<div style="padding-top:20px;text-align:center;" >
  										<span style="color:#555;font-weight:bold;">修改基本信息</span>
  									</div>
  								</a>
  							</li>
					         -->
					         
					        <!-- 添加节目 -->
  							<li class="span2" style="width:13%;">
  								<a href="#addFilm" class="thumbnail shortcutbutton" style="text-decoration:none;">
  									<img src="./img/add-film.png"/>
  									<div style="padding-top:20px;text-align:center;">
  										<span style="color:#555;font-weight:bold;">添加节目</span>
  									</div>
  								</a>
  							</li>
  							<!-- /添加节目 -->
  							
  							<!-- 修改节目分类 -->
  							<li class="span2" style="width:13%;">
  								<a href="#modifyFilmType" data-toggle="modal" class="thumbnail shortcutbutton" style="text-decoration:none;">
  									<img src="./img/modify-filmType.png"/>
  									<div style="padding-top:20px;text-align:center;">
  										<span style="color:#555;font-weight:bold;">修改节目分类</span>
  									</div>
  								</a>
  							</li>
  							<div id="modifyFilmType" class="modal hide fade">
					            <div class="modal-header">
					              <button type="button" class="close" data-dismiss="modal">&times;</button>
					              <h3>修改节目分类</h3>
					            </div>
					            <div class="modal-body">
					            	<fieldset class="form-horizontal">
										<div class="control-group">
										  <label class="control-label" for="filmTypeName">分类名称:</label>
										  <div class="controls">
										    <input type="text" class="input-large" id="filmTypeName">
										    <button id="addFilmTypeButton" class="btn btn-success"><i class="icon-plus icon-white"></i>添加</button>
										  </div>
										</div>
										<div class="control-group">
										  <label class="control-label" for="filmTypes">节目类别:</label>
										  <div class="controls">
										  	<select multiple="multiple" id="filmTypes">
										    	<s:iterator value="filmTypeList" id="filmTypeBean">
										    		<option value="<s:property value="#filmTypeBean.value" />"><s:property value="#filmTypeBean.name" /></option>
										    	</s:iterator>
								          	</select>
								          	<button id="removeFilmTypeButton" class="btn btn-danger"><i class="icon-trash icon-white"></i>删除</button>
										  </div>
										</div>
					            	</fieldset>
					            </div>
					            <div class="modal-footer">
					              <button class="btn" data-dismiss="modal" >关闭</button>
					              <button class="btn btn-danger" id="modifyFilmTypeSave">保存修改</button>
					            </div>
					        </div>
  							<!-- /修改节目分类 -->
  							
  							<!-- 节目查询 -->
  							<li class="span2" style="width:13%;">
  								<a href="#searchFilm" data-toggle="modal" class="thumbnail shortcutbutton" style="text-decoration:none;">
  									<img src="./img/search.png"/>
  									<div style="padding-top:20px;text-align:center;">
  										<span style="color:#555;font-weight:bold;">节目查询</span>
  									</div>
  								</a>
  							</li>
  							<div id="searchFilm" class="modal hide fade">
					            <div class="modal-header">
					              <button type="button" class="close" data-dismiss="modal">&times;</button>
					              <h3>搜索节目</h3>
					            </div>
					            <div class="modal-body">
					            	<s:form cssClass="form-horizontal" action="searchFilm" id="searchFilmForm">
						            	<fieldset>
											<div class="control-group">
											  <label class="control-label" for="searchFilmName">节目片名:</label>
											  <div class="controls">
											    <input type="text" class="input-large" id="searchFilmName" name="filmName">
											  </div>
											</div>
											<div class="control-group">
											  <label class="control-label" for="searchFilmLength">节目时长:</label>
											  <div class="controls">
											    <input type="text" class="input-large" id="searchFilmLength" name="filmLength">
											  </div>
											</div>
											<div class="control-group">
											  <label class="control-label" for="searchFilmTime">出品日期:</label>
											  <div class="controls">
											    <input type="text" class="input-large" id="searchFilmTime" name="filmTime">
											  </div>
											</div>
											<div class="control-group">
											  <label class="control-label" for="searchStandard">节目格式:</label>
											  <div class="controls">
											    <input type="text" class="input-large" id="searchStandard" name="standard">
											  </div>
											</div>
											<div class="control-group">
											  <label class="control-label" for="searchFilmType">节目类型:</label>
											  <div class="controls">
											    <select id="searchFilmType" name="filmType">
											    	<option value="0">全部</option>
													<s:iterator value="filmTypeList" id="filmTypeBean">
											    		<option value="<s:property value="#filmTypeBean.value" />"><s:property value="#filmTypeBean.name" /></option>
											    	</s:iterator>
												</select>
											  </div>
											</div>
											<div class="control-group">
											  <label class="control-label" for="searchFilmKeyword">关键字:</label>
											  <div class="controls">
											    <input type="text" class="input-large" id="searchFilmKeyword" name="filmKeyword">
											  </div>
											</div>
											<div class="control-group">
											  <label class="control-label" for="searchDirector">导演（编剧）:</label>
											  <div class="controls">
											    <input type="text" class="input-large" id="searchDirector" name="director">
											  </div>
											</div>
											<div class="control-group">
											  <label class="control-label" for="searchAwards">获奖情况:</label>
											  <div class="controls">
											    <input type="text" class="input-xlarge" id="searchAwards" name="awards">
											  </div>
											</div>
						            	</fieldset>
					            	</s:form>
					            </div>
					            <div class="modal-footer">
					              <button class="btn" data-dismiss="modal" >关闭</button>
					              <button class="btn btn-danger" id="searchFilmSave">确定</button>
					            </div>
					        </div>
  						</ul>
  					</div>
  				</div>
  				
  				<!-- 基本信息 -->
  				<div class="row-fluid">
  					<div class="span6">
  						<div class="accordion" id="cndIntroduce">
			  				<div class="accordion-group">
				              <div class="accordion-heading">
				                <a class="accordion-toggle" data-toggle="collapse" data-parent="#cndIntroduce" href="#introduceBody">
				                  	<i class="icon-file"></i>市场管理部介绍
				                </a>
				              </div>
				              <div id="introduceBody" class="accordion-body collapse in">
				                <div class="accordion-inner">
									<textarea class="span12" id="introduce" rows="6"><s:property value="baseInfo.introduce"/></textarea>
									<s:form cssClass="form-horizontal" id="modifyIntroduceForm" method="post" action="modifyBaseInfo">
		                				<fieldset>
		                					<div class="" style="padding-top:20px;width:450px;">
												<div class="alert alert-block">
													<a class="close" data-dismiss="alert" href="#">×</a>
													<h4 class="alert-heading">注意!</h4>
													请上传gif、jpg、png格式的图片。<br>
													简介图片上传尺寸为498*180px的图片
												</div>
											</div>
											简介图片：<input type="file" class="multi" maxlength="1" accept="gif|jpg|png" id="introduceImg" name="introduceImg"/>
		                				</fieldset>
		                				<input type="hidden" id="introduceInput" name="introduce" />
		                			</s:form>
									<div class="form-actions">
									  <button id="modifyIntroduceSave" class="btn btn-danger">保存修改</button>
									  <!-- 
									  <button class="btn" id="resetIntroduce">取消</button>
									   -->
									</div>
				                </div>
				              </div>
				            </div>
			            </div>
  					</div>
  					
  					<div class="span6">
  						<div class="accordion" id="cndInfo">
			  				<div class="accordion-group">
				              <div class="accordion-heading">
				                <a class="accordion-toggle" data-toggle="collapse" data-parent="#cndInfo" href="#infoBody">
				                  	<i class="icon-cog"></i>基本信息
				                </a>
				              </div>
				              <div id="infoBody" class="accordion-body collapse in">
				                <div class="accordion-inner">
				                	<fieldset class="form-horizontal">
					            		 <div class="control-group">
								            <label class="control-label" for="addr">地址：</label>
								            <div class="controls">
								              <input type="text" class="input-large" id="addr" value="<s:property value="baseInfo.address"/>">
								            </div>
								          </div>
								          <div class="control-group">
								            <label class="control-label" for="tel">电话：</label>
								            <div class="controls">
								              <input type="text" class="input-large" id="tel" value="<s:property value="baseInfo.tel"/>">
								            </div>
								          </div>
								          <div class="control-group">
								            <label class="control-label" for="email">邮箱：</label>
								            <div class="controls">
								              <input type="text" class="input-large" id="email" value="<s:property value="baseInfo.email"/>">
								            </div>
								          </div>
								          <div class="control-group">
								            <label class="control-label" for="qq">QQ：</label>
								            <div class="controls">
								              <input type="text" class="input-large" id="qq" value="<s:property value="baseInfo.qq"/>">
								            </div>
								          </div>
								          <div class="control-group">
								            <label class="control-label" for="msn">MSN：</label>
								            <div class="controls">
								              <input type="text" class="input-large" id="msn" value="<s:property value="baseInfo.msn"/>">
								            </div>
								          </div>
					            	</fieldset>
					            	<div class="form-actions">
									  <button id="modifyBaseInfoSave" class="btn btn-danger">保存修改</button>
									  <button class="btn" id="resetBaseInfo">取消</button>
									</div>
				                </div>
				              </div>
				            </div>
			            </div>
  					</div>
  				</div>
  				<!-- /基本信息 -->
  				
  				<!-- 节目列表 -->
  				<div class="accordion" id="filmtabls">
	  				<div class="accordion-group">
		              <div class="accordion-heading">
		                <a class="accordion-toggle" data-toggle="collapse" data-parent="#filmtabls" href="#filmtable">
		                  	<i class="icon-list"></i>节目列表
		                </a>
		              </div>
		              <div id="filmtable" class="accordion-body collapse in">
		                <div class="accordion-inner">
		                	<table class="table table-striped">
								<thead>
									<tr>
										<th><input type="checkbox" id="selectAll"></th>
										<th>节目片名</th>
										<th>节目类别</th>
										<th>出品日期</th>
										<th>节目时长</th>
										<th>节目格式</th>
										<th>导演（编导）</th>
										<th>制作单位</th>
										<th>是否推荐</th>
										<th>推荐主题</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody id="filmListBody">
									<s:iterator value="filmList" id="film">
		                				<tr id="<s:property value="#film.seq"/>">
		                					<td><input type="checkbox"/></td>
		                					<td><s:property value="#film.filmName"/></td>
		                					<td><s:property value="#film.filmType"/></td>
		                					<td><s:property value="#film.filmTime"/></td>
		                					<td><s:property value="#film.filmLength"/></td>
		                					<td><s:property value="#film.standard"/></td>
		                					<td><s:property value="#film.director"/></td>
		                					<td><s:property value="#film.producer"/></td>
		                					<td><s:property value="#film.recommend"/></td>
		                					<td><div class="tooltip-demo"><p class="muted" style="margin-bottom: 0;"><a href="#" rel="tooltip" title="<s:property value="#film.filmSubject"/>"></a></p></div></td>
		                					<!-- 
		                					<td><div class="tooltip-demo"><p class="muted" style="margin-bottom: 0;"><a href="#" rel="tooltip" title="<s:property value="#film.filmIntro"/>"></a></p></div></td>
		                					-->
		                					<td style="white-space:nowrap;">
		                						<a title="查看" class="detail"><img src="./img/icon/pencil.png" alt="查看" /></a>
		                						<a title="删除" class="delete"><img src="./img/icon/cross.png" alt="删除" /></a>
		                						<a title="编辑" class="edit"><img src="./img/icon/edit.png" alt="编辑" /></a>
		                					</td>
		                				</tr>
		                			</s:iterator>
								</tbody>
		                	</table>
		                	<div class="row-fluid">
		                		<div class="bulk-actions span6">
					             	<div class="input-append">
						                <select id="tableAction">
							                <option value="0">选择操作</option>
							                <option value="1">删除</option>
						             	</select>
						             	<button id="applyAction" class="btn btn-danger btn-small">应用</button>
						            </div>
		                		</div>
		                		<!-- 页码 -->
		                		<div class="myPagination span6">
								</div>
		                	</div>
		                </div>
		              </div>
		            </div>
	            </div>
	            <!-- /节目列表 -->
	            
	            <!-- 添加节目 -->
	            <div class="accordion" id="addFilm">
	  				<div class="accordion-group">
		              <div class="accordion-heading">
		                <a class="accordion-toggle" data-toggle="collapse" data-parent="#addFilm" href="#addFilmBody">
		                  	<i class="icon-plus-sign"></i>添加节目
		                </a>
		              </div>
		              <div id="addFilmBody" class="accordion-body collapse in">
		                <div class="accordion-inner">
		                	<s:form cssClass="form-horizontal" id="addFilmForm" method="post" action="addFilm" enctype="multipart/form-data">
		                		<fieldset>
		                			<div class="control-group">
										<label class="control-label" for="filmName">节目片名：</label>
										<div class="controls">
										  <input type="text" class="input-large" id="filmName" name="filmName" />
										  <a  href="#" rel="popover" title="注意！" data-content="节目名称不能为空">
										  	<img src="./img/icon/information.png"/>
										  </a>
									 	</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="filmTypeOfAddFilm">节目类别：</label>
										<div class="controls">
											<select id="filmTypeOfAddFilm" name="filmType">
												<s:iterator value="filmTypeList" id="filmTypeBean">
										    		<option value="<s:property value="#filmTypeBean.value" />"><s:property value="#filmTypeBean.name" /></option>
										    	</s:iterator>
											</select>
									 	</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="filmTime">出品日期：</label>
										<div class="controls">
											<input type="text" class="input-small" id="filmTime" name="filmTime" />
									 	</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="filmLength">节目时长：</label>
										<div class="controls">
											<input type="text" class="input-small" id="filmLength" name="filmLength" />
									 	</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="standard">节目格式：</label>
										<div class="controls">
											<input type="text" class="input-large" id="standard" name="standard" />
									 	</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="director">导演（编导）：</label>
										<div class="controls">
										  <input type="text" class="input-large" id="director" name="director" />
									 	</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="employee">职员：</label>
										<div class="controls">
										  <input type="text" class="input-xxlarge" id="employee" name="employee" />
									 	</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="awards">获奖情况：</label>
										<div class="controls">
										  <textarea class="input-xxlarge" id="awards" rows="7"></textarea>
										  <input type="hidden" id="awardsInput" name="awards"/>
									 	</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="broadcastSituation">播出情况：</label>
										<div class="controls">
										  <textarea class="input-xxlarge" id="broadcastSituation" rows="7"></textarea>
										  <input type="hidden" id="broadcastSituationInput" name="broadcastSituation"/>
									 	</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="media">媒体宣传：</label>
										<div class="controls">
										  <textarea class="input-xxlarge" id="media" rows="5"></textarea>
										  <input type="hidden" id="mediaInput" name="media"/>
									 	</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="link">链接：</label>
										<div class="controls">
										  <input type="text" class="input-xlarge" id="link" name="link" />
									 	</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="producer">制作单位：</label>
										<div class="controls">
										  <input type="text" class="input-xxlarge" id="producer" name="producer" />
									 	</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="filmIntro">内容介绍：</label>
										<div class="controls">
										  <textarea class="span8" id="filmIntro" rows="10"></textarea>
										  <input type="hidden" id="filmIntroInput" name="filmIntro"/>
									 	</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="comment">评论文章：</label>
										<div class="controls">
										  <textarea class="span8" id="comment" rows="10" ></textarea>
										  <input type="hidden" id="commentInput" name="comment"/>
									 	</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="commentary">台本/解说词：</label>
										<div class="controls">
										  <textarea class="span10" id="commentary" rows="10" ></textarea>
										  <input type="hidden" id="commentaryInput" name="commentary"/>
									 	</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="recommend">设置为推荐节目：</label>
										<div class="controls">
											<label class="checkbox input-large">
												<input type="checkbox" id="recommend" name="recommend" />
												是否推荐
											</label>
									 	</div>
									</div>
									
									<div id="filmSubjectBody" class="control-group">
										<label class="control-label" for="filmSubject">推荐主题：</label>
										<div class="controls">
											<input type="text" class="input-xxlarge" id=filmSubject name="filmSubject" />
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
		                		</fieldset>
	                		</s:form>
	                		<div class="form-actions">
							  <button id="addFilmSave" class="btn btn-danger">确定添加</button>
							  <button class="btn" id="resetAddFilm">重置</button>
							</div>
		                </div>
		              </div>
		            </div>
	            </div>
	            <!-- /添加节目 -->
	            <!--  帮助 -->
	            <div class="accordion" id="help">
	  				<div class="accordion-group">
		              <div class="accordion-heading">
		                <a class="accordion-toggle" data-toggle="collapse" data-parent="#help" href="#helpBody">
		                  	<i class="icon-question-sign"></i>帮助
		                </a>
		              </div>
		              <div id="helpBody" class="accordion-body collapse in">
		                <div class="accordion-inner">
	                	    <div class="alert alert-info alert-block">
						    	<a class="close" data-dismiss="alert" href="#">×</a>
						    	<h4 class="alert-heading">Warning!</h4>
						    	1、如果不能正确显示，请使用火狐浏览器<br/>
						    	2、添加节目时，填写内容简介、评论文章等内容时，如果是复制过来的内容，请先去除原来的样式，点击文本编辑框的“Remove Formatting”按钮<br/>
						    	3、编辑节目时，如果上传同名图片或视频，则新上传的会覆盖原来的
						    </div>
		                </div>
		              </div>
		            </div>
	            </div>
	            <!-- /帮助 -->
	            
	            <input id="page" type="hidden" value="<s:property value="page" />" />
	            <input id="pageCount" type="hidden" value="<s:property value="pageCount" />" />
	            <input id="count" type="hidden" value="<s:property value="count" />" />
  			</div>
  			
  		</div>
  	</div>
  </body>
</html>