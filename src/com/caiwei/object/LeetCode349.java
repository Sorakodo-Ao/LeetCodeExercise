package com.caiwei.object;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//两个数组的交集
public class LeetCode349 {
    @Test
    void test() {
        int[] res = intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        //int[] res = intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
        System.out.println(Arrays.toString(res));
    }

    /*  给定两个数组 nums1 和 nums2 ，返回 它们的交集。
        输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
        示例 1：
    输入：nums1 = [1,2,2,1], nums2 = [2,2]
    输出：[2]
    示例 2：
    输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    输出：[9,4]
    解释：[4,9] 也是可通过的
    */

    //没有数量的限制,使用hashset
    /*public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[]{0};
        }
        Set<Integer> resultSet = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                resultSet.add(nums2[i]);
            }
        }
        int[] result = new int[resultSet.size()];
        int index = 0;
        for (Integer param : resultSet) {
            result[index++] = param;
        }
        return result;
    }*/

    //使用数组模拟哈希
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[]{0};
        }
        int[] resultArray = new int[1005];
        for (int param : nums1) {
            resultArray[param] = 1;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (resultArray[nums2[i]] == 1 && !list.contains(nums2[i])) {
                list.add(nums2[i]);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
