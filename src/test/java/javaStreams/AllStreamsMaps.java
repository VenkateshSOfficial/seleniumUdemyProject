package javaStreams;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class AllStreamsMaps {
    @Test
    public void filterData(){
        Map<Integer,String> employeeDetails=new HashMap<>();
        employeeDetails.put(10023,"Venkatesh");
        employeeDetails.put(12309,"Kaushik");
        employeeDetails.put(34098,"Babbi");
        employeeDetails.put(56098,"Deepu");
        employeeDetails.put(10987,"Karthi");
        employeeDetails.put(87906,"Ranjani");

        employeeDetails.entrySet()
                .stream()
                .filter(entry->entry.getValue().toLowerCase().startsWith("k"))
                .map(val->val.getValue())
                .sorted()
                .forEach(System.out::println);

    }

}
