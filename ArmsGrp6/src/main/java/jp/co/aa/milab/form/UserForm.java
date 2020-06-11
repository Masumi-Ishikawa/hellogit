package jp.co.aa.milab.form;

import java.sql.Date;

import javax.validation.constraints.NotBlank;

public class UserForm {

	@NotBlank(message="全て入力してください")
	private String userid;

	@NotBlank(message="全て入力してください")
	private String username;

	@NotBlank(message="全て入力してください")
	private String password;

	private Date passlimit;

	private Date entrydate;

	@NotBlank(message="全て入力してください")
	private String agreementno;

	private String gradeno;

	private String mail;

	private String systemauthorityno;

	private String lasttimelogin;

	private String thistimelogin;

	private Integer firstloginflg;

	private Integer deleteflg;

	private Integer vacation;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getPasslimit() {
		return passlimit;
	}

	public void setPasslimit(Date passlimit) {
		this.passlimit = passlimit;
	}

	public Date getEntrydate() {
		return entrydate;
	}

	public void setEntrydate(Date entrydate) {
		this.entrydate = entrydate;
	}

	public String getAgreementno() {
		return agreementno;
	}

	public void setAgreementno(String agreementno) {
		this.agreementno = agreementno;
	}

	public String getGradeno() {
		return gradeno;
	}

	public void setGradeno(String gradeno) {
		this.gradeno = gradeno;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getSystemauthorityno() {
		return systemauthorityno;
	}

	public void setSystemauthorityno(String systemauthorityno) {
		this.systemauthorityno = systemauthorityno;
	}

	public String getLasttimelogin() {
		return lasttimelogin;
	}

	public void setLasttimelogin(String lasttimelogin) {
		this.lasttimelogin = lasttimelogin;
	}

	public String getThistimelogin() {
		return thistimelogin;
	}

	public void setThistimelogin(String thistimelogin) {
		this.thistimelogin = thistimelogin;
	}

	public Integer getFirstloginflg() {
		return firstloginflg;
	}

	public void setFirstloginflg(Integer firstloginflg) {
		this.firstloginflg = firstloginflg;
	}

	public Integer getDeleteflg() {
		return deleteflg;
	}

	public void setDeleteflg(Integer deleteflg) {
		this.deleteflg = deleteflg;
	}

	public int getVacation() {
		return vacation;
	}

	public void setVacation(int vacation) {
		this.vacation = vacation;
	}


	}
