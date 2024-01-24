package object.day8_interface;

//인터페이스 형식 알아보는 연습 
/*
 * 인터페이스는 규칙입니다 . 상속과는 다른 개념이라고 생각하세요 
 * 핵심은 추상메소드를 규칙으로 정의하는 것입니다.
 * ㄴ인터페이스는 직접 객체를 생성하지 않습니다.
 * ㄴ클래스가 인터페이스를 가져다가 규칙을 적용하도록 합니다 => 인터이스 구현 implement 
 */

public interface InterfaceA {
	//생성자는 없습니다. -> 직접 객체를 생성하지 않습니다.
	//필드는 상수만 가능
	//public static final 생략함. -> 규칙을 정의할때 필요한 상수값 선언.
	int SIZE = 100;
	
	/* 인터페이스 구성- 아래 4가지만 포함될수있습니다 .아래요소들은 모두 public abstract 생략함.
	 *1) 추상 메소드  : A , B 
      2) 인스턴스메소드  (default) : C
	  3) static메소드  : D
	  4) 상수
	 */

	//public abstract 생략함. 
	//1)추상 메소드-선언만함 매개변수,리턴없음
	void methodA();
	int methodB(int num);
	
	//public생략
    //2) 인스턴스메소드(default 매소드) : default : default 제한자 의미가 아니고 인스턴스 메소드 의미
	default void methodC(String message) {
		System.out.println("메시지 수신 : " + message);
	}
	
	//3)static메소드 
	static void medthodD() {
		System.out.println("나는 static 메소드입니다.");
	}
	
}
