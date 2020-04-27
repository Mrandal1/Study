package study.chapter05.thread02;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter05.thread02
 * @data 2020/4/27 16:40
 */
public class Computer {
    private static int count=0;
    private String name;
    private double price;

    public Computer(String name, double price) {
        this.name = name;
        this.price = price;
        count++;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "count=" + count +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
