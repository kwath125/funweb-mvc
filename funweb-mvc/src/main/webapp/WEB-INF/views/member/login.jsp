<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
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
			<div class="col-md-9">
				<div>
					<h1>로그인</h1>
				</div>
				<form action="/memberLoginPro.do" method="post" id="login">
					<fieldset id="fieldset-login">
						<label id="login-label">아이디</label> 
							<input type="text" name="id" id="login-input"><br> 
						<label id="login-label">비밀번호</label>
							<input type="password" name="passwd" id="login-input"><br>
							<input type="checkbox" name="keepLogin" value="true" id="keepLogin"> 
						<label for="keepLogin">로그인 유지</label>
					</fieldset>

					<div class="clear"></div>
						<div id="buttons">
							<input type="submit" value="로그인" class="button"> 
							<input type="reset" value="초기화" class="button">
						</div>
				</form>
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

