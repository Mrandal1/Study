package study.chapter01;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter01
 * @data 2020/4/23 18:23
 */


public class Test01 {
    /**
     *       enum与Enum的区别？
     *       enum:是JDK1.5后提供的关键字，用于定义枚举类
     *       Enum:是一个抽象类，所以使用enum关键字的类就默认继承了Enum抽象类
     *       枚举就是多例设计的最好体现
     * */
    public static void main(String[] args) {//使用枚举可以在编译阶段判断对象是否存在
        Color c=Color.BLUE;
        Color color=Color.绿色;
        //BLUE
        System.out.println(c);
        //绿色
        System.out.println(color);


        for (Color allColor:Color.values()) {
            //输出所有Color枚举的对象
            System.out.print(allColor+"、");
        }
        System.out.println();

        for (Color allColor:Color.values()) {
            System.out.println(allColor.ordinal()+"-"+allColor.name());
        }
         /*public final String name() {//获得Enum对象名字
            return name;
        }*/

        /* public final int ordinal() {//获得Enum对象序号(由定义时的顺序决定)
            return ordinal;
        }*/
        Person person=new Person("张三",15,Sex.MALE);
        System.out.println(person.toString());
    }
}
