<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time"%>
<!DOCTYPE html>
<html>
<head>
<title>notice</title>
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

			<!-- Main -->
			<section>
				<article>
					<h1 style="padding-left: 15px !important;">공개 게시판 [전체글갯수: ${ requestScope.pageDto.totalCount} ]</h1>

					<div class="table-responsive col-md-12">
						<table class="table table-striped">
							<tr>
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
										<tr
											onclick="location.href='content.do?num=${ board.num }&pageNum=${ pageNum }'">
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

					<div class="col-md-6"></div>
					<div id="table_search" class="col-md-5 col-md-offset-1">
						<form action="/notice.do" method="get">
							<select name="category" class="category">
								<option value="content" class="" ${ pageDto.category eq 'content' ? 'selected' : '' }>글내용</option>
								<option value="subject" ${ pageDto.category eq 'subject' ? 'selected' : '' }>글제목</option>
								<option value="name" ${ pageDto.category eq 'name' ? 'selected' : '' }>작성자</option>
							</select> 
							<input type="text" name="search" value="${ pageDto.search }" class="searchbox"> <input type="submit" value="검색"class="button-search">
						</form>

						<input type="button" value="글쓰기" class="button"onclick="location.href='writeForm.do?pageNum=${ pageNum }'">
					</div>

				</article>
			</section>
		</div>

		<div class="clear"></div>
		<div id="page_control">
			<c:if test="${ pageDto.totalCount gt 0 }">
				<%-- [이전] --%>
				<c:if test="${ pageDto.startPage gt pageDto.pageBlock }">
					<a href="/notice.do?pageNum=${ pageDto.startPage - pageDto.pageBlock }&category=${ pageDto.category }&search=${ pageDto.search }">[이전]</a>
				</c:if>
				
				<%-- 페이지블록 내에서의 시작페이지부터 끝페이지까지 번호출력 --%>
				<c:forEach var="i" begin="${ pageDto.startPage }" end="${ pageDto.endPage }" step="1">
					<a href="/notice.do?pageNum=${ i }&category=${ pageDto.category }&search=${ pageDto.search }">
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
				<a href="/notice.do?pageNum=${ pageDto.startPage + pageDto.pageBlock }&category=${ pageDto.category }&search=${ pageDto.search }">[다음]</a>
			</c:if>
			</c:if>
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

