package jp.co.aa.milab.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.aa.milab.form.JobTimeForm;

@Repository
public class JobTimeDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Map<String, Object> searchJobTime(JobTimeForm jobTimeForm) {
		
		String sql = "SELECT * FROM jobtime WHERE userid = ? AND entrydate = ?";
		
		Object[] param = {jobTimeForm.getUserid(), jobTimeForm.getEntrydate()};
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			return map = jdbcTemplate.queryForMap(sql, param);
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	public void inputJobTime(JobTimeForm jobTimeForm) {
		
		String sql = "INSERT INTO jobtime (userid, entrydate, starttime, endtime, state, worktime, overtime, nighttime, tardytime, earlytime, holidaywork, note) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		Object[] param = {jobTimeForm.getUserid(), jobTimeForm.getEntrydate(), jobTimeForm.getStarttime(), 
				jobTimeForm.getEndtime(), jobTimeForm.getState(), jobTimeForm.getWorktime(), 
				jobTimeForm.getOvertime(), jobTimeForm.getNighttime(), jobTimeForm.getTardytime(), 
				jobTimeForm.getEarlytime(), jobTimeForm.getHolidaywork(), jobTimeForm.getNote()};
		
		jdbcTemplate.update(sql, param);
	}
	
	public List<Map<String, Object>> listJobTime(String userid) {
		String sql = "SELECT * FROM jobtime WHERE userid = ?";
		
		Object[] param = {userid};
		
		List<Map<String, Object>> result = jdbcTemplate.queryForList(sql, param);
		return result;
	}
	
	public int updateJobTime(JobTimeForm jobTimeForm) {
		String sql = "UPDATE jobtime SET starttime = ?, endtime = ?, state = ?, worktime = ?, overtime = ?, nighttime = ?, tardytime = ?, earlytime = ?, holidaywork = ?, note = ? WHERE userid =? AND entrydate = ?";
		
		Object[] param = {jobTimeForm.getStarttime(), jobTimeForm.getEndtime(), jobTimeForm.getState(), jobTimeForm.getWorktime(), jobTimeForm.getOvertime(), jobTimeForm.getNighttime(), jobTimeForm.getTardytime(), jobTimeForm.getEarlytime(), jobTimeForm.getHolidaywork(), jobTimeForm.getNote(), jobTimeForm.getUserid(), jobTimeForm.getEntrydate()};
		
		int result = jdbcTemplate.update(sql, param);
		
		return result;
	}
	
}
