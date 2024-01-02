package basic.day2;

public class A09HangulCharTest {

    public static void main(String[] args) {
        

        /*answk '나' '냿' 까지 while문으로 출력해라 
        변수는 char star='나'
         * 
         * 
         */

        char start = '나';
        char end = '냿';
        int codeNa;
        int codeNet;
    

        codeNet = start;   
        codeNa = end;     // char'냿'->int 는 자동 캐스팅이니까 그냥 쓰면돼

        while (start <= end) {

            start++;
            System.out.print(start);
            
        }
        System.out.println("\n");
        System.out.println(codeNa-codeNet+1 + "개");






    }
    
}
