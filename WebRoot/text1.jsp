<%@page import="util.GetDate"%>
<%@page import="util.MyLog"%>
<%@page import="pojo.Salary"%>
<%@page import="dao.impl.SalaryDaoImpl"%>
<%@page import="dao.SalaryDao"%>
<%@page import="db.DBHelper"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Text.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <%
  SalaryDao sd=new SalaryDaoImpl();
		Connection conn=DBHelper.getConnection();
		ArrayList<Salary> list=sd.getAll(conn);
DBHelper.closeCon(conn);
		for (Salary salary : list) {
			MyLog.log.debug(salary);
			
		}
   %>
    This is my JSP page. <br>
  </body>
</html>
