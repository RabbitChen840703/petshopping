<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="<%= request.getContextPath() %>/css/petsh.css">
	<link rel="icon" href="<%= request.getContextPath()%>/images/chicken.png">
	<title>ErrorPage</title>
	<style type="text/css">
		body {
			background: #BF6573;			
	}
	.errorDiv{
		text-align: center;
		vertical-align: middle;
	}
	</style>
</head>
<body>
	<div class="errorDiv">
		<br><br>
		<h1>權限不足&ensp;&ensp;請付費解鎖更多精彩內容~~~~~</h1>
		<img src="<%= request.getContextPath()%>/images/error_icon.png"/>
	</div>
	<%@ include file="/subviews/footer.jsp" %>
</body>
</html>