<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Admin | Charts</title>
<link rel="stylesheet" href="/css/index.css" />
<link rel="stylesheet" href="/css/bootstrap.css" />
<link rel="stylesheet" href="/css/bootstrap-theme.css" />
<link rel="stylesheet" href="/css/font-awesome.min.css" />
<style>
p {
cursor: pointer;
}
img {
margin-bottom: 0px !important;
}
i {
color: #3a89ff
}
.pages {
width: 500px !important;
margin: auto;
}
div .pie_chart {
width: 550px;
height: 400px;
}
</style>
</head>
<body>
	<div id="top-menu">
		<%-- top 영역  include top.jsp --%>
		<jsp:include page="/WEB-INF/views/include/top.jsp" />
	</div>
	
	<div id="wrapper">
		<div id="page" class="container">
			<div class="col-md-3">
				<%--  관리 항목 영역  include board_submenu_admin.jsp --%>
				<jsp:include page="/WEB-INF/views/include/board_submenu_admin.jsp" />
			</div> 
			<div class="col-md-9 column4">
				<h3 class="sub_title">통계</h3>
					<input type="hidden" value=${ dateStr }>
					<input type="hidden" value=${ ageStr }>
					<div id="pie_chart_1" class="pie_chart"></div>
					<div id="pie_chart_2" class="pie_chart"></div>
			</div>
		</div>
	</div>
	<script src="https://www.gstatic.com/charts/loader.js"></script>
	<script>
	google.charts.load('current', {packages: ['corechart']});
	
	google.charts.setOnLoadCallback(function () {
		pieChart1();
		pieChart2();
	});
	
	// 차트 1
	function pieChart1() {
		var arr = ${ dateStr };	
		var dataTable = google.visualization.arrayToDataTable(arr);
		var options = {
				title: '기간별 게시글 작성수'
		};
		
		var objDiv = document.getElementById('pie_chart_1');
		var chart = new google.visualization.PieChart(objDiv);
		chart.draw(dataTable, options);
	}
	
	// 차트2
	function pieChart2() {
		var arr = ${ ageStr };
		var dataTable = google.visualization.arrayToDataTable(arr);
		var options = {
				title: '회원 연령대 분포'
		};
		
		var objDiv = document.getElementById('pie_chart_2');
		var chart = new google.visualization.PieChart(objDiv);
		chart.draw(dataTable, options);
	}
	</script>
	
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