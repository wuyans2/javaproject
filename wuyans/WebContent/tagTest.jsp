<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="aa" uri="http://lingnan.edu.cn" %>
<%@taglib prefix="c" uri="/jstlc" %>
<!-- use shortname -->
<%@taglib prefix="sql" uri="/jstlsql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <aa:hello/>

     <br>
     <c:set var="a" value="aaa"/>
     <c:out value="a"/>
     <br>
     <c:out value="${a}"/>
     <br>
     <c:remove var="a"/>
     <c:out value="${a}"/>
     <c:catch var="b">
     <%=8/0%>   
     </c:catch>
     <c:out value="${b}"/>
     
     <%
     String[] str=new String[5];
     str[0]="aaaaa";
     str[1]="bbbbb";
     str[2]="ccccc";
     str[3]="eeeee";
     str[4]="fffff";
     request.setAttribute("st",str);
     %>
     <br>
     <c:out value="${st[2]}"/>
     <br>
     <c:if test="${st[2]=='ccccc'}">
     Yes
     </c:if>
    
     <br>
     <c:choose>
     <c:when test="${st[2]=='ccacc'}">
     YES
     </c:when>
     <c:otherwise>
     NO
     </c:otherwise>   
     </c:choose>
     
     
     <br>
     <c:forEach var="c" items="${st}">
     <c:out value="${c}"/>
     </c:forEach>  
     <br>
     <c:forEach var="d" begin="1" end="4">
     <c:out value="${d}"/>
     </c:forEach>
     <br>
     <c:forTokens var="e" items="zhangcan,lisi,wangwu,zhaoliu" delims=",">
     <c:out value="${e}"/>    
     </c:forTokens>
     <br>
     <a href="http://www.qq.com">
         qq1
     </a>
     <br>
      <a href="<c:url value="http://www.qq.com"/>">
         qq2
     </a>
     <br>
     <c:url var="f" value="http://www.qq.com">
     <c:param name="sname" value="zhangsan"/>
     </c:url>
     <a href="${f}">  
       qq3
     </a>
     <br>
     <c:import url="/OK.html"/>
     <br>
     <br>
     <sql:setDataSource
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/airticket"
        user="root"
        password="123456"
        var="aaa"     
     />
     <sql:query var="result" dataSource="${aaa}"
        sql="select * from client"
     />
     <table border="1">
     <c:forEach var="g" items="${result.rows}">
     <tr>
         <td><c:out value="${g.clientID}"/></td>
         <td><c:out value="${g.name}"/></td>
         <td><c:out value="${g.tel}"/></td>
         <td><c:out value="${g.password}"/></td>
         <td><c:out value="${g.superuser}"/></td>
         <td><c:out value="${g.state}"/></td>
     </tr>
     </c:forEach>
     </table>
     <sql:update dataSource="${aaa}"
       sql="update client set password='44441' where clientID='005'"
     
     />
     <br>
       <sql:query var="result" dataSource="${aaa}"
        sql="select * from client"
     />
     <table border="1">
     <c:forEach var="h" items="${result.rows}">
     <tr>
         <td><c:out value="${h.clientID}"/></td>
         <td><c:out value="${h.name}"/></td>
         <td><c:out value="${h.tel}"/></td>
         <td><c:out value="${h.password}"/></td>
         <td><c:out value="${h.superuser}"/></td>
         <td><c:out value="${h.state}"/></td>
     </tr>
     </c:forEach>
     </table>
     
     
</body>
</html>