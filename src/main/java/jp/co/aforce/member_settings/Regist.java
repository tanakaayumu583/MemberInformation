package jp.co.aforce.member_settings;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.MemberInformationBean;
import jp.co.aforce.dao.Member_informationDAO;
import jp.co.aforce.message.Message;

@WebServlet("/jp.co.aforce.member_settings/Regist")
public class Regist extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String url = "/MemberInformation/views/member_regist.jsp";


		try {
			request.getAttribute("データ");
			Member_informationDAO dao = new Member_informationDAO();
			MemberInformationBean p = (MemberInformationBean) request.getAttribute("データ");
			HttpSession session=request.getSession();
			//存在チェック
			int line = dao.exit_check(p);
			if (line == 0) {
				//会員情報登録
				//1.member_idの付与
		        LocalDateTime now = LocalDateTime.now();
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmmss");
		        String formattedDate = now.format(formatter);
		        String new_member_id = "A" + formattedDate;
		        p.setData("member_id", new_member_id);
				//2.データベースへの登録
				int line_insert = dao.insert(p);
				if(line_insert == 1) {
			        //3.登録画面にリダイレクト I-WMM0001の成功メッセージ
					session.setAttribute("errormsg", Message.I_WMM0001);
			        url = "/MemberInformation/views/member_regist.jsp?status=success";
				}else {
					//エラーメッセージ"E-WMM0002"の設定
					session.setAttribute("errormsg", Message.E_WMM0002);
			        url = "/MemberInformation/views/member_regist.jsp?status=fail";
				}
			} else if (line >= 1) {
				//エラーメッセージ"E-WMM0001"の設定
				session.setAttribute("errormsg", Message.E_WMM0001);
		        url = "/MemberInformation/views/member_regist.jsp?status=fail";
			} else {
				//その他エラー
				session.setAttribute("errormsg", Message.W_WMM9999);
		        url = "/MemberInformation/views/member_regist.jsp?status=error";
			}
			response.sendRedirect(url);

		} catch (Exception e) {
			
		}
	}
}
