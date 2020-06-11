package jp.co.aa.milab.model;

public class calc {
	
	public int worktime(int s_time, int e_time) {
		int s_hour = s_time/60;
		int s_minute = s_time%60;
		int e_hour = e_time/60;
		int e_minute = e_time%60;
		int work_hour = 0;
		int work_minute = 0;
		int result;
		
		if(e_hour >= 18) {
			work_minute = 60-s_minute;
			if(work_minute == 0) {
				work_hour = 18-s_hour;
			} else {
				work_hour = 17-s_hour;
			}
		} else {
			if(s_minute > e_minute) {
				e_hour--;
				work_minute = (60-s_minute) + e_minute;
			} else {
				work_minute = e_minute - s_minute;
			}
			work_hour = e_hour - s_hour;
		}
		result = (work_hour*60) + work_minute;
		
		return result;
	}
	
	public int overtime(int e_time) {
		int e_hour = e_time/60;
		int e_minute = e_time%60;
		int over_hour = 0;
		int result;
		
		if(e_hour >= 22) {
			over_hour = (e_hour-18) - (e_hour-22);
			result = (over_hour*60);
		} else {
			over_hour = (e_hour-18);
			result = (over_hour*60) + e_minute;
		}
		
		return result;
		
	}
	
	public int nighttime(int e_time) {
		int e_hour = e_time/60;
		int e_minute = e_time%60;
		int night_hour = 0;
		int result;
		
		night_hour = e_hour-22;
		result = (night_hour*60) + e_minute;
		
		return result;
		
	}
	
	public int tardyTime(int s_time) {
		int s_hour = s_time/60;
		int s_minute = s_time%60;
		int tardy_hour = 0;
		int result;
		
		tardy_hour = s_hour-9;
		result = (tardy_hour*60) + s_minute;
		
		return result;
	}
	
}
