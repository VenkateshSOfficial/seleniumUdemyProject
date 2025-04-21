package javaBasics.arrays;

import java.util.ArrayList;
import java.util.List;

public class PracticeArrayList {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("rahul");
        names.add("kaushik");
        names.add("babbi");
        names.add("deepu");
        names.add("karthi");
        names.add("sudharsan");

        for (String name : names) {
            System.out.println(name);
        }

        System.out.println("The last element is : " + names.get(names.size()-1));
    }
}
