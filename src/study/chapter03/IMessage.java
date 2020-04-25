package study.chapter03;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter03
 * @data 2020/4/24 15:53
 */

@FunctionalInterface
/**函数式接口注解，内部只有一个抽象类*/
public interface IMessage {
    public void message(String msg);

}
