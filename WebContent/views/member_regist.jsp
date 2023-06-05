<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../header.html"%>
<title>会員情報登録</title>
<link href="/MemberInformation/css/member_regist.css" rel="stylesheet">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- メッセージ -->
<c:if test="${errormsg != null }">
<p 

>${errormsg}</p>
</c:if>
<c:remove var="errormsg" />
<container>
<div>
	<h2>会員情報登録</h2>
	<form action="/MemberInformation/jp.co.aforce.member_settings/Settings"
		method="post">
		<div class="input_area">
			<div class="colum clearfix">
				<p>■名前</p>
				<p class="float_l ml_15">
					姓<input type="text" name="last_name" required>
				</p>
				<p class="float_l ml_15">
					名<input type="text" name="first_name" required>
				</p>
			</div>
			<div class="colum clearfix">
				<p>■性別</p>
				<p class="float_l ml_15">
					<input type="radio" name="sex" value="1" checked>男
				</p>
				<p class="float_l ml_15">
					<input type="radio" name="sex" value="2">女
				</p>
			</div>
			<div class="colum clearfix">
				<p>■生年月日</p>
				<p class="float_l ml_15">
					<select name="birth_year" required>
						<option value=""></option>
						<%for (int i = 1990; i <= 2020; i++) {%>
						<option value="<%=i%>"><%=i%></option>
						<%}%>
					</select>年
				</p>
				<p class="float_l">
					<select name="birth_month" required>
						<option value=""></option>
						<%for (int i = 1; i <= 12; i++) {%>
						<option value="<%=i%>"><%=i%></option>
						<%}%>
					</select>月
				</p>
				<p class="float_l">
					<select name="birth_day" required>
						<option value=""></option>
						<%for (int i = 1; i <= 31; i++) {%>
						<option value="<%=i%>"><%=i%></option>
						<%}%>
					</select>日
				</p>
			</div>
			<div class="colum clearfix">
				<p>■電話番号</p>
				<p class="ml_15">
					<input type="tel" name="phone_number" style="width: 200px;"
						maxlength="15" required pattern="[\d\-]*">
				</p>
			</div>
			<div class="colum">
				<p>■メールアドレス</p>
				<p class="ml_15">
					<input type="email" name="mail_address" style="width: 200px;"
						maxlength="50" required>
				</p>
			</div>

			<div class="colum clearfix">
				<p>■職業</p>
				<p class="ml_15">
					<select name="job" style="width: 200px;" required>
						<option value="100">会社員</option>
						<option value="200">自営業</option>
						<option value="300">学生</option>
						<option value="400">その他</option>
					</select>
				</p>
			</div>
		</div>
		<input type="hidden" id="post_type" name="post_type" value="Regist" />
</div>
<div class="button_area clearfix">
	<div class="button_area_center">
		<p class="float_l">
			<input type="submit" name="regist" value="登録">
		</p>
		<p class="float_l">
			<input type="reset" name="reset" value="リセット">
		</p>
		<p class="float_l">
			<input type="button" name="back"
				onclick="location.href='/MemberInformation/views/settings.jsp'"
				value="戻る">
		</p>
	</div>
</div>
</form>
</div>
</container>
<%@include file="../footer.html"%>