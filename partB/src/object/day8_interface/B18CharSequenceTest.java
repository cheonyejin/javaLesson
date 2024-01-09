package object.day8_interface;
// CharSequence는 자바에서 만든 이미 있는 인터페이스 입니다 
// 작동을 한번 봅시다 
public class B18CharSequenceTest {

    public static void main(String[] args) {
        CharSequence csstr = new String("Hello World");
        CharSequence cssb = new String("Hi Java");
        
        String temp  = "자바 Hello~ Hi Java";
        System.out.println("charsequence타입을 인자로 하는 메소드 확인 ");
        System.out.println("contains()는 temp객체에 csstr문자열이 포함되어있는지 확인하는 메소드이다.");
        System.out.println(temp.contains(csstr));   //false
        System.out.println(temp.contains(cssb));    //true  : "Hi Java"포함하고 있어서 
        System.out.println(temp.contains("Hello")); //true
        //결론 :  메소드 인자가 인터페이스 타입일때에는 여러가지 구현클래스가 인자로 전달될수있다/.
    
    
    
    }

    
}
