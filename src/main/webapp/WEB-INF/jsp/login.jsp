<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8"%>
<%--<%--%>
<%--String path = request.getContextPath();--%>
<%--String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";--%>
<%--%>--%>
<%@ include file="baseJSP.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=8,IE=9,IE=10,IE=edge,chrome=1"/>
	<title>纵横招标网站管理平台</title>
	<style type="text/css">
		html, body {
			width: 100%;
			height: 100%;
			padding: 0px;
			margin: 0px;
			font-family: 微软雅黑;
			background-image: url("${basePath}images/login/bg.png");
			background-size: 100% 100%;
		}

		.middle_box {
			width: 100%;
			float: left;
			padding: 50px 0px;
			position: absolute;
			left: 0px;
			top: 50%;
			margin-top: -320px;
		}

		.middle_box .m_cBox {
			width: 1000px;
			height: 550px;
			margin: 0px auto;
			background-image: url("${basePath}images/login/m_bg.png");
			background-size: 100% 100%;
			border-radius: 20px !important;
			-webkit-border-radius: 20px !important;
			box-shadow: 0 5px 15px 0 rgba(0, 0, 0, 0.1)
		}

		.middle_box .m_cBox .login_box {
			width: 350px;
			height: 400px;
			background: #fff;
			float: right;
			margin-right: 50px;
			margin-top:45px;
		}

		.middle_box .m_cBox .login_box .login_box_logo {
			width: 100%;
			height: 100px;
			background-image: url("${basePath}images/login/logo.png");
			background-size: auto 100%;
			background-repeat: no-repeat;
			background-position: center center;
			margin-bottom: 10px;
		}

		.m_ipt {
			width: 298px;
			height: 40px;
			float: left;
			border: #ececec 1px solid;
			margin-left: 25px;
			overflow: hidden;
			margin-top: 15px;
			border-radius: 10px !important;
			-webkit-border-radius: 10px !important;
			position:relative;
		}

		.m_ipt i {
			display: block;
			width: 30px;
			height: 30px;
			float: left;
			margin: 5px;
		}

		.m_ipt i img {
			width: 30px;
			height: 30px;
		}

		.m_ipt input {
			width: 254px;
			height: 40px;
			float: right;
			font-size: 14px;
			line-height: 40px;
			border: none;
			margin-top: -1px;
			outline: none;
			color: #666;
			background-color: #fff;
			text-indent: 10px;
		}

		.m_ipt .m_iptBtn{position:absolute;right:0px;width:120px;background-color:#4783F7;height:40px;line-height:38px;text-align:center;font-size:12px;color:#fff;cursor:pointer;z-index:2;}
		.m_ipt .m_iptBtn:hover{background-color:#5886FC;}

		.m_rInfo {
			width: 298px;
			height: 25px;
			float: left;
			margin-left: 25px;
			margin-top: 15px;
			line-height: 25px;
			font-size: 12px;
			color: #999;
		}

		.m_rInfo input {
			float: left;
			margin-top: 6.3px;
		}

		.m_btn {
			width: 298px;
			height: 40px;
			line-height: 40px;
			float: left;
			margin-left: 25px;
			overflow: hidden;
			margin-top:20px;
			background: #4783F7;
			color: #fff;
			text-align: center;
			font-size: 18px;
			text-decoration: none;
			border-radius: 20px !important;
			-webkit-border-radius: 20px !important;
		}

		.m_btn:hover {
			background: #5886FC;
		}

		.m_btn1 {
			width: 296px;
			height: 38px;
			line-height: 38px;
			float: left;
			margin-left: 25px;
			overflow: hidden;
			margin-top: 15px;
			border: #4783F7 1px solid;
			color: #4783F7;
			text-align: center;
			font-size: 18px;
			text-decoration: none;
			border-radius: 20px !important;
			-webkit-border-radius: 20px !important;
		}

		.m_btn1:hover {
			background: #5886FC;
			color: #fff;
		}

		.f_info {
			width: 100%;
			height: 20px;
			line-height: 20px;
			color: #3971f9;
			font-size: 12px;
			text-align: center;
			position: fixed;
			bottom: 20px;
			left: 0px;
		}

		.login_tab{width:100%;float:left;margin-bottom:15px;padding:0px 25px;box-sizing: border-box; -webkit-box-sizing: border-box;}
		.login_tab .login_tabItem{width:50%;float:left;padding:10px 0px;border-bottom:#fff 2px solid;text-align:center;color:#999;font-size:14px;cursor:pointer;}
		.login_tab .login_tabItem:hover{border-bottom:#4783F7 2px solid;color:#333;}
		.login_tab .login_tabItem.seled{border-bottom:#4783F7 2px solid;color:#333;}
		.aLink{color:#666;font-size:12px;text-decoration:none;}
		.aLink:hover{text-decoration:underline;color:#4783F7;}
	</style>
	<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
	<!-- jbox -->
	<script type="text/javascript" src="<%=basePath%>js/jBox/jquery.jBox-2.3.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jBox/jquery.jBox-zh-CN.js"></script>
	<link type="text/css" rel="stylesheet" href="<%=basePath%>js/jBox/Skins2/Metro/jbox.css"/>

	<script type="text/javascript">
        $(function(){
            //登录
            $("#loginBtn").click(function(){
                var userName = $.trim($("#userName").val());
                var password = $.trim($("#password").val());
                if(userName=="" || password==""){
                    $("#err_tip").html("用户名，密码不能为空！");
                }else{
                    $.jBox.tip("正在努力登录中...", "loading");
                    $("#loginFrm").submit();
                }
            });
        });

        //回车提交表单
        $(document).keyup(function(event){
            if(event.keyCode ==13){
                $("#loginBtn").trigger("click");
            }
        });
	</script>
</head>
<body>


<!-- 中部内容区 Start -->
<div class="middle_box">
	<div class="m_cBox">



		<!-- 登录盒子 start -->
		<div class="login_box">
			<%--<div class="login_box_logo" title="logo"></div>--%>
			<div style="width:100%;padding:10px 0px;text-align:center;font-size:26px;margin-top: 50px;margin-bottom: 10px;">纵横招标网站管理平台</div>
			<form id="loginFrm" action="<%=basePath%>login" method="post">
				<!-- error显示区 start -->
				<div id="err_tip" style="width:268px;float:left;height:15px; line-height:15px; margin-left:25px; color:#F54E19;font-size:14px;">
					<c:if test="${msg != null}">
						${msg}
					</c:if>
				</div>
				<!-- error显示区 end -->

				<div class="m_ipt">
					<i><img src="<%=basePath%>images/icon_user.png"/></i>
					<input type="text" id="userName" name="userName" placeholder="请输入您的账号"/>
				</div>
				<div class="m_ipt">
					<i><img src="<%=basePath%>images/icon_pwd.png"/></i>
					<input type="password" id="password"  type="password" name="password" placeholder="请输入您的密码"/>
				</div>
				<div class="m_rInfo">
				</div>
				<a href="javascript:void(0)" id="loginBtn" class="m_btn">登录</a>
			</form>
			<div class="m_rInfo">
				如果您忘记密码？请联系管理员进行重置。
			</div>
		</div>
		<!-- 登录盒子 end -->
	</div>
</div>
<!-- 中部内容区 end -->


<!-- 页脚start -->
<div class="f_info">Copyright  ©2019-2020  Corporation, All Rights Reserved LINGMEI</div>
<!-- 页脚end -->
</body>
</html>