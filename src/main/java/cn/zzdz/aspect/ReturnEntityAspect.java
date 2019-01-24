package cn.zzdz.aspect;

import cn.zzdz.annotation.IReturnEntityColum;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

@Component
@Aspect
public class ReturnEntityAspect {
    @Pointcut("@annotation(cn.zzdz.annotation.IReturnEntityColum)")
    public void aspect() {
    }

    @Around("aspect()&&@annotation(rec)")
    public Object aroundStatus(ProceedingJoinPoint pjp, IReturnEntityColum rec) throws Throwable {
        Object proceed;
        //System.out.println("这是环绕通知之前的部分!!"); // 获取将要执行的方法名称 String
        String methodName = pjp.getSignature().getName();
        Map<Object, Object> hashMap = new HashMap<Object, Object>();
        proceed = pjp.proceed();//+"dgod";// 调用目标方法
        Class clazz = proceed.getClass();
        Class cla = Class.forName(clazz.getName());
        Constructor con = cla.getConstructor();
        Object obj = cla.newInstance();
        if (true) {

            List<String> list = new ArrayList<String>();
            list = Arrays.asList(rec.value());
            for (int i = 0; i < rec.value().length; i++) {
                String name = rec.value()[i];
                name = name.replaceFirst(name.substring(0, 1), name.substring(0, 1).toUpperCase());
                Method m = clazz.getMethod("get" + name);
                Field newname = cla.getDeclaredField(rec.value()[i]);
                newname.setAccessible(true);
                newname.set(obj,m.invoke(proceed));

            }

        } else {
            proceed = "500";
        }
        //System.out.println("这是环绕通知之后的部分!!");
        return obj;
    }


}
