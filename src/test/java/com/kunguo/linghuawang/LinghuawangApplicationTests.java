package com.kunguo.linghuawang;

import com.kunguo.linghuawang.service.AdminService;
import com.kunguo.linghuawang.service.RoleRightsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LinghuawangApplicationTests {

	@Autowired
	private RoleRightsService adminService;
	@Test
	void contextLoads() {

		System.out.println(adminService.getRoleRights(-1).get(0).name);
	}

}
