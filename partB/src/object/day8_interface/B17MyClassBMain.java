package object.day8_interface;

public class B17MyClassBMain {
    public static void main(String[] args) {
        MyClassB myb = new MyClassB();

        InterfaceA ifa = new MyClassB();
        InterfaceX ifx = new MyClassB();
        //다중 구현 클래스는 두가지 업캐스팅이 가능합니다 

        myb.methodA();
        ifa.methodA();
        //ifx.methodA();      -> 오류 : methodA는 InterfaceA의 추상메소드이다. 그러므로 다른 *인터페이스(ifx)*는 메소드 실행 못함 

        //ifa.methodX();      -> 오류 : methodX는 InterfaceX의 추상메소드이다. 그러므로 다른 *인터페이스(ifa)*는 메소드 실행 못함 
        ifx.methodX();

        InterfaceX ix = (InterfaceX) ifa;  // A를 참조한 ifa를 X로 강제 캐스팅 -> 가능하다
        ix.methodX();
    }
}
