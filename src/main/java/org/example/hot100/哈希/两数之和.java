package org.example.hot100.哈希;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/two-sum/description/?envType=study-plan-v2&envId=top-100-liked
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 *
 * @author yixin
 * @since 2024/7/3
 */
public class 两数之和 {
    public static void main(String[] args) {
        new 两数之和().twoSum(new int[]{2,7,11,15},9);
    }

    /**
     * 定义map key：num，value为index
     *遍历nums
     *  判断target-nums在map中是否存在
     *      存在：break 返回
     *      不存在：put
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if(map.containsKey(diff)){
                result[0] = i;
                result[1] = map.get(diff);
            }else{
                map.put(nums[i],i);
            }
        }
        return result;
    }
}
