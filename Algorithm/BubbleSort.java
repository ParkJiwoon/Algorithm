
/**
 * 버블 정렬
 * 시간복잡도는 O(N^2)
 */

 public class BubbleSort {
     public static void main(String[] args) {
         int[] arr = {3, 4, 2, 1};
         int n = 4;

         print(arr, n);
         bubbleSort(arr, n);
         print(arr, n);
     }

     static void bubbleSort(int[] arr, int n) {
         for(int i=0; i<n; i++) {
             for(int j=0; j<n-1; j++) {
                 if(arr[j] > arr[j+1]) {
                     int temp = arr[j];
                     arr[j] = arr[j+1];
                     arr[j+1] = temp;
                 }
             }
         }
     }

     static void print(int[] arr, int n) {
         for(int i=0; i<n; i++)
             System.out.print(arr[i] + " ");
         System.out.println();
     }
 }