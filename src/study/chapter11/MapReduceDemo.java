package study.chapter11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.DoubleSummaryStatistics;
import java.util.List;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter11
 * @data 2020/5/8 20:12
 */
public class MapReduceDemo {
    public static void main(String[] args) {
        /*
         * MapReduce模型
         *           Map--数据处理部分
         *           Reduce--分析部分
         *
         *
         *
         *
         * */

        /*使用流分析数据*/
        /*将数据保存至List集合中*/
        List<Order> list = new ArrayList<>();
        Collections.addAll(list, new Order("商品A", 100.9, 20),
                new Order("奔驰车", 50.5, 238),
                new Order("商品C", 560.9, 455),
                new Order("奥迪车", 123.0, 88),
                new Order("商品E", 4312.9, 12),
                new Order("大众车", 4312.9, 12)
        );

        /*定义规则进行分析  最后通过<统计摘要类summaryStatistics> 输出结果集*/
        DoubleSummaryStatistics stats = list.stream().filter(ele -> ele.getName().contains("车"))
                .mapToDouble(o -> o.getPrice() * o.getAmount()).summaryStatistics();
        System.out.println("购买数量" + stats.getCount());
        System.out.println("购买总价" + stats.getSum());
        System.out.println("平均花费" + stats.getAverage());
        System.out.println("最高花费" + stats.getMax());

    }
}

class Order {
    private String name;
    private double price;
    private int amount;

    public Order(String name, double price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
