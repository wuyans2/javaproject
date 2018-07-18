<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.clientDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>myself</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="css/lightbox.css" type="text/css" media="all" />
<!-- js -->
<script src="js/jquery-1.11.1.min.js"></script>
<!-- //js -->
<link href="css/ihover.css" rel="stylesheet" media="all">
<link href="css/hover_pack.css" rel="stylesheet" media="all">
</head>
<body>
<div class="header">
	<div class="container">
		<div class="logo">
			<h1>
				<a href="OK.html">
					<span class="glyphicon glyphicon-education" aria-hidden="true"></span>Welcome to sunshine reservation system	
					
				</a>
			</h1>
		</div>
		<div class="logo-right">
		<br>
			<p><small>欢迎你<%String name = (String)session.getAttribute("name"); %>
			<%=name %> </small></p>
		</div>
		<div class="clearfix"></div>
	</div>
</div>
<div id="pageAll">
		<div class="pageTop">
			<div class="page">
			<center>
				<span><a href="OK.html">首页</a></span>
				<span><a href="findmyself.jsp">我的用户信息</a></span>
				<span><a href="yHFindAllticket">查看机票</a></span>
				<span><a href="myorderform">查看我的订单</a></span>
				<span><a href="orderticket.jsp">订票</a></span>
				<span><a href="loginoutServlet">注销退出</a></span>	
				</center>			
			</div>
		</div>

		<div class="page">
			<!-- user页面样式 -->
			<div class="connoisseur">
				
				<!-- user 表格 显示 -->
				<div class="conShow">
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td width="435px" class="tdColor">client</td>
							<td width="400px" class="tdColor">name</td>
							<td width="630px" class="tdColor">tel</td>
							<td width="630px" class="tdColor">password</td>
						</tr>
				
					<%
					 String clientID = (String)session.getAttribute("clientID");
					 name = (String)session.getAttribute("name");
					 String tel = (String)session.getAttribute("tel");
					 String password = (String)session.getAttribute("password");
					%>
    			
						<tr height="40px">
						
					         <td><%=clientID %></td>
					         <td><%=name%></td>
					         <td><%=tel%></td>
					         <td><%=password%></td>
						</tr>
					</table>
				</div>
				<!-- user 表格 显示 end-->
			</div>
			<!-- user页面样式end -->
		</div>

	</div>
</body>
</html>