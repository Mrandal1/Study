package study.chapter10.factorydemo;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter10.factorydemo
 * @data 2020/5/4 12:43
 */
public class Singleton {
    private static volatile Singleton instance = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
