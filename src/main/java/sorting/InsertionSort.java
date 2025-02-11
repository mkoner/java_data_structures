package sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array1 = new int[]{12, 30, -3, 0, 2, -9};
        sort(array1);
        print(array1);
        int[] array2 = new int[]{1, 2, 3, 4};
        sort(array2);
        print(array2);
    }
    public static void sort(int[] array){
        int size = array.length;
        int j;
        for(int i=1; i<size; i++){
            j=i;
            while (j>0 && array[j] < array[j-1]){
                int temp = array[j];
                array[j] = array[j-1];
                array[j-1] = temp;
                j--;
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
  1 3 4 5

  1 2 3 4
*/
