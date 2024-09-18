package com.caiwei.object;

import org.junit.jupiter.api.Test;

//不同路径
public class LeetCode62 {
    @Test
    void test() {
        int result = uniquePaths(3, 7);
        System.out.println(result);
    }

    /*    一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
        机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
        问总共有多少条不同的路径？
    示例1：
        输入：m = 3, n = 7
        输出：28
    示例 2：
        输入：m = 3, n = 2
        输出：3*/
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        //dp[i][j] 为到达此处有几种方法
        int[][] dp = new int[m][n];
        //确定上边界和左边界都是1
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
