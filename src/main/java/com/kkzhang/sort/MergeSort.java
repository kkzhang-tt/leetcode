package com.kkzhang.sort;

public class MergeSort {

    public static void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int[] temp = new int[array.length];
        mergeSort(array, 0, array.length - 1, temp);
    }

    private static void mergeSort(int[] array, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid, temp); // 对左半部分进行归并排序
            mergeSort(array, mid + 1, right, temp); // 对右半部分进行归并排序
            merge(array, left, mid, right, temp); // 合并两个有序的子序列
        }
    }

    private static void merge(int[] array, int left, int mid, int right, int[] temp) {
        int i = left; // 左序列指针
        int j = mid + 1; // 右序列指针
        int k = 0; // 临时数组指针

        // 比较左右两个子序列的元素，将较小的元素放入临时数组中
        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        // 将剩余的元素拷贝到临时数组中
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= right) {
            temp[k++] = array[j++];
        }

        // 将临时数组中的元素复制回原数组
        k = 0;
        while (left <= right) {
            array[left++] = temp[k++];
        }
    }

    public static void main(String[] args) {
        int[] array = { 5, 2, 8, 4, 1, 9, 3, 7 };
        mergeSort(array);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

}
