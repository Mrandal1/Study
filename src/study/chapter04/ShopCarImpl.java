package study.chapter04;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter04
 * @data 2020/4/25 16:30
 */
public class ShopCarImpl implements IShopCar {
    ILink<IGood> allGood = new LinkImpl<>();

    public ShopCarImpl() {
        super();
    }

    @Override
    public void add(IGood good) {
        this.allGood.add(good);
    }

    @Override
    public void del(IGood good) {
        this.allGood.remove(good);

    }

    @Override
    public Object[] getAll() {
        return this.allGood.toArray();
    }
}
