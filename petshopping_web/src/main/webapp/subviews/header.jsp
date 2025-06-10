<%@ page pageEncoding="UTF-8"%>
<!-- header.jsp start -->
<header>
	<br> <br>
	<h1 class="headerTitle">
		<a id="toIndex" href="<%=request.getContextPath()%>">毛孩糧倉</a>
		<sub class="subTitle"><%=request.getParameter("subHeader") == null ? "首頁" : request.getParameter("subHeader")%></sub>
	</h1>
	<form id="searchForm" method="get" action="<%=request.getContextPath()%>/products_list.jsp">
		<input type="search" name="keyword" placeholder="請輸入關鍵字"
			value="<%=request.getParameter("keyword") == null ? "" : request.getParameter("keyword")%>" /><input type="submit" value="搜尋" />
	</form>
</header>
<!-- header.jsp end -->