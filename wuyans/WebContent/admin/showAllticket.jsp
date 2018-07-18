<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.TicketDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>showAllticket</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<!-- <script type="text/javascript" src="js/page.js" ></script> -->
<script>
function allcheck(){
	var checkObj = document.getElementsByName("check");
	for(var i=0; i<checkObj.length; i++)
		checkObj[i].checked = true;
}

function allnotcheck(){
	var checkObj = document.getElementsByName("check");
	for(var i=0; i<checkObj.length; i++)
		checkObj[i].checked = false;
}

function backcheck(){
	var checkObj = document.getElementsByName("check");
	for(var i=0; i<checkObj.length; i++)
		if(checkObj[i].checked == true)
			checkObj[i].checked = false;
		else
	    	checkObj[i].checked = true;
}

function deleteCheck(){
	var checkObj = document.getElementsByName("check");
	var arr=[];
	var flag = false;
	for(var i=0; i<checkObj.length; i++){
		if(checkObj[i].checked == true)	{
			arr.push(checkObj[i].value);
			flag = true;
		}
	}
	if(flag == true){
		if(confirm("您确定要删除吗？"))
			location.href="deleteCheckticketServet?arr="+arr;
	}else
		alert("至少选择一条记录，再进行删除");

}
</script>
</head>
<body>
<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="admin.html">首页</a>&nbsp;-&nbsp;-</span>&nbsp;机票管理
			</div>
		</div>
		  <form action="searchticket">						
          <div>	
          <br>			           
             &nbsp; &nbsp; &nbsp; &nbsp;<input type="text" name="address" class="am-form-field" placeholder="请输入要查找的地点" value="">
             <span class="am-input-group-btn">
               <input class="am-btn am-btn-default"  type="submit" value="搜索">
             </span>
	    </div>
   </form>

		<div class="page">
			<!-- user页面样式 -->
			<div class="connoisseur">
				
				<!-- user 表格 显示 -->
				<div class="conShow">
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td width="66px" class="tdColor tdC"></td>
							<td width="300px" class="tdColor">ticketID</td>
							<td width="400px" class="tdColor">offtime</td>
							<td width="400px" class="tdColor">falltime</td>
							<td width="400px" class="tdColor">address</td>
							<td width="300px" class="tdColor">price</td>
							<td width="330px" class="tdColor">surplus</td>
							<td width="330px" class="tdColor">state</td>
							<td width="250px" class="tdColor">操作</td>
						</tr>
					 	<%
				           Vector<TicketDTO> v = new Vector<TicketDTO>();
				           v = (Vector<TicketDTO>)session.getAttribute("allticket");
				           Iterator it = v.iterator();
				           TicketDTO t =null;
				           while(it.hasNext()){
				        	  t = (TicketDTO)it.next();   
      					%>
						<tr height="40px">
							<td><input type="checkbox" name="check" value="<%=t.getTicketID()%>"></td>
					         <td><%=t.getTicketID()%></td>
					         <td><%=t.getOfftime()%></td>
					         <td><%=t.getFalltime()%></td>
					         <td><%=t.getAddress()%></td>
					         <td><%=t.getPrice()%></td>
					         <td><%=t.getSurplus()%></td> 
					         <td><%=t.getState()%></td>  
					        
					         <td> <a href="updateticketInfo.jsp?ticketID=<%=t.getTicketID()%>"><img class="operation"
									src="img/update.png"></a> 
								<a href="deleteticketServlet?ticketID=<%=t.getTicketID()%>"><img class="operation delban"
								    src="img/delete.png"></a>
						   </td>
						</tr>
						  <%
                             }
                          %>
					</table>
				</div>
				<!-- user 表格 显示 end-->
			</div>
			<!-- user页面样式end -->
		</div>

	</div>
    <br>
    <center>
   <input type="button" id="btn1" value="&nbsp;&nbsp;全选&nbsp;&nbsp;" onClick="allcheck();"/>
   <input type="button" id="btn2" value="&nbsp;&nbsp;不选&nbsp;&nbsp;" onClick="allnotcheck();"/>
   <input type="button" id="btn3" value="&nbsp;&nbsp;反选&nbsp;&nbsp;" onClick="backcheck();"/>
   <input type="button" value="&nbsp;&nbsp;批量删除&nbsp;&nbsp;" onClick="deleteCheck();"/>
   </center>
</body>
</html>