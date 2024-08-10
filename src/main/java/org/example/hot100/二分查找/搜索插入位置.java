package org.example.hot100.二分查找;

/**
 * https://leetcode.cn/problems/search-insert-position/description/?envType=study-plan-v2&envId=top-100-liked
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * @author yixin
 * @since 2024/8/10
 */
public class 搜索插入位置 {
    public static void main(String[] args) {
        System.out.println(new 搜索插入位置().searchInsert(new int[]{1, 3}, 0));
    }

    /**
     * 二分查找法
     */
    public int searchInsert(int[] nums, int target) {
       return middleSearch(nums,target,0,nums.length-1);
    }

    private int middleSearch(int[] nums, int target,int left,int right){
        if(left>=right){
            return nums[left]>=target?left:left+1;
        }
        int middle = (right+left) / 2;
        if(nums[middle]==target){
            return middle;
        }
        if(nums[middle]>target){
            return middleSearch(nums,target,left,middle-1);
        }else{
            return middleSearch(nums,target,middle+1,right);
        }
    }
    public int searchInsertNew(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while(left<=right){
            int middle = (left+right)/2;
            if(nums[middle]==target){
                return middle;
            }else if(nums[middle]>target){
                right = middle-1;
            }else{
                left = middle+1;
            }
        }
        return left;
    }
}
