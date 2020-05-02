package study.chapter08.demo.demo7;

import java.util.Arrays;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter08.demo.demo6
 * @data 2020/5/2 13:59
 */
public class Demo7 {
    public static void main(String[] args) {
        String input ="学生A:21:99|学生B:31:59|学生C:15:89|学生D:16:38|学生F:19:77";
        String[] result=input.split("\\|");
        Student[] stu=new Student[result.length];
        for (int x=0;x<result.length;x++){
            String[] temp=result[x].split(":");
            stu[x]=new Student(temp[0],Integer.parseInt(temp[1]),Double.parseDouble(temp[2]));
        }
        Arrays.sort(stu);
        System.out.println(Arrays.toString(stu));
    }
}
