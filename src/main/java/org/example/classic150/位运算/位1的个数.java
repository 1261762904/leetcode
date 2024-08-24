package org.example.classic150.位运算;

/**
 * https://leetcode.cn/problems/number-of-1-bits/?envType=study-plan-v2&envId=top-interview-150
 * 编写一个函数，获取一个正整数的二进制形式并返回其二进制表达式中设置位的个数（也被称为汉明重量）。
 * @author yixin
 * @since 2024/8/24
 */
public class 位1的个数 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(new 位1的个数().hammingWeightNew(11));
    }
    public int hammingWeight(int n) {
        int result=0;
        while(n>>1!=0){
            if((n&1)==1)result++;
            n>>=1;
        }
        if(n>0)result++;
        return result;
    }

    /**
     * 观察这个运算： n&(n-1)，其运算结果恰为把 n 的二进制位中的最低位的 1 变为 0 之后的结果。
     * eg:n=6  6&(6-1)=4   二进制： 6:110  5:101  4:100
     */
    public int hammingWeightNew(int n) {
        int result = 0;
        while(n>0){
            n&=n-1;
            result++;
        }
        return result;
    }
}
