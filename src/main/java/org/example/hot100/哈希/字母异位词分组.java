package org.example.hot100.哈希;

import java.util.*;

/**
 * https://leetcode.cn/problems/group-anagrams/description/?envType=study-plan-v2&envId=top-100-liked
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 *
 * @author yixin
 * @since 2024/7/3
 */
public class 字母异位词分组 {
    public static void main(String[] args) {
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        new 字母异位词分组().groupAnagrams(strings);
    }

    /**
     * 定义map key：排序后的str，value：list
     * 遍历strs
     *  对str做排序
     *  判断map是否包含该str
     *      包含的话就put
     *      不包含就定义个list，然后塞入
     * 返回map.values
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortStr = String.valueOf(charArray);
            List<String> list = map.getOrDefault(sortStr, new ArrayList<>());
            list.add(str);
            map.put(sortStr,list);
        }
        return new ArrayList<>(map.values());
    }
}
