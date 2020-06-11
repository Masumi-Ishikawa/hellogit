package jp.co.aa.milab.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.aa.milab.form.JobTimeForm;
import jp.co.aa.milab.model.calc;
import jp.co.aa.milab.service.JobTimeService;

@Controller
public class JobTimeController {
	
	@Autowired
	JobTimeService jobTimeService;
	
	@GetMapping("/job/list")
	public String getJobList(@ModelAttribute JobTimeForm jobTimeForm,
			Model model) {
		String userid = "ay9564";
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),1);
		int end = cal.getActualMaximum(Calendar.DATE);
		int week = cal.get(Calendar.DAY_OF_WEEK);
		
		List<Map<String, Object>> list = jobTimeService.listJobTime(userid, week, end);
		
		model.addAttribute("list", list);
		return "jobtimelist";
	}
	
	@GetMapping("/job/regist")
	public String getJobRegist(@ModelAttribute JobTimeForm jobTimeForm,
			@RequestParam(name = "s_time", defaultValue = "") String s_time,
			@RequestParam(name = "e_time", defaultValue = "") String e_time,
			Model model) {
		
		String[] s_date = new String[2];
		String[] e_date = new String[2];
		
		if(s_time.equals("")) {
			s_date[0] = "09";
			s_date[1] = "00";
		} else {
			s_date = s_time.split(":");
		}
		
		if(e_time.equals("")) {
			e_date[0] = "18";
			e_date[1] = "00";
		} else {
			e_date = e_time.split(":");
		}
		
		model.addAttribute("s_hour", s_date[0]);
		model.addAttribute("s_minute", s_date[1]);
		model.addAttribute("e_hour", e_date[0]);
		model.addAttribute("e_minute", e_date[1]);
		
		return "jobtime";
		
	}
	
	@PostMapping("/job/regist")
	public String postJobRegist(@ModelAttribute JobTimeForm jobTimeForm,
			@RequestParam(name = "s_hour", defaultValue = "") Integer s_hour,
			@RequestParam(name = "s_minute", defaultValue = "") Integer s_minute,
			@RequestParam(name = "e_hour", defaultValue = "") Integer e_hour,
			@RequestParam(name = "e_minute", defaultValue = "") Integer e_minute,
			Model model) {
		calc calc = new calc();
		
		String start_time = s_hour + ":" + s_minute;
		String end_time = e_hour + ":" + e_minute;
		
		if(s_hour < 10) {
			start_time = "0"+ s_hour + ":" + s_minute;
		}
		
		if(s_minute == 0) {
			start_time = start_time + "0";
		}
		
		if(e_hour < 10) {
			end_time = "0"+ e_hour + ":" + e_minute;
		}
		
		if(e_minute == 0) {
			end_time = end_time + "0";
		}
		
		Integer s_time = (s_hour * 60) + s_minute;
		Integer e_time = (e_hour * 60) + e_minute;
		
		Integer work_time = null;
		Integer tardy_time = null;
		Integer over_time = null;
		Integer night_time = null;
		Integer early_time = null;
		Integer holiday_work = null;
		
		work_time = calc.worktime(s_time, e_time) - 60;
		
		if(e_time < 1080) {
			early_time = work_time;
		} else {
			early_time = 0;
		}
		
		//지각
		if(s_time > 540) {
			tardy_time = calc.tardyTime(s_time);
		} else {
			tardy_time = 0;
		}
		
		//잔업
		if(e_time > 1080) {
			over_time = calc.overtime(e_time);
		} else {
			over_time = 0;
		}
		
		//야근
		if(e_time > 1320) {
			night_time = calc.nighttime(e_time);
		} else {
			night_time = 0;
		}
		
		if(jobTimeForm.getState().equals("休日勤務")) {
			holiday_work = work_time;
		} else {
			holiday_work = 0;
		}
		
		jobTimeForm.setUserid("ay9564");
		jobTimeForm.setStarttime(start_time);
		jobTimeForm.setEndtime(end_time);
		jobTimeForm.setWorktime(work_time);
		jobTimeForm.setOvertime(over_time);
		jobTimeForm.setNighttime(night_time);
		jobTimeForm.setTardytime(tardy_time);
		jobTimeForm.setEarlytime(early_time);
		jobTimeForm.setHolidaywork(holiday_work);
		
		if(jobTimeService.searchJobTime(jobTimeForm) == null) {
			jobTimeService.inputJobTime(jobTimeForm);
		} else {
			jobTimeService.updateJobTime(jobTimeForm);
		}
		
		return "redirect:list";
		
	}
}
