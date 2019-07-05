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
		</style>
	</head>

	<body>
	
		<%@include file="/jsp/head.jsp"%>


		<div class="container">
			<div class="row">
				
				<div style="margin:0 auto;width:950px;">
					<div class="col-md-6">
						<img style="opacity: 1;width:400px;height:350px;" title="" class="medium" src="${pageContext.request.contextPath}/${bean.pimage}">
					</div>

					<div class="col-md-6">
						<div><strong>${bean.pname }</strong></div>
						<div style="border-bottom: 1px dotted #dddddd;width:350px;margin:10px 0 10px 0;">
							<div>教育局编号：${bean.pid }</div>
						</div>

						<div style="margin:10px 0 10px 0;">去年分数线: <strong style="color:#ef0101;"> ${bean.now_line }分</strong> 平均分数线：${bean.market_line } <del>分</del>
						</div>

						<div style="margin:10px 0 10px 0;">今年变化: <a target="_blank" title="今年有望 (2014-07-30 ~ 2015-01-01)" style="background-color: #f07373;">校园扩招</a> </div>

						<div style="padding:10px;border:1px solid #e7dbb1;width:330px;margin:15px 0 10px 0;;background-color: #fffee6;">
							<div style="margin:5px 0 10px 0;">第一条 规范招生行为.<br>
							第二条 符合学校学位授予有关规定者，颁发普通高等教育本科毕业生学士学位证书。<br>

第三条 我校是国家公办的教育部直属全日制普通高等学校<br>

第四条 招生工作遵循“公平竞争、公正选拔、公开程序，德智体全面考核、综合评价、择优录取”的原则<br>

第五条 招生工作接受学校纪检监察部门、新闻媒体、考生及其家长以及社会各界的监督。
</div>
							<form action="${pageContext.request.contextPath }/cart" id="form1" method="get">
								<!-- 提交的方法 -->
								<input type="hidden" name="method" value="add2cart">
								
								<!-- 商品的pid -->
								<input type="hidden" name="pid" value="${bean.pid }">
								
								<div style="border-bottom: 1px solid #faeac7;margin-top:20px;padding-left: 10px;">我的总分数:
									<input id="quantity" name="count" maxlength="4" size="10" type="text" required="required"> </div>
	
							</form>
								<a href="javascript:void(0)" onclick="subForm()">
									<input style="background:orange; height:36px;width:127px;" value="加入高校收藏夹" type="button">
								</a> &nbsp;先收藏再说</div>
						</div>
					</div>
				</div>
				<div class="clear"></div>
				<div style="width:950px;margin:0 auto;">
					<div style="background-color:#d3d3d3;width:930px;padding:10px 10px;margin:10px 0 10px 0;">
						<strong>大学介绍</strong>
					</div>

					<div>
						<img src="${pageContext.request.contextPath}/${bean.pimage}">
					</div>

					<div style="background-color:#d3d3d3;width:930px;padding:10px 10px;margin:10px 0 10px 0;">
						<strong>${bean.pdesc }</strong>
					</div>
					

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

	</body>
	<script type="text/javascript">
	function subForm(){
		//让指定的表单提交
		var num = $("#quantity").val();
		if(num ==''){
		alert("分数不能为空！！！")
		}else{
		document.getElementById("form1").submit();
		}
	}
	</script>
</html>