<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <title>NewDetail</title>
    
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
              <li class="active"><a><i class="icon-file"></i>查看新闻动态</a></li>
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
		                  	<i class="icon-list-alt"></i>新闻动态详情
		                </a>
		              </div>
		              <div id="filmDetailBody" class="accordion-body collapse in">
		                <div class="accordion-inner">
		                	<s:property value="newTrendsBean.content" escape="false"/>
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