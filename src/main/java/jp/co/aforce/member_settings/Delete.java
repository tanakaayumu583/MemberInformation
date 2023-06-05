package jp.co.aforce.member_settings;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.MemberInformationBean;
import jp.co.aforce.dao.Member_informationDAO;
import jp.co.aforce.message.Message;

@WebServlet("/jp.co.aforce.member_settings/Delete")
public class Delete extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String url = "/MemberInformation/views/member_delete.jsp";
		
		
		
		

		try {
			request.getAttribute("データ");
			Member_informationDAO dao = new Member_informationDAO();
			MemberInformationBean p = (MemberInformationBean) request.getAttribute("データ");
			
			HttpSession session = request.getSession();
			//会員情報削除
			int line = dao.delete(p.getMember_id());
			if (line == 1) {
				session.setAttribute("errormsg", Message.I_WMM0003);
				url = "/MemberInformation/views/member_delete.jsp?status=success";

			} else {
				session.setAttribute("errormsg", Message.E_WMM0004);
				url = "/MemberInformation/views/member_delete.jsp?status=error";
			}
			response.sendRedirect(url);

		} catch (Exception e) {

		}
	}
}
