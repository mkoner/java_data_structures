package sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array1 = new int[]{8, 0, 4, -1};
        sort(array1);
        print(array1);
    }
    public static void sort(int[] array){
        int size = array.length;
        for(int i=0; i < size-1; i++){
            int minIndex = i;

            for(int j=i+1; j<size; j++){
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            if(minIndex != i){
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }
    private static void print(int[] array){
        for(int num: array){
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
/*
-2 0 4 8 2

Time Complexity
 Best case (Already sorted): O(n^2)
 Worst case: O(n^2)
 Average case: O(n^2)
 */
