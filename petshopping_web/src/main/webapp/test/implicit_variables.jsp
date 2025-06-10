<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" href="<%=request.getContextPath()%>/images/icon_cat.png">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/petsh.css">
<title>implicit variable</title>
</head>
<body>
	<h2>request-隱含變數</h2>
	<hr />
	<p>
		request.getContextPath():<%=request.getContextPath()%>
	</p>
</body>
</html>