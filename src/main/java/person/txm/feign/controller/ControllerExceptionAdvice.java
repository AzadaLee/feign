package person.txm.feign.controller;

import java.lang.reflect.UndeclaredThrowableException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

/**
 * 异常统一处理类
 * @author taoxiuma
 *
 */
@ControllerAdvice
@Slf4j
public class ControllerExceptionAdvice {

	@ExceptionHandler
	@ResponseBody
	public ResponseDTO exceptionHandler(Throwable e) {
		e = e instanceof UndeclaredThrowableException ? e.getCause() : e;// 代理异常处理
		if (e instanceof TarsDataSourceException) {
			TarsDataSourceException tarsDataSourceException = (TarsDataSourceException) e;
			String code = tarsDataSourceException.getCode();
			String message = tarsDataSourceException.getMessage();
			log.debug("异常:::code:{},message:{}", code, message);
			return ResponseDTO.fail(code, message);
		}
		log.info("异常信息:", e);
		return ResponseDTO.error();
	}
}
