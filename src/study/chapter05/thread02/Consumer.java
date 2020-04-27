package study.chapter05.thread02;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter05.thread02
 * @data 2020/4/27 16:55
 */
public class Consumer implements Runnable {
    private Resource resource;

    public Consumer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int x = 0; x < 50; x++) {

            try {
                this.resource.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
