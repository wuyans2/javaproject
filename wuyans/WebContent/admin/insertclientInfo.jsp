<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.clientDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>insertclientInfo</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
<form action="insertclientServlet">
   <div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="admin.html">首页</a>&nbsp;-&nbsp;<a
					href="findAllUser">用户管理</a>&nbsp;-</span>&nbsp;添加用户信息
			</div>
		</div>
		<br>
		 <div class="page">
			<!-- user页面样式 -->
		<div class="connoisseur">
				
				<!-- user 表格 显示 -->
			<div class="conShow">
				<table border="1" cellspacing="0" cellpadding="0">
					<tr>
							
						<td width="300px" class="tdColor">clientID</td>
						<td width="400px" class="tdColor">name</td>
						<td width="400px" class="tdColor">tel</td>
						<td width="400px" class="tdColor">password</td>
						<td width="400px" class="tdColor">superuser</td>
						<td width="400px" class="tdColor">state</td>
						<td width="250px" class="tdColor">操作</td>
					</tr>

			        <tr>
			         <td height="40px"><input type="text" name="clientID" value=""></td>
			         <td height="40px"><input type="text" name="name" value=""></td>
			         <td height="40px"><input type="text" name="tel" value=""></td>
			         <td height="40px"><input type="text" name="password" value=""></td>
			         <td height="40px"><input type="text" name="superuser" value=""></td>
			         <td height="40px"><input type="text" name="state" value=""></td>
			         <td height="40px"><input type="submit" value="确认添加"></td>        
			      </tr> 
			      </table>
			       </div>
				<!-- user 表格 显示 end-->
		 </div>
			<!-- user页面样式end -->
		</div>
	</div>
</form>
</body>

</html>