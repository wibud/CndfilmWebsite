<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Search Film</title>
    
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
    <script type="text/javascript" src="./js/jquery.MultiFile.js"></script>
    <script type="text/javascript" src="./js/administrator.js"></script>
    <script type="text/javascript" src="./js/page.js"></script>
    
    <style type="text/css">
    	
    </style>
     <script type="text/javascript">
    $(document).ready(function(){
//      var param = '&director='+$('#director').val()+'&filmName='+$('#filmName').val()+'&filmTime='+$('#filmTime').val()+'&filmType='+$('#filmType').val()+'&filmKeyword='+$('#filmKeyword').val()+'&filmLength='+$('#filmLength').val()+'&standard='+$('#standard').val()+'&awards='+$('#awards').val();
//    	createPage('searchFilm',param);
    	createPageByFormSumit();
    });
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
              <li class="active"><a><i class="icon-list"></i>查询列表</a></li>
              <li><a href="adminManager.action"><i class="icon-chevron-left icon-white"></i>返回</a></li>
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
  				<div class="row-fluid">
  					<div class="span4">
  						<img src="./img/logo-name.png" />
  					</div>
  				</div>
  				
  				<!-- 节目列表 -->
  				<div class="accordion pt30" id="filmtabls">
	  				<div class="accordion-group">
		              <div class="accordion-heading">
		                <a class="accordion-toggle" data-toggle="collapse" data-parent="#filmtabls" style="cursor:default;"> 
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
	            <s:form name="turnPage" method="post" action="searchFilm">
		            <s:hidden name="filmType" value="%{#parameters.filmType}"></s:hidden>
		            <s:hidden name="director" value="%{#parameters.director}"></s:hidden>
		            <s:hidden name="filmName" value="%{#parameters.filmName}"></s:hidden>
		            <s:hidden name="filmTime" value="%{#parameters.filmTime}"></s:hidden>
		            <s:hidden name="filmKeyword" value="%{#parameters.filmKeyword}"></s:hidden>
		            <s:hidden name="filmLength" value="%{#parameters.filmLength}"></s:hidden>
		            <s:hidden name="standard" value="%{#parameters.standard}"></s:hidden>
		            <s:hidden name="awards" value="%{#parameters.awards}"></s:hidden>
		            <input type="hidden" id="desPage" name="page" value="1"/>
	            </s:form>
	            <input type="hidden" id="page" value="<s:property value="page" />"/>
	            <input id="pageCount" type="hidden" value="<s:property value="pageCount" />" />
	            <input id="count" type="hidden" value="<s:property value="count" />" />
	    	</div>
  		</div>
	</div>
  </body>
 </html>