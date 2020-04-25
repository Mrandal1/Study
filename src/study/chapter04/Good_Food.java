package study.chapter04;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter04
 * @data 2020/4/25 16:58
 */
public class Good_Food implements IGood {
    private String name;
    private double price;

    public Good_Food(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Good_Food{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
