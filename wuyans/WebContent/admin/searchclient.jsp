<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.clientDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>showAllUser</title>
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
		if(confirm("��ȷ��Ҫɾ����"))
			location.href="deleteCheckclientServet?arr="+arr;
	}else 
		alert("����ѡ��һ����¼���ٽ���ɾ��");
}
</script>

</head>
<body>
 
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="admin.html">��ҳ</a>&nbsp;-&nbsp;-</span>&nbsp;�ͻ�����
			</div>
		</div>
		    <form action="searchclient">						
          <div class="am-input-group am-input-group-sm">	
             <br>			           
             &nbsp; &nbsp; &nbsp; &nbsp;			           
             <input type="text" name="name" class="am-form-field" placeholder="������Ҫ���ҵ�����" value="">
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
							<td width="435px" class="tdColor">client</td>
							<td width="400px" class="tdColor">name</td>
							<td width="630px" class="tdColor">tel</td>
							<td width="630px" class="tdColor">password</td>
							<td width="330px" class="tdColor">superuser</td>
							<td width="330px" class="tdColor">state</td>
							<td width="250px" class="tdColor">����</td>
						</tr>
					<%
					 
			           Vector<clientDTO> v = new Vector<clientDTO>();
			           v = (Vector<clientDTO>)session.getAttribute("search");
			           Iterator it = v.iterator();
			           clientDTO c =null;
			           while(it.hasNext()){
			        	  c = (clientDTO)it.next();   
			        	
			  	        	
    			    %>
						<tr height="40px">
							<td><input type="checkbox" name="check" value="<%=c.getClientID()%>"></td>
					         <td><%=c.getClientID()%></td>
					         <td><%=c.getName()%></td>
					         <td><%=c.getTel()%></td>
					         <td><%=c.getPassword()%></td>
					         <td><%=c.getSuperuser()%></td>
					         <td><%=c.getState()%></td>  
							<td> <a href="updateclientInfo.jsp?clientID=<%=c.getClientID()%>"><img class="operation"
									src="img/update.png"></a> 
								<a href="deleteclientServlet?clientID=<%=c.getClientID()%>"><img class="operation delban"
								    src="img/delete.png"></a>
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