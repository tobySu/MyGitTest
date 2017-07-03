<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ attribute name="id" required="true" description="每个分页组件，将有一个唯一 ID" %>
<div id="${id}">
test tag body
</div>
<br>
<jsp:doBody/>
<br><input type="button" value="testBtn" id ="btnId"/>
<script type="text/javascript">
$(document).ready(function(){
	$('#btnId').click(function(){
		$('#${id}').trigger('tobyEvn',['${id}','test']);	
	})
	
});
</script>