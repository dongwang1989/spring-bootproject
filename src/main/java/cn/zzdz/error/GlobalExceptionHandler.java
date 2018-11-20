package cn.zzdz.error;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zzdz.dto.ExceptionDto;

@ControllerAdvice // 给controller用的aop 所有controller
@ResponseBody
public class GlobalExceptionHandler{
	@ExceptionHandler(value = RuntimeException.class)
	public ExceptionDto runtimeExceptionHandler(HttpServletRequest request, RuntimeException exception) throws Exception {
		System.out.println("RuntimeException");
		exception.printStackTrace();
		ExceptionDto exceptiondto = new ExceptionDto();
		exceptiondto.setErrorType("error");
		exceptiondto.setCause(exception.getCause());
		exceptiondto.setLocalized(exception.getLocalizedMessage());
		exceptiondto.setMessage(exception.getMessage());
		exceptiondto.setSuppressed(exception.getSuppressed());
		exceptiondto.setErrorclass(exception.getClass());
		return exceptiondto;
	}

	@ExceptionHandler(value = Exception.class)
	public ExceptionDto allExceptionHandler(HttpServletRequest request, Exception exception) throws Exception {
		exception.printStackTrace();
		ExceptionDto exceptiondto = new ExceptionDto();
		exceptiondto.setErrorType("fatal error");
		exceptiondto.setCause(exception.getCause());
		exceptiondto.setLocalized(exception.getLocalizedMessage());
		exceptiondto.setMessage(exception.getMessage());
		exceptiondto.setSuppressed(exception.getSuppressed());
		exceptiondto.setErrorclass(exception.getClass());
		return exceptiondto;
	}

}
