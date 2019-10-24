package datastruct;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {0,1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(fun(arr, 77));
    }

    public static int fun(int[] arr, int target) {
        int begin = 0;
        int end = arr.length - 1;
        int mid = (end + begin) / 2;
        while (begin <= end) {
            if (target == arr[mid]) {
                return mid;
            } else if (target < arr[mid]) {
                end = mid - 1;
                mid = (end + begin) / 2;
            } else {
                begin = mid + 1;
                mid = (end + begin) / 2;
            }
        }
        return -1;
    }
}
