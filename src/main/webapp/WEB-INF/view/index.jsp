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
				#disable_background{
					display:none;
					position:absolute;
					top:0%; left:0%;
					width:100%; height:100%;
					background-color:#FFFFFF;
					z-index:1001;
					-moz-opacity:0.5;
					opacity:.50;
					filter:alpha(opacity=50);
				}
				#input_dialog{
					display:none;
					position:absolute;
					top:25%; left:42%;
					width:18%; height:22%;
					padding:10px;
					border:10px solid #0080FF;
					margin:-30px;
					background-color:white;
					z-index:1002;
					color: black;
					overflow:auto;
				}
			</style>
		</head>

		<body>
			<p align="center">不一样的音乐，不一样的色彩</p>
			<p align="center">测试页面</p>
			<div id="option">
				<input type="button" id="login" value="登录" />&nbsp;&nbsp;
				<input type="button" id="register" value="注册">&nbsp;&nbsp;
				<input type="button" id="collect" value="收藏">
			</div>
			<div id="disable_background"></div>
			<div id="input_dialog">
				<p style="text-align: center">收藏：输入用户ID 和 歌曲ID</p>
				<table>
					<tr>
						<td><div style="text-align: right">用户ID：</div></td>
						<td><input id="user_id" type="text"/></td>
					</tr>
					<tr>
						<td><div style="text-align: right">歌曲ID：</div></td>
						<td><input id="song_id" type="text"/></td>
					</tr>
					<tr></tr><tr></tr>
					<tr>
						<td></td>
						<td style="text-align: right">
							<input id="input_dialog_ok" type="button" value="确定" />&nbsp;&nbsp;
							<input id="input_dialog_cancel" type="button" value="取消" />
						</td>
					</tr>
				</table>
			</div>
			<script type="text/javascript" src="<%=path%>/js/easy.js"></script>
			<script>
				e("login").onclick = function () {
					window.location.href = "<%=path%>/user/login";
				};
				e("register").onclick = function () {
					window.location.href = "<%=path%>/user/register";
				};
				function showInputDialog() {
					e("input_dialog").style.display = 'block';
					e("disable_background").style.display = 'block';
					e("user_id").focus();
				}
				e("input_dialog_ok").onclick = function () {
					e("input_dialog").style.display = 'none';
					e("disable_background").style.display = 'none';
					collect(e("user_id").value, e("song_id").value);
				};
				e("input_dialog_cancel").onclick = function () {
					e("input_dialog").style.display = 'none';
					e("disable_background").style.display = 'none';
				};
				function collect(userId, songId) {
					var ajaxRequest = new XMLHttpRequest();
					ajaxRequest.onreadystatechange = function () {
						if (ajaxRequest.readyState === 4) {
							if (ajaxRequest.status === 200) {
								alert("用户收藏成功");
							} else {
								alert("用户收藏失败");
							}
						}
					};
					var url = "<%=path%>/user/collection/" + userId + "/" + songId;
					ajaxRequest.open('PUT', url, true);
					ajaxRequest.send(null);
				}
				e("collect").onclick = function () {
					showInputDialog();
				};
			</script>
		</body>
	</html>
