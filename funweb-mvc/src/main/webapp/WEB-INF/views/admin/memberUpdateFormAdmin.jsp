<%@page import="exam.domain.MemberVo"%>
<%@page import="exam.dao.MemberDao"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>memberUpdateFormAdmin</title>
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
					<section class="container">
					<div class="box">
					<h1>회원정보 수정(관리자 전용)</h1>
					<div class="sample-text" class="genric-btn info-border circle">
					<hr>
					
					<form action="memberUpdateProAdmin.do" method="post" class="memberUpdate">
						<label>아이디</label><input type="text" name="id" value="${ member.id }" readonly ><br>
						<label>비밀번호</label><input type="password" name="passwd"><br>
						<label>비밀번호 확인</label><input type="password" name="passwd2"><br>
						<label>이름</label><input type="text" name="name" value="${ member.name }"><br>
						<label>나이</label><input type="number" name="age" min="0" max="150" value="${ member.age }"><br>
						<label>성별</label>
							<input type="radio" name="gender" value="남" checked>남자
						    <input type="radio" name="gender" value="여" >여자<br>
						<label>이메일</label><input type="email" name="email" value="${ member.email }"><br><br>
						<label></label><input type="submit" value="회원수정" class="memberUpdateConfirm">
					</form>
					</div>
					</div>
					</section>
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






