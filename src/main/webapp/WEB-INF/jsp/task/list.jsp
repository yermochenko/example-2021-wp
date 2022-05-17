<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="by.vsu.domain.Task"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>List of tasks</title>
		<style type="text/css">
			table {
				border-collapse: collapse;
			}
			th, td {
				border: 1px solid black;
			}
			th {
				background: #AAF;
				padding: 5px 10px;
			}
			td {
				padding: 5px 25px 5px 10px;
			}
			.disable {
				background: #DDD;
			}
		</style>
	</head>
	<body>
		<h1>List of tasks (from JSP)</h1>
		<table>
			<tr>
				<th>Title</th>
				<th>Description</th>
				<th>Date</th>
				<th>Importance</th>
			</tr>
			<%
				@SuppressWarnings("unchecked")
				ArrayList<Task> tasks = (ArrayList<Task>) request.getAttribute("tasks");
				int size = tasks.size();
				for(Task task : tasks) {
			%>
			<tr <% if(!task.isActive()) {%>class="disable"<%}%>>
				<td><%=task.getTitle()%></td>
				<td><%=task.getDescription()%></td> 
				<td><%=String.format("%1$td.%1$tm.%1$tY, %1$tH:%1$tM", task.getDate())%></td>
				<td><%=String.format("%.2f", task.getImportance()) %></td>
			</tr>
			<%
				}
			%>
		</table>
		<p>Total <%=size%> tasks</p>
	</body>
</html>
