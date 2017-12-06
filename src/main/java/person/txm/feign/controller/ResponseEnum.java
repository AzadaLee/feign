package person.txm.feign.controller;

import lombok.Getter;

/**
 * 返回信息枚举
 * @author taoxiuma
 *
 */
@Getter
public enum ResponseEnum {
	
	SUCCESS("000000","请求成功！"),
	SERVER_ERROR("999999","服务器繁忙，请稍后再试"),
	PARAM_NULL("111111","请求对象为空");
	private String code;
	
	private String message;

	private ResponseEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}
}
