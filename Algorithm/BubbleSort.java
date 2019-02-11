
/**
 * 버블 정렬
 * 시간복잡도는 O(N^2)
 */

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 1};
        int n = 4;

        print(arr, n);
        fastBubbleSort(arr, n);
        print(arr, n);
    }

    static void bubbleSort(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 이미 정렬이 완료되었으면 더 볼 필요 없으므로 change 변수 사용
     * for i 문 한번 돌 때마다 마지막 원소는 볼 필요 없으므로 j 의 범위를 n-1-i 까지 봄
     */
    static void fastBubbleSort(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            boolean change = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    change = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            if (change == false)
                return;
        }
    }

    static void print(int[] arr, int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}