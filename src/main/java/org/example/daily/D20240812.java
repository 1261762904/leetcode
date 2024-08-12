package org.example.daily;

/**
 * https://leetcode.cn/problems/implement-magic-dictionary/description/
 * 设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同 。 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于你构建的字典中。
 * 实现 MagicDictionary 类：
 *      MagicDictionary() 初始化对象
 *      void buildDict(String[] dictionary) 使用字符串数组 dictionary 设定该数据结构，dictionary 中的字符串互不相同
 *      bool search(String searchWord) 给定一个字符串 searchWord ，判定能否只将字符串中 一个 字母换成另一个字母，使得所形成的新字符串能够与字典中的任一字符串匹配。如果可以，返回 true ；否则，返回 false 。
 * @author yixin
 * @since 2024/8/12
 */
public class D20240812 {
    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(new String[]{"hello", "leetcode"});
        magicDictionary.search("hello"); // 返回 False
        magicDictionary.search("hhllo"); // 将第二个 'h' 替换为 'e' 可以匹配 "hello" ，所以返回 True
        magicDictionary.search("hell"); // 返回 False
        magicDictionary.search("leetcoded"); // 返回 False
    }


    static class MagicDictionary {

        private String[] dictionary;
        public MagicDictionary() {

        }

        public void buildDict(String[] dictionary) {
            this.dictionary = dictionary;
        }

        public boolean search(String searchWord) {
            boolean result = false;
            for (String word : dictionary) {
                if(word.length()!=searchWord.length()){
                    continue;
                }
                if (word.equals(searchWord)){
                    continue;
                }
                int diff=0;
                for (int i = 0; i < word.length(); i++) {
                    if(word.charAt(i)!=searchWord.charAt(i)) {
                        diff++;
                        if (diff>1) {
                            break;
                        }
                    }
                }
                if(diff == 1){
                    result=true;
                    break;
                }
            }
            return result;
        }
    }
}
