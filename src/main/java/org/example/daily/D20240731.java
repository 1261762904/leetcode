package org.example.daily;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/double-modular-exponentiation/description/
 * 给你一个二维整数数组 point ，其中 points[i] = [xi, yi] 表示二维平面内的一个点。同时给你一个整数 w 。你需要用矩形 覆盖所有 点。
 * 每个矩形的左下角在某个点 (x1, 0) 处，且右上角在某个点 (x2, y2) 处，其中 x1 <= x2 且 y2 >= 0 ，同时对于每个矩形都 必须 满足 x2 - x1 <= w 。
 * 如果一个点在矩形内或者在边上，我们说这个点被矩形覆盖了。
 * 请你在确保每个点都 至少 被一个矩形覆盖的前提下，最少 需要多少个矩形。
 * 注意：一个点可以被多个矩形覆盖。
 *
 * @author yixin
 * @since 2024/7/30
 */
public class D20240731 {
    public static void main(String[] args) {
        int[][] ints = {
                {0,0},{1,1},{2,2},{3,3},{4,4},{5,5},{6,6}
        };

        System.out.println(new D20240731().minRectanglesToCoverPoints(ints, 2));
    }

    /**
     * 获取所有横坐标 并排序
     * 定义最后一个矩形的开始点横坐标lastIndex
     * 遍历横坐标
     *      判断横坐标与开始点横坐标的距离与w的大小
     *          如果大于，则说明要以前的矩形包含不了当前坐标了，需要新建一个矩形，那就要刷新lastIndex，并result++
     * 返回result
     */
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        int[] xInts = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            xInts[i] = points[i][0];
        }
        Arrays.sort(xInts);
        int result = 1;
        int lastIndex = 0;
        for (int i = 1; i < xInts.length; i++) {
            int diff = xInts[i] - xInts[lastIndex];
            if (diff > w) {
                lastIndex = i;
                result++;
            }
        }
        return result;
    }
}
