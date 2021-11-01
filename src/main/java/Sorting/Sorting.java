package Sorting;

/**
 * Sorting Algorithms:
 *
 * Simple
 *      Insertion sort is a simple sorting algorithm that is relatively efficient for small lists and mostly sorted lists, and is often used as part of more sophisticated algorithms.
 *      It works by taking elements from the list one by one and inserting them in their correct position into a new sorted list.
 *         i ← 1
 *         while i < length(A)
 *             j ← i
 *             while j > 0 and A[j-1] > A[j]
 *                 swap A[j] and A[j-1]
 *                 j ← j - 1
 *             end while
 *             i ← i + 1
 *         end while
 *
 *      average - n^2 worst - n^2 memory - 1
 *
 *
 *      Selection sort is an in-place comparison sort. It has O(n^2) complexity, making it inefficient on large lists, and generally performs worse than the similar insertion sort.
 *      The algorithm finds the minimum value, swaps it with the value in the first position, and repeats these steps for the remainder of the list.
 *      It does no more than n swaps, and thus is useful where swapping is very expensive.
 *         int i,j;
 *         int aLength;
 *         for (i = 0; i < aLength-1; i++)
 *         {
 *             int jMin = i;
 *             for (j = i+1; j < aLength; j++)
 *             {
 *                 if (a[j] < a[jMin])
 *                 {
 *                     jMin = j;
 *                 }
 *             }
 *             if (jMin != i)
 *             {
 *                 swap(a[i], a[jMin]);
 *             }
 *         }
 *
 *      average - n^2 worst - n^2 memory - 1
 *
 *
 *      Optimizing bubble sort. The bubble sort algorithm can be optimized by observing that the n-th pass finds the n-th largest element and puts it into its final place.
 *      So, the inner loop can avoid looking at the last n − 1 items when running for the n-th time:
 *          procedure bubbleSort(A : list of sortable items)
 *             n := length(A)
 *             repeat
 *                 swapped := false
 *                 for i := 1 to n - 1 inclusive do
 *                     if A[i - 1] > A[i] then
 *                         swap(A[i - 1], A[i])
 *                         swapped := true
 *                     end if
 *                 end for
 *                 n := n - 1
 *             until not swapped
 *         end procedure
 *
 *      average - n^2 worst - n^2 memory - 1
 *
 * A comparison sort cannot perform better than O(n log n) on average:
 *
 *      Quicksort is a divide-and-conquer algorithm. It works by selecting a 'pivot' element from the array and partitioning the other elements into two sub-arrays,
 *      according to whether they are less than or greater than the pivot. For this reason, it is sometimes called partition-exchange sort.
 *      The sub-arrays are then sorted recursively. This can be done in-place, requiring small additional amounts of memory to perform the sorting.
 *      average - nlogn; worst - n^2; memory - logn
 *
 *
 *      Mergesort works as follows:
 *          Divide the unsorted list into n sublists, each containing one element (a list of one element is considered sorted).
 *          Repeatedly merge sublists to produce new sorted sublists until there is only one sublist remaining. This will be the sorted list.
 *      average - nlogn; worst - nlogn; memory - n
 *
 *
 *      HeapSort can be thought of as an improved selection sort: like selection sort,
 *      heapsort divides its input into a sorted and an unsorted region, and it iteratively shrinks the unsorted region by extracting the largest element from it and
 *      inserting it into the sorted region. Unlike selection sort, heapsort does not waste time with a linear-time scan of the unsorted region; rather,
 *      heap sort maintains the unsorted region in a heap data structure to more quickly find the largest element in each step.
 *      average - nlogn; worst - nlogn; memory - 1
 */



public class Sorting {

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver code
    public static void main(String args[])
    {
        int arr[] = { 12, 11, 13, 5, 6, 7 };

        HeapSort.HeapSort(arr);

        System.out.println("HeapSort");
        printArray(arr);

        arr = new int[]{ 12, 11, 13, 5, 6, 7 };

        QuickSort.quickSort(arr);

        System.out.println("QuickSort");
        printArray(arr);
    }

}
