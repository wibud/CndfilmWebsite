<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <title>UserDetail</title>
    
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
              <li class="active"><a><i class="icon-file"></i>查看用户</a></li>
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
		                  	<i class="icon-list-alt"></i>用户详情
		                </a>
		              </div>
		              <div id="filmDetailBody" class="accordion-body collapse in">
		                <div class="accordion-inner">
		                	<fieldset class="form-horizontal">
		                		<div class="control-group">
								  <label class="control-label" for="userName">用户名:</label>
								  <div class="controls">
								    <input type="text" class="input-xlarge" id="userName" value="<s:property value='userBean.userName' />" disabled="disabled">
								  </div>
								</div>
								<div class="control-group">
								  <label class="control-label" for="real_name">真实姓名:</label>
								  <div class="controls">
								    <input type="text" class="input-xlarge" id="real_name" value="<s:property value='userBean.real_name' />" disabled="disabled">
								  </div>
								</div>
								<s:if test="userBean.isoverdue==1">
									<div class="control-group">
									  <label class="control-label" for="pswd">密码:</label>
									  <div class="controls">
									    <input type="text" class="input-xlarge" id="pswd" value="<s:property value='userBean.pswd' />" disabled="disabled">
									  </div>
									</div>
								</s:if>
								<div class="control-group">
								  <label class="control-label" for="workplace">工作单位:</label>
								  <div class="controls">
								    <input type="text" class="input-xlarge" id="workplace" value="<s:property value='userBean.workplace' />" disabled="disabled">
								  </div>
								</div>
								<div class="control-group">
								  <label class="control-label" for="dept">工作部门:</label>
								  <div class="controls">
								    <input type="text" class="input-xlarge" id="dept" value="<s:property value='userBean.dept' />" disabled="disabled">
								  </div>
								</div>
								<div class="control-group">
								  <label class="control-label" for="cert_number">工作证号:</label>
								  <div class="controls">
								    <input type="text" class="input-xlarge" id="cert_number" value="<s:property value='userBean.cert_number' />" disabled="disabled">
								  </div>
								</div>
								<div class="control-group">
								  <label class="control-label" for="email">Email:</label>
								  <div class="controls">
								    <input type="text" class="input-xlarge" id="email" value="<s:property value='userBean.email' />" disabled="disabled">
								  </div>
								</div>
								<div class="control-group">
								  <label class="control-label" for="tel">电话:</label>
								  <div class="controls">
								    <input type="text" class="input-xlarge" id="tel" value="<s:property value='userBean.tel' />" disabled="disabled">
								  </div>
								</div>
								<div class="control-group">
								  <label class="control-label" for="rule">权限:</label>
								  <div class="controls">
								  	<s:if test="userBean.rule==1">
								  		<input type="checkbox" id="rule" disabled="disabled" checked="checked">是
								    	<input type="checkbox" disabled="disabled">否
								  	</s:if>
								    <s:else>
								    	<input type="checkbox" id="rule" disabled="disabled">是
								    	<input type="checkbox" disabled="disabled" checked="checked">否
								    </s:else>
								  </div>
								</div>
								<div class="control-group">
								  <label class="control-label" for="ctime">注册时间:</label>
								  <div class="controls">
								    <input type="text" class="input-xlarge" id="ctime" value="<s:property value='userBean.ctime' />" disabled="disabled">
								  </div>
								</div>
		                	</fieldset>
		                	
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