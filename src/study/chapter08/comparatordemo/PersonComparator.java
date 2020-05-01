package study.chapter08.comparatordemo;

import java.util.Comparator;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter08.comparatordemo
 * @data 2020/5/1 12:05
 */
public class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getAge()-o2.getAge();
    }
}
