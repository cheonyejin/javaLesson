package basic.day1;

public class ProbChangeMoney {
    
    public static void main(String[] args) {

        int myWon=1000000; //(백만원)
        double toYen;

        int cost;
        int myYen;
        double toWon;
        
        double yenToWonRate=9.29;
        double wonToTenRate=8.97;

        System.out.println(":::한/일 23.12.28 기준 환율:::");
        System.out.println("살 때 1엔 = " + yenToWonRate + "원");
        System.out.println("팔 때 1엔 = "+ wonToTenRate + "원");


        System.out.println("::: 원화를 엔화로 환전하기 :::"); 
        System.out.println("환전할 원화는 " + myWon + "원입니다.");
        System.out.println("원화를 엔화로 바꿀 때 : " +(myWon/yenToWonRate)+ "엔 입니다");

        cost = 98760;
        myYen = (int) (myWon/yenToWonRate)-cost;
        toWon = myYen*wonToTenRate;


        System.out.println("::: 엔화를 원화로 환전할 경우 :::");
        System.out.println("일본에서 사용한 금액은 " + cost +"엔입니다.");
        System.out.println("남은 엔화는 얼마인가요? " + (myYen) +  "엔");
        System.out.println("엔화를 원화로 바꿀 때 : " + toWon+ "원");

        /*
        자료형의 크기 : byte 1 < char 2  < short 2  < int 4  < long 8  < float 4  < double 8 
        char믄자형을 코드값 구하기 위해 정수로 캐스팅할때는 0~65535를 충분히 저장할수있는 int정수형으로 캐스팅한다  
        
        
        
        */ 

    }
}
