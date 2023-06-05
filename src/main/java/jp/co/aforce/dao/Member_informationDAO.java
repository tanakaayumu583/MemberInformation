package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.bean.MemberInformationBean;

public class Member_informationDAO extends DAO {

	//会員存在チェック
	public int exit_check(MemberInformationBean product) throws Exception {
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"SELECT COUNT(*) AS DB_ordernumber FROM k_users WHERE last_name = ? AND first_name = ? AND sex = ? AND birth_year = ? AND birth_month = ? "
						+ "AND birth_day = ? AND job = ? AND phone_number = ? AND mail_address = ? ");
		st.setString(1, product.getLast_name());
		st.setString(2, product.getFirst_name());
		st.setInt(3, product.getSex());
		st.setInt(4, product.getBirth_year());
		st.setInt(5, product.getBirth_month());
		st.setInt(6, product.getBirth_day());
		st.setInt(7, product.getJob());
		st.setString(8, product.getPhone_number());
		st.setString(9, product.getMail_address());

		ResultSet rs = st.executeQuery();
		rs.next();
		Integer line = Integer.valueOf((rs.getInt("DB_ordernumber")));
		st.close();
		con.close();

		return line;
	}

	//会員登録処理
	public int insert(MemberInformationBean product) throws Exception {
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"insert into k_users values(?, ? ,?, ? ,?, ? ,?, ? ,?, ?)");
		st.setString(1, product.getMember_id());
		st.setString(2, product.getLast_name());
		st.setString(3, product.getFirst_name());
		st.setInt(4, product.getSex());
		st.setInt(5, product.getBirth_year());
		st.setInt(6, product.getBirth_month());
		st.setInt(7, product.getBirth_day());
		st.setInt(8, product.getJob());
		st.setString(9, product.getPhone_number());
		st.setString(10, product.getMail_address());
		int line = st.executeUpdate();

		st.close();
		con.close();

		return line;
	}

	//検索処理
	public List<MemberInformationBean> search(String member_id) throws Exception {

		List<MemberInformationBean> list = new ArrayList<>();

		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"select * from k_users where member_id = ?");
		st.setString(1, member_id);
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			MemberInformationBean p = new MemberInformationBean();

			p.setMember_id(rs.getString("member_id"));
			p.setLast_name(rs.getString("last_name"));
			p.setFirst_name(rs.getString("first_name"));
			p.setSex(rs.getInt("sex"));
			p.setBirth_year(rs.getInt("birth_year"));
			p.setBirth_month(rs.getInt("birth_month"));
			p.setBirth_day(rs.getInt("birth_day"));
			p.setJob(rs.getInt("job"));
			p.setPhone_number(rs.getString("phone_number"));
			p.setMail_address(rs.getString("mail_address"));
			list.add(p);
		}
		st.close();
		con.close();
		return list;

	}

	//更新処理
	public int update(MemberInformationBean product) throws Exception {
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"UPDATE k_users SET last_name = ? , first_name = ? , sex = ? , birth_year = ? , birth_month = ? "
						+ ", birth_day = ? , job = ? , phone_number = ? , mail_address = ? WHERE member_id = ?");
		st.setString(1, product.getLast_name());
		st.setString(2, product.getFirst_name());
		st.setInt(3, product.getSex());
		st.setInt(4, product.getBirth_year());
		st.setInt(5, product.getBirth_month());
		st.setInt(6, product.getBirth_day());
		st.setInt(7, product.getJob());
		st.setString(8, product.getPhone_number());
		st.setString(9, product.getMail_address());
		st.setString(10, product.getMember_id());

		int line = st.executeUpdate();

		st.close();
		con.close();

		return line;
	}

	//削除処理
	//データベースのデータを削除するメソッド
	public int delete(String member_id) throws Exception {

		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"delete  from k_users where member_id = ?");
		st.setString(1, member_id);
		int line  = st.executeUpdate();

		st.close();
		con.close();
		
		return line;
	}


}
