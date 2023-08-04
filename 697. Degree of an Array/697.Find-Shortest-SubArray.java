
/**
 简单易懂，但是时间复杂度太大，需要优化寻找第一次出现和最后出现的位置
 */
// class Solution {
//     public int findShortestSubArray(int[] nums) {
//         Map<Integer, Integer> numCountMap = new HashMap<>();

//         for(int num : nums){
//             numCountMap.put(num, numCountMap.getOrDefault(num, 0) + 1);
//         }
//         int maxCount = 0;
//         for(Map.Entry<Integer, Integer> entry : numCountMap.entrySet()){
//             maxCount = Math.max(maxCount, entry.getValue());
//         }

//         int minLength = nums.length;
//         for(Map.Entry<Integer, Integer> entry : numCountMap.entrySet()){
//             // 遍历找出所有频数同为最大的数
//             if(entry.getValue() == maxCount){
//                 // 从前往后找第一次出现的位置
//                 int index1 = 0;

//                 for(int i = 0; i < nums.length; i++){
//                     if(nums[i] == entry.getKey()){
//                         index1 = i;
//                         break;
//                     }
//                 }

//                 int index2 = 0;
//                 for(int j = nums.length - 1; j >= 0; j--){
//                     if(nums[j] == entry.getKey()){
//                         index2 = j;
//                         break;
//                     }
//                 }
//                 // index2 - index1 + 1 则为该数的最小连续数组长度
//                 minLength = Math.min(minLength, index2 - index1 + 1);

//             }
//         }

//         return minLength;
//     }
// }


/**
 优化寻找第一次出现和最后出现的位置， Map<num, int[出现次数，第一次出现位置，最后一次出现位置]>
 */
class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<Integer, int[]>();
        int n = nums.length;

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            }else{
                map.put(nums[i], new int[]{1, i, i});
            }
        }

        int maxNum = 0, minLen = 0;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] arr = entry.getValue();
            if (maxNum < arr[0]) {
                maxNum = arr[0];
                minLen = arr[2] - arr[1] + 1;
            } else if (maxNum == arr[0]) {
                if (minLen > arr[2] - arr[1] + 1) {
                    minLen = arr[2] - arr[1] + 1;
                }
            }
        }
        return minLen;
    }

}