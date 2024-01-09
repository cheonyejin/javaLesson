package object.day8_interface;

//인터페이스 InterfaceA를 사용하는 구현 클래스 
// -> InterfaceA 의 추상메소드는 반드시 구현해야한다.
// -> 인터페이스의 구현 클래스가 객체로 생성된다.

public class MyClassA implements InterfaceA {	//implements : 클래스가 특정 인터페이스를 구현한다는 것을 나타낸다


	//구현하는 인터페이스의 (추상)메소드는 반드시 구현해야된다
	// 오버라이드는 상속에서 사용 
	// 인터페이스에서는 구현이라고 사용
	
	/*InterfaceA에서는 아래의 4개의 메소드를 정의했다 
	 * 1) 추상 메소드  : A , B			-> 오버라이드(재정의)
      2) 인스턴스메소드  (default) : C
	  3) static메소드  : D				-> 메소드 이름이 같아도  오버라이드하지 않고 별도로 정의가능하다.
	 */

	@Override			
	public void methodA() {
		System.out.println("나는 methodA !!");
	}
	
	@Override
	public int methodB(int num) {
		System.out.println("나는 methodB !! " + num);
			return num;
	}
	
	
	//InterfaceA 의 static 메소드를 별도로 정의할 수 있습니다.
	//이름이 같아도 override 로 처리하지 않습니다.

	public static void medthodD() {
		System.out.println("MyClassA methodD~~~");
	}
}
