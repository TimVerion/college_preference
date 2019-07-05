<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>高考志愿模拟</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
		<!-- 引入自定义css文件 style.css -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" />

		<style>
			body {
				margin-top: 20px;
				margin: 0 auto;
				width: 100%;
			}
			.carousel-inner .item img {
				width: 100%;
				height: 300px;
			}
		</style>
	</head>

	<body>
		
		<%@include file="/jsp/head.jsp" %>
			


		<div class="row" style="width:1210px;margin:0 auto;">
			
			<c:forEach items="${pb.data }" var="p">
				<div class="col-md-4">
					<a href="${pageContext.request.contextPath }/college?method=getById&pid=${p.pid}">
						<img src="${pageContext.request.contextPath}/${p.pimage}" width="170" height="170" style="display: inline-block;">
					</a>
					<p><a href="${pageContext.request.contextPath }/college?method=getById&pid=${p.pid}" style='color:green'>${fn:substring(p.pname,0,10) }..</a></p>
					<p style="overflow: hidden;text-overflow: ellipsis;white-space: nowrap;"><font color="#000">概要：${p.pdesc }</font></p>
					<p><font color="#FF0000">去年分数线：${p.now_line }</font></p>
					<p><font color="#FF0000">平均分数线：${p.market_line }</font></p>
				</div>
			</c:forEach>

			
		</div>

		<!--分页 -->
		<div style="width:380px;margin:0 auto;margin-top:50px;">
			<ul class="pagination" style="text-align:center; margin-top:10px;">
			
				<!-- 判断是否是第一页 -->
				<c:if test="${pb.pageNumber == 1 }">
					<li class="disabled">
						<a href="javascript:void(0)" aria-label="Previous">
							<span aria-hidden="true">&laquo;</span>
						</a>
					</li>
				</c:if>
				
				<!-- 不是第一页 -->
				<c:if test="${pb.pageNumber != 1 }">
					<li>
						<a href="${pageContext.request.contextPath }/college?method=findByPage&pageNumber=${pb.pageNumber-1}&cid=${param.cid}&pname=${pname}" aria-label="Previous">
							<span aria-hidden="true">&laquo;</span>
						</a>
					</li>
				</c:if>
				
				<!-- 展示所有页码 -->
				<c:forEach begin="1" end="${pb.totalPage }" var = "n">
					<!--判断是否是当前页  -->
					<c:if test="${pb.pageNumber == n}">
						<li class="active"><a href="javascript:void(0)">${n }</a></li>
					</c:if>
					<c:if test="${pb.pageNumber != n}">
						<li><a href="${pageContext.request.contextPath }/college?method=findByPage&cid=${param.cid}&pageNumber=${n}&pname=${pname}">${n }</a></li>
					</c:if>
				</c:forEach>
			
				<!-- 判断是否是最后一页 -->
				<c:if test="${pb.pageNumber== pb.totalPage }">
					<li class="disabled">
						<a href="javascript:void(0)" aria-label="Next">
							<span aria-hidden="true">&raquo;</span>
						</a>
					</li>
				</c:if>
				<c:if test="${pb.pageNumber != pb.totalPage }">
					<li>
						<a href="${pageContext.request.contextPath }/college?method=findByPage&cid=${param.cid}&pageNumber=${pb.pageNumber+1}&pname=${pname}" aria-label="Next">
							<span aria-hidden="true">&raquo;</span>
						</a>
					</li>
				</c:if>
			</ul>
		</div>
		<!--
            	描述：页脚部分
            -->
			<div class="container-fluid" style="background:#4fabf8">
				<div style="margin-top:50px;">
					<img src="${pageContext.request.contextPath}/img/footer.jpg" width="100%" height="78" alt="我们的优势" title="我们的优势" />
				</div>
		
				<div style="text-align: center;margin-top: 5px;">
					<ul class="list-inline">
						<li><a href="info.html">关于我们</a></li>
						<li><a>漏洞提交</a></li>
						<li><a>招贤纳士</a></li>
						<li><a>版权声明</a></li>
						<li><a>友情链接</a></li>
						<li><a>学信十周年</a></li>
						<li><a>证书查询</a></li>
						<li><a>服务声明</a></li>
						<li><a>广告声明</a></li>
					</ul>
				</div>
				<div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
					Copyright &copy; 2019 高考志愿模拟 版权所有
				</div>
			</div>
		</div>
	<script type="text/javascript">
		$(function(){
			//将url进行切割，并找到需要的属性值
			function getparameter(name){
				var reg = new RegExp("(^|&)"+name+"=([^&]*)(&|$)","i");
				var r = location.search.substr(1).match(reg);
				if (r!=null){
					return (r[2]);
				}
				return null;
			}
			var pname =getparameter("pname");
			 if (pname){
				 //解决关键字乱码
				 pname = window.decodeURIComponent(pname);
				 //alert(pname)
			 }
		});
	</script>
	</body>

</html>