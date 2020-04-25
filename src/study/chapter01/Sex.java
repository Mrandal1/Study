package study.chapter01;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter01
 * @data 2020/4/23 18:57
 */


public enum Sex {//性别
    MALE("男"),FEMALE("女");
    //实例化对象
    private String title;

    Sex(String sex) {
        this.title = sex;
    }

    @Override
    public String toString() {//直接引用类时将输出toString()内容
        return this.title;
    }
}
