package com.caiwei.object;


import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

// 是否存在重复元素
class LeetCode217 {
    @Test
    void test() {
        int[] arr = {-1, 2, 1, -4, 1};
        boolean b = containsDuplicate(arr);
        System.out.println(b);
    }

   /* 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；
   如果数组中每个元素互不相同，返回 false 。*/

    public boolean containsDuplicate(int[] nums) {

/*        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        if (set.size() != nums.length) {
            return true;
        }
        return false;*/


        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}