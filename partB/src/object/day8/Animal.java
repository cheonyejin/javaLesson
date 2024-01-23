package object.day8;

public abstract class Animal {		// 추상화 추가
	public static final String TYPE ="동물";	//상수 기호 TYPE에 대한 문자열 지정 
	
	//필드: 공통적인 특성
	/*
	 * 	public 모두
		protected같은패키지 또는 자식클래스
		default 같은 패키
		private 지금 클래스
	 */

	
	protected String color;
	protected String name;    //동물 이름 예)마루
	
	/*
	 * 인스턴스 : =객체
		생성자 : 인스턴스가 생성될때 호출되는 인스턴스 초기화 메서드
		-기본 생성자 : 매개변수 없음, 내용 없음
		-커스텀 생성자 매개변수 있음, 리턴있음 
	 */
	//기본생성자--> 인스턴스가 생성될때마다 호출되는 초기화메서드.
	public Animal() {
		System.out.println("☆새로운 반려동물 가족이 생겼습니다.☆");
	}
	//커스텀생성자인데 기본생성자 메소드도 호출한다
	public Animal(String name,String color) {	//String name(2) 
		this();		//기본생성자 메소드 호출
		this.name=name;				           //this.name(1)=name(2) 	
		this.color=color;					   // : name(1)은 인스턴스이고 name(2)는 매개변수이다.
											   //   주로 이 둘은 똑같은 단어를 써서 this로 구분하는것이다.
	}
	/*
	추상메소드 :
	자식클래스들이 공통적으로 가져야할 기능이 있으면
		 부모에 추상메소드 선언(public abstract class 뭐뭐뭐). 
		 자식클래스들은 반드시 부모의추상메소드를 재정의 해야한다
	*/

	public abstract void sound();	//추상메소드는 실행코드는 없고 선안만한다 ->추상화
	
	// getter,
	public String getColor() {
		return this.color;
	}
	public String getName() {
		return name;
	}
	//   setter
	public void setColor(String color) {
		this.color = color;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override	//toString()는 java의 object클래스의 메소드 이므로 사용하기 위해선 재정의해야된다 
	public String toString() {
		return TYPE + " [color=" + color + ", name=" + name + "]";
			//this,TYPE은 안됨  
			//왜? this는 인스턴스 필드와 인스턴스 메소드에서만 
			// 따라서, 인스턴스메소드-this.인스턴스 , 재정의메소드-return

	}
}
	

	

