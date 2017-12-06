package person.txm.feign.controller;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 封装异常
 * @author taoxiuma
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class TarsDataSourceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -973003277500078288L;

	private String code;

	public TarsDataSourceException(String code, String message, String param) {
		super(message != null ? String.format(message, param) : message);
		this.code = code;
	}

	public TarsDataSourceException(String code, String message) {
		this(code, message, null);
	}

	public TarsDataSourceException(String msg) {
		this(ResponseEnum.SERVER_ERROR.getCode(), msg, null);
	}
}
