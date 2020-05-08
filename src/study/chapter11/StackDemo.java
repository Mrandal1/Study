package study.chapter11;

import java.util.Stack;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter11
 * @data 2020/5/8 15:38
 */
public class StackDemo {
    public static void main(String[] args) {
        /*
        * java中的栈结构定义  public class Stack<E> extends Vector<E>
        *        1 入栈  public E push(E item)
        *        2 出栈  public synchronized E pop()
        * 空栈会抛出空栈异常
        *
        *
        * */

        Stack<Integer> stack=new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
