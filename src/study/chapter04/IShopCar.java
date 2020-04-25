package study.chapter04;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter04
 * @data 2020/4/25 16:25
 */
public interface IShopCar {
    /**
     * 添加商品
     *
     * @param good 商品
     */
    void add(IGood good);

    /**
     * 删除商品
     *
     * @param good 商品
     */
    void del(IGood good);

    /**
     * 获取购物车中所有信息
     *
     * @return Object[]
     */
    Object[] getAll();

}
