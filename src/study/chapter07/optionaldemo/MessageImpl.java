package study.chapter07.optionaldemo;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter07.optionaldemo
 * @data 2020/4/30 13:10
 */
public class MessageImpl implements IMessage {
    @Override
    public String getContent() {
        return "Content";
    }
}
