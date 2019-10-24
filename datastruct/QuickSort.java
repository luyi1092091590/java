package datastruct;

import java.util.Arrays;

/**
 * 快速排序
 */

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5, 6, 3, 1, 2, 7, 9, 5, 4};
        fun(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void fun(int[] arr, int start, int end) {
        int low = start;
        int high = end;
        int temp = arr[start];
        if (low < high) {
            while (low < high) {
                while (arr[high] >= temp && low < high) {
                    high--;
                }
                arr[low] = arr[high];
                while (arr[low] < temp && low < high) {
                    low++;
                }
                arr[high] = arr[low];
            }
            arr[low] = temp;
            fun(arr, start, low);
            fun(arr, low + 1, end);
        }
    }
}
