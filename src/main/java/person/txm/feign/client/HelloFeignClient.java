package person.txm.feign.client;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import person.txm.feign.client.fallback.HelloFeignClientFallback;

@FeignClient(name = "producter",fallback = HelloFeignClientFallback.class)
public interface HelloFeignClient {
	
	@RequestMapping("/test/hello")
	Object hello(Map<String, Object> params);
	
	@RequestMapping("/test/testGet")
	Object testGet(@RequestParam("mobile") String name,@RequestParam("name") String mobile);
}
