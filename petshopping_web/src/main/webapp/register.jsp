<%@page import="java.time.LocalDate"%>
<%@page import="uuu.petshopping.Entity.Client"%>
<%@page import="java.util.List"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" href="<%=request.getContextPath()%>/images/chicken.png">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/petsh.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/JavaScript/jquery.js"></script>
<title>毛 孩 糧 倉-註冊會員</title>
<script>

	$(function initRegister() {
		var url = "captCha?re=" + Date.now().toString(16);
		$("#regForm").attr({ "method" : "post", "autocomplete" : "off", "autofocus" : "autofocus" });
		$("#id").attr({ "type" : "text", "size" : 90,  "placeholder" : "請輸入ROCID " });
		$("#id").attr("pattern", "<%=Client.ID_PATTERN%>");
		$("#password").attr({ "type" : "password", "size" : 90, "placeholder" : "8~12位數密碼" });
		$("#password").attr({"minlength" : <%=Client.MIN_PWD_LENGTH%>});
		$("#password").attr({"maxlength" : <%=Client.MAX_PWD_LENGTH%>});
		$("#eye").attr({ "src" : "./images/eye.png", "width" : "10px" }).mousedown(showHandler).mouseleave(hideHandler).mouseup(
				hideHandler);
		$("#name").attr({ "type" : "text", "size" : 90, "placeholder" : "您的姓名" });
		$("#name").attr({"minlength" : <%=Client.MIN_NAME_LENGTH%>});
		$("#name").attr({"maxlength" : <%=Client.MAX_NAME_LENGTH%>});
		$("#email").attr({ "type" : "email", "size" : 90, "placeholder" : "電子信箱" });
		$("#email").attr("pattern", "<%=Client.EMAIL_PATTERN%>");
		$("#address").attr({ "size" : 28 });
		$("#phone").attr({ "type" : "tel","placeholder" : "請輸入手機號碼" });
		$("#phone").attr({"pattern" : "<%=Client.PHONE_PATTERN%>"});		
		$("#birthday").attr({ "type" : "date", "max" : "<%=LocalDate.now().minusYears(Client.MIN_AGE)%>" });
		$("#captCha").attr({ "type" : "text", "size" : 28, "placeholder" : "請輸入下方驗證碼" });
		$("#captChai").attr({ "src" : url });
		$("#regGetCV").click(refreshCaptcha);
	});
	function showHandler() {
		$("#password").attr("type", "text");
	}
	function hideHandler() {
		$("#password").attr("type", "password");
	}
	function refreshCaptcha() {
		url = "captCha?re=" + Date.now().toString(16);
		$("#captChai").attr("src", url);
	}
<%List<String> errorsList = (List<String>) request.getAttribute("errorsList");%>
	
</script>
</head>
<body>
	<jsp:include page="/subviews/header.jsp">
		<jsp:param value="會員註冊" name="subHeader" />
	</jsp:include>
	<%@ include file="/subviews/nav.jsp"%>
	<article>
		<form id="regForm" action="<%=request.getContextPath()%>/register.do">
			<fieldset class="userData">
				<p class="errorsList"><%=errorsList != null ? errorsList : ""%></p>
				<legend>會員基本資料</legend>
				<p>
					<label for="id"> 設定帳號：</label><input name="id" id="id" required>
				</p>
				<p>
					<label for="password"> 設定密碼：</label><input name="password" id="password" required><img id="eye" />
				</p>
				<p>
					<label for="name"> 大&emsp;&emsp;名：</label><input name="name" id="name" required>
				</p>
				<p>
					<label for="email"> 電子信箱：</label><input name="email" id="email" required>
				</p>
				<p>
					<label for="address"> 地&emsp;&emsp;址：</label><input name="address" id="address"><label for="phone">
						電&emsp;&emsp;話：</label><input name="phone" id="phone" required /><label for="gender"></label> 性&emsp;&emsp;別：<select name="gender"
						id="gender" required>
						<option id="defG" selected disabled>請選擇</option>
						<option id="male" value='M'>Male</option>
						<option id="female" value='F'>Female</option>
						<option id="other" value='O'>Other</option>
					</select>
				</p>
				<p>
					<label for="birthday"> 生&emsp;&emsp;日：</label><input name="birthday" id="birthday" required>
				</p>
				<p>
					<label for="captCha"> 驗&ensp;證&ensp;碼：</label><input name="captCha" id="captCha" required /><br /> <img id="captChai"
						alt="驗證碼圖片">
				</p>
			</fieldset>
			<fieldset class="udi">
				<div id="reUB">
					<button id="regGetCV">更新驗證碼</button>
					<button type="reset" id="regReset">重新輸入</button>
					<button type="submit" id="regSubmit">註冊會員</button>
				</div>
			</fieldset>
		</form>
	</article>
	<%@ include file="/subviews/footer.jsp"%>
</body>
</html>