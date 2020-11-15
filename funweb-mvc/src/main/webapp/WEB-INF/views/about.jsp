<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>Introduction</title>
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
			<div>
				<div class="col-md-6 col-sm-12">
					<h2>여!놀자란?</h2>
						<p>여!놀자는 여행을 좋아하는 사람들과 다양한 정보, 여행후기 등을 공유하는 커뮤니티 사이트 입니다.</p>
				</div>
				<div class="col-md-6 col-sm-12">
					<img src="/images/about/about1.jpg" style="width: 100%;">
				</div>
			</div>
		</div>
	</div>
	<div class="clearfix"></div>
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