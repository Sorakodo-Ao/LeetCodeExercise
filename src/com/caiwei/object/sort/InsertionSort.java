package com.caiwei.object.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

//插入排序
public class InsertionSort {
    @Test
    void sort() {
        int[] arr = {1, 65, 32, 45, 24, 4, 6, 9, 10, 57, 84, 46, 36, 78, 400, 96};
        System.out.println(arr.length);
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void insertionSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            //记录i的元素
            int param = arr[i];
            //i要更换到的位置
            int space = i;
            for (int j = i - 1; j >= 0; j--) {
                if (param < arr[j]) {
                    arr[j + 1] = arr[j];
                    space = j;
                }
            }
            arr[space] = param;
        }
    }

}

