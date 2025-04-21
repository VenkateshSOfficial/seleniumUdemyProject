package javaBasics.arrays;

public class ArraysExercise {
    public static void main(String[] args) {
        int[] arr={10,23,21,56,79};
        System.out.println("The first element is : " + arr[0]);
        System.out.println("The last element is : " + arr[arr.length-1]);
        for (int i=arr.length-1;i>=0;i--){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("The total count is : " + arr.length);
    }
}
