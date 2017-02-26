package com.chuang.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chuang.model.Record;
import com.chuang.service.RecoedService;
@Controller
@RequestMapping("/record")
public class RecordController {

	@Autowired
	private RecoedService recoedService;
	
		@RequestMapping("/selectR.do/{id}")
		public ModelAndView selectRecords(@PathVariable int id){
			ModelAndView m = new ModelAndView();
			List<Record> rlst = recoedService.selectRecords(id);
			System.out.println(rlst);
			if(id!=0){
	            m.addObject("rlst", rlst);
	            m.setViewName("pages/showRecord");
	        }
			return m;
		}
}
