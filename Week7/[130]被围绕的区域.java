//给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。 
//
// 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。 
//
// 示例: 
//
// X X X X
//X O O X
//X X O X
//X O X X
// 
//
// 运行你的函数后，矩阵变为： 
//
// X X X X
//X X X X
//X X X X
//X O X X
// 
//
// 解释: 
//
// 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被
//填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 442 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int m ;
    private int n;
    public void solve(char[][] board) {
        //合法性判断
        if(board == null || board.length == 0) return;

        m = board.length;
        n = board[0].length;

        //使用一个虚拟节点，边界上为O的所有节点的父节点为此虚拟节点
        UnionFind uf = new UnionFind(m * n + 1);
        int dummy = uf.parent[m*n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(board[i][j] == 'O'){
                    if(i == 0 || j == 0 || i == m-1 || j == n-1){
                        uf.union(dummy , index(i , j));
                    }
                    if(i > 0 && board[i-1][j] == 'O'){
                        uf.union(index(i-1,j),index(i,j));
                    }
                    if(i < m-1 && board[i+1][j] == 'O'){
                        uf.union(index(i+1,j),index(i,j));
                    }
                    if(j > 0 && board[i][j-1] == 'O'){
                        uf.union(index(i,j-1),index(i,j));
                    }
                    if(j < n-1 && board[i][j+1] == 'O'){
                        uf.union(index(i,j+1),index(i,j));
                    }
                }
            }
        }
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(uf.isConnected(index(i,j),dummy))
                    board[i][j] = 'O';
                else{
                    board[i][j] = 'X';
                }
            }
        }
    }
    int index(int a , int b){
        return a * n + b;
    }
}
class UnionFind{
    int[] parent;
    public UnionFind(int size){
        parent = new int[size];
        for(int i = 0 ; i < size ; i++){
            parent[i] = i;
        }
    }
    private int find(int p){
        while(p != parent[p]){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    void union(int p , int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot) return;
        parent[pRoot] = qRoot;
    }
    boolean isConnected(int p , int q){
        return find(p) == find(q);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
