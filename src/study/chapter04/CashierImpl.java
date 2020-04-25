package study.chapter04;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter04
 * @data 2020/4/25 16:43
 */
public class CashierImpl implements ICashier {
    private IShopCar shopCar;

    public CashierImpl(IShopCar shopCar) {
        this.shopCar = shopCar;
    }


    @Override
    public double getAllPrice() {
        double allPrice = 0;
        Object[] ob = this.shopCar.getAll();
        for (Object temp : ob) {
            IGood good = (IGood) temp;
            allPrice += good.getPrice();

        }

        return allPrice;
    }

    @Override
    public int allCount() {
        return this.shopCar.getAll().length;
    }
}
