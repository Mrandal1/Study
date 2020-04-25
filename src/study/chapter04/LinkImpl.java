package study.chapter04;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter04
 * @data 2020/4/24 17:56
 */

/**
 * 单向链表功能类
 */
class LinkImpl<E> implements ILink<E> {

    /**
     * 用于封装一个节点类
     */
    class Node {
        private E data;
        private Node next;

        public Node(E data) {
            this.data = data;
        }

        /**
         * 保存新的Node数据
         */
        public void addNode(Node newNode) {
            /*保存当前节点*/
            if (this.next == null) {
                this.next = newNode;

            } else {
                this.next.addNode(newNode);
            }
        }

        /**
         * 保存数据到临时数组
         */
        public void toArrayNode() {
            LinkImpl.this.returnData[LinkImpl.this.foot++] = this.data;
            if (this.next != null) {
                this.next.toArrayNode();
            }
        }

        /**
         * 获取节点数据
         */
        public E getNode(int index) {
            if (LinkImpl.this.foot++ == index) {
                return this.data;
            }
            return this.next.getNode(index);
        }

        /**
         * 修改数据节点
         */
        public void setNodeData(int index, E data) {
            if (LinkImpl.this.foot++ == index) {
                this.data = data;
            } else {
                this.next.setNodeData(index, data);
            }
        }

        /**
         * 判断数据
         */
        public boolean containsNode(E data) {
            if (this.data.equals(data)) {
                return true;
            } else {
                if (this.next == null) {
                    return false;
                } else {
                    return this.next.containsNode(data);
                }

            }
        }

        /**
         * 删除节点
         */
        public void removeNode(Node pre, E data) {
            if (this.data.equals(data)) {
                pre.next = this.next;
            } else {
                if (this.next != null) {
                    this.next.removeNode(this, data);
                }
            }
        }
    }

    /**
     * 定义根节点
     */
    private Node root;
    /**
     * 链表计数
     */
    private int count;
    /**
     * 数组索引
     */
    private int foot;
    /**
     * 返回数据
     */
    private Object[] returnData;

    @Override
    public void add(E e) {
        /*保存的节点为null直接结束操作*/
        if (e == null) {
            return;
        }
        /*创建一个新的节点*/
        Node newNode = new Node(e);
        /*当前没有根节点时，新节点为根节点*/
        if (this.root == null) {
            this.root = newNode;
        } else {
            /*添加新节点*/
            this.root.addNode(newNode);
        }
        this.count++;
        /*Node temp=this.root;
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;*/
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
        /*return this.count==0;*/
    }

    @Override
    public Object[] toArray() {
        if (this.isEmpty()) {
            return null;
        }
        this.foot = 0;

        this.returnData = new Object[this.count];
        this.root.toArrayNode();
        return this.returnData;
        /*Node temp = this.root;
        while (temp != null) {
            returnData[index++]=temp.data;
            temp = temp.next;

        }
        return this.returnData;*/
    }

    @Override
    public E getData(int index) {
        if (index < 0 || index >= this.count) {
            return null;
        }
        this.foot = 0;
        return this.root.getNode(index);
       /* Object[] ob =this.toArray();
        if (index<0||index>=ob.length){
            return null;
        }
        return (E)ob[index];*/

    }

    @Override
    public void setData(int index, E data) {
        if (index < 0 || index >= this.count) {
            System.out.println("不符合要求的index");

        }
        this.foot = 0;
        this.root.setNodeData(index, data);

    }

    @Override
    public boolean contains(E data) {
        if (data == null) {
            return false;
        }
        return this.root.containsNode(data);
    }

    @Override
    public void remove(E data) {
        if (this.contains(data)) {
            if (this.root.data.equals(data)) {
                this.root = this.root.next;
            } else {
                this.root.next.removeNode(this.root, data);
            }
            this.count--;
        }
    }

    @Override
    public void clean() {
        this.root=null;
        this.count=0;
    }
}