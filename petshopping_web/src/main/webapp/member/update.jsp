<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@ page pageEncoding="UTF-8"%>
<%@page import="uuu.petshopping.Entity.VIP"%>
<%@page import="uuu.petshopping.Entity.Client"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" href="<%=request.getContextPath()%>/images/chicken.png">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/petsh.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/JavaScript/jquery.js"></script>
<title>毛 孩 糧 倉-修改會員</title>
<script type="text/javascript">
	$(function initUpdate() {
		var url = "<%=request.getContextPath()%>/captCha?re=" + Date.now().toString(16);
		$("#id").attr({ "type" : "text", "size" : 90,  "placeholder" : "請輸入ROCID " });
		$("#id").attr("pattern", "<%=Client.ID_PATTERN%>");
		$("#password").attr({ "type" : "password", "size" : 90, "placeholder" : "6~20位數密碼" });
		$("#password").attr({"minlength" : <%=Client.MIN_PWD_LENGTH%>});
		$("#password").attr({"maxlength" : <%=Client.MAX_PWD_LENGTH%>});
		$("#eye").attr({"src": "<%=request.getContextPath()%>/images/eye.png", "width": "10px"}).mousedown(showHandler).mouseleave(hideHandler).mouseup(
				hideHandler);
		$("#renewPwd").attr("type","checkbox").change(changePwd);
		$("#newPwd").attr({ "type" : "password", "size" : 90, "placeholder" : "6~20位數新密碼" });
		$("#newPwd").attr({"minlength" : <%=Client.MIN_PWD_LENGTH%>});
		$("#newPwd").attr({"maxlength" : <%=Client.MAX_PWD_LENGTH%>});
		$("#name").attr({ "type" : "text", "size" : 90, "placeholder" : "您的姓名" });
		$("#name").attr({"minlength" : <%=Client.MIN_NAME_LENGTH%>});
		$("#name").attr({"maxlength" : <%=Client.MAX_NAME_LENGTH%>});
		$("#email").attr({ "type" : "email", "size" : 90, "placeholder" : "電子信箱" });
		$("#email").attr("pattern", "<%=Client.EMAIL_PATTERN%>");
		$("#address").attr({ "size" : 35 , "maxlength" : 100, "placeholder" : "請輸入地址" });		
		$("#phone").attr({ "type" : "tel","size": 12 , "placeholder" : "請輸入手機號碼" });	
		$("#phone").attr({"pattern" : "<%=Client.PHONE_PATTERN%>"});		
		$("#birthday").attr({ "type" : "date", "max" : "<%=LocalDate.now().minusYears(Client.MIN_AGE)%>" });
		$("#captCha").attr({ "type" : "text", "size" : 28, "placeholder" : "請輸入下方驗證碼" });
		$("#captChai").attr({ "src" : url });
		$("#updateGetCV").click(refreshCaptcha);
		<%if (request.getMethod().equalsIgnoreCase("POST")) {%>
					formRepopulation();
		<%} else {%>
				getSessionMethod();
		<%}%>
	});
	function showHandler() {
		$("#password").attr("type","text");
	}
	function hideHandler() {
		$("#password").attr("type","password");
	}
	function changePwd() {
		$("#newPwd").prop("disabled", !renewPwd.checked);
	}
	function refreshCaptcha() {
		url = "<%=request.getContextPath()%>/captCha?re=" + Date.now().toString(16);
		$("#captChai").attr("src", url);
	}	
	function formRepopulation() {
		$("#id").val("<%=request.getParameter("id")%>");
		$("#password").val("<%=request.getParameter("password")%>");
		$("#name").val("<%=request.getParameter("name")%>");
		$("#email").val("<%=request.getParameter("email")%>");
		$("#address").val("<%=request.getParameter("address")%>");
		$("#phone").val("<%=request.getParameter("phone")%>");
		$("#birthday").val("<%=request.getParameter("birthday")%>");	
	}
	
	
	<%List<String> errorsList = (List<String>) session.getAttribute("errorsList");%>
	
</script>
</head>
<body>
	<jsp:include page="/subviews/header.jsp">
		<jsp:param value="修改會員" name="subHeader" />
	</jsp:include>
	<%@include file="/subviews/nav.jsp"%>
	<article>
		<form id="updateForm" method="post" action="<%=request.getContextPath()%>/update.do">
			<p class="errorsList"><%=errorsList != null ? errorsList : ""%></p>
			<p>
				<label for="id"> 帳&emsp;&emsp;號：</label><input name="id" id="id" readonly />
			</p>
			<p>
				<label for="password">密&emsp;&emsp;碼：</label><input name="password" id="password" required><img id="eye" />
			</p>
			<br />
			<fieldset>
				<input id="renewPwd" name="renewPwd" />更改密碼<br /><label for="newPwd">新&ensp;密&ensp;碼：</label><input id="newPwd"
					name="newPwd" required disabled />
			</fieldset>
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
					<option id="defG" selected disabled>請選擇--</option>
					<option id="male" value='M'>Male</option>
					<option id="female" value='F'>Female</option>
					<option id="other" value='O'>Other</option>
				</select>
			</p>
			<p>
				<label for="birthday"> 生&emsp;&emsp;日：</label><input name="birthday" id="birthday" required>
			</p>
			<p>
				<label for="captCha"> 驗&ensp;證&ensp;碼：</label><input name="captCha" id="captCha" required /><br /><img id="captChai"
					alt="驗證碼圖片">
			</p>
			<div id="updateUS">
				<button id="updateGetCV">更新驗證碼</button>
				<button type="submit" id="updateSubmit">修改會員</button>
			</div>
		</form>
	</article>
	<%@include file="/subviews/footer.jsp"%>
</body>
<script>
	function getSessionMethod() {
		<%if (member != null) {%>
				$("#id").val("<%=member.getId()%>");
				<%if (member instanceof VIP) {%>
						$("#vipLabel").text("享有VIP<%=((VIP) member).getDiscountString()%>");
				<%}%>
				$("#name").val("<%=member.getName()%>");
				$("#email").val("<%=member.getEmail()%>");
				$("#address").val("<%=member.getAddress()%>");
				$("#phone").val("<%=member.getPhone()%>");
				$("#birthday").val("<%=member.getBirthday()%>");
		<%} else {%>
				//alert("請先登入會員");
		<%}%>
	}
</script>
</html>