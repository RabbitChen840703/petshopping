<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" href="<%=request.getContextPath()%>/images/chicken.png">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/petsh.css">
<title>毛 孩 糧 倉-產品資訊</title>
<style>
</style>
</head>
<body>
	<jsp:include page="/subviews/header.jsp">
		<jsp:param value="產品資訊" name="subHeader" />
	</jsp:include>
	<%@ include file="/subviews/nav.jsp"%>
	<article>
		<%@ include file="/product_data.jsp" %>
	</article>
	<%@include file="/subviews/footer.jsp"%>
</body>
</html>