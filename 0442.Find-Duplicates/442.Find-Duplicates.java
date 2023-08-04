
// 置换法，先将数据放入到对应位置nums[i] - 1放入到i位置，既然数字是[1,n]说明如果有数字有两个的话会占用别的数字的位置。最后循环一遍，找出占用了的别人位置的数字即可
// class Solution {
//     public List<Integer> findDuplicates(int[] nums) {
//         List<Integer> duplicateList = new ArrayList<>();
//         for(int i = 0; i < nums.length; i++){
//             while(nums[i]-1 != i){
//                 if(nums[nums[i] - 1] == nums[i]) break;
//                 swap(nums, nums[i] - 1, i);
//             }
//         }

//         for(int i = 0; i < nums.length; i++){
//             if(nums[i] != i + 1){
//                 duplicateList.add(nums[i]);
//             }
//         }
//         return duplicateList;
//     }

//     public void swap(int[] nums, int index1, int index2){
//         int temp = nums[index1];
//         nums[index1] = nums[index2];
//         nums[index2] = temp;
//     }
// }

// 标记法， 将nums[i] - 1位置的数标为负数，
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicateList = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0){
                duplicateList.add(index + 1);
            }else{
                nums[index] = -nums[index];
            }
        }
        return duplicateList;
    }
}