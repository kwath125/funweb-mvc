<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>content</title>
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
	
	<article>
	<div class="table-responsive">
	<h1>공개 게시판 Content</h1>
		
	<table class="table table-striped" id="table table-striped" style="width: auto !important;">
		<tr>
			<th scope="col" width="200">글번호</th>
			<td width="500" style="text-align: left;">${ boardVo.num }</td>
		</tr>
		<tr>
			<th scope="col">조회수</th>
			<td style="text-align: left;">${ boardVo.readcount }</td>
		</tr>
		<tr>
			<th scope="col">작성자</th>
			<td style="text-align: left;">${ boardVo.name }</td>
		</tr>
		<tr>
			<th scope="col">작성일</th>
			<td style="text-align: left;"><javatime:format value="${ boardVo.regDate }" pattern="yyyy.MM.dd HH:mm"/></td>
		</tr>
		<tr>
			<th scope="col">글제목</th>
			<td style="text-align: left;">${ boardVo.subject }</td>
		</tr>
		<tr>
			<th scope="col">글내용</th>
			<td style="text-align: left;">${ boardVo.content }</td>
		</tr>
	</table>
	
	<div id="table_search">
		<button type="button" class="button" onclick="location.href='fileModifyForm.do?num=${ boardVo.num }&pageNum=${ pageNum }'">글수정</button>
		<button type="button" class="button" onclick="location.href='fileDelete.do?num=${ boardVo.num }&pageNum=${ pageNum }'">글삭제</button>
		<button type="button" class="button" onclick="location.href='replyWriteForm.do?reRef=${ boardVo.reRef }&reLev=${ boardVo.reLev }&reSeq=${ boardVo.reSeq }&pageNum=${ pageNum }'">답글쓰기</button>
		<button type="button" class="button" onclick="location.href='notice.do?pageNum=${ pageNum }'">목록보기</button>
	</div>
	
	<div class="clear"></div>
	<div id="page_control">
	</div>
	</div>
	</article>
    
	<div class="clear"></div>
	</div>
	</div>
	
	<%-- footer 영역  include bottom.jsp --%>
	<jsp:include page="/WEB-INF/views/include/bottom.jsp"/>
	
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

