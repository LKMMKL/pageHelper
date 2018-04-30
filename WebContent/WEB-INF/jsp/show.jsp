<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="head.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>${page.pageNum}</h1>
		<a href="show?pageNum=1">1</a>
		<table class="table table-hover">
			<tr>
				<td class="table table-hover">Id</td>
				<td class="table table-hover">name</td>
			</tr>
			<c:forEach var="user" items="${page.list }">
				<tr>
					<td class="success">${user.id }</td>
					<td class="success">${user.name }</td>
				</tr>
			</c:forEach>
		</table>
		<div class="row">
			<!--文字信息-->
			<div class="col-md-3">当前第 ${page.pageNum} 页.总共 ${page.pages}
				页.一共 ${page.total} 条记录</div>
		</div>
		<div class="col-md-3">
		  <form action="show">
		   跳转至<input type="text" name="pageNum">页 &nbsp;&nbsp;
		 <input type="submit" value="跳转">
		</form>
		</div>
		<div class="col-md-6">
			<ul class="pagination">
				<li><a href="show?pageNum=1">首页</a></li>
				<c:if test="${page.hasPreviousPage}">
					<li><a href="show?pageNum=${page.pageNum-1 }">上一页</a></li>
				</c:if>
				<c:forEach var="num" items="${page.navigatepageNums }">
					<c:if test="${page.pageNum==num }">
						<li class="disabled"><a href="#">${num }</a></li>
					</c:if>
					<c:if test="${page.pageNum!=num }">
						<li><a href="show?pageNum=${num }">${num }</a></li>
					</c:if>
					
				</c:forEach>
				<c:if test="${page.hasNextPage}">
					<li><a href="show?pageNum=${page.pageNum+1 }">下一页</a></li>
				</c:if>
				<li><a href="show?pageNum=${page.pages }">尾页</a></li>
			</ul>
		</div>
	</center>
</body>
</html>