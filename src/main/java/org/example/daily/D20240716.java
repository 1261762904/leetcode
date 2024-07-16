package org.example.daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode.cn/problems/find-common-elements-between-two-arrays/description/
 * 给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，它们分别含有 n 和 m 个元素。
 * 请你计算以下两个数值：
 * 统计 0 <= i < n 中的下标 i ，满足 nums1[i] 在 nums2 中 至少 出现了一次。
 * 统计 0 <= i < m 中的下标 i ，满足 nums2[i] 在 nums1 中 至少 出现了一次。
 * 请你返回一个长度为 2 的整数数组 answer ，按顺序 分别为以上两个数值。
 *
 * @author yixin
 * @since 2024/7/12
 */
public class D20240716 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new D20240716().findIntersectionValues(new int[]{2, 3, 2}, new int[]{1, 2})));
    }

    /**
     *  遍历nums1、nums2生成set
     *  再次遍历，判断set中是否存在
     */
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int[] result = new int[2];
        HashSet<Integer> integers1 = new HashSet<>();
        HashSet<Integer> integers2 = new HashSet<>();
        for (int num : nums1) {
            integers1.add(num);
        }
        for (int num : nums2) {
            integers2.add(num);
            if(integers1.contains(num)){
                result[1] += 1;
            }
        }
        for (int num : nums1) {
            if(integers2.contains(num)){
                result[0] += 1;
            }
        }
        return result;
    }

    /**
     * 使用int数组存，index：num，value：count，相比使用map是牺牲内存换取时间
     * 遍历nums1，初始化ints
     * 遍历num2，判断是否在ints有值，
     *      如果有有值，则nums2的数量+1，判断ints值是否为-1，为-1说明已经计算计算，否则nums1的数量+ints[num],并将ints[num]置为-1
     */
    public int[] findIntersectionValues1(int[] nums1, int[] nums2) {
        int[] result = new int[2];
//        int[] nums1Array = new int[101];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            Integer count = map.getOrDefault(num, 0);
            map.put(num,++count);
//            nums1Array[num]++;
        }
        for (int num : nums2) {
//            if (nums1Array[num] != 0) {
//                result[1]++;
//                result[0] += nums1Array[num] == -1 ? 0 : nums1Array[num];
//                nums1Array[num] = -1;
//            }
            if(map.containsKey(num)){
                result[1]++;
                Integer count = map.get(num);
                result[0] += count==-1?0:count;
                map.put(num,-1);
            }
        }
        return result;
    }

}
