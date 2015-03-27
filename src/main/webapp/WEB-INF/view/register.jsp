<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
//	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="shortcut icon" href="<%=path%>/images/icon.png" >
        <title>注册</title>
		<style>
			body{
				background-color: #60B18D;
				font: 15px Microsoft YaHei;
				color: #FFFFFF;
			}
			#user_register{
				position: absolute; 
				left: 41%;
			}
			input{
				font-family: Microsoft YaHei;
			}
		</style>
    </head>
    <body>
		<p align="center">不一样的音乐，不一样的色彩</p>
		<div id="user_register">
			<table>
				<tr>
					<td><div style="text-align: right">邮箱：</div></td>
					<td><input id="email" name="email" type="text"/></td>
				</tr>
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
					<td style="text-align: center">
						<input id="register" type="button" value="注册" />
					</td>
				</tr>
			</table>
		</div>
		<script type="text/javascript" src="<%=path%>/js/easy.js"></script>
		<script>
			function register(username, password, email) {
				var ajaxRequest = new XMLHttpRequest();
				ajaxRequest.onreadystatechange = function () {
					if (ajaxRequest.readyState === 4) {
						if (ajaxRequest.status === 201) { // 注册成功
							alert(ajaxRequest.responseText);
						} else {
							alert(ajaxRequest.status);
						}
					}
				};
				var userInfo = "email=" + email + "&username=" + username + "&password=" + password;
				var url = "<%=path%>/user/user_register?dummy=" + new Date().getTime(); // 防止浏览器缓存
				ajaxRequest.open('POST', url, true); // true 表示异步调用
				ajaxRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded"); // 设置头部
				ajaxRequest.send(userInfo);
			}
			e("register").onclick = function () {
				register(e("username").value, e("password").value, e("email").value);
			};
			e("email").focus();
		</script>
    </body>
</html>