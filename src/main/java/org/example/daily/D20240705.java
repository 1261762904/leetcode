package org.example.daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.cn/problems/modify-the-matrix/description/
 * 给你一个下标从 0 开始、大小为 m x n 的整数矩阵 matrix ，新建一个下标从 0 开始、名为 answer 的矩阵。
 * 使 answer 与 matrix 相等，接着将其中每个值为 -1 的元素替换为所在列的 最大 元素。
 * @author yixin
 * @since 2024/7/3
 */
public class D20240705 {
    public static void main(String[] args) {
        int[][] ints = {
                {-1, 0, 0, 2, 2},
                {2, 0, 0, 2, 1},
                {4, 3, 2, 1, 1},
                {-1, -1, 0, 2, 4},
                {1, 0, 3, -1, 0}
        };

        System.out.println(new D20240705().modifiedMatrix(ints));
    }

    /**
     *遍历matrix
     *  获取每列的最大值，放入map中，key：列index value：最大值
     *  获取每行的-1，放入map中，key：行index，value：列index
     */
    public int[][] modifiedMatrix(int[][] matrix) {
        Map<Integer, Integer> maxMap = new HashMap<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j]==-1){
                    List<Integer> orDefault = map.getOrDefault(i, new ArrayList<>());
                    orDefault.add(j);
                    map.put(i,orDefault);
                }else {
                    Integer orDefault = maxMap.getOrDefault(j, -1);
                    Integer max = Math.max(orDefault,matrix[i][j]);
                    maxMap.put(j,max);
                }
            }
        }
        map.forEach((i,list)->{
            list.forEach(j->{
                matrix[i][j]=maxMap.get(j);
            });
        });
        return matrix;
    }

    /**
     *遍历每一列，找出最大值，然后找出-1的替换
     */
    public int[][] modifiedMatrixNew(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            int max = -1;
            for (int j = 0; j < matrix.length; j++) {
                max = Math.max(matrix[j][i],max);
            }
            for (int j = 0; j < matrix.length; j++) {
                if(matrix[j][i]==-1)matrix[j][i]=max;
            }
        }
        return matrix;
    }
}
