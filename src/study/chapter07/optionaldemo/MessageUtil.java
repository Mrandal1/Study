package study.chapter07.optionaldemo;

import java.util.Optional;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter07.optionaldemo
 * @data 2020/4/30 13:09
 */
public class MessageUtil {
    private MessageUtil() {
    }

    /*通过Optional包装对象  不允许为空*/

    public static Optional<IMessage> getMessageA() {
        return Optional.of(new MessageImpl());
    }

    /*通过Optional包装对象  允许为空*/

    public static Optional<IMessage> getMessageB() {
        return Optional.ofNullable(null);
    }

    public static void useMessage(IMessage msg) {
        if (msg != null) {
            System.out.println(msg.getContent());
        }
    }
}
