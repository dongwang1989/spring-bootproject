package cn.zzdz.handler;

import cn.zzdz.annotation.JsonFieldFilter;
import cn.zzdz.filter.JsonFilterSerializer;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletResponse;

public class JsonReturnHandler implements HandlerMethodReturnValueHandler {

    @Override
    public void handleReturnValue(Object returnObject, MethodParameter paramter,
                                  ModelAndViewContainer container, NativeWebRequest request) throws Exception {
        System.out.println("123");
        container.setRequestHandled(true);
        JsonFilterSerializer serializer = new JsonFilterSerializer();
        if(paramter.hasMethodAnnotation(JsonFieldFilter.class)) {//如果有JsonFieldFilter注解，则过滤返回的对象returnObject
            JsonFieldFilter jsonFilter = paramter.getMethodAnnotation(JsonFieldFilter.class);
            serializer.filter(jsonFilter.type() == null ?returnObject.getClass() : jsonFilter.type(), jsonFilter.include(), jsonFilter.exclude());//调用过滤方法
        }
        HttpServletResponse response = request.getNativeResponse(HttpServletResponse.class);
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.getWriter().write(serializer.toJson(returnObject));
    }
    private final HandlerMethodReturnValueHandler delegate = null;

    @Override
    public boolean supportsReturnType(MethodParameter methodParameter) {
        delegate.supportsReturnType(methodParameter);
        return methodParameter.hasMethodAnnotation(JsonFieldFilter.class);
    }

}
