package study.chapter08.treedemo;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter08.treedemo
 * @data 2020/5/1 12:53
 */
public class BinaryTree<T extends Comparable<T>> {
    private class Node {
        private Comparable<T> data;
        private Node parent;
        private Node left;
        private Node right;

        private Node(Comparable<T> data) {
            this.data = data;
        }

        public void addNode(Node newNode) {
            /*传入节点小于当前节点*/
            if (newNode.data.compareTo((T) this.data) <= 0) {
                /*当前左子树为空*/
                if (this.left == null) {
                    this.left = newNode;
                    newNode.parent = this;
                } else {
                    /*递归判断*/
                    this.left.addNode(newNode);
                }
            } else {
                /*当前右子树为空*/
                if (this.right == null) {
                    this.right = newNode;
                    newNode.parent = this;
                } else {
                    /*递归判断*/
                    this.right.addNode(newNode);
                }
            }
        }

        /*中序遍历数据节点*/
        public void toArrayNode() {
            /*左子树*/
            if (this.left != null) {
                this.left.toArrayNode();
            }
            returnData[foot++] = this.data;
            /*右子树*/
            if (this.right != null) {
                this.right.toArrayNode();
            }
        }

        public boolean containsNode(Comparable<T> data) {
            if (this.data.compareTo((T) data) == 0) {
                return true;
            } else if (this.data.compareTo((T) data) < 0) {
                if (this.left != null) {
                    return this.left.containsNode(data);
                } else {
                    return false;
                }
            } else {
                if (this.right != null) {
                    return this.right.containsNode(data);
                } else {
                    return false;
                }
            }
        }

        public Node getRemoveNode(Comparable<T> data) {
            if (this.data.compareTo((T) data) == 0) {
                return this;
            } else if (this.data.compareTo((T) data) < 0) {
                if (this.left != null) {
                    return this.left.getRemoveNode(data);
                } else {
                    return null;
                }
            } else {
                if (this.right != null) {
                    return this.right.getRemoveNode(data);
                } else {
                    return null;
                }
            }
        }
    }

    /**
     * 定义根节点
     */
    private Node root;
    /**
     * 保存个数
     */
    private int count;
    /**
     * 定义操作脚标
     */
    private int foot;
    /**
     * 返回数据
     */
    private Object[] returnData;

    /**
     * 保存节点
     *
     * @param data
     */
    public void add(Comparable<T> data) {
        if (data == null) {
            throw new NullPointerException("保存的数据不能为空");
        }
        Node newNode = new Node(data);

        if (this.root == null) {
            this.root = newNode;
        } else {
            this.root.addNode(newNode);


        }
        this.count++;
    }

    /**
     * @return 数据结构中所有数据
     */
    public Object[] toArray() {
        if (this.count == 0) {
            return null;
        }
        this.returnData = new Object[count];
        this.foot = 0;
        this.root.toArrayNode();
        return this.returnData;
    }

    public boolean contains(Comparable<T> data) {
        if (count == 0) {
            return false;
        }
        return this.root.containsNode(data);
    }

    /**
     * 删除数据
     *
     * @param data
     */
    public void remove(Comparable<T> data) {
        if (this.root == null) {
            return;
        } else {
            /*删除根节点*/
            if (this.root.data.compareTo((T) data) == 0) {
                Node moveNode = this.root.right;
                while (moveNode.left != null) {
                    moveNode = moveNode.left;
                }
                moveNode.left = this.root.left;
                moveNode.right = this.root.right;
                moveNode.parent.left = null;
                this.root = moveNode;

            } else {
                Node removeNode = this.root.getRemoveNode(data);
                if (removeNode != null) {
                    /*要删除的是没有子节点的节点*/
                    if (removeNode.left == null && removeNode.right == null) {
                        if (removeNode.parent.left != null && removeNode.parent.right != null) {
                            if (removeNode.parent.left == removeNode) {
                                removeNode.parent.left = null;
                            } else {
                                removeNode.parent.right = null;
                            }
                        } else {
                            removeNode.parent.left = null;
                            removeNode.parent.right = null;
                        }
                        removeNode.parent = null;

                    }

                    if (removeNode.left != null && removeNode.right == null) {
                        /*要删除的是只有左节点的节点*/
                        removeNode.parent.left = removeNode.left;
                        removeNode.left.parent = removeNode.parent;
                    } else if (removeNode.left == null && removeNode.right != null) {
                        /*要删除的是只有左节点的节点*/
                        removeNode.parent.left = removeNode.right;
                        removeNode.right.parent = removeNode.parent;
                    } else {
                        /*要删除的是有左右节点的节点  首先要找到右节点中最左边的节点*/
                        Node moveNode = removeNode.right;
                        while (moveNode.left != null) {
                            moveNode = moveNode.left;
                        }
                        removeNode.parent.left = moveNode;
                        moveNode.parent.left = null;
                        moveNode.parent = removeNode.parent;
                        moveNode.right = removeNode.right;
                        moveNode.left = removeNode.left;


                    }

                }
            }
            count--;
        }
    }
}
