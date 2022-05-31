<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.javaex.vo.*" %>
<%@ page import="java.util.*" %>


<%
	List<GuestVo> gList = (List<GuestVo>)request.getAttribute("gList");
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>GuestBook</title>
	</head>
	<body>
		<form action="./gbc" method="post">
			<input type="hidden" name="action" value="add">
			<table border="1" style="width:400px">
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value=""></td>
					<td>비밀번호</td>
					<td><input type="password" name="password" value=""></td>
				</tr>
				<tr>
					<td colspan="4"><textarea name="content" style="width:400px"></textarea></td>
				</tr>
				<tr>
					<td colspan="4"><button type="submit">확인</button></td>
				</tr>
			</table>
		</form>
		<br>
		
		<% for(int i=0; i<gList.size(); i++) {%>
			
			<table border="1" style="width:400px">
				<tr>
					<td style="width:30px"><%=gList.get(i).getNo() %></td>
					<td style="width:100px"><%=gList.get(i).getName() %></td>
					<td style="width:220px"><%=gList.get(i).getRegDate() %></td>
					<td style="width:50px"><a href="./gbc?action=deleteForm&no=<%=gList.get(i).getNo() %>">[삭제]</a></td>
				</tr>
				<tr>
					<td colspan="4"><%=gList.get(i).getContent() %></td>
				</tr>
			</table>
			<br>
			
		<%} %>
	</body>
</html>