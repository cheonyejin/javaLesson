package object.day8_interface;

public class B16MyClassAMain {


    //Interface 
    //MyClassA
    public static void main(String[] args) {
        // InterfaceA ifa = new InterfaceA(); -> 오류 : 인터페이스로 객체는 생성 못한다 
        //                                              단, 익명내부 타입으로 정의는 가능
        
        //구현클래스로 객체 생성하기 
        MyClassA mya = new MyClassA();
        //업캐스팅 -가능
        InterfaceA ifa = new MyClassA();
        //다운캐스팅 - 가능하다 
        MyClassA temp = (MyClassA)ifa;
        System.out.println("참조타입 변수와 상관없이 똑같이 실행됩니다.");
        mya.methodA();
        ifa.methodA();

        };
    }
    

