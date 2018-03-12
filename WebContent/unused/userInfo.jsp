<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>用户信息</title>
</head>
<body>
<%
	Cookie[] cookies= request.getCookies();
	String userID= "";
	String userName = "";
	String email = "";
	int vip=0;
	double vipVaule=0.0;
	String sex = "";
	String telphone ="";
	String job="";
	Date birthday;
	Timestamp vipTime;
	//目前开始从cookie中获取信息，用于现实用户基本信息
	/** 先考虑下要不要使用cookies
	if(cookies !=null){
		for(int i=0;i<cookies.length;i++){
			if
		}
	}
	*/
	
	%>
</body>
</html>