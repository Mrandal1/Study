package study.chapter02;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter02
 * @data 2020/4/24 13:56
 */
public class MyMath {
    //用throws关键字表明此方法可能产生异常
    public static int div(int x,int y)throws Exception{
        int temp=0;
        try {
            temp=x/y;
        }catch (Exception e){
            //向上抛异常
            throw e;
        }finally {
            System.out.println("执行完毕");
        }
        return temp;
    }
    public  static void getNum(int num){
        if (num>10){
            throw new BombException("自定义异常执行了！");
        }else {
            System.out.println("正常运行");
        }
    }

}
