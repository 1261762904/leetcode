package org.example.classic150.位运算;

/**
 * https://leetcode.cn/problems/add-binary/description/?envType=study-plan-v2&envId=top-interview-150
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 * @author yixin
 * @since 2024/8/22
 */
public class 二进制求和 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(new 二进制求和().addBinary("11","1"));
    }
    public String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        int len = Math.max(aLen, bLen);
        StringBuilder sb = new StringBuilder();
        int carry=0;
        for (int i = 0; i < len; i++) {
            carry+=i>aLen-1?0:a.charAt(aLen-1-i)-'0';
            carry+=i>bLen-1?0:b.charAt(bLen-1-i)-'0';
            sb.append((char) (carry%2+'0'));
            carry = carry/2;
        }
        if(carry>0){
            sb.append('1');
        }
        sb.reverse();
        return sb.toString();
    }
}
