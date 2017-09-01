package com.sullay.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.model.Special;
import com.sullay.service.SpecialService;

@RestController
@RequestMapping("/specialClient")
public class SpecialController {
	@Autowired
	SpecialService specialService;
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void create(@RequestBody Special special){
		specialService.create(special);
	}
	@RequestMapping(value="/",method=RequestMethod.DELETE)
	public void delete(@RequestBody Special special){
		specialService.detele(special);
	}
	@RequestMapping(value="/",method=RequestMethod.PUT)
	public void update(@RequestBody Special special){
		specialService.update(special);
	}
	@RequestMapping(value="/",method=RequestMethod.GET)
	public Special find(@RequestParam("name")String name){
		Special special = specialService.find(name);
		return special;
		
	}
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public List<Special> findAll(){
		List<Special> specials = specialService.findAll();
		return specials;
	}
}
