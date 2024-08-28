package com.caiwei.object;


import org.junit.jupiter.api.Test;

//爬楼梯
class LeetCode70 {
    @Test
    void test() {
        int result = climbStairs(10);
        System.out.println(result);
    }

    /*  假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
    每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
    示例 1：
    输入：n = 2
    输出：2
    解释：有两种方法可以爬到楼顶。
    1、  1 阶 + 1 阶
    2、  2 阶
    */
    //本质是斐波那契数列
    // 阶 数0 1 2 3 4
    // 方法数  1 2 3 5
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}