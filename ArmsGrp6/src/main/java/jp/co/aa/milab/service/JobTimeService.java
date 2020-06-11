package jp.co.aa.milab.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.aa.milab.dao.JobTimeDao;
import jp.co.aa.milab.form.JobTimeForm;

@Service
public class JobTimeService {

	@Autowired
	JobTimeDao jobTimeDao;
	
	public Map<String, Object> searchJobTime(JobTimeForm jobTimeForm) {
		
		Map<String, Object> result = jobTimeDao.searchJobTime(jobTimeForm);
		
		return result;
	}
	
	public void inputJobTime(JobTimeForm jobTimeForm) {
		jobTimeDao.inputJobTime(jobTimeForm);
	}
	
	public List<Map<String, Object>> listJobTime(String userid, int week, int day) {
		List<Map<String, Object>> maplist = jobTimeDao.listJobTime(userid);
		List<Map<String, Object>> timelList = new ArrayList<Map<String, Object>>();
		String w = "";
		int flg;
		
		for(int i = 1; i <= day; i++) {
			String sdf = "2020-06-" + i;
			java.sql.Date data = java.sql.Date.valueOf(sdf);
			flg = 0;
			Map<String, Object> m = new HashMap<String, Object>();
			switch(week%7) {
			case 1:w = "日"; 
	         	break;
		    case 2:w = "月";
		         break;
		    case 3:w = "火";
		         break;
		    case 4:w = "水";
		         break;
		    case 5:w = "木";
		         break;
		    case 6:w = "金";
		         break;
		    case 0:w = "土";
		         break;
			}
			
		for(Iterator<Map<String, Object>> it = maplist.iterator() ; it.hasNext() ; ) {
			Map<String, Object> value = it.next();
			String[] date = value.get("entrydate").toString().split("-");
				if(Integer.valueOf(date[2]) == i) {
					m.put("day", i);
					m.put("week", w);
					m.put("starttime", value.get("starttime"));
					m.put("endtime", value.get("endtime"));
					m.put("worktime", castString(value.get("worktime")));
					m.put("state", value.get("state"));
					m.put("overtime", castString(value.get("overtime")));
					m.put("nighttime", castString(value.get("nighttime")));
					m.put("tardytime", castString(value.get("tardytime")));
					m.put("earlytime", castString(value.get("earlytime")));
					m.put("note", value.get("note"));
					m.put("date", data);
					it.remove();
					flg++;
				}
			}
			
			if(flg == 0) {
				m.put("day", i);
				m.put("week", w);
				m.put("starttime", "");
				m.put("endtime", "");
				m.put("worktime", "");
				m.put("state", "");
				m.put("overtime", "");
				m.put("nighttime", "");
				m.put("tardytime", "");
				m.put("earlytime", "");
				m.put("note", "");
				m.put("date", data);
			}
			timelList.add(m);
			week++;
		}
		
		return timelList;
	}
	
	public int updateJobTime(JobTimeForm jobTimeForm) {
		int result = jobTimeDao.updateJobTime(jobTimeForm);
		
		return result;
	}
	
	public String castString(Object object) {
		if(object != null) {
			int time = Integer.valueOf(object.toString());
			int hour = time/60;
			int minute = time%60;
			String result = "";
			if(hour < 10) {
				result = "0"+ hour + ":" + minute;
			} else {
				result = hour + ":" + minute;
			}
			
			if(minute == 0) {
				result = result + "0";
			}
			return result;
		} else {
			return null;
		}
	}
}
