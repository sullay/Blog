package com.sullay.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.model.BlogInfo;
import com.sullay.model.Msg;
import com.sullay.service.BlogInfoService;

@RestController
@RequestMapping("/BlogInfoClient")
public class BlogInfoController {
	@Autowired
	BlogInfoService blogInfoService;
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody BlogInfo blogInfo){
		blogInfoService.create(blogInfo);
	}
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void delete(@RequestBody BlogInfo blogInfo){
		blogInfoService.detele(blogInfo);
	}
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody BlogInfo blogInfo){
		blogInfoService.update(blogInfo);
	}
	@RequestMapping(value="/",method=RequestMethod.GET)
	public BlogInfo find(@RequestParam("title")String title){
		return blogInfoService.find(title);
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size){
		return Msg.success().add("pageInfo", blogInfoService.findAll(page, size));
	}
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Msg findBySpecialName(@RequestParam(value="specialName",required=false)String specialName,@RequestParam("page")int page,@RequestParam("size")int size){
		return Msg.success().add("pageInfo",blogInfoService.findBySpecialName(specialName,page,size));	
	}
}
