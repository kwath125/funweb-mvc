<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- ${ cookie.쿠키이름.value } --%>
<c:if test="${ not empty cookie.id.value }">
	<c:set var="id" value="${ cookie.id.value }" scope="session" />
</c:if>

<!-- Nav -->
<nav id="top-menu-navbar" role="navigation">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
			<span class="sr-only">Navigation</span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</button>
	</div>
	<div id="menu-navbar" class="navbar-collapse navbar-ex1-collapse collapse in" aria-expanded="true">
			<ul class="nav navbar-nav">
				<li><a href="/index.do" accesskey="1" title="">홈으로</a></li>
				<li><a href="/about.do" accesskey="2" title="">커뮤니티소개</a></li>
				<li><a href="/notice.do" accesskey="3" title="">공개게시판</a></li>
			</ul>
				<div class="navbar-right">
					<ul class="nav navbar-nav">
						<c:choose>
							<c:when test="${ not empty sessionScope.id && sessionScope.id eq 'admin' }">
								<li><a href="/memberLogout.do">로그아웃</a></li>
								<li><a href="/memberUpdateUserCheck.do">회원정보수정</a></li> 
								<li><a href="/memberDelete.do">회원정보삭제</a></li>
								<li><a href="/fileNotice.do">파일게시판</a></li>
								<li><a href="/memberListAdmin.do">관리자 메뉴</a></li>	
							</c:when>
							
							<c:when test="${ not empty sessionScope.id }">
								<li><a href="/memberLogout.do">로그아웃</a></li>
								<li><a href="/memberUpdateUserCheck.do">회원정보수정</a></li> 
								<li><a href="/memberDelete.do">회원정보삭제</a></li>
								<li><a href="/fileNotice.do">파일게시판</a></li>
							</c:when>
							
							<c:otherwise>
								<li><a href="/memberLogin.do">로그인</a><li>
								<li><a href="/memberJoin.do">회원가입</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
	</div>
</nav>