package javaStreams;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AllStreams {
    String[] names={"Kaushik","Venkatesh","Babbi","Karthi"};

    @Test(priority = 0)
    public void filterData(){
        /* here we are using filter method
        *  filter() method is one of the intermediate actions which filter the data
        */
        Arrays.asList(names)
                .stream()
                .filter(name->name
                        .toLowerCase()
                        .startsWith("k"))
                .forEach(System.out::println);
    }
    @Test(priority = 1)
    public void sortData(){
        /* here we are using sort method
        * sort() method is used to sort the list either ascending or descending order
        * we can use the below methods to sort in descending order
        *  1 : Comparator.reverseOrder()
        *  2 : (x,y)-> y.compareTo(x)
        *  To sort in ascending order just use sorted() which by default will sort in ascending order*/
        System.out.println("====================================================================");
        Arrays.asList(names)
                .stream().sorted(Comparator.reverseOrder()).forEach(s-> System.out.println(s));

        System.out.println("====================================================================");

        List<String> namesList = Arrays.asList(names)
                .stream().sorted((x, y) -> y.compareTo(x)).collect(Collectors.toList());
        System.out.println(namesList);

        System.out.println("====================================================================");

        Arrays.asList(names).stream().sorted().forEach(System.out::println);
    }
    @Test(priority = 2)
    /* map is used to convert from one form to another form */
    public void mapData(){
        System.out.println("====================================================================");
        Arrays.asList(names).stream().map(s->s.toUpperCase()).forEach(System.out::println);

        System.out.println("====================================================================");
        List<Integer> length = Arrays.asList(names).stream().map(s -> s.length()).collect(Collectors.toList());
        System.out.println(length);
    }
    @Test(priority = 3)
    public void countData(){
        /* the count() method to fetch the count value in a list */
        System.out.println("====================================================================");
        long count = Arrays.asList(names).stream().count();
        System.out.println("Total names in the list are : " + count);
    }
    @Test
    public void skipAndLimitData(){
        /* skip() will skip all the number of data enter in it */
        System.out.println("============================== skip data ===============================");
        Arrays.asList(names).stream().skip(2).forEach(System.out::println);

        /* limit() will print only the number of data that are entered as parameters*/
        System.out.println("============================== limit data ===============================");
        Arrays.asList(names).stream().limit(2).forEach(System.out::println);
    }
    @Test
    public void removeDuplicateData(){
        /* distinct() will remove the duplicates from the given list */
        System.out.println("============================== removed duplicate values ===============================");
        String[] names={"Kaushik","Kaushik","Venkatesh","Venkatesh","Babbi","Karthi","Karthi"};
        Arrays.asList(names).stream().distinct().sorted((x,y)->y.compareTo(x)).forEach(System.out::println);
    }
}
