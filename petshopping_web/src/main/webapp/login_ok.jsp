<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="refresh" content="10;url=./">
<link rel="icon" href="<%=request.getContextPath()%>/images/chicken.png">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/petsh.css">
<title>毛 孩 糧 倉-登入成功</title>
<script type="text/javascript">
	
</script>
</head>
<body>
	<jsp:include page="/subviews/header.jsp">
		<jsp:param value="歡迎光臨" name="subHeader" />
	</jsp:include>
	<%@include file="/subviews/nav.jsp"%>
	<article>
		<h3 id="aftLogin">
			<%=member != null ? member.getName() + "歡迎回來" : "尚未登入"%>
		</h3>
	</article>
	<%@include file="/subviews/footer.jsp"%>
</body>
</html>