package sorting;

public class MergeSort {
    public static void main(String[] args) {
        System.out.println("Hellloooo");
        int[] array1 = {12, 7, 9, 90};
        int[] array2 = {2, 4, 6, 8};
        int[] array3 = {1, 1, 1, 1};
        int[] array4 = {27, 40, 6, 2};
        mergeSort(array1);
        mergeSort(array2);
        mergeSort(array3);
        mergeSort(array4);

        System.out.println("After merge sort : ");
        printArray(array1);
        System.out.println();
        printArray(array2);
        System.out.println();
        printArray(array3);
        System.out.println();
        printArray(array4);

    }
    public static void mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }
    private static void printArray(int[] array) {
        for (int j : array) {
            System.out.print(j + " ");
        }
    }
    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int leftArraySize = mid - left +1;
        int rightArraySize = right - mid;
        int[] leftArray = new int[leftArraySize];
        int[] rightArray = new int[rightArraySize];
        for(int i = 0; i < leftArraySize; i++){
            leftArray[i] = arr[left + i];
        }
        for(int j = 0; j < rightArraySize; j++){
            rightArray[j] = arr[mid + 1 + j];
        }
        int i = 0, j = 0, k = left;
        while(i < leftArraySize && j < rightArraySize) {
            if(leftArray[i] < rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            }
            else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while(i < leftArraySize) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        while(j < rightArraySize) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
