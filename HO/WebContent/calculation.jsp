<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="./StaticView.css" rel="stylesheet">
<title>calculation</title>
<style>
.button {
	background-color: #4CAF50;
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}

.right {
	position: absolute;
	right: 400px;
	width: 250px;
	top:60px;
	border: 5px solid green;
	padding: 50px;
	margin: 20px;
}

.last {
	position: absolute;
	right: 0px;
	top:-3px;
	width: 250px;
	height:250px;
	padding: 50px;
	margin: 20px;
}

.bottom {
	position: absolute;
	right: 0px;
	bottom: -60px;
	width: 250px;
	padding: 50px;
	margin: 20px;
}

.left {
	position: absolute;
	left: 0px;
	width: 250px;
	top: 60px;
	border: 5px solid green;
	padding: 50px;
	margin: 20px;
}

table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<body>
	<div>
		<h1 style="background-color: green;">
			<center>
				<font color="black">Results</font>
			</center>
		</h1>
	</div>
	<div class="left">
		<h3>Retailer Details</h3>
		<table>
			<tr>
				<th>Demand</th>
				<td><%=request.getAttribute("demand")%></td>
			</tr>
			<tr>
				<th>Starting Inventory</th>
				<td><%=request.getAttribute("startinv")%></td>
			</tr>
			<tr>
				<th>FullFilled</th>
				<td><%=request.getAttribute("fullfilled")%></td>
			</tr>
			<tr>
				<th>Backlog</th>
				<td><%=request.getAttribute("backalog")%></td>
			</tr>
			<tr>
				<th>Ending Inventory</th>
				<td><%=request.getAttribute("endinv")%></td>
			</tr>
			<tr>
				<th>Order</th>
				<td><%=request.getAttribute("order")%></td>
			</tr>

			<tr>
				<th>Out of Stock Cost</th>
				<td><%=request.getAttribute("outofstockcost")%></td>
			</tr>
			<tr>
				<th>Inventory Cost</th>
				<td><%=request.getAttribute("inventorycost")%></td>
			</tr>
		</table>
		<form action="./BeerDistributionServlet" method="post">
			Enter the Demand : <input type="number" name="rdemand1"
				required="required"> <input type="submit" class="button"
				value="Submit">
		</form>
	</div>
	<div class="right">
		<h3>DC Details</h3>
		<table>
			<tr>
				<th>Demand</th>
				<td><%=request.getAttribute("dcdemand")%></td>
			</tr>
			<tr>
				<th>Starting Inventory</th>
				<td><%=request.getAttribute("dcstartinv")%></td>
			</tr>
			<tr>
				<th>FullFilled</th>
				<td><%=request.getAttribute("dcfullfilled")%></td>
			</tr>
			<tr>
				<th>Backlog</th>
				<td><%=request.getAttribute("dcbacklog")%></td>
			</tr>
			<tr>
				<th>Ending Inventory</th>
				<td><%=request.getAttribute("dcendinv")%></td>
			</tr>
			<tr>
				<th>Order</th>
				<td><%=request.getAttribute("dcorder")%></td>
			</tr>
			<tr>
				<th>Out of Stock Cost</th>
				<td><%=request.getAttribute("dcoutofstockcost")%></td>
			</tr>
			<tr>
				<th>Inventory Cost</th>
				<td><%=request.getAttribute("dcinventorycost")%></td>
			</tr>


		</table>

	</div>
	<div class="last">
		<table>
			<tr>
				<th>Retailer Inventory Cost</th>
				<td><%=request.getAttribute("rIntCost")%></td>
			</tr>
			<tr>
				<th>Retailer outofstock Cost</th>
				<td><%=request.getAttribute("rOutCost")%></td>
			</tr>
			<tr>
				<th>Dc Inventory Cost</th>
				<td><%=request.getAttribute("dcInvCost")%></td>
			</tr>
			<tr>
				<th>Dc outofStock Cost</th>
				<td><%=request.getAttribute("dcOutCost")%></td>
			</tr>
			<tr>
				<th>Total Cost</th>
				<td><%=request.getAttribute("totalCost")%></td>
			</tr>

		</table>
	</div>

	<div class="bottom">
		<!--  <form action="./graph.jsp" method="post">
		 <input type="submit" class="button"
				value="View Graph">
		</form> -->

		<div id="chartContainer" style="height: 300px; width: 100%;"></div>
		<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>

	</div>
</body>
<script type="text/javascript">
	
<%ArrayList<Integer> temp = new ArrayList<Integer>();
			temp = (ArrayList) request.getAttribute("rdeman");
			int length = temp.size();%>
	window.onload = function() {

		var dps = []; // dataPoints
		var chart = new CanvasJS.Chart("chartContainer", {
			title : {
				text : "Customer Demand Trends"
			},
			axisY : {
				includeZero : false
			},

			data : [ {
				type : "line",
				dataPoints : dps
			} ]
		});

		var xVal = 0;
		var yVal = 0;
		var updateInterval = 10000;
		var dataLength = 20; // number of dataPoints visible at any point

		var updateChart = function(count) {
			var graphData, len;
			graphData = <%=temp%>
			len = <%=length%>
			console.log(graphData);
			for (var j = 0; j <= len; j++) {

				yVal = graphData[j];
				xVal = j;
				dps.push({
					x : xVal,
					y : yVal

				});

			}

			if (dps.length > dataLength) {
				dps.shift();
			}

			chart.render();
		};

		updateChart(dataLength);
		setInterval(function() {
			updateChart()
		}, updateInterval);

	}
</script>
</html>