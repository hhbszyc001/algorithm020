##学习笔记
### 感想
1. 总体感觉良好，逐渐有那种说不清，道不明的感觉，那是一种快感。
2. 但是也发现一个很大的问题，java基础不牢，得赶快解决，现在正在寻求解决的办法，尽快实施。
3. 听课遍数不够，对于一些知识点没有记笔记，后检查又得看视频，效率低。



### 额外实现BST底层

    import java.util.Deque;
    import java.util.LinkedList;
    import java.util.Stack;
    public class BST<E extends Comparable> {
    private class Node{
        public E e;
        Node left;
        Node right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

	//构造方法
    public BST() {
        root = null;
        size = 0;
    }
	
	//获取BST大小
    public int getSize(){
        return size;
    }

	//判断BST是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //向二分搜索树中添加元素
    public void add(E e){
        root = add(root , e);
    }
    //向以node为根的二分搜索树中插入元素，使用递归算法
    private Node add(Node node , E e){
        if (node == null){
            size ++;
            return new Node(e);
        }
        if(e.compareTo(node.e)<0){
            node.left = add(node.left , e);
        }else if(e.compareTo(node.e) > 0) {
            node.right = add(node.right , e);
        }
        return node;
    }


    //向二分搜索树中查找一个元素
    public boolean contains(E e){
        return contains(root, e);
    }
    private boolean contains(Node node , E e){
        if(node == null)
            return true;
        if (e.compareTo(node.e) == 0)
            return true;
        else if(e.compareTo(node.e) < 0)
            return contains(node.left , e);
        else
            return contains(node.right , e);
    }

    //前序遍历一棵搜索二叉树
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node node){
        //1.递归终止条件
        if (node == null)
            return;
        //2.递归结构
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }
    //前序非递归遍历二分搜索树
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);
            if(cur.right != null)
                stack.push(cur.right);
            if(cur.left != null)
                stack.push(cur.left);
        }
    }

    //中序遍历一棵二分搜索树
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node node){
        if(node == null) return;//终止条件

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //后序遍历一棵二分搜索树
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node node){
        if(node == null) return;
         postOrder(node.left);
         postOrder(node.right);
        System.out.println(node.e);
    }

    //二分搜索树的层序遍历，BFS,借助队列数据结构
    public void levelOrder(){
        Deque<Node> deque = new LinkedList<>();
        deque.push(root);
        while (deque != null){
            Node cur = deque.poll();
            System.out.println(cur.e);
            if(cur.left != null)
                deque.push(cur.left);
            if(cur.right != null)
                deque.push(cur.right);
        }

        /*Deque<Node> deque1 = new LinkedList<>();
        deque1.push(root);
        while(!deque1.isEmpty()){
            Node poll = deque1.poll();
            System.out.println(poll.e);
            if(poll.left != null)
                deque1.push(poll.left);
            if(poll.right != null)
                deque1.push(poll.right);
        }*/

    }

    //查找二分搜索树中的最小元素
    public E minimum(){
        if(root == null)
            throw new IllegalArgumentException("failed");
        return minimum(root).e;
    }
    private Node minimum(Node node){
        if(node.left == null)
            return node;
        return minimum(node.left);
    }
    //查找二分搜索树中的最大元素
    public E maximum(){
        if(root == null)
            throw new IllegalArgumentException("failed");
        return maximum(root).e;
    }
    private Node maximum(Node node){
        if(node.right == null)
            return node;

        return maximum(node.right);
    }

    //删除二分搜素树中的最小节点，并返回最小节点的值
    public E removeMin(){
        E ret = minimum();
        removeMin(root); //删除最小节点
        return ret; //获得最小节点的值
    }

    //删除以node为根的二分搜索树中的最小元素，并返回删除节点后新的二分搜索树的根
    public Node removeMin(Node node){

        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    //删除二分搜索树中的最大节点，并返回最大节点的值
    public E removeMax(){
        E ret = maximum();
        removeMax(root);
        return ret;
    }
    private Node removeMax(Node node){
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    //删除二分搜索树中的任意值
    public void remove(E e){
        root = remove(root,e);
    }
    private Node remove(Node node , E e){
        if(node == null) return null;
        if(e.compareTo(node.e) < 0){
            return remove(node.left , e);
        }
        if(e.compareTo(node.e) > 0){
            return remove(node.right , e);
        }else{  //  e.compareTo(node.e) = 0
            //左子树为空
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            //右子树为空
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            //左右子树都存在，使用后继元素替代
            Node successor = maximum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        	}
    	}
    }




