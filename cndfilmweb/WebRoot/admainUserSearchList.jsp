<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Search User</title>
    
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
    <script type="text/javascript" src="./js/page.js"></script>
    <script type="text/javascript" src="./js/adminManagerUser.js"></script>
    
    <style type="text/css">
    	.fontStyle{
    		 font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
			  font-size: 13px;
			  line-height: 18px;
			  color: #333333;
    	}
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
              <li class="active"><a><i class="icon-list"></i>查询列表</a></li>
              <li><a href="listUsers"><i class="icon-chevron-left icon-white"></i>返回</a></li>
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
  				<div id="searchUserBlock" class="row-fluid">
  					<div class="span4">
  						<img src="./img/logo-name.png" />
  					</div>
  				</div>
  				<!-- 用户列表 -->
  				<div class="accordion pt30" id="managerUser">
	  				<div class="accordion-group">
		              <div class="accordion-heading">
		                <a class="accordion-toggle" data-toggle="collapse" data-parent="#filmDetail" style="cursor:default;"> 
		                  	<i class="icon-list-alt"></i>用户管理
		                </a>
		              </div>
		              <div id="filmDetailBody" class="accordion-body collapse in">
		                <div class="accordion-inner">
		                	<table class="table table-striped">
		                		<thead>
									<tr>
										<th><input type="checkbox" id="selectAll"></th>
										<th>用户名</th>
										<th>真实姓名</th>
										<th>工作单位</th>
										<th>工作部门</th>
										<th>工作证号</th>
										<th>邮箱</th>
										<th>电话</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody id="userListBody">
									<s:iterator value="userList" id="user">
										<s:if test="#user.isoverdue==1">
											<tr id="<s:property value="#user.id"/>" style="color:red">
										</s:if>
										<s:else>
											<tr id="<s:property value="#user.id"/>">
										</s:else>
											<td><input type="checkbox"/></td>
											<td><s:property value="#user.userName"/></td>
											<td><s:property value="#user.real_name"/></td>
											<td><s:property value="#user.workplace"/></td>
											<td><s:property value="#user.dept"/></td>
											<td><s:property value="#user.cert_number"/></td>
											<td><s:property value="#user.email"/></td>
											<td><s:property value="#user.tel"/></td>
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
							                <option value="1">赋予权限</option>
							                <option value="2">取消权限</option>
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
	            <s:form name="turnPage" method="post" action="searchUser">
	            	<s:hidden name="userName" value="%{#parameters.userName}"></s:hidden>
	            	<s:hidden name="realName" value="%{#parameters.realName}"></s:hidden>
	            	<s:hidden name="workPlace" value="%{#parameters.workPlace}"></s:hidden>
	            	<s:hidden name="dept" value="%{#parameters.dept}"></s:hidden>
	            	<s:hidden name="certNumber" value="%{#parameters.certNumber}"></s:hidden>
		            <input type="hidden" id="desPage" name="page" value="1"/>
	            </s:form>
	            <input type="hidden" id="page" value="<s:property value="page" />"/>
	            <input id="pageCount" type="hidden" value="<s:property value="pageCount" />" />
	            <input id="count" type="hidden" value="<s:property value="count" />" />
	            <!-- /用户列表 -->
	    	</div>
  		</div>
	</div>
  </body>
 </html>