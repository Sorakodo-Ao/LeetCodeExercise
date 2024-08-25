package com.caiwei.object.slidingWindow;


import org.junit.jupiter.api.Test;

//最接近的三数之和(相邻元素)
class ThreeAdjacentSumClosest {
    @Test
    void test() {
        int[] arr = {-1, 2, 1, -4};
        int target = 1;
        int result = threeSumClosest(arr, target);
        System.out.println(result);
    }

    /*给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出相邻的三个整数，使它们的和与 target 最接近。
     返回这三个数的和。
     假定每组输入只存在恰好一个解。
    */
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int minDiffValue = Integer.MAX_VALUE;
        int result = 0;

        int i = 0;
        int j = i + 2;
        int sum = 0;
        while (j <= length - 1) {
            //滑动窗口的和
            if (i == 0) {
                int index = i;
                while (index <= j) {
                    sum += nums[index++];
                }
            } else {
                sum += nums[j];
            }
            //求与target差值
            int diffValue = 0;
            if (sum > target) {
                diffValue = Integer.min(minDiffValue, sum - target);
            } else {
                diffValue = Integer.min(minDiffValue, target - sum);
            }
            //差值比之前记录的最小差值还小
            if (diffValue < minDiffValue) {
                minDiffValue = diffValue;
                result = sum;
            }
            sum -= nums[i++];
            j++;
        }
        return result;
    }

}