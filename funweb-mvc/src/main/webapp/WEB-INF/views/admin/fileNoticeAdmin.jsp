<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>fileNoticeAdmin</title>
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

	<div class="container">
	<div class="row">

	<div class="col-md-3">
	<%--  관리 항목 영역  include board_submenu_admin.jsp --%>
	<jsp:include page="/WEB-INF/views/include/board_submenu_admin.jsp"/>
	</div>


	<div class="col-md-9 mt-sm-20" style="margin-top : 20px;">

	<h1>파일 게시판(관리자용) [전체글갯수: ${ pageDto.totalCount} ]</h1>
	<form action="fileNoticeAdminDelete.do" method="post">	
	
	<div class="table-responsive col-md-12">	
	<table class="table table-striped">
		<tr>
			<th class="select">선택</th>
			<input type="hidden" name="pageNum" value="${ pageNum }">
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:choose>
			<c:when test="${ pageDto.totalCount gt 0}">
				<%-- ${ not empty boardList } --%>
				
				<c:forEach var="board" items="${ boardList }">
					<tr onclick="'location.href=fileContent.do?num=${ board.num }&pageNum=${ pageNum }'">
					<td>
						<input id="${ board.num }" type="checkbox" name="selected" value="${ board.num }">
						<label for="${ board.num }"> </label>
					</td>
						<td>${ board.num }</td>
						<td style="text-align: left !important; cursor: pointer;">
							<c:if test="${ board.reLev gt 0 }">
								<img src="/images/center/level.gif" width="${ board.reLev * 10 }" height="13">
								<img src="/images/center/re.gif">
							</c:if> ${ board.subject }
						</td>
						<td>${ board.name }</td>
						<td><javatime:format value="${ board.regDate }" pattern="yyyy.MM.dd" /></td>
						<td>${ board.readcount }</td>
					</tr>	 
				</c:forEach>
			</c:when>
				<c:otherwise>
					<tr>
						<td colspan="5">게시판 글없음</td>
					</tr>
				</c:otherwise>
		</c:choose>
	</table>
	</div>
	<button class="adminDeleteButton" type="submit" id="delete-button">삭제</button>
</form>

	<div id="table_search">
		<form action="/fileNoticeAdmin.do" method="get">
		<select name="category" class="category">
			<option value="content" ${ pageDto.category eq 'content' ? 'selected' : '' }>글내용</option>
			<option value="subject" ${ pageDto.category eq 'subject' ? 'selected' : '' }>글제목</option>
			<option value="name" ${ pageDto.category eq 'name' ? 'selected' : '' }>작성자</option>
		</select>
		<input type="text" name="search" value="${ pageDto.search }" class="searchbox"> 
		<input type="submit" value="검색" class="button-search">
		</form>
		
	</div>
	</div>
	</div>
	</div>
	<div class="col-md-3"></div>
	<div id="page_control" class="col-md-9" style="text-align:center;">
		<c:if test="${ pageDto.totalCount gt 0 }">
				<%-- [이전] --%>
				<c:if test="${ pageDto.startPage gt pageDto.pageBlock }">
					<a href="/fileNoticeAdmin.do?pageNum=${ pageDto.startPage - pageDto.pageBlock }&category=${ pageDto.category }&search=${ pageDto.search }">[이전]</a>
				</c:if>
				
				<%-- 페이지블록 내에서의 시작페이지부터 끝페이지까지 번호출력 --%>
				<c:forEach var="i" begin="${ pageDto.startPage }" end="${ pageDto.endPage }" step="1">
					<a href="/fileNoticeAdmin.do?pageNum=${ i }&category=${ pageDto.category }&search=${ pageDto.search }">
					<c:choose>
						<c:when test="${ i eq pageNum }">
							<span style="font-weight: bold; color: red;">[${ i }]</span>
						</c:when>
						<c:otherwise>
							[${ i }]
						</c:otherwise>
					</c:choose>
					</a>
				</c:forEach>

			<%-- [다음] --%>
			<c:if test="${ pageDto.endPage < pageDto.pageCount }">
				<a href="/fileNoticeAdmin.do?pageNum=${ pageDto.startPage + pageDto.pageBlock }&category=${ pageDto.category }&search=${ pageDto.search }">[다음]</a>
			</c:if>
			</c:if>
	</div>
	</div>
	</div>

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