package study.chapter10;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter10
 * @data 2020/5/4 19:54
 */
public class ReflectionDemo3 {
    public static void main(String[] args) {
        /*
         * 实现属性自动赋值
         * */
        String value = "ename:MiKe|job:Clerk";
        Emp emp = ClassInstanceFactory.create(Emp.class, value);
        assert emp != null;
        System.out.println(emp.toString());

    }
}

class ClassInstanceFactory {
    private ClassInstanceFactory() {
    }

    /**
     * 创建实例化对象
     *
     * @param clazz 目标类
     * @param value 传入的值
     * @param <T>   目标类类型
     * @return 初始化后的实例对象
     */
    public static <T> T create(Class<T> clazz, String value) {
        try {
            Object object = clazz.getDeclaredConstructor().newInstance();
            BeanUtil.setValue(object, value);
            return (T) object;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        }

    }

}

class StringUtil {
    public static String initcap(String str) {
        if (str == null || "".equals(str)) {
            return str;
        }
        if (str.length() == 1) {
            return str.toUpperCase();
        } else {
            return str.substring(0, 1).toUpperCase() + str.substring(1, str.length());
        }

    }


}

class BeanUtil {
    private BeanUtil() {
    }

    public static void setValue(Object ob, String value) {
        String[] re = value.split("\\|");
        for (String s : re) {
            String[] eachValue = s.split(":");
            Field field = null;
            try {
                field = ob.getClass().getDeclaredField(eachValue[0]);
                Method setMethod = ob.getClass().getDeclaredMethod("set" + StringUtil.initcap(eachValue[0]), field.getType());
                setMethod.invoke(ob, eachValue[1]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}


class Emp {
    private String ename;
    private String job;

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEname() {
        return ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
