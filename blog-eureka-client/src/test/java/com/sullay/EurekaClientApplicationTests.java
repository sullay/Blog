package com.sullay;

import java.util.Date;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import com.sullay.model.BlogInfo;
import com.sullay.model.Special;
import com.sullay.service.BlogInfoService;
import com.sullay.service.SpecialService;
import com.sullay.web.BlogInfoController;
@RunWith(SpringRunner.class)
@SpringBootTest
public class EurekaClientApplicationTests {
	@Autowired
	BlogInfoController blogInfoController;
	@Autowired
	SpecialService specialService;
	@Autowired
	BlogInfoService blogInfoService;
	@Test
	public void test01(){
		Special special = new Special();
		special.setName("spring");
		specialService.create(special);
	}
	@Test
	public void test02(){
		Special special = specialService.find("spring");
		System.out.println(special.getName());
	}

	@Test
	public void test03(){
		Special special = specialService.find("spring");
		special.setName("spring boot");
		specialService.update(special);
	}
	@Test
	public void test04(){
		BlogInfo blogInfo = new BlogInfo();
		blogInfo.setAuthor("sullay");
		blogInfo.setDate(new Date());
		blogInfo.setHtml("<h1>xxxxxxxxxx<h1>");
		blogInfo.setIntroduction("xxxxxx");
		blogInfo.setLabel("spring springBoot");
		Special special = specialService.find("spring");
		blogInfo.setSpecial(special);
		blogInfo.setTitle("aop");
		blogInfoService.create(blogInfo);
	}
	@Test
	public void test05(){
		Special special = specialService.find("spring");
		specialService.detele(special);
	}
	@Test
	public void test07(){
		for (int i = 0; i < 50; i++) {
			BlogInfo blogInfo = new BlogInfo();
			blogInfo.setAuthor("sullay");
			blogInfo.setDate(new Date());
			blogInfo.setHtml("<h1>xxxxxxxxxx<h1>");
			blogInfo.setIntroduction("xxxxxx");
			blogInfo.setLabel("spring springBoot");
			Special special = specialService.find("spring");
			blogInfo.setSpecial(special);
			blogInfo.setTitle(UUID.randomUUID().toString());
			blogInfoService.create(blogInfo);
		}
	}
	@Test
	public void test08(){
		Page<BlogInfo> page = blogInfoService.findBySpecialName(null,0,5);
		System.out.println(page.getContent());
	}

	@Test
	public void test09(){
		Page<BlogInfo> page = blogInfoService.findAll(0, 10);
		System.out.println(page.getContent());
	}
	@Test
	public void test010(){
		System.out.println(blogInfoController.findBySpecialName(null, 0, 5).getExtend().get("pageInfo"));
	}
	@Test
	public void test11(){
		Special special = new Special();
		special.setName("xx");
		specialService.update(special);
	}

	@Test
	public void test12(){
		
	}
}
