package org.example.daily;

/**
 * https://leetcode.cn/problems/maximize-the-confusion-of-an-exam/description/
 * 一位老师正在出一场由 n 道判断题构成的考试，每道题的答案为 true （用 'T' 表示）或者 false （用 'F' 表示）。老师想增加学生对自己做出答案的不确定性，方法是 最大化 有 连续相同 结果的题数。（也就是连续出现 true 或者连续出现 false）。
 * 给你一个字符串 answerKey ，其中 answerKey[i] 是第 i 个问题的正确结果。除此以外，还给你一个整数 k ，表示你能进行以下操作的最多次数：
 * 每次操作中，将问题的正确答案改为 'T' 或者 'F' （也就是将 answerKey[i] 改为 'T' 或者 'F' ）。
 * 请你返回在不超过 k 次操作的情况下，最大 连续 'T' 或者 'F' 的数目。
 * @author yixin
 * @since 2024/9/2
 */
public class D20240902 {
    public static void main(String[] args) {
        System.out.println(new D20240902().maxConsecutiveAnswers("TTFF", 2));
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(maxConsecutiveAnswersInternal(answerKey, k, 'T'), maxConsecutiveAnswersInternal(answerKey, k, 'F'));
    }

    private int maxConsecutiveAnswersInternal(String answerKey, int k, char c) {
        int ans = 0;
        for (int sum = 0, left = 0, right = 0; right < answerKey.length(); right++) {
            sum += answerKey.charAt(right) == c ? 0 : 1;
            while (sum > k) {
                sum -= answerKey.charAt(left++) == c ? 0 : 1;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
