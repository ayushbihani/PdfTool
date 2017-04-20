<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:useBean id="test" class="wordddd.WordToPdfConverter" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
WORD TO PDF CONVERTER
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WORD TO PDF CONVERTER</title>
</head>
<body>

<%
test.selectFiles();



%>
<p>Succesful</p>
</body>
</html>