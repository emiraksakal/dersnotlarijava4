/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ozay
 */
public class QuickSort {

    public static void main(String[] args) {
        testQuickSort();
    }

    // abstraction of  less than <
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // swap
    private static void swap(Comparable[] a, int i, int j) {
        if (i == j) {
            return;
        }
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void swapInt(int[] a, int i, int j) {
        if (i == j) {
            return;
        }
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void print(Comparable[] ar) {
        System.out.print("Array: ");
        for (Comparable e : ar) {
            System.out.print(e.toString() + ", ");
        }
        System.out.println(".");
    }

    public static void printInt(int[] ar) {
        System.out.print("Array: ");
        for (int e : ar) {
            System.out.print(e + ", ");
        }
        System.out.println("..");
    }

    public static void testQuickSort() {
        Integer[] a2 = {4, 7, 2, 67, 8, 2, 1, 0, -4};
        System.out.println("Testing Quick Sort Comparable");
        print(a2);
        sort(a2);
        print(a2);

        /* int[] a3 = {4, 7, 2, 67, 8, 2, 1, 0, -4};
        System.out.println("Testing Quick Sort Int");
        printInt(a3);
        sortInt(a3);
        printInt(a3);

        int[] a4 = {1, 4, 67, 88, 102, 400};
        System.out.println("Testing Quick Sort Int");
        printInt(a4);
        sortInt(a4);
        printInt(a4);*/
    }

    public static void sort(Comparable[] a) {
        // shuffle /
        sort(a, 0, a.length - 1);
    }

    public static void sortInt(int[] a) {
        // shuffle /
        sortInt(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] arr, int low, int high) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    private static void sortInt(int[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partitionInt2(a, lo, hi); // partition and get pivot
        sortInt(a, lo, j - 1); // sort level of pivot j
        sortInt(a, j + 1, hi); // sort right of pivot j
    }

    private static int partitionInt(int[] a, int lo, int hi) {

        int piv = a[lo];
        int i = lo + 1;
        int j = hi;

        while (i <= j) {
            while (i <= j && a[i] <= piv) {
                i++;
            }
            while (i <= j && a[j] >= piv) {
                j--;
            }
            if (i < j) {
                swapInt(a, i, j);
                //printInt(a);
            }
        }
        swapInt(a, lo, j);
        printInt(a);
        return j;
    }

    private static int partitionInt2(int[] a, int lo, int hi) {
        int piv = a[lo];
        int i = lo;
        int j = hi;

        while (i < j) {
            if (piv > a[j]) {
                swapInt(a, i, j);
                System.out.print("Swap:" + i + ", " + j + " ");
                printInt(a);
                break;
            }
            j--;
        }

        return i;

    }

    public static int partition(Comparable[] arr, int low, int high) {
        Comparable pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (less(arr[j], pivot)) {
                i++;
                swap(arr, i, j);
                // swap arr[i] and arr[j]
            }
        }
        // swap arr[i+1] and arr[high] (or pivot)
        swap(arr, i + 1, high);
        return i + 1;
    }

}
