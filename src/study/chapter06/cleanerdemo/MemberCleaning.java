package study.chapter06.cleanerdemo;


import java.lang.ref.Cleaner;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter06.cleanerdemo
 * @data 2020/4/28 15:18
 */
public class MemberCleaning implements AutoCloseable {

    /**
     * 创建一个清除处理
     */
    private static final Cleaner CLEANER = Cleaner.create();
    private Member member;
    private Cleaner.Cleanable cleanable;

    public MemberCleaning() {
        this.member = new Member();
        /*
         * 注册使用对象
         */
        this.cleanable = CLEANER.register(this, this.member);
    }

    @Override
    public void close() throws Exception {
        /*
         * 启动多线程
         */
        this.cleanable.clean();
    }
}
