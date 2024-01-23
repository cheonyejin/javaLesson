package object.day8;
//animals[0] = new Puppy("푸들이","브라운");

public class Puppy extends Animal {
	/*
	 * 	extends는 일반 클래스와 abstract 클래스 상속에 사용되고, implement는 interface 상속에 사용된다.
		class가 class를 상속받을 땐 extends를 사용하고, interface가 interface를 상속 받을 땐 extends를 사용한다.
		class가 interface를 사용할 땐 implements를 써야하고
		interface가 class를 사용할 땐 implements를 쓸수 없다.
		extends는 클래스 한 개만 상속 받을 수 있다.
		extends 자신 클래스는 부모 클래스의 기능을 사용한다.
		implements는 여러개 사용 가능하다.
		implements는 설계 목적으로 구현 가능하다.
		implements한 클래스는 implements의 내용을 다 사용해야 한다.
	 */
	public static final String TYPE ="강아지 ";
	
	public Puppy() {
	}
	
	public Puppy(String name, String color) {
		super(name,color);				//부모 클래스 생성자 호출, 인자를 전달합니다.
	}
	
	
	@Override
	public void sound() {
		System.out.println(this.color +" 강아지는 멍멍 🐶🐶하고 짖습니다. ");

	}

	@ Override
	public String toString() {
		return TYPE+"[color=" + color + ", name=" + name + "]";
	} 
	//toString을 재정의 하지 않으면 부모 toString이 실행되고 부모의 TYPE 상수값 출력
	//static 필드 또는 메소드는 객체의 특징이 적용되지 않는다 

	
}
