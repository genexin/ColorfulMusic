<h1 style="text-align: center">ColorfulMusic</h1>
<h3 style="text-align: center">不一样的音乐，不一样的色彩</h3>
#### 数据库注意事项
1. 为了方便，你可以直接简单地在你的 MySQL 数据库中添加 'cm' 用户，密码为 'cm'：
<br/>GRANT ALL PRIVILEGES  ON \*.* TO 'cm'@'localhost' IDENTIFIED BY 'cm';
<br/>FLUSH PRIVILEGES;
2. 导入数据库：
<br/>SOURCE db.sql
3. 然后自行插入一些数据（比较麻烦，建议队友们写个小程序）
<br/>

#### 目前提供的基本 API
*基础路径： http://localhost:8080/ColorfulMusic，数据格式为 JSON*

* 获得歌曲；方法：GET；<br/>
Example：
    1. 获得 id 为 1 的歌曲：http://localhost:8080/ColorfulMusic/song/1<br/>
    2. 获得 id 1 之后的 3 首歌曲（id 分别为 2,3,4）：http://localhost:8080/ColorfulMusic/song/1/3
* 获得用户信息；方法：GET<br/>
Example：
    1. 获得 id 为 1 的用户的信息：http://localhost:8080/ColorfulMusic/user/1
    2. 获得 id 为 1 的用户收藏的歌曲：http://localhost:8080/ColorfulMusic/user/1/collection

* 用户登录；方法：GET；路径：/user/user_login；参数：username，password；Content-Type：application/x-www-form-urlencoded；登录成功返回Http状态码200和对应的用户 ID，否则返回状态码404<br/>
Example:<br/>
```JavaScript
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
	var url = "<%=path%>/user/user_login?dummy=" 
	                   + new Date().getTime(); // 防止浏览器缓存
	url += "&username=" + username + "&password=" + password;
	ajaxRequest.open('GET', url, true); // true 表示异步调用
	ajaxRequest.setRequestHeader("Content-Type", 
	                   "application/x-www-form-urlencoded"); // 设置头部
	ajaxRequest.send(null);
}
```
* 用户注册；方法：POST；路径：/user/user_register；参数：email，username，password；Content-Type：application/x-www-form-urlencoded；注册成功返回Http状态码201和对应的用户信息<br/>
Example:<br/>
``` JavaScript
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
    var userInfo = "email=" + email + 
            "&username=" + username + "&password=" + password;
    var url = "<%=path%>/user/user_register?dummy="+ new Date().getTime();
    ajaxRequest.open('POST', url, true);
    ajaxRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    ajaxRequest.send(userInfo);
}
```
* 用户收藏歌曲；方法：PUT；路径：/user/collection/{userId}/{songId}；参数：userId，songId；收藏成功返回Http状态码200；<br/>
Example:<br/>
``` JavaScript
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
```