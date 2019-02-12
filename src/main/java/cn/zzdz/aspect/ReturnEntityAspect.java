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

    //@Around("aspect()&&@annotation(rec)")
    public Object aroundStatus(ProceedingJoinPoint pjp, IReturnEntityColum rec) throws Throwable {
        Object proceed;
        //System.out.println("这是环绕通知之前的部分!!"); // 获取将要执行的方法名称 String
        //String methodName = pjp.getSignature().getName();
        Map<Object, Object> hashMap = new HashMap<Object, Object>();
        proceed = pjp.proceed();//+"dgod";// 调用目标方法
        Class clazz = proceed.getClass();
        Class cla = Class.forName(clazz.getName());
        Constructor con = cla.getConstructor();
        Object obj = cla.newInstance();
        if (clazz.getPackage().getName()=="java.util"){
           Method mmm= clazz.getMethod("size");
           mmm.invoke(clazz);
        }

        else {
            for (Method met : cla.getDeclaredMethods()) {
                System.out.println("123");
                for (String re : rec.value()) {
                    String fieldName = met.getName().substring(3).toUpperCase();
                    if (fieldName == re.toUpperCase()) {
                        Field newname = cla.getDeclaredField(re);
                        newname.setAccessible(true);
                        newname.set(obj, met.invoke(proceed));
                    }
                }

            }
        }

        return obj;
    }


}
