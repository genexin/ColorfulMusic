<%-- 
    Document   : login
    Created on : 2015-3-25, 23:04:17
    Author     : MiZhou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="zh-CN">
	<html>
		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<link rel="shortcut icon" href="<%=path%>/images/icon.png" >
			<title>多彩音乐</title>
			<style>
				body{
					background-color: #60B18D;
					font: 15px Microsoft YaHei;
					color: #FFFFFF;
				}
				#user_login{
					position: absolute; 
					left: 42%;
				}
				input{
					font-family: Microsoft YaHei;
				}
			</style>
		</head>

		<body>
			<p align="center">不一样的音乐，不一样的色彩</p>
			<div id="user_login">
				<table>
					<tr>
						<td><div style="text-align: right">用户名：</div></td>
						<td><input id="username" name="username" type="text"/></td>
					</tr>
					<tr>
						<td><div style="text-align: right">密码：</div></td>
						<td><input id="password" name="password" type="password"/></td>
					</tr>
					<tr></tr><tr></tr>
					<tr>
						<td></td>
						<td style="text-align: right">
							<input id="register" type="button" value="注册" />&nbsp;&nbsp;
							<input id="login" type="button" value="登录" />
						</td>
					</tr>
				</table>
			</div>
			<script type="text/javascript" src="<%=path%>/js/easy.js"></script>
			<script>
				function register() {
					window.location.href = "<%=path%>/user/register";
				}
				e("register").onclick = function () {
					register();
				};
				function login(username, password) {
					var ajaxRequest = new XMLHttpRequest();
					ajaxRequest.onreadystatechange = function () {
						if (ajaxRequest.readyState === 4) {
							if (ajaxRequest.status === 200) { // 登录成功
								alert(ajaxRequest.responseText);
							} else {
								alert(ajaxRequest.status);
							}
						}
					};
					var url = "<%=path%>/user/user_login?dummy=" + new Date().getTime(); // 防止浏览器缓存
					url += "&username=" + username + "&password=" + password;
					ajaxRequest.open('GET', url, true); // true 表示异步调用
					ajaxRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded"); // 设置头部
					ajaxRequest.send(null);
				}
				e("login").onclick = function () {
					login(e("username").value, e("password").value);
				};
				document.onkeydown = function (e) {
					var keyCode = 0;
					if (window.event) {
						keyCode = event.keyCode;
					} else if (e.which) {
						keyCode = e.which;
					}
					if (keyCode === 13) { // 回车键
						login(e("username").value, e("password").value);
					}
				};
				e("username").focus();
			</script>
		</body>
	</html>