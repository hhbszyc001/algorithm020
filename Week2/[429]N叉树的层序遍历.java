//给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其层序遍历: 
//
// [
//     [1],
//     [3,2,4],
//     [5,6]
//]
// 
//
// 
//
// 说明: 
//
// 
// 树的深度不会超过 1000。 
// 树的节点总数不会超过 5000。 
// Related Topics 树 广度优先搜索 
// 👍 120 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        //此题主要考察树的广度优先遍历，可以使用辅助队列完成
        List<List<Integer>> result = new ArrayList<>();
        //1. 先对树进行一个初步判断，若为空，直接返回
        if(root == null) return result;
        //2.利用队列先进先出的特点，
        Deque<Node> deque = new LinkedList<>();
        deque.add(root);
        //3.当队列不为空的情况下，
        while (!deque.isEmpty()){先将根节点压入队列
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < deque.size(); i++) {
                Node curNode = deque.poll();
                list.add(curNode.val);
                deque.addAll(curNode.children);
            }
            result.add(list);
        }
        return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
