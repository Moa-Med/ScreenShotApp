package com.app.main.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.main.model.Url;
import com.app.main.services.UrlService;

@Controller
public class ScreenController {
		
		@Autowired
	    private UrlService urlService;
	
		@RequestMapping("/snapshot")
		public String screenshot(HttpServletRequest request) {
			request.setAttribute("mode","MODE_URL");
			return "screenpage";
		}
		
		@GetMapping("/snaps")
		public String snaps(HttpServletRequest request) {
			request.setAttribute("urls",urlService.getAllUrls());
			request.setAttribute("mode","MODE_SNAPS");
			return "screenpage";
		}
			
		@PostMapping("/save-url")
		public String register(@ModelAttribute Url url,BindingResult bindingResul,HttpServletRequest request) {
			
			try {
				if(urlService.urlSave(url)==1) {
				request.setAttribute("mode","MODE_DONE");
				}else {request.setAttribute("mode","MODE_ERROR");}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			return "screenpage";
		}
		
		@RequestMapping("/delete-url")
		public String delete(@RequestParam Long id,HttpServletRequest request) {
			urlService.deleteUrl(id);
			request.setAttribute("urls",urlService.getAllUrls());
			request.setAttribute("mode","MODE_SNAPS");
			return "screenpage";
		}
		
		
		
}
