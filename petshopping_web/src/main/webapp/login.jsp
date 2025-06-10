<%@page import="java.util.List"%>
<%@ page pageEncoding="UTF-8"%>
<%@page import="uuu.petshopping.Entity.Client"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" href="<%=request.getContextPath()%>/images/chicken.png">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/petsh.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/JavaScript/jquery.js"></script>
<title>毛 孩 糧 倉-會員登入</title>
<script>
	$(function initLogin() {
		$("#id").attr({ "size" : 90, "type" : "text", "placeholder" : "請輸入帳號" });
		$("#password").attr({ "size" : 90, "type" : "password", "placeholder" : "請輸入密碼" });
		$("#eye").attr({ "src" : "./images/eye.png", "width" : "10px" }).mousedown(showHandler).mouseleave(hideHandler).mouseup(
				hideHandler);
		$("#captCha").attr({ "type" : "password", "placeholder" : "輸入下方驗證碼" });
		var url = "captCha?re=" + Date.now().toString(16);
		$("#captChai").attr("src", url);
		$("#loGCV").attr({ "type" : "button", "value" : "更新驗證碼" }).click(refreshCaptCha);
		$("#loRes").attr({ "type" : "reset", "value" : "重新填寫" });
		$("#loSub").attr({ "type" : "submit", "value" : "登入會員" });
		$("#loFPd").attr({ "type" : "button", "value" : "忘記密碼" });
	});
	function showHandler() {
		$("#password").attr("type", "text");
	}
	function hideHandler() {
		$("#password").attr("type", "password");
	}
	function refreshCaptCha() {
		var url = "captCha?re=" + Date.now().toString(16);
		$("#captChai").attr("src", url);
	}
<%List<String> errorsList = (List<String>) request.getAttribute("errorsList");%>
	
</script>
</head>
<body>
	<jsp:include page="/subviews/header.jsp">
		<jsp:param value="會員登入" name="subHeader" />
	</jsp:include>
	<%@ include file="/subviews/nav.jsp"%>
	<article>
		<form id="loginForm" method="post" action="login.do">
			<p class="errorsList"><%=errorsList != null ? errorsList : ""%></p>
			<p>
				<label for="id">會員帳號：</label><input name="id" id="id" required>
			</p>
			<p>
				<label for="password"> 會員密碼：</label><input name="password" id="password" required><img id="eye" />
			</p>
			<p>
				<label for="captCha"> 驗&ensp;證&ensp;碼：</label><input name="captCha" id="captCha" required><br /> <img id="captChai">
			</p>
			<div id="loUS">
				<input id="loGCV">&nbsp;<input id="loRes">&nbsp;<input id="loSub">&nbsp;<input id="loFPd">
			</div>
		</form>
	</article>
	<%@include file="/subviews/footer.jsp"%>
</body>
</html>