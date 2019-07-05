<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
 <head lang="en">
        <meta charset="UTF-8">
        <title></title>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
 		<script type="text/javascript">
 			$(function(){
 			});
 		</script>
 		<style type="text/css">
 			td{
 				margin-top:100px;
 			}
 			.mandatory{
 				color:red;
 			}
 		</style>
  </head>
    <body>
        <div class="container main hide">
        	<div class="row" >
	      		<ol class="breadcrumb"></ol>
	       		<div  style="width:100%;text-align:center;">
	       			<div class="col-row-12 new-title">高考志愿信息填写</div>
	       			<div style="line-height:48px;">
	       				带 <span class="mandatory">*</span> 为必填项
	       			</div>
	       			<form action="cart" method="post">
	       			<input name="method" value="saveInfo" type="hidden">
	       			<table style="margin-left:200px;">
	       				<tr>
	       					<td class="table-key"><span class="mandatory">*</span>姓名：</td>
	       					<td class="table-val"><input type="text" name="name" maxlength="18" placeholder="姓名" /></td>
	       					<td class="table-key"><span class="mandatory">*</span>性别：</td> 
	       					<td class="table-val" colspan="4">
	       						<label class="label"><input type="radio" class="sex" value="false" name="sex" checked="checked" /><span class="label-text float-left">男</span></label>
	       						<label class="label"><input type="radio" class="sex" value="true" name="sex" /><span class="label-text float-left">女</span></label>
	       					</td>
	       					<td></td>
	       				</tr>
	       				<tr>
	       					<td class="table-key"><span class="mandatory">*</span>身份证号：</td>
	       					<td class="table-val"><input type="text" name="idcard" maxlength="18" placeholder="身份证号" value="41."/></td>
	       					<td class="table-key"><span class="mandatory">*</span>出生年月：</td>
	       					<td class="table-val"><input type="text" name="birthday" placeholder="出生年月" value="2018-02-01"/></td>
	       					<td class="table-key">社保卡号：</td>
	       					<td class="table-val">
	       					<input type="text" name="sbcard" maxlength="18" placeholder="社保卡号 (非必填项)" value="41."/></td>
	       				</tr>
	       				<tr>
	       					<td class="table-key"><span class="mandatory">*</span>家庭状况：</td>
	       					<td class="table-val marriageList" colspan="2">
	       						<label class="label"><input type="radio" class="sex" value="完整" name="home" checked="checked" /><span class="label-text float-left">完整</span></label>
	       						<label class="label"><input type="radio" class="sex" value="离异" name="home" /><span class="label-text float-left">离异</span></label>
	       					</td>
	       					<td class="table-key"><span class="mandatory">*</span>身体状况：</td>
	       					<td class="table-val politicsList" colspan="2">
	       					<input type="text" name="st" placeholder="健康" value="健康">
	       					</td>
	       				</tr>
	       				<tr>
	       					<td class="table-key"><span class="mandatory">*</span>政治面貌：</td>
	       					<td class="table-val politicsList" colspan="2">
	       						<select name="zzmm">
	       						<option value=0>无党派民主人士</option>
	       						<option value=1>中共党员</option>
	       						<option value=2>共青团员</option>
	       						<option value=3>民革党员</option>
	       						<option value=4>民盟盟员</option>
	       						<option value=5>农工党党员</option>
	       						<option value=6>群众</option>
	       						</select>
	       					</td>
	       					<td class="table-key"><span class="mandatory">*</span>民族：</td>
	       					<td class="table-val nationalList" colspan="4">
	       						<select name="mz">
	       						<option value=0>汉族</option>
	       						<option value=1>藏族</option>
	       						<option value=2>彝族</option>
	       						<option value=3>回族</option>
	       						<option value=4>维族</option>
	       						<option value=5>苗族</option>
	       						<option value=6>其他</option>
	       						</select>
	       					</td>
	       				</tr>
	       			</table>
	       			
	       			<table style="margin-left:200px;">
	       				<tr>
	       					<td class="table-key text-register"><span class="mandatory">*</span>户籍地址：</td>
	       					<td class="table-val" colspan="4">
	       						<select name="province1">
	       							<option>北京市</option>
									<option>天津市</option>
									<option>河北省</option>
									<option>山西</option>
									<option>内蒙古自治区</option>
									<option>辽宁省</option>
									<option>吉林省</option>
									<option>黑龙江省</option>
									<option>上海市</option>
									<option>江苏省</option>
									<option>浙江省</option>
									<option>安徽省</option>
									<option>福建省</option>
									<option>江西省</option>
									<option>山东省</option>
									<option>河南省</option>
									<option>湖北省</option>
									<option>湖南省</option>
									<option>广东省</option>
									<option>广西壮族自治区</option>
									<option>海南省</option>
									<option>重庆市</option>
									<option>四川省</option>
									<option>贵州省</option>
									<option>云南省</option>
									<option>西藏自治区</option>
									<option>陕西省</option>
									<option>甘肃省</option>
									<option>青海省</option>
									<option>宁夏回族自治区</option>
									<option>新疆维吾尔自治区</option>
									<option>台湾</option>
									<option>香港特别行政区</option>
									<option>澳门特别行政区</option>
	       						</select>
	       						</td>
	       						<td colspan="3">
	       						<input type="text" name="address1" maxlength="64" value="详细地址" />
	       					</td>
	       				</tr>
	       				<tr>
	       					<td class="table-key text-current"><span class="mandatory">*</span>现居住地址：</td>
							<td class="table-val" colspan="4">
	       						<select name="province2">
	       							<option>北京市</option>
									<option>天津市</option>
									<option>河北省</option>
									<option>山西</option>
									<option>内蒙古自治区</option>
									<option>辽宁省</option>
									<option>吉林省</option>
									<option>黑龙江省</option>
									<option>上海市</option>
									<option>江苏省</option>
									<option>浙江省</option>
									<option>安徽省</option>
									<option>福建省</option>
									<option>江西省</option>
									<option>山东省</option>
									<option>河南省</option>
									<option>湖北省</option>
									<option>湖南省</option>
									<option>广东省</option>
									<option>广西壮族自治区</option>
									<option>海南省</option>
									<option>重庆市</option>
									<option>四川省</option>
									<option>贵州省</option>
									<option>云南省</option>
									<option>西藏自治区</option>
									<option>陕西省</option>
									<option>甘肃省</option>
									<option>青海省</option>
									<option>宁夏回族自治区</option>
									<option>新疆维吾尔自治区</option>
									<option>台湾</option>
									<option>香港特别行政区</option>
									<option>澳门特别行政区</option>
	       						</select>
	       						</td>
	       						<td colspan="3">
	       						<input type="text" name="address2" maxlength="64" value="详细地址" />
	       					</td>
	       				</tr>
	       			</table>
	       			
	       			<table style="margin-left:200px;">
	       				<tr>
	       					<td class="table-key"><span class="mandatory">*</span>手机号码：</td>
	       					<td class="table-val" colspan="1"><input type="text" name="phone" maxlength="11" placeholder="手机号码" value="158."/></td>
	       					<td class="table-key"><span class="mandatory">*</span>其他联系方式：</td>
	       					<td class="table-val" colspan="4"><input type="text" name="otherphone" maxlength="128" value="其他联系方式" /></td>
	       				</tr>
	       				<tr>
	       					<td class="table-key">毕业高中：</td>
	       					<td class="table-val" colspan="1"><input type="text" name="school" value="毕业院校 (非必填项)" /></td>
	       					<td class="table-key">理科/文科：</td>
	       					<td class="table-val" colspan="4">
	       					   <label class="label"><input type="radio"  value="理科" name="worl" checked="checked" /><span class="label-text float-left">完整</span></label>
	       						<label class="label"><input type="radio"  value="文科" name="worl" /><span class="label-text float-left">离异</span></label>
	       					</td>
	       				</tr> 
	       				<tr>
	       					<td class="table-key">毕业时间：</td>
	       					<td class="table-val" colspan="1"><input type="text" name="graduationtime" value="毕业时间 (必填项)" /></td>
	       					<td class="table-key">上学年数：</td>
	       					<td class="table-val" colspan="2"><input type="text" name="schooling" maxlength="128" value="学历 (必填项)" /></td>
	       					<td class="table-key">获得成就：</td>
	       					<td class="table-val" colspan="2"><input type="text" name="degree" maxlength="128" value="学位 (必填项)" /></td>
	       				</tr>
	       				<tr>
	       					<td class="table-key">备注：</td>
	       					<td class="table-val" colspan="7">
	       					<textarea name="bz" style="width:100%;height:50px;">
	       					other
	       					</textarea>
	       					</td>
	       				</tr>
	       			</table>
	       			<table style="margin-left:200px;">
						<tbody>
							<tr class="warning">
								<th>校徽</th>
								<th>校名</th>
								<th>平均分数线</th>
								<th>去年分数线</th>
							</tr>
							<c:forEach items="${lists}" var="ci">
								<tr class="active">
									<td width="60" width="40%">
										<input type="hidden" name="id" value="22">
										<img src="${pageContext.request.contextPath}/${ci.pimage}" width="70" height="60">
									</td>
									<td width="20%">
										<a target="_blank"> ${ci.pname}</a>
									</td>
									<td width="20%">
										${ci.now_line}
									</td>
									<td width="15%">
										<span class="subtotal">${ci.market_line }</span>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
	       			<input type="submit" value="提交" style="background: url('${pageContext.request.contextPath}/images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);height:35px;width:100px;color:white;">
	       			</form>
	       			<a href="${pageContext.request.contextPath }/jsp/cart.jsp">
	       			<button style="background: url('${pageContext.request.contextPath}/images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);height:35px;width:100px;color:white;">返回</button>
	       			</a>
	       			<div style="margin-top:50px;padding:10px; background:#fafafa; border:1px solid #ccc;"> 
	       				1.第一步要干嘛，不是别的，是确定你的分数在省内的排名.<br />
	       				2.拿起手中的志愿书，寻找你想填报的学校、专业代码。
	       			</div>
	       		</div>
        	</div>
       	</div>
    </body>
</html>