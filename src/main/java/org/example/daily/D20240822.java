package org.example.daily;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/minimum-array-end/description/
 * 给你两个整数 n 和 x 。你需要构造一个长度为 n 的 正整数 数组 nums ，对于所有 0 <= i < n - 1 ，
 * 满足 nums[i + 1] 大于 nums[i] ，并且数组 nums 中所有元素的按位 AND 运算结果为 x 。
 * 返回 nums[n - 1] 可能的 最小 值。
 * @author yixin
 * @since 2024/8/22
 */
public class D20240822 {
    public static void main(String[] args) {
        System.out.println(new D20240822().minEnd(2,36));
    }

    /**
     *
     * 例如 x=100100，那么 nums[i] 一定在如下序列中：
     * 100100、100101、100110、100111、101100、101101...
     * 只看x为0的位，是一个自然数序列
     * 0000(0),0001(1),0010(2),0011(3),0100(4),0101(5),⋯
     *
     * 所以把 x 的二进制中的 0 视作「空位」，依次往空位上填入 n−1的位
     */
    public long minEnd(int n, int x) {
       n--;
       int ans=x,i=0,j=0;
       while(n>>j>0){
           if((ans>>i&1)==0){
               ans |= ((n>>j&1)<<i);
               j++;
           }
           i++;
       }
       return ans;
    }
}
