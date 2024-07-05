package org.example.hot100.双指针;

/**
 * https://leetcode.cn/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-100-liked
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 *
 * @author yixin
 * @since 2024/7/5
 */
public class 盛最多水的容器 {
    public static void main(String[] args) {
        int[] a =new int[]{};
        System.out.println(new 盛最多水的容器().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    /**
     * min(left,right)*len
     * 移动left还是right？移动小的那个，因为移动势必会将len减小，如果要让值变大，只能让指针的值变得尽可能大一些
     * 定义left=0，right=length max
     * 循环，出条件为left==right
     *    判断当前容量与max的值
     *    移动min指针
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = -1;
        while(left!=right){
            int min = 0;
            int len = right-left;
            if(height[left]>height[right]){
                min = height[right];
                right--;
            }else{
                min = height[left];
                left++;
            }
            max = Math.max(max,min*len);

        }
        return max;
    }

    /**
     * min(left,right)*len
     * 移动left还是right？移动小的那个，因为移动势必会将len减小，如果要让值变大，只能让指针的值变得尽可能大一些
     * 定义left=0，right=length max
     * 循环，出条件为left==right
     *    获取left和right最小值
     *    移动left直到比min大，移动right直到比min大
     */
    public int maxAreaNew(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = -1;
        while(left!=right){
            int min = Math.min(height[left],height[right]);
            max = Math.max(max,min*(right-left));
            while (left<right && height[left]<=min){
                left++;
            }
            while (left<right && height[right]<=min){
                right--;
            }
        }
        return max;
    }
}
