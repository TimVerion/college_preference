<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>高考志愿模拟</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
	</head>

	<body>
		<div class="container-fluid" >

			<%@include file="/jsp/head.jsp" %>
		
			<div class="container-fluid">
				<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
						<li data-target="#carousel-example-generic" data-slide-to="1"></li>
						<li data-target="#carousel-example-generic" data-slide-to="2"></li>
						<li data-target="#carousel-example-generic" data-slide-to="3"></li>
					</ol>

					<!-- Wrapper for slides -->
					<div class="carousel-inner" role="listbox">
						<div class="item active">
							<img src="${pageContext.request.contextPath}/img/lun0.png">
							<div class="carousel-caption">

							</div>
						</div>
						<div class="item">
							<img src="${pageContext.request.contextPath}/img/lun1.png">
							<div class="carousel-caption">

							</div>
						</div>
						<div class="item">
							<img src="${pageContext.request.contextPath}/img/lun2.png">
							<div class="carousel-caption">

							</div>
						</div>
						<div class="item">
							<img src="${pageContext.request.contextPath}/img/lun3.png">
							<div class="carousel-caption">

							</div>
						</div>
					</div>

					<!-- Controls -->
					<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
						<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a>
					<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
						<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
			</div>
			<!--
            	作者：ci2713@163.com
            	时间：2015-12-30
            	描述：商品显示
            -->
			<div class="container-fluid">
				<div class="col-md-12">
					<h2>热门专业&nbsp;&nbsp;</h2>
				</div>
				<div class="col-md-2" style="border:1px solid #E7E7E7;border-right:0;padding:0;">
					<img src="${pageContext.request.contextPath}/products/hao/big01.png" width="205" height="404" style="display: inline-block;"/>
				</div>
				<div class="col-md-10">
					<div class="col-md-6" style="text-align:center;height:200px;padding:0px;">
						<a href="product_info.htm">
							<img src="${pageContext.request.contextPath}/products/hao/mid001.png" width="516px" height="200px" style="display: inline-block;">
						</a>
					</div>
					
					<c:forEach items="${hList }" var="p">
						<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
							<a href="${pageContext.request.contextPath }/college?method=getById&pid=${p.pid}">
								<img src="${pageContext.request.contextPath}/${p.pimage }" width="130" height="130" style="display: inline-block;">
							</a>
							<p><a href="${pageContext.request.contextPath }/college?method=getById&pid=${p.pid}" style='color:#666'>${fn:substring(p.pname,0,10) }..</a></p>
							<p><font color="#E4393C" style="font-size:16px">&yen;${p.now_line }</font></p>
						</div>
					</c:forEach>
	
					
				</div>
			</div>
			<!--
            	描述：商品显示
            -->
			<div class="container-fluid">
				<div class="col-md-12">
					<h2>大学排行&nbsp;&nbsp;</h2>
				</div>
				<div class="col-md-2" style="border:1px solid #E7E7E7;border-right:0;padding:0;">
					<img src="${pageContext.request.contextPath}/products/hao/big01.png" width="205" height="404" style="display: inline-block;"/>
				</div>
				<div class="col-md-10">
					<div class="col-md-6" style="text-align:center;height:200px;padding:0px;">
						<a href="product_info.htm">
							<img src="${pageContext.request.contextPath}/products/hao/mid001.png" width="516px" height="200px" style="display: inline-block;">
						</a>
					</div>
					<c:forEach items="${nList }" var="p">
						<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
							<a href="${pageContext.request.contextPath }/college?method=getById&pid=${p.pid}">
								<img src="${pageContext.request.contextPath}/${p.pimage }" width="130" height="130" style="display: inline-block;">
							</a>
							<p><a href="${pageContext.request.contextPath }/college?method=getById&pid=${p.pid}" style='color:#666'>${fn:substring(p.pname,0,10) }..</a></p>
							<p><font color="#E4393C" style="font-size:16px">&yen;${p.now_line }</font></p>
						</div>
					</c:forEach>
				
					
				</div>
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
	</body>
	<script type="text/javascript">
	//给搜索框增加业务方法
	$('#search_submit').click(function(){
		//得到搜索内容的值
		var pname = $('#search_content').val();
		//然后跳转到${pageContext.request.contextPath}/college?method=findByPage&pageNumber=1&cid=
		var cid =getparameter('cid');
		location.href="http://localhost/Voluntary_test/college?method=findByPage&pageNumber=1&cid="+cid+"&pname="+pname;
		return false
	});
	//将url进行切割，并找到需要的属性值
	function getparameter(name){
		var reg = new RegExp("(^|&)"+name+"=([^&]*)(&|$)","i");
		var r = location.search.substr(1).match(reg);
		if (r!=null){
			return (r[2]);
		}
		return null;
	}
	</script>
</html>