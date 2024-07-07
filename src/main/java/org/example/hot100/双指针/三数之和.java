package org.example.hot100.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/3sum/description/?envType=study-plan-v2&envId=top-100-liked
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 你返回所有和为 0 且不重复的三元组。
 * @author 易昕
 */
public class 三数之和 {
    public static void main(String[] args) {
        new 三数之和().threeSum(new int[]{-1,0,1,2,-1,-4});
    }

    /**
     * 排序
     * 一层循环 遍历nums 如果遇到当前和上一个一样那就continue，因为重复的不算
     *  为了保证不重复，二层、三层要比上一层的大
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(i==0 || nums[i]!=nums[i-1]){
                for (int j = i+1; j < nums.length; j++) {
                    if(j==i+1||nums[j]!=nums[j-1]){
                        for (int k = j+1; k < nums.length; k++) {
                            if((k==j+1||nums[k]!=nums[k-1]) && nums[i]+nums[j]+nums[k]==0){
                                ArrayList<Integer> list = new ArrayList<>();
                                list.add(nums[i]);
                                list.add(nums[j]);
                                list.add(nums[k]);
                                lists.add(list);
                            }
                        }
                    }
                }
            }
        }
        return lists;
    }

    public List<List<Integer>> threeSumNew(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(i==0 || nums[i]!=nums[i-1]){
                for (int j = i+1; j < nums.length; j++) {
                    if(j==i+1||nums[j]!=nums[j-1]){
                        int target = -(nums[i]+nums[j]);
                        int k = nums.length-1;
                        while (k>j && nums[k]>target){
                            k--;
                        }
                        if(k==j)continue;
                        if( nums[k]==target){
                            ArrayList<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            lists.add(list);
                        }

                    }
                }
            }
        }
        return lists;
    }

    /**
     * 第二层和第三层可以转换成左右指针
     * 当sum的值小于0时，说明left++
     * 大于0是，right--
     * 等于0放入集合中，然后判断和下一个值的大小，如果一样需要继续移动，最后还得将left和right移动一次
     */
    public List<List<Integer>> threeSumNew1(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(i==0 || nums[i]!=nums[i-1]){
                int left = i+1;
                int right = nums.length-1;
                while(left<right){
                    int result = nums[left] + nums[right] + nums[i];
                    if(result == 0){
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        lists.add(list);
                        while (left<right && nums[left]==nums[left+1]){
                            left++;
                        }
                        while (left<right && nums[right]==nums[right-1]){
                            right--;
                        }
                        left++;
                        right--;
                    }else if(result>0){
                        right--;
                    }else{
                        left++;
                    }
                }
            }
        }
        return lists;
    }
}
