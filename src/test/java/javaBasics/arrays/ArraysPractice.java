package javaBasics.arrays;

public class ArraysPractice {
    public static void main(String[] args) {
       /* below is one way ofdeclaring arrays
        int[] arr=new int[5];
        arr[0]=4;
        arr[1]=1;
        arr[2]=7;
        arr[3]=8;
        arr[4]=2;*/
/*
        System.out.println(arr[3]);
*/
        int[] numbers={2,6,9,3,0,3};
        String[] names={"kaushik","babbi","venkatesh"};

        /*System.out.println(numbers[6]);*/

        /*for(int num : numbers){
            System.out.print(num + ",");
        }*/

        for(int i=0;i<numbers.length;i++){
            System.out.println(numbers[i]);
        }
        for(String name:names){
            if(name.equalsIgnoreCase("kaushik")){
                System.out.println("The name is : "+ name);
            } else if (name.startsWith("b")) {
                System.out.println("The name is : "+ name);
            }
        }
    }
}
