<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>adminList</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="/css/index.css" />
<link rel="stylesheet" href="/css/bootstrap.css" />
<link rel="stylesheet" href="/css/bootstrap-theme.css" />
<link rel="stylesheet" href="/css/font-awesome.min.css" />
<!-- Header -->
</head>

<body>
	
	<div id="top-menu">
		<%-- top 영역  include top.jsp --%>
		<jsp:include page="/WEB-INF/views/include/top.jsp" />
	</div>

		<div id="wrapper">
			<div id="page" class="container">

	<section>
	<article>
	<div class="container">
	<div class="row">
	
	<div class="col-md-3 col-lg-3">
	<%--  관리 항목 영역  include board_submenu_admin.jsp --%>
	<jsp:include page="/WEB-INF/views/include/board_submenu_admin.jsp" />
	</div> 
	
	<div class="col-md-9 col-lg-9 table-responsive" style="margin-top : 20px;">
	<h1>전체 회원목록</h1>
	<hr>
	<form action="memberDeleteAdmin.do">
	<table class="table table-striped" id="adminTable">
	<tr>
		<th>선택</th>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이름</th>
		<th>나이</th>
		<th>성별</th>
		<th>이메일</th>
		<th>가입일자</th>
		<th>회원 정보 수정</th>
	</tr>
	<c:choose>
		<c:when test="${ pageDto.totalCount gt 0 }">
			<%-- ${ not empty memberList } --%>
			<c:forEach var="member" items="${ memberList }">
				<tr>
					<td><input type="checkbox" id="selectedid${ member.id }" name="selectedid" value=${ member.id }>
					<label for="selectedid${ member.id }"></label>
					</td>
					<td>${ member.id }</td>
					<td>${ member.passwd }</td>
					<td>${ member.name }</td>
					<td>${ member.age }</td>
					<td>${ member.gender }</td>
					<td>${ member.email }</td>
					<td><javatime:format value="${ member.regDate }" pattern="yyyy.MM.dd" /></td>
					<td><input type="button" value="수정하기" onclick="location.href='memberUpdateAdmin.do?id=${ member.id }'" class="adminInput"></td>
				</tr>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<tr>
				<td>등록된 회원이 없습니다.</td>
			</tr>
		</c:otherwise>
	</c:choose>

	</table>
		<button type="button" class="adminButton" onclick="location.href='/index.do'">메인화면</button>
		<button type="submit" class="adminButton">삭제</button>
	</form>
	</div>
	</div>
	</div>
	</article>
	</section>
	<div style="text-align: center;">
	
	<div class="clear"></div>
	<div id="page_control">
		<c:if test="${ pageDto.totalCount gt 0 }">
			<%-- [이전] --%>
			<c:if test="${ pageDto.startPage gt pageDto.pageBlock }">
				<a href="/memberListAdmin.do?pageNum=${ pageDto.startPage - pageDto.pageBlock }">[이전]</a>
			</c:if>
			
			<%-- 페이지블록 내에서의 시작페이지부터 끝페이지까지 번호출력 --%>
			<c:forEach var="i" begin="${ pageDto.startPage }" end="${ pageDto.endPage }" step="1">
			<a href="/memberListAdmin.do?pageNum=${ i }">
			<c:choose>
				<c:when test="${ i eq pageNum }">
					<span style="font-weight: bold;">[${ i }]</span>
				</c:when>
				<c:otherwise>
					[${ i }]
				</c:otherwise>
			</c:choose>
			</a>
		</c:forEach>
			
		<%-- [다음] --%>
		<c:if test="${ pageDto.endPage < pageDto.pageCount }">
			<a href="/memberListAdmin.do?pageNum=${ pageDto.startPage + pageDto.pageBlock }">[다음]</a>
		</c:if>	
		</c:if>
	</div>
	</div>
	</div>
	</div>
	
	<%-- footer 영역  include bottom.jsp --%>
	<jsp:include page="/WEB-INF/views/include/bottom.jsp" />
	
	<!-- Scripts -->
	<script src="/script/jquery.min.js"></script>
	<script src="/script/jquery.scrolly.min.js"></script>
	<script src="/script/jquery.scrollex.min.js"></script>
	<script src="/script/skel.min.js"></script>
	<script src="/script/util.js"></script>
	<script src="/script/main.js"></script>
	<script src="/script/bootstrap.js"></script>
	<script src="/script/jquery-3.5.1.js"></script>
			
</body>
</html>




