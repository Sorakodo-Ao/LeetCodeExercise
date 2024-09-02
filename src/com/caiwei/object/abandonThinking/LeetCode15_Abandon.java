package com.caiwei.object.abandonThinking;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//三数之和(这里数组有序，且索引可重复)
class LeetCode15_Abandon {
    @Test
    void test() {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(arr);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(result.toString());
    }

    /*
    leetCode 15 废案想法
    给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
    同时还满足 nums[i] + nums[j] + nums[k] == 0 。
    请你返回所有和为 0 且不重复的三元组。
    注意：答案中不可以包含重复的三元组。

    输入：nums = [-1,0,1,2,-1,-4]
    输出：[[-1,-1,2],[-1,0,1]]
    */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> resultList = new ArrayList<>();
        //和为 0
        int sum = 0;
        int left;
        int right = length - 1;
        int threeSum = 0;
        for (int i = 0; i < length -2; i++) {
            left = i + 1;
            while (left < right) {
                threeSum = nums[i] + nums[left] + nums[right];
                if (threeSum <= sum) {
                    left++;
                } else if (threeSum > sum) {
                    right--;
                }
                if(threeSum == sum){
                    //和等于0
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(left);
                    list.add(right);
                    resultList.add(list);
                }
            }
        }
        return resultList;
    }

}