package jp.co.aa.milab.form;

public class TotalTimeForm {

	private String userid;

	private String entrydate;

	private Integer total_worktime;

	private Integer total_overtime;

	private Integer total_nighttime;

	private Integer total_earlytime;

	private Integer total_holidaywork;

	private Integer vacation;


	// getter, setter


	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getEntrydate() {
		return entrydate;
	}

	public void setEntrydate(String entrydate) {
		this.entrydate = entrydate;
	}

	public Integer getTotal_worktime() {
		return total_worktime;
	}

	public void setTotal_worktime(Integer total_worktime) {
		this.total_worktime = total_worktime;
	}

	public Integer getTotal_overtime() {
		return total_overtime;
	}

	public void setTotal_overtime(Integer total_overtime) {
		this.total_overtime = total_overtime;
	}

	public Integer getTotal_nighttime() {
		return total_nighttime;
	}

	public void setTotal_nighttime(Integer total_nighttime) {
		this.total_nighttime = total_nighttime;
	}

	public Integer getTotal_earlytime() {
		return total_earlytime;
	}

	public void setTotal_earlytime(Integer total_earlytime) {
		this.total_earlytime = total_earlytime;
	}

	public Integer getTotal_holidaywork() {
		return total_holidaywork;
	}

	public void setTotal_holidaywork(Integer total_holidaywork) {
		this.total_holidaywork = total_holidaywork;
	}

	public Integer getVacation() {
		return vacation;
	}

	public void setVacation(Integer vacation) {
		this.vacation = vacation;
	}


}
