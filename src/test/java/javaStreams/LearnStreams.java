package javaStreams;

import java.util.ArrayList;
import java.util.List;

public class LearnStreams {
    public static void main(String[] args) {
        List<String>names=new ArrayList<>();
        names.add("Anand");
        names.add("Ashuthosh");
        names.add("Don");
        names.add("Ganesh");
        names.add("Suresh");
        names.add("Zaheer");
        for(String name:names){
            if(name.toLowerCase().startsWith("a")){
                System.out.println(name);

            }
        }
    }
}
