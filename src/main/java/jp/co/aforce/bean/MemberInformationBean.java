package jp.co.aforce.bean;

public class MemberInformationBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private String member_id;
	private String last_name;
	private String first_name;
	private int sex;
	private int birth_year;
	private int birth_month;
	private int birth_day;
	private int job;
	private String phone_number;
	private String mail_address;
	

	//ゲット
	public String getMember_id() {
		return member_id;
	}
	public String getLast_name() {
		return last_name;
	}
	public String getFirst_name() {
		return first_name;
	}
	public int getSex() {
		return sex;
	}
	public int getBirth_year() {
		return birth_year;
	}
	public int getBirth_month() {
		return birth_month;
	}
	public int getBirth_day() {
		return birth_day;
	}
	public int getJob() {
		return job;
	}
	
	public String getPhone_number() {
		return phone_number;
	}
	public String getMail_address() {
		return mail_address;
	}
	

	


	//セット
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public void setBirth_year(int birth_year) {
		this.birth_year = birth_year;
	}
	public void setBirth_month(int birth_month) {
		this.birth_month = birth_month;
	}
	public void setBirth_day(int birth_day) {
		this.birth_day = birth_day;
	}
	public void setJob(int job) {
		this.job = job;
	}
	
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public void setMail_address(String mail_address) {
		this.mail_address = mail_address;
	}
	

	//セット変換
	public void setData(String post_name,String post_value) {
		switch (post_name) {
		case "member_id":
			setMember_id(post_value);
			break;
		case "last_name":
			setLast_name(post_value);
			break;
		case "first_name":
			setFirst_name(post_value);
			break;
		case "sex":
			setSex(Integer.parseInt(post_value));
			break;
		case "birth_year":
			setBirth_year(Integer.parseInt(post_value));
			break;
		case "birth_month":
			setBirth_month(Integer.parseInt(post_value));
			break;
		case "birth_day":
			setBirth_day(Integer.parseInt(post_value));
			break;
		case "job":
			setJob(Integer.parseInt(post_value));
			break;
		case "phone_number":
			setPhone_number(post_value);
			break;
		case "mail_address":
			setMail_address(post_value);
			break;
		default:
			setMember_id(post_value);
			break;
		}
	}
	

	
	
}
