package object.day8;

public abstract class Animal {		// 추상화 추가
	public static final String TYPE ="동물";	//상수 기호 TYPE에 대한 문자열 지정 
	
	//필드: 공통적인 특성
	//protected로 선언했다/
	protected String color;
	protected String name;    //동물 이름 예)마루
	
	//생성자
	public Animal() {
		System.out.println("☆새로운 반려동물 가족이 생겼습니다.☆");
	}
	//커스텀생성자인데 기본생성자 메소드도 호출한다
	public Animal(String name,String color) {
		this();		//기본생성자 메소드 호출
		this.name=name;
		this.color=color;
	}
	
	/*
	추상메소드: 자식 클래스 들이 공통적으로 가져야할 기능
				자식 클래스들이 반드시 재정의 하도록 강요.
				추상메소드가 있는 클래스는 반드시 abstract을 서줘야 한다.
				추상메소드는 코드가 없다= 실행내용이 없다 => 선언만한다 (추상화)(아래의 코드와 같이)
				자식은 부모가 추상화시킨 클래스를 실체화한다 			
				* 부모 클래스로는 객체 생성 못함
				
	*/
	public abstract void sound();
	
	
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


	@Override
	public String toString() {
		return TYPE + " [color=" + color + ", name=" + name + "]";
			//this,TYPE은 안됨  왜? this는 인스턴스 필드와 인스턴스 메소드에서만 

	}

}
	

	

