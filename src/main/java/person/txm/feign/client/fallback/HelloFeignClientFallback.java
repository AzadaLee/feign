package person.txm.feign.client.fallback;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import person.txm.feign.client.HelloFeignClient;

@Component
public class HelloFeignClientFallback implements HelloFeignClient {

	@Override
	public Object hello(Map<String, Object> params) {
		Map<String, Object> result = new HashMap<>();
		result.put("resultCode", "500000");
		result.put("resultMsg", "调用异常");
		return result;
	}

	@Override
	public Object testGet(String name, String mobile) {
		return null;
	}

}
