package basic.day4;

import java.util.Scanner;

//for문 복습
public class A22ForReview {
    public static void main(String[] args) {
        
        int m;
        int n;
        int sum=0;
        int result=1;   //곱하기여서 초기값이 0이 아닌 1

        //1. 1부터 n까지 더하기 
        n=10;
        for(int i =1;i<=n;i++){
            sum += i;
        }
        System.out.println(String.format("1. 1부터 %d까지의 합계 : %,d", n, sum));
        System.out.println("1. 1부터 " + n + "까지의 합계 : " + sum);

        //2. 1부터 n까지 곱하기 
        n=10;                   //int는 -2147483648~2147483648 이후는 long
        //n=20으로  int에 저장하면 음수값이  나온다 (오버플러우)
        long longresult = 1;
        for(int i=1;i<=n;i++){
            result *= i;
            longresult *= i;
        }
        System.out.println(String.format("1. 1부터 %d까지의 곱 : %,d", n, result));
        System.out.println("1. 1부터 " + n + "까지의 곱 : " + result);


        //3. 시작값 m부터 n가지 더하기 
        m=5; n=8;
        sum=0;
        for(int i=m;i<=n;i++){
            sum +=i;
            System.out.println(String.format("3. %d부터 %d까지 더하기 : %d",m,n,result));

        }
   
        //4. 시작값 m부터 n가지 더하기 
        m=5;
        n=8;
        longresult=1;
        for(int i=m;i<=n;i++){
            longresult *= i;
            System.out.println(String.format("4. %d부터 %d까지 곱하기 : %d",m,n,longresult));

        }

        //5. 2의 n승 구하기 = 2를 n번 곱하기    
        n=5;
        longresult=1;
        for(int i=1;i<=n;i++){
            longresult *= 2;
            System.out.println(String.format("5. 2의 %d승 구하기 : %d",n,longresult));

        }
 
        //6. 구구단 출력 : for문 안에 for문
        //Scanner sc = new Scanner(System.in);
        //System.out.println("몇단");
        //int n = sc.nextInt();

        for(int i =2;i<=9;i++){

            System.out.println(String.format("%3d단",i));

            for(int j=1;j<=9;j++){  //
                System.out.println(String.format("%3d x %2d = %2d",i,j,i*j));


            }
        }




    }
    
}
