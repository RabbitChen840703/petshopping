<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="refresh" content="10;url=./">
<link rel="icon" href="<%=request.getContextPath()%>/images/chicken.png">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/petsh.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/JavaScript/jquery.js"></script>
<title>毛 孩 糧 倉</title>
<script type="text/javascript"></script>
</head>
<body>
	<jsp:include page="/subviews/header.jsp">
		<jsp:param value="註冊成功" name="subHeader" />
	</jsp:include>
	<%@include file="/subviews/nav.jsp"%>
	<article>
		<h3>${requestScope.member!=null?member.getName():"尚未註冊成功" }</h3>
		<p>10秒後將自動跳轉<a href="./">首頁</a></p>
	</article>
	<%@include file="/subviews/footer.jsp"%>
</body>
</html>