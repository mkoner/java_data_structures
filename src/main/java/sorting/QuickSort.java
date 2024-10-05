package sorting;

public class QuickSort {
    public static void main(String[] args) {
        int[] array1 = {12, 7, 9, 90};
        int[] array2 = {2, 4, 6, 8};
        int[] array3 = {1, 1, 1, 1};
        int[] array4 = {27, 40, 6, 2};
        quickSort(array1);
        quickSort(array2);
        quickSort(array3);
        quickSort(array4);

        System.out.println("After merge sort : ");
        printArray(array1);
        System.out.println();
        printArray(array2);
        System.out.println();
        printArray(array3);
        System.out.println();
        printArray(array4);
    }

    public static void quickSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left -1;
        for (int j = left; j < right; j++) {
            if(arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[right] = arr[i+1];
        arr[i+1] = pivot;
        return i+1;
    }
    private static void printArray(int[] array) {
        for (int j : array) {
            System.out.print(j + " ");
        }
    }
}
