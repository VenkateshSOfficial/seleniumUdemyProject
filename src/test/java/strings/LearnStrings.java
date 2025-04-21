package strings;

public class LearnStrings {
    public static void main(String[] args) {
        /* What is String in java ?
        * String is an object which represents equence of characters in java
        *
        * What are te ways of declaring Strings in java ?
        * String literal
        * String object creation
        *
        * When new keyword is used Java is forced to create a new object even though the value is same
        * */

        /* String literal */
        String name="Venkatesh";
        /* String new object creation */
        String name1=new String("Venkatesh");
        String s="Hello welcome how are you";
        System.out.println("Trimmed value : "+ s.trim());
        String[] s1 = s.split(" ");
        for(String s2:s1){
            System.out.println(s2);
        }

    }
}
