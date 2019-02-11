/**
 * 합병 정렬
 * 시간복잡도는 O(n logn) 보장
 * 대신 sorted 배열을 추가로 선언해야 해서 메모리를 많이 먹음
 */

public class MergeSort {

    static int[] sorted;

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 1, 6};
        int n = 5;
        sorted = new int[n];

        print(arr, n);

        mergeSort(arr, 0, n - 1);

        print(arr, n);
    }

    static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    static void merge(int[] arr, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int index = low;

        while (i <= mid && j <= high) {
            if (arr[i] < arr[j])
                sorted[index++] = arr[i++];
            else
                sorted[index++] = arr[j++];
        }

        while (i <= mid)
            sorted[index++] = arr[i++];

        while (j <= high)
            sorted[index++] = arr[j++];

        for (int k = low; k <= high; k++)
            arr[k] = sorted[k];
    }

    static void print(int[] arr, int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}