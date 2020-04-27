package study.chapter05.thread02;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter05.thread02
 * @data 2020/4/27 16:53
 */
public class Producer implements Runnable {
    private Resource resource;

    public Producer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int x=0;x<50;x++){
            try {
                this.resource.make();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
