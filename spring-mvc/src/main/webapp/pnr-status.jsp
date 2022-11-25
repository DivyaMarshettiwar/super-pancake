<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.6.1.js"></script>
<script>
$(function(){
	$("form").submit(function(event){
		event.preventDefault();
		
		let pnrNo = $("#pnrNo").val();
		let url = 'http://localhost:8080/spring-mvc/pnr-status?pnrNo='+pnrNo;
		
		$.ajax({
			url : url,
			method : 'GET',
			success : function(data){
				//alert(JSON.stringify(data));
				let resultDiv = $("#result");
				resultDiv.append($("<p />")).text("Train No. " + data.trainNo);
				resultDiv.append($("<p />")).text("Travel Date " + data.travelDate);
				// $.each(data.passengers, function(index,passenger)){
					//alert(JSON.stringify(passenger))
				for(let passenger of data.passengers){
					let p = $("<p />")
								.html("Passenger Name " + passenger.name + "<br />"
								+ "Gender " + passenger.gender + "<br />"
								+ "Status " + passenger.status + "<br />"
								+ "<hr />");
					resultDiv.append(p); 
				}
			}
		})
	})
})
</script>
</head>
<body>
<form>
Enter PNR No : <input id="pnrNo" />
<button type="submit">Check Status</button>
</form>
<div id="result"></div>
</body>
</html>