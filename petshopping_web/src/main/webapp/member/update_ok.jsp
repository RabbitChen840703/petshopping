<%@ page pageEncoding="UTF-8"%>
<%@page import="uuu.petshopping.Entity.Client"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="refresh" content="10;url=./">
<link rel="icon" href="<%=request.getContextPath()%>/images/chicken.png">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/petsh.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/JavaScript/jquery.js"></script>
<title>毛 孩 糧 倉-修改成功</title>
<script type="text/javascript"></script>
</head>
<body>
	<jsp:include page="/subviews/header.jsp">
		<jsp:param value="修改成功" name="subHeader" />
	</jsp:include>
	<%@include file="/subviews/nav.jsp"%>
	<article>
		<h3>歡迎光臨, ${sessionScope.member.getName()} 修改成功</h3>
		<p>10秒後自動跳轉<a href="<%=request.getContextPath()%>">首頁</a></p>	
	</article>
	<%@include file="/subviews/footer.jsp"%>
</body>
</html>