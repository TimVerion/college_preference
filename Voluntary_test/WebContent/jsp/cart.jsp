<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>高考模拟</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
		<!-- 引入自定义css文件 style.css -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" />
		<style>
			body {
				margin-top: 20px;
				margin: 0 auto;
			}
			
			.carousel-inner .item img {
				width: 100%;
				height: 300px;
			}
			
			
			font {
				color: #3164af;
				font-size: 18px;
				font-weight: normal;
				padding: 0 10px;
			}
		</style>
	</head>

	<body>
	
		
		<%@include file="/jsp/head.jsp" %>

		<div class="container">
			<div class="row">
				<c:if test="${empty cart || empty cart.cartItems }">
					<h3>您还没有心仪的学校，快去添加吧！！！</h3>
				</c:if>
				<c:if test="${not empty cart.cartItems}">
				<div style="margin:0 auto; margin-top:10px;width:950px;">
					<table class="table table-bordered">
						<tbody>
							<tr class="warning">
								<th>校徽</th>
								<th>校名</th>
								<th>平均分数线</th>
								<th>去年分数线</th>
								<th>我的预估分数</th>
								<th>操作</th>
							</tr>
							<c:forEach items="${cart.cartItems }" var="ci">
								<tr class="active">
									<td width="60" width="40%">
										<input type="hidden" name="id" value="22">
										<img src="${pageContext.request.contextPath}/${ci.college.pimage}" width="70" height="60">
									</td>
									<td width="20%">
										<a target="_blank"> ${ci.college.pname}</a>
									</td>
									<td width="20%">
										${ci.college.now_line}
									</td>
									<td width="15%">
										<span class="subtotal">${ci.college.market_line }</span>
									</td>
									<td width="20%">
										<input type="text" readonly="readonly" name="quantity" value="${ci.count }" maxlength="4" size="10">
									</td>
									<td>
										<a href="javascript:void(0);" onclick="removeFromCart('${ci.college.pid}')" class="delete">删除</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>

			<div style="margin-right:130px;">
				<div style="text-align:right;">
					电脑预测: <strong style="color:#ff6600;">${cart.total }</strong>
				</div>
				<div style="text-align:right;margin-top:10px;margin-bottom:10px;">
					<a href="${pageContext.request.contextPath }/cart?method=clear" id="clear" class="clear">清空购物车</a>
					<a href="${pageContext.request.contextPath }/cart?method=tozj">
						<input type="button" width="100" value="专家预测" name="submit" border="0" style="background: url('${pageContext.request.contextPath}/images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
						height:35px;width:100px;color:white;">
					</a>
				</div>
			</div>
			</c:if>
		</div>
	
	</body>
	<script type="text/javascript">
	function removeFromCart(pid){
		if(confirm("您忍心抛弃我吗？")){
			location.href="${pageContext.request.contextPath}/cart?method=remove&pid="+pid;
			
		}
	}
	</script>

</html>