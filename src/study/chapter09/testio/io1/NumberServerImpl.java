package study.chapter09.testio.io1;

import study.chapter09.testio.InputUtil;

import java.util.Arrays;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter09.testio.io1
 * @data 2020/5/3 17:25
 */
public class NumberServerImpl implements INumberServer {
    @Override
    public int[] stat(int count) {
        int[] result=new int[2];
        int[] data=new int[count];
        for (int i=0;i<count;i++){
            data[i]= InputUtil.getInt("请输入第"+(i+1)+"个数字：");
        }
        Arrays.sort(data);
        result[0]=data[0];
        result[1]=data[count-1];
        return result;
    }
}
