package com.caiwei.object;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//三数之和
public class LeetCode15 {
    @Test
    void test() {
        //List<List<Integer>> result = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        List<List<Integer>> result = threeSum(new int[]{0, 0, 0, 0});
        System.out.println(result.toString());
    }

    /*  给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足
        i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。
        请你返回所有和为 0 且不重复的三元组。
        注意：答案中不可以包含重复的三元组。
        示例 1：
        输入：nums = [-1,0,1,2,-1,-4]
        输出：[ [-1,-1,2] , [-1,0,1] ]
        解释：
        nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
        nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
        nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
        不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
        注意，输出的顺序和三元组的顺序并不重要。
    */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        if (nums[0] > 0) {
            return result;
        }
        int length = nums.length;
        int left, right;
        for (int i = 0; i < length; i++) {
            if (i >= 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            left = i + 1;
            right = length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> resultList = new ArrayList<>();
                    resultList.add(nums[i]);
                    resultList.add(nums[left]);
                    resultList.add(nums[right]);
                    result.add(resultList);
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                }
            }
        }
        return result;
    }
}
