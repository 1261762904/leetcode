package org.example.daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/minimum-substring-partition-of-equal-character-frequency/description/
 * 给你一个字符串 s ，你需要将它分割成一个或者更多的 平衡 子字符串。
 * 比方说，s == "ababcc" 那么 ("abab", "c", "c") ，("ab", "abc", "c") 和 ("ababcc") 都是合法分割，
 * 但是 ("a", "bab", "cc") ，("aba", "bc", "c") 和 ("ab", "abcc") 不是，不平衡的子字符串用粗体表示。
 * 请你返回 s 最少 能分割成多少个平衡子字符串。
 * 注意：一个 平衡 字符串指的是字符串中所有字符出现的次数都相同。
 * @author yixin
 * @since 2024/8/28
 */
public class D20240828 {
    public static void main(String[] args) {
        //fabccddg
        System.out.println(new D20240828().minimumSubstringsInPartition("abababaccddb"));
    }

    static final int INF = 0x3f3f3f3f;

    public int minimumSubstringsInPartition(String s) {
        int n = s.length();
        int[] d = new int[n + 1];
        Arrays.fill(d, INF);
        d[0] = 0;
        for (int i = 1; i <= n; i++) {
            Map<Character, Integer> occCnt = new HashMap<>();
            int maxCnt = 0;
            for (int j = i; j >= 1; j--) {
                occCnt.put(s.charAt(j - 1), occCnt.getOrDefault(s.charAt(j - 1), 0) + 1);
                maxCnt = Math.max(maxCnt, occCnt.get(s.charAt(j - 1)));
                if (maxCnt * occCnt.size() == (i - j + 1) && d[j - 1] != INF) {
                    d[i] = Math.min(d[i], d[j - 1] + 1);
                }
            }
        }
        return d[n];
    }

    public int minimumSubstringsInPartitionNew(String s) {
        int n = s.length();
        int[] d = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            d[i] = d[i-1]+1;
            int[] ints = new int[26];
            int maxCnt = 0;
            int size=0;
            for (int j = i; j >= 1; j--) {
                int index = s.charAt(j - 1) - 'a';
                if(++ints[index]==1){
                    size++;
                }
                maxCnt = Math.max(maxCnt, ints[index]);
                if (maxCnt * size == (i - j + 1)) {
                    d[i] = Math.min(d[i], d[j - 1] + 1);
                }
            }
        }
        return d[n];
    }
}
