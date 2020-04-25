package study.chapter04;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter04
 * @data 2020/4/24 18:11
 */
public interface ILink<E> {
    /**
     * 实现Node节点的增加
     *
     * @param e 节点数据
     */
    void add(E e);

    /**
     * 获取链表数据个数
     *
     * @return 数据个数
     */
    int size();

    /**
     * 判断空链表
     *
     * @return 是否为空
     */
    boolean isEmpty();

    /**
     * 返回数组数据
     *
     * @return Object[]
     */
    Object[] toArray();

    /**
     * 根据索引取得链表数据
     *
     * @param index 链表索引
     * @return data
     */
    E getData(int index);

    /**
     * 修改指定索引位数据
     *
     * @param index 指定索引
     * @param data  目标数据信息
     */
    void setData(int index, E data);

    /**
     * 判断指定数据是否存在
     *
     * @param data 指定数据
     * @return boolean
     */
    boolean contains(E data);

    /**
     * 删除指定数据
     *
     * @param data 指定数据
     */
    void remove(E data);

    /**
     *清空链表
     */
    void clean();
}
