package com.sullay.Client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sullay.model.Special;
@FeignClient("eureka-client")
@RequestMapping("/specialClient")
public interface SpecialClient {
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody Special special);
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void delete(@RequestBody Special special);
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody Special special);
	@RequestMapping(value="/",method=RequestMethod.GET)
	public Special find(@RequestParam("name") String name);
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public List<Special> findAll();
}
