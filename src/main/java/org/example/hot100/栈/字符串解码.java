package org.example.hot100.栈;

import com.sun.org.apache.bcel.internal.generic.NEW;

import javax.naming.spi.ResolveResult;
import java.util.LinkedList;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/decode-string/description/?envType=study-plan-v2&envId=top-100-liked
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * @author yixin
 * @since 2024/8/12
 */
public class 字符串解码 {
    public static void main(String[] args) {
        System.out.println(new 字符串解码().decodeString("abc3[cd]xyz"));
        System.out.println(new 字符串解码().decodeString("3[a2[c]]"));
    }

    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        Stack<String> stackRes = new Stack<>();
        Stack<Integer> stackMulti = new Stack<>();
        int multi =0;
        for (char c : s.toCharArray()) {
            if(c=='['){
                stackMulti.push(multi);
                multi=0;
                stackRes.push(res.toString());
                res = new StringBuilder();
            }else if(c==']'){
                Integer curMulti= stackMulti.pop();
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < curMulti; i++) {
                    temp.append(res);
                }
                res = new StringBuilder(stackRes.pop()+temp);
            } else if (c>='0' && c<='9') {
                multi = multi*10+ Integer.parseInt(c + "");
            }else{
                res.append(c);
            }
        }
        return res.toString();
    }

}
