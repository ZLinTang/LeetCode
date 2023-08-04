
/**
 分组 + 哈希
 */
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        int zeroSumCount = 0;

        // 将nums1,nums2为一组，nums1[i],nums2[j]的和sum,存入哈希表，key为sum，value为次数
        Map<Integer, Integer> sumCountMap = new HashMap<>();
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                int sum = nums1[i] + nums2[j];
                sumCountMap.put(sum, sumCountMap.getOrDefault(sum, 0) + 1);
            }
        }

        for(int m = 0; m < nums3.length; m++){
            for(int n = 0; n < nums4.length; n++){
                int sum = nums3[m] + nums4[n];
                if(sumCountMap.containsKey(-sum)){
                    zeroSumCount += sumCountMap.get(-sum);
                }
            }
        }

        return zeroSumCount;
    }
}