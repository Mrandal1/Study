package study.chapter06;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter06
 * @data 2020/4/28 14:12
 */
public class SystemDemo {
    public static void main(String[] args) {
        /*
         * system 类
         * 方法
         * 1 数组拷贝
         * public static native void arraycopy(Object src,int srcPos,Object dest,int destPos,int length);
         * 2 获取当前的日期时间数值
         *  public static native long currentTimeMillis();
         * 3 进行垃圾回收 GC (此方法是继续引用 Runtime 中的 GC 方法)
         *  public static void gc()
         *
         *
         *
         * */
        /*测试耗时操作统计*/
        long start=System.currentTimeMillis();
        String str="A";
        for (int i=0;i<3000;i++){
            str+=i;
        }
        long end=System.currentTimeMillis();
        System.out.println("操作耗时"+(end-start));

    }
}
