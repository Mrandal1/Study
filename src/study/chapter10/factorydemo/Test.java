package study.chapter10.factorydemo;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter10.factorydemo
 * @data 2020/5/4 11:12
 */
public class Test {
    public static void main(String[] args) {
        IMessage message=Factory.getInstance("study.chapter10.factorydemo.CloudMessageImpl",IMessage.class) ;
        message.sendMessage();
        IService service=Factory.getInstance("study.chapter10.factorydemo.HouseServiceImpl",IService.class);
        service.service();
    }
}
