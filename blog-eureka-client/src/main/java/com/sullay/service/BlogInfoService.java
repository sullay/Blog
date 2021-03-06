package com.sullay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sullay.model.BlogInfo;
import com.sullay.repository.BlogInfoRepository;

@Service
public class BlogInfoService {
	@Autowired
	BlogInfoRepository blogInfoRepository;
	public void create(BlogInfo blogInfo){
		blogInfoRepository.save(blogInfo);
	}
	public void detele(BlogInfo blogInfo){
		blogInfoRepository.delete(blogInfo);
	}
	public void update(BlogInfo blogInfo){
		blogInfoRepository.save(blogInfo);
	}
	public BlogInfo find(String title){
		return blogInfoRepository.findByTitle(title);
	}
	public Page<BlogInfo> findAll(int page,int size){
		Pageable pageable = new PageRequest(page, size);
		return blogInfoRepository.findAll(pageable);
	}
	public Page<BlogInfo> findBySpecialName(String specialName,int page,int size){
		Pageable pageable = new PageRequest(page, size);
		return blogInfoRepository.findBySpecialName(specialName,pageable);
	}
}
