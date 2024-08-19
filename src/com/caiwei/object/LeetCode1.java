package com.caiwei.object;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//两数之和
class LeetCode1 {
    @Test
    void test() {
        int[] nums = {2,11,7,15};
        int target = 9;
        int[] sumArray = twoSum(nums, target);
        System.out.println(Arrays.toString(sumArray));
    }

/*    给定一个整数数组 nums 和一个整数目标值 target，
    请你在该数组中找出 和为目标值 target  的那 两个 整数，
    并返回它们的数组下标。
    示例 1：
    输入：nums = [2,7,11,15], target = 9
    输出：[0,1]
*/
//哈希表
public int[] twoSum(int[] nums, int target) {
    if(nums == null || nums.length == 0) {
        return null;
    }
    //创建哈希
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        map.put(nums[i], i);
    }
    //
    int[] result = new int[2];
    for (int i = 0; i < nums.length; i++) {
        int diffNum = target - nums[i];
        if(map.containsKey(diffNum)&& map.get(diffNum) != i) {
            Integer index = map.get(diffNum);
            result[0] = i;
            result[1] = index;
            break;
        }
    }
    return result;
}
/*    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return null;
        }
        //暴力法
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        if(result[0] == 0 && result[1] == 0) {
            return null;
        }
        return result;
    }*/

}