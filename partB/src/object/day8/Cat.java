package object.day8;

public class Cat extends Animal{

    public Cat() {
	}
	
	public Cat(String color) {
		super();                //생략할수있나요? - 생략 가능 super()은 자식 클래스 생성자에서 기본 호출됩니다
        this.color = color;		
	}
	
    @Override
	public void sound() {
		System.out.println(this.color +" 고양이는 야옹 🐱하고 소리를 냅니다. ");

	}

	@ Override
	public String toString() {
		return TYPE+"[color=" + color + ", name=" + name + "]";
    
    }


}
