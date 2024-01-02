package basic.day2;

import java.util.Locale;

public class HomeStringFormat {

    public static void main(String[] args) {

        int i = 23;

        System.out.println(String.format("%d_", i));
        System.out.println(String.format("%5d_", i));
        System.out.println(String.format("%-5d_", i));
        System.out.println(String.format("%05d_", i));

        String str = "tete";

        System.out.println(String.format("%s_", str));
        System.out.println(String.format("%12s_", str));
        System.out.println(String.format("%-12s_", str));
        System.out.println(String.format("%.2s_", str));
        System.out.println(String.format("%-12.2s_", str));
        System.out.println(String.format("%12.2s_", str));
  
        double n = 123.45678;

        System.out.println(3.4);
        System.out.println(n);
        System.out.println();

        System.out.println(String.format("%f_", 3.4));
        System.out.println(String.format("%f_", n));
        System.out.println(String.format("%.6f_", n));
        System.out.println(String.format("%15f_", n));
        System.out.println(String.format("%-15f_", n));
        System.out.println(String.format("%.3f_", n));
        System.out.println(String.format("%.2f_", n));
        System.out.println(String.format("%15.2f_", n));
        System.out.println(String.format("%-15.2f_", n));
        System.out.println(String.format("%015f_", n));
        System.out.println(String.format("%015.2f_", n));

        System.out.println("Unicode 코드 → 문자");
        System.out.println(String.format("48 → %c, 57 → %c", 48, 57));
        System.out.println(String.format("65 → %c, 90 → %c", 65, 90));
        System.out.println(String.format("97 → %c, 122 → %c", 97, 122));
        System.out.println(String.format("44032 → %c, 55203 → %c", 44032, 55203)); //  U+AC00, U+D7A3


        
    }
    
}
