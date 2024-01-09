package object.day5;

public class MyClass1 {


	//main없는 클래스 
	
	//이 클래스는 객체를 생성할 때 사용할 원본(정의) 역할을 하는 클래스입니다. 
	//구성요소 : 필드(클래스의 특성을 나타내는 값), 메소드
	
	//필드 선언
	String field1;
	int field2;
	
    //배열은 참조타입이므로 참조타입 field3변수만 선언한 상태입니다.
    //배열도 객체입니다. 아직 객체는 생성이 안됬습니다.
	double[] field3;   
	//초기값은 null
	
	//클래스 안에서 선언된 변수는 **전역변수(사용범위)
	//전역변수의 초기화 안해도 기본값이 저장됩니다.
	//       ㄴ참조형 타입은 null,수치 기본형 타입은 0  
	
	//상수: 값을 바꿀수 없는 상태의 데이터 (리터럴 상수, 기호상수)
	//final : 값을 변경할 수없다.반드시 초기화한다.
	//final int field4=999;     
	
	//*상수는 모든 객체가 같은 값이므로 공유영역에 저장하고
	//*클래스 이름으로 접근한다. 식별자를 대문자로 한다. 
	//*클래스의 성질을 나타내는 고정된(고유한) 값.
	//static : 클래스의 고유한 특성. 클래스 이름으로 접근한다.
	static int field5;  //값을 변경할수 있다.
	
	static final int FIELD4=999;
	//final : 변경할 수 없는 변수
	//staitc final : 상수라고 합니다.
	
}
