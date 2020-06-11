package jp.co.aa.milab.form;

import java.sql.Date;

public class JobTimeForm {
	
	private String[] state_ary = { "定時勤務", "休日勤務", "休暇", "有休" };
	
	private String[] hour_ary = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", 
			"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", 
			"21", "22", "23", "24"};

	private String[] minute_ary = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", 
			"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", 
			"21", "22", "23", "24", "25", "26", "27", "28", "29", "30", 
			"31", "32", "33", "34", "35", "36", "37", "38", "39", "40", 
			"41", "42", "43", "44", "45", "46", "47", "48", "49", "50", 
			"51", "52", "53", "54", "55", "56", "57", "58", "59"};

	private String userid;
	
	private Date entrydate;
	
	private String starttime;
	
	private String endtime;
	
	private String state;
	
	private Integer worktime;
	
	private Integer overtime;
	
	private Integer nighttime;
	
	private Integer tardytime;
	
	private Integer earlytime;
	
	private Integer holidaywork;
	
	private String note;
	
	//getter, setter
	
	public String getUserid() {
		return userid;
	}

	public String[] getState_ary() {
		return state_ary;
	}

	public void setState_ary(String[] state_ary) {
		this.state_ary = state_ary;
	}

	public String[] getHour_ary() {
		return hour_ary;
	}

	public void setHour_ary(String[] hour_ary) {
		this.hour_ary = hour_ary;
	}

	public String[] getMinute_ary() {
		return minute_ary;
	}

	public void setMinute_ary(String[] minute_ary) {
		this.minute_ary = minute_ary;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Date getEntrydate() {
		return entrydate;
	}

	public void setEntrydate(Date entrydate) {
		this.entrydate = entrydate;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getWorktime() {
		return worktime;
	}

	public void setWorktime(Integer worktime) {
		this.worktime = worktime;
	}

	public Integer getOvertime() {
		return overtime;
	}

	public void setOvertime(Integer overtime) {
		this.overtime = overtime;
	}

	public Integer getNighttime() {
		return nighttime;
	}

	public void setNighttime(Integer nighttime) {
		this.nighttime = nighttime;
	}

	public Integer getTardytime() {
		return tardytime;
	}

	public void setTardytime(Integer tardytime) {
		this.tardytime = tardytime;
	}

	public Integer getEarlytime() {
		return earlytime;
	}

	public void setEarlytime(Integer earlytime) {
		this.earlytime = earlytime;
	}

	public Integer getHolidaywork() {
		return holidaywork;
	}

	public void setHolidaywork(Integer holidaywork) {
		this.holidaywork = holidaywork;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
}
