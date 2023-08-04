/**
 * 方法一：哈希集
 * 思路与算法
 *
 * 如果一张卡片正反两面有相同的数字，那么这张卡片无论怎么翻转，正面都是这个数字，这个数字即不能是最后所选的数字 x。
 *
 * 按照这个思路，我们首先遍历所有卡片，如果卡片上的两个数字相同，则加入哈希集合 same 中，除此集合外的所有数字，都可以被选做 x，
 * 我们只需要再次遍历所有数字，找到最小值即可。
 *
 * 最后，我们返回找到的最小值，如果没有则返回 0。
 *
 */

class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> same = new HashSet();
        for (int i = 0; i < fronts.length; i++){
            if(fronts[i] == backs[i]){
                same.add(fronts[i]);
            }
        }

        int minRs = 3000;
        for(int x : fronts){
            if(x < minRs && !same.contains(x)){
                minRs = x;
            }
        }

        for(int x : backs){
            if(x < minRs && !same.contains(x)){
                minRs = x;
            }
        }

        return minRs == 3000? 0 : minRs;
    }
}