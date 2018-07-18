<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.TicketDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>updateticketInfo</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
<form action="updateticketServlet">
   <div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="admin.html">首页</a>&nbsp;-&nbsp;<a
					href="showAllticket.jsp">机票管理</a>&nbsp;-</span>&nbsp;修改机票信息
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
							
						<td width="300px" class="tdColor">ticketID</td>
						<td width="400px" class="tdColor">offtime</td>
						<td width="400px" class="tdColor">falltime</td>
						<td width="400px" class="tdColor">address</td>
						<td width="400px" class="tdColor">price</td>
						<td width="400px" class="tdColor">surplus</td>
						<td width="400px" class="tdColor">state</td>
						<td width="250px" class="tdColor">操作</td>
					</tr>
      <%
           String ticketID = request.getParameter("ticketID");
           Vector<TicketDTO> v = new Vector<TicketDTO>();
           v = (Vector<TicketDTO>)session.getAttribute("allticket");
           Iterator it = v.iterator();
           TicketDTO t =null;
           while(it.hasNext()){
        	  t = (TicketDTO)it.next();
        	  if((t.getTicketID()).equals(ticketID)){
      %>
        <tr>
         <td height="40px"><input type="text" readOnly="true" name="ticketID" value=<%=t.getTicketID()%>></td>
         <td height="40px"><input type="text" name="offtime" value=<%=t.getOfftime()%>></td>
         <td height="40px"><input type="text" name="falltime" value=<%=t.getFalltime()%>></td>
         <td height="40px"><input type="text" name="address" value=<%=t.getAddress()%>></td>
         <td height="40px"><input type="text" name="price" value=<%=t.getPrice()%>></td>
         <td height="40px"><input type="text" name="surplus" value=<%=t.getSurplus()%>></td>
         <td height="40px"><input type="text" name="state" value=<%=t.getState()%>></td>
         <td height="40px"><input type="submit" value="确认修改"></td>        
      </tr> 
      <%
          }}
      %>
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