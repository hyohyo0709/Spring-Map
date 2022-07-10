package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dto.LibmapDTO;
import service.LibmapService;

// http://localhost:8090/myapp/map.do

@Controller
public class MapController {

	private LibmapService service;
	
	public MapController() {
		// TODO Auto-generated constructor stub
	}
	
	public void setService(LibmapService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/map.do")
	public String mapForm() {
		
	
		return "map";
	}
	
	
	
	@ResponseBody
	@RequestMapping(value = "/libmap.do", method = RequestMethod.POST)
	public ModelAndView libraryMap(int pageNo, int pageSize, String keyword, ModelAndView mav) {
		int countAll = service.f_countAllProcess(keyword);
		int totalPage=countAll/pageSize;
		if((countAll%pageSize)>0) {
			totalPage++;
		}
		
		List<LibmapDTO> aList = service.f_listProcess(pageNo, pageSize, keyword);
		mav.addObject("aList", aList);
		mav.addObject("pageNo", pageNo);
		mav.addObject("totalPage", totalPage);
		mav.setViewName("jsonView");
		
		return mav;
		
	}
}
