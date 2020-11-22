//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明： 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出：[1,2,2,3,5,6] 
//
// 
//
// 提示： 
//
// 
// -10^9 <= nums1[i], nums2[i] <= 10^9 
// nums1.length == m + n 
// nums2.length == n 
// 
// Related Topics 数组 双指针 
// 👍 693 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
//解法1，使用java提供的已有方法

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1);
    }
}


//解法2，使用一个辅助数组
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1,0,nums1_copy,0,m);
        int p1 = 0;
        int p2 = 0;
        int p = 0 ;
        while(p1 < m && p2 < n){
            nums1[p++] = nums1_copy[p1] > nums2[p2] ? nums2[p2++] : nums1_copy[p1++];
        }
        if(p1 < m) System.arraycopy(nums1_copy,p1,nums1,p,m+n-p);
        if(p2 < n) System.arraycopy(nums2,p2,nums1,p,m+n-p);
    }
}

//leetcode submit region end(Prohibit modification and deletion)
