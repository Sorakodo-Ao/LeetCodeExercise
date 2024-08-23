package com.caiwei.object.sort;

import org.junit.jupiter.api.Test;
//快排
public class QuickSort {
    @Test
    void sort() {
        int[] arr = {1, 32, 45, 24, 4, 6, 9, 10, 57, 46, 36};
        System.out.println(arr.length);
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
    }

    public void quickSort(int[] arr, int left, int right) {
        if(left < right){
            int position = partition(arr, left, right);
            quickSort(arr, left, position - 1);
            quickSort(arr, position + 1, right);
        }
    }

    public int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }
}
/*
public class QuickSort {

    // 快速排序函数
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // pi 是 partition 函数返回的基准值的索引
            int pi = partition(arr, low, high);

            // 递归地排序基准值左边和右边的子数组
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // 分区函数
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // 选择最后一个元素作为基准值
        int i = (low - 1); // i 是小于基准值的元素的索引

        for (int j = low; j < high; j++) {
            // 如果当前元素小于或等于基准值
            if (arr[j] <= pivot) {
                i++;

                // 交换 arr[i] 和 arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // 交换 arr[i+1] 和基准值 pivot
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // 主函数，用于测试排序算法
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        quickSort(arr, 0, n - 1);

        System.out.println("Sorted array: ");
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
    }
}
*/
