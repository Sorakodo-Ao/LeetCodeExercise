package com.caiwei.object;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//四数之和
public class LeetCode18 {
    @Test
    void test() {
        List<List<Integer>> result = fourSum(new int[]{-2,-1,-1,1,1,2,2}, 0);
        System.out.println(result);
    }
/*
给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]]
（若两个四元组元素一一对应，则认为两个四元组重复）：
    0 <= a, b, c, d < n
    a、b、c 和 d 互不相同
    nums[a] + nums[b] + nums[c] + nums[d] == target
    你可以按 任意顺序 返回答案 。
示例 1：
输入：nums = [1,0,-1,0,-2,2], target = 0
输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
*/
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int length = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        if (nums[0] >= 0 && nums[0] > target) {
            return result;
        }
        for (int i = 0; i < length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] > target && target > 0) {
                    break;
                }
                if (nums[j] == nums[j - 1] && j > i + 1) {
                    continue;
                }
                int left = j + 1;
                int right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        List<Integer> resultList = new ArrayList<>();
                        resultList.add(nums[i]);
                        resultList.add(nums[j]);
                        resultList.add(nums[left]);
                        resultList.add(nums[right]);
                        result.add(resultList);
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                    }

                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    }else{
                        left++;
                        right--;
                    }

                }
            }
        }
        return result;
    }
}
