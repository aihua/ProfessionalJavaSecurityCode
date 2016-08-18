<%@ page import="ecommerce_example.data.*, java.text.*" %>
<%
DecimalFormat decimalFormat = new DecimalFormat( "###,###,###.00" );
Account account = (Account)request.getAttribute( "Account" ); %>
<html>
	<head>
		<title>Account Balance</title>
	</head>

	<body>
		<table cellpadding="4">
			<tr>
				<td>Account id:</td>
				<td><%= account.getAccountID() %></td>
			</tr>
			<tr>
				<td>Customer name:</td>
				<td><%= account.getCustomerName() %></td>
			</tr>
			<tr>
				<td>Current balance:</td>
				<td>$<%= decimalFormat.format( account.getBalance() ) %></td>
			</tr>
		</table>
	</body>
</html>