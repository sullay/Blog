package com.sullay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sullay.model.Special;

public interface SpecialRepository extends JpaRepository<Special, Integer> {
	public Special findByName(String name);
}
