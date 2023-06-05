<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../header.html"%>
<title>会員情報更新</title>
<link href="/MemberInformation/css/member_regist.css" rel="stylesheet">
<link href="/MemberInformation/css/member_update.css" rel="stylesheet">
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%
String searched = "";
String status = "";
boolean display = false;
if (request.getParameter("status") != null) {
	status = request.getParameter("status");
	if ((status.equals("search_success"))) {
		display = true;
	}
} else {
	display = false;
}
if (display == false) {
	session.removeAttribute("search_member_info");
}

List<jp.co.aforce.bean.MemberInformationBean> list = (List<jp.co.aforce.bean.MemberInformationBean>) session
		.getAttribute("search_member_info");
%>
<!-- エラーメッセージ -->
<c:if test="${errormsg != null }">${errormsg}</c:if>
<c:remove var="errormsg"/>
<container>
<div>
	<h2>会員情報更新</h2>
	<div class="search_member_info clearfix">
		<form
			action="/MemberInformation/jp.co.aforce.member_settings/Settings"
			method="post">
			<div class="input_area float_l">
				<div class="colum">
					<p>■会員番号</p>
					<p class="ml_15">
						<input type="text" name="member_id" 
						<%if(request.getParameter("member_id") != null){%>
							value="<%=request.getParameter("member_id") %>"
							<%}%>
						required placeholder="会員番号(半角英数字のみ)" pattern="^[0-9a-zA-Z]+$"
						>
					</p>
				</div>
			</div>
			<input type="hidden" id="my_url" name="my_url" value="update" />
			<input type="hidden" id="post_type" name="post_type" value="Search" />
			<div class="button_area float_r">
				<p>
					<input type="submit" name="search" value="検索">
				</p>
			</div>
		</form>
	</div>
	<%
	if (display == true) {
		for (jp.co.aforce.bean.MemberInformationBean m_i : list) {
			if (m_i.getMember_id() != null) {
	%>
	<div class="member_info clearfix">
		<form
			action="/MemberInformation/jp.co.aforce.member_settings/Settings"
			method="post">
			<div class="input_area">
				<div class="colum clearfix">
					<p>■名前</p>
					<p class="float_l ml_15">
						姓<input type="text" name="last_name"
							value="<%=m_i.getLast_name()%>" required>
					</p>
					<p class="float_l ml_15">
						名<input type="text" name="first_name"
							value="<%=m_i.getFirst_name()%>" required>
					</p>
				</div>
				<div class="colum clearfix">
					<p>■性別</p>
					<p class="float_l ml_15">
						<input type="radio" name="sex" value="1" <%if (m_i.getSex() == 1) {%>
							checked <%}%>>男
					</p>
					<p class="float_l ml_15">
						<input type="radio" name="sex" value="2" <%if (m_i.getSex() == 0) {%>
							checked <%}%>>女
					</p>
				</div>
								<div class="colum clearfix">
					<p>■生年月日</p>
					<p class="float_l ml_15">
						<select name="birth_year" required>
							<option value="item1"></option>
							<%for (int i = 1990; i <= 2020; i++) {%>
							<option value="<%=i%>"
							<%if(i==m_i.getBirth_year()){%>selected<%} %>
							><%=i%></option>
							<%}%>
						</select>年
					</p>
					<p class="float_l">
						<select name="birth_month" required>
							<option value="item1"></option>
							<%for (int i = 1; i <= 12; i++) {%>
							<option value="<%=i%>"
							<%if(i==m_i.getBirth_month()){%>selected<%} %>
							><%=i%></option>
							<%}%>
						</select>月
					</p>
					<p class="float_l">
						<select name="birth_day" required>
							<option value=""></option>
							<%for (int i = 1; i <= 31; i++) {%>
							<option value="<%=i%>"
							<%if(i==m_i.getBirth_day()){%>selected<%} %>
							><%=i%></option>
							<%}%>
						</select>日
					</p>
				</div>
				<div class="colum clearfix">
					<p>■電話番号</p>
					<p class="ml_15">
						<input type="tel" name="phone_number" style="width: 200px;"
							maxlength="15" value="<%=m_i.getPhone_number()%>" required pattern="[\d\-]*">
					</p>
				</div>
				<div class="colum">
					<p>■メールアドレス</p>
					<p class="ml_15">
						<input type="email" name="mail_address" style="width: 200px;"
							maxlength="50" value="<%=m_i.getMail_address()%>" required>
					</p>
				</div>

				<div class="colum clearfix">
					<p>■職業</p>
					<p class="ml_15">
						<select name="job" style="width: 200px;">
							<option value="100" <%if(100==m_i.getJob()){%>selected<%} %>>会社員</option>
							<option value="200" <%if(200==m_i.getJob()){%>selected<%} %>>自営業</option>
							<option value="300" <%if(300==m_i.getJob()){%>selected<%} %>>学生</option>
							<option value="400" <%if(400==m_i.getJob()){%>selected<%} %>>その他</option>
						</select>
					</p>
				</div>

			</div>
			<input type="hidden" id="post_type" name="member_id" value="<%=m_i.getMember_id() %>" />
			<input type="hidden" id="post_type" name="post_type" value="Update" />
	</div>
	<div class="button_area clearfix">
		<div>
			<p class="float_r">
				<input type="button" name="back" onclick="location.href='/MemberInformation/views/settings.jsp'" value="戻る">
			</p>
			<p class="float_r">
				<input type="submit" name="update" value="更新">
			</p>
		</div>
	</div>
	</form>
</div>
<%
}
}
}
%>
<c:remove var="search_member_info" />
<% session.invalidate();%>
</div>
</container>
<%@include file="../footer.html"%>