<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="zh-CN">
	<html>
		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<link rel="shortcut icon" href="images/icon.png" >
			<title>多彩音乐</title>
			<style>
				body{
					background-color: #60B18D;
					font: 15px Microsoft YaHei;
					color: #FFFFFF;
				}
				input{
					font-family: Microsoft YaHei;
				}
				#option{
					position: absolute; 
					right: 5%;
				}
			</style>
		</head>

		<body>
			<p align="center">不一样的音乐，不一样的色彩</p>
			<div id="option">
				<input type="button" id="login" value="登录" />&nbsp;&nbsp;
				<input type="button" id="register" value="注册">
			</div>
			<script>
				document.getElementById("login").onclick = function () {
					window.location.href = "<%=path%>/user/login";
				};
				document.getElementById("register").onclick = function () {
					window.location.href = "<%=path%>/user/register";
				};
			</script>
		</body>
	</html>
