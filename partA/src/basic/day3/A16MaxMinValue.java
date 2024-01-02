package basic.day3;

public class A16MaxMinValue {


    public static void main(String[] args) {
        
        int n1 = 5;
        int n2 = 6;
        int n3 = 7;
        int min;
        int max;

        if (n1 <n2) {
            min = n1 ;
            max = n2 ;
        }
        else {
            min = n2;
            max = n1;
        }

        if (min > n3) min = n3;
        //참 또는 거짓일때 실행하는 명령문이 1개이면 {}을 생략해도된다 
        
        if ( max < n3) {
            max = n3;
            
        }
        //이번엔 삼항연산식으로 표현해보기
        min = (n1 < n2 ? n1 : n2);
        min = (min < n3 ? n3 : min );
        
        max = (n1 > n2 ? n1 : n2);
        max = (max < n3 ? n3 : max );

        System.out.println(min);
        System.out.println(max);

    }
    
}
