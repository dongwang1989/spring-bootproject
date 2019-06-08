package cn.zzdz.error;

import cn.zzdz.dto.ExceptionDto;
import org.apache.log4j.Logger;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice // 给controller用的aop 所有controller
@ResponseBody
public class GlobalExceptionHandler{
	static Logger logger = Logger.getLogger(ExceptionController.class);
	@ExceptionHandler(value = RuntimeException.class)
	public ExceptionDto runtimeExceptionHandler(HttpServletRequest request, RuntimeException exception) throws RuntimeException {
		//System.out.println("GlobalExceptionHandler");
		//exception.printStackTrace();
		logger.error(exception.getLocalizedMessage());
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
	@ResponseBody
	public ExceptionDto allExceptionHandler(HttpServletRequest request, Exception exception) throws Exception  {

		//exception.printStackTrace();
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
