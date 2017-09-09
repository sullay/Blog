package com.sullay.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.Client.SpecialClient;
import com.sullay.model.Msg;
import com.sullay.model.Special;

@RestController
public class SpecailController {
	@Autowired
	SpecialClient specialClient;
	@RequestMapping(value="/specials",method=RequestMethod.GET)
	public Msg findAll(){
		List<Special> specials = specialClient.findAll();
		return Msg.success().add("specials", specials);
	}
	@RequestMapping(value="/special",method=RequestMethod.POST)
	public void create(Special special){
		if(special.getName()!=null&&!"".equals(special.getName())){
			specialClient.create(special);	
		}
	}
}
