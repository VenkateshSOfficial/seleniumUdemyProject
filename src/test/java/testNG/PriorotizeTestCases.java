package testNG;

import org.testng.annotations.Test;

public class PriorotizeTestCases {
    @Test(priority = 2)
    public void execute1(){
        System.out.println("execute 1");
    }
    @Test(priority = 1)
    public void execute2(){
        System.out.println("execute 2");
    }
    @Test(priority = 0)
    public void execute3(){
        System.out.println("execute 3");
    }
}
