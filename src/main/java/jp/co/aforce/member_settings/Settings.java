package jp.co.aforce.member_settings;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.bean.MemberInformationBean;
import jp.co.aforce.tool.Page;

@WebServlet("/jp.co.aforce.member_settings/Settings")
public class Settings extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();
		Page.header(out);

		//post元の判定
		String post_type = request.getParameter("post_type");
		//post項目名の定義
		List<String> list = new ArrayList<String>(Arrays.asList(
				"member_id", "last_name", "first_name",
				"sex", "birth_year", "birth_month",
				"birth_day", "job", "phone_number",
				"mail_address"));

	try {
			//beanにpostデータを格納
			MemberInformationBean pd = new MemberInformationBean();
			for (int i = 0; i < list.size(); i++) {
				if(request.getParameter(list.get(i))==null) {
					continue;
				}
				pd.setData(list.get(i), request.getParameter(list.get(i)));
			}
			request.setAttribute("データ", pd);
			request.setAttribute("my_url", request.getParameter("my_url"));

			//フォワード処理
			RequestDispatcher rd = this.getServletContext()
					.getRequestDispatcher("/jp.co.aforce.member_settings/" + post_type);
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}

