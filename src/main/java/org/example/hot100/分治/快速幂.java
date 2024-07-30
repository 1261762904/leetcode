package org.example.hot100.分治;

/**
 * https://leetcode.cn/problems/powx-n/
 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
 * @author yixin
 * @since 2024/7/30
 */
public class 快速幂 {

    /**
     * 分治
     * x * x^2 * x^4 * x^ 8
     * x^5 = x * x^4 5的二进制：0101
     * x^10 = x^2 * x^ 8  10二进制：1010
     * 那怎么判断需要哪些数相乘呢？
     * 对二进制向右移动，每移一次判断个位是否等于1，如果等于1说明要乘，否则继续
     */
    public double myPow(double x, int n) {
//        return  Math.pow(x,n);
        double result = 1d;
        //如果n=-2^31,变成正数会溢出，int最大值2^31-1
        long ln = n;
        if (ln < 0) {
            ln = -ln;
            x = 1 / x;
        }
        while (ln > 0) {
            if ((ln & 1) == 1) {
                result *= x;
            }
            x *= x;
            ln = ln >> 1;
        }
        return result;
    }


}
