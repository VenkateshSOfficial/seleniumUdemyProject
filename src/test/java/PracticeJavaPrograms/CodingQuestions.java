package PracticeJavaPrograms;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CodingQuestions {
    @Test(priority = 0)
    public void reverseSentance(){
        String sentance="hello how are you java";
        String[] s = sentance.split(" ");
        String reversed = Arrays.asList(s).stream().map(word -> new StringBuilder(word).reverse().toString()).collect(Collectors.joining(" "));
        System.out.println(reversed);
    }
    @Test(priority = 1)
    public void reverseWord(){
        String word="java";
        String reversed=new StringBuilder(word).reverse().toString();
        System.out.println(reversed);
    }
}
