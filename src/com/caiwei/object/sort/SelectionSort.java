package com.caiwei.object.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

//选择排序
public class SelectionSort {
    @Test
    void test() {
        int[] arr = {1, 32, 45, 24, 4, 6, 9, 10, 57, 105, 46, 36, 0};
        System.out.println(arr.length);
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void selectionSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[minIndex] > arr[j]) {
                    //当前j元素比minIndex元素小
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                //当前i元素不是最小的
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

}
