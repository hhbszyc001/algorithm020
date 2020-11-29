//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 527 👎 0


import java.lang.reflect.Array;
import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0)return new ArrayList();
        Map<String,List> map = new HashMap<String,List>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String s1 = String.valueOf(chars);
            if(!map.containsKey(s1))
                map.put(s1,new ArrayList());
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }*/
    public List<List<String>> groupAnagrams(String[] strs){
        if(strs.length == 0) return new ArrayList();

        Map<String, List> map = new HashMap<>();
        for (String s:strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if(!map.containsKey(key))
                map.put(key,new ArrayList());
            map.get(key).add(s);

        }
        return new ArrayList(map.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
