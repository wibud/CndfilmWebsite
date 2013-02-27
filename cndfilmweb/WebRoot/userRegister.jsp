<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="oa.bean.UserBean" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<title>用户注册</title>

		<!-- css -->
		<link href="./css/jquery.ennui.contentslider.css" rel="stylesheet" type="text/css" media="screen,projection" />
		<link href="./css/bootstrap.css" rel="stylesheet">
		<link href="./css/bootstrap-responsive.css" rel="stylesheet">
		<link href="./css/rainbows.css" rel="stylesheet" type="text/css" />
		<link href="./css/base.css" rel="stylesheet" type="text/css" />

		<!-- slider css -->
		<link href="./css/slider.css" rel="stylesheet">

		<!-- js -->
		<script src="./js/jquery.js"></script>
		<script src="./js/bootstrap.js"></script>

		<!--slider js  -->
		<script type="text/javascript" src="./js/jquery.nivo.slider.js"></script>
		<script type="text/javascript" src="./js/cufon-yui.js"></script>
		<script type="text/javascript" src="./js/scripts.js"></script>
		<script type="text/javascript" src="./js/custom.js"></script>
		<script type="text/javascript" src="./js/jquery.form.js"></script>
		<script type="text/javascript" src="./js/rainbows.js"></script>
		<script type="text/javascript" src="./js/base.js"></script>
		<script type="text/javascript" src="./js/register.js"></script>
		<script type="text/javascript" src="./js/login.js"></script>

		<script language="javascript" type="text/javascript">
			function clearText(field) {
				if (field.defaultValue == field.value)
					field.value = '';
				else if (field.value == '')
					field.value = field.defaultValue;
			}

		</script>
	</head>
	<body>

		<div id="wrapper">

			<div id="header_bar">
				<div id="header">
				</div>
				<!--
				<div id="search_box">
					<form action="#" method="get">
						<input type="text" value="请输入搜索内容" name="q" size="10"
							id="searchfield" title="searchfield" onfocus="clearText(this)"
							onblur="clearText(this)" />
						<input type="image" src="images/search_button.png" name="Search"
							value="search" alt="搜索" id="searchbutton" title="Search" />
					</form>
				</div>
				-->
				<div id="search_box" style="text-align:center">
					<%if(session.getAttribute("user")==null){ %>
						<a style="color:#000000" href="#login" data-toggle="modal">登录</a>
						<span style="color:#999999">|</span>
						<a style="color:#000000" href="registerPage">注册</a>
						<div id="login" class="modal hide fade">
				            <div class="modal-body">
			            		<fieldset class="form-horizontal">
				            		 <div class="control-group">
							            <label class="control-label" for="loginUserName">用户名：</label>
							            <div class="controls">
							              <input type="text" class="input-xlarge" id="loginUserName">
							            </div>
							          </div>
							          <div class="control-group">
							            <label class="control-label" for="loginPswd">密码：</label>
							            <div class="controls">
							              <input type="password" class="input-xlarge" id="loginPswd">
							            </div>
							          </div>
				            	</fieldset>
				            </div>
				            <div class="modal-footer">
				              <button class="btn btn-danger" id="loginButton">登录</button>
				            </div>
				        </div>
					<%}else{ %>
						<span>欢迎您   <%=((UserBean)session.getAttribute("user")).getUserName() %></span>
						<span style="color:#999999">|</span>
						<a style="color:#000000" href="#modifyPswd" data-toggle="modal">修改密码</a>
						<div id="modifyPswd" class="modal hide fade">
				            <div class="modal-body">
			            		<fieldset class="form-horizontal">
				            		 <div class="control-group">
							            <label class="control-label" for="loginNewPswd">新密码：</label>
							            <div class="controls">
							              <input type="password" class="input-xlarge" id="loginNewPswd">
							            </div>
							          </div>
							          <div class="control-group">
							            <label class="control-label" for="loginAssurePswd">确认密码：</label>
							            <div class="controls">
							              <input type="password" class="input-xlarge" id="loginAssurePswd">
							            </div>
							          </div>
				            	</fieldset>
				            </div>
				            <div class="modal-footer">
				              <button class="btn btn-danger" id="modifyPswdButton">确认修改</button>
				            </div>
				        </div>
					<%} %>
				</div>
			</div>
			<!-- end of templatemo_site_title_bar -->

			<div id="banner">
				<div id="menu">
					<ul>
						<li>
							<a href="index" target="_parent" ><span></span>
								<ul>
									<li>首页</li>
									<li class='labelmenu'>Home</li>
								</ul>
							</a>
						</li>
						<li>
							<a href="filmLibrary" target="_parent"><span></span>
								<ul>
									<li>影片库</li>
									<li class='labelmenu'>Film Library</li>
								</ul>
							</a>
						</li>
						<li>
							<a href="advancedSearch" target="_parent"><span></span>
								<ul>
									<li>高级查询</li>
									<li class='labelmenu'>Advanced Search</li>
								</ul>
							</a>
						</li>
						<li>
							<a href="newTrends" target="_parent"><span></span>
								<ul>
									<li>新闻动态</li>
									<li class='labelmenu'>News</li>
								</ul>
							</a>
						</li>
						<li>
							<a href="index?linkTo=contactUs" target="_parent"><span></span>
								<ul>
									<li>联系我们</li>
									<li class='labelmenu'>Contact Us</li>
								</ul>
							</a>
						</li>

					</ul>
				</div>
				<!-- end of menu -->

				<!--Slider-->

				<div id="slider-bg">
					<div class="full-width-wrapper" id="slider-frame">
						<div class="fixed-width-wrapper maxx-theme" id="slider-wrapper">

							<div id="slider" class="nivoSlider">
								
								<s:iterator value="recommendFilmList" id="recommendFilm" status="st">
									<a id="<s:property value="#recommendFilm.seq" />" href="javascript:void(0);" onclick="seeDetail(this.id);"><img src="./uploadFiles/<s:property value="#recommendFilm.folder_name" />/picture/recommend/recommendPicture.jpg" title="#htmlcaption<s:property value="#st.index" />">
									</a>
								</s:iterator>
							</div>
							
							<s:iterator value="recommendFilmList" id="recommendFilm" status="st">
								<div id="htmlcaption<s:property value="#st.index" />" class="nivo-html-caption">
									<s:property value="#recommendFilm.filmSubject" />
								</div>
							</s:iterator>

						</div>
					</div>
				</div>

				<!-- /Slider -->

			</div>
			<!-- end of banner -->
			<div id="content">
				<div id="body-content" class="body-divider">
					<h2 class="title" style="text-align: center">用户注册</h2>
					<h4 class="sub_title">Register</h4>
					<s:form cssClass="form-horizontal" action="userRegister" id="registerForm">
						<div class="control-group">
							<label class="control-label" for="userName">用户名：</label><label id="userNameError" class="error hidden"></label>
							<div class="controls">
								<input type="text" style="width:290px;" id="userName" name="userName"/>
						 	</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="pswd">密码：</label><label id="pswdError" class="error hidden"></label>
							<div class="controls">
								<input type="password" style="width:290px;" id="pswd" name="pswd"/>
						 	</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="assurePswd">确认密码：</label><label id="assurePswdError" class="error hidden"></label>
							<div class="controls">
								<input type="password" style="width:290px;" id="assurePswd"/>
						 	</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="realName">真实姓名：</label><label id="realNameError" class="error hidden"></label>
							<div class="controls">
								<input type="text" style="width:290px;" id="realName" name="realName"/>
						 	</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="workPlace">工作单位：</label><label id="workPlaceError" class="error hidden"></label>
							<div class="controls">
								<input type="text" style="width:290px;" id="workPlace" name="workPlace"/>
						 	</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="dept">工作部门：</label><label id="deptError" class="error hidden"></label>
							<div class="controls">
								<input type="text" style="width:290px;" id="dept" name="dept"/>
						 	</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="certNumber">工作证号：</label><label id="certNumberError" class="error hidden"></label>
							<div class="controls">
								<input type="text" style="width:290px;" id="certNumber" name="certNumber"/>
						 	</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="email">Email：</label><label id="emailError" class="error hidden"></label>
							<div class="controls">
								<input type="text" style="width:290px;" id="email" name="email"/>
						 	</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="tel">手机号：</label><label id="telError" class="error hidden"></label>
							<div class="controls">
								<input type="text" style="width:290px;" id="tel" name="tel"/>
						 	</div>
						</div>
					</s:form>
					<a class="btn-style" style="color:#FFFFFF;margin-right:250px;" id="registerButton" href="javascript:void(0);"><strong>确定 Register</strong></a>
				</div>
				<div class="clear"></div>
			</div>

			<div id="content_bottom"></div>

			<div id="footer">
				<ul class="footer_menu">
					<li>
						<a href="index">首页 Home</a>
					</li>
					<li>
						<a href="filmLibrary">影片库 Film Library</a>
					</li>
					<li>
						<a href="advancedSearch">高级查询 Advanced Search</a>
					</li>
					<li>
						<a href="newTrends">新闻动态 News</a>
					</li>
					<li class="last_menu">
						<a href="index?linkTo=contactUs">联系我们 Contact Us</a>
					</li>
				</ul>

				<a href="http://www.cndfilm.com/01/index.shtml">中央新影</a>
			</div>
			<!-- end of footer -->
		</div>
		<!-- end of templatemo_wrapper -->
	</body>

</html>
