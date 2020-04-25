package study.chapter01;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter01
 * @data 2020/4/23 19:04
 */
public enum Color {//定义枚举对象类
    //   RED,BLUE,绿色;//实例化无参对象  枚举对象要写在第一行！！！
    //实例化有参对象
    RED("红色"),BLUE("蓝色"),绿色("绿色");

    private  String title;

    private Color(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
