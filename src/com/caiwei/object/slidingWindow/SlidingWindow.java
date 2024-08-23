package com.caiwei.object.slidingWindow;

import org.junit.jupiter.api.Test;

//滑动窗口问题
//求在三个相邻元素中，相加之和最小
public class SlidingWindow {
    @Test
    void test() {
        int[] arr = {2, 5, 4, 2, 1, 6, 5, 3, 1, 1, 1};
        int minValue = slidingWindow(arr);
        System.out.println(minValue);

    }

    public int slidingWindow(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int length = arr.length;
        //滑动窗口区间为【i,j】
        int i = 0;
        int j = i + 2;
        //和的最小值
        int result = Integer.MAX_VALUE;
        //滑动窗口之和
        int sum = 0;
        while (j <= length - 1) {
            if (i == 0) {
                int index = i;
                //前三个数之和
                while (index <= j) {
                    sum += arr[index++];
                }
            } else {
                //移动窗口
                sum += arr[j];
            }
            //和Result比较得出最小值
            result = Integer.min(result, sum);
            //窗口滑动一位
            sum -= arr[i++];
            j++;
        }
        return result;
    }
}

