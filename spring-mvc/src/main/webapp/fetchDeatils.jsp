<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap.min.css"
	integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu"
	crossorigin="anonymous">
<script src="http://code.jquery.com/jquery-3.6.1.js"></script>
<script>
$(function(){
	$("form").submit(function(event){
		event.preventDefault();

		let acno = $("#acno").val();
		let url = 'http://localhost:8080/spring-mvc/fetchDetailsRest?acno='+acno;
 	//alert(acno);
		$.ajax({
			url : url,
			method : 'GET',
			success : function(data){
				let resultDiv = $("#result");
				resultDiv.append($("<p />")).text("Account No. : " + data.acno);
				resultDiv.append($("<p />")).text("Name :  " + data.name);
				resultDiv.append($("<p />")).text("Balance :  " + data.balance);
				 for(let transaction of data.transactions){
					let p = $("<p />")
								.html("Transaction no. :  " + transaction.txno + "<br />"
								+ "Date :  " + transaction.date + "<br />"
								+ "Type :  " + transaction.type + "<br />"
								+ "Amount :  " + transaction.amount + "<br />"
								+ "<hr />");
					resultDiv.append(p); 
				} 
			}
		})
	})
})
</script>
<style>
table, th, td {
  border: 1px solid;
}
</style>
</head>
<body>
<form>
Enter Account number : <input id="acno" /><br />
<button type="submit">Get Details</button>
</form>
<!--  
<c:if test="${account != null }">
Search Result : <br />
Acno : ${ account.acno } <br />
Name : ${ account.name } <br />
Balance : ${ account.balance } <br /><br />

Transaction Details
		<table>
			<tr>
				<th>Txno</th>
				<th>Date and Time</th>
				<th>Type</th>
				<th>Amount</th>
			</tr>
			<c:forEach items="${ account.transactions }" var="t">
				<tr>
					<td>${ t.txno }</td>
					<td>${ t.date}</td>
					<td>${ t.type }</td>
					<td>${ t.amount }</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
-->
<div id="result"></div>
</body>
</html>