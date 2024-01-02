package basic.day3;

import java.text.DecimalFormat;
import java.util.Scanner;


public class A20BankExam {

    public static void main(String[] args) {
        
        int menu; 
        int money; //입력
        int blance=0;  //잔액
        boolean run=true;
        Scanner sc = new Scanner(System.in);


        while (run) {

            System.out.println("-----------------------------------"); 
            System.out.println(" 1.예금 | 2.출금 | 3.잔액 | 4.종료   "); 
            System.out.println("-----------------------------------"); 
            System.out.print("메뉴 선택 >>> ");
            menu = sc.nextInt();
            DecimalFormat df = new DecimalFormat("#,###원"); // 세자리마다 컴마 찍기 
        


            switch (menu) {
                case 1:
                    System.out.print("예금액 >>> ");
                    money = sc.nextInt();
                    blance += money;
                    System.out.println("고객님의 잔액은 " + df.format(blance));
                    break;
                case 2:
                    System.out.print("출금액 >>> ");
                    money = sc.nextInt();
                    
                    if(money <= blance){
                        System.out.println("고객님의 잔액은 " + df.format(blance));
                        blance -= money;}
                        
                    else 
                        System.out.println("잔액이 부족합니다");

                    break;

                case 3:
                    System.out.println("현재 잔고 " + df.format(blance));
                    break;

                case 4:
                    run = false;
                    break;

                default:
                    System.out.println("잘못된 메뉴 선택값입니다 1~4만 입력하세요.");
                    break;
            }//swith
            
        }//while









    }//main


}//class
