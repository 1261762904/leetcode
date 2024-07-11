package org.example.hot100.滑动窗口;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/?envType=study-plan-v2&envId=top-100-liked
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * @author yixin
 * @since 2024/7/11
 */
public class 找到字符串中所有字母异位词 {
    public static void main(String[] args) {
        new 找到字符串中所有字母异位词().findAnagrams("cbaebabacd","abc");
    }

    /**
     * 如果p比s长度大直接返回
     * 定义int[] index代表”字符-a“ value代表数量
     * 初始化int[]
     * 遍历，直到s.len-p.len+1
     * index大于0 则需要移动窗口
     * 遍历两个int[]是否匹配
     * 匹配则是异位词
     *
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if(s.length()<p.length())return list;
        int[] ints = new int[26];
        int[] intp = new int[26];
        int i = 0;
        while (i<p.length()){
            ints[s.charAt(i)-'a']++;
            intp[p.charAt(i)-'a']++;
            i++;
        }
        int len = s.length()-p.length()+1;
        for (i = 0; i < len; i++) {
            if(i>0){
                int index = s.charAt(i - 1) - 'a';
                if(ints[index]>0)ints[index]--;
                ints[s.charAt(i+p.length()-1)-'a']++;
            }
            int j = 0;
            for (; j < ints.length; j++) {
               if(ints[j]!=intp[j])break;
            }
            if(j==ints.length) list.add(i);
        }
        return list;
    }

}
