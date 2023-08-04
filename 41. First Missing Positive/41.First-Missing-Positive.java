
/**
 空间时间度：O(n) 不满足题目要求
 */
// class Solution {
//     public int firstMissingPositive(int[] nums) {
//         Map<Integer, Integer> numIndexMap = new HashMap<>();
//         for(int i = 0; i < nums.length; i++){
//             numIndexMap.put(nums[i], i);
//         }

//         // 只需要遍历 1~nums.length + 1即可，如果前面的每一个数都存在，那么输出nums.length + 1
//         for(int i = 1; i <= nums.length + 1; i++){
//             if(!numIndexMap.containsKey(i)){
//                 return i;
//             }
//         }
//         return -1;
//     }
// }


/**
 优化：原地哈希
 空间复杂度：O(1)
 */
class Solution {
    public int firstMissingPositive(int[] nums) {

        // 通过交换将数据num[i]放入到num[i]-1的位置
        for(int i = 0; i < nums.length; i++){
            while(nums[i] > 0 && nums[i] <= nums.length && nums[i] - 1 != i){
                // 如果要交换的两个数相等则跳过
                if(nums[nums[i] - 1] == nums[i]) break;
                swap(nums, nums[i] - 1, i);
            }
        }

        //
        for(int i = 0; i < nums.length; i++){
            if(nums[i] - 1 != i){
                return i + 1;
            }
        }
        // 都正确则返回数组长度 + 1
        return nums.length + 1;
    }

    public void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}