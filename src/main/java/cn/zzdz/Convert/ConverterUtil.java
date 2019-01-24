package cn.zzdz.Convert;


import org.springframework.cglib.beans.BeanCopier;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;


public class ConverterUtil {
    //private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    // 使用多线程安全的Map来缓存BeanCopier，由于读操作远大于写，所以性能影响可以忽略
    public static ConcurrentHashMap<String, BeanCopier> beanCopierMap = new ConcurrentHashMap<String, BeanCopier>();

    /**
     * 通过cglib BeanCopier形式
     * @param source
     * @param target
     */
    public static void copyProperties(Object source, Object target) {
        String beanKey = generateKey(source.getClass(), target.getClass());
        BeanCopier copier = null;
        copier = BeanCopier.create(source.getClass(), target.getClass(), false);
        beanCopierMap.putIfAbsent(beanKey, copier);// putIfAbsent已经实现原子操作了。
        copier = beanCopierMap.get(beanKey);
        copier.copy(source, target, null);
    }

    private static String generateKey(Class<?> class1, Class<?> class2) {
        return class1.toString() + class2.toString();
    }

    /**
     ×通过常规反射形式
     * DTO对象转换为实体对象。如命名不规范或其他原因导致失败。
     * @param t 源转换的对象
     * @param e 目标转换的对象
     *
     */
    public static <T,E> void transalte(T t,E e){
        Method[] tms=t.getClass().getDeclaredMethods();
        Method[] tes=e.getClass().getDeclaredMethods();
        for(Method m1:tms){
            if(m1.getName().startsWith("get")){
                String mNameSubfix=m1.getName().substring(3);
                String forName="set"+mNameSubfix;
                for(Method m2:tes){
                    if(m2.getName().equals(forName)){
                        // 如果类型一致，或者m2的参数类型是m1的返回类型的父类或接口
                        boolean canContinue = m2.getParameterTypes()[0].isAssignableFrom(m1.getReturnType());
                        if (canContinue) {
                            try {
                                m2.invoke(e, m1.invoke(t));
                                //System.out.println("ceeeeee");
                                break;
                            } catch (Exception e1) {
                                // TODO Auto-generated catch block
                                //logger.debug("");
                                e1.printStackTrace();
                            }
                        }
                    }
                }
            }

        }
        //logger.debug("转换完成");

    }

}
