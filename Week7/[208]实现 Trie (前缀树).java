//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。 
//
// 示例: 
//
// Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");   
//trie.search("app");     // 返回 true 
//
// 说明: 
//
// 
// 你可以假设所有的输入都是由小写字母 a-z 构成的。 
// 保证所有输入均为非空字符串。 
// 
// Related Topics 设计 字典树 
// 👍 494 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Trie {
    public class TrieNode{//每个节点最多有26个不同的字母
        private boolean isEnd;
        private TrieNode[] next;

        public TrieNode(){
            isEnd = false;
            next = new TrieNode[26];
        }
    }
    private TrieNode root;//根节点

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0 ; i < word.length() ; i++){
            int index = word.charAt(i) - 'a';
            if(cur.next[index] == null){
                cur.next[index] = new TrieNode();
            }
            cur = cur.next[index];
        }
        cur.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0 ; i < word.length() ; i++){
            int index = word.charAt(i) - 'a';
            if(cur.next[index] == null){
                return false;
            }
            cur = cur.next[index];
        }
        return cur.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i = 0 ; i < prefix.length() ; i++){
            int index = prefix.charAt(i) - 'a';
            if(cur.next[index] == null){
                return false;
            }
            cur = cur.next[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)
