<%@ page language="java" 
	contentType="text/html; 
	charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商品搜索页面</title>
<link rel="stylesheet" href="../css/header.css" />
<link rel="stylesheet" href="../css/search.css" />
<link rel="stylesheet" href="../css/footer.css" />
<link rel="stylesheet" href="../css/common.css" />
</head>
<!-- 页面顶部-->
<c:import url="header.jsp"></c:import>

<!-- nav主导航-->
<nav id="nav">
<ul>
	<li><a href="index.html" class="acti">首页</a></li>
	<li><a href="index.html#computer">电脑办公</a></li>
	<li><a href="index.html#stationery">办公文具</a></li>
</ul>
</nav>

<body>
	<div id="goods_list_section_wrapper">
		<div id="goods_list_section">
		<h3>全部结果 > 笔记本</h3>
		<ul id="goods_list">
			<c:forEach items="${data}" var="goods">
			<li class="item">
				<div class="image">
					<a href="${pageContext.request.contextPath }/goods/details.do?id=${goods.id }">
						<img src="${pageContext.request.contextPath }${goods.image }"
							alt="${goods.title }" 
							title="${goods.title }" />
					</a>
				</div>
				<div class="title">
					<a href="${pageContext.request.contextPath }/goods/details.do?id=${goods.id }">
						${goods.title }
					</a>
				</div>
				<div class="buy">
					<span class="price">
						<b>￥</b><span class="content">${goods.price}.00</span>
					</span>
					<span class="add_cart">
						<img id="collect"
							src="../images/search/care.png" alt="" />
						<a href="javascript:void(0);" 
							class="add_cart">加入购物车</a>
					</span>
				</div>
			</li>
			</c:forEach>
		</ul>
		
		<div style="clear: both;"></div>
		
		<div class="pages">
			<c:forEach var="page" begin="1" end="${maxPage}">
				<c:if test="${page == currentPage }">
					${page }
				</c:if>
				<c:if test="${page != currentPage }">
					<a
						href="${pageContext.request.contextPath }/goods/list.do?id=${categoryId }&page=${page }">
						${page }</a>
				</c:if>
			</c:forEach>
		</div>
		</div>
	</div>
	<!-- 尾部-->
	<!-- 页面底部-->
	<div class="foot_bj">
		<div id="foot">
			<div class="lf">
				<p class="footer1">
					<img src="../images/footer/logo.png" alt="" class=" footLogo" />
				</p>
				<p class="footer2">
					<img src="../images/footer/footerFont.png" alt="" />
				</p>
			</div>
			<div class="foot_left lf">
				<ul>
					<li><a href="#"><h3>买家帮助</h3></a></li>
					<li><a href="#">新手指南</a></li>
					<li><a href="#">服务保障</a></li>
					<li><a href="#">常见问题</a></li>
				</ul>
				<ul>
					<li><a href="#"><h3>商家帮助</h3></a></li>
					<li><a href="#">商家入驻</a></li>
					<li><a href="#">商家后台</a></li>
				</ul>
				<ul>
					<li><a href="#"><h3>关于我们</h3></a></li>
					<li><a href="#">关于达内</a></li>
					<li><a href="#">联系我们</a></li>
					<li><img src="../images/footer/wechat.png" alt="" /> <img
						src="../images/footer/sinablog.png" alt="" /></li>
				</ul>
			</div>
			<div class="service">
				<p>学子商城客户端</p>
				<img src="../images/footer/ios.png" class="lf"> <img
					src="../images/footer/android.png" alt="" class="lf" />
			</div>
			<div class="download">
				<img src="../images/footer/erweima.png">
			</div>
			<!-- 页面底部-备案号 #footer -->
			<div class="record">&copy;2017 达内集团有限公司 版权所有 京ICP证xxxxxxxxxxx</div>
		</div>
	</div>
	<div class="modal" style="display: none">
		<div class="modal_dialog">
			<div class="modal_header">操作提醒</div>
			<div class="modal_information">
				<img src="../images/model/model_img2.png" alt="" /> <span>将您的宝贝加入购物车？</span>

			</div>
			<div class="yes">
				<span>确定</span>
			</div>
			<div class="no">
				<span>取消</span>
			</div>
		</div>
	</div>
	<script src="../js/jquery-3.1.1.min.js"></script>
	<script src="../js/index1.js"></script>
	<script src="../js/jquery.page.js"></script>
	<script>
		$(".add_cart").click(function() {
			$(".modal").show();
			$(".modal .modal_information span").html("将您的宝贝加入购物车?");
		})
		$(".yes").click(function() {
			$(".modal").hide();
		})
		$('.no').click(function() {
			$('.modal').hide();

		})
	</script>
	
	<script type="text/javascript">
		/**添加到收藏**/
		$("#collect").click(function(e) {
			$(".modal").show();
			$(".modal .modal_information span").html("将您的宝贝加入收藏夹");
		})
		$(".yes").click(function() {
			$(".modal").hide();
			$('#collect').attr("src", "../images/search/care1.png");
		})
	</script>
</body>
</html>