<%@page import="uuu.petshopping.Entity.SpecialOffer"%>
<%@page import="uuu.petshopping.Entity.Product"%>
<%@page import="java.util.List"%>
<%@page import="uuu.petshopping.Service.ProductsService"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" href="<%=request.getContextPath()%>/images/chicken.png">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/petsh.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/JavaScript/jquery.js"></script>
<title>毛 孩 糧 倉-產品清單</title>
<% 
		String keyword = request.getParameter("keyword");
		String category = request.getParameter("category");
		String newest = request.getParameter("newest");
		ProductsService pService = new ProductsService();
		List<Product> pList = null;
		if( keyword != null && (keyword=keyword.trim()).length()>0){
			pList = pService.getProductsByKeyword(keyword);
		}else if( category != null && ( category=category.trim()).length()>0){
			pList = pService.getProductsByCategory(category);
		}else if( newest != null){
			pList = pService.getLatestArrivalProducts();
		}else{
			pList = pService.getAllProducts();
		}	
		%>
</head>
<body>
	<jsp:include page="subviews/header.jsp">
		<jsp:param value="產品清單" name="subHeader" />
	</jsp:include>
	<%@ include file="/subviews/nav.jsp"%>
	<article>
		<div class="navCategory">
			<a href="?category=貓媽幼貓糧食">貓媽幼貓糧食</a>
			<a href="?category=貓主食濕糧">貓主食濕糧</a>
			<a href="?category=奶貓救援">奶貓救援</a>
			<a href="?category=德國邦尼">德國邦尼</a>
			<a href="?newest=">最新到貨</a>
		</div>
		<%if(pList == null || pList.size()==0){ %>
			<h3>查無產品資訊</h3>
		<%} else { %>
			<div class="productsList">	
				<%for(int i=0;i<pList.size();i++){
						Product product = pList.get(i);%>
				<div class="productItem">						
					<img src="<%=product.getPhotoUrl()%>"/>
					<h4><a href="product_detail.jsp?productId=<%=product.getId()%>"><%=product.getName() %></a></h4>
					<div>優惠價:<%= product instanceof SpecialOffer ? ((SpecialOffer)product).getDiscountString() :  "" %>
							<%=product.getUnitPrice() %>元(<%=product.getStock() %>)
					</div>
				</div>	
				<% } %>													
			</div>	
		<%} %>
	</article>
	<%@ include file="/subviews/footer.jsp"%>
</body>
</html>