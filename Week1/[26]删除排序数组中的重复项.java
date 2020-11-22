//给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。 
//
// 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。 
//
// 
//
// 示例 1: 
//
// 给定数组 nums = [1,1,2], 
//
//函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 
//
//你不需要考虑数组中超出新长度后面的元素。 
//
// 示例 2: 
//
// 给定 nums = [0,0,1,1,1,2,2,3,3,4],
//
//函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
//
//你不需要考虑数组中超出新长度后面的元素。
// 
//
// 
//
// 说明: 
//
// 为什么返回数值是整数，但输出的答案是数组呢? 
//
// 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。 
//
// 你可以想象内部操作如下: 
//
// // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
//int len = removeDuplicates(nums);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
// 
// Related Topics 数组 双指针 
// 👍 1720 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

//使用两个指针i和j,i为慢指针，j为快指针，只要nums[i]=nums[j] ，就增加j,直到出现nums[i] != nums[j]
//此时，i++,nums[j] 赋值给nums[i]，直到j指针走到数组末尾
//时间复杂度为O(n)
//空间复杂度为O(1)
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length ==0 )return 0; //对传入的数组进行判断，不满足条件直接返回0；

        int i = 0;//慢指针从0开始
        //快指针从1开始，比较nums[i]和nums[j]，如果不相同，则将nums[j]赋值给nums[i]的下一位即可。注意临界值，j可以到达数组的最后一个位置，索引为length-1
        for(int j = 1; j < nums.length; j++){
            if(nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1; //返回值为数组长度
    }
}
//leetcode submit region end(Prohibit modification and deletion)
