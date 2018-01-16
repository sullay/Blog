package com.sullay.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sullay.model.Special;
import com.sullay.repository.SpecialRepository;

@Service
public class SpecialService {
	@Autowired
	SpecialRepository specialRepository;
	public void create(Special special){
		specialRepository.save(special);
	}
	public void detele(Special special){
		specialRepository.delete(special);
	}
	public void update(Special special){
		specialRepository.save(special);
	}
	public Special find(String name){
		return specialRepository.findByName(name);
	}
	public List<Special> findAll(){
		return specialRepository.findAll();
	}
}
