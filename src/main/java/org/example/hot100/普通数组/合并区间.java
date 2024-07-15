package org.example.hot100.普通数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/merge-intervals/description/?envType=study-plan-v2&envId=top-100-liked
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 * @author yixin
 * @since 2024/7/15
 */
public class 合并区间 {
    public static void main(String[] args) {
        new 合并区间().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
    }

    /**
     * 对数组的第一个元素进行排列
     * 循环
     *  left是可以确定的，现在需要判断是否合并
     *      不合并：当list为空或者右边的left比左边的right还要大，那就需要新建一个区间不合并 eg:{1,2} {3,5}
     *      合并：通过获取right值取最大值，来判断是否要延长还是取前一个
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int l = intervals[i][0];
            int r = intervals[i][1];
            if (list.isEmpty() || list.get(list.size() - 1)[1] < l) {
                list.add(new int[]{l, r});
            } else {
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], r);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}

