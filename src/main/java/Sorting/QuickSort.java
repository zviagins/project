package Sorting;

public class QuickSort {

    public static void quickSort(int[] arr){
        quickSort(arr, 0, arr.length-1);
    }

    /* low  --> Starting index,  high  --> Ending index */
    private static void quickSort(int[] arr, int low, int high){
        if (low < high) {
            //pi is partitioning index, arr[pi] is now at right place
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);  // Before pi
            quickSort(arr, pi + 1, high); // After pi
        }
    }

    /**
     *    This function takes last element as pivot, places
     *    the pivot element at its correct position in sorted
     *    array, and places all smaller (smaller than pivot)
     *    to left of pivot and all greater elements to right
     *    of pivot
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j=low; j<high-1; j++){
            if (arr[j] < pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap( arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


}
