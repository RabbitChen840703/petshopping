<%@page import="uuu.petshopping.Entity.SpecialOffer"%>
<%@page import="uuu.petshopping.Service.ProductsService"%>
<%@page import="uuu.petshopping.Entity.Product"%>
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
<title>毛 孩 糧 倉-產品明細v1</title>
<script type="text/javascript"></script>
</head>
<body>
	<jsp:include page="/subviews/header.jsp">
		<jsp:param value="產品明細v1" name="subHeader" />
	</jsp:include>
	<%@include file="/subviews/nav.jsp"%>
	<article>
		<% String productId = request.getParameter("productId");
				ProductsService pService = new ProductsService();
				Product product = null;
				if(productId != null && (productId.trim()).length()>0){
					product = pService.getProductById(productId);
				} 
				if ( product == null) { %>
					<h3>查無產品資訊</h3>
		<% } else { %>
				<div class="prdocutRegion">
					<img class="productPhoto" src="<%=product.getPhotoUrl()%>"/>
					<div class="productData">
						<h3><%=product.getName() %></h3><br/>
						<div>上架日期：<%=product.getReleaseDate() %></div>
						<div>原產地：<%=product.getPlaceOfProduct() %></div>
						<% if (product instanceof SpecialOffer) { %>
							<div>定價：<span class="listPrice"><%=((SpecialOffer)product).getListPrice() %></span>元</div>
						<% } %>
						<div>優惠價：<span class="discount"><%= product instanceof SpecialOffer ? ((SpecialOffer)product).getDiscountString() : ""%></span>
							<span class="unitPrice"><%=product.getUnitPrice() %></span>元</div>
						<div>庫存：<span><%=product.getStock() %></span>件</div>	
						<form id="cartForm">
							<input type="hidden" name="productId" value="<%=product.getId() %>">
							<p>
								<label for="quantity">數量：</label>
								<input type="number" name="quantity" min="1" max="<%=product.getStock()%>"/>
								<input type="submit" value="加入購物車"/>
							</p>
						</form>
					</div>
				</div>
				<div>
					<hr/>
					<p class="productDesc"><%=product.getDescription() %></p>
				</div>			
		<% } %>
	</article>
	<%@include file="/subviews/footer.jsp"%>
</body>
</html>