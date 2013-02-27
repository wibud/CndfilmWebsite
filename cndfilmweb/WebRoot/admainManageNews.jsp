<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <title>News</title>
    
    <!-- css -->
    <link href="./css/bootstrap.css" rel="stylesheet">
    <link href="./css/bootstrap-responsive.css" rel="stylesheet">
    <link href="./css/docs.css" rel="stylesheet">
    <link href="./css/default.css" rel="stylesheet">
    <link href="./css/administrator.css" rel="stylesheet">
    <link href="./css/nav.css" rel="stylesheet">
    
    <!-- js -->
    <script type="text/javascript" src="./js/jquery.js"></script>
    <script type="text/javascript" src="./js/bootstrap.js"></script>
    <script type="text/javascript" src="./js/application.js"></script>
    <script type="text/javascript" src="./js/jquery.form.js"></script>
    <script type="text/javascript" src="./js/nicEdit.js"></script>
    <script type="text/javascript" src="./js/glDatePicker.min.js"></script>
    <script type="text/javascript" src="./js/page.js"></script>
    <script type="text/javascript" src="./js/newsManage.js"></script>
    
    <style type="text/css">
    </style>
    <script type="text/javascript">
    $(document).ready(function(){
    	createPageByFormSumit();
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
              <li><a href="#addNews">添加动态</a></li>
              <li><a href="#managerNews">新闻动态管理</a></li>
            </ul>
       	</div>
	</div>
	<!--/ admin manager navbar -->
	<div class="container-fluid">
		<div class="row-fluid" style="">
  			<div class="span3" style="width:250px;"></div>
  			<div class="span9" style="height:100%;">
  				<div id="addNews" class="row-fluid">
  					<div class="span4">
  						<img src="./img/logo-name.png" />
  					</div>
  				</div>
  				
  				<!-- 添加动态 -->
  				<div class="accordion pt30" id="news">
	  				<div class="accordion-group">
		              <div class="accordion-heading">
		                <a class="accordion-toggle" data-toggle="collapse" data-parent="#news" href="#newsBody"> 
		                  	<i class="icon-list-alt"></i>添加动态
		                </a>
		              </div>
		              <div id="newsBody" class="accordion-body collapse in">
		                <div class="accordion-inner">
		                	<s:form cssClass="form-horizontal" id="addNewsForm" method="post" action="addNewTrends" name="addNewsForm">
			                	<fieldset>
			                		<div class="control-group">
										<label class="control-label" for="title">标题：</label>
										<div class="controls">
											<input class="span12" id="title" type="text" name="title"></input>
									 	</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="time">时间：</label>
										<div class="controls">
											<input class="input-large" id="time" type="text" readonly="readonly" name="time"></input>
									 	</div>
									</div>
			                		<div class="control-group">
										<label class="control-label" for="newsContent">内容：</label>
										<div class="controls">
											<textarea class="span12" id="newsContent" rows="20"></textarea>
									 	</div>
									</div>
									<input type="hidden" id="newsContentInput" name="content" />
			                	</fieldset>
			                </s:form>
		                	<div class="form-actions">
							  <button id="newSave" class="btn btn-danger">添加</button>
							</div>
		                </div>
		              </div>
		            </div>
		        </div>
		        <!-- /添加动态 -->
		        <!-- 动态管理 -->
		        <div class="accordion" id="managerNews">
	  				<div class="accordion-group">
		              <div class="accordion-heading">
		                <a class="accordion-toggle" data-toggle="collapse" data-parent="#managerNews" href="#managerNewsBody"> 
		                  	<i class="icon-list-alt"></i>新闻动态管理
		                </a>
		              </div>
		              <div id="managerNewsBody" class="accordion-body collapse in">
		                <div class="accordion-inner">
		                	<table class="table table-striped">
		                		<thead>
									<tr>
										<th>标题</th>
										<th>时间</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<s:iterator value="newTrendsList" id="newTrend">
										<tr id="<s:property value="#newTrend.seq"/>">
											<td><s:property value="#newTrend.title"/></td>
											<td><s:property value="#newTrend.time"/></td>
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
		        <!-- /动态管理 -->
		        <s:form name="turnPage" method="post" action="listNewTrends">
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