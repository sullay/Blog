package com.sullay;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sullay.Client.BlogInfoClient;
import com.sullay.Client.SpecialClient;
import com.sullay.model.Special;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EurekaConsumerApplicationTests {
	@Autowired
	SpecialClient specialClient;
	@Autowired
	BlogInfoClient blogInfoClient;
	@Test
	public void test1() {
		List<Special> find = specialClient.findAll();
		System.out.println(find.get(0).getName());
	}
	@Test
	public void test2() {
		Special find = specialClient.find("spring");
		System.out.println(find.getName());
	}
	@Test
	public void test3(){
		Special special = new Special();
		special.setName("spring cloud");
		specialClient.create(special);
	}
	@Test
	public void test4(){
		Special special = specialClient.find("spring cloud");
		specialClient.delete(special);
	}

	@Test
	public void test5(){
		blogInfoClient.findBySpecialName(null, 0, 5);
	}
}
