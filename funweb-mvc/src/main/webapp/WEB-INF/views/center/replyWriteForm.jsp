<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>replyWriteForm</title>
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
	
	<div class="table-responsive">	
	<article>

	<h1>공개 게시판 답글작성</h1>
	
	<form action="replyWritePro.do" method="post" name="frm">
	<input type="hidden" name="reRef" value="${ boardVo.reRef }">
	<input type="hidden" name="reLev" value="${ boardVo.reLev }">
	<input type="hidden" name="reSeq" value="${ boardVo.reSeq }">
	<input type="hidden" name="pageNum" value="${ pageNum }">
	<table class="table table-striped"id="table table-striped">
		<tr>
			<th scope="col" width="200">이름</th>
			<td style="text-align: left; width: 500px;">
				<input type="text" name="name">
			</td>
		</tr>
		<tr>
			<th scope="col">비밀번호</th>
			<td style="text-align: left;">
				<input type="password" name="passwd">
			</td>
		</tr>
		<tr>
			<th scope="col">글제목</th>
			<td style="text-align: left;">
				<input type="text" name="subject" value="[RE:]">
			</td>
		</tr>
		<tr>
			<th scope="col">글내용</th>
			<td style="text-align: left;">
				<textarea rows="13" cols="40" name="content"></textarea>
			</td>
		</tr>
	</table>

	<div id="table_search">
		<button type="submit" class="button">답글쓰기</button>
		<button type="reset" class="button">다시쓰기</button>
		<button type="button" class="button" onclick="location.href='notice.jsp?pageNum=${ pageNum }'">목록보기</button>
	</div>
	</form>
	
	<div class="clear"></div>
	<div id="page_control">
	</div>
	
	</article>
    </div>
	</div>
	</div>	
    
	<div class="clear"></div>
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

