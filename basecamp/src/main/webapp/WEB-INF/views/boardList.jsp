<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<title>메인!!</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">	
	<h2>게시판</h2>
	<form action="writePostForm.do">
		<input type="submit" value="글쓰기" class="btn btn-default">
	</form>
	<table class="table table-hover">
    	<thead>
        	<tr>
        		<th>글번호</th>
            	<th>이메일</th>
            	<th>본문</th>
            	<th>작성일</th>
        	</tr>
    	</thead>
    	<tbody>
        	<c:choose>
            	<c:when test="${fn:length(list) > 0}">
                	<c:forEach items="${list }" var="row">
                    	<tr>
                    		<td>${row.postId}</td>
                        	<td>${row.email }</td>
                        	<td><a href="postDetail.do?postId=${row.postId}">${row.text }</a></td>
                        	<td>${row.modTime }</td> 
                    	</tr>
                	</c:forEach>
            	</c:when>
            	<c:otherwise>
                	<tr>
                    	<td colspan="4">조회된 결과가 없습니다.</td>
                	</tr>
            	</c:otherwise>
        	</c:choose>         
    	</tbody>
	</table>
</div>
</body>
</html>