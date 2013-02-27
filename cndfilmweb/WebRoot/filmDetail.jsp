<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="oa.bean.UserBean" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<title>影片详情</title>

		<!-- css -->
		<link href="./css/jquery.ennui.contentslider.css" rel="stylesheet" type="text/css" media="screen,projection" />
		<link href="./css/bootstrap.css" rel="stylesheet">
		<link href="./css/bootstrap-responsive.css" rel="stylesheet">
		<link href="./css/rainbows.css" rel="stylesheet" type="text/css" />
		<link href="./css/lightbox.css" rel="stylesheet">
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
		<script type="text/javascript" src="./js/rainbows.js"></script>
		<script type="text/javascript" src="./js/lightbox.js"></script>
		<script type="text/javascript" src="./js/base.js"></script>
		<script type="text/javascript" src="./js/detail.js"></script>
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
							<a href="index" target="_parent"><span></span>
								<ul>
									<li>首页</li>
									<li class='labelmenu'>Home</li>
								</ul>
							</a>
						</li>
						<li>
							<a target="_parent" class="current"><span></span>
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
				<div id="body-content">
					<div class="header-text">
						<ul id="breadcrumbs">
							<li><a>影片库 Film Library</a></li>
							<li class="current"><a>详情 Detail</a></li>
						</ul>
						<h2 class="double-color sp" style="color:#454545;"><s:property value="filmDetail.filmName" /></h2>
					</div>
					<s:if test="filmDetail.link!=''">
						<div class="detailBlock">
							<span class="category">
								<a href="<s:property value="filmDetail.link" />">专题链接</a>
							</span>
						</div>
					</s:if>
					<div class="detailThreeBlock">
						<a class="detailTitle">出品日期：<s:property value="filmDetail.filmTime" /></a>
					</div>
					<div class="detailThreeBlock">
						<a class="detailTitle">节目类型：<s:property value="filmDetail.filmType" /></a>
					</div>
					<div class="detailThreeBlock">
						<a class="detailTitle">节目时长：<s:property value="filmDetail.filmLength" /></a>
					</div>
					<div class="detailThreeBlock">
						<a class="detailTitle">节目规格：<s:property value="filmDetail.standard" /></a>
					</div>
					<div class="detailThreeBlock" style="width:490px;">
						<div style="float:left;width:110px;">
							<a class="detailTitle">导演(编剧)：</a>
						</div>
						<div style="float:left;width:370px;height:32px;line-height:30px;height:auto;">
							<s:property value="filmDetail.director" />
						</div>
					</div>
					<%if(session.getAttribute("user")!=null && ((UserBean)session.getAttribute("user")).getRule().equals("1")){ %>
						<div class="detailBlock">
							<div style="float:left;width:100px;">
								<a class="detailTitle">制作单位：</a>
							</div>
							<div style="float:left;width:630px;height:32px;line-height: 30px;height:auto;">
								<s:property value="filmDetail.producer" />
							</div>
						</div>
					<%} %>
					<div class="detailBlock">
						<div style="float:left;width:78px;">
							<a class="detailTitle">职员：</a>
						</div>
						<div style="float:left;width:630px;height:32px;line-height: 30px;height:auto;">
							<s:property value="filmDetail.employee" />
						</div>
					</div>
					<div class="detailBlock">
						<div style="float:left;width:100px;">
							<a class="detailTitle">节目内容：</a>
						</div>
						<div style="float:left;width:630px;height:32px;line-height: 30px;height:auto;">
							<s:property value="filmDetail.filmIntro" escape="false"/>
						</div>
					</div>
					<div class="detailBlock">
						<div style="float:left;width:100px;">
							<a class="detailTitle">获奖情况：</a>
						</div>
						<div style="float:left;width:630px;height:32px;line-height: 30px;height:auto;">
							<s:property value="filmDetail.awards" escape="false"/>
						</div>
					</div>
					<div class="detailBlock">
						<div style="float:left;width:100px;">
							<a class="detailTitle">播出情况：</a>
						</div>
						<div style="float:left;width:630px;height:32px;line-height: 30px;height:auto;">
							<s:property value="filmDetail.broadcastSituation" escape="false"/>
						</div>
					</div>
					<div class="detailBlock">
						<div style="float:left;width:100px;">
							<a class="detailTitle">媒体宣传：</a>
						</div>
						<div style="float:left;width:630px;height:32px;line-height: 30px;height:auto;">
							<s:property value="filmDetail.media" escape="false"/>
						</div>
					</div>
					<div class="detailBlock">
						<div style="float:left;width:100px;">
							<a class="detailTitle">评论文章：</a>
						</div>
						<div style="float:left;width:630px;line-height: 30px;max-height:300px;overflow:hidden;">
							<div style="max-height:268px;overflow:hidden;">
								<s:property value="filmDetail.comment" escape="false"/>
							</div>
							<div style="height:32px;">
								<a class="read-more" href="javascript:seeComment(<s:property value="filmDetail.seq" />);" style="float:right;"></a>
							</div>
						</div>
					</div>
					<%if(session.getAttribute("user")!=null && ((UserBean)session.getAttribute("user")).getRule().equals("1")){ %>
						<div class="detailBlock">
							<div style="float:left;width:120px;">
								<a class="detailTitle">台本/解说词：</a>
							</div>
							<div style="float:left;width:610px;line-height: 30px;max-height:300px;overflow:hidden;">
								<div style="max-height:268px;overflow:hidden;">
									<s:property value="filmDetail.commentary" escape="false"/>
								</div>
								<div style="height:32px;">
									<a class="read-more" href="javascript:seeCommentary(<s:property value="filmDetail.seq" />);" style="float:right;"></a>
								</div>
							</div>
						</div>
					<%} %>
					<div class="detailBlock">
						<div style="float:left;width:78px;">
							<a class="detailTitle">剧照：</a>
						</div>
						<div style="float:left;width:652px;line-height: 30px;height:auto;">
							<s:iterator value="filmDetail.photoPath" id="photoPath" status="st">
								<s:if test="#st.count <= 3">
									<div class="photoBlock">
										<div class="img-border preloading-light" style="position: relative;">
											<a class="imgAnchor" rel="lightbox[Photo]" href="./uploadFiles/<s:property value="filmDetail.folder_name" />/picture/photo/<s:property value="#photoPath" />" ><img title="Photo" width="188px" height="100px" style="visibility: visible; opacity: 1;" src="./uploadFiles/<s:property value="filmDetail.folder_name" />/picture/photo/<s:property value="#photoPath" />"/><div></div></a>
										</div>
									</div>
								</s:if>
							</s:iterator>
							<div class="clear"></div>
							<s:if test="filmDetail.photoPath.size >= 4">
								<div style="height:32px;padding-top:15px;">
									<a class="read-more" href="javascript:seePhoto(<s:property value="filmDetail.seq" />);" style="float:right;"></a>
								</div>
							</s:if>
						</div>
					</div>
					<div class="detailBlock">
						<div style="float:left;width:78px;">
							<a class="detailTitle">海报：</a>
						</div>
						<div style="float:left;width:652px;height:32px;line-height: 30px;height:auto;">
							<s:iterator value="filmDetail.posterPath" id="posterPath" status="st">
								<s:if test="#st.count <= 3">
									<div class="photoBlock">
										<div class="img-border preloading-light" style="position: relative;">
											<a class="imgAnchor" rel="lightbox[Poster]" href="./uploadFiles/<s:property value="filmDetail.folder_name" />/picture/poster/<s:property value="#posterPath" />" ><img title="Poster" width="188px" height="100px" style="visibility: visible; opacity: 1;" src="./uploadFiles/<s:property value="filmDetail.folder_name" />/picture/poster/<s:property value="#posterPath" />"/><div></div></a>
										</div>
									</div>
								</s:if>
							</s:iterator>
							<div class="clear"></div>
							<s:if test="filmDetail.posterPath.size >= 4">
								<div style="height:32px;padding-top:15px;">
									<a class="read-more" href="javascript:seePoster(<s:property value="filmDetail.seq" />);" style="float:right;"></a>
								</div>
							</s:if>
						</div>
					</div>
					<div class="detailBlock">
						<div style="float:left;width:78px;">
							<a class="detailTitle">花絮：</a>
						</div>
						<div style="float:left;width:652px;height:32px;line-height: 30px;height:auto;">
							<s:iterator value="filmDetail.videoPath" id="videoBean" status="st">
								<s:if test="#st.count <= 3">
									<div class="photoBlock">
										<div class="img-border preloading-light" style="position: relative;">
											<a class="videoAnchor" href="javascript:seeVideo(<s:property value="filmDetail.seq" />,'<s:property value="#videoBean.videoName" />');"><img width="188px" height="100px" style="visibility: visible; opacity: 1;" src="./uploadFiles/<s:property value="filmDetail.folder_name" />/video/screen/<s:property value="#videoBean.videoScreenName" />"/><div></div></a>
										</div>
									</div>
								</s:if>
							</s:iterator>
							<div class="clear"></div>
							<s:if test="filmDetail.videoPath.size >= 4">
								<div style="height:32px;padding-top:15px;">
									<a class="read-more" href="javascript:seeMoreVideo(<s:property value="filmDetail.seq" />);" style="float:right;"></a>
								</div>
							</s:if>
						</div>
					</div>
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
						<a>影片库 Film Library</a>
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
	</body>
</html>