package basic.day2;

public class A08PreView {

    public static void main(String[] args) {
        

        char start = 'A'; 
        while (start <= 'Z') {
            
           System.out.print(start++);
           System.out.print(++start);
        }
        System.out.println();

        while (start > 'A') {
            System.out.print(--start);
            System.out.print(start--);
        }
    }
    
}
