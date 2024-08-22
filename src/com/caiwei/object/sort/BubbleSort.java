package com.caiwei.object.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

//冒泡排序
public class BubbleSort {
    @Test
    void test() {
        int[] arr = {1, 32, 45, 24, 4, 6, 9, 10, 57, 46, 36, 0};
        System.out.println(arr.length);
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void bubbleSort(int[] arr) {
        int length = arr.length;
        //比较趟数
        for (int i = 0; i < length; i++) {
            //相邻之间比较
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
