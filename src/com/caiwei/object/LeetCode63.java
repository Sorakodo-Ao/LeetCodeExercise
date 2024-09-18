package com.caiwei.object;

import org.junit.jupiter.api.Test;

//不同路径 II
public class LeetCode63 {
    @Test
    void test() {
        int result = uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
        System.out.println(result);
    }

    /*  一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
        机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
        现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
        网格中的障碍物和空位置分别用 1 和 0 来表示。
        示例 1：
        输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
        输出：2*/
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            } else {
                dp[i][0] = 1;
            }
        }
        for (int j = 0; j < col; j++) {
            if (obstacleGrid[0][j] == 1) {
                break;
            } else {
                dp[0][j] = 1;
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[row - 1][col - 1];
    }
}
