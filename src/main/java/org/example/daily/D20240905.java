package org.example.daily;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://leetcode.cn/problems/clear-digits/description/
 * 给你一个字符串 s 。
 * 你的任务是重复以下操作删除 所有 数字字符：
 * 删除 第一个数字字符 以及它左边 最近 的 非数字 字符。
 * 请你返回删除所有数字字符以后剩下的字符串。
 * @author yixin
 * @since 2024/9/5
 */
public class D20240905 {
    public static void main(String[] args) {
        System.out.println(new D20240905().clearDigits("abc"));
        System.out.println(new D20240905().clearDigits("ab1c"));
    }


    public String clearDigits(String s) {
        char[] chars = new char[s.length()];
        int right = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c>='0' && c<='9'){
                right--;
            }else{
                chars[++right]=c;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= right; i++) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    public String clearDigitsNew(String s) {
        StringBuilder res = new StringBuilder();
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                //数字
                res.deleteCharAt(res.length() - 1);
            } else{
                res.append(c);
            }
        }
        return res.toString();
    }
}
