package object.day8;

public class Member {
    
    //인스턴스 필드 만들기 
    private String name;
    private int age;

    //get
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    //set
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }

    /* 
    //기본생성자  : 
    public Member(){
        System.out.println("❤새로운 반려동물 가족이 생겼습니다.❤");
    }
    */  // 이거 이미 Animal클래스에서 만들었어 안만들어도 돼 

    //커스텀 생성자 
    public Member(int age , String name){
        this.age=age;
        this.name=name;
    }

	
    //비지니스 로직 : 강아지는 15세이상, 고양이는 18세이상, 
    //              토끼는 13세 이상 분양받을 수 있습니다.
    //boolean을 쓴 이유는 참, 거짓을 통해 if문을 써야되서 boolean이다.
    // A객체 instanceof B클래스 
    //    : A객체가 B클래스의 인스턴스 필드에 있는지 확인하는 것이다. 
    //          있으면 다음 if문이 실행된다.
    // *****Puppy 객체는  Animal 클래스의 인스턴스이기도 합니다

    // .getAge는 Member클래스에서 만든거잖아 
    // 그러니까 Animal클래스에서도 만들어줘야돼                             -> 이렇게 해도 결과가 나오는데 강사님은 isAdopt()에 getAge를 넣지 않는 쉬운방법으로 하셨다 
    // 그러고 자식 클래스들은 animal의 getAge()를 재정의해줘야돼                                                                강사님이 하신 방법을 기억하도록 하자.

    /* ((이건 강사님이 쓰신 필기))
     * 다형성 예시 : 메소드 인자가 부모타입일때 , 실제객체는 여러 자식객체가 될수있습니다. 
     * 실제객체는 실행할때 결정된다.
     * 
     * AND 연산(&&) : 모두 참이면 참
     * OR 연산(||) : 하나라도 참이면 참 
     */
    public boolean isAdopt(Animal animal) {
        if (animal instanceof Puppy && age >= 15) {            // 강아지는 15세 이상이면 분양 가능
            return true;
        } else if (animal instanceof Cat && age >= 18) {      // 고양이는 18세 이상이면 분양 가능
            return true;
        } else if (animal instanceof Rabbit&& age >= 13) {   // 토끼는 13세 이상이면 분양 가능
            return true;
            } else {                             // 다른 동물은 분양 불가능
                return false;
        }
    }

}
