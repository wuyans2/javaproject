<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.orderformDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>showAllorderform</title>
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
	//lert(arr);
	if(flag == true){
		if(confirm("��ȷ��Ҫɾ����"))
			location.href="deleteCheckorderformServet?arr="+arr;
	}else
		alert("����ѡ��һ����¼���ٽ���ɾ��");

}
</script>
</head>
<body>


<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="admin.html">��ҳ</a>&nbsp;-&nbsp;-</span>&nbsp;��������
			</div>
		</div>
		    <form action="searchorder">						
          <div>	
          <br>			           
             &nbsp; &nbsp; &nbsp; &nbsp;<input type="text" name="clientID" class="am-form-field" placeholder="������Ҫ���ҵ�clientID" value="">
             <span class="am-input-group-btn">
               <input class="am-btn am-btn-default"  type="submit" value="����">
             </span>
	    </div>
   </form>

		<div class="page">
			<!-- userҳ����ʽ -->
			<div class="connoisseur">
				
				<!-- user ��� ��ʾ -->
				<div class="conShow">
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td width="66px" class="tdColor tdC"></td>
							<td width="300px" class="tdColor">clientID</td>
							<td width="400px" class="tdColor">ticketID</td>
							<td width="400px" class="tdColor">number</td>
							<td width="400px" class="tdColor">state</td>
							<td width="250px" class="tdColor">����</td>
						</tr>
					 	<%
				           Vector<orderformDTO> v = new Vector<orderformDTO>();
				           v = (Vector<orderformDTO>)session.getAttribute("search2");
				           Iterator it = v.iterator();
				           orderformDTO o =null;
				           while(it.hasNext()){
				        	  o = (orderformDTO)it.next();   
				    	%>
						<tr height="40px">
							<td><input type="checkbox" name="check" value="<%=o.getClientID()%>,<%=o.getTicketID()%>"></td>
					         <td><%=o.getClientID()%></td>
					         <td><%=o.getTicketID()%></td>
					         <td><%=o.getNumber()%></td>
					         <td><%=o.getState()%></td>  
					         <td> <a href="updateorderformInfo.jsp?ticketID=<%=o.getTicketID()%>&&clientID=<%=o.getClientID()%>">
					              <img class="operation" src="img/update.png"></a> 
								<a href="deleteorderformServlet?ticketID=<%=o.getTicketID()%>&&clientID=<%=o.getClientID()%>">
								<img class="operation delban" src="img/delete.png"></a>
						   </td>
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

	</div>
	<br>
	<center>
   <input type="button" id="btn1" value="&nbsp;&nbsp;ȫѡ&nbsp;&nbsp;" onClick="allcheck();"/>
   <input type="button" id="btn2" value="&nbsp;&nbsp;��ѡ&nbsp;&nbsp;" onClick="allnotcheck();"/>
   <input type="button" id="btn3" value="&nbsp;&nbsp;��ѡ&nbsp;&nbsp;" onClick="backcheck();"/>
   <input type="button" value="&nbsp;&nbsp;����ɾ��&nbsp;&nbsp;" onClick="deleteCheck();"/>
   </center>
</body>
</html>