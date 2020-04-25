package study.chapter04;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter04
 * @data 2020/4/25 16:40
 */
public interface ICashier {
    /**
     * 计算所有商品的价格
     * @return double price
     */
    double getAllPrice();

    /**
     * 商品总数
     * @return
     */
    int allCount();


}
