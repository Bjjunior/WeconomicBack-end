<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exemplo JSP</title>
</head>
<body>
	<ul>
	
	<%for(int x = 0; x < 10 ; x++){%>
				
			<li><%=x %></li>
			
	<%}%>
	</ul>
	
</body>
</html>