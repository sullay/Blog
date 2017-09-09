package com.sullay.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.sullay.Client.BlogInfoClient;
import com.sullay.model.Msg;
@RestController
public class BlogInfoController {
	@Autowired
	BlogInfoClient blogInfoClient;
	@RequestMapping(value="/blogInfos",method=RequestMethod.GET)
	public Msg findBlogInfos(@RequestParam(value="specialName")String specialName,@RequestParam(value="page",defaultValue="0")Integer page){
		if("all".equals(specialName)){
			return blogInfoClient.findAll(page, 10).add("specialName", specialName);
		}else if("other".equals(specialName)){
			return blogInfoClient.findBySpecialName(null, page, 10).add("specialName", specialName);
		}else{
			return blogInfoClient.findBySpecialName(specialName, page, 10).add("specialName", specialName);
		}
	}
	@RequestMapping(value="/blogInfo",method=RequestMethod.GET)
	public Msg findBlogInfo(String title){
		return Msg.success().add("blogInfo",blogInfoClient.find(title));
	}
}
