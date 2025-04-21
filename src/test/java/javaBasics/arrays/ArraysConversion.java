package javaBasics.arrays;

import java.util.Arrays;
import java.util.List;

public class ArraysConversion {
    public static void main(String[] args) {
        String[] names={"babbi","kauhsik","venkatesh","dechu","karthi"};
        List<String> listOfNames = Arrays.asList(names);
        for(String name:listOfNames){
            System.out.println(name);
        }
    }
}
