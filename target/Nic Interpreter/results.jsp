<%@page import="cse.maven.sample.exception.InvalidNicNumberException"%>
<%@page import="cse.maven.sample.NicProp"%>
<%@page import="cse.maven.sample.NicInterpreter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 
    Document   : results
    Created on : 12-Sep-2013, 9:45:24
    Author     : Prakhash
--%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<h1>Result of the Nic interpretation</h1>
<%
	String nicNum = request.getParameter("nicNum");
	
	NicInterpreter nicInterpreter = new NicInterpreter();
	
	try {
		NicProp resultN = nicInterpreter.createNicProp(nicNum);

                out.println(resultN.getData());

	} catch (InvalidNicNumberException ex) {
		out.println(ex.getMessage());
	}	
%>
</head>
<body>

</body>
</html>