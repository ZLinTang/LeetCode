package com.zlin.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZLin
 * @since 2023/8/2
 */
@SuppressWarnings("unused")
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> numIndexMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            // 相同数据已经存在，则需要排除target是否是相同的两数之和
            if(numIndexMap.containsKey(nums[i])){
                if(target - nums[i] == nums[i]){
                    result[0] = numIndexMap.get(nums[i]);
                    result[1] = i;
                    return result;
                }
            }else{
                // 若map中还没有，则需要判断，target和当前数的差在Map中是否已存在
                if(numIndexMap.containsKey(target - nums[i])){
                    result[0] = numIndexMap.get(target - nums[i]);
                    result[1] = i;
                }else{
                    numIndexMap.put(nums[i], i);
                }
            }
        }
        return result;
    }
}
