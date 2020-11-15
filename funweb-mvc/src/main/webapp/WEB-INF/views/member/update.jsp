<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<title>update</title>
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
					<h1>회원정보 수정</h1>
					<div class="sample-text" class="genric-btn info-border circle">
					<hr>
					
					<form action="memberUpdatePro.do" method="post" class="memberUpdate">
						<label>아이디</label><input type="text" name="id" value="${ sessionScope.id }" readonly><br>
						<label>비밀번호</label><input type="password" name="passwd" id="passwd"><br>
						<label>비밀번호 확인</label><input type="password" name="passwd2" id="passwd2"><br>
						<span id="passwdMessage"></span><br>
						<label>이름</label><input type="text" name="name" value="${ member.name }"><br>
						<label>나이</label><input type="number" name="age" min="0" max="150" value="${ member.age }"><br>
						<label>성별</label><input type="radio" name="gender" value="남">남자
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
		
	<script>
	// 패스워드 일치여부 확인
	var passwd = document.getElementById('passwd');
	var passwd2 = document.getElementById('passwd2');
	var spanMessage = document.getElementById('passwdMessage');
	
	passwd2.onkeyup = function() {
		console.log('타이핑 중');
	
		if (passwd.value != passwd2.value) {
			spanMessage.style.color = "red";
			spanMessage.innerHTML = '비밀번호가 일치하지 않습니다.'
		} else {
			spanMessage.style.color = "green";
			spanMessage.innerHTML = '비밀번호 일치.';
		}
		
	};
	
	
	</script>
	
	
	
</body>
</html>






