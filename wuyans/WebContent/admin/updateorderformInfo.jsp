<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.orderformDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>updateorderform</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
<form action="updateorderformServlet">
      <div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="admin.html">��ҳ</a>&nbsp;-&nbsp;<a
					href="showAllorderform.jsp">��������</a>&nbsp;-</span>&nbsp;�޸Ķ���
			</div>
		</div>
		<br>
  <div class="page">
			<!-- userҳ����ʽ -->
			<div class="connoisseur">
				
				<!-- user ��� ��ʾ -->
				<div class="conShow">
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>						
							<td width="300px" class="tdColor">clientID</td>
							<td width="400px" class="tdColor">ticketID</td>
							<td width="400px" class="tdColor">number</td>
							<td width="400px" class="tdColor">state</td>
							<td width="250px" class="tdColor">����</td>
						</tr>
      
      <%
           String ticketID = request.getParameter("ticketID");
           String clientID = request.getParameter("clientID");
           Vector<orderformDTO> v = new Vector<orderformDTO>();
           v = (Vector<orderformDTO>)session.getAttribute("allorderform");
           Iterator it = v.iterator();
           orderformDTO o =null;
           while(it.hasNext()){
        	  o = (orderformDTO)it.next();
        	  if((o.getTicketID()).equals(ticketID)&&(o.getClientID()).equals(clientID)){
      %>
        <tr>
         <td height="40px"><input type="text" readOnly="true" name="clientID" value=<%=o.getClientID()%>></td>
         <td height="40px"><input type="text" readOnly="true" name="ticketID" value=<%=o.getTicketID()%>></td>
         <td height="40px"><input type="text" name="number" value=<%=o.getNumber()%>></td>
         <td height="40px"><input type="text" name="state" value=<%=o.getState()%>></td>
         <td height="40px"><input type="submit" value="ȷ���޸�"></td>        
      </tr> 
      <%
          }}
      %>
   </table>
  				 </div>
				<!-- user ��� ��ʾ end-->
			</div>
			<!-- userҳ����ʽend -->
		</div>

	</div>
   
</form>
</body>
</html>