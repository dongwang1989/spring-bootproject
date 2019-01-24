package cn.zzdz.error;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.apache.log4j.Logger;

@RestController
public class ExceptionController extends AbstractErrorController {// extends AbstractErrorController

    static Logger logger = Logger.getLogger(ExceptionController.class);

    public ExceptionController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    @Value("${server.error.path:${error.path:/error}}")
    public String ERROR_PATH;// 注入的东西不能王final里加


    @RequestMapping("/error")
    public @ResponseBody
    ResponseEntity<Map<String, Object>> error(HttpServletRequest request, Exception exception)
            throws Exception {

        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        statusCode = statusCode == null ? HttpStatus.INTERNAL_SERVER_ERROR.value() : statusCode;
        logger.error("code:" + statusCode + " " + "message:" + HttpStatus.valueOf(statusCode) + " " + "exception:" + exception.getMessage());
        Map<String, Object> bodyfirst = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        HttpStatus status = getStatus(request);
        body.put("code", statusCode);
        body.put("message", HttpStatus.valueOf(statusCode));
        body.put("data", null);
        body.put("exception", exception.getMessage());
        bodyfirst.put("error", body);
        return new ResponseEntity<>(bodyfirst, status);
    }

    @Override
    public String getErrorPath() {
        // TODO Auto-generated method stub
        return null;
    }

}
