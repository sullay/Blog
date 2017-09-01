package com.sullay.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sullay.model.BlogInfo;

public interface BlogInfoRepository extends JpaRepository<BlogInfo, Integer> {
	public BlogInfo findByTitle(String title);
	public Page<BlogInfo> findBySpecialName(String name,Pageable pageRequest);
}
