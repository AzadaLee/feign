package person.txm.feign.controller;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -847368115488998377L;

	/**
	 * 响应码
	 */
	private String code;
	
	/**
	 * 响应信息
	 */
	private String message;

	/**
	 * 响应的结果
	 */
	private Object result;


	public static ResponseDTO success() {
		return new ResponseDTO(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMessage(), null);
	}

	public static ResponseDTO success(String code, String message) {
		return new ResponseDTO(code, message, null);
	}
	
	public static ResponseDTO success(Object data) {
		return new ResponseDTO(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMessage(), data);
	}

	public static ResponseDTO fail(String code, String message) {
		return new ResponseDTO(code, message, null);
	}
	
	public static ResponseDTO error() {
		return new ResponseDTO(ResponseEnum.SERVER_ERROR.getCode(), ResponseEnum.SERVER_ERROR.getMessage(), null);
	}
}
