package basic.day2;

public class HomeStringFomatHJY {
    
   public static void main(String[] args) {
    
    int t = 100;
    System.out.println(String.format("10진수(%d) : 2진수(%s), 8진수(%o), 16진수(%x)", t, Integer.toBinaryString(t), t, t));

    
    
    int i = 23;
      //오른쪽 정렬이고, -를 붙일 경우 왼쪽정렬
    System.out.println(String.format("%d_", i));
    System.out.println(String.format("%5d_", i));  // %와 d 사이에 숫자를 넣어 글자 길이를 설정한다
    System.out.println(String.format("%-5d_", i));
    System.out.println(String.format("%05d_", i)); // i의 길이가 5보다 작을 경우 0을 붙인다 
    // %d 와 %-5d의 구분을 위해 맨 마지막에 _ 을 포함시켰습니다.
    i = 123456789;

    System.out.println(String.format("%,d_", i));  //% 바로 뒤에 , 를 붙이면 3자리 단위로 쉼표를 찍어줍니다.


    i = 123456789;

    System.out.println(String.format("%,d_", i));  //% 바로 뒤에 , 를 붙이면 3자리 단위로 쉼표를 찍어줍니다.
    System.out.println(String.format("%,15d_", i));
    System.out.println(String.format("%,-15d_", i));
    System.out.println(String.format("%,015d_", i));
    
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
   
   String str = "tete";

   System.out.println(String.format("%s_", str)); //%s는 문자열을 그대로 출력
   System.out.println(String.format("%12s_", str)); //%s 앞에 숫자(N)를 설정할 경우, str.length()가 N보다 작을 경우 공백을 추가
   System.out.println(String.format("%-12s_", str)); //-를 붙일 경우 왼쪽정렬
   System.out.println(String.format("%.2s_", str)); //.숫자(N)를 설정할 경우, 최대 N길이 만큼만 출력
   System.out.println(String.format("%-12.2s_", str));
   System.out.println(String.format("%12.2s_", str));


   









}


   
   


}
