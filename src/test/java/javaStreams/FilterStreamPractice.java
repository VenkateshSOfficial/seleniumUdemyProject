package javaStreams;

import java.util.ArrayList;
import java.util.List;

public class FilterStreamPractice {
    public static void main(String[] args) {
        List<String> names=new ArrayList<>();
        names.add("Anand");
        names.add("Ashuthosh");
        names.add("Don");
        names.add("Ganesh");
        names.add("Suresh");
        names.add("Zaheer");
        long c = names.stream().filter(s -> s.toLowerCase().startsWith("a")).count();
        System.out.println(c);

    }
}
