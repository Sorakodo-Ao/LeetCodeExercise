package com.caiwei.object;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

//分割等和子集
public class LeetCode416 {
    @Test
    void test() {
        boolean judge = canPartition(new int[]{1, 2, 3, 5});
        System.out.println(judge);
    }


    /*  给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
        示例 1：
        输入：nums = [1,5,11,5]
        输出：true
        解释：数组可以分割成 [1, 5, 5] 和 [11] 。
        示例 2：
        输入：nums = [1,2,3,5]
        输出：false
        解释：数组不能分割成两个元素和相等的子集。*/

    //使用动态规划，变成01背包问题
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            //和为奇数，不符合条件
            return false;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        //初始化
        dp[0] = 0;
        //dp[j] = max(dp[j] , dp[j-weight[i]] + value[i])
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Integer.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[target] == target;
    }
}
