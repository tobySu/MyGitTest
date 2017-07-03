<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags/toby" prefix="tb"%>

<body>
<jsp:include page="inc/inc.jsp"></jsp:include>
${toby.name}
<c:set value="test" var="test"/>
<c:out value="${test}"></c:out>
<tb:toby id="testId">
test jsp body
</tb:toby>
<div id='testEvnId'></div>
</body>
	
	
<script type="text/javascript">
	
$(document).ready(function(){
	$('#testId').bind('tobyEvn',function(e,id,test){
		$('#testEvnId').html('tobyEvn id :'+ JSON.stringify(e) +'<br>');
		$('#testEvnId').append('tobyEvn id :'+id+'test:'+test);
	});
});
	
</script>

