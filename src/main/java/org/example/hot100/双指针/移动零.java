package org.example.hot100.双指针;

/**
 * https://leetcode.cn/problems/move-zeroes/description/?envType=study-plan-v2&envId=top-100-liked
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * @author yixin
 * @since 2024/7/4
 */
public class 移动零 {
    public static void main(String[] args) {
        new 移动零().moveZeroesNew(new int[]{0,1,0,3,12});
    }

    /**
     * 不能保证相对顺序
     * --
     * 定义左右指针，左指针0，右指针length-1
     * 循环（left<right）
     *  判断左指针值是否等于0，
     *      等于0就和右指针值替换，右指针-1，
     *  左指针+1
     */
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            if(nums[left]==0){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right--;
            }
            left++;
        }
    }

    /**
     * 保证相对顺序
     * 遍历nums，移动right，如果right值不等于0，就和left值替换并且left和right都移动，否则只移动right
     * --
     * 定义左右指针 左指针0，右指针为循环的index
     * 遍历nums
     *  判断num是否为0
     *      yes：替换左右指针的值 left++
     */
    public void moveZeroesNew(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if(nums[right]!=0){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }
    }
}
