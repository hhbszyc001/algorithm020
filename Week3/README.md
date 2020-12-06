## 学习笔记
1. 这周时间花了不少，但是对于回溯和分治以及递归的理解都不够，需要再回去看看。
2. 因为较难，而自己又比较想快速掌握，心态不好，要改正。
3. 多敲，慢慢就会变好了吧


### 基础加强（基于BST实现的Map）
    public class BSTMap<K extends Comparable<K>, V> implements Map<K , V> {
    	private class Node{
        	public K key;
        	public V value;
        	Node left;
        	Node right;

        	public Node(K key , V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        	}
   	 	}

    	private Node root;
    	private int size;

    	public BSTMap() {
        	root = null;
        	size = 0;
    	}

    	@Override
    	public int getSize(){
        	return size;
    	}

    	@Override
    	public boolean isEmpty(){
        	return size == 0;
    	}

    	@Override
    	public void add(K key,V value){
        	root = add(root , key , value);
    	}
    	private Node add(Node node , K key , V value){
        	if (node == null){
            	size ++;
            	return new Node(key,value);
        	}
        	if(key.compareTo(node.key)<0){
            	node.left = add(node.left, key, value);
        	}else if(key.compareTo(node.key) > 0) {
            	node.right = add(node.right , key, value);
        	}
        	else
            	node.value = value;
        	return node;
    	}
    	public Node getNode(Node node , K key){
        	if(node == null)
            	return null;
        	if(key.compareTo(node.key) == 0)
            return node;
        	else if(key.compareTo(node.key) < 0)
            	return getNode(node.left,key);
        	else
            	return getNode(node.right,key);
    	}

	    @Override
	    public boolean contains(K key){
	        return getNode(root , key) != null;
	    }

	    @Override
	    public V get(K key){
	        Node node = getNode(root, key);
	        return node == null ? null : node.value;
	    }

	    @Override
	    public void set(K key , V value){
	        Node node = getNode(root , key);
	        if(node == null)
	            throw new IllegalArgumentException("key is not exists");
	        node.value = value;
	    }

	    private Node maximum(Node node){
	        if(node.right == null)
	            return node;
	        return maximum(node.right);
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

	    //删除二分搜索树实现的Map中的任意值
	    public V remove(K key){
	        Node node = remove(root,key);
	        return node.value;
	    }

	    private Node remove(Node node , K key){
	        if(node == null) return null;
	        if(key.compareTo(node.key) < 0){
	            return remove(node.left , key);
	        }
	        if(key.compareTo(node.key) > 0){
	            return remove(node.right , key);
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
