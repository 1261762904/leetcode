package org.example.hot100.子串;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数。
 * 子数组是数组中元素的连续非空序列。
 * @author yixin
 * @since 2024/7/12
 */
public class 和为K的子数组 {
    public static void main(String[] args) {
        System.out.println(new 和为K的子数组().subarraySumNew(new int[]{1,-4,1,-3,1,1}, -2));
    }

    /**
     * 定义左右指针
     * 两个循环，外层左指针，从0开始，判断是否等于k；
     *      定义sum=nums[left]
     *      内层右指针+1，从左指针开始
     *          sum+=nums[right]
     *          判断sum是否等于k
     */
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        for (int left = 0; left < nums.length; left++) {
            if(nums[left]==k)result++;
            int sum = nums[left];
            for (int right = left+1; right < nums.length; right++) {
                sum += nums[right];
                if(sum==k)result++;
            }
        }
        return result;
    }

    /**
     * 定义 map，key：存所有差值sum-k，value：数量
     * 对于nums.length为1并且k!=nums[0] 可以直接返回
     * 初始化map （0，1） 代表差值为0的有一个，本身
     * 遍历nums
     *     添加sum，判断是否map中是否包含差值，如果包含则count+map.value
     *     然后sum塞入nums，有值的+1
     */
    public int subarraySumNew(int[] nums, int k) {
        Map<Integer, Integer> pre = new HashMap<>();
        int sum = 0;
        int count = 0;
        if (nums.length == 1 && k != nums[0]) {
            return count;
        }
        pre.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // 判断是否有差值为k
            if (pre.containsKey(sum - k)) {
                count += pre.get(sum - k);
            }
            // 将前缀和存入MAP中
            if (pre.containsKey(sum)) {
                pre.put(sum, pre.get(sum) + 1);
            } else {
                pre.put(sum, 1);
            }
//            pre.put(sum,pre.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
