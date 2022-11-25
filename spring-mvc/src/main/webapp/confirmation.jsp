<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap.min.css"
	integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu"
	crossorigin="anonymous">
<script src="http://code.jquery.com/jquery-1.6.2.min.js"></script>
</head>
<body>
<h1>Success</h1>
<%-- <h3>Your Account number is : ${ acno }</h3> --%>
<h3>Your Account number is : ${ generatedAcno }</h3>
<button class="btn btn-primary" onclick="window.location='transactionForm.jsp'">Money Transfer</button>
</body>
</html>