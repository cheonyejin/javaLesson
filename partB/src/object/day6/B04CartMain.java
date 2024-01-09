package object.day6;

import java.util.Arrays;
import java.util.Scanner;

public class B04CartMain {
    
    public static void main(String[] args) {
         CartClass momo =  new CartClass();

        //String, String[], int[] 필드는 초기값이 null

        String[] products = {"새우깡","칠성사이다","빅토리아","제주감귤","나주베","호빵","이클립스"};
        int[] prices = {3000,2500,9900,12000,9800,6000,1500};

        momo.setUserid("모모");
        momo.setProductName(products);
        momo.setPrices(prices);




        Scanner sc =  new Scanner(System.in);

        System.out.println("모모의 장바구니입니다");
        System.out.println(String.format("%s\t %s\t %s\t","번호","상품명","가격" ));

        for(int i = 0 ; i < momo.getProductName().length ; i++){        //gerProductName이야 조심해 
            System.out.println(String.format("%d\t %s\t %d\t",i, products[i],prices[i]));
        }

        System.out.println("구매할 상품을 선택하시오. 선택종료는 -1입니다.");
        // select는 저장공간 자체를 말한다 
        // k는 (그 저장공간의 각각 몇번방으로 가라)저장공간의 인덱스이다 
        // sel은 입력받은 값이다 
        int sel = 0;                //입력받은 값
        int[] select = new int[5]; //저장공간의 최대 크기(갯수)는 5개
        int k = 0;                 //저장공간의 인덱스

        while (sel != -1 && k < select.length) {  //길이는 5 인덱스는 01234 이므로 
            System.out.println("상품 번호 입력");
            sel = sc.nextInt();
            //sel의 선택범위는 productName 인덱스범위 안에서 선택하는 것이다 
            if(sel<-1 || sel > products.length-1){     //장바구니 이외의 숫자를 선택하면 잘못됏다고 알려줘야됨 
                                            //-1하는 이유는 인덱스가 0부터 시작이니깐 
                System.out.println("없는 상품입니다");
                continue; //아래있는 명령어 실행하지 않고 다시 반복문 시작으로 돌아간다
            } 
            select[k++]=sel;        //대입후에 ++ 해야됨 
        }

        if(k==select.length)
            System.out.println("장바구니를 모두 채우셨습니다");

        System.out.println("선택하신 번호는 : " + Arrays.toString(select));
        System.out.println("모모님이 선택하신 상품 합계 : " + momo.total_Money(select));

        momo.total_Money(select);  //setter메소드가 여기서는 필요없습니다 
                                                  //total_Money 메소드가 대신 값을 계산하여 저장할것입니다 . 
        
    }
    //필요에 따라서는 기존의 setter메소드는 사요하지 않고 추가적인 비지니스로직을 구현하는 메소드를 만듭니다.-> total money  
    
    
    
}
