package study.chapter04;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter04
 * @data 2020/4/24 17:39
 */
public class Test04 {
    public static void main(String[] args) {
        ILink<String> all = new LinkImpl<>();
        System.out.println(all.isEmpty());
        all.add("Happy");
        all.add("day");
        all.add("12");
        all.add("13");
        all.remove("day");
        all.add("14");
        all.setData(2, "aaaaa");
        System.out.println(all.isEmpty());
        System.out.println(all.size());

        Object[] ob = all.toArray();
        for (Object temp : ob) {
            System.out.println(temp);
        }
        System.out.println(all.getData(3));
        System.out.println(all.contains("day"));
        /*测试PetShop*/
        PetShop shop = new PetShop();
        shop.addPet(new Cat("a1", "黑色"));
        shop.addPet(new Dog("a3", "黑色"));
        shop.addPet(new Cat("a7", "白色"));
        shop.addPet(new Dog("a2", "白色"));
        Object[] re = shop.search("白色").toArray();
        for (Object temp : re) {
            System.out.println(temp);
        }
        /*测试Good_Shop*/
        /*向购物车中加入或拿走商品*/
        IShopCar car = new ShopCarImpl();
        car.add(new Good_Book("图书1", 23.32));
        car.add(new Good_Book("图书2", 26.0));
        car.add(new Good_Book("图书3", 66));
        car.add(new Good_Food("面包", 10));
        /*选择结账收银点*/
        ICashier cashier = new CashierImpl(car);
        System.out.println("----------统计商品----------");
        for (Object temp : car.getAll()) {
            IGood good = (IGood) temp;
            System.out.println(temp);
        }
        System.out.println("商品总数：" + cashier.allCount() + "\t总计" + cashier.getAllPrice());

    }


}
