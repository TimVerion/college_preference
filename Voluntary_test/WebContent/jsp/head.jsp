<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--描述：菜单栏 -->
			<div class="container-fluid">
				<div class="col-md-4">
					<img src="${pageContext.request.contextPath}/img/logo2.jpg" />
				</div>
				<div class="col-md-5">
				</div>
				<div class="col-md-3" style="padding-top:20px">
					<ol class="list-inline">
						<c:if test="${empty user }">
							<li><a href="${pageContext.request.contextPath }/user?method=loginUI">登录.选志愿</a></li>
							<li><a href="${pageContext.request.contextPath }/user?method=registUI">注册</a></li>
						</c:if>
						
						<c:if test="${not empty user }">
							${user.name }:你好!
							<li><a href="${pageContext.request.contextPath }/user?method=logout">退出</a></li>
						</c:if>
						<li><a href="${pageContext.request.contextPath }/jsp/cart.jsp">高校收藏夹</a></li>
					</ol>
				</div>
			</div>
			<!--
            	时间：2015-12-30
            	描述：导航条
            -->
			<div class="container-fluid">
				<nav class="navbar navbar-inverse">
					<div class="container-fluid">
						<!-- Brand and toggle get grouped for better mobile display -->
						<div class="navbar-header">
							<a class="navbar-brand" href="${pageContext.request.contextPath }">首页</a>
						</div>

						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav" id="c_ul">
							</ul>
							<form class="navbar-form navbar-right" role="search">
								<div class="form-group" id="c_s">
									<input type="text" class="form-control" placeholder="大学名字" id="search_content">
								</div>
								<button type="submit" id="search_submit" class="btn btn-default">搜索</button>
							</form>

						</div>
						<!-- /.navbar-collapse -->
					</div>
					<!-- /.container-fluid -->
				</nav>
			</div>
<script type="text/javascript">
	$(function(){
		//发送ajax 查询所有分类
		$.post("${pageContext.request.contextPath}/category",{"method":"findAll"},function(obj){
			//alert(obj);
			//遍历json列表,获取每一个分类,包装成li标签,插入到ul内部
			//$.each($(obj),function(){});
			$(obj).each(function(){
				//alert(this.cname);
				$("#c_ul").append("<li><a href='${pageContext.request.contextPath}/college?method=findByPage&pageNumber=1&cid="+this.cid+"'>"+this.cname+"</a></li>");
			});
		},"json");
	});
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
