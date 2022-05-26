<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
		<h1>List of tasks (from JSTL)</h1>
		<table>
			<tr>
				<th>Title</th>
				<th>Description</th>
				<th>Date</th>
				<th>Importance</th>
			</tr>
			<c:forEach var="task" items="${tasks}">
				<c:choose>
					<c:when test="${task.active}">
						<c:set var="cls" value="enable"/>
					</c:when>
					<c:otherwise>
						<c:set var="cls" value="disable"/>
					</c:otherwise>
				</c:choose>
				<tr class="${cls}">
					<td>${task.title}</td>
					<td>${task.description}</td>
					<td><fmt:formatDate value="${task.date}" pattern="dd.MM.yyyy, HH:mm"/></td>
					<td><fmt:formatNumber value="${task.importance}" pattern="0.00"/></td>
				</tr>
			</c:forEach>
		</table>
		<p>Total ${fn:length(tasks)} tasks</p>
	</body>
</html>
