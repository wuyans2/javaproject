<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"  import="java.util.*,cn.edu.lingnan.dto.TicketDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>lookAllticket</title>
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
			<p><small>��ӭ��<%String name = (String)session.getAttribute("name"); %>
			<%=name %> </small></p>
		</div>
		<div class="clearfix"></div>
	</div>
</div>
<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<center>
				<span><a href="OK.html">��ҳ</a></span>
				<span><a href="findmyself.jsp">�ҵ��û���Ϣ</a></span>
				<span><a href="yHFindAllticket">�鿴��Ʊ</a></span>
				<span><a href="myorderform">�鿴�ҵĶ���</a></span>
				<span><a href="orderticket.jsp">��Ʊ</a></span>
				<span><a href="loginoutServlet">ע���˳�</a></span>	
				</center>	
			</div>
		</div>
<div class="page">
			<!-- userҳ����ʽ -->
			<div class="connoisseur">
				
				<!-- user ��� ��ʾ -->
				<div class="conShow">
				
			<table border="1" cellspacing="0" cellpadding="0">
			      <tr>
			         <td width="300px" class="tdColor">ticketID</td>
			         <td width="300px" class="tdColor">offtime</td>
			         <td width="300px" class="tdColor">falltime</td>
			         <td width="300px" class="tdColor">address</td>
			         <td width="300px" class="tdColor">price</td>
			         <td width="300px" class="tdColor">surplus</td>
			      </tr>
			      
			      <%
			           Vector<TicketDTO> v = new Vector<TicketDTO>();
			           v = (Vector<TicketDTO>)session.getAttribute("ticket");
			           Iterator it = v.iterator();
			           TicketDTO t =null;
			           while(it.hasNext()){
			        	  t = (TicketDTO)it.next();   
			      %>
			        <tr height="40px"> 
			         <td><%=t.getTicketID()%></td>
			         <td><%=t.getOfftime()%></td>
			         <td><%=t.getFalltime()%></td>
			         <td><%=t.getAddress()%></td>
			         <td><%=t.getPrice()%></td>
			         <td><%=t.getSurplus()%></td> 
			      </tr> 
			      <%
			          }
			      %>
			   </table>
			   </div>
				<!-- user ��� ��ʾ end-->
			</div>
			<!-- userҳ����ʽend -->
		</div>

</body>
</html>