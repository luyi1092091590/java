package datastruct;
/**
 * 堆排序
 * */
import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 6, 1, 4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            maxHeap(arr, arr.length, i);
        }
        for (int j = arr.length - 1; j > 0; j--) {
            int temp = arr[0];
            arr[0] = arr[j];
            arr[j] = temp;
            maxHeap(arr, j, 0);
        }
    }

    public static void maxHeap(int[] arr, int size, int index) {
        int leftNode = index * 2 + 1;
        int rightNode = index * 2 + 2;
        int maxIndex = index;
        if (leftNode < size && arr[leftNode] > arr[maxIndex]) {
            maxIndex = leftNode;
        }
        if (rightNode < size && arr[rightNode] > arr[maxIndex]) {
            maxIndex = rightNode;
        }
        if (maxIndex != index) {
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[index];
            arr[index] = temp;
            maxHeap(arr, size, maxIndex);
        }
    }
}
