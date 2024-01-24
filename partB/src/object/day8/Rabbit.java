package object.day8;

public class Rabbit extends Animal{
    
    public static final String TYPE = "토끼";

    //생성자 정의를 아예 안하면 -기본 생성자 그리고 자동으로 부모생성자 super() 호출합니다.
    //복습: 자식 객체가 생성될때, 먼저 부모객체를 생성하고 
    //      자식 인스턴스 요소가 추가됩니다. 이때, 부모생성자는 super()가 기본입니다 
    
    @Override
	public void sound() {
		System.out.println(this.color +" 토끼는 🐰🐰조용합니다. ");

	}

	@ Override
	public String toString() {
		return TYPE+"[color=" + color + ", name=" + name + "]";
	}
    
}