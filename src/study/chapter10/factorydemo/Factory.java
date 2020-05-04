package study.chapter10.factorydemo;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter10.factorydemo
 * @data 2020/5/4 10:52
 */
public class Factory {
    private Factory() {
    }

    /**
     * 获取接口实例化
     *
     * @param classname 接口的子类
     * @param clazz     接口类型
     * @param <T>       指定接口类型
     * @return 如果子类存在，返回指定接口实例化对象
     */
    public static <T> T getInstance(String classname, Class<T> clazz) {
        T instance = null;
        try {
            instance = (T) Class.forName(classname).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }
}
