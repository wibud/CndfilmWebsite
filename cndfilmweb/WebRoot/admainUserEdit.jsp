<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <title>EditUser</title>
    
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
    <script type="text/javascript" src="./js/userEdit.js"></script>
    
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
              <li class="active"><a><i class="icon-list"></i>编辑用户</a></li>
              <li>
					<a href="javascript:void(0);" onclick="javascript:history.back();"><i class="icon-chevron-left icon-white"></i>返回</a>
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
  				
  				<!-- 编辑新闻动态 -->
  				<div class="accordion pt30" id="filmDetail">
	  				<div class="accordion-group">
		              <div class="accordion-heading">
		                <a class="accordion-toggle" data-toggle="collapse" data-parent="#filmDetail" style="cursor:default;"> 
		                  	<i class="icon-pencil"></i>编辑用户
		                </a>
		              </div>
		              <div id="filmDetailBody" class="accordion-body collapse in">
		                <div class="accordion-inner">
		                	<s:form cssClass="form-horizontal" id="editUserForm" method="post" action="editUser">
		                		<fieldset>
		                			<input type="hidden" value="<s:property value="userBean.id" />" name="id"/>
			                			<div class="control-group">
									  <label class="control-label" for="userName">用户名:</label>
									  <div class="controls">
									    <input type="text" class="input-xlarge" id="userName" value="<s:property value='userBean.userName' />" name="userName">
									  </div>
									</div>
									<div class="control-group">
									  <label class="control-label" for="real_name">真实姓名:</label>
									  <div class="controls">
									    <input type="text" class="input-xlarge" id="real_name" value="<s:property value='userBean.real_name' />" name="realName">
									  </div>
									</div>
									<div class="control-group">
									  <label class="control-label" for="workplace">工作单位:</label>
									  <div class="controls">
									    <input type="text" class="input-xlarge" id="workplace" value="<s:property value='userBean.workplace' />" name="workPlace">
									  </div>
									</div>
									<div class="control-group">
									  <label class="control-label" for="dept">工作部门:</label>
									  <div class="controls">
									    <input type="text" class="input-xlarge" id="dept" value="<s:property value='userBean.dept' />" name="dept">
									  </div>
									</div>
									<div class="control-group">
									  <label class="control-label" for="cert_number">工作证号:</label>
									  <div class="controls">
									    <input type="text" class="input-xlarge" id="cert_number" value="<s:property value='userBean.cert_number' />" name="certNumber">
									  </div>
									</div>
									<div class="control-group">
									  <label class="control-label" for="email">Email:</label>
									  <div class="controls">
									    <input type="text" class="input-xlarge" id="email" value="<s:property value='userBean.email' />" name="email">
									  </div>
									</div>
									<div class="control-group">
									  <label class="control-label" for="tel">电话:</label>
									  <div class="controls">
									    <input type="text" class="input-xlarge" id="tel" value="<s:property value='userBean.tel' />" name="tel">
									  </div>
									</div>
									<div class="control-group">
									  <label class="control-label" for="rule">权限:</label>
									  <div class="controls">
									  	<s:if test="userBean.rule==1">
									  		<input type="radio" id="rule" value="1" checked="checked" name="rule">是
									    	<input type="radio" value="0" name="rule">否
									  	</s:if>
									    <s:else>
									    	<input type="radio" id="rule" value="1" name="rule">是
									    	<input type="radio" value="0" checked="checked" name="rule">否
									    </s:else>
									  </div>
									</div>
		                		</fieldset>
		                	</s:form>
		                	<div class="form-actions">
							  <button id="editSave" class="btn btn-danger">确定修改</button>
							</div>
		                </div>
		              </div>
		            </div>
	            </div>
	            <!-- /编辑新闻动态 -->
	    	</div>
  		</div>
	</div>
  </body>
 </html>