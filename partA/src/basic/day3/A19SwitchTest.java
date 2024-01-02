package basic.day3;

import java.util.Scanner;  //키보드 입력을 위한 클래스 

//switch 는 if 조건식이 equal (==) 을 여러번 검사하는 경우에 사용.
//		   조건식에서 검사하는 값은 정수(byte,short,int,long), char, 문자열 형식만 가능합니다.
public class A19SwitchTest {

	public static void main(String[] args) {

		
		int menu =1;
		
		Scanner sc = new Scanner(System.in); // system.in은 표준입력
		//키보드 입력 : 진도와 상관없이 방법만 알고 써보겠습니다 
	
		//	break는 밑에 있는 명령어로 넘어간다
		boolean run =true;			//run 이라는 변수가 참인동안 
		while (run) {				//while문이 진행되도록
				
			System.out.println(":::: 쇼핑몰 사용자 마이페이지 ::::");
			System.out.println("1:장바구니   2:찜 상품   3.배송 조회   4.구매 목록  5.종료");
			System.out.print("선택 하세요. >>>> ");
			menu = sc.nextInt(); // 키보드 입력을 위한 커서가 보이면 여러분들이 값을 입력해주세요

			switch (menu) {
				case 1:    //menu==1 ?
					System.out.println("장바구니 🎁🎁🎁🎁 .많이 담아 주세요.");
					break;	   //아래의 명령어들을 실행하지 않고 switch{ .. } 를 끝냅니다.
				case 2:   //menu==2 ?
					System.out.println("찜 상품 입니다.❤❤");
					break;
				case 3:   //menu==3 ?
					System.out.println("배송 조회 🚚🚛🚚🚛 ");
					break;
				case 4:   //menu==4 ?
					System.out.println("구매 목록 입니다.");
					break;
				case 5:   //menu==5 ?
					System.out.println("종료 입니다.");
					run = false; // 5번을 입력하면 종료되도록한다 
					break;
				default:   //값이 1,2,3,4,5 모두 아닌경우
					System.out.println("잘못된 선택 입니다.");
					break;
			}   //switch 끝}
		
	} //while 끝
	System.out.println("프로그램이 종료됩니다");
} //main end

}//class