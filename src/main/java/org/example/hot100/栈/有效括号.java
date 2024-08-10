package org.example.hot100.栈;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/valid-parentheses/description/?envType=study-plan-v2&envId=top-100-liked
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * @author yixin
 * @since 2024/8/10
 */
public class 有效括号 {
    public static void main(String[] args) {
        System.out.println(new 有效括号().isValid("{[]}"));
    }

    public boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (char c : charArray) {
            if (map.containsKey(c)) {
                if (stack.isEmpty() || !stack.pop().equals(map.get(c))) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public boolean isValidNew(String s) {
        char[] charArray = s.toCharArray();
        char[] stack = new char[charArray.length];
        int head = 0;
        for (char c : charArray) {
            if(c=='('||c=='{'||c=='['){
                stack[head++] = c;
            }else{
                if(head==0){
                    return false;
                }
                switch (c){
                    case ')':
                        if(stack[--head]!='('){
                            return false;
                        }
                        break;
                    case '}':
                        if(stack[--head]!='{'){
                            return false;
                        }
                        break;
                    case ']':
                        if(stack[--head]!='['){
                            return false;
                        }
                        break;
                }
            }
        }
        return head==0;
    }
}
