package basic.day2;

public class A05PrefixPostfixTest {
	
	public static void main(String[] args) {
		
		int start =100;
		
		/* 증가 또는 감소연산자 (증감연산)는 다른 명령문과 같이 쓰일때 위치가 중요합니다.

		start++ ++start는 start = start+1
		start-- --start는 start = start-1

		*/

		System.out.println("== postfix 확인 (출력 후에 +1)==");
		System.out.println(start++);		//출력 후에 +1
		System.out.println(start++);		//출력 후에 +1
		System.out.println(start++);		//출력 후에 +1
		System.out.println(start++);		//출력 후에 +1

		System.out.println("== postfix 확인 (출력 후에 -1)==");
		System.out.println(start--);		//출력 후에 +1
		System.out.println(start--);		//출력 후에 +1
		System.out.println(start--);		//출력 후에 +1
		System.out.println(start--);		//출력 후에 +1

		start = 100;
		System.out.println("== prefix 확인 (+1 후에 출력) ==");
		System.out.println(++start);		// +1 후에 출력
		System.out.println(++start);
		System.out.println(++start);
		System.out.println(++start);
		
		System.out.println("== prefix 확인 (-1 후에 출력) ==");
		System.out.println(--start);
		System.out.println(--start);
		System.out.println(--start);
		System.out.println(--start);
		
	}

}
