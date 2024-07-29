package org.example.daily;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://leetcode.cn/problems/baseball-game/description/
 * 你现在是一场采用特殊赛制棒球比赛的记录员。这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分。
 * 比赛开始时，记录是空白的。你会得到一个记录操作的字符串列表 ops，其中 ops[i] 是你需要记录的第 i 项操作，ops 遵循下述规则：
 * 整数 x - 表示本回合新获得分数 x
 * "+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
 * "D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * "C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * 请你返回记录中所有得分的总和。
 * @author yixin
 * @since 2024/7/26
 */
public class D20240729 {

    /**
     * 输入：ops = ["5","2","C","D","+"]
     * 输出：30
     * 解释：
     * "5" - 记录加 5 ，记录现在是 [5]
     * "2" - 记录加 2 ，记录现在是 [5, 2]
     * "C" - 使前一次得分的记录无效并将其移除，记录现在是 [5].
     * "D" - 记录加 2 * 5 = 10 ，记录现在是 [5, 10].
     * "+" - 记录加 5 + 10 = 15 ，记录现在是 [5, 10, 15].
     * 所有得分的总和 5 + 10 + 15 = 30
     */
    public static void main(String[] args) {
        new D20240729().calPoints(new String[]{"5","2","C","D","+"});
    }


    /**
     * 定义一个int集合
     * 遍历operations
     * 判断char是否为"C"、"D"、“+”
     *      “C”：移除int集合最后一位
     *      "D": 获取int集合中最后一位乘2
     *      "+": 获取int集合倒数第一和第二位相加
     */
    public int calPoints(String[] operations) {
        ArrayList<Integer> list = new ArrayList<>();
        for (String operation : operations) {
            int size = list.size()-1;
            switch (operation){
                case "C":
                    list.remove(size);
                    break;
                case "D":
                    int multi = list.get(size) * 2;
                    list.add(multi);
                    break;
                case "+":
                    int sum = list.get(size) + list.get(size - 1);
                    list.add(sum);
                    break;
                default:
                    list.add(Integer.valueOf(operation));
            }
        }
        return list.stream().reduce(0, Integer::sum);
    }


}
