<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户注册</title>
</head>
<body>

<form action="RegServlet" method="post">
	<table align="center" width="450">
		<tr>
			<td align="center" colspan="2">
				<h2>用户注册</h2>
				<hr>
			</td>
		</tr>
		<tr>
			<td align="right">用户名：</td>
			<td><input type="text" name="userName" /></td>
		</tr>
		<tr>
			<td align="right">密码：</td>
			<td><input type="password" name="password" /></td>
		</tr>
		<tr>
			<td align="right">邮件：</td>
			<td><input type="text" name="email" /></td>
		</tr>
		<tr>
			<td align="right">会员：</td>
			<td>
				<input type="radio" name="vip" value="1" checked="checked">是
				<input type="radio" name="vip" value="0">否
			</td>
		</tr>
		<tr>
			<td align="right">性别：</td>
			<td>
				<input type="radio" name="sex" value="男" checked="checked">男
				<input type="radio" name="sex" value="女">女
			</td>
		</tr>
		<tr>
			<td align="right">电话号码：</td>
			<td><input type="text" name="telphone" /></td>
		</tr>
		<tr>
			<td align="right">生日：</td>
			<td><input type="text" name="birthday" /></td>
		</tr>
		<tr>
			<td align="center" colspan="2">
				<input type="submit" value="注　册">
			</td>
		</tr>
	</table>
</form>
</body>
</html>