package study.chapter10;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter10
 * @data 2020/5/4 13:11
 */
public abstract class AbsPerson {
    private int absint;
    public String absstr;
    public AbsPerson(){}
    public AbsPerson(String str,int age){}
    abstract void go();
}
