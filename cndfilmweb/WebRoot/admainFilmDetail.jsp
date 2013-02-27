<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Detail</title>
    
    <!-- css -->
    <link href="./css/bootstrap.css" rel="stylesheet">
    <link href="./css/bootstrap-responsive.css" rel="stylesheet">
    <link href="./css/docs.css" rel="stylesheet">
    <link href="./css/lightbox.css" rel="stylesheet">
    <link href="./css/detail.css" rel="stylesheet">
    <link href="./css/administrator.css" rel="stylesheet">
    
    <!-- js -->
    <script type="text/javascript" src="./js/jquery.js"></script>
    <script type="text/javascript" src="./js/bootstrap.js"></script>
    <script type="text/javascript" src="./js/application.js"></script>
    <script type="text/javascript" src="./js/jquery.form.js"></script>
    <script type="text/javascript" src="./js/jquery.MultiFile.js"></script>
    <script type="text/javascript" src="./js/galleria-1.2.8.min.js"></script>
    <script type="text/javascript" src="./js/jquery.isotope.min.js"></script>
    <script type="text/javascript" src="./js/lightbox.js"></script>
    <script type="text/javascript" src="./js/jquery.media.js"></script>
    <script type="text/javascript" src="./js/admin.detail.js"></script>
    <script type="text/javascript" src="./js/page.js"></script>
    
    <style type="text/css">
    	.fontStyle{
    		 font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
			  font-size: 13px;
			  line-height: 18px;
			  color: #333333;
    	}
    </style>
    <script type="text/javascript">
    </script>
    
  </head>
  <body style="background-color:#f5f5f5;">
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
              <li class="active"><a><i class="icon-file"></i>查看详情</a></li>
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
  				
  				<!-- 节目详情 -->
  				<div class="accordion pt30" id="filmDetail">
	  				<div class="accordion-group">
		              <div class="accordion-heading">
		                <a class="accordion-toggle" data-toggle="collapse" data-parent="#filmDetail" style="cursor:default;"> 
		                  	<i class="icon-list-alt"></i>节目详情
		                </a>
		              </div>
		              <div id="filmDetailBody" class="accordion-body collapse in">
		                <div class="accordion-inner">
		                	<ul class="thumbnails pt10">
		                		<li class="span12">
		                			<div class="thumbnail" style="background-color:#222;">
		                				<!-- 
		                				<div id="galleria">
						  					<s:if test="filmDetail.photoPath.count==0&&filmDetail.recommendPath.count==0">
								                <img src="./img/noneimg.jpg"/>			
						       				</s:if>
						       				<s:else>
						       					<s:iterator value="filmDetail.recommendPath" id="recommendPhotoPath">
		                							<img data-title="推荐图片" data-description="<s:property value='filmDetail.filmSubject' />" src="./uploadFiles/<s:property value="filmDetail.folder_name" />/picture/recommend/<s:property value='#recommendPhotoPath' />"/>
		                						</s:iterator>
						       				</s:else>
						  				</div> -->
						  				
						  				<!-- 剧照、海报 -->
								        <div class="navbar">
									    	<div class="navbar-inner">
									    		<div class="container">
									    			<ul id="filters" class="nav nav-pills" data-option-key="filter">
													    <li class="active"><a href="#filter" data-option-value="*">全部</a></li>
													    <li><a href="#filter" data-option-value=".recommend">推荐</a></li>
													    <li><a href="#filter" data-option-value=".photo">剧照</a></li>
													    <li><a href="#filter" data-option-value=".poster">海报</a></li>
													 </ul>
									    		</div>
									    	</div>
									    </div>
								         
									     <div id="container">
									     	<s:iterator value="filmDetail.recommendPath" id="recommendPhotoPath">
	                							<a class="element recommend" href="./uploadFiles/<s:property value="filmDetail.folder_name" />/picture/recommend/<s:property value='#recommendPhotoPath' />" rel="lightbox"><img src="./uploadFiles/<s:property value="filmDetail.folder_name" />/picture/recommend/<s:property value='#recommendPhotoPath' />"/></a>
	                						</s:iterator>
	                						<s:iterator value="filmDetail.photoPath" id="photoFileName">
	                							<a class="element photo" href="./uploadFiles/<s:property value="filmDetail.folder_name" />/picture/photo/<s:property value='#photoFileName' />" rel="lightbox"><img  src="./uploadFiles/<s:property value="filmDetail.folder_name" />/picture/photo/<s:property value='#photoFileName' />"/></a>
	                						</s:iterator>	
	                						<s:iterator value="filmDetail.posterPath" id="posterFileName">
	                							<a class="element poster" href="./uploadFiles/<s:property value="filmDetail.folder_name" />/picture/poster/<s:property value='#posterFileName' />" rel="lightbox"><img  src="./uploadFiles/<s:property value="filmDetail.folder_name" />/picture/poster/<s:property value='#posterFileName' />"/></a>
	                						</s:iterator>
									     </div>
		                			</div>
		                		</li>
		                	</ul>
		                	<ul class="thumbnails">
		                		<li class="span12">
		                			<div class="thumbnail pt10">
		                				<div style="margin:10px">
			                				<table class="table">
			                					<tbody>
			                						<tr>
			                							<td><h5>节目片名:</h5></td>
			                							<td><s:property value="filmDetail.filmName" /></td>
			                							<td><h5>出品日期:</h5></td>
			                							<td><s:property value="filmDetail.filmTime" /></td>
			                							<td><h5>节目类型:</h5></td>
			                							<td><s:property value="filmDetail.filmType" /></td>
			                							<td><h5>节目时长:</h5></td>
			                							<td><s:property value="filmDetail.filmLength" /></td>
			                						</tr>
			                						<tr>
			                							<td><h5>节目格式:</h5></td>
			                							<td><s:property value="filmDetail.standard" /></td>
			                							<td><h5>导演（编剧）:</h5></td>
			                							<td><s:property value="filmDetail.director" /></td>
			                							<td><h5>职员:</h5></td>
			                							<td><s:property value="filmDetail.employee" /></td>
			                							<td><h5>链接:</h5></td>
			                							<td><s:property value="filmDetail.link" /></td>
			                						</tr>
			                						<tr>
			                							<td><h5>制作单位:</h5></td>
			                							<td><s:property value="filmDetail.producer" /></td>
			                							<td><h5>添加时间:</h5></td>
			                							<td><s:property value="filmDetail.ctime" /></td>
			                							<td><h5>是否推荐:</h5></td>
			                							<td>
			                								<s:if test="filmDetail.recommend==1">
							                					是
							                				</s:if>
						                					<s:else>
						                						否
						                					</s:else>
						                				</td>
			                							<td><h5>推荐主题:</h5></td>
			                							<td><s:property value="filmDetail.filmSubject" /></td>
			                						</tr>
			                					</tbody>
			                				</table>
			                				<div class="row-fluid pt10" >
			                					<div class="span6">
			                						<div class="scrollspy-example fontStyle" >
					                					<h4>节目内容:</h4><br>
					                					<s:property value="filmDetail.filmIntro" escape="false"/>
					                				</div>
					                				<hr>
			                					</div>
			                					<div class="span6">
			                						<div class="scrollspy-example fontStyle">
					                					<h4>获奖情况:</h4><br>
					                					<s:property value="filmDetail.awards" escape="false"/>
					                				</div>
					                				<hr>
			                					</div>
			                				</div>
			                				<div class="row-fluid">
			                					<div class="span6">
			                						<div class="scrollspy-example fontStyle" >
					                					<h4>播出情况:</h4><br>
					                					<s:property value="filmDetail.broadcastSituation" escape="false"/>
					                				</div>
					                				<hr>
			                					</div>
			                					<div class="span6">
			                						<div class="scrollspy-example fontStyle">
					                					<h4>媒体宣传:</h4><br>
					                					<s:property value="filmDetail.media" escape="false"/>
					                				</div>
					                				<hr>
			                					</div>
			                				</div>
			                				<div class="row-fluid">
			                					<div class="span12">
			                						<div class="scrollspy-example fontStyle" >
					                					<h4>评论文章:</h4><br>
					                					<s:property value="filmDetail.comment" escape="false"/>
					                				</div>
					                				<hr>
			                					</div>
			                				</div>
			                				<div class="row-fluid">
			                					<div class="span12">
			                						<div class="scrollspy-example fontStyle">
					                					<h4>台本/解说词:</h4><br>
					                					<s:property value="filmDetail.commentary" escape="false"/>
					                				</div>
			                					</div>
			                				</div>
		                				</div>
		                			</div>
		                		</li>
		                	</ul>
		                	<s:if test="filmDetail.videoPath.size()!=0">
		                		<ul class="thumbnails">
			                		<li class="span12">
			                			<div class="thumbnail">
			                				<s:iterator value="filmDetail.videoPath" id="videoPath" status="st">
			                					<s:if test="#st.first && #st.last">
			                						<div class="row-fluid">
			                							<div class="span6">
			                								<a class="media" href="./mediaplayer/player.swf?file=../uploadFiles/<s:property value="filmDetail.folder_name" />/video/<s:property value="#videoPath.videoName" />"></a>
			                							</div>
			                						</div>
			                					</s:if>
			                					<s:elseif test="#st.first && !#st.last">
			                						<div class="row-fluid">
			                							<div class="span6">
			                								<a class="media" href="./mediaplayer/player.swf?file=../uploadFiles/<s:property value="filmDetail.folder_name" />/video/<s:property value="#videoPath.videoName" />"></a>
			                							</div>
			                					</s:elseif>
			                					<s:elseif test="#st.last && #st.even">
				                						<div class="span6">
				                							<a class="media" href="./mediaplayer/player.swf?file=../uploadFiles/<s:property value="filmDetail.folder_name" />/video/<s:property value="#videoPath.videoName" />"></a>
				                						</div>
				                					</div>
			                					</s:elseif>
			                					<s:elseif test="#st.last && #st.odd">
			                						<div class="row-fluid">
				                						<div class="span6">
				                							<a class="media" href="./mediaplayer/player.swf?file=../uploadFiles/<s:property value="filmDetail.folder_name" />/video/<s:property value="#videoPath.videoName" />"></a>
				                						</div>
				                					</div>
			                					</s:elseif>
			                					<s:elseif test="#st.even">
			                							<div class="span6">
				                							<a class="media" href="./mediaplayer/player.swf?file=../uploadFiles/<s:property value="filmDetail.folder_name" />/video/<s:property value="#videoPath.videoName" />"></a>
				                						</div>
				                					</div>
			                					</s:elseif>
			                					<s:else>
			                						<div class="row-fluid">
			                							<div class="span6">
			                								<a class="media" href="./mediaplayer/player.swf?file=../uploadFiles/<s:property value="filmDetail.folder_name" />/video/<s:property value="#videoPath.videoName" />"></a>
			                							</div>
			                					</s:else>
			                				</s:iterator>
			                			</div>
			                		</li>
			                	</ul>
		                	</s:if>
		                	
		                </div>
		              </div>
		            </div>
	            </div>
	            <!-- /节目详情 -->
	    	</div>
  		</div>
	</div>
  </body>
 </html>