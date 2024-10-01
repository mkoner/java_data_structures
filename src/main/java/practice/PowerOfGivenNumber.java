package practice;

/*
Given an array of integers and a number n find how many numbers in the array
are power of n
 */

public class PowerOfGivenNumber {

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 8, 16, 32}; // n=2 out:5
        int[] array2 = {1, 5, 25, 125, 625, 7, 10}; // n=5 out:5
        int[] array3 = {32, 64, 128, 256, 512, 1024}; // n=4 out:0
        System.out.println(numOfPower(array1, 2));
        System.out.println(numOfPower(array2, 5));
        System.out.println(numOfPower(array3, 4));
    }

    private static int numOfPower(int[] array, int n) {
        int count = 0;
        for(int i: array) {
            if(isPower(i, n))
                count++;
        }
        return count;
    }

    private static boolean isPower(int num, int n) {
        while(num > 0) {
            if(num == 1) return true;
            if(num % n != 0) return false;
            num = num/n;
        }
        return true;
    }
}
