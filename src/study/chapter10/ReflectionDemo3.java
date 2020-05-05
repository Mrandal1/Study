package study.chapter10;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        String value = "ename:MiKe|empno:123456789|job:Clerk|hiredata:2019-5-20|salary:200.60|dept.dname:xxxdname";
        Emp emp = ClassInstanceFactory.create(Emp.class, value);
        assert emp != null;
        System.out.println(emp.toString());

    }
}

class ClassInstanceFactory {
    private ClassInstanceFactory() {
    }

    /**
     * 创建实例化对象 并传值
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
            return str.substring(0, 1).toUpperCase() + str.substring(1);
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
                /*多级配置*/
                if (eachValue[0].contains(".")) {
                    String[] temp = eachValue[0].split("\\.");
                    Object currentObject = ob;
                    for (int y = 0; y < temp.length - 1; y++) {
                        Method getmethod = currentObject.getClass().getDeclaredMethod("get" + StringUtil.initcap(temp[y]));
                        Object tempOb = getmethod.invoke(currentObject);
                        if (tempOb == null) {
                            /*获取属性*/
                            Field setobj = currentObject.getClass().getDeclaredField(temp[y]);
                            /*获取方法*/
                            Method method = currentObject.getClass().getDeclaredMethod("set" + StringUtil.initcap(temp[y]), setobj.getType());
                            /*为级联对象实例化*/
                            Object newob = setobj.getType().getDeclaredConstructor().newInstance();
                            /*传入实例*/
                            method.invoke(currentObject, newob);
                            currentObject = newob;

                        } else {
                            currentObject = tempOb;
                        }
                    }
                    field = currentObject.getClass().getDeclaredField(temp[temp.length - 1]);
                    Method setMethod = currentObject.getClass().getDeclaredMethod("set" + StringUtil.initcap(temp[temp.length - 1]), field.getType());
                    Object conobject = BeanUtil.convertAttributeValue(field.getType().getName(), eachValue[1]);
                    setMethod.invoke(currentObject, conobject);
                } else {
                    field = ob.getClass().getDeclaredField(eachValue[0]);
                    Method setMethod = ob.getClass().getDeclaredMethod("set" + StringUtil.initcap(eachValue[0]), field.getType());
                    Object conobject = BeanUtil.convertAttributeValue(field.getType().getName(), eachValue[1]);
                    setMethod.invoke(ob, conobject);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private static Object convertAttributeValue(String type, String value) {
        if ("long".equals(type) || "java.lang.Long".equals(type)) {
            return Long.parseLong(value);
        } else if ("int".equals(type) || "java.lang.Integer".equals(type)) {
            return Integer.parseInt(value);
        } else if ("double".equals(type) || "java.lang.Double".equals(type)) {
            return Double.parseDouble(value);
        } else if ("java.util.Date".equals(type)) {
            SimpleDateFormat sdf = null;
            if (value.matches("\\d{4}-\\d{1,2}-\\d{1,2}")) {
                sdf = new SimpleDateFormat("yyyy-MM-dd");
            } else if (value.matches("\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}")) {
                sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            } else {
                return new Date();
            }
            try {
                return sdf.parse(value);
            } catch (ParseException e) {
                return new Date();
            }
        } else {
            return value;
        }

    }
}

class Company {
    private String name;
    private Date createDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}

class Dept {
    private String dname;
    private String loc;
    private Company company;

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                ", company=" + company +
                '}';
    }
}

class Emp {
    private String ename;
    private long empno;
    private double salary;
    private Date hiredata;
    private String job;
    private Dept dept;

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

    public long getEmpno() {
        return empno;
    }

    public void setEmpno(long empno) {
        this.empno = empno;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getHiredata() {
        return hiredata;
    }

    public void setHiredata(Date hiredata) {
        this.hiredata = hiredata;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "ename='" + ename + '\'' +
                ", empno=" + empno +
                ", salary=" + salary +
                ", hiredata=" + hiredata +
                ", job='" + job + '\'' +
                ", dept.dname=" + dept.getDname() +
                '}';
    }
}
