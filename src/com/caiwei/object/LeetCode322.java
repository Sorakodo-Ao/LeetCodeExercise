package com.caiwei.object;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

//零钱兑换
//todo
class LeetCode322 {
    @Test
    void test() {
        int[] coins = {1, 2, 5};
        int result = coinChange(coins, 11);
        System.out.println(result);
    }

    /*
    给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
    计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
    你可以认为每种硬币的数量是无限的。
    */
/*
 示例 1：  输入：coins = [1, 2, 5], amount = 11
            输出：3
            解释：11 = 5 + 5 + 1
 示例 2：  输入：coins = [2], amount = 3
            输出：-1
 示例 3：  输入：coins = [1], amount = 0
            输出：0
*/
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        int result = 0;
        int index = coins.length - 1;
        while (index >= 0) {
            if (amount < coins[0]) {
                break;
            }
            amount -= coins[index];
            result++;
            if (amount < coins[index]) {
                index--;
            }
            if (amount < 0) {
                amount += coins[index + 1];
                result--;
            }

        }
        return result == 0 ? -1 : result;
    }
}