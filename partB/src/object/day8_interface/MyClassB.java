package object.day8_interface;

//인터페이스를 다중(여러개)으로 사용하는 구현 클래스 연습입니다.

//결론 : 상속 extends는 단일 상속
//		구현 implements는 다중 구현
public class MyClassB implements InterfaceA , InterfaceX {	//인터페이스 여러개를 구현한다면?
		

	//InterfaceA : A,B,C,D
	//InterfaceX : X

	//InterfaceA의 추상메소드 구현
	@Override
	public void methodA() {
		System.out.println(" 여기는 MyClassB의 methodA입니다 ");
		
	}
	
	@Override
	public int methodB(int num) {
		return num*11;
	}
	
	//InterfaceX의 추상메소드 구현
	@Override
	public String methodX() {
		return "나는 테스트";
	}
}
