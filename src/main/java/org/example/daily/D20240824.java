package org.example.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/permutation-difference-between-two-strings/description/
 * 给你两个字符串 s 和 t，每个字符串中的字符都不重复，且 t 是 s 的一个排列。
 * 排列差 定义为 s 和 t 中每个字符在两个字符串中位置的绝对差值之和。
 * 返回 s 和 t 之间的 排列差 。
 * @author yixin
 * @since 2024/8/24
 */
public class D20240824 {
    public static void main(String[] args) {
        System.out.println(new D20240824().findPermutationDifference("abc","bac"));
    }

    public int findPermutationDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        char[] tCharArray = t.toCharArray();
        for (int i = 0; i < tCharArray.length; i++) {
            map.put(tCharArray[i],i);
        }
        char[] sCharArray = s.toCharArray();
        int result = 0;
        for (int i = 0; i < sCharArray.length; i++) {
            result += Math.abs(map.get(sCharArray[i]) - i);
        }
        return result;
    }

    public int findPermutationDifferenceNew(String s, String t) {
        int[] ints = new int[26];
        for (int i = 0; i < t.length(); i++) {
            ints[t.charAt(i) - 'a'] = i;
        }
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += Math.abs(ints[s.charAt(i) - 'a'] - i);
        }
        return result;
    }
}
