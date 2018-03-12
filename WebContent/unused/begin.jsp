<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>首页</title>
</head>
<body style ="margin:0px">
<jsp:include page="top.jsp"></jsp:include>
<%
	response.setHeader("refresh","5;URL=login.jsp");
	%>
<table width="781" height="279" border="0" cellpadding ="0"
cellspacing="0">
	<tr>
		<td>&nbsp;</td>
		</tr>
</table>
<jsp:include page= "bottom.jsp"/>
</body>
</html>