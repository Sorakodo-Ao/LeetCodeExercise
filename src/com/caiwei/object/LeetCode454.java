package com.caiwei.object;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

//四数相加 II
public class LeetCode454 {
    @Test
    void test() {
        int result = fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2});
        System.out.println(result);
    }

    /*  给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，
        请你计算有多少个元组 (i, j, k, l) 能满足：
        1、 0 <= i, j, k, l < n
        2、 nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
    */
/*  示例 1：
    输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
    输出：2
    解释：
    两个元组如下：
            1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
            2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
    示例 2：
    输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
    输出：1*/
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        if (nums1.length == 0 || nums2.length == 0 || nums3.length == 0 || nums4.length == 0) {
            return 0;
        }
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int twoSum = nums1[i] + nums2[j];
                if (map.containsKey(twoSum)) {
                    map.replace(twoSum, map.get(twoSum) + 1);
                } else {
                    map.put(twoSum, 1);
                }
            }
        }
        map.forEach((key, value) -> {
            System.out.println("key = " + key + " value = " + value);
        });
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int twoSum = -nums3[i] - nums4[j];
                if (map.containsKey(twoSum)) {
                    result += map.get(twoSum);
                }
            }
        }
        return result;
    }
}
