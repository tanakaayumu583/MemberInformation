package jp.co.aforce.member_settings;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.MemberInformationBean;
import jp.co.aforce.dao.Member_informationDAO;
import jp.co.aforce.message.Message;

@WebServlet("/jp.co.aforce.member_settings/Search")
public class Search extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String url = "/MemberInformation/views/member_update.jsp";

		try {
			Member_informationDAO dao = new Member_informationDAO();
			MemberInformationBean p = (MemberInformationBean) request.getAttribute("データ");

			//配列宣言			
			List<MemberInformationBean> list = new ArrayList<>();
			//検索
			list = dao.search(p.getMember_id());
			
			//検索結果を持ってlist1.jspにフォワード
			HttpSession session=request.getSession();
			session.setAttribute("search_member_info", list);
			String my_url =  (String) request.getAttribute("my_url");


			if (list.size() ==1) {
				url = "/MemberInformation/views/member_"+my_url+".jsp?status=search_success&member_id="+p.getMember_id();
			}else {
				session.setAttribute("errormsg", Message.W_WMM0001);
				url = "/MemberInformation/views/member_"+my_url+".jsp?status=search_error&member_id="+p.getMember_id();
			}
			response.sendRedirect(url);

		} catch (Exception e) {}
	}
}
