package org.example.hot100.滑动窗口;

import java.util.HashSet;

/**
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-100-liked
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 * @author yixin
 * @since 2024/7/10
 */
public class 无重复字符的最长子串 {
    public static void main(String[] args) {
        System.out.println(new 无重复字符的最长子串().lengthOfLongestSubstringNew("pwwkew"));
    }


    /**
     * str转变成char arrays
     * 定义左右指针，left：0 right：0
     * 定义一个set、max
     * 遍历right<len
     *  遍历 right<len && set中不包含right值，set.add right值，并right++
     *  判断right-left与max大小，取最大值，将set的left数据删掉 left++
     *  添加char到set
     */
     public int lengthOfLongestSubstring(String s) {
         char[] charArray = s.toCharArray();
         int left = 0;
         int right = 1;
         int len = s.length();
         int max = 0;
         HashSet<Character> set = new HashSet<>();
         set.add(charArray[left]);
         while (right < len) {
             while (right < len && !set.contains(charArray[right])) {
                 set.add(charArray[right]);
                 right++;
             }
             max = Math.max(max, right - left);
             set.remove(charArray[left]);
             left++;
         }
         return max;
     }

    public int lengthOfLongestSubstringNew(String s) {
        char[] charArray = s.toCharArray();
        int left = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        for (int right = 0; right < charArray.length;) {
            if(set.contains(charArray[right])){
                set.remove(charArray[left++]);
            }else{
                max = Math.max(max,right-left+1);
                set.add(charArray[right]);
                right++;
            }
        }
        return max;
    }
}
