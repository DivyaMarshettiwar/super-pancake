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
<style>
table, th, td {
  border: 1px solid;
}
</style>
</head>
<body>
	<div><h1>Create Account</h1></div>

	<div class="container">
		<form method="post" action="openAccount">

			<div>
				Enter your name : <input name="name" />
			</div>
			<div>
				Account Type : 
				<select name="type">
					<option value="savings">Savings</option>
					<option value="current">Current</option>
				</select>
			</div>
			<div>
				Initial Balance : <input name="balance" />
			</div>
			<div>
				<button type="submit">Open Account</button>
			</div>
		</form>
		<button class="btn btn-primary" onclick="window.location='transactionForm.jsp'">Money Transfer</button>
		<button class="btn btn-primary" onclick="window.location='fetchDeatils.jsp'">Fetch Details</button>
	</div>
</body>
</html>