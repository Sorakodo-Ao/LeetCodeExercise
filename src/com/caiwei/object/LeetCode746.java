package com.caiwei.object;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

//使用最小花费爬楼梯
public class LeetCode746 {
    @Test
    void test() {
        int[] arr = {10, 15, 20};
        int result = minCostClimbingStairs(arr);
        System.out.println(result);
    }

    /*  给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。
        一旦你支付此费用，即可选择向上爬 一个或者两个 台阶。
        你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
        请你计算并返回达到楼梯顶部的最低花费。

        示例 1：
        输入：cost = [10,15,20]
        输出：15
        解释：你将从下标为 1 的台阶开始。
                - 支付 15 ，向上爬两个台阶，到达楼梯顶部。
        总花费为 15 。
    */
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        int costLength = cost.length;
        int[] dp = new int[costLength + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[costLength];
    }

}
