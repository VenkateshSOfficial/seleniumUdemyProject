package javaStreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Prac {
    public static void main(String[] args) {
        String[] names={"Kauhsik","deeepu","karthi","ranju","ashwini"};
        List<String> listOfNames = Arrays.asList(names);
        List<String> data = listOfNames.stream()
                .filter(s -> s.length() > 4)
                .map(s -> s.toUpperCase())
                .sorted((a, b) -> b.compareTo(a)).collect(Collectors.toList());
        /*for(String datum:data){
            System.out.println(datum);
        }*/
        System.out.println(data);
    }
}
