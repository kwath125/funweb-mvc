<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time"%>
<!DOCTYPE html>
<html>

<head>
<title>memberUpdateAdmin</title>
<link rel="stylesheet" href="/css/index.css" />
<link rel="stylesheet" href="/css/bootstrap.css" />
<link rel="stylesheet" href="/css/bootstrap-theme.css" />
<link rel="stylesheet" href="/css/font-awesome.min.css" />
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

					<div class="col-md-3 col-lg-3">
						<%--  관리 항목 영역  include board_submenu_admin.jsp --%>
						<jsp:include page="/WEB-INF/views/include/board_submenu_admin.jsp" />
					</div>

					<article>
						<div class="col-md-9 col-lg-9 table-responsive">
							<h1>회원정보</h1>

							<table class="table table-striped" id="table table-striped" style="width: auto !important;">
								<tr>
									<th scope="col" width="200">아이디</th>
									<td width="500" style="text-align: left;">${ member.id }</td>
								</tr>

								<tr>
									<th scope="col">비밀번호</th>
									<td style="text-align: left;">${ member.passwd }</td>
								</tr>

								<tr>
									<th scope="col">이름</th>
									<td style="text-align: left;">${ member.name }</td>
								</tr>

								<tr>
									<th scope="col">가입일</th>
									<td style="text-align: left;"><javatime:format value="${ member.regDate }" pattern="yyyy.MM.dd HH:mm" /></td>
								</tr>

								<tr>
									<th scope="col">이메일</th>
									<td style="text-align: left;">${ member.email }</td>
								</tr>

							</table>
							
							<div id="table_search">
								<button type="button" class="button" onclick="location.href = 'memberUpdateFormAdmin.do?id=${ member.id }'">회원수정</button>
								<button type="button" class="button" onclick="location.href='memberListAdmin.do'">회원목록</button>
							</div>

						</div>
					</article>
				</div>
			</div>
		</div>
	</div>

	<%-- bottom 영역  include bottom.jsp --%>
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
