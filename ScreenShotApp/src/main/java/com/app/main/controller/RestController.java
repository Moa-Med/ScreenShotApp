package com.app.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.main.model.Url;
import com.app.main.services.UrlService;


@org.springframework.web.bind.annotation.RestController 
public class RestController {

	@Autowired
	private UrlService urlService;
	
	@GetMapping("/saveurl")
	public String saveUrl(@RequestParam String urls,@RequestParam String fileName) throws Exception{
		Url url=new Url(urls,fileName);
		 urlService.urlSave(url);
		 return " Screenshot done !!! ";
	}
	
	
	
}
