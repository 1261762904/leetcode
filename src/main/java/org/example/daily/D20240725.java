package org.example.daily;

/**
 * https://leetcode.cn/problems/minimum-operations-to-make-a-special-number/description/
 * 给你一个下标从 0 开始的字符串 num ，表示一个非负整数。
 * 在一次操作中，您可以选择 num 的任意一位数字并将其删除。请注意，如果你删除 num 中的所有数字，则 num 变为 0。
 * 返回最少需要多少次操作可以使 num 变成特殊数字。
 * 如果整数 x 能被 25 整除，则该整数 x 被认为是特殊数字。
 * @author yixin
 * @since 2024/7/25
 */
public class D20240725 {
    public static void main(String[] args) {
        new D20240725().minimumOperations("2245047");
    }


    /**
     * 使用贪心算法
     *
     * 能满足条件的情况
     * 只有一位 0
     * 只有两位 25、50、75
     * 三位以上 最后两位25 50 75 00
     * 从右至左遍历
     *
     * 如果遇到0，5，判断前面是否有遇到0,如果有遇，保留num左边的值，剔除右边的值
     * 如果遇到2，7，判断前面是否有遇到5，如果遇到，保留num左边的值，剔除右边的值
     * 如果前面都没有找到则判断是否有0，如果有，则剔除非零的即可
     * 都没有就全部剔除
     */
    public int minimumOperations(String num) {
        boolean find0 = false;
        boolean find5 = false;
        int length = num.length();
        for (int i=length-1;i>=0;i--){
            if(num.charAt(i)=='0' || num.charAt(i)=='5'){
                if(find0){
                    return length-i-2;
                }
                if(num.charAt(i)=='0'){
                    find0=true;
                }
                if(num.charAt(i)=='5'){
                    find5=true;
                }
            }
            if(num.charAt(i)=='2' || num.charAt(i)=='7'){
                if(find5){
                    return length-i-2;
                }
            }
        }
        if(find0){
            return length-1;
        }
        return length;
    }


}
