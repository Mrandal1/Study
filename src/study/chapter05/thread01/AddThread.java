package study.chapter05.thread01;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter05.Thread01
 * @data 2020/4/27 16:00
 */
public class AddThread implements Runnable {
    private Resource re;

    public AddThread(Resource re) {
        this.re = re;
    }

    @Override
    public void run() {
        for (int x = 0; x < 50; x++) {
            try {
                this.re.add();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
