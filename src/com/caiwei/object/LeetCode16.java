package com.caiwei.object;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

//最接近的三数之和
//是随便取三个数，没说是相邻的！！！！！！！
//todo
class LeetCode16 {
    @Test
    void test() {
        int[] arr = {-1, 2, 1, -4};
        int[] arr1 = {321, 413, 82, 812, -646, -858, 729, 609, -339, 483, -323, -399, -82, -455, 18, 661, 890, -328, -311, 520, -865, -174, 55, 685, -636, 462, -172, -696, -296, -832, 766, -808, -763, 853, 482, 411, 703, 655, -793, -121, -726, 105, -966, -471, 612, 551, -257, 836, -94, -213, 511, 317, -293, 279, -571, 242, -519, 386, -670, -806, -612, -433, -481, 794, 712, 378, -325, -564, 477, 169, 601, 971, -300, -431, -152, 285, -899, 978, -419, 708, 536, -816, -335, 284, 384, -922, -941, 633, 934, 497, -351, 62, 392, -493, -44, -400, 646, -912, -864, 835, 713, -12, 322, -228, 340, -42, -307, -580, -802, -914, -142, 575, -684, -415, 718, -579, 759, 579, 732, -645, 525, 114, -880, -603, -699, -101, -738, -887, 327, 192, 747, -614, 393, 97, -569, 160, 782, -69, 235, -598, -116, 928, -805, -76, -521, 671, 417, 600, -442, 236, 831, 637, -562, 613, -705, -158, -237, -299, 808, -734, 364, 919, 251, -163, -343, 899};
        int target = 1;
        int target1 = 2218;
        int result = threeSumClosest(arr1, target1);
        System.out.println(result);
    }

    /*给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
     返回这三个数的和。
     假定每组输入只存在恰好一个解。
    */
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        //排序
        Arrays.sort(nums);
        //结果
        int result = nums[0] + nums[1] + nums[2];
        //三个值之和
        int threeSum;
        for (int i = 0; i < length -2; i++) {
            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                threeSum = nums[i] + nums[left] + nums[right];
                if(Math.abs(threeSum - target) < Math.abs(result - target)){
                    result = threeSum;
                }
                if(threeSum > target){
                    right--;
                }else{
                    left++;
                }
                if(threeSum == target){
                    return threeSum;
                }
            }
        }
        return result;
    }

}