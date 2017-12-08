package person.txm.feign.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import person.txm.feign.client.HelloFeignClient;

@RestController
@RequestMapping("/feign")
@Slf4j
public class FeignController {

	@Autowired
	private HelloFeignClient helloFeignClient;
	
	@RequestMapping("/test")
	public Object test(){
		log.info("feign controller test=====");
		return helloFeignClient.hello(new HashMap<String, Object>());
	}
	
	@RequestMapping("/testGet")
	public Object testGet(){
		return helloFeignClient.testGet("DOUG", "18655555");
	}
}
