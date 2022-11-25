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
<form method="post" action="transferMoney">
Enter from acno : <input name="fromAcno" /><br />
Enter to acno : <input name="toAcno" /><br />
Enter amount : <input name="amount" /><br />
<button type="submit">Transfer</button>
</form>
</body>
</html>