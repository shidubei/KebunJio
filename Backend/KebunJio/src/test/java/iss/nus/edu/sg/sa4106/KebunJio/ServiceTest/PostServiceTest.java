package iss.nus.edu.sg.sa4106.KebunJio.ServiceTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import iss.nus.edu.sg.sa4106.KebunJio.Services.PostService;

@SpringBootTest
public class PostServiceTest {
	@Autowired
	private PostService postService;
	
	@Test
	void testAdd() {
		int result = postService.add(1, 2);
		Assertions.assertEquals(3,result);
	}
}
