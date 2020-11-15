<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>updateUserCheck</title>
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
				
	<h1>사용자 확인</h1>
		<hr>
		
			<form action="memberUpdateUserCheckPro.do" method="post">
				<!-- hidden 타입 input태그로 사용자 눈에 안보이게 전송 -->
				<input type="hidden" name="id" value="${ sessionScope.id }">
				비밀번호 <input type="password" name="passwd" style="width : 200px"><br><br>
				<input type="submit" value="비밀번호 확인" class="updateUserCheck-input">
			</form>
		
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




