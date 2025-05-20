package javaStreams;

import java.util.ArrayList;
import java.util.List;

public class SortedStreams {
    public static void main(String[] args) {
        List<String> allNames=new ArrayList<>();
        allNames.add("Anand");
        allNames.add("Ashuthosh");
        allNames.add("Don");
        allNames.add("Ganesh");
        allNames.add("Suresh");
        allNames.add("Zaheer");

        allNames.stream().
                filter(s->s.toLowerCase().startsWith("a")).
                sorted().map(s->s.toUpperCase()).
                forEach(System.out::println);
    }
}
