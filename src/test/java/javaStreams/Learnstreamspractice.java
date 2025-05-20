package javaStreams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Learnstreamspractice {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 3, 4, 3, 2, 5, 6, 5, 7, 8, 9, 8, 7, 5);
        nums.stream().distinct().sorted((x,y)->y.compareTo(x)).forEach(s-> System.out.println(s));
    }
}
