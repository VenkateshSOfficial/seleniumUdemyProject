package javaStreams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PracticeFilter {
    public static void main(String[] args) {
        List<String> allNames=new ArrayList<>();
        allNames.add("Anand");
        allNames.add("Ashuthosh");
        allNames.add("Don");
        allNames.add("Ganesh");
        allNames.add("Suresh");
        allNames.add("Zaheer");
        Stream<String> names = Stream.of("Anand", "Ashuthosh", "Don", "Ganesh", "Suresh", "Zaheer");
        long count = names.filter(s -> s.toLowerCase().startsWith("b")).count();
        System.out.println(count);
        Stream<String> name=Stream.of("Anand", "Ashuthosh", "Don", "Ganesh", "Suresh", "Zaheer");
        name.filter(s -> s.length()>5).forEach(System.out::println);

        allNames.stream().filter(s->s.length()>5).limit(1).forEach(System.out::println);

    }
}
