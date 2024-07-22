package org.example.hot100.普通数组;

/**
 * https://leetcode.cn/problems/rotate-array/description/?envType=study-plan-v2&envId=top-100-liked
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * @author yixin
 * @since 2024/7/22
 */
public class 轮转数组 {
    public static void main(String[] args) {
        new 轮转数组().rotate(new int[]{1,2,3,4,5,6,7},3);

    }

    /**
     * 对于k=0相当于不移动，直接返回
     * 定义新的result数组存储移动后的值
     * 遍历nums
     *      计算下标为i移动后的下标  newIndex = (i+k)%nums.length
     *      赋值
     * 遍历并替换nums里的值
     */
    public void rotate(int[] nums, int k) {
        if(k==0)return;
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int index = (i + k) % nums.length;
            result[index] = nums[i];
        }
        //  System.arraycopy(newArr, 0, nums, 0, n);
        for (int i = 0; i < result.length; i++) {
            nums[i] = result[i];
        }
    }

    /**
     * 先将整个数组翻转
     * 对k取k和nums.length取余
     * 然后翻转[0-(k-1)]和[k,nums.length-1]
     */
    public void rotateNew(int[] nums, int k) {
        k = k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);

    }

    private void reverse(int[] nums,int start,int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
