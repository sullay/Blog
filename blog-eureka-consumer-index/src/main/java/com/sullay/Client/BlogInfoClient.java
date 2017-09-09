package com.sullay.Client;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sullay.model.BlogInfo;
import com.sullay.model.Msg;
@FeignClient("eureka-client")
@RequestMapping("/BlogInfoClient")
public interface BlogInfoClient {
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody BlogInfo blogInfo);
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void delete(@RequestBody BlogInfo blogInfo);
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody BlogInfo blogInfo);
	@RequestMapping(value="/",method=RequestMethod.GET)
	public BlogInfo find(@RequestParam("title")String title);
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Msg findAll(@RequestParam("page")int page,@RequestParam("size")int size);
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Msg findBySpecialName(@RequestParam(value="specialName",required=false)String specialName,@RequestParam("page")int page,@RequestParam("size")int size);
}
