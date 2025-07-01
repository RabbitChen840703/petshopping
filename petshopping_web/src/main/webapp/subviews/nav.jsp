<%@page import="uuu.petshopping.Entity.Client"%>
<%@ page pageEncoding="UTF-8"%>
<!-- nav.jsp start -->
<nav>
	<a id="toProducts" href="<%=request.getContextPath()%>/products_list.jsp"> 找飯飯 </a>&nbsp;|
	<%Client member = (Client) session.getAttribute("member"); %>
	<% if(member == null) {%>
		<a id="toSignin" href="<%=request.getContextPath()%>/login.jsp"> 登入會員 </a>&nbsp;|
		<a id="toRegister" href="<%=request.getContextPath()%>/register.jsp"> 註冊會員 </a>&nbsp;|
	<% } else {%>
		<a id ="toAlterUser" href="<%=request.getContextPath()%>/member/update.jsp">修改會員</a>&nbsp;|
		<a id="toLogout" href="<%=request.getContextPath() %>/logout.do">登出</a>
	<% } %>
</nav>
<hr />
<!-- nav.jsp end -->