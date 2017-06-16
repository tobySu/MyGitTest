<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
<jsp:include page="inc/inc.jsp"></jsp:include>
<link href="<c:url value='/static/bootstrap/datepicker/css/datepicker.css' />" rel="stylesheet">
<link href="<c:url value='/static/bootstrap/dist/css/typeahead.css' />" rel="stylesheet">
<script type="text/javascript" src="<c:url value='/static/bootstrap/datepicker/js/bootstrap-datepicker.js' />"></script>
<script type="text/javascript" src="<c:url value='/static/bootstrap/datepicker/js/locales/bootstrap-datepicker.zh-CN.js' />"></script>
<script type="text/javascript" src="<c:url value='/static/bootstrap/dist/js/typeahead.min.js'/>"></script>
<script type="text/javascript">
$(function(){
	$('#down').click(function(){
		window.location.href= "<c:url value='/download'/>";
	});
	if("${upload}"=='true'){
		alert("${message}");
	}
	$('#beginTime,#endTime').datepicker({
		language : 'zh-CN',
		format : 'yyyy-mm-dd',
		calendarWeeks : true,
		autoclose : true,
		todayHighlight : true
	});
});
/* function upload(){
	$("#uploadForm").submit();
} */
</script>
</head>

<body>
<c:out value="aaa"></c:out>
<button id='down' class="btn btn-primary">test download</button>
<form action="<c:url value='/download'/>" method="get">
<input type="submit" value="form">
</form>
<form action="<c:url value='/upload'/>" enctype="multipart/form-data" id="uploadForm" method="post">
普通：<br>
<input type="file" name="file" id="file"/><br>
路径：<input type="text" name ="path"/>
<input type="submit" value="upload"/>

</form>


<br><br><br><br>
<form action="<c:url value='/testMethod'/>" method="post">
<input type="hidden" name="name" value="testname">
<input type="submit" value="submit">
</form>

<br><br>
时间控件：<br>
<div id="datePicker" style="width:33%;padding-left:15px;">	
	<div class="row">
		<div class="col-md-6 padding-right-0 " >
			<div id="beginTime_search" class="input-group date">
				<input type="text" id="beginTime" class="form-control" name="beginTime" placeholder="开始时间">  
				<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
			</div>
		</div>
		<div class="col-md-6 padding-left-0">
			<div id="endTime_search" class="input-group date">
				<input type="text" id="endTime" class="form-control" name=endTime placeholder="结束时间"> 
				<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
			</div>
		</div>
	</div>
</div>

<br>
<span class="glyphicon glyphicon-search"></span>

</body>

</html>