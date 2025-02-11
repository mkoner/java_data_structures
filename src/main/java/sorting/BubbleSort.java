package sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array1 = new int[]{12, 7, 0, -3};
        sort(array1);
        printArray(array1);
        int[] array2 = new int[]{12, 15, 18, 23};
        sort(array2);
        printArray(array2);
    }
    public static void sort(int[] array){
        int size = array.length;
        boolean swapped;
        for(int i=0; i < size - 1; i++){
            swapped = false;
            for(int j=0; j < size - i - 1; j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) break;
        }
    }
    private static void printArray(int[] array){
        for(int num: array){
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

/*
Best Case (Already Sorted): O(n)
Worst Case (Reverse Sorted): O(n^2 )
Average Case:O(n^2 )
*/
